package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class n<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f15333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private volatile L f15334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private volatile a<L> f15335c;

    @c1.a
    public static final class a<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final L f15336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15337b;

        @c1.a
        a(L l7, String str) {
            this.f15336a = l7;
            this.f15337b = str;
        }

        @c1.a
        @c.m0
        public String a() {
            String str = this.f15337b;
            int iIdentityHashCode = System.identityHashCode(this.f15336a);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(str);
            sb.append("@");
            sb.append(iIdentityHashCode);
            return sb.toString();
        }

        @c1.a
        public boolean equals(@c.o0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15336a == aVar.f15336a && this.f15337b.equals(aVar.f15337b);
        }

        @c1.a
        public int hashCode() {
            return (System.identityHashCode(this.f15336a) * 31) + this.f15337b.hashCode();
        }
    }

    @c1.a
    public interface b<L> {
        @c1.a
        void a(@c.m0 L l7);

        @c1.a
        void b();
    }

    @c1.a
    n(@c.m0 Looper looper, @c.m0 L l7, @c.m0 String str) {
        this.f15333a = new com.google.android.gms.common.util.concurrent.a(looper);
        this.f15334b = (L) com.google.android.gms.common.internal.u.l(l7, "Listener must not be null");
        this.f15335c = new a<>(l7, com.google.android.gms.common.internal.u.g(str));
    }

    @c1.a
    public void a() {
        this.f15334b = null;
        this.f15335c = null;
    }

    @c.o0
    @c1.a
    public a<L> b() {
        return this.f15335c;
    }

    @c1.a
    public boolean c() {
        return this.f15334b != null;
    }

    @c1.a
    public void d(@c.m0 final b<? super L> bVar) {
        com.google.android.gms.common.internal.u.l(bVar, "Notifier must not be null");
        this.f15333a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.g2
            @Override // java.lang.Runnable
            public final void run() {
                this.f15220a.e(bVar);
            }
        });
    }

    final void e(b<? super L> bVar) {
        L l7 = this.f15334b;
        if (l7 == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(l7);
        } catch (RuntimeException e8) {
            bVar.b();
            throw e8;
        }
    }

    @c1.a
    n(@c.m0 Executor executor, @c.m0 L l7, @c.m0 String str) {
        this.f15333a = (Executor) com.google.android.gms.common.internal.u.l(executor, "Executor must not be null");
        this.f15334b = (L) com.google.android.gms.common.internal.u.l(l7, "Listener must not be null");
        this.f15335c = new a<>(l7, com.google.android.gms.common.internal.u.g(str));
    }
}
