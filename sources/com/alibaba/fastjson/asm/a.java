package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f12537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f12538b;

    public a() {
        this.f12537a = new byte[64];
    }

    private void a(int i7) {
        byte[] bArr = this.f12537a;
        int length = bArr.length * 2;
        int i8 = this.f12538b;
        int i9 = i7 + i8;
        if (length <= i9) {
            length = i9;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        this.f12537a = bArr2;
    }

    a b(int i7, int i8) {
        int i9 = this.f12538b;
        if (i9 + 2 > this.f12537a.length) {
            a(2);
        }
        byte[] bArr = this.f12537a;
        int i10 = i9 + 1;
        bArr[i9] = (byte) i7;
        bArr[i10] = (byte) i8;
        this.f12538b = i10 + 1;
        return this;
    }

    a c(int i7, int i8) {
        int i9 = this.f12538b;
        if (i9 + 3 > this.f12537a.length) {
            a(3);
        }
        byte[] bArr = this.f12537a;
        int i10 = i9 + 1;
        bArr[i9] = (byte) i7;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >>> 8);
        bArr[i11] = (byte) i8;
        this.f12538b = i11 + 1;
        return this;
    }

    public a d(int i7) {
        int i8 = this.f12538b;
        int i9 = i8 + 1;
        if (i9 > this.f12537a.length) {
            a(1);
        }
        this.f12537a[i8] = (byte) i7;
        this.f12538b = i9;
        return this;
    }

    public a e(byte[] bArr, int i7, int i8) {
        if (this.f12538b + i8 > this.f12537a.length) {
            a(i8);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i7, this.f12537a, this.f12538b, i8);
        }
        this.f12538b += i8;
        return this;
    }

    public a f(int i7) {
        int i8 = this.f12538b;
        if (i8 + 4 > this.f12537a.length) {
            a(4);
        }
        byte[] bArr = this.f12537a;
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 24);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i7 >>> 8);
        bArr[i11] = (byte) i7;
        this.f12538b = i11 + 1;
        return this;
    }

    public a g(int i7) {
        int i8 = this.f12538b;
        if (i8 + 2 > this.f12537a.length) {
            a(2);
        }
        byte[] bArr = this.f12537a;
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 8);
        bArr[i9] = (byte) i7;
        this.f12538b = i9 + 1;
        return this;
    }

    public a h(String str) {
        int length = str.length();
        int i7 = this.f12538b;
        if (i7 + 2 + length > this.f12537a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f12537a;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (length >>> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) length;
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 1 || cCharAt > 127) {
                throw new UnsupportedOperationException();
            }
            bArr[i9] = (byte) cCharAt;
            i10++;
            i9++;
        }
        this.f12538b = i9;
        return this;
    }

    public a(int i7) {
        this.f12537a = new byte[i7];
    }
}
