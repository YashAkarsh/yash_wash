package com.haier.uhome.usdk.scene.json.down;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ReportBean {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @b(name = "t")
    private long f32080t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @b(name = "v")
    private String f32081v;

    public long getT() {
        return this.f32080t;
    }

    public String getV() {
        return this.f32081v;
    }

    public void setT(long j7) {
        this.f32080t = j7;
    }

    public void setV(String str) {
        this.f32081v = str;
    }

    public String toString() {
        return "AttrsReport{t=" + this.f32080t + ", v='" + this.f32081v + "'}";
    }
}
