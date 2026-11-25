package androidx.core.os;

import c.g1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class u implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Locale[] f6110c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Locale f6111d = new Locale("en", "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Locale f6112e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Locale f6113f = p.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale[] f6114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    private final String f6115b;

    @c.t0(21)
    static class a {
        private a() {
        }

        @c.t
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    u(@c.m0 Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f6114a = f6110c;
            this.f6115b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < localeArr.length; i7++) {
            Locale locale = localeArr[i7];
            if (locale == null) {
                throw new NullPointerException("list[" + i7 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                k(sb, locale2);
                if (i7 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f6114a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f6115b = sb.toString();
    }

    private Locale e(Collection<String> collection, boolean z7) {
        int iF = f(collection, z7);
        if (iF == -1) {
            return null;
        }
        return this.f6114a[iF];
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001e  */
    private int f(Collection<String> collection, boolean z7) {
        int iG;
        Locale[] localeArr = this.f6114a;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        if (z7) {
            iG = g(f6113f);
            if (iG == 0) {
                return 0;
            }
            if (iG >= Integer.MAX_VALUE) {
                iG = Integer.MAX_VALUE;
            }
        } else {
            iG = Integer.MAX_VALUE;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            int iG2 = g(p.b(it.next()));
            if (iG2 == 0) {
                return 0;
            }
            if (iG2 < iG) {
                iG = iG2;
            }
        }
        if (iG == Integer.MAX_VALUE) {
            return 0;
        }
        return iG;
    }

    private int g(Locale locale) {
        int i7 = 0;
        while (true) {
            Locale[] localeArr = this.f6114a;
            if (i7 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (j(locale, localeArr[i7]) > 0) {
                return i7;
            }
            i7++;
        }
    }

    private static String h(Locale locale) {
        String strA = a.a(locale);
        return !strA.isEmpty() ? strA : "";
    }

    private static boolean i(Locale locale) {
        return f6111d.equals(locale) || f6112e.equals(locale);
    }

    @c.e0(from = 0, to = 1)
    private static int j(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || i(locale) || i(locale2)) {
            return 0;
        }
        String strH = h(locale);
        if (!strH.isEmpty()) {
            return strH.equals(h(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @g1
    static void k(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.v
    public int a(Locale locale) {
        int i7 = 0;
        while (true) {
            Locale[] localeArr = this.f6114a;
            if (i7 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i7].equals(locale)) {
                return i7;
            }
            i7++;
        }
    }

    @Override // androidx.core.os.v
    public String b() {
        return this.f6115b;
    }

    @Override // androidx.core.os.v
    @c.o0
    public Object c() {
        return null;
    }

    @Override // androidx.core.os.v
    public Locale d(@c.m0 String[] strArr) {
        return e(Arrays.asList(strArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        Locale[] localeArr = ((u) obj).f6114a;
        if (this.f6114a.length != localeArr.length) {
            return false;
        }
        int i7 = 0;
        while (true) {
            Locale[] localeArr2 = this.f6114a;
            if (i7 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i7].equals(localeArr[i7])) {
                return false;
            }
            i7++;
        }
    }

    @Override // androidx.core.os.v
    public Locale get(int i7) {
        if (i7 >= 0) {
            Locale[] localeArr = this.f6114a;
            if (i7 < localeArr.length) {
                return localeArr[i7];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f6114a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.v
    public boolean isEmpty() {
        return this.f6114a.length == 0;
    }

    @Override // androidx.core.os.v
    public int size() {
        return this.f6114a.length;
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i7 = 0;
        while (true) {
            Locale[] localeArr = this.f6114a;
            if (i7 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i7]);
            if (i7 < this.f6114a.length - 1) {
                sb.append(',');
            }
            i7++;
        }
    }
}
