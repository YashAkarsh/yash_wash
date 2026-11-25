package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import c.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f18788h = "%02d";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f18789i = "%d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f18790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f18791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f18792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f18793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f18794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f18795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f18796g;

    static class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i7) {
            return new TimeModel[i7];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, f18788h);
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int g(int i7) {
        return i7 >= 12 ? 1 : 0;
    }

    public int d() {
        if (this.f18792c == 1) {
            return this.f18793d % 24;
        }
        int i7 = this.f18793d;
        if (i7 % 12 == 0) {
            return 12;
        }
        return this.f18796g == 1 ? i7 - 12 : i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public d e() {
        return this.f18791b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f18793d == timeModel.f18793d && this.f18794e == timeModel.f18794e && this.f18792c == timeModel.f18792c && this.f18795f == timeModel.f18795f;
    }

    public d f() {
        return this.f18790a;
    }

    public void h(int i7) {
        if (this.f18792c == 1) {
            this.f18793d = i7;
        } else {
            this.f18793d = (i7 % 12) + (this.f18796g != 1 ? 0 : 12);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18792c), Integer.valueOf(this.f18793d), Integer.valueOf(this.f18794e), Integer.valueOf(this.f18795f)});
    }

    public void i(int i7) {
        this.f18796g = g(i7);
        this.f18793d = i7;
    }

    public void j(@e0(from = 0, to = 60) int i7) {
        this.f18794e = i7 % 60;
    }

    public void k(int i7) {
        if (i7 != this.f18796g) {
            this.f18796g = i7;
            int i8 = this.f18793d;
            if (i8 < 12 && i7 == 1) {
                this.f18793d = i8 + 12;
            } else {
                if (i8 < 12 || i7 != 0) {
                    return;
                }
                this.f18793d = i8 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f18793d);
        parcel.writeInt(this.f18794e);
        parcel.writeInt(this.f18795f);
        parcel.writeInt(this.f18792c);
    }

    public TimeModel(int i7) {
        this(0, 0, 10, i7);
    }

    public TimeModel(int i7, int i8, int i9, int i10) {
        this.f18793d = i7;
        this.f18794e = i8;
        this.f18795f = i9;
        this.f18792c = i10;
        this.f18796g = g(i7);
        this.f18790a = new d(59);
        this.f18791b = new d(i10 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
