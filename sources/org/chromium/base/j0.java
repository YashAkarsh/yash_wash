package org.chromium.base;

import android.os.Handler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class j0<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f38797i = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f38799b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Exception f38801d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f38805h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38798a = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Callback<T>> f38800c = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Callback<Exception>> f38802e = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Thread f38803f = Thread.currentThread();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f38804g = new Handler();

    public interface a<A, R> {
        j0<R> apply(A a8);
    }

    public interface b<A, R> {
        R apply(A a8);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface c {
        public static final int V = 0;
        public static final int W = 1;
        public static final int X = 2;
    }

    public static class d extends RuntimeException {
        public d(String str, Throwable th) {
            super(str, th);
        }
    }

    private void e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(Callback<Exception> callback) {
        int i7 = this.f38798a;
        if (i7 == 2) {
            q(callback, this.f38801d);
        } else if (i7 == 0) {
            this.f38802e.add(callback);
        }
    }

    public static <T> j0<T> i(T t7) {
        j0<T> j0Var = new j0<>();
        j0Var.h(t7);
        return j0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Exception exc) {
        throw new d("Promise was rejected without a rejection handler.", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(j0 j0Var, b bVar, Object obj) {
        try {
            j0Var.h(bVar.apply(obj));
        } catch (Exception e8) {
            j0Var.s(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(a aVar, final j0 j0Var, Object obj) {
        try {
            j0 j0VarApply = aVar.apply(obj);
            Objects.requireNonNull(j0Var);
            j0VarApply.w(new Callback() { // from class: org.chromium.base.i0
                @Override // org.chromium.base.Callback
                public final void onResult(Object obj2) {
                    this.f38795a.h(obj2);
                }
            }, new g0(j0Var));
        } catch (Exception e8) {
            j0Var.s(e8);
        }
    }

    private <S> void q(final Callback<S> callback, final S s7) {
        this.f38804g.post(new Runnable() { // from class: org.chromium.base.d0
            @Override // java.lang.Runnable
            public final void run() {
                callback.onResult(s7);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x(Callback<T> callback) {
        int i7 = this.f38798a;
        if (i7 == 1) {
            q(callback, this.f38799b);
        } else if (i7 == 0) {
            this.f38800c.add(callback);
        }
    }

    public void f(Callback<Exception> callback) {
        e();
        g(callback);
    }

    public void h(T t7) {
        e();
        this.f38798a = 1;
        this.f38799b = t7;
        Iterator<Callback<T>> it = this.f38800c.iterator();
        while (it.hasNext()) {
            q(it.next(), t7);
        }
        this.f38800c.clear();
    }

    public T j() {
        return this.f38799b;
    }

    public boolean k() {
        e();
        return this.f38798a == 1;
    }

    public boolean l() {
        e();
        return this.f38798a == 2;
    }

    public void r() {
        s(null);
    }

    public void s(Exception exc) {
        e();
        this.f38798a = 2;
        this.f38801d = exc;
        Iterator<Callback<Exception>> it = this.f38802e.iterator();
        while (it.hasNext()) {
            q((Callback) it.next(), exc);
        }
        this.f38802e.clear();
    }

    public <R> j0<R> t(final a<T, R> aVar) {
        e();
        final j0<R> j0Var = new j0<>();
        x(new Callback() { // from class: org.chromium.base.h0
            @Override // org.chromium.base.Callback
            public final void onResult(Object obj) {
                j0.p(aVar, j0Var, obj);
            }
        });
        g(new g0(j0Var));
        return j0Var;
    }

    public <R> j0<R> u(final b<T, R> bVar) {
        e();
        final j0<R> j0Var = new j0<>();
        x(new Callback() { // from class: org.chromium.base.f0
            @Override // org.chromium.base.Callback
            public final void onResult(Object obj) {
                j0.o(this.f38783a, bVar, obj);
            }
        });
        g(new g0(j0Var));
        return j0Var;
    }

    public void v(Callback<T> callback) {
        e();
        if (this.f38805h) {
            x(callback);
        } else {
            w(callback, new Callback() { // from class: org.chromium.base.e0
                @Override // org.chromium.base.Callback
                public final void onResult(Object obj) {
                    j0.n((Exception) obj);
                }
            });
            this.f38805h = true;
        }
    }

    public void w(Callback<T> callback, Callback<Exception> callback2) {
        e();
        x(callback);
        g(callback2);
    }
}
