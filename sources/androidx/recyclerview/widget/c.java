package androidx.recyclerview.widget;

import c.m0;
import c.o0;
import c.x0;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final Executor f9334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Executor f9335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final i.d<T> f9336c;

    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Object f9337d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Executor f9338e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        private Executor f9339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Executor f9340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final i.d<T> f9341c;

        public a(@m0 i.d<T> dVar) {
            this.f9341c = dVar;
        }

        @m0
        public c<T> a() {
            if (this.f9340b == null) {
                synchronized (f9337d) {
                    if (f9338e == null) {
                        f9338e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f9340b = f9338e;
            }
            return new c<>(this.f9339a, this.f9340b, this.f9341c);
        }

        @m0
        public a<T> b(Executor executor) {
            this.f9340b = executor;
            return this;
        }

        @x0({x0.a.LIBRARY})
        @m0
        public a<T> c(Executor executor) {
            this.f9339a = executor;
            return this;
        }
    }

    c(@o0 Executor executor, @m0 Executor executor2, @m0 i.d<T> dVar) {
        this.f9334a = executor;
        this.f9335b = executor2;
        this.f9336c = dVar;
    }

    @m0
    public Executor a() {
        return this.f9335b;
    }

    @m0
    public i.d<T> b() {
        return this.f9336c;
    }

    @o0
    @x0({x0.a.LIBRARY})
    public Executor c() {
        return this.f9334a;
    }
}
