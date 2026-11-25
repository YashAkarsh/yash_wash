package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.t0(24)
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class s2 extends z3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5893d = "TypefaceCompatApi24Impl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5894e = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5895f = "addFontWeightStyle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5896g = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Class<?> f5897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Constructor<?> f5898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Method f5899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Method f5900k;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName(f5894e);
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod(f5895f, ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod(f5896g, Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e(f5893d, e8.getClass().getName(), e8);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f5898i = constructor;
        f5897h = cls;
        f5899j = method2;
        f5900k = method;
    }

    s2() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i7, int i8, boolean z7) {
        try {
            return ((Boolean) f5899j.invoke(obj, byteBuffer, Integer.valueOf(i7), null, Integer.valueOf(i8), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f5897h, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f5900k.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f5899j;
        if (method == null) {
            Log.w(f5893d, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f5898i.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface b(Context context, androidx.core.content.res.f.d dVar, Resources resources, int i7) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (androidx.core.content.res.f.e eVar : dVar.a()) {
            ByteBuffer byteBufferB = a4.b(context, resources, eVar.b());
            if (byteBufferB == null || !k(objN, byteBufferB, eVar.c(), eVar.e(), eVar.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface c(Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        androidx.collection.i iVar = new androidx.collection.i();
        for (androidx.core.provider.j.c cVar : cVarArr) {
            Uri uriD = cVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) iVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = a4.f(context, cancellationSignal, uriD);
                iVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i7);
    }
}
