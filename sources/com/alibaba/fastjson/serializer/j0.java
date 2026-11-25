package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j0 f13084a = new j0();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
        } else {
            j1Var.write(((com.alibaba.fastjson.c) obj).k());
        }
    }
}
