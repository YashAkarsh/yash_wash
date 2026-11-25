package com.haier.globalwasher.modle.utils.phone_util;

import android.location.LocationManager;
import com.haier.globalwasher.MyApplication;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a() {
        LocationManager locationManager = (LocationManager) MyApplication.k().getSystemService("location");
        boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
        if (zIsProviderEnabled) {
            return 1;
        }
        return zIsProviderEnabled2 ? 2 : 0;
    }
}
