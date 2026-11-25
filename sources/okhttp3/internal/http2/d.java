package okhttp3.internal.http2;

import com.haier.uhome.account.api.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.g0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okio.a0;
import okio.o;
import okio.o0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37973a = 15;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37974b = 31;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37975c = 63;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f37976d = 127;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f37977e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f37978f = 16384;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private static final c[] f37979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private static final Map<p, Integer> f37980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f37981i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f37982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f37983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        @h5.e
        public c[] f37984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f37985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @h5.e
        public int f37986e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @h5.e
        public int f37987f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f37988g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f37989h;

        @h5.i
        public a(@a7.d o0 o0Var, int i7) {
            this(o0Var, i7, 0, 4, null);
        }

        private final void a() {
            int i7 = this.f37989h;
            int i8 = this.f37987f;
            if (i7 < i8) {
                if (i7 == 0) {
                    b();
                } else {
                    d(i8 - i7);
                }
            }
        }

        private final void b() {
            kotlin.collections.o.w2(this.f37984c, null, 0, 0, 6, null);
            this.f37985d = this.f37984c.length - 1;
            this.f37986e = 0;
            this.f37987f = 0;
        }

        private final int c(int i7) {
            return this.f37985d + 1 + i7;
        }

        private final int d(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f37984c.length;
                while (true) {
                    length--;
                    i8 = this.f37985d;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    c cVar = this.f37984c[length];
                    l0.m(cVar);
                    int i10 = cVar.f37970a;
                    i7 -= i10;
                    this.f37987f -= i10;
                    this.f37986e--;
                    i9++;
                }
                c[] cVarArr = this.f37984c;
                System.arraycopy(cVarArr, i8 + 1, cVarArr, i8 + 1 + i9, this.f37986e);
                this.f37985d += i9;
            }
            return i9;
        }

        private final p f(int i7) throws IOException {
            if (h(i7)) {
                return d.f37981i.c()[i7].f37971b;
            }
            int iC = c(i7 - d.f37981i.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.f37984c;
                if (iC < cVarArr.length) {
                    c cVar = cVarArr[iC];
                    l0.m(cVar);
                    return cVar.f37971b;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        private final void g(int i7, c cVar) {
            this.f37982a.add(cVar);
            int i8 = cVar.f37970a;
            if (i7 != -1) {
                c cVar2 = this.f37984c[c(i7)];
                l0.m(cVar2);
                i8 -= cVar2.f37970a;
            }
            int i9 = this.f37989h;
            if (i8 > i9) {
                b();
                return;
            }
            int iD = d((this.f37987f + i8) - i9);
            if (i7 == -1) {
                int i10 = this.f37986e + 1;
                c[] cVarArr = this.f37984c;
                if (i10 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f37985d = this.f37984c.length - 1;
                    this.f37984c = cVarArr2;
                }
                int i11 = this.f37985d;
                this.f37985d = i11 - 1;
                this.f37984c[i11] = cVar;
                this.f37986e++;
            } else {
                this.f37984c[i7 + c(i7) + iD] = cVar;
            }
            this.f37987f += i8;
        }

        private final boolean h(int i7) {
            return i7 >= 0 && i7 <= d.f37981i.c().length - 1;
        }

        private final int j() throws IOException {
            return okhttp3.internal.d.b(this.f37983b.readByte(), 255);
        }

        private final void m(int i7) throws IOException {
            if (h(i7)) {
                this.f37982a.add(d.f37981i.c()[i7]);
                return;
            }
            int iC = c(i7 - d.f37981i.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.f37984c;
                if (iC < cVarArr.length) {
                    List<c> list = this.f37982a;
                    c cVar = cVarArr[iC];
                    l0.m(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        private final void o(int i7) throws IOException {
            g(-1, new c(f(i7), k()));
        }

        private final void p() throws IOException {
            g(-1, new c(d.f37981i.a(k()), k()));
        }

        private final void q(int i7) throws IOException {
            this.f37982a.add(new c(f(i7), k()));
        }

        private final void r() throws IOException {
            this.f37982a.add(new c(d.f37981i.a(k()), k()));
        }

        @a7.d
        public final List<c> e() {
            List<c> listQ5 = g0.Q5(this.f37982a);
            this.f37982a.clear();
            return listQ5;
        }

        public final int i() {
            return this.f37989h;
        }

        @a7.d
        public final p k() throws IOException {
            int iJ = j();
            boolean z7 = (iJ & 128) == 128;
            long jN = n(iJ, 127);
            if (!z7) {
                return this.f37983b.l(jN);
            }
            okio.m mVar = new okio.m();
            k.f38198d.b(this.f37983b, jN, mVar);
            return mVar.E0();
        }

        public final void l() throws IOException {
            while (!this.f37983b.N()) {
                int iB = okhttp3.internal.d.b(this.f37983b.readByte(), 255);
                if (iB == 128) {
                    throw new IOException("index == 0");
                }
                if ((iB & 128) == 128) {
                    m(n(iB, 127) - 1);
                } else if (iB == 64) {
                    p();
                } else if ((iB & 64) == 64) {
                    o(n(iB, 63) - 1);
                } else if ((iB & 32) == 32) {
                    int iN = n(iB, 31);
                    this.f37989h = iN;
                    if (iN < 0 || iN > this.f37988g) {
                        throw new IOException("Invalid dynamic table size update " + this.f37989h);
                    }
                    a();
                } else if (iB == 16 || iB == 0) {
                    r();
                } else {
                    q(n(iB, 15) - 1);
                }
            }
        }

        public final int n(int i7, int i8) throws IOException {
            int i9 = i7 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i8 + (iJ << i10);
                }
                i8 += (iJ & 127) << i10;
                i10 += 7;
            }
        }

        @h5.i
        public a(@a7.d o0 source, int i7, int i8) {
            l0.p(source, "source");
            this.f37988g = i7;
            this.f37989h = i8;
            this.f37982a = new ArrayList();
            this.f37983b = a0.d(source);
            c[] cVarArr = new c[8];
            this.f37984c = cVarArr;
            this.f37985d = cVarArr.length - 1;
        }

        public /* synthetic */ a(o0 o0Var, int i7, int i8, int i9, w wVar) {
            this(o0Var, i7, (i9 & 4) != 0 ? i7 : i8);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        public int f37992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public c[] f37993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @h5.e
        public int f37995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @h5.e
        public int f37996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @h5.e
        public int f37997h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f37998i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final okio.m f37999j;

        @h5.i
        public b(int i7, @a7.d okio.m mVar) {
            this(i7, false, mVar, 2, null);
        }

        private final void a() {
            int i7 = this.f37992c;
            int i8 = this.f37996g;
            if (i7 < i8) {
                if (i7 == 0) {
                    b();
                } else {
                    c(i8 - i7);
                }
            }
        }

        private final void b() {
            kotlin.collections.o.w2(this.f37993d, null, 0, 0, 6, null);
            this.f37994e = this.f37993d.length - 1;
            this.f37995f = 0;
            this.f37996g = 0;
        }

        private final int c(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f37993d.length;
                while (true) {
                    length--;
                    i8 = this.f37994e;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    c cVar = this.f37993d[length];
                    l0.m(cVar);
                    i7 -= cVar.f37970a;
                    int i10 = this.f37996g;
                    c cVar2 = this.f37993d[length];
                    l0.m(cVar2);
                    this.f37996g = i10 - cVar2.f37970a;
                    this.f37995f--;
                    i9++;
                }
                c[] cVarArr = this.f37993d;
                System.arraycopy(cVarArr, i8 + 1, cVarArr, i8 + 1 + i9, this.f37995f);
                c[] cVarArr2 = this.f37993d;
                int i11 = this.f37994e;
                Arrays.fill(cVarArr2, i11 + 1, i11 + 1 + i9, (Object) null);
                this.f37994e += i9;
            }
            return i9;
        }

        private final void d(c cVar) {
            int i7 = cVar.f37970a;
            int i8 = this.f37992c;
            if (i7 > i8) {
                b();
                return;
            }
            c((this.f37996g + i7) - i8);
            int i9 = this.f37995f + 1;
            c[] cVarArr = this.f37993d;
            if (i9 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f37994e = this.f37993d.length - 1;
                this.f37993d = cVarArr2;
            }
            int i10 = this.f37994e;
            this.f37994e = i10 - 1;
            this.f37993d[i10] = cVar;
            this.f37995f++;
            this.f37996g += i7;
        }

        public final void e(int i7) {
            this.f37997h = i7;
            int iMin = Math.min(i7, 16384);
            int i8 = this.f37992c;
            if (i8 == iMin) {
                return;
            }
            if (iMin < i8) {
                this.f37990a = Math.min(this.f37990a, iMin);
            }
            this.f37991b = true;
            this.f37992c = iMin;
            a();
        }

        public final void f(@a7.d p data) throws IOException {
            l0.p(data, "data");
            if (this.f37998i) {
                k kVar = k.f38198d;
                if (kVar.d(data) < data.a0()) {
                    okio.m mVar = new okio.m();
                    kVar.c(data, mVar);
                    p pVarE0 = mVar.E0();
                    h(pVarE0.a0(), 127, 128);
                    this.f37999j.p1(pVarE0);
                    return;
                }
            }
            h(data.a0(), 127, 0);
            this.f37999j.p1(data);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x007a  */
        public final void g(@a7.d List<c> headerBlock) throws IOException {
            int length;
            int length2;
            l0.p(headerBlock, "headerBlock");
            if (this.f37991b) {
                int i7 = this.f37990a;
                if (i7 < this.f37992c) {
                    h(i7, 31, 32);
                }
                this.f37991b = false;
                this.f37990a = Integer.MAX_VALUE;
                h(this.f37992c, 31, 32);
            }
            int size = headerBlock.size();
            for (int i8 = 0; i8 < size; i8++) {
                c cVar = headerBlock.get(i8);
                p pVarI0 = cVar.f37971b.i0();
                p pVar = cVar.f37972c;
                d dVar = d.f37981i;
                Integer num = dVar.b().get(pVarI0);
                if (num != null) {
                    length2 = num.intValue() + 1;
                    if (2 > length2 || 7 < length2) {
                        length = length2;
                        length2 = -1;
                    } else if (l0.g(dVar.c()[length2 - 1].f37972c, pVar)) {
                        length = length2;
                    } else if (l0.g(dVar.c()[length2].f37972c, pVar)) {
                        length2++;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.f37993d.length;
                    for (int i9 = this.f37994e + 1; i9 < length3; i9++) {
                        c cVar2 = this.f37993d[i9];
                        l0.m(cVar2);
                        if (l0.g(cVar2.f37971b, pVarI0)) {
                            c cVar3 = this.f37993d[i9];
                            l0.m(cVar3);
                            if (l0.g(cVar3.f37972c, pVar)) {
                                length2 = d.f37981i.c().length + (i9 - this.f37994e);
                                break;
                            } else if (length == -1) {
                                length = (i9 - this.f37994e) + d.f37981i.c().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    h(length2, 127, 128);
                } else if (length == -1) {
                    this.f37999j.writeByte(64);
                    f(pVarI0);
                    f(pVar);
                    d(cVar);
                } else if (pVarI0.b0(c.f37958d) && (!l0.g(c.f37968n, pVarI0))) {
                    h(length, 15, 0);
                    f(pVar);
                } else {
                    h(length, 63, 64);
                    f(pVar);
                    d(cVar);
                }
            }
        }

        public final void h(int i7, int i8, int i9) {
            if (i7 < i8) {
                this.f37999j.writeByte(i7 | i9);
                return;
            }
            this.f37999j.writeByte(i9 | i8);
            int i10 = i7 - i8;
            while (i10 >= 128) {
                this.f37999j.writeByte(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.f37999j.writeByte(i10);
        }

        @h5.i
        public b(@a7.d okio.m mVar) {
            this(0, false, mVar, 3, null);
        }

        @h5.i
        public b(int i7, boolean z7, @a7.d okio.m out) {
            l0.p(out, "out");
            this.f37997h = i7;
            this.f37998i = z7;
            this.f37999j = out;
            this.f37990a = Integer.MAX_VALUE;
            this.f37992c = i7;
            c[] cVarArr = new c[8];
            this.f37993d = cVarArr;
            this.f37994e = cVarArr.length - 1;
        }

        public /* synthetic */ b(int i7, boolean z7, okio.m mVar, int i8, w wVar) {
            this((i8 & 1) != 0 ? 4096 : i7, (i8 & 2) != 0 ? true : z7, mVar);
        }
    }

    static {
        d dVar = new d();
        f37981i = dVar;
        p pVar = c.f37965k;
        p pVar2 = c.f37966l;
        p pVar3 = c.f37967m;
        p pVar4 = c.f37964j;
        f37979g = new c[]{new c(c.f37968n, ""), new c(pVar, Const.HTTP_REQUEST_TYPE_GET), new c(pVar, Const.HTTP_REQUEST_TYPE_POST), new c(pVar2, "/"), new c(pVar2, "/index.html"), new c(pVar3, com.haier.uhome.usdk.base.a.av), new c(pVar3, j0.b.f34226a), new c(pVar4, "200"), new c(pVar4, "204"), new c(pVar4, "206"), new c(pVar4, "304"), new c(pVar4, "400"), new c(pVar4, "404"), new c(pVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c(com.alipay.sdk.packet.e.f13726f, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c(androidx.constraintlayout.core.motion.utils.w.h.f3145c, ""), new c(j0.c.f34242f, ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c(com.alipay.sdk.widget.j.f13873s, ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f37980h = dVar.d();
    }

    private d() {
    }

    private final Map<p, Integer> d() {
        c[] cVarArr = f37979g;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            c[] cVarArr2 = f37979g;
            if (!linkedHashMap.containsKey(cVarArr2[i7].f37971b)) {
                linkedHashMap.put(cVarArr2[i7].f37971b, Integer.valueOf(i7));
            }
        }
        Map<p, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        l0.o(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    @a7.d
    public final p a(@a7.d p name) throws IOException {
        l0.p(name, "name");
        int iA0 = name.a0();
        for (int i7 = 0; i7 < iA0; i7++) {
            byte b8 = (byte) 65;
            byte b9 = (byte) 90;
            byte bN = name.n(i7);
            if (b8 <= bN && b9 >= bN) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.l0());
            }
        }
        return name;
    }

    @a7.d
    public final Map<p, Integer> b() {
        return f37980h;
    }

    @a7.d
    public final c[] c() {
        return f37979g;
    }
}
