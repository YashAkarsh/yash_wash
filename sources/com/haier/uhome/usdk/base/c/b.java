package com.haier.uhome.usdk.base.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f31236a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f31237a = new b();

        private a() {
        }
    }

    public void b(c cVar) {
        if (cVar != null) {
            synchronized (this.f31236a) {
                this.f31236a.remove(cVar);
            }
        }
    }

    private b() {
        this.f31236a = new ArrayList();
    }

    public static b a() {
        return a.f31237a;
    }

    public void a(c cVar) {
        if (cVar != null) {
            synchronized (this.f31236a) {
                this.f31236a.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i7) {
        ArrayList arrayList;
        synchronized (this.f31236a) {
            arrayList = new ArrayList(this.f31236a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).notifyBtStateChanged(i7);
        }
    }

    public void a(final int i7) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.usdk.base.c.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f31249a.b(i7);
            }
        });
    }
}
