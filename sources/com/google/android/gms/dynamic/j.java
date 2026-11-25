package com.google.android.gms.dynamic;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f16024a;

    j(a aVar) {
        this.f16024a = aVar;
    }

    @Override // com.google.android.gms.dynamic.g
    public final void a(e eVar) {
        this.f16024a.f16015a = eVar;
        Iterator it = this.f16024a.f16017c.iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(this.f16024a.f16015a);
        }
        this.f16024a.f16017c.clear();
        this.f16024a.f16016b = null;
    }
}
