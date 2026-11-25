package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes.dex */
public class e0 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e0 f13024a = new e0();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        int i8 = 0;
        Type type2 = (j1Var.G(k1.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        e1 e1Var = n0Var.f13149q;
        n0Var.L(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i9 = i8 + 1;
                if (i8 != 0) {
                    j1Var.append(',');
                }
                if (objNextElement == null) {
                    j1Var.X1();
                } else {
                    n0Var.B(objNextElement.getClass()).c(n0Var, objNextElement, Integer.valueOf(i9 - 1), type2, 0);
                }
                i8 = i9;
            }
            j1Var.append(']');
        } finally {
            n0Var.f13149q = e1Var;
        }
    }
}
