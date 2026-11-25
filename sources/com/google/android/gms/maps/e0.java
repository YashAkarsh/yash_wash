package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.p1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class e0 extends com.google.android.gms.dynamic.a<d0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f16504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<d0> f16505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f16506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<i> f16507h = new ArrayList();

    @g1.d0
    e0(Fragment fragment) {
        this.f16504e = fragment;
    }

    static /* synthetic */ void v(e0 e0Var, Activity activity) {
        e0Var.f16506g = activity;
        e0Var.x();
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<d0> gVar) {
        this.f16505f = gVar;
        x();
    }

    public final void w(i iVar) {
        if (b() != null) {
            b().b(iVar);
        } else {
            this.f16507h.add(iVar);
        }
    }

    public final void x() {
        if (this.f16506g == null || this.f16505f == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16506g);
            this.f16505f.a(new d0(this.f16504e, p1.a(this.f16506g, null).q2(com.google.android.gms.dynamic.f.z3(this.f16506g))));
            Iterator<i> it = this.f16507h.iterator();
            while (it.hasNext()) {
                b().b(it.next());
            }
            this.f16507h.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
