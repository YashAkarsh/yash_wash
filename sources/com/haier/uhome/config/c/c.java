package com.haier.uhome.config.c;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.usdk.base.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<f> f28458a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f28459a = new c();

        private a() {
        }
    }

    private c() {
        this.f28458a = new CopyOnWriteArrayList();
    }

    public static c a() {
        return a.f28459a;
    }

    public void b(f fVar) {
        this.f28458a.remove(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i7, int i8, int i9) {
        Iterator<f> it = this.f28458a.iterator();
        while (it.hasNext()) {
            it.next().a(i7, i8, i9);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.f28458a.add(fVar);
        }
    }

    public void a(final int i7, final int i8, final int i9) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.config.c.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f28460a.b(i7, i8, i9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, int i8, int i9) {
        Iterator<f> it = this.f28458a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, i8, i9);
        }
    }

    public void a(final String str, final int i7, final int i8, final int i9) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.config.c.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f28464a.b(str, i7, i8, i9);
            }
        });
    }

    public void a(com.haier.uhome.config.entity.c cVar) {
        com.haier.uhome.usdk.base.d.c.a().c(cVar);
    }

    public void a(com.haier.uhome.config.entity.d dVar) {
        com.haier.uhome.usdk.base.d.c.a().c(dVar);
    }
}
