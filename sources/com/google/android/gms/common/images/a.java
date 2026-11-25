package com.google.android.gms.common.images;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15602b;

    public a(int i7, int i8) {
        this.f15601a = i7;
        this.f15602b = i8;
    }

    @m0
    public static a c(@m0 String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw d(str);
        }
        try {
            return new a(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (NumberFormatException unused) {
            throw d(str);
        }
    }

    private static NumberFormatException d(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public int a() {
        return this.f15602b;
    }

    public int b() {
        return this.f15601a;
    }

    public boolean equals(@o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f15601a == aVar.f15601a && this.f15602b == aVar.f15602b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = this.f15602b;
        int i8 = this.f15601a;
        return i7 ^ ((i8 >>> 16) | (i8 << 16));
    }

    @m0
    public String toString() {
        int i7 = this.f15601a;
        int i8 = this.f15602b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i7);
        sb.append("x");
        sb.append(i8);
        return sb.toString();
    }
}
