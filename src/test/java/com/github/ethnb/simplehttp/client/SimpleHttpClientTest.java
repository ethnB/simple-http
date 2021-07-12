package com.github.ethnb.simplehttp.client;

import java.io.IOException;
import java.net.URISyntaxException;

import com.github.ethnb.simplehttp.Request;
import com.github.ethnb.simplehttp.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * SimpleHttpClientTest
 */
public class SimpleHttpClientTest {

    private static int OK = 200;

    @Test
    void example() throws URISyntaxException, IOException, InterruptedException {
        final SimpleHttpClient client = SimpleHttpClient.create();

        final Request request = Request.create("http://postman-echo.com/status/200", "GET", "body".getBytes());
        final Response response = client.execute(request);

        Assertions.assertEquals(OK, response.getStatus());
    }
}
