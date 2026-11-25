package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class q extends r {
    public q(String str) {
        super(str);
    }

    @org.hamcrest.i
    public static org.hamcrest.k<String> k(String str) {
        return new q(str);
    }

    @Override // org.hamcrest.core.r
    protected boolean h(String str) {
        return str.startsWith(this.f39724c);
    }

    @Override // org.hamcrest.core.r
    protected String j() {
        return "starting with";
    }
}
