package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class k implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f13106a = new k();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        if (obj == null) {
            n0Var.f13143k.Z1(k1.WriteNullStringAsEmpty);
        } else {
            n0Var.T(obj.toString());
        }
    }
}
