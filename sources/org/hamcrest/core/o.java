package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class o extends r {
    public o(String str) {
        super(str);
    }

    @org.hamcrest.i
    public static org.hamcrest.k<String> k(String str) {
        return new o(str);
    }

    @Override // org.hamcrest.core.r
    protected boolean h(String str) {
        return str.indexOf(this.f39724c) >= 0;
    }

    @Override // org.hamcrest.core.r
    protected String j() {
        return "containing";
    }
}
