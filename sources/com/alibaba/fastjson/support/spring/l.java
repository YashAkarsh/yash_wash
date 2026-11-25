package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.l0;
import com.alibaba.fastjson.serializer.n0;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class l implements l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13249c = "/**/";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13250d = k1.BrowserSecure.f13132a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f13251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13252b;

    public l(Object obj) {
        this.f13251a = obj;
    }

    @Override // com.alibaba.fastjson.serializer.l0
    public void a(n0 n0Var, Object obj, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (this.f13252b == null) {
            n0Var.S(this.f13251a);
            return;
        }
        int i8 = f13250d;
        if ((i7 & i8) != 0 || j1Var.F(i8)) {
            j1Var.write(f13249c);
        }
        j1Var.write(this.f13252b);
        j1Var.write(40);
        n0Var.S(this.f13251a);
        j1Var.write(41);
    }

    public String b() {
        return this.f13252b;
    }

    public Object c() {
        return this.f13251a;
    }

    public void d(String str) {
        this.f13252b = str;
    }

    public void e(Object obj) {
        this.f13251a = obj;
    }
}
