package com.google.common.primitives;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f22349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22350b;

    private e0(String str, int i7) {
        this.f22349a = str;
        this.f22350b = i7;
    }

    static e0 a(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char cCharAt = str.charAt(0);
        int i7 = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (cCharAt == '#') {
            str = str.substring(1);
        } else if (cCharAt != '0' || str.length() <= 1) {
            i7 = 10;
        } else {
            str = str.substring(1);
            i7 = 8;
        }
        return new e0(str, i7);
    }
}
