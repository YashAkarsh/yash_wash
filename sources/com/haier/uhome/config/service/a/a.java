package com.haier.uhome.config.service.a;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public interface a<P, R, E extends ICallback<R>> {
    public static final int a_ = 1000;
    public static final int b_ = 1004;
    public static final int c_ = 2001;
    public static final int d_ = 2002;
    public static final int e_ = 2003;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f28527f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f28528g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f28529h = 4000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f28530i = 5000;

    uSDKError a();

    void a(P p7, E e8);

    void a(String str);
}
