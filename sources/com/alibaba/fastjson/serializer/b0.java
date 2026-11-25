package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class b0 extends com.alibaba.fastjson.parser.deserializer.b implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f13019a = new b0();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        char[] charArray;
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        Date dateN = obj instanceof Date ? (Date) obj : com.alibaba.fastjson.util.l.n(obj);
        if (j1Var.G(k1.WriteDateUseDateFormat)) {
            DateFormat dateFormatX = n0Var.x();
            if (dateFormatX == null) {
                dateFormatX = new SimpleDateFormat(com.alibaba.fastjson.a.f12531e, n0Var.f13151s);
                dateFormatX.setTimeZone(n0Var.f13150r);
            }
            j1Var.a2(dateFormatX.format(dateN));
            return;
        }
        if (j1Var.G(k1.WriteClassName) && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                j1Var.write("new Date(");
                j1Var.W1(((Date) obj).getTime());
                j1Var.write(41);
                return;
            } else {
                j1Var.write(123);
                j1Var.J0(com.alibaba.fastjson.a.f12529c);
                n0Var.T(obj.getClass().getName());
                j1Var.d1(',', "val", ((Date) obj).getTime());
                j1Var.write(125);
                return;
            }
        }
        long time = dateN.getTime();
        if (!j1Var.G(k1.UseISO8601DateFormat)) {
            j1Var.W1(time);
            return;
        }
        int i8 = j1Var.G(k1.UseSingleQuotes) ? 39 : 34;
        j1Var.write(i8);
        Calendar calendar = Calendar.getInstance(n0Var.f13150r, n0Var.f13151s);
        calendar.setTimeInMillis(time);
        int i9 = calendar.get(1);
        int i10 = calendar.get(2) + 1;
        int i11 = calendar.get(5);
        int i12 = calendar.get(11);
        int i13 = calendar.get(12);
        int i14 = calendar.get(13);
        int i15 = calendar.get(14);
        if (i15 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.util.f.j(i15, 23, charArray);
            com.alibaba.fastjson.util.f.j(i14, 19, charArray);
            com.alibaba.fastjson.util.f.j(i13, 16, charArray);
            com.alibaba.fastjson.util.f.j(i12, 13, charArray);
            com.alibaba.fastjson.util.f.j(i11, 10, charArray);
            com.alibaba.fastjson.util.f.j(i10, 7, charArray);
            com.alibaba.fastjson.util.f.j(i9, 4, charArray);
        } else if (i14 == 0 && i13 == 0 && i12 == 0) {
            charArray = "0000-00-00".toCharArray();
            com.alibaba.fastjson.util.f.j(i11, 10, charArray);
            com.alibaba.fastjson.util.f.j(i10, 7, charArray);
            com.alibaba.fastjson.util.f.j(i9, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.util.f.j(i14, 19, charArray);
            com.alibaba.fastjson.util.f.j(i13, 16, charArray);
            com.alibaba.fastjson.util.f.j(i12, 13, charArray);
            com.alibaba.fastjson.util.f.j(i11, 10, charArray);
            com.alibaba.fastjson.util.f.j(i10, 7, charArray);
            com.alibaba.fastjson.util.f.j(i9, 4, charArray);
        }
        j1Var.write(charArray);
        int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            j1Var.write(90);
        } else {
            if (rawOffset > 9) {
                j1Var.write(43);
                j1Var.N1(rawOffset);
            } else if (rawOffset > 0) {
                j1Var.write(43);
                j1Var.write(48);
                j1Var.N1(rawOffset);
            } else if (rawOffset < -9) {
                j1Var.write(45);
                j1Var.N1(rawOffset);
            } else if (rawOffset < 0) {
                j1Var.write(45);
                j1Var.write(48);
                j1Var.N1(rawOffset);
            }
            j1Var.append(":00");
        }
        j1Var.write(i8);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v19, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r5v25, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.b
    public <T> T g(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new com.alibaba.fastjson.d("parse error");
        }
        String strSubstring = (String) obj2;
        if (strSubstring.length() == 0) {
            return null;
        }
        com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(strSubstring);
        try {
            if (gVar.T2(false)) {
                ?? r7 = (T) gVar.X1();
                if (type == Calendar.class) {
                    gVar.close();
                    return r7;
                }
                T t7 = (T) r7.getTime();
                gVar.close();
                return t7;
            }
            gVar.close();
            if (strSubstring.length() == bVar.E().length() || (strSubstring.length() == 22 && bVar.E().equals("yyyyMMddHHmmssSSSZ"))) {
                try {
                    return (T) bVar.F().parse(strSubstring);
                } catch (ParseException unused) {
                }
            }
            if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
            }
            if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf(124);
            if (iLastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    com.alibaba.fastjson.parser.g gVar2 = new com.alibaba.fastjson.parser.g(strSubstring.substring(0, iLastIndexOf));
                    try {
                        if (gVar2.T2(false)) {
                            ?? r8 = (T) gVar2.X1();
                            r8.setTimeZone(timeZone);
                            return type == Calendar.class ? r8 : (T) r8.getTime();
                        }
                    } finally {
                        gVar2.close();
                    }
                }
            }
            return (T) new Date(Long.parseLong(strSubstring));
        } catch (Throwable th) {
            gVar.close();
            throw th;
        }
    }
}
