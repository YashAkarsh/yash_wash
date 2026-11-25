package com.haier.uhome.search.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WifiManager f30018a;

    public l(WifiManager wifiManager) {
        this.f30018a = wifiManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", false);
        if (this.f30018a == null) {
            e3.a.v("WifiScanReceiver: wifiManager is null!", new Object[0]);
            return;
        }
        if (!com.haier.library.common.util.f.j(context, "android.permission.ACCESS_COARSE_LOCATION") || !com.haier.library.common.util.f.j(context, "android.permission.ACCESS_FINE_LOCATION")) {
            e3.a.v("WifiScanReceiver: location permission denied!", new Object[0]);
            return;
        }
        List<ScanResult> scanResults = this.f30018a.getScanResults();
        if (scanResults == null) {
            scanResults = new ArrayList<>();
        }
        com.haier.uhome.usdk.base.d.c.a().c(new com.haier.uhome.search.service.entity.h(booleanExtra, scanResults));
    }
}
