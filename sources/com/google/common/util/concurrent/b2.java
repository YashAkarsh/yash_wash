package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public interface b2 {

    @s1.a
    public static abstract class b {
        public void a(c cVar, Throwable th) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(c cVar) {
        }

        public void e(c cVar) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @s1.a
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f22550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f22551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f22552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f22553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f22554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ c[] f22555g;

        static enum a extends c {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return false;
            }
        }

        static enum b extends c {
            b(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return false;
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.b2$c$c, reason: collision with other inner class name */
        static enum C0292c extends c {
            C0292c(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return false;
            }
        }

        static enum d extends c {
            d(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return false;
            }
        }

        static enum e extends c {
            e(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return true;
            }
        }

        static enum f extends c {
            f(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.util.concurrent.b2.c
            boolean a() {
                return true;
            }
        }

        static {
            a aVar = new a("NEW", 0);
            f22549a = aVar;
            b bVar = new b("STARTING", 1);
            f22550b = bVar;
            C0292c c0292c = new C0292c(kotlinx.coroutines.debug.internal.f.f35948b, 2);
            f22551c = c0292c;
            d dVar = new d("STOPPING", 3);
            f22552d = dVar;
            e eVar = new e("TERMINATED", 4);
            f22553e = eVar;
            f fVar = new f("FAILED", 5);
            f22554f = fVar;
            f22555g = new c[]{aVar, bVar, c0292c, dVar, eVar, fVar};
        }

        private c(String str, int i7) {
            super(str, i7);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f22555g.clone();
        }

        abstract boolean a();
    }

    void a(b bVar, Executor executor);

    void b(long j7, TimeUnit timeUnit) throws TimeoutException;

    c c();

    void d();

    Throwable e();

    void f(long j7, TimeUnit timeUnit) throws TimeoutException;

    @u1.a
    b2 g();

    void h();

    @u1.a
    b2 i();

    boolean isRunning();
}
