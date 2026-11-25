package com.google.android.gms.maps.internal;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static byte a(@c.o0 Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : (byte) 1;
        }
        return (byte) -1;
    }

    @c.o0
    public static Boolean b(byte b8) {
        if (b8 == 0) {
            return Boolean.FALSE;
        }
        if (b8 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
