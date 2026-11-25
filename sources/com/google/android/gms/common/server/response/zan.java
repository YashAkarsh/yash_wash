package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FieldMappingDictionaryCreator")
@y
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f15957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRootClassName", id = 3)
    private final String f15958c;

    @SafeParcelable.b
    zan(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) ArrayList<zal> arrayList, @SafeParcelable.e(id = 3) String str) {
        this.f15956a = i7;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = new HashMap<>();
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            zal zalVar = arrayList.get(i8);
            String str2 = zalVar.f15951b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) u.k(zalVar.f15952c)).size();
            for (int i9 = 0; i9 < size2; i9++) {
                zam zamVar = zalVar.f15952c.get(i9);
                map2.put(zamVar.f15954b, zamVar.f15955c);
            }
            map.put(str2, map2);
        }
        this.f15957b = map;
        this.f15958c = (String) u.k(str);
        r0();
    }

    public final String K() {
        return this.f15958c;
    }

    @o0
    public final Map<String, FastJsonResponse.Field<?, ?>> Q(String str) {
        return this.f15957b.get(str);
    }

    public final void p0() {
        for (String str : this.f15957b.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f15957b.get(str);
            HashMap map2 = new HashMap();
            for (String str2 : map.keySet()) {
                map2.put(str2, map.get(str2).V0());
            }
            this.f15957b.put(str, map2);
        }
    }

    public final void r0() {
        Iterator<String> it = this.f15957b.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f15957b.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).s1(this);
            }
        }
    }

    public final void s0(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.f15957b.put((String) u.k(cls.getCanonicalName()), map);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f15957b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f15957b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public final boolean v0(Class<? extends FastJsonResponse> cls) {
        return this.f15957b.containsKey(u.k(cls.getCanonicalName()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15956a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f15957b.keySet()) {
            arrayList.add(new zal(str, this.f15957b.get(str)));
        }
        e1.b.d0(parcel, 2, arrayList, false);
        e1.b.Y(parcel, 3, this.f15958c, false);
        e1.b.b(parcel, iA);
    }

    public zan(Class<? extends FastJsonResponse> cls) {
        this.f15956a = 1;
        this.f15957b = new HashMap<>();
        this.f15958c = (String) u.k(cls.getCanonicalName());
    }
}
