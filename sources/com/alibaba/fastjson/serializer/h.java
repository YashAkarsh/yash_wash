package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class h implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13068a = new h();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (b.a(obj)) {
            j1Var.d1('{', "value", c.a(obj).longValue());
            j1Var.write(125);
        } else if (e.a(obj)) {
            j1Var.V0('{', "value", f.a(obj).doubleValue());
            j1Var.write(125);
        }
    }
}
