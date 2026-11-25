package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.g2;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static final int A = 26;
    public static final int B = 36;
    private static final q C = new androidx.emoji2.text.flatbuffer.a(new byte[]{0}, 1);
    static final /* synthetic */ boolean D = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7540a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7541b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7542c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7543d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7544e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7545f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7546g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7547h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7548i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7549j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7550k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7551l = 11;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7552m = 12;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7553n = 13;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7554o = 14;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7555p = 15;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7556q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7557r = 17;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7558s = 18;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7559t = 19;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f7560u = 20;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7561v = 21;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f7562w = 22;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f7563x = 23;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f7564y = 24;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f7565z = 25;

    public static class a extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final a f7566e = new a(j.C, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ boolean f7567f = false;

        a(q qVar, int i7, int i8) {
            super(qVar, i7, i8);
        }

        public static a d() {
            return f7566e;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public StringBuilder a(StringBuilder sb) {
            sb.append(h0.f35376b);
            sb.append(this.f7571a.n(this.f7572b, b()));
            sb.append(h0.f35376b);
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.h
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public ByteBuffer c() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f7571a.m());
            byteBufferWrap.position(this.f7572b);
            byteBufferWrap.limit(this.f7572b + b());
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte e(int i7) {
            return this.f7571a.get(this.f7572b + i7);
        }

        public byte[] f() {
            int iB = b();
            byte[] bArr = new byte[iB];
            for (int i7 = 0; i7 < iB; i7++) {
                bArr[i7] = this.f7571a.get(this.f7572b + i7);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public String toString() {
            return this.f7571a.n(this.f7572b, b());
        }
    }

    public static class b extends RuntimeException {
        b(String str) {
            super(str);
        }
    }

    public static class c extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final c f7568d = new c(j.C, 0, 0);

        c(q qVar, int i7, int i8) {
            super(qVar, i7, i8);
        }

        public static c d() {
            return f7568d;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public StringBuilder a(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        int c(byte[] bArr) {
            byte b8;
            byte b9;
            int i7 = this.f7572b;
            int i8 = 0;
            do {
                b8 = this.f7571a.get(i7);
                b9 = bArr[i8];
                if (b8 == 0) {
                    return b8 - b9;
                }
                i7++;
                i8++;
                if (i8 == bArr.length) {
                    return b8 - b9;
                }
            } while (b8 == b9);
            return b8 - b9;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f7572b == this.f7572b && cVar.f7573c == this.f7573c;
        }

        public int hashCode() {
            return this.f7572b ^ this.f7573c;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public String toString() {
            int i7 = this.f7572b;
            while (this.f7571a.get(i7) != 0) {
                i7++;
            }
            int i8 = this.f7572b;
            return this.f7571a.n(i8, i7 - i8);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f7569a;

        d(i iVar) {
            this.f7569a = iVar;
        }

        public c a(int i7) {
            if (i7 >= b()) {
                return c.f7568d;
            }
            i iVar = this.f7569a;
            int i8 = iVar.f7572b + (i7 * iVar.f7573c);
            i iVar2 = this.f7569a;
            q qVar = iVar2.f7571a;
            return new c(qVar, j.i(qVar, i8, iVar2.f7573c), 1);
        }

        public int b() {
            return this.f7569a.b();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i7 = 0; i7 < this.f7569a.b(); i7++) {
                this.f7569a.d(i7).z(sb);
                if (i7 != this.f7569a.b() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class e extends k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final e f7570f = new e(j.C, 1, 1);

        e(q qVar, int i7, int i8) {
            super(qVar, i7, i8);
        }

        private int f(d dVar, byte[] bArr) {
            int iB = dVar.b() - 1;
            int i7 = 0;
            while (i7 <= iB) {
                int i8 = (i7 + iB) >>> 1;
                int iC = dVar.a(i8).c(bArr);
                if (iC < 0) {
                    i7 = i8 + 1;
                } else {
                    if (iC <= 0) {
                        return i8;
                    }
                    iB = i8 - 1;
                }
            }
            return -(i7 + 1);
        }

        public static e g() {
            return f7570f;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.k, androidx.emoji2.text.flatbuffer.j.f
        public StringBuilder a(StringBuilder sb) {
            sb.append("{ ");
            d dVarJ = j();
            int iB = b();
            k kVarK = k();
            for (int i7 = 0; i7 < iB; i7++) {
                sb.append(h0.f35376b);
                sb.append(dVarJ.a(i7).toString());
                sb.append("\" : ");
                sb.append(kVarK.d(i7).toString());
                if (i7 != iB - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public g h(String str) {
            return i(str.getBytes(StandardCharsets.UTF_8));
        }

        public g i(byte[] bArr) {
            d dVarJ = j();
            int iB = dVarJ.b();
            int iF = f(dVarJ, bArr);
            return (iF < 0 || iF >= iB) ? g.f7574f : d(iF);
        }

        public d j() {
            int i7 = this.f7572b - (this.f7573c * 3);
            q qVar = this.f7571a;
            int i8 = j.i(qVar, i7, this.f7573c);
            q qVar2 = this.f7571a;
            int i9 = this.f7573c;
            return new d(new i(qVar, i8, j.n(qVar2, i7 + i9, i9), 4));
        }

        public k k() {
            return new k(this.f7571a, this.f7572b, this.f7573c);
        }
    }

    private static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        q f7571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7573c;

        f(q qVar, int i7, int i8) {
            this.f7571a = qVar;
            this.f7572b = i7;
            this.f7573c = i8;
        }

        public abstract StringBuilder a(StringBuilder sb);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final g f7574f = new g(j.C, 0, 1, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q f7575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f7579e;

        g(q qVar, int i7, int i8, int i9) {
            this(qVar, i7, i8, 1 << (i9 & 3), i9 >> 2);
        }

        public a b() {
            if (!m() && !v()) {
                return a.d();
            }
            q qVar = this.f7575a;
            return new a(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
        }

        public boolean c() {
            if (n()) {
                return this.f7575a.get(this.f7576b) != 0;
            }
            return j() != 0;
        }

        public double d() {
            int i7 = this.f7579e;
            if (i7 == 3) {
                return j.m(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 1) {
                return j.n(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 != 2) {
                if (i7 == 5) {
                    return Double.parseDouble(i());
                }
                if (i7 == 6) {
                    q qVar = this.f7575a;
                    return j.n(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
                }
                if (i7 == 7) {
                    q qVar2 = this.f7575a;
                    return j.p(qVar2, j.i(qVar2, this.f7576b, this.f7577c), this.f7578d);
                }
                if (i7 == 8) {
                    q qVar3 = this.f7575a;
                    return j.m(qVar3, j.i(qVar3, this.f7576b, this.f7577c), this.f7578d);
                }
                if (i7 == 10) {
                    return k().b();
                }
                if (i7 != 26) {
                    return 0.0d;
                }
            }
            return j.p(this.f7575a, this.f7576b, this.f7577c);
        }

        public int e() {
            int i7 = this.f7579e;
            if (i7 == 1) {
                return j.n(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 2) {
                return (int) j.p(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 3) {
                return (int) j.m(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 5) {
                return Integer.parseInt(i());
            }
            if (i7 == 6) {
                q qVar = this.f7575a;
                return j.n(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 == 7) {
                q qVar2 = this.f7575a;
                return (int) j.p(qVar2, j.i(qVar2, this.f7576b, this.f7577c), this.f7577c);
            }
            if (i7 == 8) {
                q qVar3 = this.f7575a;
                return (int) j.m(qVar3, j.i(qVar3, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 == 10) {
                return k().b();
            }
            if (i7 != 26) {
                return 0;
            }
            return j.n(this.f7575a, this.f7576b, this.f7577c);
        }

        public c f() {
            if (!r()) {
                return c.d();
            }
            q qVar = this.f7575a;
            return new c(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
        }

        public long g() {
            int i7 = this.f7579e;
            if (i7 == 1) {
                return j.o(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 2) {
                return j.p(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 3) {
                return (long) j.m(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 5) {
                try {
                    return Long.parseLong(i());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i7 == 6) {
                q qVar = this.f7575a;
                return j.o(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 == 7) {
                q qVar2 = this.f7575a;
                return j.p(qVar2, j.i(qVar2, this.f7576b, this.f7577c), this.f7577c);
            }
            if (i7 == 8) {
                q qVar3 = this.f7575a;
                return (long) j.m(qVar3, j.i(qVar3, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 == 10) {
                return k().b();
            }
            if (i7 != 26) {
                return 0L;
            }
            return j.n(this.f7575a, this.f7576b, this.f7577c);
        }

        public e h() {
            if (!s()) {
                return e.g();
            }
            q qVar = this.f7575a;
            return new e(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
        }

        public String i() {
            if (v()) {
                int i7 = j.i(this.f7575a, this.f7576b, this.f7577c);
                q qVar = this.f7575a;
                int i8 = this.f7578d;
                return this.f7575a.n(i7, (int) j.p(qVar, i7 - i8, i8));
            }
            if (!r()) {
                return "";
            }
            int i9 = j.i(this.f7575a, this.f7576b, this.f7578d);
            int i10 = i9;
            while (this.f7575a.get(i10) != 0) {
                i10++;
            }
            return this.f7575a.n(i9, i10 - i9);
        }

        public long j() {
            int i7 = this.f7579e;
            if (i7 == 2) {
                return j.p(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 1) {
                return j.o(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 3) {
                return (long) j.m(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 10) {
                return k().b();
            }
            if (i7 == 26) {
                return j.n(this.f7575a, this.f7576b, this.f7577c);
            }
            if (i7 == 5) {
                return Long.parseLong(i());
            }
            if (i7 == 6) {
                q qVar = this.f7575a;
                return j.o(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 == 7) {
                q qVar2 = this.f7575a;
                return j.p(qVar2, j.i(qVar2, this.f7576b, this.f7577c), this.f7578d);
            }
            if (i7 != 8) {
                return 0L;
            }
            q qVar3 = this.f7575a;
            return (long) j.m(qVar3, j.i(qVar3, this.f7576b, this.f7577c), this.f7577c);
        }

        public k k() {
            if (y()) {
                q qVar = this.f7575a;
                return new k(qVar, j.i(qVar, this.f7576b, this.f7577c), this.f7578d);
            }
            int i7 = this.f7579e;
            if (i7 == 15) {
                q qVar2 = this.f7575a;
                return new i(qVar2, j.i(qVar2, this.f7576b, this.f7577c), this.f7578d, 4);
            }
            if (!j.k(i7)) {
                return k.c();
            }
            q qVar3 = this.f7575a;
            return new i(qVar3, j.i(qVar3, this.f7576b, this.f7577c), this.f7578d, j.r(this.f7579e));
        }

        public int l() {
            return this.f7579e;
        }

        public boolean m() {
            return this.f7579e == 25;
        }

        public boolean n() {
            return this.f7579e == 26;
        }

        public boolean o() {
            int i7 = this.f7579e;
            return i7 == 3 || i7 == 8;
        }

        public boolean p() {
            int i7 = this.f7579e;
            return i7 == 1 || i7 == 6;
        }

        public boolean q() {
            return p() || x();
        }

        public boolean r() {
            return this.f7579e == 4;
        }

        public boolean s() {
            return this.f7579e == 9;
        }

        public boolean t() {
            return this.f7579e == 0;
        }

        public String toString() {
            return z(new StringBuilder(128)).toString();
        }

        public boolean u() {
            return q() || o();
        }

        public boolean v() {
            return this.f7579e == 5;
        }

        public boolean w() {
            return j.k(this.f7579e);
        }

        public boolean x() {
            int i7 = this.f7579e;
            return i7 == 2 || i7 == 7;
        }

        public boolean y() {
            int i7 = this.f7579e;
            return i7 == 10 || i7 == 9;
        }

        StringBuilder z(StringBuilder sb) {
            int i7 = this.f7579e;
            if (i7 != 36) {
                switch (i7) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(g());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(j());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(d());
                        return sb;
                    case 4:
                        c cVarF = f();
                        sb.append(h0.f35376b);
                        StringBuilder sbA = cVarF.a(sb);
                        sbA.append(h0.f35376b);
                        return sbA;
                    case 5:
                        sb.append(h0.f35376b);
                        sb.append(i());
                        sb.append(h0.f35376b);
                        return sb;
                    case 9:
                        return h().a(sb);
                    case 10:
                        return k().a(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new b("not_implemented:" + this.f7579e);
                    case 25:
                        return b().a(sb);
                    case 26:
                        sb.append(c());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(k());
            return sb;
        }

        g(q qVar, int i7, int i8, int i9, int i10) {
            this.f7575a = qVar;
            this.f7576b = i7;
            this.f7577c = i8;
            this.f7578d = i9;
            this.f7579e = i10;
        }
    }

    private static abstract class h extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final int f7580d;

        h(q qVar, int i7, int i8) {
            super(qVar, i7, i8);
            this.f7580d = j.n(this.f7571a, i7 - i8, i8);
        }

        public int b() {
            return this.f7580d;
        }
    }

    public static class i extends k {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final i f7581g = new i(j.C, 1, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f7582f;

        i(q qVar, int i7, int i8, int i9) {
            super(qVar, i7, i8);
            this.f7582f = i9;
        }

        public static i f() {
            return f7581g;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.k
        public g d(int i7) {
            if (i7 >= b()) {
                return g.f7574f;
            }
            return new g(this.f7571a, this.f7572b + (i7 * this.f7573c), this.f7573c, 1, this.f7582f);
        }

        public int g() {
            return this.f7582f;
        }

        public boolean h() {
            return this == f7581g;
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.flatbuffer.j$j, reason: collision with other inner class name */
    static class C0094j {
        C0094j() {
        }

        static int a(byte b8) {
            return b8 & 255;
        }

        static long b(int i7) {
            return ((long) i7) & 4294967295L;
        }

        static int c(short s7) {
            return s7 & g2.f34732d;
        }
    }

    public static class k extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final k f7583e = new k(j.C, 1, 1);

        k(q qVar, int i7, int i8) {
            super(qVar, i7, i8);
        }

        public static k c() {
            return f7583e;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public StringBuilder a(StringBuilder sb) {
            sb.append("[ ");
            int iB = b();
            for (int i7 = 0; i7 < iB; i7++) {
                d(i7).z(sb);
                if (i7 != iB - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.h
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public g d(int i7) {
            long jB = b();
            long j7 = i7;
            if (j7 >= jB) {
                return g.f7574f;
            }
            return new g(this.f7571a, this.f7572b + (i7 * this.f7573c), this.f7573c, C0094j.a(this.f7571a.get((int) (((long) this.f7572b) + (jB * ((long) this.f7573c)) + j7))));
        }

        public boolean e() {
            return this == f7583e;
        }

        @Override // androidx.emoji2.text.flatbuffer.j.f
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static g g(q qVar) {
        int iG = qVar.g() - 1;
        byte b8 = qVar.get(iG);
        int i7 = iG - 1;
        return new g(qVar, i7 - b8, b8, C0094j.a(qVar.get(i7)));
    }

    @Deprecated
    public static g h(ByteBuffer byteBuffer) {
        return g(byteBuffer.hasArray() ? new androidx.emoji2.text.flatbuffer.a(byteBuffer.array(), byteBuffer.limit()) : new androidx.emoji2.text.flatbuffer.d(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(q qVar, int i7, int i8) {
        return (int) (((long) i7) - p(qVar, i7, i8));
    }

    static boolean j(int i7) {
        return i7 <= 3 || i7 == 26;
    }

    static boolean k(int i7) {
        return (i7 >= 11 && i7 <= 15) || i7 == 36;
    }

    static boolean l(int i7) {
        return (i7 >= 1 && i7 <= 4) || i7 == 26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double m(q qVar, int i7, int i8) {
        if (i8 == 4) {
            return qVar.getFloat(i7);
        }
        if (i8 != 8) {
            return -1.0d;
        }
        return qVar.getDouble(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(q qVar, int i7, int i8) {
        return (int) o(qVar, i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o(q qVar, int i7, int i8) {
        int i9;
        if (i8 == 1) {
            i9 = qVar.get(i7);
        } else if (i8 == 2) {
            i9 = qVar.getShort(i7);
        } else {
            if (i8 != 4) {
                if (i8 != 8) {
                    return -1L;
                }
                return qVar.getLong(i7);
            }
            i9 = qVar.getInt(i7);
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long p(q qVar, int i7, int i8) {
        if (i8 == 1) {
            return C0094j.a(qVar.get(i7));
        }
        if (i8 == 2) {
            return C0094j.c(qVar.getShort(i7));
        }
        if (i8 == 4) {
            return C0094j.b(qVar.getInt(i7));
        }
        if (i8 != 8) {
            return -1L;
        }
        return qVar.getLong(i7);
    }

    static int q(int i7, int i8) {
        if (i8 == 0) {
            return (i7 - 1) + 11;
        }
        if (i8 == 2) {
            return (i7 - 1) + 16;
        }
        if (i8 == 3) {
            return (i7 - 1) + 19;
        }
        if (i8 != 4) {
            return 0;
        }
        return (i7 - 1) + 22;
    }

    static int r(int i7) {
        return (i7 - 11) + 1;
    }
}
