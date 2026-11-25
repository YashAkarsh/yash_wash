package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class i2 extends b implements e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i2 f12893b = new i2();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i2 f12894c = new i2(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12895a = false;

    public i2() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.b
    protected <T> T g(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (this.f12895a) {
            return (T) h(bVar, type, obj, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new java.sql.Date(((Date) obj2).getTime());
        }
        if (obj2 instanceof Number) {
            return (T) new java.sql.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new com.alibaba.fastjson.d("parse error : " + obj2);
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(str);
        try {
            if (gVar.S2()) {
                timeInMillis = gVar.X1().getTimeInMillis();
            } else {
                try {
                    T t7 = (T) new java.sql.Date(bVar.F().parse(str).getTime());
                    gVar.close();
                    return t7;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            gVar.close();
            return (T) new java.sql.Date(timeInMillis);
        } catch (Throwable th) {
            gVar.close();
            throw th;
        }
    }

    protected <T> T h(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new Timestamp(((Date) obj2).getTime());
        }
        if (obj2 instanceof Number) {
            return (T) new Timestamp(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new com.alibaba.fastjson.d("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(str);
        try {
            if (gVar.S2()) {
                timeInMillis = gVar.X1().getTimeInMillis();
            } else {
                try {
                    T t7 = (T) new Timestamp(bVar.F().parse(str).getTime());
                    gVar.close();
                    return t7;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            gVar.close();
            return (T) new Timestamp(timeInMillis);
        } catch (Throwable th) {
            gVar.close();
            throw th;
        }
    }

    public i2(boolean z7) {
    }
}
