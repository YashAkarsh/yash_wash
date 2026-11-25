package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.a
@s1.b
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s0 f19540a = new a();

    static class a extends s0 {
        a() {
        }

        @Override // com.google.common.base.s0
        public long a() {
            return d0.k();
        }
    }

    protected s0() {
    }

    public static s0 b() {
        return f19540a;
    }

    @u1.a
    public abstract long a();
}
