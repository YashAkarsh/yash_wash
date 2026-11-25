package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.t0(21)
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class r2 extends z3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5858d = "TypefaceCompatApi21Impl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5859e = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5860f = "addFontWeightStyle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5861g = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Class<?> f5862h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Constructor<?> f5863i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Method f5864j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Method f5865k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f5866l = false;

    r2() {
    }

    private static boolean k(Object obj, String str, int i7, boolean z7) {
        n();
        try {
            return ((Boolean) f5864j.invoke(obj, str, Integer.valueOf(i7), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static Typeface l(Object obj) {
        n();
        try {
            Object objNewInstance = Array.newInstance(f5862h, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f5865k.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private File m(@c.m0 ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f5866l) {
            return;
        }
        f5866l = true;
        try {
            cls = Class.forName(f5859e);
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod(f5860f, String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod(f5861g, Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e(f5858d, e8.getClass().getName(), e8);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f5863i = constructor;
        f5862h = cls;
        f5864j = method2;
        f5865k = method;
    }

    private static Object o() {
        n();
        try {
            return f5863i.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // androidx.core.graphics.z3
    public Typeface b(Context context, androidx.core.content.res.f.d dVar, Resources resources, int i7) {
        Object objO = o();
        for (androidx.core.content.res.f.e eVar : dVar.a()) {
            File fileE = a4.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!a4.c(fileE, resources, eVar.b())) {
                    return null;
                }
                if (!k(objO, fileE.getPath(), eVar.e(), eVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return l(objO);
    }

    @Override // androidx.core.graphics.z3
    public Typeface c(Context context, CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) {
        if (cVarArr.length < 1) {
            return null;
        }
        androidx.core.provider.j.c cVarH = h(cVarArr, i7);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(cVarH.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileM = m(parcelFileDescriptorOpenFileDescriptor);
                if (fileM != null && fileM.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceD;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
