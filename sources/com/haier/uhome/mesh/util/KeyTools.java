package com.haier.uhome.mesh.util;

/* JADX INFO: loaded from: classes2.dex */
public class KeyTools {
    public static int getElementIndex(long j7) {
        return (int) (j7 >> 32);
    }

    public static long getGlobalVendorModelId(int i7, int i8) {
        return (((long) i7) << 32) + ((long) i8);
    }

    public static int getVendorModelId(int i7, int i8) {
        return i7 | (i8 << 16);
    }

    public static long getGlobalVendorModelId(int i7, int i8, int i9) {
        return getGlobalVendorModelId(i7, getVendorModelId(i8, i9));
    }

    public static int getVendorModelId(long j7) {
        return (int) j7;
    }
}
