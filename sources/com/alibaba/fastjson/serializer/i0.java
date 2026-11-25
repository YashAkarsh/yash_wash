package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class i0 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i0 f13073a = new i0();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Object obj2;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iL0 = dVar.L0();
        if (iL0 == 8) {
            dVar.Q(16);
            return null;
        }
        try {
            if (iL0 == 2) {
                int iH = dVar.H();
                dVar.Q(16);
                obj2 = (T) Integer.valueOf(iH);
            } else if (iL0 == 3) {
                BigDecimal bigDecimalH0 = dVar.h0();
                dVar.Q(16);
                obj2 = (T) Integer.valueOf(bigDecimalH0.intValue());
            } else if (iL0 == 12) {
                com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(true);
                bVar.A1(eVar);
                obj2 = (T) com.alibaba.fastjson.util.l.s(eVar);
            } else {
                obj2 = (T) com.alibaba.fastjson.util.l.s(bVar.x0());
            }
            obj = AtomicInteger.class;
            return type == obj ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("parseInt error, field : " + obj, e8);
        }
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        Number number = (Number) obj;
        if (number == null) {
            j1Var.Z1(k1.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            j1Var.W1(number.longValue());
        } else {
            j1Var.N1(number.intValue());
        }
        if (j1Var.G(k1.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                j1Var.write(66);
            } else if (cls == Short.class) {
                j1Var.write(83);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
