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
@SafeParcelable.a(creator = "SleepSegmentEventCreator")
@SafeParcelable.f({1000})
public class SleepSegmentEvent extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new n1();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16308f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16309g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16310h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStartTimeMillis", id = 1)
    private final long f16311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEndTimeMillis", id = 2)
    private final long f16312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatus", id = 3)
    private final int f16313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMissingDataDurationMinutes", id = 4)
    private final int f16314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getNinetiethPctConfidence", id = 5)
    private final int f16315e;

    @SafeParcelable.b
    @com.google.android.gms.common.internal.y
    public SleepSegmentEvent(@SafeParcelable.e(id = 1) long j7, @SafeParcelable.e(id = 2) long j8, @SafeParcelable.e(id = 3) int i7, @SafeParcelable.e(id = 4) int i8, @SafeParcelable.e(id = 5) int i9) {
        com.google.android.gms.common.internal.u.b(j7 <= j8, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.f16311a = j7;
        this.f16312b = j8;
        this.f16313c = i7;
        this.f16314d = i8;
        this.f16315e = i9;
    }

    @c.m0
    public static List<SleepSegmentEvent> s(@c.m0 Intent intent) {
        com.google.android.gms.common.internal.u.k(intent);
        if (!s0(intent)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
        if (arrayList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            byte[] bArr = (byte[]) arrayList.get(i7);
            com.google.android.gms.common.internal.u.k(bArr);
            arrayList2.add((SleepSegmentEvent) e1.c.a(bArr, CREATOR));
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean s0(@c.o0 Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
    }

    public long K() {
        return this.f16312b;
    }

    public long Q() {
        return this.f16312b - this.f16311a;
    }

    public boolean equals(@c.o0 Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f16311a == sleepSegmentEvent.p0() && this.f16312b == sleepSegmentEvent.K() && this.f16313c == sleepSegmentEvent.r0() && this.f16314d == sleepSegmentEvent.f16314d && this.f16315e == sleepSegmentEvent.f16315e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Long.valueOf(this.f16311a), Long.valueOf(this.f16312b), Integer.valueOf(this.f16313c));
    }

    public long p0() {
        return this.f16311a;
    }

    public int r0() {
        return this.f16313c;
    }

    @c.m0
    public String toString() {
        long j7 = this.f16311a;
        long j8 = this.f16312b;
        int i7 = this.f16313c;
        StringBuilder sb = new StringBuilder(84);
        sb.append("startMillis=");
        sb.append(j7);
        sb.append(", endMillis=");
        sb.append(j8);
        sb.append(", status=");
        sb.append(i7);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.K(parcel, 1, p0());
        e1.b.K(parcel, 2, K());
        e1.b.F(parcel, 3, r0());
        e1.b.F(parcel, 4, this.f16314d);
        e1.b.F(parcel, 5, this.f16315e);
        e1.b.b(parcel, iA);
    }
}
