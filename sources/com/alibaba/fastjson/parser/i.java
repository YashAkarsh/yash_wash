package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f12966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f12968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient String f12969e;

    public i(i iVar, Object obj, Object obj2) {
        this.f12966b = iVar;
        this.f12965a = obj;
        this.f12967c = obj2;
    }

    public String toString() {
        if (this.f12969e == null) {
            if (this.f12966b == null) {
                this.f12969e = "$";
            } else if (this.f12967c instanceof Integer) {
                this.f12969e = this.f12966b.toString() + "[" + this.f12967c + "]";
            } else {
                this.f12969e = this.f12966b.toString() + com.alibaba.android.arouter.utils.b.f12515h + this.f12967c;
            }
        }
        return this.f12969e;
    }
}
