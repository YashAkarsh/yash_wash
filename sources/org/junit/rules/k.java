package org.junit.rules;

/* JADX INFO: loaded from: classes3.dex */
public class k extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39937a;

    @Override // org.junit.rules.m
    protected void n(org.junit.runner.c cVar) {
        this.f39937a = cVar.p();
    }

    public String r() {
        return this.f39937a;
    }
}
