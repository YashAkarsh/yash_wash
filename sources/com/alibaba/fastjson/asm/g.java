package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12586b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f12589e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StringBuffer f12588d = new StringBuffer();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12587c = 0;

    protected g(int i7, int i8) {
        this.f12586b = i7;
        this.f12585a = i8;
        this.f12589e = i8 == 0;
    }

    protected String a() {
        return this.f12588d.length() != 0 ? this.f12588d.substring(1) : "";
    }

    protected void b(String str, int i7) {
        int i8 = this.f12586b;
        if (i7 < i8 || i7 >= i8 + this.f12585a) {
            return;
        }
        if (!str.equals("arg" + this.f12587c)) {
            this.f12589e = true;
        }
        this.f12588d.append(',');
        this.f12588d.append(str);
        this.f12587c++;
    }
}
