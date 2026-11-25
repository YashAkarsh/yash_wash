package com.haier.library.okhttp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f27563a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f27564a = new ArrayList(20);

        public a a(g0 g0Var) {
            int iA = g0Var.a();
            for (int i7 = 0; i7 < iA; i7++) {
                j(g0Var.d(i7), g0Var.h(i7));
            }
            return this;
        }

        a b(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return j(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            return str.startsWith(":") ? j("", str.substring(1)) : j("", str);
        }

        public a c(String str, String str2) {
            g0.n(str);
            g0.g(str2, str);
            return j(str, str2);
        }

        public a d(String str, Date date) {
            if (date != null) {
                c(str, com.haier.library.okhttp.b.e.d.a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public g0 e() {
            return new g0(this);
        }

        public a f(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                return c(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public a g(String str, String str2) {
            g0.n(str);
            return j(str, str2);
        }

        public a h(String str, Date date) {
            if (date != null) {
                k(str, com.haier.library.okhttp.b.e.d.a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public a i(String str) {
            int i7 = 0;
            while (i7 < this.f27564a.size()) {
                if (str.equalsIgnoreCase(this.f27564a.get(i7))) {
                    this.f27564a.remove(i7);
                    this.f27564a.remove(i7);
                    i7 -= 2;
                }
                i7 += 2;
            }
            return this;
        }

        a j(String str, String str2) {
            this.f27564a.add(str);
            this.f27564a.add(str2.trim());
            return this;
        }

        public a k(String str, String str2) {
            g0.n(str);
            g0.g(str2, str);
            i(str);
            j(str, str2);
            return this;
        }

        public String l(String str) {
            for (int size = this.f27564a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f27564a.get(size))) {
                    return this.f27564a.get(size + 1);
                }
            }
            return null;
        }
    }

    g0(a aVar) {
        List<String> list = aVar.f27564a;
        this.f27563a = (String[]) list.toArray(new String[list.size()]);
    }

    public static g0 b(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[map.size() * 2];
        int i7 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = entry.getKey().trim();
            String strTrim2 = entry.getValue().trim();
            n(strTrim);
            g(strTrim2, strTrim);
            strArr[i7] = strTrim;
            strArr[i7 + 1] = strTrim2;
            i7 += 2;
        }
        return new g0(strArr);
    }

    public static g0 c(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i7 = 0; i7 < strArr2.length; i7++) {
            String str = strArr2[i7];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i7] = str.trim();
        }
        for (int i8 = 0; i8 < strArr2.length; i8 += 2) {
            String str2 = strArr2[i8];
            String str3 = strArr2[i8 + 1];
            n(str2);
            g(str3, str2);
        }
        return new g0(strArr2);
    }

    private static String f(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    static void g(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(n.d.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str2, str));
            }
        }
    }

    static void n(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(n.d.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str));
            }
        }
    }

    public int a() {
        return this.f27563a.length / 2;
    }

    public String d(int i7) {
        return this.f27563a[i7 * 2];
    }

    @Nullable
    public String e(String str) {
        return f(this.f27563a, str);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof g0) && Arrays.equals(((g0) obj).f27563a, this.f27563a);
    }

    public String h(int i7) {
        return this.f27563a[(i7 * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f27563a);
    }

    @Nullable
    public Date i(String str) {
        String strE = e(str);
        if (strE != null) {
            return com.haier.library.okhttp.b.e.d.b(strE);
        }
        return null;
    }

    public Set<String> j() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int iA = a();
        for (int i7 = 0; i7 < iA; i7++) {
            treeSet.add(d(i7));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public long k() {
        String[] strArr = this.f27563a;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i7 = 0; i7 < length2; i7++) {
            length += (long) this.f27563a[i7].length();
        }
        return length;
    }

    public List<String> l(String str) {
        int iA = a();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < iA; i7++) {
            if (str.equalsIgnoreCase(d(i7))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(h(i7));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public a m() {
        a aVar = new a();
        Collections.addAll(aVar.f27564a, this.f27563a);
        return aVar;
    }

    public Map<String, List<String>> o() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iA = a();
        for (int i7 = 0; i7 < iA; i7++) {
            String lowerCase = d(i7).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(h(i7));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iA = a();
        for (int i7 = 0; i7 < iA; i7++) {
            sb.append(d(i7));
            sb.append(": ");
            sb.append(h(i7));
            sb.append("\n");
        }
        return sb.toString();
    }

    private g0(String[] strArr) {
        this.f27563a = strArr;
    }
}
