package no.cantara.observer.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by baardl on 24.07.17.
 */
public class AWSClientIPObserver extends ClientIPObserver {

    public static final String CLIENT_IP_HEADER = "X-Forwarded-For" ;

    @Override
    public String findClientIp(HttpServletRequest request) {
        //Look for X-Forwarded-For: client-ip-address
        String ip = request.getHeader(CLIENT_IP_HEADER);

        return ip;
    }
}
