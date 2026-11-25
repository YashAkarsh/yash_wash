package org.chromium.base;

import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class z<E> implements x<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f38974e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private E f38977c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f38975a = Thread.currentThread();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f38976b = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a0<Callback<E>> f38978d = new a0<>();

    private void d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Object obj, Callback callback) {
        if (this.f38977c == obj && this.f38978d.m(callback)) {
            callback.onResult(this.f38977c);
        }
    }

    @Override // org.chromium.base.x
    public void a(Callback<E> callback) {
        d();
        this.f38978d.o(callback);
    }

    @Override // org.chromium.base.x
    public E b(final Callback<E> callback) {
        d();
        this.f38978d.g(callback);
        final E e8 = this.f38977c;
        if (e8 != null) {
            this.f38976b.post(new Runnable() { // from class: org.chromium.base.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f38971a.e(e8, callback);
                }
            });
        }
        return this.f38977c;
    }

    public void f(E e8) {
        d();
        if (e8 == this.f38977c) {
            return;
        }
        this.f38977c = e8;
        Iterator<Callback<E>> it = this.f38978d.iterator();
        while (it.hasNext()) {
            it.next().onResult(this.f38977c);
        }
    }

    @Override // org.chromium.base.n0
    @c.o0
    public E get() {
        d();
        return this.f38977c;
    }
}
