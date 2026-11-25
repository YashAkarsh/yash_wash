package com.haier.uhome.config.service;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f28540a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f28541a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.f28541a;
    }

    private c() {
        this.f28540a = b.a();
    }

    public String a(String str, String str2) {
        return this.f28540a.a(str, str2);
    }
}
