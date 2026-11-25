package com.haier.uhome.control.cloud.a;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.base.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o> f29024a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f29025a = new b();

        private a() {
        }
    }

    public void b(o oVar) {
        this.f29024a.remove(oVar);
    }

    private b() {
        this.f29024a = new CopyOnWriteArrayList();
    }

    public static b a() {
        return a.f29025a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, int i8) {
        for (o oVar : this.f29024a) {
            if (oVar.a(str)) {
                oVar.a(i7, i8);
            }
        }
    }

    public void a(o oVar) {
        if (oVar != null) {
            this.f29024a.add(oVar);
        }
    }

    public void a(int i7, int i8) {
        a("", i7, i8);
    }

    public void a(final String str, final int i7, final int i8) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f29061a.b(str, i7, i8);
            }
        });
    }
}
