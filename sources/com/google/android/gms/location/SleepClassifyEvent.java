package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SleepClassifyEventCreator")
public class SleepClassifyEvent extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTimestampSec", id = 1)
    private final int f16299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConfidence", id = 2)
    private final int f16300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMotion", id = 3)
    private final int f16301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getLight", id = 4)
    private final int f16302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getNoise", id = 5)
    private final int f16303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getLightDiff", id = 6)
    private final int f16304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "getNightOrDay", id = 7)
    private final int f16305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConfidenceOverwrittenByAlarmClockTrigger", id = 8)
    private final boolean f16306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getPresenceConfidence", id = 9)
    private final int f16307i;

    @SafeParcelable.b
    @com.google.android.gms.common.internal.y
    public SleepClassifyEvent(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) int i9, @SafeParcelable.e(id = 4) int i10, @SafeParcelable.e(id = 5) int i11, @SafeParcelable.e(id = 6) int i12, @SafeParcelable.e(id = 7) int i13, @SafeParcelable.e(id = 8) boolean z7, @SafeParcelable.e(id = 9) int i14) {
        this.f16299a = i7;
        this.f16300b = i8;
        this.f16301c = i9;
        this.f16302d = i10;
        this.f16303e = i11;
        this.f16304f = i12;
        this.f16305g = i13;
        this.f16306h = z7;
        this.f16307i = i14;
    }

    @c.m0
    public static List<SleepClassifyEvent> s(@c.m0 Intent intent) {
        com.google.android.gms.common.internal.u.k(intent);
        if (!s0(intent)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
        if (arrayList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            byte[] bArr = (byte[]) arrayList.get(i7);
            com.google.android.gms.common.internal.u.k(bArr);
            arrayList2.add((SleepClassifyEvent) e1.c.a(bArr, CREATOR));
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean s0(@c.o0 Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
    }

    public int K() {
        return this.f16300b;
    }

    public int Q() {
        return this.f16302d;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f16299a == sleepClassifyEvent.f16299a && this.f16300b == sleepClassifyEvent.f16300b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16299a), Integer.valueOf(this.f16300b));
    }

    public int p0() {
        return this.f16301c;
    }

    public long r0() {
        return ((long) this.f16299a) * 1000;
    }

    @c.m0
    public String toString() {
        int i7 = this.f16299a;
        int i8 = this.f16300b;
        int i9 = this.f16301c;
        int i10 = this.f16302d;
        StringBuilder sb = new StringBuilder(65);
        sb.append(i7);
        sb.append(" Conf:");
        sb.append(i8);
        sb.append(" Motion:");
        sb.append(i9);
        sb.append(" Light:");
        sb.append(i10);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16299a);
        e1.b.F(parcel, 2, K());
        e1.b.F(parcel, 3, p0());
        e1.b.F(parcel, 4, Q());
        e1.b.F(parcel, 5, this.f16303e);
        e1.b.F(parcel, 6, this.f16304f);
        e1.b.F(parcel, 7, this.f16305g);
        e1.b.g(parcel, 8, this.f16306h);
        e1.b.F(parcel, 9, this.f16307i);
        e1.b.b(parcel, iA);
    }
}
