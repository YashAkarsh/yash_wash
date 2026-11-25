package com.haier.uhome.config.json;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class Addition {

    @b(name = "code")
    private int code;

    @b(name = "reason")
    private String reason;

    public int getCode() {
        return this.code;
    }

    public String getReason() {
        return this.reason;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String toString() {
        return "Addition{code=" + this.code + ", reason='" + this.reason + "'}";
    }
}
