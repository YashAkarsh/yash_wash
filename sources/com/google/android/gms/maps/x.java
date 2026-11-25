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
final class x extends com.google.android.gms.dynamic.a<w> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f16731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f16732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.google.android.gms.dynamic.g<w> f16733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    private final GoogleMapOptions f16734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<g> f16735i = new ArrayList();

    @g1.d0
    x(ViewGroup viewGroup, Context context, @c.o0 GoogleMapOptions googleMapOptions) {
        this.f16731e = viewGroup;
        this.f16732f = context;
        this.f16734h = googleMapOptions;
    }

    @Override // com.google.android.gms.dynamic.a
    protected final void a(com.google.android.gms.dynamic.g<w> gVar) {
        this.f16733g = gVar;
        w();
    }

    public final void v(g gVar) {
        if (b() != null) {
            b().a(gVar);
        } else {
            this.f16735i.add(gVar);
        }
    }

    public final void w() {
        if (this.f16733g == null || b() != null) {
            return;
        }
        try {
            f.a(this.f16732f);
            com.google.android.gms.maps.internal.e eVarD4 = p1.a(this.f16732f, null).D4(com.google.android.gms.dynamic.f.z3(this.f16732f), this.f16734h);
            if (eVarD4 == null) {
                return;
            }
            this.f16733g.a(new w(this.f16731e, eVarD4));
            Iterator<g> it = this.f16735i.iterator();
            while (it.hasNext()) {
                b().a(it.next());
            }
            this.f16735i.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        } catch (com.google.android.gms.common.i unused) {
        }
    }
}
