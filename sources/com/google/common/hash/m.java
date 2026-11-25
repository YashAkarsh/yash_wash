package com.google.common.hash;

import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class m extends c implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21842d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y<? extends Checksum> f21843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21845c;

    private final class b extends com.google.common.hash.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Checksum f21846b;

        @Override // com.google.common.hash.u
        public r o() {
            long value = this.f21846b.getValue();
            return m.this.f21844b == 32 ? r.i((int) value) : r.j(value);
        }

        @Override // com.google.common.hash.a
        protected void q(byte b8) {
            this.f21846b.update(b8);
        }

        @Override // com.google.common.hash.a
        protected void t(byte[] bArr, int i7, int i8) {
            this.f21846b.update(bArr, i7, i8);
        }

        private b(Checksum checksum) {
            this.f21846b = (Checksum) com.google.common.base.e0.E(checksum);
        }
    }

    m(y<? extends Checksum> yVar, int i7, String str) {
        this.f21843a = (y) com.google.common.base.e0.E(yVar);
        com.google.common.base.e0.k(i7 == 32 || i7 == 64, "bits (%s) must be either 32 or 64", i7);
        this.f21844b = i7;
        this.f21845c = (String) com.google.common.base.e0.E(str);
    }

    @Override // com.google.common.hash.s
    public u b() {
        return new b(this.f21843a.get());
    }

    @Override // com.google.common.hash.s
    public int h() {
        return this.f21844b;
    }

    public String toString() {
        return this.f21845c;
    }
}
