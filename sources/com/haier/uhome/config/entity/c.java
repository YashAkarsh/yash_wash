package com.haier.uhome.config.entity;

import com.haier.uhome.config.json.notify.ConfigProcessNotify;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.haier.uhome.config.a.d f28504c;

    private c(String str, String str2, com.haier.uhome.config.a.d dVar) {
        this.f28502a = str;
        this.f28503b = str2;
        this.f28504c = dVar;
    }

    public String a() {
        return this.f28502a;
    }

    public String b() {
        return this.f28503b;
    }

    public com.haier.uhome.config.a.d c() {
        return this.f28504c;
    }

    public String toString() {
        return "ConfigProgressDTO{wifiMac='" + this.f28502a + "', uplusId='" + this.f28503b + "', progress='" + this.f28504c + "'}";
    }

    public static c a(ConfigProcessNotify configProcessNotify) {
        return new c(configProcessNotify.getWifiMac(), configProcessNotify.getUplusId(), com.haier.uhome.config.a.d.a(configProcessNotify.getProgress()));
    }
}
