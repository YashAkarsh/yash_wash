package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.stream.d;
import com.google.gson.v;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class SqlDateTypeAdapter extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f23069b = new y() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f23070a = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized Date e(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.J0() == com.google.gson.stream.c.NULL) {
            aVar.v0();
            return null;
        }
        try {
            return new Date(this.f23070a.parse(aVar.G0()).getTime());
        } catch (ParseException e8) {
            throw new v(e8);
        }
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public synchronized void i(d dVar, Date date) throws IOException {
        dVar.T0(date == null ? null : this.f23070a.format((java.util.Date) date));
    }
}
