package com.haier.globalwasher.modle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.LatLng;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.v;
import com.haier.globalwasher.modle.utils.v.d;
import com.haier.globalwasher.modle.utils.v.e;
import com.haier.globalwasher.modle.utils.z;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f24395j = 1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f24396k = 10.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f24397l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocationManager f24398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocationListener f24399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BaseActivity f24400c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Resources f24403f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    v f24405h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24401d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24402e = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24404g = "LocationUtil";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f24406i = false;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f24406i = false;
            MyApplication.e();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f24406i = false;
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.setFlags(268435456);
            e.this.f24400c.startActivityForResult(intent, 1007);
        }
    }

    public class c implements LocationListener {
        public c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            LatLng latLng = LatLng.getInstance(e.this.f24400c);
            latLng.setLatitude(location.getLatitude());
            latLng.setLongitude(location.getLongitude());
            q.c("MyLocationListener", "onLocationChanged---" + LatLng.getInstance(e.this.f24400c).getLatitude() + ", " + LatLng.getInstance(e.this.f24400c).getLongitude());
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            q.c("MyLocationListener", "onProviderDisabled---" + str);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            q.c("MyLocationListener", "onProviderEnabled---" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i7, Bundle bundle) {
            q.c("MyLocationListener", "onStatusChanged---" + str);
        }
    }

    public e(BaseActivity baseActivity) {
        this.f24400c = baseActivity;
        this.f24403f = baseActivity.getResources();
    }

    public void b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f24403f.getString(R.string.exit_app));
        arrayList.add(this.f24403f.getString(R.string.to_setting));
        if (this.f24405h == null) {
            this.f24405h = new v();
        }
        v vVar = this.f24405h;
        Objects.requireNonNull(vVar);
        v.e eVar = vVar.new e();
        eVar.b(this.f24400c);
        q.c(this.f24404g, "权限权限权限权限权限权限权限权限权限权限权1限权限");
        v vVar2 = this.f24405h;
        BaseActivity baseActivity = this.f24400c;
        String string = this.f24403f.getString(R.string.pop_title);
        v vVar3 = this.f24405h;
        Objects.requireNonNull(vVar3);
        vVar2.l(baseActivity, string, arrayList, vVar3.new d(), eVar);
    }

    @SuppressLint({"MissingPermission"})
    public int c() {
        if (this.f24398a == null) {
            this.f24398a = (LocationManager) this.f24400c.getSystemService("location");
        }
        if (this.f24399b == null) {
            this.f24399b = new c();
        }
        q.c(this.f24404g, "initLocation");
        if (!this.f24398a.isProviderEnabled("network")) {
            q.c(this.f24404g, "openLocationSwitch");
            d();
            return 3;
        }
        q.c(this.f24404g, "isProviderEnabled");
        if (androidx.core.content.d.a(this.f24400c, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.f24398a.requestLocationUpdates("network", 1000L, 10.0f, this.f24399b);
            q.c(this.f24404g, "requestLocationUpdates");
            return 1;
        }
        i0.d(this.f24400c, this.f24403f.getString(R.string.pop_title_network));
        q.c(this.f24404g, "权限权限权限权限权限权限权限121323123123123权限权限权限权1限权限");
        b();
        return 2;
    }

    public void d() {
        if (this.f24406i) {
            return;
        }
        this.f24406i = true;
        z.f(this.f24400c, this.f24403f.getString(R.string.open_location_switch_popup_title), this.f24403f.getString(R.string.open_location_switch_popup_content), this.f24403f.getString(R.string.exit_app), this.f24403f.getString(R.string.open_location_switch_popup_right_away_start), new a(), new b());
    }
}
