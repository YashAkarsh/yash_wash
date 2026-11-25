package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.m0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "WakeLockEventCreator")
@c1.a
@Deprecated
public final class WakeLockEvent extends StatsEvent {

    @m0
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTimeMillis", id = 2)
    private final long f15962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEventType", id = 11)
    private int f15963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWakeLockName", id = 4)
    private final String f15964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getSecondaryWakeLockName", id = 10)
    private final String f15965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCodePackage", id = 17)
    private final String f15966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWakeLockType", id = 5)
    private final int f15967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCallingPackages", id = 6)
    @Nullable
    private final List<String> f15968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEventKey", id = 12)
    private final String f15969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getElapsedRealtime", id = 8)
    private final long f15970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.c(getter = "getDeviceState", id = 14)
    private int f15971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SafeParcelable.c(getter = "getHostPackage", id = 13)
    private final String f15972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SafeParcelable.c(getter = "getBeginPowerPercentage", id = 15)
    private final float f15973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTimeout", id = 16)
    private final long f15974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean f15975o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f15976p = -1;

    @SafeParcelable.b
    WakeLockEvent(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) long j7, @SafeParcelable.e(id = 11) int i8, @SafeParcelable.e(id = 4) String str, @SafeParcelable.e(id = 5) int i9, @SafeParcelable.e(id = 6) @Nullable List<String> list, @SafeParcelable.e(id = 12) String str2, @SafeParcelable.e(id = 8) long j8, @SafeParcelable.e(id = 14) int i10, @SafeParcelable.e(id = 10) String str3, @SafeParcelable.e(id = 13) String str4, @SafeParcelable.e(id = 15) float f8, @SafeParcelable.e(id = 16) long j9, @SafeParcelable.e(id = 17) String str5, @SafeParcelable.e(id = 18) boolean z7) {
        this.f15961a = i7;
        this.f15962b = j7;
        this.f15963c = i8;
        this.f15964d = str;
        this.f15965e = str3;
        this.f15966f = str5;
        this.f15967g = i9;
        this.f15968h = list;
        this.f15969i = str2;
        this.f15970j = j8;
        this.f15971k = i10;
        this.f15972l = str4;
        this.f15973m = f8;
        this.f15974n = j9;
        this.f15975o = z7;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int K() {
        return this.f15963c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long Q() {
        return this.f15976p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long p0() {
        return this.f15962b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @m0
    public final String r0() {
        List<String> list = this.f15968h;
        String str = this.f15964d;
        int i7 = this.f15967g;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i8 = this.f15971k;
        String str2 = this.f15965e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f15972l;
        if (str3 == null) {
            str3 = "";
        }
        float f8 = this.f15973m;
        String str4 = this.f15966f;
        String str5 = str4 != null ? str4 : "";
        boolean z7 = this.f15975o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(strJoin).length() + str2.length() + str3.length() + str5.length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i7);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(i8);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f8);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z7);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15961a);
        e1.b.K(parcel, 2, this.f15962b);
        e1.b.Y(parcel, 4, this.f15964d, false);
        e1.b.F(parcel, 5, this.f15967g);
        e1.b.a0(parcel, 6, this.f15968h, false);
        e1.b.K(parcel, 8, this.f15970j);
        e1.b.Y(parcel, 10, this.f15965e, false);
        e1.b.F(parcel, 11, this.f15963c);
        e1.b.Y(parcel, 12, this.f15969i, false);
        e1.b.Y(parcel, 13, this.f15972l, false);
        e1.b.F(parcel, 14, this.f15971k);
        e1.b.w(parcel, 15, this.f15973m);
        e1.b.K(parcel, 16, this.f15974n);
        e1.b.Y(parcel, 17, this.f15966f, false);
        e1.b.g(parcel, 18, this.f15975o);
        e1.b.b(parcel, iA);
    }
}
