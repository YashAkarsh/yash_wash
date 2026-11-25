package com.haier.uhome.control.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28716d;

    public String a() {
        return this.f28713a;
    }

    public int b() {
        return this.f28714b;
    }

    public String c() {
        return this.f28715c;
    }

    public String d() {
        return this.f28716d;
    }

    public String toString() {
        return "CloudDeviceBindResult{protocol='" + this.f28713a + "', result=" + this.f28714b + ", devId='" + this.f28715c + "', uplusId='" + this.f28716d + "'}";
    }

    public void a(String str) {
        this.f28713a = str;
    }

    public void b(String str) {
        this.f28715c = str;
    }

    public void c(String str) {
        this.f28716d = str;
    }

    public void a(int i7) {
        this.f28714b = i7;
    }
}
