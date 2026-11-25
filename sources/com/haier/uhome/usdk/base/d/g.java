package com.haier.uhome.usdk.base.d;

import com.haier.uhome.usdk.base.json.InComing;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class g<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f31274a;

    public g(f fVar) {
        this.f31274a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        while (true) {
            InComing inComingD = this.f31274a.d();
            if (inComingD == null) {
                return null;
            }
            try {
                this.f31274a.b(inComingD);
            } catch (Exception e8) {
                e3.a.h("ReceiveMsgTrigger exception,Exception [%s]", com.haier.library.common.util.c.e(e8));
            }
        }
    }
}
