package com.haier.library.json.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f26764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f26765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f26766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f26767d;

    public l(l lVar, Object obj, Object obj2) {
        this.f26765b = lVar;
        this.f26764a = obj;
        this.f26766c = obj2;
    }

    public String toString() {
        if (this.f26765b == null) {
            return "$";
        }
        if (!(this.f26766c instanceof Integer)) {
            return this.f26765b.toString() + com.alibaba.android.arouter.utils.b.f12515h + this.f26766c;
        }
        return this.f26765b.toString() + "[" + this.f26766c + "]";
    }
}
