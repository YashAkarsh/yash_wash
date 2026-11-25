package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @f.b
    private final int f16368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f16369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Location f16370d;

    private j(int i7, @f.b int i8, List<f> list, Location location) {
        this.f16367a = i7;
        this.f16368b = i8;
        this.f16369c = list;
        this.f16370d = location;
    }

    @c.m0
    public static j a(@c.m0 Intent intent) {
        ArrayList arrayList = null;
        if (intent == null) {
            return null;
        }
        int i7 = -1;
        int intExtra = intent.getIntExtra(com.google.android.gms.common.internal.g.f15733a, -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1) {
            if (intExtra2 == 1 || intExtra2 == 2) {
                i7 = intExtra2;
            } else if (intExtra2 == 4) {
                i7 = 4;
            }
        }
        ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2.size());
            int size = arrayList2.size();
            for (int i8 = 0; i8 < size; i8++) {
                byte[] bArr = (byte[]) arrayList2.get(i8);
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                zzbe zzbeVarCreateFromParcel = zzbe.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
                arrayList.add(zzbeVarCreateFromParcel);
            }
        }
        return new j(intExtra, i7, arrayList, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    public int b() {
        return this.f16367a;
    }

    @f.b
    public int c() {
        return this.f16368b;
    }

    @c.m0
    public List<f> d() {
        return this.f16369c;
    }

    @c.m0
    public Location e() {
        return this.f16370d;
    }

    public boolean f() {
        return this.f16367a != -1;
    }
}
