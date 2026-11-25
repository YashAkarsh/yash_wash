package com.google.common.escape;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<char[]> f21542a = new a();

    static class a extends ThreadLocal<char[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    private h() {
    }

    static char[] a() {
        return f21542a.get();
    }
}
