package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Month f17401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Month f17402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final DateValidator f17403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private Month f17404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17406f;

    public interface DateValidator extends Parcelable {
        boolean m(long j7);
    }

    static class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(@m0 Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i7) {
            return new CalendarConstraints[i7];
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f17401a.equals(calendarConstraints.f17401a) && this.f17402b.equals(calendarConstraints.f17402b) && androidx.core.util.r.a(this.f17404d, calendarConstraints.f17404d) && this.f17403c.equals(calendarConstraints.f17403c);
    }

    Month f(Month month) {
        if (month.compareTo(this.f17401a) < 0) {
            return this.f17401a;
        }
        return month.compareTo(this.f17402b) > 0 ? this.f17402b : month;
    }

    public DateValidator g() {
        return this.f17403c;
    }

    @m0
    Month h() {
        return this.f17402b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17401a, this.f17402b, this.f17404d, this.f17403c});
    }

    int i() {
        return this.f17406f;
    }

    @o0
    Month j() {
        return this.f17404d;
    }

    @m0
    Month k() {
        return this.f17401a;
    }

    int l() {
        return this.f17405e;
    }

    boolean n(long j7) {
        if (this.f17401a.g(1) <= j7) {
            Month month = this.f17402b;
            if (j7 <= month.g(month.f17429e)) {
                return true;
            }
        }
        return false;
    }

    void o(@o0 Month month) {
        this.f17404d = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f17401a, 0);
        parcel.writeParcelable(this.f17402b, 0);
        parcel.writeParcelable(this.f17404d, 0);
        parcel.writeParcelable(this.f17403c, 0);
    }

    private CalendarConstraints(@m0 Month month, @m0 Month month2, @m0 DateValidator dateValidator, @o0 Month month3) {
        this.f17401a = month;
        this.f17402b = month2;
        this.f17404d = month3;
        this.f17403c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f17406f = month.l(month2) + 1;
        this.f17405e = (month2.f17427c - month.f17427c) + 1;
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f17407e = u.a(Month.b(1900, 0).f17430f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f17408f = u.a(Month.b(2100, 11).f17430f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f17409g = "DEEP_COPY_VALIDATOR_KEY";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f17410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f17411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f17412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DateValidator f17413d;

        public b() {
            this.f17410a = f17407e;
            this.f17411b = f17408f;
            this.f17413d = DateValidatorPointForward.a(Long.MIN_VALUE);
        }

        @m0
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(f17409g, this.f17413d);
            Month monthD = Month.d(this.f17410a);
            Month monthD2 = Month.d(this.f17411b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(f17409g);
            Long l7 = this.f17412c;
            return new CalendarConstraints(monthD, monthD2, dateValidator, l7 == null ? null : Month.d(l7.longValue()), null);
        }

        @m0
        public b b(long j7) {
            this.f17411b = j7;
            return this;
        }

        @m0
        public b c(long j7) {
            this.f17412c = Long.valueOf(j7);
            return this;
        }

        @m0
        public b d(long j7) {
            this.f17410a = j7;
            return this;
        }

        @m0
        public b e(@m0 DateValidator dateValidator) {
            this.f17413d = dateValidator;
            return this;
        }

        b(@m0 CalendarConstraints calendarConstraints) {
            this.f17410a = f17407e;
            this.f17411b = f17408f;
            this.f17413d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f17410a = calendarConstraints.f17401a.f17430f;
            this.f17411b = calendarConstraints.f17402b.f17430f;
            this.f17412c = Long.valueOf(calendarConstraints.f17404d.f17430f);
            this.f17413d = calendarConstraints.f17403c;
        }
    }
}
