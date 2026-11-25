package org.chromium.net.impl;

import android.content.Context;
import c.g1;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends org.chromium.net.s {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f39328q = Pattern.compile("^[0-9\\.]*$");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f39329r = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39330a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f39334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f39335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f39336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f39337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f39338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f39339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f39340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f39341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f39342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected long f39343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f39344o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f39331b = new LinkedList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f39332c = new LinkedList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f39345p = 20;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f39346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[][] f39347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f39348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Date f39349d;

        b(String str, byte[][] bArr, boolean z7, Date date) {
            this.f39346a = str;
            this.f39347b = bArr;
            this.f39348c = z7;
            this.f39349d = date;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f39350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f39351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f39352c;

        c(String str, int i7, int i8) {
            this.f39350a = str;
            this.f39351b = i7;
            this.f39352c = i8;
        }
    }

    public e(Context context) {
        this.f39330a = context.getApplicationContext();
        i(false);
        e(true);
        d(false);
        f(0, 0L);
        g(false);
        h(true);
    }

    private static String X(String str) throws IllegalArgumentException {
        if (f39328q.matcher(str).matches()) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. A hostname should not consist of digits and/or dots only.");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("Hostname " + str + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
        try {
            return IDN.toASCII(str, 2);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Hostname " + str + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
        }
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public e j(boolean z7) {
        return this;
    }

    public String B() {
        return this.f39342m;
    }

    Context C() {
        return this.f39330a;
    }

    String D() {
        return this.f39336g ? v.c(this.f39330a) : "";
    }

    String E() {
        return this.f39334e;
    }

    boolean F() {
        return this.f39337h;
    }

    long G() {
        return this.f39341l;
    }

    int H() {
        return this.f39340k;
    }

    VersionSafeCallbacks.b I() {
        return null;
    }

    long J() {
        return this.f39343n;
    }

    boolean K() {
        return this.f39344o;
    }

    boolean L() {
        return this.f39333d;
    }

    List<b> M() {
        return this.f39332c;
    }

    boolean N() {
        return this.f39336g;
    }

    List<c> O() {
        return this.f39331b;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public e l(String str) {
        this.f39342m = str;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public e m(org.chromium.net.j.a.b bVar) {
        return this;
    }

    @g1
    public e R(long j7) {
        this.f39343n = j7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public e n(String str) {
        if (!new File(str).isDirectory()) {
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        this.f39335f = str;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public e o(int i7) {
        if (i7 > 19 || i7 < -20) {
            throw new IllegalArgumentException("Thread priority invalid");
        }
        this.f39345p = i7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public e p(String str) {
        this.f39334e = str;
        return this;
    }

    String V() {
        return this.f39335f;
    }

    int W(int i7) {
        int i8 = this.f39345p;
        return i8 == 20 ? i7 : i8;
    }

    @Override // org.chromium.net.s
    public String k() {
        return v.b(this.f39330a);
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public e a(String str, Set<byte[]> set, boolean z7, Date date) {
        if (str == null) {
            throw new NullPointerException("The hostname cannot be null");
        }
        if (set == null) {
            throw new NullPointerException("The set of SHA256 pins cannot be null");
        }
        if (date == null) {
            throw new NullPointerException("The pin expiration date cannot be null");
        }
        String strX = X(str);
        HashSet hashSet = new HashSet(set.size());
        for (byte[] bArr : set) {
            if (bArr == null || bArr.length != 32) {
                throw new IllegalArgumentException("Public key pin is invalid");
            }
            hashSet.add(bArr);
        }
        this.f39332c.add(new b(strX, (byte[][]) hashSet.toArray(new byte[hashSet.size()][]), z7, date));
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e b(String str, int i7, int i8) {
        if (!str.contains("/")) {
            this.f39331b.add(new c(str, i7, i8));
            return this;
        }
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + str);
    }

    boolean s() {
        return this.f39338i;
    }

    boolean t() {
        return this.f39339j;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public e d(boolean z7) {
        this.f39338i = z7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public e e(boolean z7) {
        this.f39337h = z7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public e f(int i7, long j7) {
        if (i7 == 3 || i7 == 2) {
            if (V() == null) {
                throw new IllegalArgumentException("Storage path must be set");
            }
        } else if (V() != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        this.f39339j = i7 == 0 || i7 == 2;
        this.f39341l = j7;
        if (i7 == 0) {
            this.f39340k = 0;
        } else if (i7 == 1) {
            this.f39340k = 2;
        } else {
            if (i7 != 2 && i7 != 3) {
                throw new IllegalArgumentException("Unknown cache mode");
            }
            this.f39340k = 1;
        }
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public e g(boolean z7) {
        this.f39344o = z7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public e h(boolean z7) {
        this.f39333d = z7;
        return this;
    }

    @Override // org.chromium.net.s
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public e i(boolean z7) {
        this.f39336g = z7;
        return this;
    }
}
