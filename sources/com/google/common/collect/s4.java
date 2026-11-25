package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
class s4 extends e9<Object, Object> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final s4 f21039m = new s4();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f21040n = 0;

    private s4() {
        super(v7.y(), 0, null);
    }

    private Object readResolve() {
        return f21039m;
    }
}
