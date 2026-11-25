package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public interface m {
    @c1.a
    boolean c();

    @c1.a
    void h(@c.m0 String str, @c.m0 LifecycleCallback lifecycleCallback);

    @c.o0
    @c1.a
    <T extends LifecycleCallback> T l(@c.m0 String str, @c.m0 Class<T> cls);

    @c.o0
    @c1.a
    Activity m();

    @c1.a
    boolean p();

    @c1.a
    void startActivityForResult(@c.m0 Intent intent, int i7);
}
