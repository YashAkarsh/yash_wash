package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class r implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f13166a = new r();

    public static <T> T f(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 2) {
            T t7 = (T) dVar.h0();
            dVar.Q(16);
            return t7;
        }
        if (dVar.L0() == 3) {
            T t8 = (T) dVar.h0();
            dVar.Q(16);
            return t8;
        }
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.l.h(objX0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        try {
            return (T) f(bVar);
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("parseDecimal error, field : " + obj, e8);
        }
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        j1Var.write(j1Var.G(k1.WriteBigDecimalAsPlain) ? bigDecimal.toPlainString() : bigDecimal.toString());
        if (j1Var.G(k1.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            j1Var.write(46);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
