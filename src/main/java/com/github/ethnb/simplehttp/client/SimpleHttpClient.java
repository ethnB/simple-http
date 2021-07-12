package com.github.ethnb.simplehttp.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.github.ethnb.simplehttp.Request;
import com.github.ethnb.simplehttp.Response;

public class SimpleHttpClient implements IHttpClient {
    private HttpClient backingClient;

    private SimpleHttpClient(final HttpClient backingClient) {
        this.backingClient = backingClient;
    }

    @Override
    public Response execute(final String uri, final String method, final byte[] body)
            throws IOException, InterruptedException, URISyntaxException {
        return this.execute(Request.create(uri, method, body));
    }

    /**
     * This is the single entry point for all requests
     * 
     * @param request the request for the client to execute
     * @return a Response containing HTTP response details
     * @throws IOException          if the request URI scheme is not supported or if
     *                              the backing client throws an error while sending
     * @throws InterruptedException if the send operation is interrupted
     */
    @Override
    public Response execute(final Request request) throws IOException, InterruptedException {
        final HttpRequest realRequest = HttpRequest.newBuilder(request.getURI())
                .method(request.getMethod(), BodyPublishers.ofByteArray(request.getBody())).build();

        final HttpResponse<byte[]> response = backingClient.send(realRequest, BodyHandlers.ofByteArray());
        return Response.create(response.statusCode(), response.body());
    }

    public static SimpleHttpClient create() {
        final HttpClient client = HttpClient.newHttpClient();
        return new SimpleHttpClient(client);
    }
}