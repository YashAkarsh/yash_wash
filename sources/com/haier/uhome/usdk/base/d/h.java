package com.haier.uhome.usdk.base.d;

import com.haier.uhome.usdk.base.json.BasicReq;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class h<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f31275a;

    public h(f fVar) {
        this.f31275a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        while (true) {
            BasicReq basicReqC = this.f31275a.c();
            if (basicReqC == null) {
                return null;
            }
            try {
                this.f31275a.b(basicReqC);
            } catch (Exception e8) {
                e3.a.h("SendMsgTrigger [%s] exception,Exception [%s]", basicReqC, com.haier.library.common.util.c.e(e8));
            }
        }
    }
}
