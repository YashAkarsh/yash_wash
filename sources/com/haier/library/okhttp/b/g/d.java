package com.haier.library.okhttp.b.g;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.library.a.c0;
import com.haier.library.a.t;
import com.haier.uhome.account.api.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f27155a = 15;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f27156b = 31;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f27157c = 63;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f27158d = 127;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c[] f27159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Map<com.haier.library.a.j, Integer> f27160f;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f27161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.haier.library.a.i f27162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f27164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c[] f27165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f27166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f27167g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f27168h;

        a(int i7, c0 c0Var) {
            this(i7, i7, c0Var);
        }

        private int b(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f27165e.length;
                while (true) {
                    length--;
                    i8 = this.f27166f;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f27165e[length].f27154c;
                    i7 -= i10;
                    this.f27168h -= i10;
                    this.f27167g--;
                    i9++;
                }
                c[] cVarArr = this.f27165e;
                System.arraycopy(cVarArr, i8 + 1, cVarArr, i8 + 1 + i9, this.f27167g);
                this.f27166f += i9;
            }
            return i9;
        }

        private void d(int i7, c cVar) {
            this.f27161a.add(cVar);
            int i8 = cVar.f27154c;
            if (i7 != -1) {
                i8 -= this.f27165e[g(i7)].f27154c;
            }
            int i9 = this.f27164d;
            if (i8 > i9) {
                n();
                return;
            }
            int iB = b((this.f27168h + i8) - i9);
            if (i7 == -1) {
                int i10 = this.f27167g + 1;
                c[] cVarArr = this.f27165e;
                if (i10 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f27166f = this.f27165e.length - 1;
                    this.f27165e = cVarArr2;
                }
                int i11 = this.f27166f;
                this.f27166f = i11 - 1;
                this.f27165e[i11] = cVar;
                this.f27167g++;
            } else {
                this.f27165e[i7 + g(i7) + iB] = cVar;
            }
            this.f27168h += i8;
        }

        private void f(int i7) throws IOException {
            if (p(i7)) {
                this.f27161a.add(d.f27159e[i7]);
                return;
            }
            int iG = g(i7 - d.f27159e.length);
            if (iG >= 0) {
                c[] cVarArr = this.f27165e;
                if (iG < cVarArr.length) {
                    this.f27161a.add(cVarArr[iG]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        private int g(int i7) {
            return this.f27166f + 1 + i7;
        }

        private void j(int i7) throws IOException {
            this.f27161a.add(new c(m(i7), i()));
        }

        private void k() {
            int i7 = this.f27164d;
            int i8 = this.f27168h;
            if (i7 < i8) {
                if (i7 == 0) {
                    n();
                } else {
                    b(i8 - i7);
                }
            }
        }

        private void l(int i7) throws IOException {
            d(-1, new c(m(i7), i()));
        }

        private com.haier.library.a.j m(int i7) throws IOException {
            if (p(i7)) {
                return d.f27159e[i7].f27152a;
            }
            int iG = g(i7 - d.f27159e.length);
            if (iG >= 0) {
                c[] cVarArr = this.f27165e;
                if (iG < cVarArr.length) {
                    return cVarArr[iG].f27152a;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        private void n() {
            Arrays.fill(this.f27165e, (Object) null);
            this.f27166f = this.f27165e.length - 1;
            this.f27167g = 0;
            this.f27168h = 0;
        }

        private void o() throws IOException {
            this.f27161a.add(new c(d.a(i()), i()));
        }

        private boolean p(int i7) {
            return i7 >= 0 && i7 <= d.f27159e.length - 1;
        }

        private void q() throws IOException {
            d(-1, new c(d.a(i()), i()));
        }

        private int r() throws IOException {
            return this.f27162b.j() & 255;
        }

        int a() {
            return this.f27164d;
        }

        int c(int i7, int i8) throws IOException {
            int i9 = i7 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int iR = r();
                if ((iR & 128) == 0) {
                    return i8 + (iR << i10);
                }
                i8 += (iR & 127) << i10;
                i10 += 7;
            }
        }

        void e() throws IOException {
            while (!this.f27162b.g()) {
                int iJ = this.f27162b.j() & 255;
                if (iJ == 128) {
                    throw new IOException("index == 0");
                }
                if ((iJ & 128) == 128) {
                    f(c(iJ, 127) - 1);
                } else if (iJ == 64) {
                    q();
                } else if ((iJ & 64) == 64) {
                    l(c(iJ, 63) - 1);
                } else if ((iJ & 32) == 32) {
                    int iC = c(iJ, 31);
                    this.f27164d = iC;
                    if (iC < 0 || iC > this.f27163c) {
                        throw new IOException("Invalid dynamic table size update " + this.f27164d);
                    }
                    k();
                } else if (iJ == 16 || iJ == 0) {
                    o();
                } else {
                    j(c(iJ, 15) - 1);
                }
            }
        }

        public List<c> h() {
            ArrayList arrayList = new ArrayList(this.f27161a);
            this.f27161a.clear();
            return arrayList;
        }

        com.haier.library.a.j i() throws IOException {
            int iR = r();
            boolean z7 = (iR & 128) == 128;
            int iC = c(iR, 127);
            return z7 ? com.haier.library.a.j.m(k.b().e(this.f27162b.S(iC))) : this.f27162b.t1(iC);
        }

        a(int i7, int i8, c0 c0Var) {
            this.f27161a = new ArrayList();
            c[] cVarArr = new c[8];
            this.f27165e = cVarArr;
            this.f27166f = cVarArr.length - 1;
            this.f27167g = 0;
            this.f27168h = 0;
            this.f27163c = i7;
            this.f27164d = i8;
            this.f27162b = t.b(c0Var);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f27169k = 4096;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f27170l = 16384;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.g f27171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f27172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f27173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f27174d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27175e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f27176f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        c[] f27177g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f27178h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f27179i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f27180j;

        b(com.haier.library.a.g gVar) {
            this(4096, true, gVar);
        }

        private void a() {
            Arrays.fill(this.f27177g, (Object) null);
            this.f27178h = this.f27177g.length - 1;
            this.f27179i = 0;
            this.f27180j = 0;
        }

        private void e(c cVar) {
            int i7 = cVar.f27154c;
            int i8 = this.f27176f;
            if (i7 > i8) {
                a();
                return;
            }
            g((this.f27180j + i7) - i8);
            int i9 = this.f27179i + 1;
            c[] cVarArr = this.f27177g;
            if (i9 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f27178h = this.f27177g.length - 1;
                this.f27177g = cVarArr2;
            }
            int i10 = this.f27178h;
            this.f27178h = i10 - 1;
            this.f27177g[i10] = cVar;
            this.f27179i++;
            this.f27180j += i7;
        }

        private int g(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f27177g.length;
                while (true) {
                    length--;
                    i8 = this.f27178h;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f27177g[length].f27154c;
                    i7 -= i10;
                    this.f27180j -= i10;
                    this.f27179i--;
                    i9++;
                }
                c[] cVarArr = this.f27177g;
                System.arraycopy(cVarArr, i8 + 1, cVarArr, i8 + 1 + i9, this.f27179i);
                c[] cVarArr2 = this.f27177g;
                int i11 = this.f27178h;
                Arrays.fill(cVarArr2, i11 + 1, i11 + 1 + i9, (Object) null);
                this.f27178h += i9;
            }
            return i9;
        }

        private void h() {
            int i7 = this.f27176f;
            int i8 = this.f27180j;
            if (i7 < i8) {
                if (i7 == 0) {
                    a();
                } else {
                    g(i8 - i7);
                }
            }
        }

        void b(int i7) {
            this.f27175e = i7;
            int iMin = Math.min(i7, 16384);
            int i8 = this.f27176f;
            if (i8 == iMin) {
                return;
            }
            if (iMin < i8) {
                this.f27173c = Math.min(this.f27173c, iMin);
            }
            this.f27174d = true;
            this.f27176f = iMin;
            h();
        }

        void c(int i7, int i8, int i9) {
            if (i7 < i8) {
                this.f27171a.y1(i7 | i9);
                return;
            }
            this.f27171a.y1(i9 | i8);
            int i10 = i7 - i8;
            while (i10 >= 128) {
                this.f27171a.y1(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.f27171a.y1(i10);
        }

        void d(com.haier.library.a.j jVar) throws IOException {
            if (!this.f27172b || k.b().a(jVar) >= jVar.Z()) {
                c(jVar.Z(), 127, 0);
                this.f27171a.B(jVar);
                return;
            }
            com.haier.library.a.g gVar = new com.haier.library.a.g();
            k.b().d(jVar, gVar);
            com.haier.library.a.j jVarS = gVar.s();
            c(jVarS.Z(), 127, 128);
            this.f27171a.B(jVarS);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0069  */
        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x0084  */
        /* JADX WARN: Code duplicated, block: B:33:0x0098 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:38:0x00af  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00db  */
        /* JADX WARN: Code duplicated, block: B:55:0x0090 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a2 A[SYNTHETIC] */
        void f(List<c> list) throws IOException {
            int length;
            int length2;
            int i7;
            int length3;
            if (this.f27174d) {
                int i8 = this.f27173c;
                if (i8 < this.f27176f) {
                    c(i8, 31, 32);
                }
                this.f27174d = false;
                this.f27173c = Integer.MAX_VALUE;
                c(this.f27176f, 31, 32);
            }
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                c cVar = list.get(i9);
                com.haier.library.a.j jVarX = cVar.f27152a.X();
                com.haier.library.a.j jVar = cVar.f27153b;
                Integer num = d.f27160f.get(jVarX);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else {
                        c[] cVarArr = d.f27159e;
                        if (!com.haier.library.okhttp.n.d.y(cVarArr[length - 1].f27153b, jVar)) {
                            if (com.haier.library.okhttp.n.d.y(cVarArr[length].f27153b, jVar)) {
                                length2 = length;
                                length++;
                            } else {
                                length2 = length;
                                length = -1;
                            }
                        }
                    }
                    if (length == -1) {
                        length3 = this.f27177g.length;
                        for (i7 = this.f27178h + 1; i7 < length3; i7++) {
                            if (!com.haier.library.okhttp.n.d.y(this.f27177g[i7].f27152a, jVarX)) {
                                if (com.haier.library.okhttp.n.d.y(this.f27177g[i7].f27153b, jVar)) {
                                    length = d.f27159e.length + (i7 - this.f27178h);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i7 - this.f27178h) + d.f27159e.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        c(length, 127, 128);
                    } else if (length2 == -1) {
                        this.f27171a.y1(64);
                        d(jVarX);
                        d(jVar);
                        e(cVar);
                    } else if (jVarX.M(c.f27141d) || c.f27151n.equals(jVarX)) {
                        c(length2, 63, 64);
                        d(jVar);
                        e(cVar);
                    } else {
                        c(length2, 15, 0);
                        d(jVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    length3 = this.f27177g.length;
                    while (i7 < length3) {
                        if (!com.haier.library.okhttp.n.d.y(this.f27177g[i7].f27152a, jVarX)) {
                            if (com.haier.library.okhttp.n.d.y(this.f27177g[i7].f27153b, jVar)) {
                                length = d.f27159e.length + (i7 - this.f27178h);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i7 - this.f27178h) + d.f27159e.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    c(length, 127, 128);
                } else if (length2 == -1) {
                    this.f27171a.y1(64);
                    d(jVarX);
                    d(jVar);
                    e(cVar);
                } else if (jVarX.M(c.f27141d)) {
                    c(length2, 63, 64);
                    d(jVar);
                    e(cVar);
                } else {
                    c(length2, 63, 64);
                    d(jVar);
                    e(cVar);
                }
            }
        }

        b(int i7, boolean z7, com.haier.library.a.g gVar) {
            this.f27173c = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f27177g = cVarArr;
            this.f27178h = cVarArr.length - 1;
            this.f27179i = 0;
            this.f27180j = 0;
            this.f27175e = i7;
            this.f27176f = i7;
            this.f27172b = z7;
            this.f27171a = gVar;
        }
    }

    static {
        com.haier.library.a.j jVar = c.f27148k;
        com.haier.library.a.j jVar2 = c.f27149l;
        com.haier.library.a.j jVar3 = c.f27150m;
        com.haier.library.a.j jVar4 = c.f27147j;
        f27159e = new c[]{new c(c.f27151n, ""), new c(jVar, Const.HTTP_REQUEST_TYPE_GET), new c(jVar, Const.HTTP_REQUEST_TYPE_POST), new c(jVar2, "/"), new c(jVar2, "/index.html"), new c(jVar3, com.haier.uhome.usdk.base.a.av), new c(jVar3, j0.b.f34226a), new c(jVar4, "200"), new c(jVar4, "204"), new c(jVar4, "206"), new c(jVar4, "304"), new c(jVar4, "400"), new c(jVar4, "404"), new c(jVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c(com.alipay.sdk.packet.e.f13726f, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c(w.h.f3145c, ""), new c(j0.c.f34242f, ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c(com.alipay.sdk.widget.j.f13873s, ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f27160f = b();
    }

    private d() {
    }

    static com.haier.library.a.j a(com.haier.library.a.j jVar) throws IOException {
        int iZ = jVar.Z();
        for (int i7 = 0; i7 < iZ; i7++) {
            byte bX = jVar.x(i7);
            if (bX >= 65 && bX <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + jVar.o());
            }
        }
        return jVar;
    }

    private static Map<com.haier.library.a.j, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f27159e.length);
        int i7 = 0;
        while (true) {
            c[] cVarArr = f27159e;
            if (i7 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i7].f27152a)) {
                linkedHashMap.put(cVarArr[i7].f27152a, Integer.valueOf(i7));
            }
            i7++;
        }
    }
}
