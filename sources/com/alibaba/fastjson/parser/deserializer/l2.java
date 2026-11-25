package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.sql.Time;

/* JADX INFO: loaded from: classes.dex */
public class l2 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l2 f12900a = new l2();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        long timeInMillis;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 16) {
            dVar.Q(4);
            if (dVar.L0() != 4) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            dVar.v0(2);
            if (dVar.L0() != 2) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            long jQ = dVar.q();
            dVar.Q(13);
            if (dVar.L0() != 13) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            dVar.Q(16);
            return (T) new Time(jQ);
        }
        T t7 = (T) bVar.x0();
        if (t7 == 0) {
            return null;
        }
        if (t7 instanceof Time) {
            return t7;
        }
        if (t7 instanceof Number) {
            return (T) new Time(((Number) t7).longValue());
        }
        if (!(t7 instanceof String)) {
            throw new com.alibaba.fastjson.d("parse error");
        }
        String str = (String) t7;
        if (str.length() == 0) {
            return null;
        }
        com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(str);
        if (gVar.S2()) {
            timeInMillis = gVar.X1().getTimeInMillis();
        } else {
            boolean z7 = false;
            int i7 = 0;
            while (true) {
                if (i7 >= str.length()) {
                    z7 = true;
                    break;
                }
                char cCharAt = str.charAt(i7);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i7++;
            }
            if (!z7) {
                gVar.close();
                return (T) Time.valueOf(str);
            }
            timeInMillis = Long.parseLong(str);
        }
        gVar.close();
        return (T) new Time(timeInMillis);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }
}
