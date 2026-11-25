package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQualityResp extends BasicDeviceResp {

    @b(name = "lplr")
    private int lplr;

    @b(name = "lrtt")
    private int lrtt;
    private String module;

    @b(name = "rplr")
    private int rplr;

    @b(name = "rrtt")
    private int rrtt;

    @b(name = "strength")
    private int strength;

    public int getLplr() {
        return this.lplr;
    }

    public int getLrtt() {
        return this.lrtt;
    }

    public String getModule() {
        return this.module;
    }

    public int getRplr() {
        return this.rplr;
    }

    public int getRrtt() {
        return this.rrtt;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setLplr(int i7) {
        this.lplr = i7;
    }

    public void setLrtt(int i7) {
        this.lrtt = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setRplr(int i7) {
        this.rplr = i7;
    }

    public void setRrtt(int i7) {
        this.rrtt = i7;
    }

    public void setStrength(int i7) {
        this.strength = i7;
    }

    @Override // com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "NetworkQualityResp{" + super.toString() + ", strength=" + this.strength + ", lrtt=" + this.lrtt + ", lplr=" + this.lplr + ", rrtt=" + this.rrtt + ", rplr=" + this.rplr + '}';
    }
}
