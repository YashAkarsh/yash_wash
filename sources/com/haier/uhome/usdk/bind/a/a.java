package com.haier.uhome.usdk.bind.a;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f31487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f31488c;

    public a(int i7) {
        this(i7, "", "");
    }

    public int a() {
        return this.f31486a;
    }

    public String b() {
        return this.f31487b;
    }

    public String c() {
        return this.f31488c;
    }

    public String toString() {
        return "BindState{code=" + this.f31486a + ", name='" + this.f31487b + "', desc='" + this.f31488c + "'}";
    }

    public a(int i7, String str, String str2) {
        this.f31486a = i7;
        this.f31487b = str;
        this.f31488c = str2;
    }
}
