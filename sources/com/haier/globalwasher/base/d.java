package com.haier.globalwasher.base;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f24328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24329e;

    public d(String str, int i7, String str2) {
        this.f24325a = str;
        this.f24326b = i7;
        this.f24327c = str2;
    }

    public String a() {
        return this.f24325a;
    }

    public String b() {
        return this.f24327c;
    }

    public String c() {
        return this.f24329e;
    }

    public int d() {
        return this.f24326b;
    }

    public void e(String str) {
        this.f24325a = str;
    }

    public void f(String str) {
        this.f24327c = str;
    }

    public void g(String str) {
        this.f24329e = str;
    }

    public void h(int i7) {
        this.f24326b = i7;
    }
}
