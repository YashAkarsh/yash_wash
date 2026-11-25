package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.maps.internal.p1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class i0 extends com.google.android.gms.dynamic.a<h0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f16522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f16523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<h0> f16524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    private final StreetViewPanoramaOptions f16525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<i> f16526i = new ArrayList();

    @g1.d0
    i0(ViewGroup viewGroup, Context context, @c.o0 StreetViewPanoramaOptions streetViewPanoramaOptions) {
        this.f16522e = viewGroup;
        this.f16523f = context;
        this.f16525h = streetViewPanoramaOptions;
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<h0> gVar) {
        this.f16524g = gVar;
        w();
    }

    public final void v(i iVar) {
        if (b() != null) {
            b().b(iVar);
        } else {
            this.f16526i.add(iVar);
        }
    }

    public final void w() {
        if (this.f16524g == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16523f);
            this.f16524g.a(new h0(this.f16522e, p1.a(this.f16523f, null).r4(com.google.android.gms.dynamic.f.z3(this.f16523f), this.f16525h)));
            Iterator<i> it = this.f16526i.iterator();
            while (it.hasNext()) {
                b().b(it.next());
            }
            this.f16526i.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
