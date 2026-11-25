package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class n1 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n1 f13152a = new n1();

    public static <T> T f(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVarH0 = bVar.h0();
        if (dVarH0.L0() == 4) {
            T t7 = (T) dVarH0.x0();
            dVarH0.Q(16);
            return t7;
        }
        if (dVarH0.L0() == 2) {
            T t8 = (T) dVarH0.R1();
            dVarH0.Q(16);
            return t8;
        }
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        return (T) objX0.toString();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
            if (dVar.L0() == 4) {
                String strX0 = dVar.x0();
                dVar.Q(16);
                return (T) new StringBuffer(strX0);
            }
            Object objX0 = bVar.x0();
            if (objX0 == null) {
                return null;
            }
            return (T) new StringBuffer(objX0.toString());
        }
        if (type != StringBuilder.class) {
            return (T) f(bVar);
        }
        com.alibaba.fastjson.parser.d dVar2 = bVar.f12789f;
        if (dVar2.L0() == 4) {
            String strX1 = dVar2.x0();
            dVar2.Q(16);
            return (T) new StringBuilder(strX1);
        }
        Object objX1 = bVar.x0();
        if (objX1 == null) {
            return null;
        }
        return (T) new StringBuilder(objX1.toString());
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        g(n0Var, (String) obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 4;
    }

    public void g(n0 n0Var, String str) {
        j1 j1Var = n0Var.f13143k;
        if (str == null) {
            j1Var.Z1(k1.WriteNullStringAsEmpty);
        } else {
            j1Var.a2(str);
        }
    }
}
