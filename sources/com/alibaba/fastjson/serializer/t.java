package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class t implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f13171a = new t();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Object obj2;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        try {
            if (dVar.L0() == 6) {
                dVar.Q(16);
                obj2 = (T) Boolean.TRUE;
            } else if (dVar.L0() == 7) {
                dVar.Q(16);
                obj2 = (T) Boolean.FALSE;
            } else if (dVar.L0() == 2) {
                int iH = dVar.H();
                dVar.Q(16);
                obj2 = iH == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
            } else {
                Object objX0 = bVar.x0();
                if (objX0 == null) {
                    return null;
                }
                obj2 = (T) com.alibaba.fastjson.util.l.j(objX0);
            }
            return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) obj2).booleanValue()) : (T) obj2;
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("parseBoolean error, field : " + obj, e8);
        }
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            j1Var.Z1(k1.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            j1Var.write("true");
        } else {
            j1Var.write(com.paytm.pgsdk.d.G);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 6;
    }
}
