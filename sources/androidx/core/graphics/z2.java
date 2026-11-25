package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@c.t0(26)
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class z2 extends r2 {
    private static final int A = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f5912t = "TypefaceCompatApi26Impl";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f5913u = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f5914v = "addFontFromAssetManager";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f5915w = "addFontFromBuffer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f5916x = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f5917y = "freeze";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f5918z = "abortCreation";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Class<?> f5919m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected final Constructor<?> f5920n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected final Method f5921o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected final Method f5922p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final Method f5923q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected final Method f5924r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final Method f5925s;

    public z2() {
        Class<?> clsY;
        Constructor<?> constructorZ;
        Method methodV;
        Method methodW;
        Method methodA;
        Method methodU;
        Method methodX;
        try {
            clsY = y();
            constructorZ = z(clsY);
            methodV = v(clsY);
            methodW = w(clsY);
            methodA = A(clsY);
            methodU = u(clsY);
            methodX = x(clsY);
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e(f5912t, "Unable to collect necessary methods for class " + e8.getClass().getName(), e8);
            clsY = null;
            constructorZ = null;
            methodV = null;
            methodW = null;
            methodA = null;
            methodU = null;
            methodX = null;
        }
        this.f5919m = clsY;
        this.f5920n = constructorZ;
        this.f5921o = methodV;
        this.f5922p = methodW;
        this.f5923q = methodA;
        this.f5924r = methodU;
        this.f5925s = methodX;
    }

    @c.o0
    private Object o() {
        try {
            return this.f5920n.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f5924r.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i7, int i8, int i9, @c.o0 FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f5921o.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i7, int i8, int i9) {
        try {
            return ((Boolean) this.f5922p.invoke(obj, byteBuffer, Integer.valueOf(i7), null, Integer.valueOf(i8), Integer.valueOf(i9))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f5923q.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f5921o == null) {
            Log.w(f5912t, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f5921o != null;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(f5917y, new Class[0]);
    }

    @Override // androidx.core.graphics.r2, androidx.core.graphics.z3
    @c.o0
    public Typeface b(Context context, androidx.core.content.res.f.d dVar, Resources resources, int i7) {
        if (!t()) {
            return super.b(context, dVar, resources, i7);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        for (androidx.core.content.res.f.e eVar : dVar.a()) {
            if (!q(context, objO, eVar.a(), eVar.c(), eVar.e(), eVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(eVar.d()))) {
                p(objO);
                return null;
            }
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    @Override // androidx.core.graphics.r2, androidx.core.graphics.z3
    @c.o0
    public Typeface c(Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) {
        Typeface typefaceL;
        if (cVarArr.length < 1) {
            return null;
        }
        if (!t()) {
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
                    y2.a();
                    Typeface typefaceBuild = x2.a(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(cVarH.e()).setItalic(cVarH.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = a4.h(context, cVarArr, cancellationSignal);
        Object objO = o();
        if (objO == null) {
            return null;
        }
        boolean z7 = false;
        for (androidx.core.provider.j.c cVar : cVarArr) {
            ByteBuffer byteBuffer = mapH.get(cVar.d());
            if (byteBuffer != null) {
                if (!r(objO, byteBuffer, cVar.c(), cVar.e(), cVar.f() ? 1 : 0)) {
                    p(objO);
                    return null;
                }
                z7 = true;
            }
        }
        if (!z7) {
            p(objO);
            return null;
        }
        if (s(objO) && (typefaceL = l(objO)) != null) {
            return Typeface.create(typefaceL, i7);
        }
        return null;
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface e(Context context, Resources resources, int i7, String str, int i8) {
        if (!t()) {
            return super.e(context, resources, i7, str, i8);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        if (!q(context, objO, str, 0, -1, -1, null)) {
            p(objO);
            return null;
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    @c.o0
    protected Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f5919m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f5925s.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(f5918z, new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod(f5914v, AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod(f5915w, ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(f5916x, Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName(f5913u);
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
