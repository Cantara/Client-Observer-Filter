package no.cantara.observer.filter;

import org.slf4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Servlet filter to be included in your servlet container.
 * Created by baardl on 25.07.17.
 */
public class ClientObserverFilter implements Filter {
    private static final Logger log = getLogger(ClientObserverFilter.class);
    private static final Logger filterLog = getLogger("ClientObserverFilter");
    private AWSClientIPObserver awsClientIPObserver;
    private ClientIPObserver clientIPObserver;
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("ClientObserverFilter:INIT");
        filterLog.info("ClientObserverFilter:INIT");
        awsClientIPObserver = new AWSClientIPObserver();
        clientIPObserver = new ClientIPObserver();

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            String forwardedClientIp = awsClientIPObserver.findClientIp((HttpServletRequest) servletRequest);
            String clientIp = clientIPObserver.findClientIp((HttpServletRequest) servletRequest);
            filterLog.info("Client Request from {}. Forwarded from {}", clientIp, forwardedClientIp);
        } else {
            log.trace("Request is not HttpServletRequest.");
        }
        filterChain.doFilter(servletRequest, servletResponse);


    }

    public void destroy() {
        log.info("ClientObserverFilter:DESTROY");
    }
}
