package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
class r4 extends q7<Object, Object> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final r4 f20998k = new r4();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f20999l = 0;

    private r4() {
        super(v7.y(), 0);
    }

    private Object readResolve() {
        return f20998k;
    }
}
