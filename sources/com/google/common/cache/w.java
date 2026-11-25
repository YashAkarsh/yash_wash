package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class w extends c0 implements Serializable, u {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f19850j = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f19601c = 0;
        this.f19599a = null;
        this.f19600b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(b());
    }

    @Override // com.google.common.cache.u
    public void a() {
        c(1L);
    }

    @Override // com.google.common.cache.u
    public long b() {
        long j7 = this.f19600b;
        c0.b[] bVarArr = this.f19599a;
        if (bVarArr != null) {
            for (c0.b bVar : bVarArr) {
                if (bVar != null) {
                    j7 += bVar.f19611h;
                }
            }
        }
        return j7;
    }

    @Override // com.google.common.cache.u
    public void c(long j7) {
        int length;
        c0.b bVar;
        c0.b[] bVarArr = this.f19599a;
        if (bVarArr == null) {
            long j8 = this.f19600b;
            if (e(j8, j8 + j7)) {
                return;
            }
        }
        int[] iArr = c0.f19593d.get();
        boolean zA = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j9 = bVar.f19611h;
            zA = bVar.a(j9, j9 + j7);
            if (zA) {
                return;
            }
        }
        j(j7, iArr, zA);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return b();
    }

    @Override // com.google.common.cache.c0
    final long g(long j7, long j8) {
        return j7 + j8;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) b();
    }

    public void k() {
        c(-1L);
    }

    public void l() {
        i(0L);
    }

    @Override // java.lang.Number
    public long longValue() {
        return b();
    }

    public long m() {
        long j7 = this.f19600b;
        c0.b[] bVarArr = this.f19599a;
        this.f19600b = 0L;
        if (bVarArr != null) {
            for (c0.b bVar : bVarArr) {
                if (bVar != null) {
                    j7 += bVar.f19611h;
                    bVar.f19611h = 0L;
                }
            }
        }
        return j7;
    }

    public String toString() {
        return Long.toString(b());
    }
}
