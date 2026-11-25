package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
@y1.f(y1.f.a.FULL)
@s1.c
public class o extends Number implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f22863b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicLongFieldUpdater<o> f22864c = AtomicLongFieldUpdater.newUpdater(o.class, "a");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile transient long f22865a;

    public o(double d8) {
        this.f22865a = Double.doubleToRawLongBits(d8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        g(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(c());
    }

    @u1.a
    public final double a(double d8) {
        long j7;
        double dLongBitsToDouble;
        do {
            j7 = this.f22865a;
            dLongBitsToDouble = Double.longBitsToDouble(j7) + d8;
        } while (!f22864c.compareAndSet(this, j7, Double.doubleToRawLongBits(dLongBitsToDouble)));
        return dLongBitsToDouble;
    }

    public final boolean b(double d8, double d9) {
        return f22864c.compareAndSet(this, Double.doubleToRawLongBits(d8), Double.doubleToRawLongBits(d9));
    }

    public final double c() {
        return Double.longBitsToDouble(this.f22865a);
    }

    @u1.a
    public final double d(double d8) {
        long j7;
        double dLongBitsToDouble;
        do {
            j7 = this.f22865a;
            dLongBitsToDouble = Double.longBitsToDouble(j7);
        } while (!f22864c.compareAndSet(this, j7, Double.doubleToRawLongBits(dLongBitsToDouble + d8)));
        return dLongBitsToDouble;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return c();
    }

    public final double e(double d8) {
        return Double.longBitsToDouble(f22864c.getAndSet(this, Double.doubleToRawLongBits(d8)));
    }

    public final void f(double d8) {
        f22864c.lazySet(this, Double.doubleToRawLongBits(d8));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) c();
    }

    public final void g(double d8) {
        this.f22865a = Double.doubleToRawLongBits(d8);
    }

    public final boolean h(double d8, double d9) {
        return f22864c.weakCompareAndSet(this, Double.doubleToRawLongBits(d8), Double.doubleToRawLongBits(d9));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) c();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) c();
    }

    public String toString() {
        return Double.toString(c());
    }

    public o() {
    }
}
