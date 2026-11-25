package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public class p implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f22875b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient AtomicLongArray f22876a;

    public p(int i7) {
        this.f22876a = new AtomicLongArray(i7);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i7 = objectInputStream.readInt();
        com.google.common.primitives.y.c cVarF = com.google.common.primitives.y.f();
        for (int i8 = 0; i8 < i7; i8++) {
            cVarF.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.f22876a = new AtomicLongArray(cVarF.g().F());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int iG = g();
        objectOutputStream.writeInt(iG);
        for (int i7 = 0; i7 < iG; i7++) {
            objectOutputStream.writeDouble(c(i7));
        }
    }

    @u1.a
    public double a(int i7, double d8) {
        long j7;
        double dLongBitsToDouble;
        do {
            j7 = this.f22876a.get(i7);
            dLongBitsToDouble = Double.longBitsToDouble(j7) + d8;
        } while (!this.f22876a.compareAndSet(i7, j7, Double.doubleToRawLongBits(dLongBitsToDouble)));
        return dLongBitsToDouble;
    }

    public final boolean b(int i7, double d8, double d9) {
        return this.f22876a.compareAndSet(i7, Double.doubleToRawLongBits(d8), Double.doubleToRawLongBits(d9));
    }

    public final double c(int i7) {
        return Double.longBitsToDouble(this.f22876a.get(i7));
    }

    @u1.a
    public final double d(int i7, double d8) {
        long j7;
        double dLongBitsToDouble;
        do {
            j7 = this.f22876a.get(i7);
            dLongBitsToDouble = Double.longBitsToDouble(j7);
        } while (!this.f22876a.compareAndSet(i7, j7, Double.doubleToRawLongBits(dLongBitsToDouble + d8)));
        return dLongBitsToDouble;
    }

    public final double e(int i7, double d8) {
        return Double.longBitsToDouble(this.f22876a.getAndSet(i7, Double.doubleToRawLongBits(d8)));
    }

    public final void f(int i7, double d8) {
        this.f22876a.lazySet(i7, Double.doubleToRawLongBits(d8));
    }

    public final int g() {
        return this.f22876a.length();
    }

    public final void h(int i7, double d8) {
        this.f22876a.set(i7, Double.doubleToRawLongBits(d8));
    }

    public final boolean i(int i7, double d8, double d9) {
        return this.f22876a.weakCompareAndSet(i7, Double.doubleToRawLongBits(d8), Double.doubleToRawLongBits(d9));
    }

    public String toString() {
        int iG = g() - 1;
        if (iG == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder((iG + 1) * 19);
        sb.append('[');
        int i7 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.f22876a.get(i7)));
            if (i7 == iG) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i7++;
        }
    }

    public p(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i7 = 0; i7 < length; i7++) {
            jArr[i7] = Double.doubleToRawLongBits(dArr[i7]);
        }
        this.f22876a = new AtomicLongArray(jArr);
    }
}
