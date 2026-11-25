package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class w extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f16125a;

    w(char c8) {
        this.f16125a = c8;
    }

    @Override // com.google.android.gms.internal.common.z
    public final boolean a(char c8) {
        return c8 == this.f16125a;
    }

    public final String toString() {
        int i7 = this.f16125a;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i8 = 0; i8 < 4; i8++) {
            cArr[5 - i8] = "0123456789ABCDEF".charAt(i7 & 15);
            i7 >>= 4;
        }
        String strCopyValueOf = String.copyValueOf(cArr);
        StringBuilder sb = new StringBuilder(String.valueOf(strCopyValueOf).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(strCopyValueOf);
        sb.append("')");
        return sb.toString();
    }
}
