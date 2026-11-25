package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final p f6096b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f6097a;

    @c.t0(21)
    static class a {
        private a() {
        }

        @c.t
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @c.t0(24)
    static class b {
        private b() {
        }

        @c.t
        static LocaleList a(Locale... localeArr) {
            t.a();
            return s.a(localeArr);
        }

        @c.t
        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @c.t
        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private p(v vVar) {
        this.f6097a = vVar;
    }

    @c.m0
    public static p a(@c.m0 Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? n(b.a(localeArr)) : new p(new u(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @c.m0
    public static p c(@c.o0 String str) {
        if (str == null || str.isEmpty()) {
            return g();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i7 = 0; i7 < length; i7++) {
            localeArr[i7] = a.a(strArrSplit[i7]);
        }
        return a(localeArr);
    }

    @c.m0
    @c.y0(min = 1)
    public static p e() {
        return Build.VERSION.SDK_INT >= 24 ? n(b.b()) : a(Locale.getDefault());
    }

    @c.m0
    @c.y0(min = 1)
    public static p f() {
        return Build.VERSION.SDK_INT >= 24 ? n(b.c()) : a(Locale.getDefault());
    }

    @c.m0
    public static p g() {
        return f6096b;
    }

    @c.t0(24)
    @c.m0
    public static p n(@c.m0 LocaleList localeList) {
        return new p(new e0(localeList));
    }

    @c.t0(24)
    @Deprecated
    public static p o(Object obj) {
        return n(o.a(obj));
    }

    @c.o0
    public Locale d(int i7) {
        return this.f6097a.get(i7);
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && this.f6097a.equals(((p) obj).f6097a);
    }

    @c.o0
    public Locale h(@c.m0 String[] strArr) {
        return this.f6097a.d(strArr);
    }

    public int hashCode() {
        return this.f6097a.hashCode();
    }

    @c.e0(from = -1)
    public int i(@c.o0 Locale locale) {
        return this.f6097a.a(locale);
    }

    public boolean j() {
        return this.f6097a.isEmpty();
    }

    @c.e0(from = 0)
    public int k() {
        return this.f6097a.size();
    }

    @c.m0
    public String l() {
        return this.f6097a.b();
    }

    @c.o0
    public Object m() {
        return this.f6097a.c();
    }

    @c.m0
    public String toString() {
        return this.f6097a.toString();
    }
}
