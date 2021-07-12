package com.github.ethnb.simplehttp;

import java.net.URI;
import java.net.URISyntaxException;

public class Request {
    private URI uri;
    private String method;
    private byte[] body;
    private Header[] headers = { new Header("test-header", "test-value") };

    private Request(final URI uri, final String method, final byte[] body) {
        this.uri = uri;
        this.method = method;
        this.body = body;
    }

    public URI getURI() {
        return this.uri;
    }

    public String getMethod() {
        return this.method;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Header[] getHeaders() {
        return this.headers;
    }

    public static Request create(final String url, final String method, final byte[] body) throws URISyntaxException {
        final URI uri = URI.create(url);

        return new Request(uri, method, body);
    }
}