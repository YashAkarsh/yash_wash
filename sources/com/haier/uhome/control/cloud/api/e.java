package com.haier.uhome.control.cloud.api;

import com.haier.uhome.usdk.base.api.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29115a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29116b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f29122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f29123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f29124j;

    public void a(String str, o oVar) {
        com.haier.uhome.control.cloud.service.c.l().b(this.f29117c, str, oVar);
    }

    public synchronized void b(String str) {
        this.f29122h.remove(str);
    }

    public void c(String str) {
        this.f29117c = str;
    }

    public void d(String str) {
        this.f29118d = str;
    }

    public void e(String str) {
        this.f29119e = str;
    }

    public void f(String str) {
        this.f29121g = str;
    }

    public long g() {
        return this.f29123i;
    }

    public int h() {
        return this.f29124j;
    }

    public synchronized void a(String str) {
        this.f29122h.add(str);
    }

    public String c() {
        return this.f29119e;
    }

    public int d() {
        return this.f29120f;
    }

    public String e() {
        return this.f29121g;
    }

    public ArrayList<String> f() {
        return this.f29122h;
    }

    public String b() {
        return this.f29118d;
    }

    public String a() {
        return this.f29117c;
    }

    public void b(int i7) {
        this.f29124j = i7;
    }

    public void a(int i7) {
        this.f29120f = i7;
    }

    public void a(ArrayList<String> arrayList) {
        this.f29122h = arrayList;
    }

    public void a(long j7) {
        this.f29123i = j7;
    }
}
