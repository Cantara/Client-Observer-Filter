package no.cantara.observer.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static no.cantara.observer.filter.AWSClientIPObserver.CLIENT_IP_HEADER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by baardl on 25.07.17.
 */
class AWSClientIPObserverTest {

    private HttpServletRequest request;
    @BeforeEach
    void setUp() {
        request = mock(HttpServletRequest.class);
    }

    @Test
    void findClientIp() {
        String expectedIp = "192.168.0.5";
        when(request.getHeader(CLIENT_IP_HEADER)).thenReturn(expectedIp);
        ClientIPObserver clientIPObserver = new AWSClientIPObserver();
        assertEquals(expectedIp,clientIPObserver.findClientIp(request));

    }

}