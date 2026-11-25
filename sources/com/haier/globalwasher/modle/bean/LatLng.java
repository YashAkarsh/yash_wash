package com.haier.globalwasher.modle.bean;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.e;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LatLng implements Serializable {
    public double latitude;
    public double longitude;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LatLng f24356a = new LatLng();

        private a() {
        }
    }

    public static LatLng getInstance(BaseActivity baseActivity) {
        LatLng latLng = a.f24356a;
        if (latLng != null && (latLng.getLatitude() == 0.0d || latLng.getLongitude() == 0.0d)) {
            new e(baseActivity).c();
        }
        return latLng;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d8) {
        this.latitude = d8;
    }

    public void setLongitude(double d8) {
        this.longitude = d8;
    }
}
