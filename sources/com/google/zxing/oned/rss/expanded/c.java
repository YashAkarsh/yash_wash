package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f23909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23911c;

    c(List<b> list, int i7, boolean z7) {
        this.f23909a = new ArrayList(list);
        this.f23910b = i7;
        this.f23911c = z7;
    }

    List<b> a() {
        return this.f23909a;
    }

    int b() {
        return this.f23910b;
    }

    boolean c(List<b> list) {
        return this.f23909a.equals(list);
    }

    boolean d() {
        return this.f23911c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f23909a.equals(cVar.a()) && this.f23911c == cVar.f23911c;
    }

    public int hashCode() {
        return this.f23909a.hashCode() ^ Boolean.valueOf(this.f23911c).hashCode();
    }

    public String toString() {
        return "{ " + this.f23909a + " }";
    }
}
