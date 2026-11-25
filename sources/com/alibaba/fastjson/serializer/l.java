package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class l implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f13133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y0 f13134b;

    public l(Class<?> cls, y0 y0Var) {
        this.f13133a = cls;
        this.f13134b = y0Var;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public final void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        e1 e1Var = n0Var.f13149q;
        n0Var.L(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            for (int i8 = 0; i8 < length; i8++) {
                if (i8 != 0) {
                    j1Var.append(',');
                }
                Object obj3 = objArr[i8];
                if (obj3 == null) {
                    if (j1Var.G(k1.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        j1Var.a2("");
                    } else {
                        j1Var.append("null");
                    }
                } else if (obj3.getClass() == this.f13133a) {
                    this.f13134b.c(n0Var, obj3, Integer.valueOf(i8), null, 0);
                } else {
                    n0Var.B(obj3.getClass()).c(n0Var, obj3, Integer.valueOf(i8), null, 0);
                }
            }
            j1Var.append(']');
        } finally {
            n0Var.f13149q = e1Var;
        }
    }
}
