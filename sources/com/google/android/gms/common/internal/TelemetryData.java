package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "TelemetryDataCreator")
@c1.a
public class TelemetryData extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<TelemetryData> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTelemetryConfigVersion", id = 1)
    private final int f15656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodInvocations", id = 2)
    @Nullable
    private List<MethodInvocation> f15657b;

    @SafeParcelable.b
    public TelemetryData(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) @Nullable List<MethodInvocation> list) {
        this.f15656a = i7;
        this.f15657b = list;
    }

    @c.o0
    public final List<MethodInvocation> K() {
        return this.f15657b;
    }

    public final void Q(@c.m0 MethodInvocation methodInvocation) {
        if (this.f15657b == null) {
            this.f15657b = new ArrayList();
        }
        this.f15657b.add(methodInvocation);
    }

    public final int b() {
        return this.f15656a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15656a);
        e1.b.d0(parcel, 2, this.f15657b, false);
        e1.b.b(parcel, iA);
    }
}
