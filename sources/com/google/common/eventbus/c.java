package com.google.common.eventbus;

import androidx.core.app.l2;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.e0;
import com.google.common.base.x;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f21544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21545b;

    public c(Object obj, Object obj2) {
        this.f21544a = e0.E(obj);
        this.f21545b = e0.E(obj2);
    }

    public Object a() {
        return this.f21545b;
    }

    public Object b() {
        return this.f21544a;
    }

    public String toString() {
        return x.c(this).f(ShareConstants.FEED_SOURCE_PARAM, this.f21544a).f(l2.f5216t0, this.f21545b).toString();
    }
}
