package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17420a;

    static class a implements Parcelable.Creator<DateValidatorPointBackward> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointBackward createFromParcel(@m0 Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointBackward[] newArray(int i7) {
            return new DateValidatorPointBackward[i7];
        }
    }

    /* synthetic */ DateValidatorPointBackward(long j7, a aVar) {
        this(j7);
    }

    @m0
    public static DateValidatorPointBackward a(long j7) {
        return new DateValidatorPointBackward(j7);
    }

    @m0
    public static DateValidatorPointBackward b() {
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
        return (obj instanceof DateValidatorPointBackward) && this.f17420a == ((DateValidatorPointBackward) obj).f17420a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f17420a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean m(long j7) {
        return j7 <= this.f17420a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeLong(this.f17420a);
    }

    private DateValidatorPointBackward(long j7) {
        this.f17420a = j7;
    }
}
