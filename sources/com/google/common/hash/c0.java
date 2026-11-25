package com.google.common.hash;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class c0 extends j0 implements Serializable, a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f21737j = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21809c = 0;
        this.f21807a = null;
        this.f21808b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(b());
    }

    @Override // com.google.common.hash.a0
    public void a() {
        c(1L);
    }

    @Override // com.google.common.hash.a0
    public long b() {
        long j7 = this.f21808b;
        j0.b[] bVarArr = this.f21807a;
        if (bVarArr != null) {
            for (j0.b bVar : bVarArr) {
                if (bVar != null) {
                    j7 += bVar.f21819h;
                }
            }
        }
        return j7;
    }

    @Override // com.google.common.hash.a0
    public void c(long j7) {
        int length;
        j0.b bVar;
        j0.b[] bVarArr = this.f21807a;
        if (bVarArr == null) {
            long j8 = this.f21808b;
            if (e(j8, j8 + j7)) {
                return;
            }
        }
        int[] iArr = j0.f21801d.get();
        boolean zA = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j9 = bVar.f21819h;
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

    @Override // com.google.common.hash.j0
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
        long j7 = this.f21808b;
        j0.b[] bVarArr = this.f21807a;
        this.f21808b = 0L;
        if (bVarArr != null) {
            for (j0.b bVar : bVarArr) {
                if (bVar != null) {
                    j7 += bVar.f21819h;
                    bVar.f21819h = 0L;
                }
            }
        }
        return j7;
    }

    public String toString() {
        return Long.toString(b());
    }
}
