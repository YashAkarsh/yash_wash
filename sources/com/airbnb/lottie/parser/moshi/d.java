package com.airbnb.lottie.parser.moshi;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f12228a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f12229b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f12230c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f12231d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f12232e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f12233f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f12234g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f12235h = 8;

    private d() {
    }

    static String a(int i7, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = iArr[i8];
            if (i9 == 1 || i9 == 2) {
                sb.append('[');
                sb.append(iArr2[i8]);
                sb.append(']');
            } else if (i9 == 3 || i9 == 4 || i9 == 5) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = strArr[i8];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
