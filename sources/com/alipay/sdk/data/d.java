package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
class d implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f13702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HashMap f13703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f13704c;

    d(c cVar, Context context, HashMap map) {
        this.f13704c = cVar;
        this.f13702a = context;
        this.f13703b = map;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Exception {
        return this.f13704c.c(this.f13702a, this.f13703b);
    }
}
