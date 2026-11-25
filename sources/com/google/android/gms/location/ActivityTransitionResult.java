package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ActivityTransitionResultCreator")
@SafeParcelable.f({1000})
public class ActivityTransitionResult extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new d2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransitionEvents", id = 1)
    private final List<ActivityTransitionEvent> f16241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getExtras", id = 2)
    private Bundle f16242b;

    public ActivityTransitionResult(@SafeParcelable.e(id = 1) @c.m0 List<ActivityTransitionEvent> list) {
        this.f16242b = null;
        com.google.android.gms.common.internal.u.l(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i7 = 1; i7 < list.size(); i7++) {
                com.google.android.gms.common.internal.u.a(list.get(i7).Q() >= list.get(i7 + (-1)).Q());
            }
        }
        this.f16241a = Collections.unmodifiableList(list);
    }

    public static boolean Q(@c.o0 Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
    }

    @c.o0
    public static ActivityTransitionResult s(@c.m0 Intent intent) {
        if (Q(intent)) {
            return (ActivityTransitionResult) e1.c.b(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", CREATOR);
        }
        return null;
    }

    @c.m0
    public List<ActivityTransitionEvent> K() {
        return this.f16241a;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f16241a.equals(((ActivityTransitionResult) obj).f16241a);
    }

    public int hashCode() {
        return this.f16241a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, K(), false);
        e1.b.k(parcel, 2, this.f16242b, false);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    @com.google.android.gms.common.internal.y
    public ActivityTransitionResult(@SafeParcelable.e(id = 1) @c.m0 List<ActivityTransitionEvent> list, @c.o0 @SafeParcelable.e(id = 2) Bundle bundle) {
        this(list);
        this.f16242b = bundle;
    }
}
