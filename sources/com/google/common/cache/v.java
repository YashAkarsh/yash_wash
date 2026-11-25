package com.google.common.cache;

import com.google.common.base.p0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p0<u> f19849a;

    static class a implements p0<u> {
        a() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u get() {
            return new w();
        }
    }

    static class b implements p0<u> {
        b() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u get() {
            return new c(null);
        }
    }

    private static final class c extends AtomicLong implements u {
        private c() {
        }

        @Override // com.google.common.cache.u
        public void a() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.u
        public long b() {
            return get();
        }

        @Override // com.google.common.cache.u
        public void c(long j7) {
            getAndAdd(j7);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        p0<u> bVar;
        try {
            new w();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f19849a = bVar;
    }

    v() {
    }

    public static u a() {
        return f19849a.get();
    }
}
