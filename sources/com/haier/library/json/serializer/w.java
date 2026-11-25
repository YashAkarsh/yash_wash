package com.haier.library.json.serializer;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f26855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f26856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f26857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26858d;

    public w(w wVar, Object obj, Object obj2, int i7) {
        this.f26855a = wVar;
        this.f26856b = obj;
        this.f26857c = obj2;
        this.f26858d = i7;
    }

    public String toString() {
        if (this.f26855a == null) {
            return "$";
        }
        if (!(this.f26857c instanceof Integer)) {
            return this.f26855a.toString() + com.alibaba.android.arouter.utils.b.f12515h + this.f26857c;
        }
        return this.f26855a.toString() + "[" + this.f26857c + "]";
    }
}
