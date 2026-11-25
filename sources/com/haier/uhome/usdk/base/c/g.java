package com.haier.uhome.usdk.base.c;

import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f31248a = new g();

        private a() {
        }
    }

    public static g a() {
        return a.f31248a;
    }

    private g() {
    }

    public void a(BasicResp basicResp) {
        BasicReq basicReqA = f.a().a(basicResp.getSn());
        if (basicReqA != null) {
            basicReqA.setResponse(basicResp);
            synchronized (basicReqA) {
                basicReqA.notifyAll();
            }
        }
    }
}
