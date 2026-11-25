package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.stream.d;
import com.google.gson.v;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class TimeTypeAdapter extends x<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f23071b = new y() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f23072a = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized Time e(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.J0() == com.google.gson.stream.c.NULL) {
            aVar.v0();
            return null;
        }
        try {
            return new Time(this.f23072a.parse(aVar.G0()).getTime());
        } catch (ParseException e8) {
            throw new v(e8);
        }
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public synchronized void i(d dVar, Time time) throws IOException {
        dVar.T0(time == null ? null : this.f23072a.format((Date) time));
    }
}
