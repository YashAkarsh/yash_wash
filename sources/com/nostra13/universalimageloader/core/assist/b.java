package com.nostra13.universalimageloader.core.assist;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f32633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f32634b;

    public enum a {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public b(a aVar, Throwable th) {
        this.f32633a = aVar;
        this.f32634b = th;
    }

    public Throwable a() {
        return this.f32634b;
    }

    public a b() {
        return this.f32633a;
    }
}
