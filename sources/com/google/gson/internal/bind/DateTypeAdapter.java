package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.e;
import com.google.gson.internal.k;
import com.google.gson.stream.d;
import com.google.gson.v;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTypeAdapter extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f23040b = new y() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f23041a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f23041a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.e()) {
            arrayList.add(k.e(2, 2));
        }
    }

    private synchronized Date j(String str) {
        Iterator<DateFormat> it = this.f23041a.iterator();
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

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Date e(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.J0() != com.google.gson.stream.c.NULL) {
            return j(aVar.G0());
        }
        aVar.v0();
        return null;
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public synchronized void i(d dVar, Date date) throws IOException {
        try {
            if (date == null) {
                dVar.g0();
            } else {
                dVar.T0(this.f23041a.get(0).format(date));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
