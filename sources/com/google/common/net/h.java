package com.google.common.net;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f22291b = "-._~!$'()*,;&=@:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f22290a = "-_.*";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.common.escape.f f22292c = new g(f22290a, true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.common.escape.f f22293d = new g("-._~!$'()*,;&=@:+", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.common.escape.f f22294e = new g("-._~!$'()*,;&=@:+/?", false);

    private h() {
    }

    public static com.google.common.escape.f a() {
        return f22292c;
    }

    public static com.google.common.escape.f b() {
        return f22294e;
    }

    public static com.google.common.escape.f c() {
        return f22293d;
    }
}
