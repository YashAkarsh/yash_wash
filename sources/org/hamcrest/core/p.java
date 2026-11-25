package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class p extends r {
    public p(String str) {
        super(str);
    }

    @org.hamcrest.i
    public static org.hamcrest.k<String> k(String str) {
        return new p(str);
    }

    @Override // org.hamcrest.core.r
    protected boolean h(String str) {
        return str.endsWith(this.f39724c);
    }

    @Override // org.hamcrest.core.r
    protected String j() {
        return "ending with";
    }
}
