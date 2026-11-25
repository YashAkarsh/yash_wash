package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15626b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15627a = false;

    @c.o0
    @c1.a
    protected static Integer K() {
        synchronized (f15626b) {
        }
        return null;
    }

    @c1.a
    protected static boolean s(@c.m0 String str) {
        synchronized (f15626b) {
        }
        return true;
    }

    @c1.a
    protected abstract boolean Q(int i7);

    @c1.a
    public void p0(boolean z7) {
        this.f15627a = z7;
    }

    @c1.a
    protected boolean r0() {
        return this.f15627a;
    }
}
