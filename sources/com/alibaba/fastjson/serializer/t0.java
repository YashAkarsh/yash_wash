package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class t0 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t0 f13172a = new t0();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Object objV;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        try {
            int iL0 = dVar.L0();
            if (iL0 == 2) {
                long jQ = dVar.q();
                dVar.Q(16);
                objV = (T) Long.valueOf(jQ);
            } else {
                if (iL0 == 12) {
                    com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(true);
                    bVar.A1(eVar);
                    objV = (T) com.alibaba.fastjson.util.l.v(eVar);
                } else {
                    objV = com.alibaba.fastjson.util.l.v(bVar.x0());
                }
                if (objV == null) {
                    return null;
                }
            }
            return type == AtomicLong.class ? (T) new AtomicLong(((Long) objV).longValue()) : (T) objV;
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("parseLong error, field : " + obj, e8);
        }
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullNumberAsZero);
            return;
        }
        long jLongValue = ((Long) obj).longValue();
        j1Var.W1(jLongValue);
        if (!j1Var.G(k1.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        j1Var.write(76);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
