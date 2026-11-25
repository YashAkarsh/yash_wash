package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23890b;

    public b(int i7, int i8) {
        this.f23889a = i7;
        this.f23890b = i8;
    }

    public final int a() {
        return this.f23890b;
    }

    public final int b() {
        return this.f23889a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f23889a == bVar.f23889a && this.f23890b == bVar.f23890b;
    }

    public final int hashCode() {
        return this.f23889a ^ this.f23890b;
    }

    public final String toString() {
        return this.f23889a + "(" + this.f23890b + ')';
    }
}
