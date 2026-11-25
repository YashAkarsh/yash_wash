package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
abstract class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21732b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s[] f21733a;

    class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u[] f21734a;

        a(u[] uVarArr) {
            this.f21734a = uVarArr;
        }

        @Override // com.google.common.hash.u
        public <T> u n(T t7, p<? super T> pVar) {
            for (u uVar : this.f21734a) {
                uVar.n(t7, pVar);
            }
            return this;
        }

        @Override // com.google.common.hash.u
        public r o() {
            return b.this.m(this.f21734a);
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u a(double d8) {
            for (u uVar : this.f21734a) {
                uVar.a(d8);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u b(short s7) {
            for (u uVar : this.f21734a) {
                uVar.b(s7);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u c(boolean z7) {
            for (u uVar : this.f21734a) {
                uVar.c(z7);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u d(float f8) {
            for (u uVar : this.f21734a) {
                uVar.d(f8);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u e(int i7) {
            for (u uVar : this.f21734a) {
                uVar.e(i7);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u f(long j7) {
            for (u uVar : this.f21734a) {
                uVar.f(j7);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u g(byte[] bArr) {
            for (u uVar : this.f21734a) {
                uVar.g(bArr);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u h(byte b8) {
            for (u uVar : this.f21734a) {
                uVar.h(b8);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u i(CharSequence charSequence) {
            for (u uVar : this.f21734a) {
                uVar.i(charSequence);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u j(byte[] bArr, int i7, int i8) {
            for (u uVar : this.f21734a) {
                uVar.j(bArr, i7, i8);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u k(char c8) {
            for (u uVar : this.f21734a) {
                uVar.k(c8);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u l(ByteBuffer byteBuffer) {
            int iPosition = byteBuffer.position();
            for (u uVar : this.f21734a) {
                byteBuffer.position(iPosition);
                uVar.l(byteBuffer);
            }
            return this;
        }

        @Override // com.google.common.hash.u, com.google.common.hash.h0
        public u m(CharSequence charSequence, Charset charset) {
            for (u uVar : this.f21734a) {
                uVar.m(charSequence, charset);
            }
            return this;
        }
    }

    b(s... sVarArr) {
        for (s sVar : sVarArr) {
            com.google.common.base.e0.E(sVar);
        }
        this.f21733a = sVarArr;
    }

    private u l(u[] uVarArr) {
        return new a(uVarArr);
    }

    @Override // com.google.common.hash.s
    public u b() {
        int length = this.f21733a.length;
        u[] uVarArr = new u[length];
        for (int i7 = 0; i7 < length; i7++) {
            uVarArr[i7] = this.f21733a[i7].b();
        }
        return l(uVarArr);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public u k(int i7) {
        com.google.common.base.e0.d(i7 >= 0);
        int length = this.f21733a.length;
        u[] uVarArr = new u[length];
        for (int i8 = 0; i8 < length; i8++) {
            uVarArr[i8] = this.f21733a[i8].k(i7);
        }
        return l(uVarArr);
    }

    abstract r m(u[] uVarArr);
}
