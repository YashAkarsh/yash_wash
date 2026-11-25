package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int A = 23;
    public static final int B = 24;

    @Deprecated
    public static final int C = 1500;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c1.a
    public static final int f14996e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14997f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14998g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14999h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f15000i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15001j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15002k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15003l = 6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f15004m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f15005n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f15006o = 9;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f15007p = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f15008q = 11;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f15009r = 13;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f15010s = 14;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f15011t = 15;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f15012u = 16;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f15013v = 17;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f15014w = 18;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f15015x = 19;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f15016y = 20;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f15017z = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getErrorCode", id = 2)
    private final int f15019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getResolution", id = 3)
    private final PendingIntent f15020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getErrorMessage", id = 4)
    private final String f15021d;

    @c1.a
    @com.google.android.gms.common.internal.y
    @c.m0
    public static final ConnectionResult D = new ConnectionResult(0);

    @c.m0
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new y();

    @SafeParcelable.b
    ConnectionResult(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @c.o0 @SafeParcelable.e(id = 3) PendingIntent pendingIntent, @c.o0 @SafeParcelable.e(id = 4) String str) {
        this.f15018a = i7;
        this.f15019b = i8;
        this.f15020c = pendingIntent;
        this.f15021d = str;
    }

    @c.m0
    static String x0(int i7) {
        if (i7 == 99) {
            return "UNFINISHED";
        }
        if (i7 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i7) {
            case -1:
                return "UNKNOWN";
            case 0:
                return s0.c.f40302p;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i7) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i7);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public int K() {
        return this.f15019b;
    }

    @c.o0
    public String Q() {
        return this.f15021d;
    }

    public boolean equals(@c.o0 Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f15019b == connectionResult.f15019b && com.google.android.gms.common.internal.s.b(this.f15020c, connectionResult.f15020c) && com.google.android.gms.common.internal.s.b(this.f15021d, connectionResult.f15021d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f15019b), this.f15020c, this.f15021d);
    }

    @c.o0
    public PendingIntent p0() {
        return this.f15020c;
    }

    public boolean r0() {
        return (this.f15019b == 0 || this.f15020c == null) ? false : true;
    }

    public boolean s0() {
        return this.f15019b == 0;
    }

    @c.m0
    public String toString() {
        com.google.android.gms.common.internal.s.a aVarD = com.google.android.gms.common.internal.s.d(this);
        aVarD.a("statusCode", x0(this.f15019b));
        aVarD.a("resolution", this.f15020c);
        aVarD.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f15021d);
        return aVarD.toString();
    }

    public void v0(@c.m0 Activity activity, int i7) throws IntentSender.SendIntentException {
        if (r0()) {
            PendingIntent pendingIntent = this.f15020c;
            com.google.android.gms.common.internal.u.k(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i7, null, 0, 0, 0);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15018a);
        e1.b.F(parcel, 2, K());
        e1.b.S(parcel, 3, p0(), i7, false);
        e1.b.Y(parcel, 4, Q(), false);
        e1.b.b(parcel, iA);
    }

    public ConnectionResult(int i7) {
        this(i7, null, null);
    }

    public ConnectionResult(int i7, @c.o0 PendingIntent pendingIntent) {
        this(i7, pendingIntent, null);
    }

    public ConnectionResult(int i7, @c.o0 PendingIntent pendingIntent, @c.o0 String str) {
        this(1, i7, pendingIntent, str);
    }
}
