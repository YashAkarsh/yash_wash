package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17421a;

    static class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward createFromParcel(@m0 Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward[] newArray(int i7) {
            return new DateValidatorPointForward[i7];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j7, a aVar) {
        this(j7);
    }

    @m0
    public static DateValidatorPointForward a(long j7) {
        return new DateValidatorPointForward(j7);
    }

    @m0
    public static DateValidatorPointForward b() {
        return a(u.t().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f17421a == ((DateValidatorPointForward) obj).f17421a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f17421a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean m(long j7) {
        return j7 >= this.f17421a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeLong(this.f17421a);
    }

    private DateValidatorPointForward(long j7) {
        this.f17421a = j7;
    }
}
