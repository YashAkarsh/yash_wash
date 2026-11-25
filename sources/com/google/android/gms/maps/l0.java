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
final class l0 extends com.google.android.gms.dynamic.a<k0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f16539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<k0> f16540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f16541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f16542h = new ArrayList();

    @g1.d0
    l0(Fragment fragment) {
        this.f16539e = fragment;
    }

    static /* synthetic */ void v(l0 l0Var, Activity activity) {
        l0Var.f16541g = activity;
        l0Var.x();
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<k0> gVar) {
        this.f16540f = gVar;
        x();
    }

    public final void w(g gVar) {
        if (b() != null) {
            b().a(gVar);
        } else {
            this.f16542h.add(gVar);
        }
    }

    public final void x() {
        if (this.f16541g == null || this.f16540f == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16541g);
            com.google.android.gms.maps.internal.d dVarJ0 = p1.a(this.f16541g, null).J0(com.google.android.gms.dynamic.f.z3(this.f16541g));
            if (dVarJ0 == null) {
                return;
            }
            this.f16540f.a(new k0(this.f16539e, dVarJ0));
            Iterator<g> it = this.f16542h.iterator();
            while (it.hasNext()) {
                b().a(it.next());
            }
            this.f16542h.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
