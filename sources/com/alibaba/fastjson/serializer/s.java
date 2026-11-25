package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class s implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f13169a = new s();

    public static <T> T f(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 2) {
            String strR1 = dVar.R1();
            dVar.Q(16);
            return (T) new BigInteger(strR1);
        }
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.l.i(objX0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        return (T) f(bVar);
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullNumberAsZero);
        } else {
            j1Var.write(((BigInteger) obj).toString());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
