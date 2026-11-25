package com.google.gson.internal.reflect;

import com.google.gson.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Class f23241d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23242b = d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Field f23243c = c();

    c() {
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f23241d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.internal.reflect.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e8) {
            throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e8);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f23242b != null && this.f23243c != null) {
            try {
                f23241d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f23242b, accessibleObject, Long.valueOf(((Long) f23241d.getMethod("objectFieldOffset", Field.class).invoke(this.f23242b, this.f23243c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
