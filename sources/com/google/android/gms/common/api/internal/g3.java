package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.t;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class g3<R extends com.google.android.gms.common.api.t> extends com.google.android.gms.common.api.x<R> implements com.google.android.gms.common.api.u<R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<com.google.android.gms.common.api.k> f15228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e3 f15229h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.api.w<? super R, ? extends com.google.android.gms.common.api.t> f15222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private g3<? extends com.google.android.gms.common.api.t> f15223b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private volatile com.google.android.gms.common.api.v<? super R> f15224c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.api.n<R> f15225d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f15226e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    private Status f15227f = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15230i = false;

    public g3(WeakReference<com.google.android.gms.common.api.k> weakReference) {
        com.google.android.gms.common.internal.u.l(weakReference, "GoogleApiClient reference must not be null");
        this.f15228g = weakReference;
        com.google.android.gms.common.api.k kVar = weakReference.get();
        this.f15229h = new e3(this, kVar != null ? kVar.r() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Status status) {
        synchronized (this.f15226e) {
            this.f15227f = status;
            o(status);
        }
    }

    @GuardedBy("mSyncToken")
    private final void n() {
        if (this.f15222a == null && this.f15224c == null) {
            return;
        }
        com.google.android.gms.common.api.k kVar = this.f15228g.get();
        if (!this.f15230i && this.f15222a != null && kVar != null) {
            kVar.H(this);
            this.f15230i = true;
        }
        Status status = this.f15227f;
        if (status != null) {
            o(status);
            return;
        }
        com.google.android.gms.common.api.n<R> nVar = this.f15225d;
        if (nVar != null) {
            nVar.h(this);
        }
    }

    private final void o(Status status) {
        synchronized (this.f15226e) {
            com.google.android.gms.common.api.w<? super R, ? extends com.google.android.gms.common.api.t> wVar = this.f15222a;
            if (wVar != null) {
                ((g3) com.google.android.gms.common.internal.u.k(this.f15223b)).m((Status) com.google.android.gms.common.internal.u.l(wVar.b(status), "onFailure must not return null"));
            } else if (p()) {
                ((com.google.android.gms.common.api.v) com.google.android.gms.common.internal.u.k(this.f15224c)).b(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean p() {
        return (this.f15224c == null || this.f15228g.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(com.google.android.gms.common.api.t tVar) {
        if (tVar instanceof com.google.android.gms.common.api.p) {
            try {
                ((com.google.android.gms.common.api.p) tVar).i();
            } catch (RuntimeException e8) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(tVar)), e8);
            }
        }
    }

    @Override // com.google.android.gms.common.api.u
    public final void a(R r7) {
        synchronized (this.f15226e) {
            if (!r7.G().G0()) {
                m(r7.G());
                q(r7);
            } else if (this.f15222a != null) {
                t2.a().submit(new d3(this, r7));
            } else if (p()) {
                ((com.google.android.gms.common.api.v) com.google.android.gms.common.internal.u.k(this.f15224c)).c(r7);
            }
        }
    }

    @Override // com.google.android.gms.common.api.x
    public final void b(@c.m0 com.google.android.gms.common.api.v<? super R> vVar) {
        synchronized (this.f15226e) {
            boolean z7 = true;
            com.google.android.gms.common.internal.u.r(this.f15224c == null, "Cannot call andFinally() twice.");
            if (this.f15222a != null) {
                z7 = false;
            }
            com.google.android.gms.common.internal.u.r(z7, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f15224c = vVar;
            n();
        }
    }

    @Override // com.google.android.gms.common.api.x
    @c.m0
    public final <S extends com.google.android.gms.common.api.t> com.google.android.gms.common.api.x<S> c(@c.m0 com.google.android.gms.common.api.w<? super R, ? extends S> wVar) {
        g3<? extends com.google.android.gms.common.api.t> g3Var;
        synchronized (this.f15226e) {
            boolean z7 = true;
            com.google.android.gms.common.internal.u.r(this.f15222a == null, "Cannot call then() twice.");
            if (this.f15224c != null) {
                z7 = false;
            }
            com.google.android.gms.common.internal.u.r(z7, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f15222a = wVar;
            g3Var = new g3<>(this.f15228g);
            this.f15223b = g3Var;
            n();
        }
        return g3Var;
    }

    final void k() {
        this.f15224c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(com.google.android.gms.common.api.n<?> nVar) {
        synchronized (this.f15226e) {
            this.f15225d = nVar;
            n();
        }
    }
}
