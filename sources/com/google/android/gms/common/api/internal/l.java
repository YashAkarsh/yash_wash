package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f15319a;

    public l(@c.m0 Activity activity) {
        com.google.android.gms.common.internal.u.l(activity, "Activity must not be null");
        this.f15319a = activity;
    }

    @c.m0
    public final Activity a() {
        return (Activity) this.f15319a;
    }

    @c.m0
    public final FragmentActivity b() {
        return (FragmentActivity) this.f15319a;
    }

    public final boolean c() {
        return this.f15319a instanceof Activity;
    }

    public final boolean d() {
        return this.f15319a instanceof FragmentActivity;
    }

    @c1.a
    public l(@c.m0 ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
