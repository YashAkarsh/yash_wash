package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7584h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7585i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7586j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7587k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7588l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7589m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f7590n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f7591o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f7592p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f7593q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final /* synthetic */ boolean f7594r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f7595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f7596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, Integer> f7597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Integer> f7598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f7599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Comparator<b> f7601g;

    class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            byte b8;
            byte b9;
            int i7 = bVar.f7608e;
            int i8 = bVar2.f7608e;
            do {
                b8 = k.this.f7595a.get(i7);
                b9 = k.this.f7595a.get(i8);
                if (b8 == 0) {
                    return b8 - b9;
                }
                i7++;
                i8++;
            } while (b8 == b9);
            return b8 - b9;
        }
    }

    public k(int i7) {
        this(new androidx.emoji2.text.flatbuffer.a(i7), 1);
    }

    private void A(String str, long j7) {
        this.f7596b.add(b.w(u(str), j7));
    }

    static int E(long j7) {
        if (j7 <= j.C0094j.a((byte) -1)) {
            return 0;
        }
        if (j7 <= j.C0094j.c((short) -1)) {
            return 1;
        }
        return j7 <= j.C0094j.b(-1) ? 2 : 3;
    }

    private void F(b bVar, int i7) {
        int i8 = bVar.f7604a;
        if (i8 != 0 && i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                H(bVar.f7606c, i7);
                return;
            } else if (i8 != 26) {
                J(bVar.f7607d, i7);
                return;
            }
        }
        I(bVar.f7607d, i7);
    }

    private b G(int i7, byte[] bArr, int i8, boolean z7) {
        int iE = E(bArr.length);
        I(bArr.length, b(iE));
        int iS = this.f7595a.s();
        this.f7595a.u(bArr, 0, bArr.length);
        if (z7) {
            this.f7595a.v((byte) 0);
        }
        return b.f(i7, iS, i8, iE);
    }

    private void H(double d8, int i7) {
        if (i7 == 4) {
            this.f7595a.d((float) d8);
        } else if (i7 == 8) {
            this.f7595a.a(d8);
        }
    }

    private void I(long j7, int i7) {
        if (i7 == 1) {
            this.f7595a.v((byte) j7);
            return;
        }
        if (i7 == 2) {
            this.f7595a.b((short) j7);
        } else if (i7 == 4) {
            this.f7595a.e((int) j7);
        } else {
            if (i7 != 8) {
                return;
            }
            this.f7595a.f(j7);
        }
    }

    private void J(long j7, int i7) {
        I((int) (((long) this.f7595a.s()) - j7), i7);
    }

    private b K(int i7, String str) {
        return G(i7, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    private int b(int i7) {
        int i8 = 1 << i7;
        int iQ = b.q(this.f7595a.s(), i8);
        while (true) {
            int i9 = iQ - 1;
            if (iQ == 0) {
                return i8;
            }
            this.f7595a.v((byte) 0);
            iQ = i9;
        }
    }

    private b c(int i7, int i8) {
        long j7 = i8;
        int iMax = Math.max(0, E(j7));
        int i9 = i7;
        while (i9 < this.f7596b.size()) {
            i9++;
            iMax = Math.max(iMax, b.i(4, 0, this.f7596b.get(i9).f7608e, this.f7595a.s(), i9));
        }
        int iB = b(iMax);
        I(j7, iB);
        int iS = this.f7595a.s();
        while (i7 < this.f7596b.size()) {
            int i10 = this.f7596b.get(i7).f7608e;
            J(this.f7596b.get(i7).f7608e, iB);
            i7++;
        }
        return new b(-1, j.q(4, 0), iMax, iS);
    }

    private b d(int i7, int i8, int i9, boolean z7, boolean z8, b bVar) {
        int i10;
        int iQ;
        int i11 = i9;
        long j7 = i11;
        int iMax = Math.max(0, E(j7));
        if (bVar != null) {
            iMax = Math.max(iMax, bVar.h(this.f7595a.s(), 0));
            i10 = 3;
        } else {
            i10 = 1;
        }
        int i12 = 4;
        int iMax2 = iMax;
        for (int i13 = i8; i13 < this.f7596b.size(); i13++) {
            iMax2 = Math.max(iMax2, this.f7596b.get(i13).h(this.f7595a.s(), i13 + i10));
            if (z7 && i13 == i8) {
                i12 = this.f7596b.get(i13).f7604a;
                if (!j.l(i12)) {
                    throw new j.b("TypedVector does not support this element type");
                }
            }
        }
        int i14 = i8;
        int iB = b(iMax2);
        if (bVar != null) {
            J(bVar.f7607d, iB);
            I(1 << bVar.f7605b, iB);
        }
        if (!z8) {
            I(j7, iB);
        }
        int iS = this.f7595a.s();
        for (int i15 = i14; i15 < this.f7596b.size(); i15++) {
            F(this.f7596b.get(i15), iB);
        }
        if (!z7) {
            while (i14 < this.f7596b.size()) {
                this.f7595a.v(this.f7596b.get(i14).s(iMax2));
                i14++;
            }
        }
        if (bVar != null) {
            iQ = 9;
        } else if (z7) {
            if (!z8) {
                i11 = 0;
            }
            iQ = j.q(i12, i11);
        } else {
            iQ = 10;
        }
        return new b(i7, iQ, iMax2, iS);
    }

    private int u(String str) {
        if (str == null) {
            return -1;
        }
        int iS = this.f7595a.s();
        if ((this.f7599e & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f7595a.u(bytes, 0, bytes.length);
            this.f7595a.v((byte) 0);
            this.f7597c.put(str, Integer.valueOf(iS));
            return iS;
        }
        Integer num = this.f7597c.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f7595a.u(bytes2, 0, bytes2.length);
        this.f7595a.v((byte) 0);
        this.f7597c.put(str, Integer.valueOf(iS));
        return iS;
    }

    private void z(String str, long j7) {
        b bVarV;
        int iU = u(str);
        int iE = E(j7);
        if (iE == 0) {
            bVarV = b.x(iU, (int) j7);
        } else if (iE == 1) {
            bVarV = b.u(iU, (int) j7);
        } else {
            bVarV = iE == 2 ? b.v(iU, (int) j7) : b.w(iU, j7);
        }
        this.f7596b.add(bVarV);
    }

    public void B(BigInteger bigInteger) {
        A(null, bigInteger.longValue());
    }

    public int C() {
        return this.f7596b.size();
    }

    public int D() {
        return this.f7596b.size();
    }

    public int e(String str, int i7) {
        int iU = u(str);
        ArrayList<b> arrayList = this.f7596b;
        Collections.sort(arrayList.subList(i7, arrayList.size()), this.f7601g);
        b bVarD = d(iU, i7, this.f7596b.size() - i7, false, false, c(i7, this.f7596b.size() - i7));
        while (this.f7596b.size() > i7) {
            ArrayList<b> arrayList2 = this.f7596b;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.f7596b.add(bVarD);
        return (int) bVarD.f7607d;
    }

    public int f(String str, int i7, boolean z7, boolean z8) {
        b bVarD = d(u(str), i7, this.f7596b.size() - i7, z7, z8, null);
        while (this.f7596b.size() > i7) {
            ArrayList<b> arrayList = this.f7596b;
            arrayList.remove(arrayList.size() - 1);
        }
        this.f7596b.add(bVarD);
        return (int) bVarD.f7607d;
    }

    public ByteBuffer g() {
        int iB = b(this.f7596b.get(0).h(this.f7595a.s(), 0));
        F(this.f7596b.get(0), iB);
        this.f7595a.v(this.f7596b.get(0).r());
        this.f7595a.v((byte) iB);
        this.f7600f = true;
        return ByteBuffer.wrap(this.f7595a.m(), 0, this.f7595a.s());
    }

    public r h() {
        return this.f7595a;
    }

    public int i(String str, byte[] bArr) {
        b bVarG = G(u(str), bArr, 25, false);
        this.f7596b.add(bVarG);
        return (int) bVarG.f7607d;
    }

    public int j(byte[] bArr) {
        return i(null, bArr);
    }

    public void k(String str, boolean z7) {
        this.f7596b.add(b.g(u(str), z7));
    }

    public void l(boolean z7) {
        k(null, z7);
    }

    public void m(double d8) {
        o(null, d8);
    }

    public void n(float f8) {
        p(null, f8);
    }

    public void o(String str, double d8) {
        this.f7596b.add(b.k(u(str), d8));
    }

    public void p(String str, float f8) {
        this.f7596b.add(b.j(u(str), f8));
    }

    public void q(int i7) {
        s(null, i7);
    }

    public void r(long j7) {
        t(null, j7);
    }

    public void s(String str, int i7) {
        t(str, i7);
    }

    public void t(String str, long j7) {
        int iU = u(str);
        if (-128 <= j7 && j7 <= 127) {
            this.f7596b.add(b.o(iU, (int) j7));
            return;
        }
        if (-32768 <= j7 && j7 <= 32767) {
            this.f7596b.add(b.l(iU, (int) j7));
        } else if (-2147483648L > j7 || j7 > 2147483647L) {
            this.f7596b.add(b.n(iU, j7));
        } else {
            this.f7596b.add(b.m(iU, (int) j7));
        }
    }

    public int v(String str) {
        return w(null, str);
    }

    public int w(String str, String str2) {
        int iU = u(str);
        if ((this.f7599e & 2) == 0) {
            b bVarK = K(iU, str2);
            this.f7596b.add(bVarK);
            return (int) bVarK.f7607d;
        }
        Integer num = this.f7598d.get(str2);
        if (num != null) {
            this.f7596b.add(b.f(iU, num.intValue(), 5, E(str2.length())));
            return num.intValue();
        }
        b bVarK2 = K(iU, str2);
        this.f7598d.put(str2, Integer.valueOf((int) bVarK2.f7607d));
        this.f7596b.add(bVarK2);
        return (int) bVarK2.f7607d;
    }

    public void x(int i7) {
        z(null, i7);
    }

    public void y(long j7) {
        z(null, j7);
    }

    public k() {
        this(256);
    }

    @Deprecated
    public k(ByteBuffer byteBuffer, int i7) {
        this(new androidx.emoji2.text.flatbuffer.a(byteBuffer.array()), i7);
    }

    public k(r rVar, int i7) {
        this.f7596b = new ArrayList<>();
        this.f7597c = new HashMap<>();
        this.f7598d = new HashMap<>();
        this.f7600f = false;
        this.f7601g = new a();
        this.f7595a = rVar;
        this.f7599e = i7;
    }

    private static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ boolean f7603f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f7604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f7605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final double f7606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f7607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7608e;

        b(int i7, int i8, int i9, long j7) {
            this.f7608e = i7;
            this.f7604a = i8;
            this.f7605b = i9;
            this.f7607d = j7;
            this.f7606c = Double.MIN_VALUE;
        }

        static b f(int i7, int i8, int i9, int i10) {
            return new b(i7, i9, i10, i8);
        }

        static b g(int i7, boolean z7) {
            return new b(i7, 26, 0, z7 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i7, int i8) {
            return i(this.f7604a, this.f7605b, this.f7607d, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int i(int i7, int i8, long j7, int i9, int i10) {
            if (j.j(i7)) {
                return i8;
            }
            for (int i11 = 1; i11 <= 32; i11 *= 2) {
                int iE = k.E((int) (((long) ((q(i9, i11) + i9) + (i10 * i11))) - j7));
                if ((1 << iE) == i11) {
                    return iE;
                }
            }
            return 3;
        }

        static b j(int i7, float f8) {
            return new b(i7, 3, 2, f8);
        }

        static b k(int i7, double d8) {
            return new b(i7, 3, 3, d8);
        }

        static b l(int i7, int i8) {
            return new b(i7, 1, 1, i8);
        }

        static b m(int i7, int i8) {
            return new b(i7, 1, 2, i8);
        }

        static b n(int i7, long j7) {
            return new b(i7, 1, 3, j7);
        }

        static b o(int i7, int i8) {
            return new b(i7, 1, 0, i8);
        }

        private static byte p(int i7, int i8) {
            return (byte) (i7 | (i8 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int q(int i7, int i8) {
            return ((~i7) + 1) & (i8 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte r() {
            return s(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte s(int i7) {
            return p(t(i7), this.f7604a);
        }

        private int t(int i7) {
            return j.j(this.f7604a) ? Math.max(this.f7605b, i7) : this.f7605b;
        }

        static b u(int i7, int i8) {
            return new b(i7, 2, 1, i8);
        }

        static b v(int i7, int i8) {
            return new b(i7, 2, 2, i8);
        }

        static b w(int i7, long j7) {
            return new b(i7, 2, 3, j7);
        }

        static b x(int i7, int i8) {
            return new b(i7, 2, 0, i8);
        }

        b(int i7, int i8, int i9, double d8) {
            this.f7608e = i7;
            this.f7604a = i8;
            this.f7605b = i9;
            this.f7606c = d8;
            this.f7607d = Long.MIN_VALUE;
        }
    }

    public k(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
