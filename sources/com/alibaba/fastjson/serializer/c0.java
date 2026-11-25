package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class c0 implements y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f13020b = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecimalFormat f13021a;

    public c0() {
        this.f13021a = null;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullNumberAsZero);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            j1Var.X1();
            return;
        }
        DecimalFormat decimalFormat = this.f13021a;
        if (decimalFormat == null) {
            j1Var.x0(dDoubleValue, true);
        } else {
            j1Var.write(decimalFormat.format(dDoubleValue));
        }
    }

    public c0(DecimalFormat decimalFormat) {
        this.f13021a = decimalFormat;
    }

    public c0(String str) {
        this(new DecimalFormat(str));
    }
}
