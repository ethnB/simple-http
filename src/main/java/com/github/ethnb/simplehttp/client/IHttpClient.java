package com.github.ethnb.simplehttp.client;

import java.io.IOException;
import java.net.URISyntaxException;

import com.github.ethnb.simplehttp.Request;
import com.github.ethnb.simplehttp.Response;

public interface IHttpClient {
    Response execute(final String uri, final String method, final byte[] body)
            throws IOException, InterruptedException, URISyntaxException;

    Response execute(final Request request) throws IOException, InterruptedException;
}
