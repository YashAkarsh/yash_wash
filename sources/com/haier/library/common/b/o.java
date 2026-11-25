package com.haier.library.common.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f26440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f26441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f26442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f26443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f26444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<Integer, q> f26445i = new HashMap();

    public String a() {
        return this.f26437a;
    }

    public void b(double d8) {
        this.f26440d = d8;
    }

    public void c(int i7) {
        this.f26438b = i7;
    }

    public void d(String str) {
        this.f26437a = str;
    }

    public void e(Map<Integer, q> map) {
        this.f26445i = map;
    }

    public int f() {
        return this.f26438b;
    }

    public void g(double d8) {
        this.f26441e = d8;
    }

    public void h(int i7) {
        this.f26439c = i7;
    }

    public int i() {
        return this.f26439c;
    }

    public void j(double d8) {
        this.f26442f = d8;
    }

    public void k(int i7) {
        this.f26444h = i7;
    }

    public double l() {
        return this.f26440d;
    }

    public void m(double d8) {
        this.f26443g = d8;
    }

    public double n() {
        return this.f26441e;
    }

    public double o() {
        return this.f26442f;
    }

    public double p() {
        return this.f26443g;
    }

    public int q() {
        return this.f26444h;
    }

    public Map<Integer, q> r() {
        return this.f26445i;
    }

    public String toString() {
        return "PingResult{url='" + this.f26437a + "', sendCount=" + this.f26438b + ", receiveCount=" + this.f26439c + ", packetLossRate=" + this.f26440d + ", fastestTimeCost=" + this.f26441e + ", slowestTimeCost=" + this.f26442f + ", averageTimeCost=" + this.f26443g + ", packetLength=" + this.f26444h + ", sequenceNumber2Result=" + this.f26445i + '}';
    }
}
