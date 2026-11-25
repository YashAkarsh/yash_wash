package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "PatternItemCreator")
@SafeParcelable.f({1})
public class PatternItem extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<PatternItem> CREATOR = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16609c = "PatternItem";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getType", id = 2)
    private final int f16610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getLength", id = 3)
    private final Float f16611b;

    @SafeParcelable.b
    public PatternItem(@SafeParcelable.e(id = 2) int i7, @o0 @SafeParcelable.e(id = 3) Float f8) {
        boolean z7 = true;
        if (i7 != 1 && (f8 == null || f8.floatValue() < 0.0f)) {
            z7 = false;
        }
        String strValueOf = String.valueOf(f8);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i7);
        sb.append(" length=");
        sb.append(strValueOf);
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
        this.f16610a = i7;
        this.f16611b = f8;
    }

    @o0
    static List<PatternItem> s(@o0 List<PatternItem> list) {
        PatternItem dash;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PatternItem dot : list) {
            if (dot == null) {
                dot = null;
            } else {
                int i7 = dot.f16610a;
                if (i7 == 0) {
                    com.google.android.gms.common.internal.u.r(dot.f16611b != null, "length must not be null.");
                    dash = new Dash(dot.f16611b.floatValue());
                } else if (i7 == 1) {
                    dot = new Dot();
                } else if (i7 != 2) {
                    String str = f16609c;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Unknown PatternItem type: ");
                    sb.append(i7);
                    Log.w(str, sb.toString());
                } else {
                    com.google.android.gms.common.internal.u.r(dot.f16611b != null, "length must not be null.");
                    dash = new Gap(dot.f16611b.floatValue());
                }
                dot = dash;
            }
            arrayList.add(dot);
        }
        return arrayList;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f16610a == patternItem.f16610a && com.google.android.gms.common.internal.s.b(this.f16611b, patternItem.f16611b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16610a), this.f16611b);
    }

    @m0
    public String toString() {
        int i7 = this.f16610a;
        String strValueOf = String.valueOf(this.f16611b);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i7);
        sb.append(" length=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 2, this.f16610a);
        e1.b.z(parcel, 3, this.f16611b, false);
        e1.b.b(parcel, iA);
    }
}
