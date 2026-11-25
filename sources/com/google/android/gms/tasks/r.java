package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class r implements c<Void, List> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f16816a;

    r(Collection collection) {
        this.f16816a = collection;
    }

    @Override // com.google.android.gms.tasks.c
    public final /* bridge */ /* synthetic */ List a(@c.m0 m<Void> mVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f16816a.iterator();
        while (it.hasNext()) {
            arrayList.add(((m) it.next()).r());
        }
        return arrayList;
    }
}
