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
final class u extends com.google.android.gms.dynamic.a<t> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f16720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<t> f16721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f16722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f16723h = new ArrayList();

    @g1.d0
    u(Fragment fragment) {
        this.f16720e = fragment;
    }

    static /* synthetic */ void v(u uVar, Activity activity) {
        uVar.f16722g = activity;
        uVar.x();
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<t> gVar) {
        this.f16721f = gVar;
        x();
    }

    public final void w(g gVar) {
        if (b() != null) {
            b().a(gVar);
        } else {
            this.f16723h.add(gVar);
        }
    }

    public final void x() {
        if (this.f16722g == null || this.f16721f == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16722g);
            com.google.android.gms.maps.internal.d dVarJ0 = p1.a(this.f16722g, null).J0(com.google.android.gms.dynamic.f.z3(this.f16722g));
            if (dVarJ0 == null) {
                return;
            }
            this.f16721f.a(new t(this.f16720e, dVarJ0));
            Iterator<g> it = this.f16723h.iterator();
            while (it.hasNext()) {
                b().a(it.next());
            }
            this.f16723h.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
