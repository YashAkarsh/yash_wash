package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class r0 extends LifecycleCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<WeakReference<m0<?>>> f16817b;

    private r0(com.google.android.gms.common.api.internal.m mVar) {
        super(mVar);
        this.f16817b = new ArrayList();
        this.f15136a.h("TaskOnStopCallback", this);
    }

    public static r0 m(Activity activity) {
        com.google.android.gms.common.api.internal.m mVarC = LifecycleCallback.c(activity);
        r0 r0Var = (r0) mVarC.l("TaskOnStopCallback", r0.class);
        return r0Var == null ? new r0(mVarC) : r0Var;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    @c.j0
    public final void l() {
        synchronized (this.f16817b) {
            Iterator<WeakReference<m0<?>>> it = this.f16817b.iterator();
            while (it.hasNext()) {
                m0<?> m0Var = it.next().get();
                if (m0Var != null) {
                    m0Var.t();
                }
            }
            this.f16817b.clear();
        }
    }

    public final <T> void n(m0<T> m0Var) {
        synchronized (this.f16817b) {
            this.f16817b.add(new WeakReference<>(m0Var));
        }
    }
}
