package no.cantara.observer.filter;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Detect which IP the client is calling from.
 * Created by baardl on 24.07.17.
 */
public class ClientIPObserver {

    public String findClientIp(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return ip;
    }
}
