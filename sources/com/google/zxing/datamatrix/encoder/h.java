package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f23662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.zxing.f f23663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.zxing.f f23664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f23665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f23666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f23667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f23668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f23669i;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i7 = 0; i7 < length; i7++) {
            char c8 = (char) (bytes[i7] & 255);
            if (c8 == '?' && str.charAt(i7) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c8);
        }
        this.f23661a = sb.toString();
        this.f23662b = l.FORCE_NONE;
        this.f23665e = new StringBuilder(str.length());
        this.f23667g = -1;
    }

    private int i() {
        return this.f23661a.length() - this.f23669i;
    }

    public int a() {
        return this.f23665e.length();
    }

    public StringBuilder b() {
        return this.f23665e;
    }

    public char c() {
        return this.f23661a.charAt(this.f23666f);
    }

    public char d() {
        return this.f23661a.charAt(this.f23666f);
    }

    public String e() {
        return this.f23661a;
    }

    public int f() {
        return this.f23667g;
    }

    public int g() {
        return i() - this.f23666f;
    }

    public k h() {
        return this.f23668h;
    }

    public boolean j() {
        return this.f23666f < i();
    }

    public void k() {
        this.f23667g = -1;
    }

    public void l() {
        this.f23668h = null;
    }

    public void m(com.google.zxing.f fVar, com.google.zxing.f fVar2) {
        this.f23663c = fVar;
        this.f23664d = fVar2;
    }

    public void n(int i7) {
        this.f23669i = i7;
    }

    public void o(l lVar) {
        this.f23662b = lVar;
    }

    public void p(int i7) {
        this.f23667g = i7;
    }

    public void q() {
        r(a());
    }

    public void r(int i7) {
        k kVar = this.f23668h;
        if (kVar == null || i7 > kVar.b()) {
            this.f23668h = k.o(i7, this.f23662b, this.f23663c, this.f23664d, true);
        }
    }

    public void s(char c8) {
        this.f23665e.append(c8);
    }

    public void t(String str) {
        this.f23665e.append(str);
    }
}
