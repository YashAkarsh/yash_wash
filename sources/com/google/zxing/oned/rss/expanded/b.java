package com.google.zxing.oned.rss.expanded;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.zxing.oned.rss.b f23906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.zxing.oned.rss.b f23907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.zxing.oned.rss.c f23908d;

    b(com.google.zxing.oned.rss.b bVar, com.google.zxing.oned.rss.b bVar2, com.google.zxing.oned.rss.c cVar, boolean z7) {
        this.f23906b = bVar;
        this.f23907c = bVar2;
        this.f23908d = cVar;
        this.f23905a = z7;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    com.google.zxing.oned.rss.c b() {
        return this.f23908d;
    }

    com.google.zxing.oned.rss.b c() {
        return this.f23906b;
    }

    com.google.zxing.oned.rss.b d() {
        return this.f23907c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f23906b, bVar.f23906b) && a(this.f23907c, bVar.f23907c) && a(this.f23908d, bVar.f23908d);
    }

    boolean f() {
        return this.f23905a;
    }

    public boolean g() {
        return this.f23907c == null;
    }

    public int hashCode() {
        return (e(this.f23906b) ^ e(this.f23907c)) ^ e(this.f23908d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f23906b);
        sb.append(" , ");
        sb.append(this.f23907c);
        sb.append(" : ");
        com.google.zxing.oned.rss.c cVar = this.f23908d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
