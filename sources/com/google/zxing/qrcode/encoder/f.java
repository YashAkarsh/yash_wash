package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.h;
import com.google.zxing.qrcode.decoder.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24224f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f24225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.zxing.qrcode.decoder.f f24226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f24227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24228d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f24229e;

    public static boolean f(int i7) {
        return i7 >= 0 && i7 < 8;
    }

    public com.google.zxing.qrcode.decoder.f a() {
        return this.f24226b;
    }

    public int b() {
        return this.f24228d;
    }

    public b c() {
        return this.f24229e;
    }

    public h d() {
        return this.f24225a;
    }

    public j e() {
        return this.f24227c;
    }

    public void g(com.google.zxing.qrcode.decoder.f fVar) {
        this.f24226b = fVar;
    }

    public void h(int i7) {
        this.f24228d = i7;
    }

    public void i(b bVar) {
        this.f24229e = bVar;
    }

    public void j(h hVar) {
        this.f24225a = hVar;
    }

    public void k(j jVar) {
        this.f24227c = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f24225a);
        sb.append("\n ecLevel: ");
        sb.append(this.f24226b);
        sb.append("\n version: ");
        sb.append(this.f24227c);
        sb.append("\n maskPattern: ");
        sb.append(this.f24228d);
        if (this.f24229e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f24229e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
