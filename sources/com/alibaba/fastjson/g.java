package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.deserializer.e1;
import com.alibaba.fastjson.serializer.f0;
import com.alibaba.fastjson.serializer.g1;
import com.alibaba.fastjson.serializer.p0;
import com.alibaba.fastjson.serializer.y0;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.alibaba.fastjson.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentMap<String, g> f12662e = new ConcurrentHashMap(128, 0.75f, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long f12663f = 5614464919154503228L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long f12664g = -1580386065683472715L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u[] f12666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g1 f12667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.fastjson.parser.j f12668d;

    static class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12669a;

        public a(int i7) {
            this.f12669a = i7;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            return gVar.p(obj2, this.f12669a);
        }

        public boolean b(g gVar, Object obj) {
            return gVar.F(gVar, obj, this.f12669a);
        }

        public boolean c(g gVar, Object obj, Object obj2) {
            return gVar.K(gVar, obj, this.f12669a, obj2);
        }
    }

    static class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f12670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f12671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f12672c;

        enum a {
            And,
            Or
        }

        public b(u uVar, u uVar2, a aVar) {
            this.f12670a = uVar;
            this.f12671b = uVar2;
            this.f12672c = aVar;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            return null;
        }
    }

    static class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f12677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final q f12678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f12679d;

        public c(String str, double d8, q qVar) {
            this.f12676a = str;
            this.f12677b = d8;
            this.f12678c = qVar;
            this.f12679d = com.alibaba.fastjson.util.l.K(str);
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12676a, this.f12679d);
            if (objT == null || !(objT instanceof Number)) {
                return false;
            }
            double dDoubleValue = ((Number) objT).doubleValue();
            q qVar = this.f12678c;
            if (qVar == q.EQ) {
                return dDoubleValue == this.f12677b;
            }
            if (qVar == q.NE) {
                return dDoubleValue != this.f12677b;
            }
            if (qVar == q.GE) {
                return dDoubleValue >= this.f12677b;
            }
            if (qVar == q.GT) {
                return dDoubleValue > this.f12677b;
            }
            if (qVar == q.LE) {
                return dDoubleValue <= this.f12677b;
            }
            return qVar == q.LT && dDoubleValue < this.f12677b;
        }
    }

    interface d {
        boolean a(g gVar, Object obj, Object obj2, Object obj3);
    }

    public static class f implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f12682a;

        public f(d dVar) {
            this.f12682a = dVar;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            com.alibaba.fastjson.b bVar = new com.alibaba.fastjson.b();
            if (!(obj2 instanceof Iterable)) {
                if (this.f12682a.a(gVar, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.f12682a.a(gVar, obj, obj2, obj3)) {
                    bVar.add(obj3);
                }
            }
            return bVar;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.fastjson.g$g, reason: collision with other inner class name */
    static class C0148g implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f12685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f12686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f12687e;

        public C0148g(String str, long j7, long j8, boolean z7) {
            this.f12683a = str;
            this.f12684b = com.alibaba.fastjson.util.l.K(str);
            this.f12685c = j7;
            this.f12686d = j8;
            this.f12687e = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12683a, this.f12684b);
            if (objT == null) {
                return false;
            }
            if (objT instanceof Number) {
                long jLongValue = ((Number) objT).longValue();
                if (jLongValue >= this.f12685c && jLongValue <= this.f12686d) {
                    return !this.f12687e;
                }
            }
            return this.f12687e;
        }
    }

    static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f12690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12691d;

        public h(String str, long[] jArr, boolean z7) {
            this.f12688a = str;
            this.f12689b = com.alibaba.fastjson.util.l.K(str);
            this.f12690c = jArr;
            this.f12691d = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12688a, this.f12689b);
            if (objT == null) {
                return false;
            }
            if (objT instanceof Number) {
                long jLongValue = ((Number) objT).longValue();
                for (long j7 : this.f12690c) {
                    if (j7 == jLongValue) {
                        return !this.f12691d;
                    }
                }
            }
            return this.f12691d;
        }
    }

    static class i implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long[] f12694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12695d;

        public i(String str, Long[] lArr, boolean z7) {
            this.f12692a = str;
            this.f12693b = com.alibaba.fastjson.util.l.K(str);
            this.f12694c = lArr;
            this.f12695d = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12692a, this.f12693b);
            int i7 = 0;
            if (objT == null) {
                Long[] lArr = this.f12694c;
                int length = lArr.length;
                while (i7 < length) {
                    if (lArr[i7] == null) {
                        return !this.f12695d;
                    }
                    i7++;
                }
                return this.f12695d;
            }
            if (objT instanceof Number) {
                long jLongValue = ((Number) objT).longValue();
                Long[] lArr2 = this.f12694c;
                int length2 = lArr2.length;
                while (i7 < length2) {
                    Long l7 = lArr2[i7];
                    if (l7 != null && l7.longValue() == jLongValue) {
                        return !this.f12695d;
                    }
                    i7++;
                }
            }
            return this.f12695d;
        }
    }

    static class j implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f12698c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final q f12699d;

        public j(String str, long j7, q qVar) {
            this.f12696a = str;
            this.f12697b = com.alibaba.fastjson.util.l.K(str);
            this.f12698c = j7;
            this.f12699d = qVar;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12696a, this.f12697b);
            if (objT == null || !(objT instanceof Number)) {
                return false;
            }
            long jLongValue = ((Number) objT).longValue();
            q qVar = this.f12699d;
            if (qVar == q.EQ) {
                return jLongValue == this.f12698c;
            }
            if (qVar == q.NE) {
                return jLongValue != this.f12698c;
            }
            if (qVar == q.GE) {
                return jLongValue >= this.f12698c;
            }
            if (qVar == q.GT) {
                return jLongValue > this.f12698c;
            }
            if (qVar == q.LE) {
                return jLongValue <= this.f12698c;
            }
            return qVar == q.LT && jLongValue < this.f12698c;
        }
    }

    static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private char f12702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12703d;

        public k(String str) {
            this.f12700a = str;
            h();
        }

        static boolean f(char c8) {
            return c8 == '-' || c8 == '+' || (c8 >= '0' && c8 <= '9');
        }

        void a(char c8) {
            if (this.f12702c == c8) {
                if (g()) {
                    return;
                }
                h();
            } else {
                throw new com.alibaba.fastjson.h("expect '" + c8 + ", but '" + this.f12702c + "'");
            }
        }

        u b(String str) {
            int length = str.length();
            int i7 = 0;
            char cCharAt = str.charAt(0);
            int i8 = length - 1;
            char cCharAt2 = str.charAt(i8);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                if (iIndexOf == -1) {
                    return new r(str.substring(1, i8), false);
                }
                String[] strArrSplit = str.split(",");
                String[] strArr = new String[strArrSplit.length];
                while (i7 < strArrSplit.length) {
                    String str2 = strArrSplit[i7];
                    strArr[i7] = str2.substring(1, str2.length() - 1);
                    i7++;
                }
                return new n(strArr);
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (!com.alibaba.fastjson.util.l.i0(str)) {
                    return new r(str, false);
                }
                try {
                    return new a(Integer.parseInt(str));
                } catch (NumberFormatException unused) {
                    return new r(str, false);
                }
            }
            if (iIndexOf != -1) {
                String[] strArrSplit2 = str.split(",");
                int[] iArr = new int[strArrSplit2.length];
                while (i7 < strArrSplit2.length) {
                    iArr[i7] = Integer.parseInt(strArrSplit2[i7]);
                    i7++;
                }
                return new m(iArr);
            }
            if (iIndexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] strArrSplit3 = str.split(":");
            int length2 = strArrSplit3.length;
            int[] iArr2 = new int[length2];
            for (int i9 = 0; i9 < strArrSplit3.length; i9++) {
                String str3 = strArrSplit3[i9];
                if (str3.length() != 0) {
                    iArr2[i9] = Integer.parseInt(str3);
                } else {
                    if (i9 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i9] = 0;
                }
            }
            int i10 = iArr2[0];
            int i11 = length2 > 1 ? iArr2[1] : -1;
            int i12 = length2 == 3 ? iArr2[2] : 1;
            if (i11 < 0 || i11 >= i10) {
                if (i12 > 0) {
                    return new s(i10, i11, i12);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i12);
            }
            throw new UnsupportedOperationException("end must greater than or equals start. start " + i10 + ",  end " + i11);
        }

        public u[] c() {
            String str = this.f12700a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            u[] uVarArr = new u[8];
            while (true) {
                u uVarO = o();
                if (uVarO == null) {
                    break;
                }
                int i7 = this.f12703d;
                if (i7 == uVarArr.length) {
                    u[] uVarArr2 = new u[(i7 * 3) / 2];
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, i7);
                    uVarArr = uVarArr2;
                }
                int i8 = this.f12703d;
                this.f12703d = i8 + 1;
                uVarArr[i8] = uVarO;
            }
            int i9 = this.f12703d;
            if (i9 == uVarArr.length) {
                return uVarArr;
            }
            u[] uVarArr3 = new u[i9];
            System.arraycopy(uVarArr, 0, uVarArr3, 0, i9);
            return uVarArr3;
        }

        d d(d dVar) {
            char c8 = this.f12702c;
            boolean z7 = c8 == '&';
            if ((c8 != '&' || e() != '&') && (this.f12702c != '|' || e() != '|')) {
                return dVar;
            }
            h();
            h();
            while (this.f12702c == ' ') {
                h();
            }
            return new e(dVar, (d) j(false), z7);
        }

        char e() {
            return this.f12700a.charAt(this.f12701b);
        }

        boolean g() {
            return this.f12701b >= this.f12700a.length();
        }

        void h() {
            String str = this.f12700a;
            int i7 = this.f12701b;
            this.f12701b = i7 + 1;
            this.f12702c = str.charAt(i7);
        }

        u i(boolean z7) {
            Object objJ = j(z7);
            return objJ instanceof u ? (u) objJ : new f((d) objJ);
        }

        /* JADX WARN: Code duplicated, block: B:250:0x032b A[LOOP:7: B:248:0x0327->B:250:0x032b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:253:0x0333  */
        /* JADX WARN: Code duplicated, block: B:255:0x0339  */
        /* JADX WARN: Code duplicated, block: B:257:0x033e  */
        /* JADX WARN: Code duplicated, block: B:434:0x032f A[EDGE_INSN: B:434:0x032f->B:251:0x032f BREAK  A[LOOP:7: B:248:0x0327->B:250:0x032b], SYNTHETIC] */
        Object j(boolean z7) {
            boolean z8;
            char c8;
            char c9;
            char c10;
            char c11;
            char c12;
            char c13;
            String[] strArr;
            String str;
            String str2;
            d lVar;
            char c14;
            char c15;
            char c16;
            char c17;
            char c18;
            char c19;
            char c20;
            char c21;
            char c22;
            int i7;
            char c23;
            if (z7) {
                a('[');
            }
            int i8 = 0;
            if (this.f12702c == '?') {
                h();
                a('(');
                if (this.f12702c == '@') {
                    h();
                    a(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                z8 = true;
            } else {
                z8 = false;
            }
            char c24 = ']';
            char c25 = ')';
            if (!z8 && !com.alibaba.fastjson.util.f.h(this.f12702c)) {
                int i9 = this.f12701b - 1;
                while (true) {
                    char c26 = this.f12702c;
                    if (c26 == ']' || c26 == '/' || g() || !((c23 = this.f12702c) != '.' || z8 || z8)) {
                        break;
                    }
                    if (c23 == '\\') {
                        h();
                    }
                    h();
                }
                if (z7 || (c22 = this.f12702c) == '/' || c22 == '.') {
                    int i10 = this.f12701b;
                    i7 = i10 - 1;
                } else {
                    i7 = this.f12701b;
                }
                String strSubstring = this.f12700a.substring(i9, i7);
                if (strSubstring.indexOf("\\.") == -1) {
                    u uVarB = b(strSubstring);
                    if (z7 && !g()) {
                        a(']');
                    }
                    return uVarB;
                }
                String strReplaceAll = strSubstring.replaceAll("\\\\\\.", "\\.");
                if (strReplaceAll.indexOf("\\-") != -1) {
                    strReplaceAll = strReplaceAll.replaceAll("\\\\-", "-");
                }
                if (z8) {
                    a(')');
                }
                return new r(strReplaceAll, false);
            }
            String strM = m();
            r();
            if (z8 && this.f12702c == ')') {
                h();
                d oVar = new o(strM);
                while (true) {
                    c21 = this.f12702c;
                    if (c21 != ' ') {
                        break;
                    }
                    h();
                }
                if (c21 == '&' || c21 == '|') {
                    oVar = d(oVar);
                }
                if (z7) {
                    a(']');
                }
                return oVar;
            }
            if (z7 && this.f12702c == ']') {
                h();
                d oVar2 = new o(strM);
                while (true) {
                    c20 = this.f12702c;
                    if (c20 != ' ') {
                        break;
                    }
                    h();
                }
                if (c20 == '&' || c20 == '|') {
                    oVar2 = d(oVar2);
                }
                a(')');
                if (z8) {
                    a(')');
                }
                if (z7) {
                    a(']');
                }
                return oVar2;
            }
            q qVarN = n();
            r();
            if (qVarN == q.BETWEEN || qVarN == q.NOT_BETWEEN) {
                boolean z9 = qVarN == q.NOT_BETWEEN;
                Object objQ = q();
                if (!"and".equalsIgnoreCase(m())) {
                    throw new com.alibaba.fastjson.h(this.f12700a);
                }
                Object objQ2 = q();
                if (objQ == null || objQ2 == null) {
                    throw new com.alibaba.fastjson.h(this.f12700a);
                }
                if (g.x(objQ.getClass()) && g.x(objQ2.getClass())) {
                    return new C0148g(strM, ((Number) objQ).longValue(), ((Number) objQ2).longValue(), z9);
                }
                throw new com.alibaba.fastjson.h(this.f12700a);
            }
            if (qVarN == q.IN || qVarN == q.NOT_IN) {
                boolean z10 = qVarN == q.NOT_IN;
                a('(');
                com.alibaba.fastjson.b bVar = new com.alibaba.fastjson.b();
                bVar.add(q());
                while (true) {
                    r();
                    if (this.f12702c != ',') {
                        break;
                    }
                    h();
                    bVar.add(q());
                    c25 = c25;
                    c24 = c24;
                }
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                for (Object obj : bVar) {
                    if (obj != null) {
                        Class<?> cls = obj.getClass();
                        if (z11 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                            z11 = false;
                            z13 = false;
                        }
                        if (z12 && cls != String.class) {
                            z12 = false;
                        }
                    } else if (z11) {
                        z11 = false;
                    }
                }
                if (bVar.size() == 1 && bVar.get(0) == null) {
                    d oVar3 = z10 ? new o(strM) : new p(strM);
                    while (true) {
                        c13 = this.f12702c;
                        if (c13 != ' ') {
                            break;
                        }
                        h();
                    }
                    if (c13 == '&' || c13 == '|') {
                        oVar3 = d(oVar3);
                    }
                    a(')');
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return oVar3;
                }
                if (z11) {
                    if (bVar.size() == 1) {
                        d jVar = new j(strM, ((Number) bVar.get(0)).longValue(), z10 ? q.NE : q.EQ);
                        while (true) {
                            c12 = this.f12702c;
                            if (c12 != ' ') {
                                break;
                            }
                            h();
                        }
                        if (c12 == '&' || c12 == '|') {
                            jVar = d(jVar);
                        }
                        a(')');
                        if (z8) {
                            a(')');
                        }
                        if (z7) {
                            a(']');
                        }
                        return jVar;
                    }
                    int size = bVar.size();
                    long[] jArr = new long[size];
                    while (i8 < size) {
                        jArr[i8] = ((Number) bVar.get(i8)).longValue();
                        i8++;
                    }
                    d hVar = new h(strM, jArr, z10);
                    while (true) {
                        c11 = this.f12702c;
                        if (c11 != ' ') {
                            break;
                        }
                        h();
                    }
                    if (c11 == '&' || c11 == '|') {
                        hVar = d(hVar);
                    }
                    a(')');
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return hVar;
                }
                if (!z12) {
                    if (!z13) {
                        throw new UnsupportedOperationException();
                    }
                    int size2 = bVar.size();
                    Long[] lArr = new Long[size2];
                    while (i8 < size2) {
                        Number number = (Number) bVar.get(i8);
                        if (number != null) {
                            lArr[i8] = Long.valueOf(number.longValue());
                        }
                        i8++;
                    }
                    d iVar = new i(strM, lArr, z10);
                    while (true) {
                        c8 = this.f12702c;
                        if (c8 != ' ') {
                            break;
                        }
                        h();
                    }
                    if (c8 == '&' || c8 == '|') {
                        iVar = d(iVar);
                    }
                    a(')');
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return iVar;
                }
                if (bVar.size() == 1) {
                    d xVar = new x(strM, (String) bVar.get(0), z10 ? q.NE : q.EQ);
                    while (true) {
                        c10 = this.f12702c;
                        if (c10 != ' ') {
                            break;
                        }
                        h();
                    }
                    if (c10 == '&' || c10 == '|') {
                        xVar = d(xVar);
                    }
                    a(')');
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return xVar;
                }
                String[] strArr2 = new String[bVar.size()];
                bVar.toArray(strArr2);
                d wVar = new w(strM, strArr2, z10);
                while (true) {
                    c9 = this.f12702c;
                    if (c9 != ' ') {
                        break;
                    }
                    h();
                }
                if (c9 == '&' || c9 == '|') {
                    wVar = d(wVar);
                }
                a(')');
                if (z8) {
                    a(')');
                }
                if (z7) {
                    a(']');
                }
                return wVar;
            }
            char c27 = this.f12702c;
            if (c27 != '\'' && c27 != '\"') {
                if (f(c27)) {
                    long jL = l();
                    double dK = this.f12702c == '.' ? k(jL) : 0.0d;
                    d jVar2 = dK == 0.0d ? new j(strM, jL, qVarN) : new c(strM, dK, qVarN);
                    while (true) {
                        c19 = this.f12702c;
                        if (c19 != ' ') {
                            break;
                        }
                        h();
                    }
                    if (c19 == '&' || c19 == '|') {
                        jVar2 = d(jVar2);
                    }
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return jVar2;
                }
                char c28 = this.f12702c;
                if (c28 == 'n') {
                    if ("null".equals(m())) {
                        d pVar = qVarN == q.EQ ? new p(strM) : qVarN == q.NE ? new o(strM) : null;
                        if (pVar != null) {
                            while (true) {
                                c18 = this.f12702c;
                                if (c18 != ' ') {
                                    break;
                                }
                                h();
                            }
                            if (c18 == '&' || c18 == '|') {
                                pVar = d(pVar);
                            }
                        }
                        if (z8) {
                            a(')');
                        }
                        a(']');
                        if (pVar != null) {
                            return pVar;
                        }
                        throw new UnsupportedOperationException();
                    }
                } else if (c28 == 't') {
                    if ("true".equals(m())) {
                        d yVar = qVarN == q.EQ ? new y(strM, Boolean.TRUE, true) : qVarN == q.NE ? new y(strM, Boolean.TRUE, false) : null;
                        if (yVar != null) {
                            while (true) {
                                c17 = this.f12702c;
                                if (c17 != ' ') {
                                    break;
                                }
                                h();
                            }
                            if (c17 == '&' || c17 == '|') {
                                yVar = d(yVar);
                            }
                        }
                        if (z8) {
                            a(')');
                        }
                        a(']');
                        if (yVar != null) {
                            return yVar;
                        }
                        throw new UnsupportedOperationException();
                    }
                } else if (c28 == 'f' && com.paytm.pgsdk.d.G.equals(m())) {
                    d yVar2 = qVarN == q.EQ ? new y(strM, Boolean.FALSE, true) : qVarN == q.NE ? new y(strM, Boolean.FALSE, false) : null;
                    if (yVar2 != null) {
                        while (true) {
                            c16 = this.f12702c;
                            if (c16 != ' ') {
                                break;
                            }
                            h();
                        }
                        if (c16 == '&' || c16 == '|') {
                            yVar2 = d(yVar2);
                        }
                    }
                    if (z8) {
                        a(')');
                    }
                    a(']');
                    if (yVar2 != null) {
                        return yVar2;
                    }
                    throw new UnsupportedOperationException();
                }
                throw new UnsupportedOperationException();
            }
            String strP = p();
            if (qVarN == q.RLIKE) {
                lVar = new t(strM, strP, false);
            } else {
                if (qVarN != q.NOT_RLIKE) {
                    if (qVarN == q.LIKE || qVarN == q.NOT_LIKE) {
                        while (strP.indexOf("%%") != -1) {
                            strP = strP.replaceAll("%%", "%");
                        }
                        boolean z14 = qVarN == q.NOT_LIKE;
                        int iIndexOf = strP.indexOf(37);
                        if (iIndexOf == -1) {
                            lVar = new x(strM, strP, qVarN == q.LIKE ? q.EQ : q.NE);
                            c14 = ' ';
                        } else {
                            String[] strArrSplit = strP.split("%");
                            if (iIndexOf == 0) {
                                if (strP.charAt(strP.length() - 1) == '%') {
                                    int length = strArrSplit.length - 1;
                                    String[] strArr3 = new String[length];
                                    System.arraycopy(strArrSplit, 1, strArr3, 0, length);
                                    strArr = strArr3;
                                    str2 = null;
                                    str = null;
                                } else {
                                    String str3 = strArrSplit[strArrSplit.length - 1];
                                    if (strArrSplit.length > 2) {
                                        int length2 = strArrSplit.length - 2;
                                        String[] strArr4 = new String[length2];
                                        System.arraycopy(strArrSplit, 1, strArr4, 0, length2);
                                        str = str3;
                                        strArr = strArr4;
                                        str2 = null;
                                    } else {
                                        str = str3;
                                        str2 = null;
                                        strArr = null;
                                    }
                                }
                            } else if (strP.charAt(strP.length() - 1) == '%') {
                                strArr = strArrSplit;
                                str2 = null;
                                str = null;
                            } else {
                                if (strArrSplit.length == 1) {
                                    str2 = strArrSplit[0];
                                    str = null;
                                } else if (strArrSplit.length == 2) {
                                    String str4 = strArrSplit[0];
                                    str = strArrSplit[1];
                                    str2 = str4;
                                } else {
                                    String str5 = strArrSplit[0];
                                    String str6 = strArrSplit[strArrSplit.length - 1];
                                    int length3 = strArrSplit.length - 2;
                                    String[] strArr5 = new String[length3];
                                    System.arraycopy(strArrSplit, 1, strArr5, 0, length3);
                                    strArr = strArr5;
                                    str = str6;
                                    str2 = str5;
                                }
                                strArr = null;
                            }
                            c14 = ' ';
                            lVar = new l(strM, str2, str, strArr, z14);
                        }
                    } else {
                        lVar = new x(strM, strP, qVarN);
                    }
                    while (true) {
                        c15 = this.f12702c;
                        if (c15 == c14) {
                            break;
                        }
                        h();
                    }
                    if (c15 != '&' || c15 == '|') {
                        lVar = d(lVar);
                    }
                    if (z8) {
                        a(')');
                    }
                    if (z7) {
                        a(']');
                    }
                    return lVar;
                }
                lVar = new t(strM, strP, true);
            }
            c14 = ' ';
            while (true) {
                c15 = this.f12702c;
                if (c15 == c14) {
                    break;
                    break;
                }
                h();
            }
            if (c15 != '&') {
                lVar = d(lVar);
            } else {
                lVar = d(lVar);
            }
            if (z8) {
                a(')');
            }
            if (z7) {
                a(']');
            }
            return lVar;
        }

        protected double k(long j7) {
            int i7 = this.f12701b - 1;
            h();
            while (true) {
                char c8 = this.f12702c;
                if (c8 < '0' || c8 > '9') {
                    break;
                }
                h();
            }
            return Double.parseDouble(this.f12700a.substring(i7, this.f12701b - 1)) + j7;
        }

        protected long l() {
            int i7 = this.f12701b - 1;
            char c8 = this.f12702c;
            if (c8 == '+' || c8 == '-') {
                h();
            }
            while (true) {
                char c9 = this.f12702c;
                if (c9 < '0' || c9 > '9') {
                    break;
                }
                h();
            }
            return Long.parseLong(this.f12700a.substring(i7, this.f12701b - 1));
        }

        String m() {
            r();
            char c8 = this.f12702c;
            if (c8 != '\\' && !com.alibaba.fastjson.util.f.h(c8)) {
                throw new com.alibaba.fastjson.h("illeal jsonpath syntax. " + this.f12700a);
            }
            StringBuilder sb = new StringBuilder();
            while (!g()) {
                char c9 = this.f12702c;
                if (c9 == '\\') {
                    h();
                    sb.append(this.f12702c);
                    if (g()) {
                        break;
                    }
                    h();
                } else {
                    if (!com.alibaba.fastjson.util.f.m(c9)) {
                        break;
                    }
                    sb.append(this.f12702c);
                    h();
                }
            }
            if (g() && com.alibaba.fastjson.util.f.m(this.f12702c)) {
                sb.append(this.f12702c);
            }
            return sb.toString();
        }

        protected q n() {
            q qVar;
            char c8 = this.f12702c;
            if (c8 == '=') {
                h();
                qVar = q.EQ;
            } else if (c8 == '!') {
                h();
                a('=');
                qVar = q.NE;
            } else if (c8 == '<') {
                h();
                if (this.f12702c == '=') {
                    h();
                    qVar = q.LE;
                } else {
                    qVar = q.LT;
                }
            } else if (c8 == '>') {
                h();
                if (this.f12702c == '=') {
                    h();
                    qVar = q.GE;
                } else {
                    qVar = q.GT;
                }
            } else {
                qVar = null;
            }
            if (qVar != null) {
                return qVar;
            }
            String strM = m();
            if (!"not".equalsIgnoreCase(strM)) {
                if ("like".equalsIgnoreCase(strM)) {
                    return q.LIKE;
                }
                if ("rlike".equalsIgnoreCase(strM)) {
                    return q.RLIKE;
                }
                if ("in".equalsIgnoreCase(strM)) {
                    return q.IN;
                }
                if ("between".equalsIgnoreCase(strM)) {
                    return q.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            r();
            String strM2 = m();
            if ("like".equalsIgnoreCase(strM2)) {
                return q.NOT_LIKE;
            }
            if ("rlike".equalsIgnoreCase(strM2)) {
                return q.NOT_RLIKE;
            }
            if ("in".equalsIgnoreCase(strM2)) {
                return q.NOT_IN;
            }
            if ("between".equalsIgnoreCase(strM2)) {
                return q.NOT_BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        u o() {
            boolean z7 = true;
            if (this.f12703d == 0 && this.f12700a.length() == 1) {
                if (f(this.f12702c)) {
                    return new a(this.f12702c - '0');
                }
                char c8 = this.f12702c;
                if ((c8 >= 'a' && c8 <= 'z') || (c8 >= 'A' && c8 <= 'Z')) {
                    return new r(Character.toString(c8), false);
                }
            }
            while (!g()) {
                r();
                char c9 = this.f12702c;
                if (c9 != '$') {
                    if (c9 != '.' && c9 != '/') {
                        if (c9 == '[') {
                            return i(true);
                        }
                        if (this.f12703d == 0) {
                            return new r(m(), false);
                        }
                        throw new com.alibaba.fastjson.h("not support jsonpath : " + this.f12700a);
                    }
                    h();
                    if (c9 == '.' && this.f12702c == '.') {
                        h();
                        int length = this.f12700a.length();
                        int i7 = this.f12701b;
                        if (length > i7 + 3 && this.f12702c == '[' && this.f12700a.charAt(i7) == '*' && this.f12700a.charAt(this.f12701b + 1) == ']' && this.f12700a.charAt(this.f12701b + 2) == '.') {
                            h();
                            h();
                            h();
                            h();
                        }
                    } else {
                        z7 = false;
                    }
                    char c10 = this.f12702c;
                    if (c10 == '*') {
                        if (!g()) {
                            h();
                        }
                        return z.f12758a;
                    }
                    if (f(c10)) {
                        return i(false);
                    }
                    String strM = m();
                    if (this.f12702c != '(') {
                        return new r(strM, z7);
                    }
                    h();
                    if (this.f12702c != ')') {
                        throw new com.alibaba.fastjson.h("not support jsonpath : " + this.f12700a);
                    }
                    if (!g()) {
                        h();
                    }
                    if ("size".equals(strM) || "length".equals(strM)) {
                        return v.f12745a;
                    }
                    throw new com.alibaba.fastjson.h("not support jsonpath : " + this.f12700a);
                }
                h();
            }
            return null;
        }

        String p() {
            char c8 = this.f12702c;
            h();
            int i7 = this.f12701b - 1;
            while (this.f12702c != c8 && !g()) {
                h();
            }
            String strSubstring = this.f12700a.substring(i7, g() ? this.f12701b : this.f12701b - 1);
            a(c8);
            return strSubstring;
        }

        protected Object q() {
            r();
            if (f(this.f12702c)) {
                return Long.valueOf(l());
            }
            char c8 = this.f12702c;
            if (c8 == '\"' || c8 == '\'') {
                return p();
            }
            if (c8 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(m())) {
                return null;
            }
            throw new com.alibaba.fastjson.h(this.f12700a);
        }

        public final void r() {
            while (true) {
                char c8 = this.f12702c;
                if (c8 > ' ') {
                    return;
                }
                if (c8 != ' ' && c8 != '\r' && c8 != '\n' && c8 != '\t' && c8 != '\f' && c8 != '\b') {
                    return;
                } else {
                    h();
                }
            }
        }
    }

    static class l implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f12706c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f12707d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String[] f12708e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f12709f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f12710g;

        public l(String str, String str2, String str3, String[] strArr, boolean z7) {
            this.f12704a = str;
            this.f12705b = com.alibaba.fastjson.util.l.K(str);
            this.f12706c = str2;
            this.f12707d = str3;
            this.f12708e = strArr;
            this.f12710g = z7;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.f12709f = length;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            int length;
            Object objT = gVar.t(obj3, this.f12704a, this.f12705b);
            if (objT == null) {
                return false;
            }
            String string = objT.toString();
            if (string.length() < this.f12709f) {
                return this.f12710g;
            }
            String str = this.f12706c;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.f12710g;
                }
                length = this.f12706c.length() + 0;
            }
            String[] strArr = this.f12708e;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.f12710g;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.f12707d;
            return (str3 == null || string.endsWith(str3)) ? !this.f12710g : this.f12710g;
        }
    }

    static class m implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f12711a;

        public m(int[] iArr) {
            this.f12711a = iArr;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f12711a.length);
            int i7 = 0;
            while (true) {
                int[] iArr = this.f12711a;
                if (i7 >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(gVar.p(obj2, iArr[i7]));
                i7++;
            }
        }
    }

    static class n implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f12712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f12713b;

        public n(String[] strArr) {
            this.f12712a = strArr;
            this.f12713b = new long[strArr.length];
            int i7 = 0;
            while (true) {
                long[] jArr = this.f12713b;
                if (i7 >= jArr.length) {
                    return;
                }
                jArr[i7] = com.alibaba.fastjson.util.l.K(strArr[i7]);
                i7++;
            }
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f12712a.length);
            int i7 = 0;
            while (true) {
                String[] strArr = this.f12712a;
                if (i7 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(gVar.t(obj2, strArr[i7], this.f12713b[i7]));
                i7++;
            }
        }
    }

    static class o implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12715b;

        public o(String str) {
            this.f12714a = str;
            this.f12715b = com.alibaba.fastjson.util.l.K(str);
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            return gVar.t(obj3, this.f12714a, this.f12715b) != null;
        }
    }

    static class p implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12717b;

        public p(String str) {
            this.f12716a = str;
            this.f12717b = com.alibaba.fastjson.util.l.K(str);
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            return gVar.t(obj3, this.f12716a, this.f12717b) == null;
        }
    }

    enum q {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or
    }

    static class r implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f12737c;

        public r(String str, boolean z7) {
            this.f12735a = str;
            this.f12736b = com.alibaba.fastjson.util.l.K(str);
            this.f12737c = z7;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            if (!this.f12737c) {
                return gVar.t(obj2, this.f12735a, this.f12736b);
            }
            ArrayList arrayList = new ArrayList();
            gVar.h(obj2, this.f12735a, arrayList);
            return arrayList;
        }

        public boolean c(g gVar, Object obj) {
            return gVar.G(obj, this.f12735a);
        }

        public void d(g gVar, Object obj, Object obj2) {
            if (this.f12737c) {
                gVar.i(obj, this.f12735a, this.f12736b, obj2);
            } else {
                gVar.L(obj, this.f12735a, this.f12736b, obj2);
            }
        }
    }

    static class s implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f12740c;

        public s(int i7, int i8, int i9) {
            this.f12738a = i7;
            this.f12739b = i8;
            this.f12740c = i9;
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            int iIntValue = v.f12745a.a(gVar, obj, obj2).intValue();
            int i7 = this.f12738a;
            if (i7 < 0) {
                i7 += iIntValue;
            }
            int i8 = this.f12739b;
            if (i8 < 0) {
                i8 += iIntValue;
            }
            int i9 = ((i8 - i7) / this.f12740c) + 1;
            if (i9 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i9);
            while (i7 <= i8 && i7 < iIntValue) {
                arrayList.add(gVar.p(obj2, i7));
                i7 += this.f12740c;
            }
            return arrayList;
        }
    }

    static class t implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pattern f12743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12744d;

        public t(String str, String str2, boolean z7) {
            this.f12741a = str;
            this.f12742b = com.alibaba.fastjson.util.l.K(str);
            this.f12743c = Pattern.compile(str2);
            this.f12744d = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12741a, this.f12742b);
            if (objT == null) {
                return false;
            }
            boolean zMatches = this.f12743c.matcher(objT.toString()).matches();
            return this.f12744d ? !zMatches : zMatches;
        }
    }

    interface u {
        Object a(g gVar, Object obj, Object obj2);
    }

    static class v implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f12745a = new v();

        v() {
        }

        @Override // com.alibaba.fastjson.g.u
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(g gVar, Object obj, Object obj2) {
            return Integer.valueOf(gVar.o(obj2));
        }
    }

    static class w implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f12748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12749d;

        public w(String str, String[] strArr, boolean z7) {
            this.f12746a = str;
            this.f12747b = com.alibaba.fastjson.util.l.K(str);
            this.f12748c = strArr;
            this.f12749d = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12746a, this.f12747b);
            for (String str : this.f12748c) {
                if (str == objT) {
                    return !this.f12749d;
                }
                if (str != null && str.equals(objT)) {
                    return !this.f12749d;
                }
            }
            return this.f12749d;
        }
    }

    static class x implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f12752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final q f12753d;

        public x(String str, String str2, q qVar) {
            this.f12750a = str;
            this.f12751b = com.alibaba.fastjson.util.l.K(str);
            this.f12752c = str2;
            this.f12753d = qVar;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objT = gVar.t(obj3, this.f12750a, this.f12751b);
            q qVar = this.f12753d;
            if (qVar == q.EQ) {
                return this.f12752c.equals(objT);
            }
            if (qVar == q.NE) {
                return !this.f12752c.equals(objT);
            }
            if (objT == null) {
                return false;
            }
            int iCompareTo = this.f12752c.compareTo(objT.toString());
            q qVar2 = this.f12753d;
            if (qVar2 == q.GE) {
                return iCompareTo <= 0;
            }
            if (qVar2 == q.GT) {
                return iCompareTo < 0;
            }
            if (qVar2 == q.LE) {
                return iCompareTo >= 0;
            }
            return qVar2 == q.LT && iCompareTo > 0;
        }
    }

    static class y implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f12756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f12757d;

        public y(String str, Object obj, boolean z7) {
            this.f12757d = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.f12754a = str;
            this.f12755b = com.alibaba.fastjson.util.l.K(str);
            this.f12756c = obj;
            this.f12757d = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            boolean zEquals = this.f12756c.equals(gVar.t(obj3, this.f12754a, this.f12755b));
            return !this.f12757d ? !zEquals : zEquals;
        }
    }

    static class z implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static z f12758a = new z();

        z() {
        }

        @Override // com.alibaba.fastjson.g.u
        public Object a(g gVar, Object obj, Object obj2) {
            return gVar.u(obj2);
        }
    }

    public g(String str) {
        this(str, g1.i(), com.alibaba.fastjson.parser.j.q());
    }

    private static void A(Map<Object, String> map, String str, Object obj, g1 g1Var) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null || map.containsKey(obj)) {
            return;
        }
        map.put(obj, str);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    A(map, sb4.toString(), entry.getValue(), g1Var);
                }
            }
            return;
        }
        int i7 = 0;
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i7);
                A(map, sb3.toString(), obj2, g1Var);
                i7++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i7 < length) {
                Object obj3 = Array.get(obj, i7);
                if (str.equals("/")) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                }
                sb2.append("/");
                sb2.append(i7);
                A(map, sb2.toString(), obj3, g1Var);
                i7++;
            }
            return;
        }
        if (com.alibaba.fastjson.parser.j.w(cls) || cls.isEnum()) {
            return;
        }
        y0 y0VarJ = g1Var.j(cls);
        if (y0VarJ instanceof p0) {
            try {
                for (Map.Entry<String, Object> entry2 : ((p0) y0VarJ).A(obj).entrySet()) {
                    String key2 = entry2.getKey();
                    if (key2 instanceof String) {
                        if (str.equals("/")) {
                            sb = new StringBuilder();
                            sb.append("/");
                            sb.append(key2);
                        } else {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("/");
                            sb.append(key2);
                        }
                        A(map, sb.toString(), entry2.getValue(), g1Var);
                    }
                }
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("toJSON error", e8);
            }
        }
    }

    private static void B(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, g1 g1Var) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null) {
            return;
        }
        int i7 = 0;
        if (map.put(obj, str) != null) {
            if (!((obj instanceof String) || (obj instanceof Number) || (obj instanceof Date) || (obj instanceof UUID))) {
                return;
            }
        }
        map2.put(str, obj);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    B(map, map2, sb4.toString(), entry.getValue(), g1Var);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i7);
                B(map, map2, sb3.toString(), obj2, g1Var);
                i7++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i7 < length) {
                Object obj3 = Array.get(obj, i7);
                if (str.equals("/")) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                }
                sb2.append("/");
                sb2.append(i7);
                B(map, map2, sb2.toString(), obj3, g1Var);
                i7++;
            }
            return;
        }
        if (com.alibaba.fastjson.parser.j.w(cls) || cls.isEnum()) {
            return;
        }
        y0 y0VarJ = g1Var.j(cls);
        if (y0VarJ instanceof p0) {
            try {
                for (Map.Entry<String, Object> entry2 : ((p0) y0VarJ).A(obj).entrySet()) {
                    String key2 = entry2.getKey();
                    if (key2 instanceof String) {
                        if (str.equals("/")) {
                            sb = new StringBuilder();
                            sb.append("/");
                            sb.append(key2);
                        } else {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("/");
                            sb.append(key2);
                        }
                        B(map, map2, sb.toString(), entry2.getValue(), g1Var);
                    }
                }
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("toJSON error", e8);
            }
        }
    }

    public static Object C(String str, String str2) {
        return c(str2).m(com.alibaba.fastjson.a.l(str));
    }

    public static boolean E(Object obj, String str) {
        return c(str).D(obj);
    }

    public static boolean J(Object obj, String str, Object obj2) {
        return c(str).H(obj, obj2);
    }

    public static int N(Object obj, String str) {
        g gVarC = c(str);
        return gVarC.o(gVarC.m(obj));
    }

    public static void a(Object obj, String str, Object... objArr) {
        c(str).b(obj, objArr);
    }

    public static g c(String str) {
        if (str == null) {
            throw new com.alibaba.fastjson.h("jsonpath can not be null");
        }
        g gVar = f12662e.get(str);
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(str);
        if (f12662e.size() >= 1024) {
            return gVar2;
        }
        f12662e.putIfAbsent(str, gVar2);
        return f12662e.get(str);
    }

    public static boolean e(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return c(str).d(obj);
    }

    public static boolean g(Object obj, String str, Object obj2) {
        return c(str).f(obj, obj2);
    }

    static boolean j(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return l((Number) obj, (Number) obj2);
        }
        return false;
    }

    static boolean l(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean zX = x(cls);
        Class<?> cls2 = number2.getClass();
        boolean zX2 = x(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (zX2) {
                return bigDecimal.equals(BigDecimal.valueOf(number2.longValue()));
            }
        }
        if (zX) {
            if (zX2) {
                return number.longValue() == number2.longValue();
            }
            if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (zX2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(number2.longValue()));
        }
        boolean zW = w(cls);
        boolean zW2 = w(cls2);
        return ((zW && zW2) || ((zW && zX2) || (zW2 && zX))) && number.doubleValue() == number2.doubleValue();
    }

    public static Object n(Object obj, String str) {
        return c(str).m(obj);
    }

    protected static boolean w(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean x(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> y(Object obj) {
        return z(obj, g1.f13055g);
    }

    public static Map<String, Object> z(Object obj, g1 g1Var) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap map = new HashMap();
        B(identityHashMap, map, "/", obj, g1Var);
        return map;
    }

    public boolean D(Object obj) {
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        v();
        Object objA = obj;
        int i7 = 0;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i7 < uVarArr.length) {
                if (i7 == uVarArr.length - 1) {
                    break;
                }
                objA = uVarArr[i7].a(this, obj, objA);
                if (objA != null) {
                    i7++;
                }
            }
            objA = null;
            break;
        }
        if (objA == null) {
            return false;
        }
        u[] uVarArr2 = this.f12666b;
        u uVar = uVarArr2[uVarArr2.length - 1];
        if (!(uVar instanceof r)) {
            if (uVar instanceof a) {
                return ((a) uVar).b(this, objA);
            }
            throw new UnsupportedOperationException();
        }
        r rVar = (r) uVar;
        if ((objA instanceof Collection) && uVarArr2.length > 1) {
            u uVar2 = uVarArr2[uVarArr2.length - 2];
            if ((uVar2 instanceof s) || (uVar2 instanceof m)) {
                Iterator it = ((Collection) objA).iterator();
                while (it.hasNext()) {
                    if (rVar.c(this, it.next())) {
                        z7 = true;
                    }
                }
                return z7;
            }
        }
        return rVar.c(this, objA);
    }

    public boolean F(g gVar, Object obj, int i7) {
        if (!(obj instanceof List)) {
            throw new com.alibaba.fastjson.h("unsupported set operation." + obj.getClass());
        }
        List list = (List) obj;
        if (i7 >= 0) {
            if (i7 >= list.size()) {
                return false;
            }
            list.remove(i7);
            return true;
        }
        int size = list.size() + i7;
        if (size < 0) {
            return false;
        }
        list.remove(size);
        return true;
    }

    protected boolean G(Object obj, String str) {
        if (obj instanceof Map) {
            return ((Map) obj).remove(str) != null;
        }
        e1 e1VarN = this.f12668d.n(obj.getClass());
        com.alibaba.fastjson.parser.deserializer.n nVar = e1VarN instanceof com.alibaba.fastjson.parser.deserializer.n ? (com.alibaba.fastjson.parser.deserializer.n) e1VarN : null;
        if (nVar == null) {
            throw new UnsupportedOperationException();
        }
        com.alibaba.fastjson.parser.deserializer.k kVarK = nVar.k(str);
        if (kVarK == null) {
            return false;
        }
        kVarK.f(obj, null);
        return true;
    }

    public boolean H(Object obj, Object obj2) {
        return I(obj, obj2, true);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    public boolean I(Object obj, Object obj2, boolean z7) {
        Class<?> cls;
        com.alibaba.fastjson.parser.deserializer.n nVarQ;
        if (obj == null) {
            return false;
        }
        v();
        Object obj3 = obj;
        int i7 = 0;
        Object obj4 = null;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i7 >= uVarArr.length) {
                obj3 = obj4;
                break;
            }
            u uVar = uVarArr[i7];
            Object objA = uVar.a(this, obj, obj3);
            if (objA == null) {
                u[] uVarArr2 = this.f12666b;
                u uVar2 = i7 < uVarArr2.length - 1 ? uVarArr2[i7 + 1] : null;
                if (uVar2 instanceof r) {
                    if (uVar instanceof r) {
                        String str = ((r) uVar).f12735a;
                        com.alibaba.fastjson.parser.deserializer.n nVarQ2 = q(obj3.getClass());
                        if (nVarQ2 != null) {
                            cls = nVarQ2.k(str).f12897a.f13297e;
                            nVarQ = q(cls);
                        } else {
                            cls = null;
                            nVarQ = null;
                        }
                    } else {
                        cls = null;
                        nVarQ = null;
                    }
                    if (nVarQ == null) {
                        objA = new com.alibaba.fastjson.e();
                    } else {
                        if (nVarQ.f12905d.f13343c == null) {
                            return false;
                        }
                        objA = nVarQ.d(null, cls);
                    }
                } else {
                    objA = uVar2 instanceof a ? new com.alibaba.fastjson.b() : null;
                }
                if (objA != null) {
                    if (!(uVar instanceof r)) {
                        if (!(uVar instanceof a)) {
                            break;
                        }
                        ((a) uVar).c(this, obj3, objA);
                    } else {
                        ((r) uVar).d(this, obj3, objA);
                    }
                } else {
                    break;
                }
            }
            i7++;
            obj4 = obj3;
            obj3 = objA;
        }
        if (obj3 == null) {
            return false;
        }
        u[] uVarArr3 = this.f12666b;
        u uVar3 = uVarArr3[uVarArr3.length - 1];
        if (uVar3 instanceof r) {
            ((r) uVar3).d(this, obj3, obj2);
            return true;
        }
        if (uVar3 instanceof a) {
            return ((a) uVar3).c(this, obj3, obj2);
        }
        throw new UnsupportedOperationException();
    }

    public boolean K(g gVar, Object obj, int i7, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i7 >= 0) {
                list.set(i7, obj2);
            } else {
                list.set(list.size() + i7, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new com.alibaba.fastjson.h("unsupported set operation." + cls);
        }
        int length = Array.getLength(obj);
        if (i7 >= 0) {
            if (i7 < length) {
                Array.set(obj, i7, obj2);
            }
        } else if (Math.abs(i7) <= length) {
            Array.set(obj, length + i7, obj2);
        }
        return true;
    }

    protected boolean L(Object obj, String str, long j7, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        }
        if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    L(obj3, str, j7, obj2);
                }
            }
            return true;
        }
        e1 e1VarN = this.f12668d.n(obj.getClass());
        com.alibaba.fastjson.parser.deserializer.n nVar = e1VarN instanceof com.alibaba.fastjson.parser.deserializer.n ? (com.alibaba.fastjson.parser.deserializer.n) e1VarN : null;
        if (nVar == null) {
            throw new UnsupportedOperationException();
        }
        com.alibaba.fastjson.parser.deserializer.k kVarJ = nVar.j(j7);
        if (kVarJ == null) {
            return false;
        }
        kVarJ.e(obj, obj2);
        return true;
    }

    public int M(Object obj) {
        if (obj == null) {
            return -1;
        }
        v();
        int i7 = 0;
        Object objA = obj;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i7 >= uVarArr.length) {
                return o(objA);
            }
            objA = uVarArr[i7].a(this, obj, objA);
            i7++;
        }
    }

    public void b(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        v();
        int i7 = 0;
        Object obj2 = null;
        Object objA = obj;
        int i8 = 0;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i8 >= uVarArr.length) {
                break;
            }
            if (i8 == uVarArr.length - 1) {
                obj2 = objA;
            }
            objA = uVarArr[i8].a(this, obj, objA);
            i8++;
        }
        if (objA == null) {
            throw new com.alibaba.fastjson.h("value not found in path " + this.f12665a);
        }
        if (objA instanceof Collection) {
            Collection collection = (Collection) objA;
            int length = objArr.length;
            while (i7 < length) {
                collection.add(objArr[i7]);
                i7++;
            }
            return;
        }
        Class<?> cls = objA.getClass();
        if (!cls.isArray()) {
            throw new com.alibaba.fastjson.d("unsupported array put operation. " + cls);
        }
        int length2 = Array.getLength(objA);
        Object objNewInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
        System.arraycopy(objA, 0, objNewInstance, 0, length2);
        while (i7 < objArr.length) {
            Array.set(objNewInstance, length2 + i7, objArr[i7]);
            i7++;
        }
        u[] uVarArr2 = this.f12666b;
        u uVar = uVarArr2[uVarArr2.length - 1];
        if (uVar instanceof r) {
            ((r) uVar).d(this, obj2, objNewInstance);
        } else {
            if (!(uVar instanceof a)) {
                throw new UnsupportedOperationException();
            }
            ((a) uVar).c(this, obj2, objNewInstance);
        }
    }

    public boolean d(Object obj) {
        if (obj == null) {
            return false;
        }
        v();
        Object objA = obj;
        int i7 = 0;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i7 >= uVarArr.length) {
                return true;
            }
            objA = uVarArr[i7].a(this, obj, objA);
            if (objA == null) {
                return false;
            }
            i7++;
        }
    }

    public boolean f(Object obj, Object obj2) {
        Object objM = m(obj);
        if (objM == obj2) {
            return true;
        }
        if (objM == null) {
            return false;
        }
        if (!(objM instanceof Iterable)) {
            return j(objM, obj2);
        }
        Iterator it = ((Iterable) objM).iterator();
        while (it.hasNext()) {
            if (j(it.next(), obj2)) {
                return true;
            }
        }
        return false;
    }

    protected void h(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                list.add(map.get(str));
                return;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                h(it.next(), str, list);
            }
            return;
        }
        p0 p0VarR = r(obj.getClass());
        if (p0VarR == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i7 = 0; i7 < list2.size(); i7++) {
                    h(list2.get(i7), str, list);
                }
                return;
            }
            return;
        }
        try {
            f0 f0VarV = p0VarR.v(str);
            if (f0VarV == null) {
                Iterator<Object> it2 = p0VarR.z(obj).iterator();
                while (it2.hasNext()) {
                    h(it2.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(f0VarV.c(obj));
                } catch (InvocationTargetException e8) {
                    throw new com.alibaba.fastjson.d("getFieldValue error." + str, e8);
                }
            } catch (IllegalAccessException e9) {
                throw new com.alibaba.fastjson.d("getFieldValue error." + str, e9);
            }
        } catch (Exception e10) {
            throw new com.alibaba.fastjson.h("jsonpath error, path " + this.f12665a + ", segement " + str, e10);
        }
    }

    protected void i(Object obj, String str, long j7, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            } else {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    i(it.next(), str, j7, obj2);
                }
                return;
            }
        }
        Class<?> cls = obj.getClass();
        com.alibaba.fastjson.parser.deserializer.n nVarQ = q(cls);
        if (nVarQ == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i(list.get(i7), str, j7, obj2);
                }
                return;
            }
            return;
        }
        try {
            com.alibaba.fastjson.parser.deserializer.k kVarK = nVarQ.k(str);
            if (kVarK != null) {
                kVarK.e(obj, obj2);
                return;
            }
            Iterator<Object> it2 = r(cls).B(obj).iterator();
            while (it2.hasNext()) {
                i(it2.next(), str, j7, obj2);
            }
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.h("jsonpath error, path " + this.f12665a + ", segement " + str, e8);
        }
    }

    @Override // com.alibaba.fastjson.c
    public String k() {
        return com.alibaba.fastjson.a.y0(this.f12665a);
    }

    public Object m(Object obj) {
        if (obj == null) {
            return null;
        }
        v();
        int i7 = 0;
        Object objA = obj;
        while (true) {
            u[] uVarArr = this.f12666b;
            if (i7 >= uVarArr.length) {
                return objA;
            }
            objA = uVarArr[i7].a(this, obj, objA);
            i7++;
        }
    }

    int o(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i7++;
                }
            }
            return i7;
        }
        p0 p0VarR = r(obj.getClass());
        if (p0VarR == null) {
            return -1;
        }
        try {
            return p0VarR.C(obj);
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.h("evalSize error : " + this.f12665a, e8);
        }
    }

    protected Object p(Object obj, int i7) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i7 >= 0) {
                if (i7 < list.size()) {
                    return list.get(i7);
                }
                return null;
            }
            if (Math.abs(i7) <= list.size()) {
                return list.get(list.size() + i7);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i7 >= 0) {
                if (i7 < length) {
                    return Array.get(obj, i7);
                }
                return null;
            }
            if (Math.abs(i7) <= length) {
                return Array.get(obj, length + i7);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i7));
            return obj2 == null ? map.get(Integer.toString(i7)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            throw new UnsupportedOperationException();
        }
        int i8 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i8 == i7) {
                return obj3;
            }
            i8++;
        }
        return null;
    }

    protected com.alibaba.fastjson.parser.deserializer.n q(Class<?> cls) {
        e1 e1VarN = this.f12668d.n(cls);
        if (e1VarN instanceof com.alibaba.fastjson.parser.deserializer.n) {
            return (com.alibaba.fastjson.parser.deserializer.n) e1VarN;
        }
        return null;
    }

    protected p0 r(Class<?> cls) {
        y0 y0VarJ = this.f12667c.j(cls);
        if (y0VarJ instanceof p0) {
            return (p0) y0VarJ;
        }
        return null;
    }

    public String s() {
        return this.f12665a;
    }

    protected Object t(Object obj, String str, long j7) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            if (obj2 == null) {
                return (f12663f == j7 || f12664g == j7) ? Integer.valueOf(map.size()) : obj2;
            }
            return obj2;
        }
        p0 p0VarR = r(obj.getClass());
        if (p0VarR != null) {
            try {
                return p0VarR.y(obj, str, j7, false);
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.h("jsonpath error, path " + this.f12665a + ", segement " + str, e8);
            }
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (f12663f == j7 || f12664g == j7) {
                return Integer.valueOf(list.size());
            }
            com.alibaba.fastjson.b bVar = new com.alibaba.fastjson.b(list.size());
            for (int i7 = 0; i7 < list.size(); i7++) {
                Object obj3 = list.get(i7);
                if (obj3 == list) {
                    bVar.add(obj3);
                } else {
                    Object objT = t(obj3, str, j7);
                    if (objT instanceof Collection) {
                        bVar.addAll((Collection) objT);
                    } else if (objT != null) {
                        bVar.add(objT);
                    }
                }
            }
            return bVar;
        }
        if (obj instanceof Enum) {
            Enum r7 = (Enum) obj;
            if (-4270347329889690746L == j7) {
                return r7.name();
            }
            if (-1014497654951707614L == j7) {
                return Integer.valueOf(r7.ordinal());
            }
        }
        if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            if (8963398325558730460L == j7) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j7) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j7) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j7) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j7) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j7) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    protected Collection<Object> u(Object obj) {
        p0 p0VarR = r(obj.getClass());
        if (p0VarR == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            throw new UnsupportedOperationException();
        }
        try {
            return p0VarR.z(obj);
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.h("jsonpath error, path " + this.f12665a, e8);
        }
    }

    protected void v() {
        if (this.f12666b != null) {
            return;
        }
        if ("*".equals(this.f12665a)) {
            this.f12666b = new u[]{z.f12758a};
        } else {
            this.f12666b = new k(this.f12665a).c();
        }
    }

    public g(String str, g1 g1Var, com.alibaba.fastjson.parser.j jVar) {
        if (str == null || str.length() == 0) {
            throw new com.alibaba.fastjson.h("json-path can not be null or empty");
        }
        this.f12665a = str;
        this.f12667c = g1Var;
        this.f12668d = jVar;
    }

    static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<d> f12681b;

        public e(d dVar, d dVar2, boolean z7) {
            ArrayList arrayList = new ArrayList(2);
            this.f12681b = arrayList;
            arrayList.add(dVar);
            this.f12681b.add(dVar2);
            this.f12680a = z7;
        }

        @Override // com.alibaba.fastjson.g.d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            if (this.f12680a) {
                Iterator<d> it = this.f12681b.iterator();
                while (it.hasNext()) {
                    if (!it.next().a(gVar, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<d> it2 = this.f12681b.iterator();
            while (it2.hasNext()) {
                if (it2.next().a(gVar, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }

        public e(List<d> list, boolean z7) {
            this.f12680a = z7;
            this.f12681b = list;
        }
    }
}
