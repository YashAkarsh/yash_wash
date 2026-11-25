package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "MapStyleOptionsCreator")
@SafeParcelable.f({1})
public final class MapStyleOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f16593b = "MapStyleOptions";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getJson", id = 2)
    private String f16594a;

    @SafeParcelable.b
    public MapStyleOptions(@SafeParcelable.e(id = 2) @m0 String str) {
        com.google.android.gms.common.internal.u.l(str, "json must not be null");
        this.f16594a = str;
    }

    @m0
    public static MapStyleOptions s(@m0 Context context, int i7) throws Resources.NotFoundException {
        try {
            return new MapStyleOptions(new String(g1.q.f(context.getResources().openRawResource(i7)), "UTF-8"));
        } catch (IOException e8) {
            String string = e8.toString();
            StringBuilder sb = new StringBuilder(string.length() + 37);
            sb.append("Failed to read resource ");
            sb.append(i7);
            sb.append(": ");
            sb.append(string);
            throw new Resources.NotFoundException(sb.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 2, this.f16594a, false);
        e1.b.b(parcel, iA);
    }
}
