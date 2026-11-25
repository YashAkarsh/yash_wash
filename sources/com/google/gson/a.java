package com.google.gson;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class a extends x<Date> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f22951c = "DefaultDateTypeAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends Date> f22952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f22953b;

    a(Class<? extends Date> cls) {
        ArrayList arrayList = new ArrayList();
        this.f22953b = arrayList;
        this.f22952a = l(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.e.e()) {
            arrayList.add(com.google.gson.internal.k.e(2, 2));
        }
    }

    private Date j(String str) {
        synchronized (this.f22953b) {
            Iterator<DateFormat> it = this.f22953b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return x1.a.g(str, new ParsePosition(0));
            } catch (ParseException e8) {
                throw new v(str, e8);
            }
        }
    }

    private static Class<? extends Date> l(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Date e(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.J0() == com.google.gson.stream.c.NULL) {
            aVar.v0();
            return null;
        }
        Date dateJ = j(aVar.G0());
        Class<? extends Date> cls = this.f22952a;
        if (cls == Date.class) {
            return dateJ;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(dateJ.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(dateJ.getTime());
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void i(com.google.gson.stream.d dVar, Date date) throws IOException {
        if (date == null) {
            dVar.g0();
            return;
        }
        synchronized (this.f22953b) {
            dVar.T0(this.f22953b.get(0).format(date));
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f22953b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f22953b = arrayList;
        this.f22952a = l(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    a(Class<? extends Date> cls, int i7) {
        ArrayList arrayList = new ArrayList();
        this.f22953b = arrayList;
        this.f22952a = l(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i7, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i7));
        }
        if (com.google.gson.internal.e.e()) {
            arrayList.add(com.google.gson.internal.k.d(i7));
        }
    }

    public a(int i7, int i8) {
        this(Date.class, i7, i8);
    }

    public a(Class<? extends Date> cls, int i7, int i8) {
        ArrayList arrayList = new ArrayList();
        this.f22953b = arrayList;
        this.f22952a = l(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i7, i8, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i7, i8));
        }
        if (com.google.gson.internal.e.e()) {
            arrayList.add(com.google.gson.internal.k.e(i7, i8));
        }
    }
}
