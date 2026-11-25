package com.google.common.hash;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f21875a = (int) System.currentTimeMillis();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @u1.j
    static abstract class b implements y<Checksum> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f21877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f21878d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f21879a;

        static enum a extends b {
            a(String str, int i7, String str2) {
                super(str, i7, str2);
            }

            @Override // com.google.common.base.p0, java.util.function.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new CRC32();
            }
        }

        /* JADX INFO: renamed from: com.google.common.hash.v$b$b, reason: collision with other inner class name */
        static enum C0278b extends b {
            C0278b(String str, int i7, String str2) {
                super(str, i7, str2);
            }

            @Override // com.google.common.base.p0, java.util.function.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Checksum get() {
                return new Adler32();
            }
        }

        static {
            a aVar = new a("CRC_32", 0, "Hashing.crc32()");
            f21876b = aVar;
            C0278b c0278b = new C0278b("ADLER_32", 1, "Hashing.adler32()");
            f21877c = c0278b;
            f21878d = new b[]{aVar, c0278b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f21878d.clone();
        }

        private b(String str, int i7, String str2) {
            super(str, i7);
            this.f21879a = new m(this, 32, str2);
        }
    }

    private static final class c extends com.google.common.hash.b {
        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(this.f21733a, ((c) obj).f21733a);
            }
            return false;
        }

        @Override // com.google.common.hash.s
        public int h() {
            int iH = 0;
            for (s sVar : this.f21733a) {
                iH += sVar.h();
            }
            return iH;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f21733a);
        }

        @Override // com.google.common.hash.b
        r m(u[] uVarArr) {
            byte[] bArr = new byte[h() / 8];
            int iN = 0;
            for (u uVar : uVarArr) {
                r rVarO = uVar.o();
                iN += rVarO.n(bArr, iN, rVarO.d() / 8);
            }
            return r.h(bArr);
        }

        private c(s... sVarArr) {
            super(sVarArr);
            for (s sVar : sVarArr) {
                com.google.common.base.e0.o(sVar.h() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", sVar.h(), sVar);
            }
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f21880a;

        public d(long j7) {
            this.f21880a = j7;
        }

        public double a() {
            long j7 = (this.f21880a * 2862933555777941757L) + 1;
            this.f21880a = j7;
            return ((double) (((int) (j7 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f21881a = new e0("MD5", "Hashing.md5()");

        private e() {
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f21882a = new e0("SHA-1", "Hashing.sha1()");

        private f() {
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f21883a = new e0("SHA-256", "Hashing.sha256()");

        private g() {
        }
    }

    private static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f21884a = new e0("SHA-384", "Hashing.sha384()");

        private h() {
        }
    }

    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f21885a = new e0("SHA-512", "Hashing.sha512()");

        private i() {
        }
    }

    private v() {
    }

    @Deprecated
    public static s A() {
        return f.f21882a;
    }

    public static s B() {
        return g.f21883a;
    }

    public static s C() {
        return h.f21884a;
    }

    public static s D() {
        return i.f21885a;
    }

    public static s E() {
        return i0.f21786e;
    }

    public static s F(long j7, long j8) {
        return new i0(2, 4, j7, j8);
    }

    public static s a() {
        return b.f21877c.f21879a;
    }

    static int b(int i7) {
        com.google.common.base.e0.e(i7 > 0, "Number of bits must be positive");
        return (i7 + 31) & (-32);
    }

    public static r c(Iterable<r> iterable) {
        Iterator<r> it = iterable.iterator();
        com.google.common.base.e0.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iD = it.next().d() / 8;
        byte[] bArr = new byte[iD];
        Iterator<r> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrA = it2.next().a();
            com.google.common.base.e0.e(bArrA.length == iD, "All hashcodes must have the same bit length.");
            for (int i7 = 0; i7 < bArrA.length; i7++) {
                bArr[i7] = (byte) ((bArr[i7] * 37) ^ bArrA[i7]);
            }
        }
        return r.h(bArr);
    }

    public static r d(Iterable<r> iterable) {
        Iterator<r> it = iterable.iterator();
        com.google.common.base.e0.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iD = it.next().d() / 8;
        byte[] bArr = new byte[iD];
        Iterator<r> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] bArrA = it2.next().a();
            com.google.common.base.e0.e(bArrA.length == iD, "All hashcodes must have the same bit length.");
            for (int i7 = 0; i7 < bArrA.length; i7++) {
                bArr[i7] = (byte) (bArr[i7] + bArrA[i7]);
            }
        }
        return r.h(bArr);
    }

    public static s e(s sVar, s sVar2, s... sVarArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(sVar);
        arrayList.add(sVar2);
        arrayList.addAll(Arrays.asList(sVarArr));
        return new c((s[]) arrayList.toArray(new s[0]));
    }

    public static s f(Iterable<s> iterable) {
        com.google.common.base.e0.E(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<s> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        com.google.common.base.e0.k(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new c((s[]) arrayList.toArray(new s[0]));
    }

    public static int g(long j7, int i7) {
        int i8 = 0;
        com.google.common.base.e0.k(i7 > 0, "buckets must be positive: %s", i7);
        d dVar = new d(j7);
        while (true) {
            int iA = (int) (((double) (i8 + 1)) / dVar.a());
            if (iA < 0 || iA >= i7) {
                break;
            }
            i8 = iA;
        }
        return i8;
    }

    public static int h(r rVar, int i7) {
        return g(rVar.m(), i7);
    }

    public static s i() {
        return b.f21876b.f21879a;
    }

    public static s j() {
        return n.f21848a;
    }

    public static s k() {
        return o.f21851a;
    }

    public static s l(int i7) {
        int iB = b(i7);
        if (iB == 32) {
            return g0.f21772c;
        }
        if (iB <= 128) {
            return f0.f21762c;
        }
        int i8 = (iB + 127) / 128;
        s[] sVarArr = new s[i8];
        sVarArr[0] = f0.f21762c;
        int i9 = f21875a;
        for (int i10 = 1; i10 < i8; i10++) {
            i9 += 1500450271;
            sVarArr[i10] = x(i9);
        }
        return new c(sVarArr);
    }

    public static s m(Key key) {
        return new d0("HmacMD5", key, u("hmacMd5", key));
    }

    public static s n(byte[] bArr) {
        return m(new SecretKeySpec((byte[]) com.google.common.base.e0.E(bArr), "HmacMD5"));
    }

    public static s o(Key key) {
        return new d0("HmacSHA1", key, u("hmacSha1", key));
    }

    public static s p(byte[] bArr) {
        return o(new SecretKeySpec((byte[]) com.google.common.base.e0.E(bArr), "HmacSHA1"));
    }

    public static s q(Key key) {
        return new d0("HmacSHA256", key, u("hmacSha256", key));
    }

    public static s r(byte[] bArr) {
        return q(new SecretKeySpec((byte[]) com.google.common.base.e0.E(bArr), "HmacSHA256"));
    }

    public static s s(Key key) {
        return new d0("HmacSHA512", key, u("hmacSha512", key));
    }

    public static s t(byte[] bArr) {
        return s(new SecretKeySpec((byte[]) com.google.common.base.e0.E(bArr), "HmacSHA512"));
    }

    private static String u(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    @Deprecated
    public static s v() {
        return e.f21881a;
    }

    public static s w() {
        return f0.f21761b;
    }

    public static s x(int i7) {
        return new f0(i7);
    }

    public static s y() {
        return g0.f21771b;
    }

    public static s z(int i7) {
        return new g0(i7);
    }
}
