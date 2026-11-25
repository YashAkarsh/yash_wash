package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @c.m0
    protected final m f15136a;

    @c1.a
    protected LifecycleCallback(@c.m0 m mVar) {
        this.f15136a = mVar;
    }

    @c1.a
    @c.m0
    public static m c(@c.m0 Activity activity) {
        return e(new l(activity));
    }

    @c1.a
    @c.m0
    public static m d(@c.m0 ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @c1.a
    @c.m0
    protected static m e(@c.m0 l lVar) {
        if (lVar.d()) {
            return i4.C(lVar.b());
        }
        if (lVar.c()) {
            return g4.d(lVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static m getChimeraLifecycleFragmentImpl(l lVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @c1.a
    @c.j0
    public void a(@c.m0 String str, @c.m0 FileDescriptor fileDescriptor, @c.m0 PrintWriter printWriter, @c.m0 String[] strArr) {
    }

    @c1.a
    @c.m0
    public Activity b() {
        Activity activityM = this.f15136a.m();
        com.google.android.gms.common.internal.u.k(activityM);
        return activityM;
    }

    @c1.a
    @c.j0
    public void f(int i7, int i8, @c.m0 Intent intent) {
    }

    @c1.a
    @c.j0
    public void g(@c.o0 Bundle bundle) {
    }

    @c1.a
    @c.j0
    public void h() {
    }

    @c1.a
    @c.j0
    public void i() {
    }

    @c1.a
    @c.j0
    public void j(@c.m0 Bundle bundle) {
    }

    @c1.a
    @c.j0
    public void k() {
    }

    @c1.a
    @c.j0
    public void l() {
    }
}
