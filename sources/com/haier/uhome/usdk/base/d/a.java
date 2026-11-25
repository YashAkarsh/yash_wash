package com.haier.uhome.usdk.base.d;

import com.haier.uhome.usdk.base.api.l;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f31253a;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.base.d.a$a, reason: collision with other inner class name */
    private static class C0379a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f31254a = new a();

        private C0379a() {
        }
    }

    public static a a() {
        return C0379a.f31254a;
    }

    private a() {
        this.f31253a = f.a();
    }

    public void a(BasicReq basicReq, int i7, l lVar) {
        this.f31253a.a(basicReq, i7, lVar);
    }

    public void a(BasicReq basicReq, l lVar) {
        a(basicReq, 5, lVar);
    }
}
