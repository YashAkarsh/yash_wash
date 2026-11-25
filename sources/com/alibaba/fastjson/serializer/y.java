package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class y implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f13184a = new y();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.alibaba.fastjson.b, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (bVar.f12789f.L0() == 8) {
            bVar.f12789f.Q(16);
            return null;
        }
        if (type == com.alibaba.fastjson.b.class) {
            ?? r7 = (T) new com.alibaba.fastjson.b();
            bVar.V0(r7);
            return r7;
        }
        ?? r8 = (T) com.alibaba.fastjson.util.l.I(type);
        bVar.T0(com.alibaba.fastjson.util.l.Q(type), r8, obj);
        return r8;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        k1 k1Var = k1.WriteClassName;
        Type typeQ = (j1Var.G(k1Var) || k1.d(i7, k1Var)) ? com.alibaba.fastjson.util.l.Q(type) : null;
        Collection collection = (Collection) obj;
        e1 e1Var = n0Var.f13149q;
        int i8 = 0;
        n0Var.L(e1Var, obj, obj2, 0);
        if (j1Var.G(k1Var)) {
            if (HashSet.class == collection.getClass()) {
                j1Var.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                j1Var.append("TreeSet");
            }
        }
        try {
            j1Var.append('[');
            for (Object obj3 : collection) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    j1Var.append(',');
                }
                if (obj3 == null) {
                    j1Var.X1();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        j1Var.N1(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        j1Var.W1(((Long) obj3).longValue());
                        if (j1Var.G(k1.WriteClassName)) {
                            j1Var.write(76);
                        }
                    } else {
                        y0 y0VarB = n0Var.B(cls);
                        if (k1.d(i7, k1.WriteClassName) && (y0VarB instanceof p0)) {
                            ((p0) y0VarB).N(n0Var, obj3, Integer.valueOf(i9 - 1), typeQ, i7);
                        } else {
                            y0VarB.c(n0Var, obj3, Integer.valueOf(i9 - 1), typeQ, i7);
                        }
                    }
                }
                i8 = i9;
            }
            j1Var.append(']');
        } finally {
            n0Var.f13149q = e1Var;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 14;
    }
}
