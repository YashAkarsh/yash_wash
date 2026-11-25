package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.w;
import c.m0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f17414c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f17415d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final d f17418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final List<CalendarConstraints.DateValidator> f17419b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f17416e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f17417f = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    static class a implements d {
        a() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int a() {
            return 1;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean b(@m0 List<CalendarConstraints.DateValidator> list, long j7) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.m(j7)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class b implements d {
        b() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int a() {
            return 2;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean b(@m0 List<CalendarConstraints.DateValidator> list, long j7) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.m(j7)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator createFromParcel(@m0 Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i7 = parcel.readInt();
            d dVar = (i7 != 2 && i7 == 1) ? CompositeDateValidator.f17416e : CompositeDateValidator.f17417f;
            return new CompositeDateValidator((List) w.l(arrayList), dVar, null);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator[] newArray(int i7) {
            return new CompositeDateValidator[i7];
        }
    }

    private interface d {
        int a();

        boolean b(@m0 List<CalendarConstraints.DateValidator> list, long j7);
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @m0
    public static CalendarConstraints.DateValidator d(@m0 List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, f17417f);
    }

    @m0
    public static CalendarConstraints.DateValidator e(@m0 List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, f17416e);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f17419b.equals(compositeDateValidator.f17419b) && this.f17418a.a() == compositeDateValidator.f17418a.a();
    }

    public int hashCode() {
        return this.f17419b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean m(long j7) {
        return this.f17418a.b(this.f17419b, j7);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeList(this.f17419b);
        parcel.writeInt(this.f17418a.a());
    }

    private CompositeDateValidator(@m0 List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f17419b = list;
        this.f17418a = dVar;
    }
}
