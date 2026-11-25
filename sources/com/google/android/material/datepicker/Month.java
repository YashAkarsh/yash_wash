package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Calendar f17425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f17426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f17427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f17428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f17429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f17430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private String f17431g;

    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(@m0 Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i7) {
            return new Month[i7];
        }
    }

    private Month(@m0 Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarF = u.f(calendar);
        this.f17425a = calendarF;
        this.f17426b = calendarF.get(2);
        this.f17427c = calendarF.get(1);
        this.f17428d = calendarF.getMaximum(7);
        this.f17429e = calendarF.getActualMaximum(5);
        this.f17430f = calendarF.getTimeInMillis();
    }

    @m0
    static Month b(int i7, int i8) {
        Calendar calendarV = u.v();
        calendarV.set(1, i7);
        calendarV.set(2, i8);
        return new Month(calendarV);
    }

    @m0
    static Month d(long j7) {
        Calendar calendarV = u.v();
        calendarV.setTimeInMillis(j7);
        return new Month(calendarV);
    }

    @m0
    static Month e() {
        return new Month(u.t());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@m0 Month month) {
        return this.f17425a.compareTo(month.f17425a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f17426b == month.f17426b && this.f17427c == month.f17427c;
    }

    int f() {
        int firstDayOfWeek = this.f17425a.get(7) - this.f17425a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f17428d : firstDayOfWeek;
    }

    long g(int i7) {
        Calendar calendarF = u.f(this.f17425a);
        calendarF.set(5, i7);
        return calendarF.getTimeInMillis();
    }

    int h(long j7) {
        Calendar calendarF = u.f(this.f17425a);
        calendarF.setTimeInMillis(j7);
        return calendarF.get(5);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f17426b), Integer.valueOf(this.f17427c)});
    }

    @m0
    String i(Context context) {
        if (this.f17431g == null) {
            this.f17431g = e.i(context, this.f17425a.getTimeInMillis());
        }
        return this.f17431g;
    }

    long j() {
        return this.f17425a.getTimeInMillis();
    }

    @m0
    Month k(int i7) {
        Calendar calendarF = u.f(this.f17425a);
        calendarF.add(2, i7);
        return new Month(calendarF);
    }

    int l(@m0 Month month) {
        if (this.f17425a instanceof GregorianCalendar) {
            return ((month.f17427c - this.f17427c) * 12) + (month.f17426b - this.f17426b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeInt(this.f17427c);
        parcel.writeInt(this.f17426b);
    }
}
