package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class k0 implements y0 {
    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        if (obj == null) {
            n0Var.f13143k.X1();
            return;
        }
        Date date = (Date) obj;
        com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e();
        eVar.put("date", Integer.valueOf(date.getDate()));
        eVar.put("day", Integer.valueOf(date.getDay()));
        eVar.put("hours", Integer.valueOf(date.getHours()));
        eVar.put("minutes", Integer.valueOf(date.getMinutes()));
        eVar.put("month", Integer.valueOf(date.getMonth()));
        eVar.put("seconds", Integer.valueOf(date.getSeconds()));
        eVar.put("time", Long.valueOf(date.getTime()));
        eVar.put("timezoneOffset", Integer.valueOf(date.getTimezoneOffset()));
        eVar.put("year", Integer.valueOf(date.getYear()));
        n0Var.S(eVar);
    }
}
