package com.haier.library.okhttp.api;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> {
    public abstract void onError(com.haier.library.okhttp.a aVar, Exception exc);

    public abstract void onResponse(com.haier.library.okhttp.a aVar, T t7);

    public abstract T parseNetworkResponse(com.haier.library.okhttp.a aVar) throws Exception;
}
