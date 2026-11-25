package com.alibaba.fastjson.parser.deserializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX INFO: loaded from: classes.dex */
public class d2 implements com.alibaba.fastjson.serializer.y0, e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d2 f12879a = new d2();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer numS = com.alibaba.fastjson.util.l.s(bVar.s1(Integer.class));
            return numS == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(numS.intValue());
        }
        if (type == OptionalLong.class) {
            Long lV = com.alibaba.fastjson.util.l.v(bVar.s1(Long.class));
            return lV == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(lV.longValue());
        }
        if (type == OptionalDouble.class) {
            Double dP = com.alibaba.fastjson.util.l.p(bVar.s1(Double.class));
            return dP == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(dP.doubleValue());
        }
        Object objW1 = bVar.w1(com.alibaba.fastjson.util.l.r0(type));
        return objW1 == null ? (T) Optional.empty() : (T) Optional.of(objW1);
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(com.alibaba.fastjson.serializer.n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        if (obj == null) {
            n0Var.V();
            return;
        }
        if (b2.a(obj)) {
            Optional optionalA = l1.a(obj);
            n0Var.S(optionalA.isPresent() ? optionalA.get() : null);
            return;
        }
        if (o1.a(obj)) {
            OptionalDouble optionalDoubleA = p1.a(obj);
            if (optionalDoubleA.isPresent()) {
                n0Var.S(Double.valueOf(optionalDoubleA.getAsDouble()));
                return;
            } else {
                n0Var.V();
                return;
            }
        }
        if (t1.a(obj)) {
            OptionalInt optionalIntA = u1.a(obj);
            if (optionalIntA.isPresent()) {
                n0Var.f13143k.N1(optionalIntA.getAsInt());
                return;
            } else {
                n0Var.V();
                return;
            }
        }
        if (!h1.a(obj)) {
            throw new com.alibaba.fastjson.d("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLongA = i1.a(obj);
        if (optionalLongA.isPresent()) {
            n0Var.f13143k.W1(optionalLongA.getAsLong());
        } else {
            n0Var.V();
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
