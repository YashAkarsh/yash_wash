package com.haier.hailicommontlib.mvp_api.moudle.bean;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f26221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26222e;

    public d(String str, int i7, String str2) {
        this.f26218a = str;
        this.f26219b = i7;
        this.f26220c = str2;
    }

    public String a() {
        return this.f26218a;
    }

    public String b() {
        return this.f26220c;
    }

    public String c() {
        return this.f26222e;
    }

    public int d() {
        return this.f26219b;
    }

    public void e(String str) {
        this.f26218a = str;
    }

    public void f(String str) {
        this.f26220c = str;
    }

    public void g(String str) {
        this.f26222e = str;
    }

    public void h(int i7) {
        this.f26219b = i7;
    }
}
