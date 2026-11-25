package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class j4 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f20465a;

    j4(int i7) {
        this.f20465a = i7;
    }

    public void a(int i7) {
        this.f20465a += i7;
    }

    public int b(int i7) {
        int i8 = this.f20465a + i7;
        this.f20465a = i8;
        return i8;
    }

    public int c() {
        return this.f20465a;
    }

    public int d(int i7) {
        int i8 = this.f20465a;
        this.f20465a = i7;
        return i8;
    }

    public void e(int i7) {
        this.f20465a = i7;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j4) && ((j4) obj).f20465a == this.f20465a;
    }

    public int hashCode() {
        return this.f20465a;
    }

    public String toString() {
        return Integer.toString(this.f20465a);
    }
}
