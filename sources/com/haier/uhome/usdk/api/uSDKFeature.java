package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKFeature {
    NONE,
    DEFAULT,
    TRACE,
    TRACE_DNS,
    TRACE_NET_SITUATION,
    SAFE_DNS;

    public final int mask = 1 << ordinal();

    uSDKFeature() {
    }
}
