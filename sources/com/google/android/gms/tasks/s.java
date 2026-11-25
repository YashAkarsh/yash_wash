package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class s implements c<Void, m<List<m<?>>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f16818a;

    s(Collection collection) {
        this.f16818a = collection;
    }

    @Override // com.google.android.gms.tasks.c
    public final /* bridge */ /* synthetic */ m<List<m<?>>> a(@c.m0 m<Void> mVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f16818a);
        return p.g(arrayList);
    }
}
