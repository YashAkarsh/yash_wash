package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class m1 implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f13138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f13139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f13140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13141d;

    public m1(String... strArr) {
        this(null, strArr);
    }

    @Override // com.alibaba.fastjson.serializer.c1
    public boolean e(n0 n0Var, Object obj, String str) {
        if (obj == null) {
            return true;
        }
        Class<?> cls = this.f13138a;
        if (cls != null && !cls.isInstance(obj)) {
            return true;
        }
        if (this.f13140c.contains(str)) {
            return false;
        }
        if (this.f13141d > 0) {
            int i7 = 0;
            for (e1 e1Var = n0Var.f13149q; e1Var != null; e1Var = e1Var.f13025a) {
                i7++;
                if (i7 > this.f13141d) {
                    return false;
                }
            }
        }
        return this.f13139b.size() == 0 || this.f13139b.contains(str);
    }

    public Class<?> f() {
        return this.f13138a;
    }

    public Set<String> g() {
        return this.f13140c;
    }

    public Set<String> h() {
        return this.f13139b;
    }

    public int i() {
        return this.f13141d;
    }

    public void j(int i7) {
        this.f13141d = i7;
    }

    public m1(Class<?> cls, String... strArr) {
        this.f13139b = new HashSet();
        this.f13140c = new HashSet();
        this.f13141d = 0;
        this.f13138a = cls;
        for (String str : strArr) {
            if (str != null) {
                this.f13139b.add(str);
            }
        }
    }
}
