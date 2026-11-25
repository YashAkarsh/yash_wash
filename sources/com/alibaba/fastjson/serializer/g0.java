package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
public class g0 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g0 f13053b = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NumberFormat f13054a;

    public g0() {
    }

    public static <T> T f(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 2) {
            String strR1 = dVar.R1();
            dVar.Q(16);
            return (T) Float.valueOf(Float.parseFloat(strR1));
        }
        if (dVar.L0() == 3) {
            float fI0 = dVar.I0();
            dVar.Q(16);
            return (T) Float.valueOf(fI0);
        }
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.l.r(objX0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        try {
            return (T) f(bVar);
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
        float fFloatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f13054a;
        if (numberFormat != null) {
            j1Var.write(numberFormat.format(fFloatValue));
        } else {
            j1Var.A1(fFloatValue, true);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }

    public g0(DecimalFormat decimalFormat) {
        this.f13054a = decimalFormat;
    }

    public g0(String str) {
        this(new DecimalFormat(str));
    }
}
