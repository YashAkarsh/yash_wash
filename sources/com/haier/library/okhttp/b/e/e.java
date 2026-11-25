package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.t;
import com.haier.library.okhttp.y;
import com.haier.library.okhttp.z;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.haier.library.a.j f27065a = com.haier.library.a.j.i("\"\\");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.haier.library.a.j f27066b = com.haier.library.a.j.i("\t ,=");

    private e() {
    }

    private static int a(com.haier.library.a.g gVar, byte b8) {
        int i7 = 0;
        while (!gVar.g() && gVar.q1(0L) == b8) {
            i7++;
            gVar.j();
        }
        return i7;
    }

    public static int b(String str, int i7) {
        char cCharAt;
        while (i7 < str.length() && ((cCharAt = str.charAt(i7)) == ' ' || cCharAt == '\t')) {
            i7++;
        }
        return i7;
    }

    public static int c(String str, int i7, String str2) {
        while (i7 < str.length() && str2.indexOf(str.charAt(i7)) == -1) {
            i7++;
        }
        return i7;
    }

    public static long d(com.haier.library.okhttp.a aVar) {
        return e(aVar.G());
    }

    public static long e(g0 g0Var) {
        return f(g0Var.e(com.google.common.net.c.f22134b));
    }

    private static long f(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static g0 g(g0 g0Var, g0 g0Var2) {
        Set<String> setT = t(g0Var2);
        if (setT.isEmpty()) {
            return new g0.a().e();
        }
        g0.a aVar = new g0.a();
        int iA = g0Var.a();
        for (int i7 = 0; i7 < iA; i7++) {
            String strD = g0Var.d(i7);
            if (setT.contains(strD)) {
                aVar.c(strD, g0Var.h(i7));
            }
        }
        return aVar.e();
    }

    private static String h(char c8, int i7) {
        char[] cArr = new char[i7];
        Arrays.fill(cArr, c8);
        return new String(cArr);
    }

    public static List<t> i(g0 g0Var, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < g0Var.a(); i7++) {
            if (str.equalsIgnoreCase(g0Var.d(i7))) {
                k(arrayList, new com.haier.library.a.g().b(g0Var.h(i7)));
            }
        }
        return arrayList;
    }

    public static void j(z zVar, h0 h0Var, g0 g0Var) {
        if (zVar == z.f27919a) {
            return;
        }
        List<y> listH = y.h(h0Var, g0Var);
        if (listH.isEmpty()) {
            return;
        }
        zVar.a(h0Var, listH);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x007d A[EDGE_INSN: B:61:0x007d->B:28:0x007d BREAK  A[LOOP:2: B:22:0x006a->B:51:0x00c5], SYNTHETIC] */
    private static void k(List<t> list, com.haier.library.a.g gVar) {
        String strS;
        while (true) {
            String strS2 = null;
            while (true) {
                if (strS2 == null) {
                    l(gVar);
                    strS2 = s(gVar);
                    if (strS2 == null) {
                        return;
                    }
                }
                boolean zL = l(gVar);
                String strS3 = s(gVar);
                if (strS3 == null) {
                    if (gVar.g()) {
                        list.add(new t(strS2, (Map<String, String>) Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                int iA = a(gVar, (byte) 61);
                boolean zL2 = l(gVar);
                if (zL || !(zL2 || gVar.g())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iA2 = iA + a(gVar, (byte) 61);
                    while (true) {
                        if (strS3 == null) {
                            strS3 = s(gVar);
                            if (l(gVar)) {
                                break;
                            }
                            iA2 = a(gVar, (byte) 61);
                            if (iA2 == 0) {
                                break;
                            }
                            if (iA2 <= 1 || l(gVar)) {
                                return;
                            }
                            if (gVar.g() && gVar.q1(0L) == 34) {
                                strS = o(gVar);
                            } else {
                                strS = s(gVar);
                            }
                            if (strS != null || ((String) linkedHashMap.put(strS3, strS)) != null) {
                                return;
                            }
                            if (l(gVar) && !gVar.g()) {
                                return;
                            } else {
                                strS3 = null;
                            }
                        } else {
                            if (iA2 == 0) {
                                break;
                                break;
                            }
                            if (iA2 <= 1) {
                                return;
                            }
                            if (gVar.g()) {
                                strS = s(gVar);
                            } else {
                                strS = s(gVar);
                            }
                            if (strS != null) {
                                return;
                            }
                            if (l(gVar)) {
                            }
                            strS3 = null;
                        }
                    }
                    list.add(new t(strS2, linkedHashMap));
                    strS2 = strS3;
                } else {
                    list.add(new t(strS2, (Map<String, String>) Collections.singletonMap(null, strS3 + h('=', iA))));
                }
            }
        }
    }

    private static boolean l(com.haier.library.a.g gVar) {
        boolean z7 = false;
        while (!gVar.g()) {
            byte bQ1 = gVar.q1(0L);
            if (bQ1 != 44) {
                if (bQ1 != 32 && bQ1 != 9) {
                    break;
                }
                gVar.j();
            } else {
                gVar.j();
                z7 = true;
            }
        }
        return z7;
    }

    public static boolean m(com.haier.library.okhttp.a aVar, g0 g0Var, com.haier.library.okhttp.f fVar) {
        for (String str : v(aVar)) {
            if (!n.d.y(g0Var.l(str), fVar.e(str))) {
                return false;
            }
        }
        return true;
    }

    public static int n(String str, int i7) {
        try {
            long j7 = Long.parseLong(str);
            if (j7 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j7 < 0) {
                return 0;
            }
            return (int) j7;
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    private static String o(com.haier.library.a.g gVar) {
        if (gVar.j() != 34) {
            throw new IllegalArgumentException();
        }
        com.haier.library.a.g gVar2 = new com.haier.library.a.g();
        while (true) {
            long jA = gVar.a(f27065a);
            if (jA == -1) {
                return null;
            }
            if (gVar.q1(jA) == 34) {
                gVar2.I1(gVar, jA);
                gVar.j();
                return gVar2.T();
            }
            if (gVar.Y0() == jA + 1) {
                return null;
            }
            gVar2.I1(gVar, jA);
            gVar.j();
            gVar2.I1(gVar, 1L);
        }
    }

    public static boolean p(com.haier.library.okhttp.a aVar) {
        return q(aVar.G());
    }

    public static boolean q(g0 g0Var) {
        return t(g0Var).contains("*");
    }

    public static g0 r(com.haier.library.okhttp.a aVar) {
        return g(aVar.h0().v0().f(), aVar.G());
    }

    private static String s(com.haier.library.a.g gVar) {
        try {
            long jA = gVar.a(f27066b);
            if (jA == -1) {
                jA = gVar.Y0();
            }
            if (jA != 0) {
                return gVar.C1(jA);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static Set<String> t(g0 g0Var) {
        Set<String> setEmptySet = Collections.emptySet();
        int iA = g0Var.a();
        for (int i7 = 0; i7 < iA; i7++) {
            if (com.google.common.net.c.A0.equalsIgnoreCase(g0Var.d(i7))) {
                String strH = g0Var.h(i7);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strH.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static boolean u(com.haier.library.okhttp.a aVar) {
        if (aVar.v0().d().equals("HEAD")) {
            return false;
        }
        int iU = aVar.u();
        return (((iU >= 100 && iU < 200) || iU == 204 || iU == 304) && d(aVar) == -1 && !"chunked".equalsIgnoreCase(aVar.E(com.google.common.net.c.f22183z0))) ? false : true;
    }

    private static Set<String> v(com.haier.library.okhttp.a aVar) {
        return t(aVar.G());
    }
}
