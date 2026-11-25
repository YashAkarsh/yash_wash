package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n1 {
    private n1() {
    }

    @c.o0
    public static <T extends Parcelable> T a(@c.o0 Bundle bundle, String str) {
        ClassLoader classLoaderD = d();
        bundle.setClassLoader(classLoaderD);
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(classLoaderD);
        return (T) bundle2.getParcelable(str);
    }

    public static void b(@c.o0 Bundle bundle, @c.o0 Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        Parcelable parcelableA = a(bundle, "MapOptions");
        if (parcelableA != null) {
            c(bundle2, "MapOptions", parcelableA);
        }
        Parcelable parcelableA2 = a(bundle, "StreetViewPanoramaOptions");
        if (parcelableA2 != null) {
            c(bundle2, "StreetViewPanoramaOptions", parcelableA2);
        }
        Parcelable parcelableA3 = a(bundle, "camera");
        if (parcelableA3 != null) {
            c(bundle2, "camera", parcelableA3);
        }
        if (bundle.containsKey("position")) {
            bundle2.putString("position", bundle.getString("position"));
        }
        if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
            bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
        }
    }

    public static void c(Bundle bundle, String str, @c.o0 Parcelable parcelable) {
        ClassLoader classLoaderD = d();
        bundle.setClassLoader(classLoaderD);
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(classLoaderD);
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }

    private static ClassLoader d() {
        return (ClassLoader) com.google.android.gms.common.internal.u.k(n1.class.getClassLoader());
    }
}
