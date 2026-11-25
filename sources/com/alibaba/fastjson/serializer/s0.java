package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f13170a = new s0();

    @Override // com.alibaba.fastjson.serializer.y0
    public final void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        char c8;
        j1 j1Var = n0Var.f13143k;
        k1 k1Var = k1.WriteClassName;
        boolean z7 = j1Var.G(k1Var) || k1.d(i7, k1Var);
        j1 j1Var2 = n0Var.f13143k;
        Type typeQ = z7 ? com.alibaba.fastjson.util.l.Q(type) : null;
        if (obj == null) {
            j1Var2.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            j1Var2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        e1 e1Var = n0Var.f13149q;
        n0Var.L(e1Var, obj, obj2, 0);
        try {
            char c9 = ',';
            char c10 = ']';
            if (j1Var2.G(k1.PrettyFormat)) {
                j1Var2.append('[');
                n0Var.F();
                int i8 = 0;
                for (Object obj3 : list) {
                    if (i8 != 0) {
                        j1Var2.append(c9);
                    }
                    n0Var.J();
                    if (obj3 == null) {
                        n0Var.f13143k.X1();
                    } else if (n0Var.u(obj3)) {
                        n0Var.W(obj3);
                    } else {
                        y0 y0VarB = n0Var.B(obj3.getClass());
                        n0Var.f13149q = new e1(e1Var, obj, obj2, 0, 0);
                        y0VarB.c(n0Var, obj3, Integer.valueOf(i8), typeQ, i7);
                    }
                    i8++;
                    c10 = c10;
                    c9 = ',';
                }
                n0Var.v();
                n0Var.J();
                j1Var2.append(c10);
                return;
            }
            char c11 = ']';
            j1Var2.append('[');
            int size = list.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj4 = list.get(i9);
                if (i9 != 0) {
                    c8 = ',';
                    j1Var2.append(',');
                } else {
                    c8 = ',';
                }
                if (obj4 == null) {
                    j1Var2.append("null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        j1Var2.N1(((Integer) obj4).intValue());
                    } else {
                        if (cls == Long.class) {
                            long jLongValue = ((Long) obj4).longValue();
                            if (z7) {
                                j1Var2.W1(jLongValue);
                                j1Var2.write(76);
                            } else {
                                j1Var2.W1(jLongValue);
                            }
                        } else if ((k1.DisableCircularReferenceDetect.f13132a & i7) != 0) {
                            n0Var.B(obj4.getClass()).c(n0Var, obj4, Integer.valueOf(i9), typeQ, i7);
                            z7 = z7;
                        } else {
                            i9 = i9;
                            if (!j1Var2.f13095h) {
                                n0Var.f13149q = new e1(e1Var, obj, obj2, 0, 0);
                            }
                            if (n0Var.u(obj4)) {
                                n0Var.W(obj4);
                            } else {
                                y0 y0VarB2 = n0Var.B(obj4.getClass());
                                if ((k1.WriteClassName.f13132a & i7) == 0 || !(y0VarB2 instanceof p0)) {
                                    y0VarB2.c(n0Var, obj4, Integer.valueOf(i9), typeQ, i7);
                                } else {
                                    ((p0) y0VarB2).N(n0Var, obj4, Integer.valueOf(i9), typeQ, i7);
                                }
                            }
                        }
                        i9++;
                        z7 = z7;
                        c11 = ']';
                    }
                }
                z7 = z7;
                i9++;
                z7 = z7;
                c11 = ']';
            }
            j1Var2.append(c11);
        } finally {
            n0Var.f13149q = e1Var;
        }
    }
}
