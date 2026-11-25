package org.checkerframework.checker.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.h0;
import y5.f;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38563a = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Pattern f38564b = Pattern.compile(f38563a);

    /* JADX INFO: renamed from: org.checkerframework.checker.formatter.a$a, reason: collision with other inner class name */
    private static class C0517a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y5.a f38566b;

        public C0517a(char c8, int i7) {
            this.f38565a = i7;
            this.f38566b = y5.a.c(c8);
        }

        y5.a a() {
            return this.f38566b;
        }

        int b() {
            return this.f38565a;
        }
    }

    public static class b extends MissingFormatArgumentException {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f38567c = 17000126;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38569b;

        public b(int i7, int i8) {
            super("-");
            this.f38568a = i7;
            this.f38569b = i8;
        }

        public int a() {
            return this.f38568a;
        }

        public int b() {
            return this.f38569b;
        }

        @Override // java.util.MissingFormatArgumentException, java.lang.Throwable
        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", Integer.valueOf(this.f38568a), Integer.valueOf(this.f38569b));
        }
    }

    public static class c extends IllegalFormatConversionException {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f38570c = 17000126;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y5.a f38571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y5.a f38572b;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(y5.a aVar, y5.a aVar2) {
            char cCharAt = aVar.f40652b.length() == 0 ? '-' : aVar.f40652b.charAt(0);
            Class<? extends Object>[] clsArr = aVar2.f40651a;
            super(cCharAt, clsArr == null ? Object.class : clsArr[0]);
            this.f38571a = aVar;
            this.f38572b = aVar2;
        }

        public y5.a a() {
            return this.f38571a;
        }

        public y5.a b() {
            return this.f38572b;
        }

        @Override // java.util.IllegalFormatConversionException, java.lang.Throwable
        public String getMessage() {
            return String.format("Expected category %s but found %s.", this.f38571a, this.f38572b);
        }
    }

    @f
    public static String a(String str, y5.a... aVarArr) throws IllegalFormatException {
        y5.a[] aVarArrC = c(str);
        if (aVarArrC.length != aVarArr.length) {
            throw new b(aVarArr.length, aVarArrC.length);
        }
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            if (aVarArr[i7] != aVarArrC[i7]) {
                throw new c(aVarArr[i7], aVarArrC[i7]);
            }
        }
        return str;
    }

    private static char b(Matcher matcher) {
        String strGroup = matcher.group(5);
        return strGroup == null ? matcher.group(6).charAt(0) : strGroup.charAt(0);
    }

    public static y5.a[] c(String str) throws IllegalFormatException {
        f(str);
        C0517a[] c0517aArrE = e(str);
        HashMap map = new HashMap();
        int iMax = -1;
        int i7 = -1;
        int i8 = -1;
        for (C0517a c0517a : c0517aArrE) {
            int iB = c0517a.b();
            if (iB != -1) {
                if (iB != 0) {
                    i8 = iB - 1;
                } else {
                    i7++;
                    i8 = i7;
                }
            }
            iMax = Math.max(iMax, i8);
            map.put(Integer.valueOf(i8), y5.a.d(map.containsKey(Integer.valueOf(i8)) ? (y5.a) map.get(Integer.valueOf(i8)) : y5.a.UNUSED, c0517a.a()));
        }
        y5.a[] aVarArr = new y5.a[iMax + 1];
        for (int i9 = 0; i9 <= iMax; i9++) {
            aVarArr[i9] = map.containsKey(Integer.valueOf(i9)) ? (y5.a) map.get(Integer.valueOf(i9)) : y5.a.UNUSED;
        }
        return aVarArr;
    }

    private static int d(Matcher matcher) {
        String strGroup = matcher.group(1);
        if (strGroup != null) {
            return Integer.parseInt(strGroup.substring(0, strGroup.length() - 1));
        }
        return (matcher.group(2) == null || !matcher.group(2).contains(String.valueOf(h0.f35379e))) ? 0 : -1;
    }

    private static C0517a[] e(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f38564b.matcher(str);
        while (matcher.find()) {
            char cB = b(matcher);
            if (cB != '%' && cB != 'n') {
                arrayList.add(new C0517a(cB, d(matcher)));
            }
        }
        return (C0517a[]) arrayList.toArray(new C0517a[arrayList.size()]);
    }

    public static void f(String str) throws IllegalFormatException {
        String.format(str, null);
    }
}
