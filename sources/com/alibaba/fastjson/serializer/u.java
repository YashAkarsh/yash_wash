package com.alibaba.fastjson.serializer;

import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public class u implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f13173b = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DatatypeFactory f13174a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        T t7 = (T) b0.f13019a.b(bVar, type, obj);
        if (t7 instanceof Calendar) {
            return t7;
        }
        Date date = (Date) t7;
        if (date == null) {
            return null;
        }
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        ?? r7 = (T) Calendar.getInstance(dVar.getTimeZone(), dVar.getLocale());
        r7.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) f((GregorianCalendar) r7) : r7;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        char[] charArray;
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!j1Var.G(k1.UseISO8601DateFormat)) {
            n0Var.S(gregorianCalendar.getTime());
            return;
        }
        char c8 = j1Var.G(k1.UseSingleQuotes) ? '\'' : kotlin.text.h0.f35376b;
        j1Var.append(c8);
        int i8 = gregorianCalendar.get(1);
        int i9 = gregorianCalendar.get(2) + 1;
        int i10 = gregorianCalendar.get(5);
        int i11 = gregorianCalendar.get(11);
        int i12 = gregorianCalendar.get(12);
        int i13 = gregorianCalendar.get(13);
        int i14 = gregorianCalendar.get(14);
        if (i14 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.util.f.j(i14, 23, charArray);
            com.alibaba.fastjson.util.f.j(i13, 19, charArray);
            com.alibaba.fastjson.util.f.j(i12, 16, charArray);
            com.alibaba.fastjson.util.f.j(i11, 13, charArray);
            com.alibaba.fastjson.util.f.j(i10, 10, charArray);
            com.alibaba.fastjson.util.f.j(i9, 7, charArray);
            com.alibaba.fastjson.util.f.j(i8, 4, charArray);
        } else if (i13 == 0 && i12 == 0 && i11 == 0) {
            charArray = "0000-00-00".toCharArray();
            com.alibaba.fastjson.util.f.j(i10, 10, charArray);
            com.alibaba.fastjson.util.f.j(i9, 7, charArray);
            com.alibaba.fastjson.util.f.j(i8, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.util.f.j(i13, 19, charArray);
            com.alibaba.fastjson.util.f.j(i12, 16, charArray);
            com.alibaba.fastjson.util.f.j(i11, 13, charArray);
            com.alibaba.fastjson.util.f.j(i10, 10, charArray);
            com.alibaba.fastjson.util.f.j(i9, 7, charArray);
            com.alibaba.fastjson.util.f.j(i8, 4, charArray);
        }
        j1Var.write(charArray);
        int rawOffset = gregorianCalendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            j1Var.append("Z");
        } else if (rawOffset > 0) {
            j1Var.append("+").append(String.format(TimeModel.f18788h, Integer.valueOf(rawOffset))).append(":00");
        } else {
            j1Var.append("-").append(String.format(TimeModel.f18788h, Integer.valueOf(-rawOffset))).append(":00");
        }
        j1Var.append(c8);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 2;
    }

    public XMLGregorianCalendar f(Calendar calendar) {
        if (this.f13174a == null) {
            try {
                this.f13174a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e8) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e8);
            }
        }
        return this.f13174a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
