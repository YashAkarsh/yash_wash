package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ActivityTransitionRequestCreator")
@SafeParcelable.f({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new c2();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.m0
    public static final Comparator<ActivityTransition> f16236e = new b2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getActivityTransitions", id = 1)
    private final List<ActivityTransition> f16237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getTag", id = 2)
    private final String f16238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getClients", id = 3)
    private final List<ClientIdentity> f16239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getContextAttributionTag", id = 4)
    private String f16240d;

    public ActivityTransitionRequest(@c.m0 List<ActivityTransition> list) {
        this(list, null, null, null);
    }

    @c.m0
    public final ActivityTransitionRequest K(@c.o0 String str) {
        this.f16240d = str;
        return this;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (com.google.android.gms.common.internal.s.b(this.f16237a, activityTransitionRequest.f16237a) && com.google.android.gms.common.internal.s.b(this.f16238b, activityTransitionRequest.f16238b) && com.google.android.gms.common.internal.s.b(this.f16240d, activityTransitionRequest.f16240d) && com.google.android.gms.common.internal.s.b(this.f16239c, activityTransitionRequest.f16239c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f16237a.hashCode() * 31;
        String str = this.f16238b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f16239c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f16240d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public void s(@c.m0 Intent intent) {
        com.google.android.gms.common.internal.u.k(intent);
        e1.c.n(this, intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
    }

    @c.m0
    public String toString() {
        String strValueOf = String.valueOf(this.f16237a);
        String str = this.f16238b;
        String strValueOf2 = String.valueOf(this.f16239c);
        String str2 = this.f16240d;
        int length = strValueOf.length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 79 + length2 + strValueOf2.length() + String.valueOf(str2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(strValueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("', mClients=");
        sb.append(strValueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, this.f16237a, false);
        e1.b.Y(parcel, 2, this.f16238b, false);
        e1.b.d0(parcel, 3, this.f16239c, false);
        e1.b.Y(parcel, 4, this.f16240d, false);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    public ActivityTransitionRequest(@SafeParcelable.e(id = 1) @c.m0 List<ActivityTransition> list, @c.o0 @SafeParcelable.e(id = 2) String str, @c.o0 @SafeParcelable.e(id = 3) List<ClientIdentity> list2, @c.o0 @SafeParcelable.e(id = 4) String str2) {
        com.google.android.gms.common.internal.u.l(list, "transitions can't be null");
        com.google.android.gms.common.internal.u.b(list.size() > 0, "transitions can't be empty.");
        com.google.android.gms.common.internal.u.k(list);
        TreeSet treeSet = new TreeSet(f16236e);
        for (ActivityTransition activityTransition : list) {
            com.google.android.gms.common.internal.u.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.f16237a = Collections.unmodifiableList(list);
        this.f16238b = str;
        this.f16239c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f16240d = str2;
    }
}
