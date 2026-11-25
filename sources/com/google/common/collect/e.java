package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class e<T> extends ck<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f20178a = b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f20179b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20180a;

        static {
            int[] iArr = new int[b.values().length];
            f20180a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20180a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected e() {
    }

    private boolean c() {
        this.f20178a = b.FAILED;
        this.f20179b = a();
        if (this.f20178a == b.DONE) {
            return false;
        }
        this.f20178a = b.READY;
        return true;
    }

    protected abstract T a();

    @u1.a
    protected final T b() {
        this.f20178a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @u1.a
    public final boolean hasNext() {
        com.google.common.base.e0.g0(this.f20178a != b.FAILED);
        int i7 = a.f20180a[this.f20178a.ordinal()];
        if (i7 == 1) {
            return false;
        }
        if (i7 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @u1.a
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f20178a = b.NOT_READY;
        T t7 = this.f20179b;
        this.f20179b = null;
        return t7;
    }

    public final T peek() {
        if (hasNext()) {
            return this.f20179b;
        }
        throw new NoSuchElementException();
    }
}
