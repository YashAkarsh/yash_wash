package com.haier.uhome.search.b;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.haier.uhome.usdk.base.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f29737a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f29738a = new f();

        private a() {
        }
    }

    private f() {
        this.f29737a = new CopyOnWriteArrayList();
    }

    public static f a() {
        return a.f29738a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, com.haier.uhome.usdk.base.api.f fVar) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(str, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, int i7) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().b(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str, int i7) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7);
        }
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.f29737a.add(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, int i7) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, i7);
        }
    }

    public void a(final String str, final com.haier.uhome.usdk.base.api.f fVar) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f29741a.b(str, fVar);
            }
        });
    }

    public void a(final String str, final String str2, final int i7) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f29762a.b(str, str2, i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, String str2, int i8, int i9) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, str2, i8, i9);
        }
    }

    public void a(final String str, final int i7, final String str2, final int i8, final int i9) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f29768a.b(str, i7, str2, i8, i9);
            }
        });
    }

    public void a(final com.haier.uhome.search.service.entity.b bVar) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f29757a.b(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.search.service.entity.b bVar) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
    }

    public void a(final String str, final int i7) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f29759a.d(str, i7);
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final String str4, final int i7, final String str5, final String str6, final int i8, final String str7, final int i9) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f29746a.b(str, str2, str3, str4, i7, str5, str6, i8, str7, i9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, String str3, String str4, int i7, String str5, String str6, int i8, String str7, int i9) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3, str4, i7, str5, str6, i8, str7, i9);
        }
    }

    public void a(final com.haier.uhome.search.service.entity.d dVar) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f29739a.b(dVar);
            }
        });
    }

    public void a(final com.haier.uhome.search.service.entity.i iVar) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f29744a.b(iVar);
            }
        });
    }

    public void a(final com.haier.uhome.search.service.entity.c cVar) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f29766a.b(cVar);
            }
        });
    }

    public void b(final String str, final int i7) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.search.b.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f29774a.c(str, i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.search.service.entity.d dVar) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.search.service.entity.i iVar) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.search.service.entity.c cVar) {
        Iterator<e> it = this.f29737a.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
    }
}
