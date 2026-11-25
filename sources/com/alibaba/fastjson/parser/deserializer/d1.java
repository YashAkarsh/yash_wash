package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class d1 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f12878a = new d1();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v16, types: [T, java.lang.Number, java.lang.Object, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strR1 = dVar.R1();
                dVar.Q(16);
                return (T) Double.valueOf(Double.parseDouble(strR1));
            }
            long jQ = dVar.q();
            dVar.Q(16);
            if (type == Short.TYPE || type == Short.class) {
                if (jQ <= 32767 && jQ >= -32768) {
                    return (T) Short.valueOf((short) jQ);
                }
                throw new com.alibaba.fastjson.d("short overflow : " + jQ);
            }
            if (type != Byte.TYPE && type != Byte.class) {
                return (jQ < -2147483648L || jQ > 2147483647L) ? (T) Long.valueOf(jQ) : (T) Integer.valueOf((int) jQ);
            }
            if (jQ <= 127 && jQ >= -128) {
                return (T) Byte.valueOf((byte) jQ);
            }
            throw new com.alibaba.fastjson.d("short overflow : " + jQ);
        }
        if (dVar.L0() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String strR2 = dVar.R1();
                dVar.Q(16);
                return (T) Double.valueOf(Double.parseDouble(strR2));
            }
            ?? r13 = (T) dVar.h0();
            dVar.Q(16);
            if (type != Short.TYPE && type != Short.class) {
                return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r13.byteValue()) : r13;
            }
            if (r13.compareTo(BigDecimal.valueOf(32767L)) <= 0 && r13.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                return (T) Short.valueOf(r13.shortValue());
            }
            throw new com.alibaba.fastjson.d("short overflow : " + ((Object) r13));
        }
        if (dVar.L0() == 18 && "NaN".equals(dVar.x0())) {
            dVar.E();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        }
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            try {
                return (T) com.alibaba.fastjson.util.l.p(objX0);
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("parseDouble error, field : " + obj, e8);
            }
        }
        if (type == Short.TYPE || type == Short.class) {
            try {
                return (T) com.alibaba.fastjson.util.l.w(objX0);
            } catch (Exception e9) {
                throw new com.alibaba.fastjson.d("parseShort error, field : " + obj, e9);
            }
        }
        if (type != Byte.TYPE && type != Byte.class) {
            return (T) com.alibaba.fastjson.util.l.h(objX0);
        }
        try {
            return (T) com.alibaba.fastjson.util.l.k(objX0);
        } catch (Exception e10) {
            throw new com.alibaba.fastjson.d("parseByte error, field : " + obj, e10);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
