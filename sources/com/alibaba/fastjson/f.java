package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.l0;
import com.alibaba.fastjson.serializer.n0;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f12658c = "/**/";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12659d = k1.BrowserSecure.f13132a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Object> f12661b = new ArrayList();

    public f() {
    }

    @Override // com.alibaba.fastjson.serializer.l0
    public void a(n0 n0Var, Object obj, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        int i8 = f12659d;
        if ((i7 & i8) != 0 || j1Var.F(i8)) {
            j1Var.write(f12658c);
        }
        j1Var.write(this.f12660a);
        j1Var.write(40);
        for (int i9 = 0; i9 < this.f12661b.size(); i9++) {
            if (i9 != 0) {
                j1Var.write(44);
            }
            n0Var.S(this.f12661b.get(i9));
        }
        j1Var.write(41);
    }

    public void b(Object obj) {
        this.f12661b.add(obj);
    }

    public String c() {
        return this.f12660a;
    }

    public List<Object> d() {
        return this.f12661b;
    }

    public void e(String str) {
        this.f12660a = str;
    }

    public String f() {
        return toString();
    }

    public String toString() {
        return a.y0(this);
    }

    public f(String str) {
        this.f12660a = str;
    }
}
