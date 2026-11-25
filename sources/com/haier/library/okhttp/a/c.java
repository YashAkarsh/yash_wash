package com.haier.library.okhttp.a;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<String> f26909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f26910b;

    public List<String> a() {
        return this.f26909a;
    }

    public void b(int i7) {
        this.f26910b = i7;
    }

    public void c(List<String> list) {
        this.f26909a = list;
    }

    public int d() {
        return this.f26910b;
    }

    public String toString() {
        return "LocalIpInfo{ipList=" + this.f26909a + ", ttl=" + this.f26910b + '}';
    }
}
