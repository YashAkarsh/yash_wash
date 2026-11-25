package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class g0 extends c implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final s f21771b = new g0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final s f21772c = new g0(v.f21875a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f21773d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f21774e = -862048943;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f21775f = 461845907;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f21776g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21777a;

    @u1.a
    private static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f21778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f21779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f21780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f21781d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f21782e = false;

        a(int i7) {
            this.f21778a = i7;
        }

        private void p(int i7, long j7) {
            long j8 = this.f21779b;
            int i8 = this.f21780c;
            long j9 = ((j7 & 4294967295L) << i8) | j8;
            this.f21779b = j9;
            int i9 = i8 + (i7 * 8);
            this.f21780c = i9;
            this.f21781d += i7;
            if (i9 >= 32) {
                this.f21778a = g0.y(this.f21778a, g0.z((int) j9));
                this.f21779b >>>= 32;
                this.f21780c -= 32;
            }
        }

        @Override // com.google.common.hash.u
        public r o() {
            com.google.common.base.e0.g0(!this.f21782e);
            this.f21782e = true;
            int iZ = this.f21778a ^ g0.z((int) this.f21779b);
            this.f21778a = iZ;
            return g0.w(iZ, this.f21781d);
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u e(int i7) {
            p(4, i7);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u f(long j7) {
            p(4, (int) j7);
            p(4, j7 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u h(byte b8) {
            p(1, b8 & 255);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u j(byte[] bArr, int i7, int i8) {
            com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
            int i9 = 0;
            while (true) {
                int i10 = i9 + 4;
                if (i10 > i8) {
                    break;
                }
                p(4, g0.x(bArr, i9 + i7));
                i9 = i10;
            }
            while (i9 < i8) {
                h(bArr[i7 + i9]);
                i9++;
            }
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u k(char c8) {
            p(2, c8);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u l(ByteBuffer byteBuffer) {
            ByteOrder byteOrderOrder = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                e(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                h(byteBuffer.get());
            }
            byteBuffer.order(byteOrderOrder);
            return this;
        }

        @Override // com.google.common.hash.d, com.google.common.hash.u, com.google.common.hash.h0
        public u m(CharSequence charSequence, Charset charset) {
            if (!com.google.common.base.f.f19383c.equals(charset)) {
                return super.m(charSequence, charset);
            }
            int length = charSequence.length();
            int i7 = 0;
            while (true) {
                int i8 = i7 + 4;
                if (i8 > length) {
                    break;
                }
                char cCharAt = charSequence.charAt(i7);
                char cCharAt2 = charSequence.charAt(i7 + 1);
                char cCharAt3 = charSequence.charAt(i7 + 2);
                char cCharAt4 = charSequence.charAt(i7 + 3);
                if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                    break;
                }
                p(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
                i7 = i8;
            }
            while (i7 < length) {
                char cCharAt5 = charSequence.charAt(i7);
                if (cCharAt5 < 128) {
                    p(1, cCharAt5);
                } else if (cCharAt5 < 2048) {
                    p(2, g0.u(cCharAt5));
                } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                    p(3, g0.t(cCharAt5));
                } else {
                    int iCodePointAt = Character.codePointAt(charSequence, i7);
                    if (iCodePointAt == cCharAt5) {
                        g(charSequence.subSequence(i7, length).toString().getBytes(charset));
                        return this;
                    }
                    i7++;
                    p(4, g0.v(iCodePointAt));
                }
                i7++;
            }
            return this;
        }
    }

    g0(int i7) {
        this.f21777a = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long t(char c8) {
        return (((c8 & '?') | 128) << 16) | (((c8 >>> '\f') | 480) & 255) | ((((c8 >>> 6) & 63) | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long u(char c8) {
        return (((c8 & '?') | 128) << 8) | (((c8 >>> 6) | 960) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long v(int i7) {
        return ((((long) (i7 >>> 18)) | 240) & 255) | ((((long) ((i7 >>> 12) & 63)) | 128) << 8) | ((((long) ((i7 >>> 6) & 63)) | 128) << 16) | ((((long) (i7 & 63)) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r w(int i7, int i8) {
        int i9 = i7 ^ i8;
        int i10 = (i9 ^ (i9 >>> 16)) * (-2048144789);
        int i11 = (i10 ^ (i10 >>> 13)) * (-1028477387);
        return r.i(i11 ^ (i11 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(byte[] bArr, int i7) {
        return com.google.common.primitives.c0.k(bArr[i7 + 3], bArr[i7 + 2], bArr[i7 + 1], bArr[i7]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int y(int i7, int i8) {
        return (Integer.rotateLeft(i7 ^ i8, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z(int i7) {
        return Integer.rotateLeft(i7 * f21774e, 15) * f21775f;
    }

    @Override // com.google.common.hash.s
    public u b() {
        return new a(this.f21777a);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r c(int i7) {
        return w(y(this.f21777a, z(i7)), 4);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r e(CharSequence charSequence, Charset charset) {
        if (!com.google.common.base.f.f19383c.equals(charset)) {
            return a(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int iY = this.f21777a;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i8 + 4;
            if (i10 > length) {
                break;
            }
            char cCharAt = charSequence.charAt(i8);
            char cCharAt2 = charSequence.charAt(i8 + 1);
            char cCharAt3 = charSequence.charAt(i8 + 2);
            char cCharAt4 = charSequence.charAt(i8 + 3);
            if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                break;
            }
            iY = y(iY, z((cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24)));
            i9 += 4;
            i8 = i10;
        }
        long jT = 0;
        while (i8 < length) {
            char cCharAt5 = charSequence.charAt(i8);
            if (cCharAt5 < 128) {
                jT |= ((long) cCharAt5) << i7;
                i7 += 8;
                i9++;
            } else if (cCharAt5 < 2048) {
                jT |= u(cCharAt5) << i7;
                i7 += 16;
                i9 += 2;
            } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                jT |= t(cCharAt5) << i7;
                i7 += 24;
                i9 += 3;
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i8);
                if (iCodePointAt == cCharAt5) {
                    return a(charSequence.toString().getBytes(charset));
                }
                i8++;
                jT |= v(iCodePointAt) << i7;
                i9 += 4;
            }
            if (i7 >= 32) {
                iY = y(iY, z((int) jT));
                jT >>>= 32;
                i7 -= 32;
            }
            i8++;
        }
        return w(z((int) jT) ^ iY, i9);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g0) && this.f21777a == ((g0) obj).f21777a;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r g(CharSequence charSequence) {
        int iZ = this.f21777a;
        for (int i7 = 1; i7 < charSequence.length(); i7 += 2) {
            iZ = y(iZ, z(charSequence.charAt(i7 - 1) | (charSequence.charAt(i7) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            iZ ^= z(charSequence.charAt(charSequence.length() - 1));
        }
        return w(iZ, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.s
    public int h() {
        return 32;
    }

    public int hashCode() {
        return g0.class.hashCode() ^ this.f21777a;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r i(long j7) {
        return w(y(y(this.f21777a, z((int) j7)), z((int) (j7 >>> 32))), 8);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.s
    public r j(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        int iY = this.f21777a;
        int iP = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9 + 4;
            if (i10 > i8) {
                break;
            }
            iY = y(iY, z(x(bArr, i9 + i7)));
            i9 = i10;
        }
        int i11 = i9;
        int i12 = 0;
        while (i11 < i8) {
            iP ^= com.google.common.primitives.i0.p(bArr[i7 + i11]) << i12;
            i11++;
            i12 += 8;
        }
        return w(z(iP) ^ iY, i8);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.f21777a + ")";
    }
}
