package com.haier.uhome.search.service.entity;

import android.net.wifi.ScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f29917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ScanResult> f29918b;

    public h(boolean z7, List<ScanResult> list) {
        this.f29917a = z7;
        this.f29918b = list;
    }

    public boolean a() {
        return this.f29917a;
    }

    public List<ScanResult> b() {
        return this.f29918b;
    }
}
