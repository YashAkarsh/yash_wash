package com.haier.uhome.control.cloud.service;

import com.haier.uhome.usdk.base.service.BaseNative;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceNative extends BaseNative {
    public native String connect(String str, String str2, int i7, String str3, String str4);

    public native void disconnect(long j7);

    public native int subscribeResource(long j7, String str, int i7);

    public native void unsubscribeResource(long j7, String str);
}
