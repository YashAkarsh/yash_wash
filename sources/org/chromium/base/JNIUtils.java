package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
public class JNIUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f38675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ClassLoader f38676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38677c = false;

    public static void a() {
        f38675a = Boolean.TRUE;
    }

    public static void b(ClassLoader classLoader) {
        f38676b = classLoader;
    }

    @CalledByNative
    public static Object getClassLoader() {
        ClassLoader classLoader = f38676b;
        return classLoader == null ? JNIUtils.class.getClassLoader() : classLoader;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (f38675a == null) {
            f38675a = Boolean.FALSE;
        }
        return f38675a.booleanValue();
    }
}
