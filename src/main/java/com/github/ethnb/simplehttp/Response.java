package com.github.ethnb.simplehttp;

public class Response {
    private int status;
    private byte[] body;
    private Header[] headers = { new Header("test-response-header", "test-value") };

    private Response(final int status, final byte[] body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Header[] getHeaders() {
        return this.headers;
    }

    public static Response create(final int status, final byte[] body) {
        return new Response(status, body);
    }
}
