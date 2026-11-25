package com.haier.uhome.account.api;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomReqInfo {
    private String apiVersion;
    private Map<String, Object> body;
    private Map<String, String> headers;
    private boolean isHttps;
    private boolean isNotUwsType;
    private boolean notFixResult;
    private HttpRequestType requestType;
    private long timeout;
    private String token;
    private String url;

    public String getApiVersion() {
        return this.apiVersion;
    }

    public Map<String, Object> getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpRequestType getRequestType() {
        return this.requestType;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isHttps() {
        return this.isHttps;
    }

    public boolean isNotFixResult() {
        return this.notFixResult;
    }

    public boolean isNotUwsType() {
        return this.isNotUwsType;
    }

    public void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public void setBody(Map<String, Object> map) {
        this.body = map;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setHttps(boolean z7) {
        this.isHttps = z7;
    }

    public void setNotFixResult(boolean z7) {
        this.notFixResult = z7;
    }

    public void setNotUwsType(boolean z7) {
        this.isNotUwsType = z7;
    }

    public void setRequestType(HttpRequestType httpRequestType) {
        this.requestType = httpRequestType;
    }

    public void setTimeout(long j7) {
        this.timeout = j7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "CustomReqInfo{url='" + this.url + ", isHttps=" + this.isHttps + ", requestType=" + this.requestType + ", body=" + this.body + ", headers=" + this.headers + ", token='" + this.token + ", timeout=" + this.timeout + ", isNotUwsType=" + this.isNotUwsType + '}';
    }
}
