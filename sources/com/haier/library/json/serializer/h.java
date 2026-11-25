package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f26822a = new h();

    private h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v9, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.util.Calendar] */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        Object objG;
        String strA0;
        Object time;
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 2) {
            Object objValueOf = Long.valueOf(eVar.t());
            eVar.y(16);
            objG = objValueOf;
        } else if (iD0 == 4) {
            strA0 = eVar.a0();
            eVar.y(16);
            if ((eVar.f26707c & com.haier.library.json.parser.d.AllowISO8601DateFormat.f26696a) != 0) {
                com.haier.library.json.parser.e eVar2 = new com.haier.library.json.parser.e(strA0);
                if (eVar2.L(true)) {
                    ?? r7 = (T) eVar2.m();
                    if (type == Calendar.class) {
                        objG = strA0;
                        time = strA0;
                        eVar2.f();
                        return r7;
                    }
                    objG = strA0;
                    time = strA0;
                    time = r7.getTime();
                }
                objG = strA0;
                time = strA0;
                eVar2.f();
                objG = time;
            }
        } else if (iD0 == 8) {
            eVar.x();
            objG = null;
        } else if (iD0 == 12) {
            eVar.x();
            if (eVar.d0() != 4) {
                throw new com.haier.library.json.d("syntax error");
            }
            if (com.haier.library.json.a.f26646c.equals(eVar.a0())) {
                eVar.x();
                bVar.b(17);
                Type typeC = i3.d.C(eVar.a0(), bVar.f26661b.f26771c);
                if (typeC != null) {
                    type = typeC;
                }
                bVar.b(4);
                bVar.b(16);
            }
            eVar.z(':');
            if (eVar.d0() != 2) {
                throw new com.haier.library.json.d("syntax error : " + eVar.e0());
            }
            long jT = eVar.t();
            eVar.x();
            Object objValueOf2 = Long.valueOf(jT);
            bVar.b(13);
            objG = objValueOf2;
        } else if (bVar.f26669j == 2) {
            bVar.f26669j = 0;
            bVar.b(16);
            if (eVar.d0() != 4) {
                throw new com.haier.library.json.d("syntax error");
            }
            if (!"val".equals(eVar.a0())) {
                throw new com.haier.library.json.d("syntax error");
            }
            eVar.x();
            bVar.b(17);
            Object objG2 = bVar.G();
            bVar.b(13);
            objG = objG2;
        } else {
            objG = bVar.G();
        }
        objG = strA0;
        T t7 = (T) c(bVar, type, obj, objG);
        if (type != Calendar.class || (t7 instanceof Calendar)) {
            return t7;
        }
        Date date = (Date) t7;
        if (date == null) {
            return null;
        }
        ?? r13 = (T) Calendar.getInstance(eVar.f26708d, eVar.f26709e);
        r13.setTime(date);
        return r13;
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        char[] charArray;
        z zVar = mVar.f26832b;
        if (obj == null) {
            zVar.H();
            return;
        }
        if ((zVar.f26874c & a0.WriteClassName.f26811a) != 0 && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                zVar.write("new Date(");
                zVar.G(((Date) obj).getTime());
                zVar.write(41);
                return;
            }
            zVar.write(123);
            zVar.v(com.haier.library.json.a.f26646c, false);
            mVar.z(obj.getClass().getName());
            zVar.write(44);
            zVar.v("val", false);
            zVar.G(((Date) obj).getTime());
            zVar.write(125);
            return;
        }
        Date time = obj instanceof Calendar ? ((Calendar) obj).getTime() : (Date) obj;
        if ((zVar.f26874c & a0.WriteDateUseDateFormat.f26811a) != 0) {
            DateFormat dateFormatI = mVar.i();
            if (dateFormatI == null) {
                dateFormatI = new SimpleDateFormat(com.haier.library.json.a.f26647d, mVar.f26845o);
                dateFormatI.setTimeZone(mVar.f26844n);
            }
            zVar.K(dateFormatI.format(time));
            return;
        }
        long time2 = time.getTime();
        int i7 = zVar.f26874c;
        if ((a0.UseISO8601DateFormat.f26811a & i7) == 0) {
            zVar.G(time2);
            return;
        }
        a0 a0Var = a0.UseSingleQuotes;
        if ((i7 & a0Var.f26811a) != 0) {
            zVar.write(39);
        } else {
            zVar.write(34);
        }
        Calendar calendar = Calendar.getInstance(mVar.f26844n, mVar.f26845o);
        calendar.setTimeInMillis(time2);
        int i8 = calendar.get(1);
        int i9 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        int i13 = calendar.get(13);
        int i14 = calendar.get(14);
        if (i14 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            z.m(i14, 23, charArray);
            z.m(i13, 19, charArray);
            z.m(i12, 16, charArray);
            z.m(i11, 13, charArray);
            z.m(i10, 10, charArray);
            z.m(i9, 7, charArray);
            z.m(i8, 4, charArray);
        } else if (i13 == 0 && i12 == 0 && i11 == 0) {
            charArray = "0000-00-00".toCharArray();
            z.m(i10, 10, charArray);
            z.m(i9, 7, charArray);
            z.m(i8, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            z.m(i13, 19, charArray);
            z.m(i12, 16, charArray);
            z.m(i11, 13, charArray);
            z.m(i10, 10, charArray);
            z.m(i9, 7, charArray);
            z.m(i8, 4, charArray);
        }
        zVar.write(charArray);
        if ((zVar.f26874c & a0Var.f26811a) != 0) {
            zVar.write(39);
        } else {
            zVar.write(34);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.util.Calendar] */
    protected <T> T c(com.haier.library.json.parser.b bVar, Type type, Object obj, Object obj2) {
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
            throw new com.haier.library.json.d("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        com.haier.library.json.parser.e eVar = new com.haier.library.json.parser.e(str);
        try {
            if (!eVar.L(false)) {
                eVar.f();
                try {
                    return (T) bVar.r().parse(str);
                } catch (ParseException unused) {
                    return (T) new Date(Long.parseLong(str));
                }
            }
            ?? r7 = (T) eVar.m();
            if (type == Calendar.class) {
                eVar.f();
                return r7;
            }
            T t7 = (T) r7.getTime();
            eVar.f();
            return t7;
        } catch (Throwable th) {
            eVar.f();
            throw th;
        }
    }
}
