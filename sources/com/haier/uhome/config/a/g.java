package com.haier.uhome.config.a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f28451c;

    public g(String str, int i7, a aVar) {
        this.f28449a = str;
        this.f28450b = i7;
        this.f28451c = aVar;
    }

    public a a() {
        return this.f28451c;
    }

    public String b() {
        return this.f28449a;
    }

    public int c() {
        return this.f28450b;
    }

    public String toString() {
        return "uSDKDeviceConfigInfoAP{ssid='" + this.f28449a + ", power=" + this.f28450b + ", encryptionType=" + this.f28451c + '}';
    }
}
