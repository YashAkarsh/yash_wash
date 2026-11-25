package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "MethodInvocationCreator")
@c1.a
public class MethodInvocation extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodKey", id = 1)
    private final int f15642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getResultStatusCode", id = 2)
    private final int f15643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConnectionResultStatusCode", id = 3)
    private final int f15644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStartTimeMillis", id = 4)
    private final long f15645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEndTimeMillis", id = 5)
    private final long f15646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getCallingModuleId", id = 6)
    private final String f15647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getCallingEntryPoint", id = 7)
    private final String f15648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0", getter = "getServiceId", id = 8)
    private final int f15649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "-1", getter = "getLatencyMillis", id = 9)
    private final int f15650i;

    @c1.a
    @Deprecated
    public MethodInvocation(int i7, int i8, int i9, long j7, long j8, @c.o0 String str, @c.o0 String str2, int i10) {
        this(i7, i8, i9, j7, j8, str, str2, i10, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15642a);
        e1.b.F(parcel, 2, this.f15643b);
        e1.b.F(parcel, 3, this.f15644c);
        e1.b.K(parcel, 4, this.f15645d);
        e1.b.K(parcel, 5, this.f15646e);
        e1.b.Y(parcel, 6, this.f15647f, false);
        e1.b.Y(parcel, 7, this.f15648g, false);
        e1.b.F(parcel, 8, this.f15649h);
        e1.b.F(parcel, 9, this.f15650i);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    public MethodInvocation(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) int i9, @SafeParcelable.e(id = 4) long j7, @SafeParcelable.e(id = 5) long j8, @c.o0 @SafeParcelable.e(id = 6) String str, @c.o0 @SafeParcelable.e(id = 7) String str2, @SafeParcelable.e(id = 8) int i10, @SafeParcelable.e(id = 9) int i11) {
        this.f15642a = i7;
        this.f15643b = i8;
        this.f15644c = i9;
        this.f15645d = j7;
        this.f15646e = j8;
        this.f15647f = str;
        this.f15648g = str2;
        this.f15649h = i10;
        this.f15650i = i11;
    }
}
