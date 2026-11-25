package org.chromium.net;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39445a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39446b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39447c = 2;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f39448a;

        public a(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException("Executor must not be null");
            }
            this.f39448a = executor;
        }

        public Executor a() {
            return this.f39448a;
        }

        public abstract void b(k0 k0Var);
    }

    public static abstract class b {
        @c.o0
        public abstract Date a();

        @c.o0
        public abstract Date b();

        @c.o0
        public abstract Date c();

        @c.o0
        public abstract Date d();

        @c.o0
        public abstract Date e();

        @c.o0
        public abstract Date f();

        @c.o0
        public abstract Long g();

        @c.o0
        public abstract Date h();

        @c.o0
        public abstract Date i();

        @c.o0
        public abstract Date j();

        @c.o0
        public abstract Date k();

        @c.o0
        public abstract Date l();

        @c.o0
        public abstract Long m();

        public abstract boolean n();

        @c.o0
        public abstract Date o();

        @c.o0
        public abstract Date p();

        @c.o0
        public abstract Long q();

        @c.o0
        public abstract Long r();
    }

    public abstract Collection<Object> a();

    @c.o0
    public abstract k b();

    public abstract int c();

    public abstract b d();

    @c.o0
    public abstract u0 e();

    public abstract String f();
}
