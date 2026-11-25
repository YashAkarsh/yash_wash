package com.haier.uhome.account.model;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReqModel {
    private String bodys;
    private Map<String, String> bodysMap;
    private Map<String, String> headers;
    private boolean isHttps;
    private boolean notFixResult;
    private String requestType;
    private long timeout;
    private String url;

    public String getBodys() {
        return this.bodys;
    }

    public Map<String, String> getBodysMap() {
        return this.bodysMap;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public boolean getHttps() {
        return this.isHttps;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isNotFixResult() {
        return this.notFixResult;
    }

    public void setBodys(String str) {
        this.bodys = str;
    }

    public void setBodysMap(Map<String, String> map) {
        this.bodysMap = map;
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

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public void setTimeout(long j7) {
        this.timeout = j7;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
