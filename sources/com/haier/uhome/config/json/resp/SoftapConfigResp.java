package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SoftapConfigResp extends BasicResp {

    @b(name = "last_err")
    private int lastErr;

    @b(name = "last_match")
    private int lastMatch;

    @b(name = "softapConfigMode")
    private int softapConfigMode;

    public int getLastErr() {
        return this.lastErr;
    }

    public int getLastMatch() {
        return this.lastMatch;
    }

    public int getSoftapConfigMode() {
        return this.softapConfigMode;
    }

    public void setLastErr(int i7) {
        this.lastErr = i7;
    }

    public void setLastMatch(int i7) {
        this.lastMatch = i7;
    }

    public void setSoftapConfigMode(int i7) {
        this.softapConfigMode = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "SoftapConfigResp{softapConfigMode=" + this.softapConfigMode + ", lastErr=" + this.lastErr + ", lastMatch=" + this.lastMatch + '}';
    }
}
