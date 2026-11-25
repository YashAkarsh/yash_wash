package com.haier.uhome.control.cloud.api;

import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.control.cloud.service.a f29098a;

    /* JADX INFO: renamed from: com.haier.uhome.control.cloud.api.a$a, reason: collision with other inner class name */
    private static class C0369a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f29099a = new a();

        private C0369a() {
        }
    }

    public static a a() {
        return C0369a.f29099a;
    }

    private a() {
        this.f29098a = new com.haier.uhome.control.cloud.service.a();
    }

    public void a(ICallback<com.haier.uhome.control.base.a.c> iCallback) {
        this.f29098a.a(iCallback);
    }
}
