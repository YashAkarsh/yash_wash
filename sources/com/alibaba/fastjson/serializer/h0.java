package com.alibaba.fastjson.serializer;

import com.google.common.collect.tc;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class h0 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h0 f13069a = new h0();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj instanceof tc) {
            n0Var.S(((tc) obj).asMap());
        }
    }
}
