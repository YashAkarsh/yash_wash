package com.haier.uhome.control.cloud.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.haier.uhome.usdk.base.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<p> f29051a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f29052a = new h();

        private a() {
        }
    }

    private h() {
        this.f29051a = new CopyOnWriteArrayList();
    }

    public static h a() {
        return a.f29052a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    public void b(p pVar) {
        if (pVar != null) {
            this.f29051a.remove(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7);
        }
    }

    public void a(p pVar) {
        if (pVar != null) {
            this.f29051a.add(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, int i7, int i8) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().b(str, i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str, int i7, int i8) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, i8);
        }
    }

    public void a(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29046a.b(str, i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, String str3) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3);
        }
    }

    public void a(final String str) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f29077a.d(str);
            }
        });
    }

    public void a(final String str, final String str2, final String str3) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29026a.b(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
    }

    public void a(final String str, final String str2) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f29065a.b(str, str2);
            }
        });
    }

    public void a(final String str, final int i7, final String str2, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29041a.b(str, i7, str2, i8);
            }
        });
    }

    public void a(final String str, final int i7, final boolean z7, final String str2) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29053a.b(str, i7, z7, str2);
            }
        });
    }

    public void b(final String str) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29049a.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, String str2, int i8) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, str2, i8);
        }
    }

    public void a(final String str, final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29030a.d(str, i7, i8);
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final String str4, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29018a.b(str, str2, str3, str4, i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, boolean z7, String str2) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, z7, str2);
        }
    }

    public void a(final long j7, final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f29079a.b(j7, str, i7);
            }
        });
    }

    public void a(final long j7, final String str, final String str2, final int i7) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f29068a.b(j7, str, str2, i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, String str3, String str4, int i7) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3, str4, i7);
        }
    }

    public void a(final long j7, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29058a.b(j7, i7);
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final int i7, final int i8, final String str4) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29034a.b(str, str2, str3, i7, i8, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j7, String str, int i7) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(j7, str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j7, String str, String str2, int i7) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(j7, str, str2, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j7, int i7) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(j7, i7);
        }
    }

    public void b(final String str, final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.cloud.a.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f29073a.c(str, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, String str3, int i7, int i8, String str4) {
        Iterator<p> it = this.f29051a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3, i7, i8, str4);
        }
    }
}
