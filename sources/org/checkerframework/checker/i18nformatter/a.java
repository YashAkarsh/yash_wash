package org.checkerframework.checker.i18nformatter;

import androidx.constraintlayout.core.motion.utils.w;
import b6.i;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: org.checkerframework.checker.i18nformatter.a$a, reason: collision with other inner class name */
    private static class C0518a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b6.b f38574b;

        public C0518a(int i7, b6.b bVar) {
            this.f38573a = i7;
            this.f38574b = bVar;
        }

        public String toString() {
            return this.f38574b.toString() + "(index: " + this.f38573a + ")";
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f38575a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Locale f38576b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static List<b6.b> f38577c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static List<Integer> f38578d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static int f38579e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f38580f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f38581g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f38582h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f38583i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f38584j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f38585k = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f38586l = 2;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f38587m = 3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f38588n = 4;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f38590p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f38591q = 1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final int f38592r = 2;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final int f38593s = 3;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String[] f38589o = {"", "number", "date", "time", "choice"};

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final String[] f38594t = {"", "currency", "percent", w.b.f3027b};

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final String[] f38595u = {"", "short", "medium", "long", MessengerShareContentUtility.WEBVIEW_RATIO_FULL};

        private b() {
        }

        private static void a(String str) {
            StringBuilder[] sbArr = new StringBuilder[4];
            sbArr[0] = new StringBuilder();
            f38579e = 0;
            f38575a = -1;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            boolean z7 = false;
            while (i7 < str.length()) {
                char cCharAt = str.charAt(i7);
                if (i9 == 0) {
                    if (cCharAt == '\'') {
                        int i10 = i7 + 1;
                        if (i10 >= str.length() || str.charAt(i10) != '\'') {
                            z7 = !z7;
                        } else {
                            sbArr[i9].append(cCharAt);
                            i7 = i10;
                        }
                    } else if (cCharAt != '{' || z7) {
                        sbArr[i9].append(cCharAt);
                    } else {
                        if (sbArr[1] == null) {
                            sbArr[1] = new StringBuilder();
                        }
                        i9 = 1;
                    }
                } else if (z7) {
                    sbArr[i9].append(cCharAt);
                    if (cCharAt == '\'') {
                        z7 = false;
                    }
                } else if (cCharAt != ' ') {
                    if (cCharAt == '\'') {
                        sbArr[i9].append(cCharAt);
                        z7 = true;
                    } else if (cCharAt != ',') {
                        if (cCharAt == '{') {
                            i8++;
                            sbArr[i9].append(cCharAt);
                        } else if (cCharAt != '}') {
                            sbArr[i9].append(cCharAt);
                        } else if (i8 == 0) {
                            c(i7, f38579e, sbArr);
                            f38579e++;
                            sbArr[1] = null;
                            sbArr[2] = null;
                            sbArr[3] = null;
                            i9 = 0;
                        } else {
                            i8--;
                            sbArr[i9].append(cCharAt);
                        }
                    } else if (i9 < 3) {
                        i9++;
                        if (sbArr[i9] == null) {
                            sbArr[i9] = new StringBuilder();
                        }
                    } else {
                        sbArr[i9].append(cCharAt);
                    }
                } else if (i9 != 2 || sbArr[2].length() > 0) {
                    sbArr[i9].append(cCharAt);
                }
                i7++;
            }
            if (i8 != 0 || i9 == 0) {
                return;
            }
            f38575a = -1;
            throw new IllegalArgumentException("Unmatched braces in the pattern");
        }

        private static final int b(String str, String[] strArr) {
            for (int i7 = 0; i7 < strArr.length; i7++) {
                if (str.equals(strArr[i7])) {
                    return i7;
                }
            }
            String lowerCase = str.trim().toLowerCase(Locale.ROOT);
            if (lowerCase == str) {
                return -1;
            }
            for (int i8 = 0; i8 < strArr.length; i8++) {
                if (lowerCase.equals(strArr[i8])) {
                    return i8;
                }
            }
            return -1;
        }

        private static void c(int i7, int i8, StringBuilder[] sbArr) {
            b6.b bVar;
            int iB;
            String[] strArr = new String[sbArr.length];
            for (int i9 = 0; i9 < sbArr.length; i9++) {
                StringBuilder sb = sbArr[i9];
                strArr[i9] = sb != null ? sb.toString() : "";
            }
            try {
                int i10 = Integer.parseInt(strArr[1]);
                if (i10 < 0) {
                    throw new IllegalArgumentException("negative argument number: " + i10);
                }
                int i11 = f38575a;
                f38575a = i8;
                f38578d.add(Integer.valueOf(i10));
                if (strArr[2].length() == 0 || (iB = b(strArr[2], f38589o)) == 0) {
                    bVar = b6.b.GENERAL;
                } else if (iB == 1) {
                    int iB2 = b(strArr[3], f38594t);
                    if (iB2 != 0 && iB2 != 1 && iB2 != 2 && iB2 != 3) {
                        try {
                            new DecimalFormat(strArr[3], DecimalFormatSymbols.getInstance(f38576b));
                        } catch (IllegalArgumentException e8) {
                            f38575a = i11;
                            throw e8;
                        }
                    }
                    bVar = b6.b.NUMBER;
                } else if (iB == 2 || iB == 3) {
                    String str = strArr[3];
                    String[] strArr2 = f38595u;
                    int iB3 = b(str, strArr2);
                    if (iB3 < 0 || iB3 >= strArr2.length) {
                        try {
                            new SimpleDateFormat(strArr[3], f38576b);
                        } catch (IllegalArgumentException e9) {
                            f38575a = i11;
                            throw e9;
                        }
                    }
                    bVar = b6.b.DATE;
                } else {
                    if (iB != 4) {
                        f38575a = i11;
                        throw new IllegalArgumentException("unknown format type: " + strArr[2]);
                    }
                    if (strArr[3].length() == 0) {
                        throw new IllegalArgumentException("Choice Pattern requires Subformat Pattern: " + strArr[3]);
                    }
                    try {
                        new ChoiceFormat(strArr[3]);
                        bVar = b6.b.NUMBER;
                    } catch (Exception e10) {
                        f38575a = i11;
                        throw new IllegalArgumentException("Choice Pattern incorrect: " + strArr[3], e10);
                    }
                }
                f38577c.add(bVar);
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException("can't parse argument number: " + strArr[1], e11);
            }
        }

        public static C0518a[] d(String str) {
            f38577c = new ArrayList();
            f38578d = new ArrayList();
            f38576b = Locale.getDefault(Locale.Category.FORMAT);
            a(str);
            C0518a[] c0518aArr = new C0518a[f38579e];
            for (int i7 = 0; i7 < f38579e; i7++) {
                c0518aArr[i7] = new C0518a(f38578d.get(i7).intValue(), f38577c.get(i7));
            }
            return c0518aArr;
        }
    }

    public static b6.b[] a(String str) throws IllegalFormatException {
        d(str);
        C0518a[] c0518aArrD = b.d(str);
        HashMap map = new HashMap();
        int iMax = -1;
        for (C0518a c0518a : c0518aArrD) {
            int i7 = c0518a.f38573a;
            map.put(Integer.valueOf(i7), b6.b.b(c0518a.f38574b, map.containsKey(Integer.valueOf(i7)) ? (b6.b) map.get(Integer.valueOf(i7)) : b6.b.UNUSED));
            iMax = Math.max(iMax, i7);
        }
        b6.b[] bVarArr = new b6.b[iMax + 1];
        for (int i8 = 0; i8 <= iMax; i8++) {
            bVarArr[i8] = map.containsKey(Integer.valueOf(i8)) ? (b6.b) map.get(Integer.valueOf(i8)) : b6.b.UNUSED;
        }
        return bVarArr;
    }

    @b6.a
    public static boolean b(String str, b6.b... bVarArr) {
        b6.b[] bVarArrA = a(str);
        if (bVarArrA.length != bVarArr.length) {
            return false;
        }
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            if (!b6.b.c(bVarArr[i7], bVarArrA[i7])) {
                return false;
            }
        }
        return true;
    }

    @i
    public static boolean c(String str) {
        try {
            a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void d(String str) throws IllegalFormatException {
        MessageFormat.format(str, null);
    }
}
