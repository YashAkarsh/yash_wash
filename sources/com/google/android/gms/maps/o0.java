package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.internal.p1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class o0 extends com.google.android.gms.dynamic.a<n0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f16707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<n0> f16708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f16709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<i> f16710h = new ArrayList();

    @g1.d0
    o0(Fragment fragment) {
        this.f16707e = fragment;
    }

    static /* synthetic */ void v(o0 o0Var, Activity activity) {
        o0Var.f16709g = activity;
        o0Var.x();
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<n0> gVar) {
        this.f16708f = gVar;
        x();
    }

    public final void w(i iVar) {
        if (b() != null) {
            b().b(iVar);
        } else {
            this.f16710h.add(iVar);
        }
    }

    public final void x() {
        if (this.f16709g == null || this.f16708f == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16709g);
            this.f16708f.a(new n0(this.f16707e, p1.a(this.f16709g, null).q2(com.google.android.gms.dynamic.f.z3(this.f16709g))));
            Iterator<i> it = this.f16710h.iterator();
            while (it.hasNext()) {
                b().b(it.next());
            }
            this.f16710h.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
