package org.chromium.base;

import dalvik.system.BaseDexClassLoader;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public class BundleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f38635a;

    static {
        boolean z7;
        try {
            Class.forName("org.chromium.base.BundleCanary");
            z7 = true;
        } catch (ClassNotFoundException unused) {
            z7 = false;
        }
        f38635a = z7;
    }

    @CalledByNative
    private static String getNativeLibraryPath(String str) {
        m0 m0VarE = m0.e();
        try {
            String strFindLibrary = ((BaseDexClassLoader) o.e().getClassLoader()).findLibrary(str);
            if (m0VarE != null) {
                m0VarE.close();
            }
            return strFindLibrary;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m0VarE != null) {
                    try {
                        m0VarE.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @CalledByNative
    public static boolean isBundle() {
        return f38635a;
    }
}
