package com.haier.library.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f26311a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f26314d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g f26312b = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b0 f26315e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0 f26316f = new b();

    final class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d0 f26317a = new d0();

        a() {
        }

        @Override // com.haier.library.a.b0
        public void I1(g gVar, long j7) throws IOException {
            synchronized (v.this.f26312b) {
                if (v.this.f26313c) {
                    throw new IllegalStateException("closed");
                }
                while (j7 > 0) {
                    v vVar = v.this;
                    if (vVar.f26314d) {
                        throw new IOException("source is closed");
                    }
                    long jY0 = vVar.f26311a - vVar.f26312b.Y0();
                    if (jY0 == 0) {
                        this.f26317a.c(v.this.f26312b);
                    } else {
                        long jMin = Math.min(jY0, j7);
                        v.this.f26312b.I1(gVar, jMin);
                        j7 -= jMin;
                        v.this.f26312b.notifyAll();
                    }
                }
            }
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return this.f26317a;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (v.this.f26312b) {
                v vVar = v.this;
                if (vVar.f26313c) {
                    return;
                }
                if (vVar.f26314d && vVar.f26312b.Y0() > 0) {
                    throw new IOException("source is closed");
                }
                v vVar2 = v.this;
                vVar2.f26313c = true;
                vVar2.f26312b.notifyAll();
            }
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            synchronized (v.this.f26312b) {
                v vVar = v.this;
                if (vVar.f26313c) {
                    throw new IllegalStateException("closed");
                }
                if (vVar.f26314d && vVar.f26312b.Y0() > 0) {
                    throw new IOException("source is closed");
                }
            }
        }
    }

    final class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d0 f26319a = new d0();

        b() {
        }

        @Override // com.haier.library.a.c0
        public long P0(g gVar, long j7) throws IOException {
            synchronized (v.this.f26312b) {
                if (v.this.f26314d) {
                    throw new IllegalStateException("closed");
                }
                while (v.this.f26312b.Y0() == 0) {
                    v vVar = v.this;
                    if (vVar.f26313c) {
                        return -1L;
                    }
                    this.f26319a.c(vVar.f26312b);
                }
                long jP0 = v.this.f26312b.P0(gVar, j7);
                v.this.f26312b.notifyAll();
                return jP0;
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return this.f26319a;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (v.this.f26312b) {
                v vVar = v.this;
                vVar.f26314d = true;
                vVar.f26312b.notifyAll();
            }
        }
    }

    public v(long j7) {
        if (j7 >= 1) {
            this.f26311a = j7;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j7);
    }

    public final c0 a() {
        return this.f26316f;
    }

    public final b0 b() {
        return this.f26315e;
    }
}
