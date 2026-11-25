package com.haier.uhome.usdk.base.d;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f31264c;

    public d(String str) {
        this.f31262a = str;
    }

    public String toString() {
        return "EventMessage{token=" + this.f31262a + ", what=" + this.f31263b + ", obj=" + this.f31264c + '}';
    }

    public d(String str, int i7) {
        this(str);
        this.f31263b = i7;
    }

    public d(String str, Object obj) {
        this(str);
        this.f31264c = obj;
    }

    public d(String str, int i7, Object obj) {
        this(str, obj);
        this.f31263b = i7;
    }
}
