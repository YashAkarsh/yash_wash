package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.c
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Double f19429a = Double.valueOf(0.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Float f19430b = Float.valueOf(0.0f);

    private j() {
    }

    public static <T> T a(Class<T> cls) {
        e0.E(cls);
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.TYPE) {
            return (T) f19430b;
        }
        if (cls == Double.TYPE) {
            return (T) f19429a;
        }
        return null;
    }
}
