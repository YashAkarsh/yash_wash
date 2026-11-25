package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@s1.b
abstract class b<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0222b f19290a = EnumC0222b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f19291b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19292a;

        static {
            int[] iArr = new int[EnumC0222b.values().length];
            f19292a = iArr;
            try {
                iArr[EnumC0222b.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19292a[EnumC0222b.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    private enum EnumC0222b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected b() {
    }

    private boolean c() {
        this.f19290a = EnumC0222b.FAILED;
        this.f19291b = a();
        if (this.f19290a == EnumC0222b.DONE) {
            return false;
        }
        this.f19290a = EnumC0222b.READY;
        return true;
    }

    protected abstract T a();

    @u1.a
    protected final T b() {
        this.f19290a = EnumC0222b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        e0.g0(this.f19290a != EnumC0222b.FAILED);
        int i7 = a.f19292a[this.f19290a.ordinal()];
        if (i7 == 1) {
            return true;
        }
        if (i7 != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f19290a = EnumC0222b.NOT_READY;
        T t7 = this.f19291b;
        this.f19291b = null;
        return t7;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
