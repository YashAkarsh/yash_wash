package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class l1 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13135a;

    public l1(String str) {
        this.f13135a = str;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        if (obj == null) {
            n0Var.f13143k.X1();
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f13135a, n0Var.f13151s);
        simpleDateFormat.setTimeZone(n0Var.f13150r);
        n0Var.T(simpleDateFormat.format((Date) obj));
    }
}
