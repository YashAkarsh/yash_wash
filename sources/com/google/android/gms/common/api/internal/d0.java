package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.g1(otherwise = 2)
final class d0 extends LifecycleCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Runnable> f15181b;

    private d0(m mVar) {
        super(mVar);
        this.f15181b = new ArrayList();
        this.f15136a.h("LifecycleObserverOnStop", this);
    }

    static /* bridge */ /* synthetic */ d0 m(Activity activity) {
        d0 d0Var;
        synchronized (activity) {
            m mVarC = LifecycleCallback.c(activity);
            d0Var = (d0) mVarC.l("LifecycleObserverOnStop", d0.class);
            if (d0Var == null) {
                d0Var = new d0(mVarC);
            }
        }
        return d0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void o(Runnable runnable) {
        this.f15181b.add(runnable);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    @c.j0
    public final void l() {
        List<Runnable> list;
        synchronized (this) {
            list = this.f15181b;
            this.f15181b = new ArrayList();
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }
}
