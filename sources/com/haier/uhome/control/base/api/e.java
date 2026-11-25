package com.haier.uhome.control.base.api;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<d> f28791c;

    public e(String str, String str2, List<d> list) {
        this.f28789a = str;
        this.f28790b = str2;
        this.f28791c = list;
    }

    public String a() {
        return this.f28789a;
    }

    public String b() {
        return this.f28790b;
    }

    public List<d> c() {
        return this.f28791c;
    }

    public String toString() {
        return "DeviceEvent{mName='" + this.f28789a + "', mType='" + this.f28790b + "', attrs=" + this.f28791c + '}';
    }

    public void a(String str) {
        this.f28789a = str;
    }

    public void b(String str) {
        this.f28790b = str;
    }

    public void a(List<d> list) {
        this.f28791c = list;
    }
}
