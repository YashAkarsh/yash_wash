package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ActivityRecognitionResultCreator")
@SafeParcelable.f({1000})
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {

    @c.m0
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 1)
    List<DetectedActivity> f16222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    long f16223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    long f16224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(id = 4)
    int f16225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(id = 5)
    Bundle f16226e;

    @g1.d0
    public ActivityRecognitionResult(@c.m0 DetectedActivity detectedActivity, long j7, long j8) {
        this(Collections.singletonList(detectedActivity), j7, j8, 0, null);
    }

    private static boolean G0(@c.o0 Bundle bundle, @c.o0 Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!G0(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i7 = 0; i7 < length; i7++) {
                            if (com.google.android.gms.common.internal.s.b(Array.get(obj, i7), Array.get(obj2, i7))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    @c.o0
    public static ActivityRecognitionResult s(@c.m0 Intent intent) {
        Bundle extras;
        ActivityRecognitionResult activityRecognitionResult;
        if (v0(intent) && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
            if (obj instanceof byte[]) {
                activityRecognitionResult = (ActivityRecognitionResult) e1.c.a((byte[]) obj, CREATOR);
            } else if (obj instanceof ActivityRecognitionResult) {
                activityRecognitionResult = (ActivityRecognitionResult) obj;
            } else {
                activityRecognitionResult = null;
            }
        } else {
            activityRecognitionResult = null;
        }
        if (activityRecognitionResult != null) {
            return activityRecognitionResult;
        }
        List<ActivityRecognitionResult> listX0 = x0(intent);
        if (listX0 == null || listX0.isEmpty()) {
            return null;
        }
        return listX0.get(listX0.size() - 1);
    }

    public static boolean v0(@c.o0 Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List<ActivityRecognitionResult> listX0 = x0(intent);
        return (listX0 == null || listX0.isEmpty()) ? false : true;
    }

    @c.o0
    public static List<ActivityRecognitionResult> x0(@c.m0 Intent intent) {
        if (intent != null && intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) {
            return e1.c.g(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
        }
        return null;
    }

    public int K(int i7) {
        for (DetectedActivity detectedActivity : this.f16222a) {
            if (detectedActivity.Q() == i7) {
                return detectedActivity.K();
            }
        }
        return 0;
    }

    public long Q() {
        return this.f16224c;
    }

    @com.google.android.gms.common.internal.y
    public final boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f16223b == activityRecognitionResult.f16223b && this.f16224c == activityRecognitionResult.f16224c && this.f16225d == activityRecognitionResult.f16225d && com.google.android.gms.common.internal.s.b(this.f16222a, activityRecognitionResult.f16222a) && G0(this.f16226e, activityRecognitionResult.f16226e)) {
                return true;
            }
        }
        return false;
    }

    @com.google.android.gms.common.internal.y
    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(Long.valueOf(this.f16223b), Long.valueOf(this.f16224c), Integer.valueOf(this.f16225d), this.f16222a, this.f16226e);
    }

    @c.m0
    public DetectedActivity p0() {
        return this.f16222a.get(0);
    }

    @c.m0
    public List<DetectedActivity> r0() {
        return this.f16222a;
    }

    public long s0() {
        return this.f16223b;
    }

    @c.m0
    public String toString() {
        String strValueOf = String.valueOf(this.f16222a);
        long j7 = this.f16223b;
        long j8 = this.f16224c;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(strValueOf);
        sb.append(", timeMillis=");
        sb.append(j7);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j8);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, this.f16222a, false);
        e1.b.K(parcel, 2, this.f16223b);
        e1.b.K(parcel, 3, this.f16224c);
        e1.b.F(parcel, 4, this.f16225d);
        e1.b.k(parcel, 5, this.f16226e, false);
        e1.b.b(parcel, iA);
    }

    public ActivityRecognitionResult(@c.m0 List<DetectedActivity> list, long j7, long j8) {
        this(list, j7, j8, 0, null);
    }

    @SafeParcelable.b
    @com.google.android.gms.common.internal.y
    public ActivityRecognitionResult(@SafeParcelable.e(id = 1) @c.m0 List<DetectedActivity> list, @SafeParcelable.e(id = 2) long j7, @SafeParcelable.e(id = 3) long j8, @SafeParcelable.e(id = 4) int i7, @c.o0 @SafeParcelable.e(id = 5) Bundle bundle) {
        com.google.android.gms.common.internal.u.b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        com.google.android.gms.common.internal.u.b(j7 > 0 && j8 > 0, "Must set times");
        this.f16222a = list;
        this.f16223b = j7;
        this.f16224c = j8;
        this.f16225d = i7;
        this.f16226e = bundle;
    }
}
