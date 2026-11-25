package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.q2;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.u;
import c.w;
import c.x0;
import c.z;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5735a = "ResourcesCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f5736b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @z("sColorStateCacheLock")
    private static final WeakHashMap<f, SparseArray<e>> f5737c = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f5738d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.c
    public static final int f5739e = 0;

    @t0(15)
    static class a {
        private a() {
        }

        @t
        static Drawable a(Resources resources, int i7, int i8) {
            return resources.getDrawableForDensity(i7, i8);
        }
    }

    @t0(21)
    static class b {
        private b() {
        }

        @t
        static Drawable a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getDrawable(i7, theme);
        }

        @t
        static Drawable b(Resources resources, int i7, int i8, Resources.Theme theme) {
            return resources.getDrawableForDensity(i7, i8, theme);
        }
    }

    @t0(23)
    static class c {
        private c() {
        }

        @t
        static int a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getColor(i7, theme);
        }

        @m0
        @t
        static ColorStateList b(@m0 Resources resources, @c.n int i7, @o0 Resources.Theme theme) {
            return resources.getColorStateList(i7, theme);
        }
    }

    @t0(29)
    static class d {
        private d() {
        }

        @t
        static float a(@m0 Resources resources, @c.p int i7) {
            return resources.getFloat(i7);
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f5740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f5741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f5742c;

        e(@m0 ColorStateList colorStateList, @m0 Configuration configuration, @o0 Resources.Theme theme) {
            this.f5740a = colorStateList;
            this.f5741b = configuration;
            this.f5742c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Resources f5743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f5744b;

        f(@m0 Resources resources, @o0 Resources.Theme theme) {
            this.f5743a = resources;
            this.f5744b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f5743a.equals(fVar.f5743a) && androidx.core.util.r.a(this.f5744b, fVar.f5744b);
        }

        public int hashCode() {
            return androidx.core.util.r.b(this.f5743a, this.f5744b);
        }
    }

    public static abstract class g {
        @x0({x0.a.LIBRARY})
        @m0
        public static Handler e(@o0 Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public final void c(final int i7, @o0 Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5750a.f(i7);
                }
            });
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public final void d(@m0 final Typeface typeface, @o0 Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5748a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i7);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(@m0 Typeface typeface);
    }

    public static final class h {

        @t0(23)
        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f5745a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f5746b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f5747c;

            private a() {
            }

            /* JADX WARN: Code duplicated, block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @SuppressLint({"BanUncheckedReflection"})
            static void a(@m0 Resources.Theme theme) {
                Method method;
                synchronized (f5745a) {
                    if (f5747c) {
                        method = f5746b;
                        if (method != null) {
                            method.invoke(theme, new Object[0]);
                        }
                    } else {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f5746b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e8) {
                            Log.i(i.f5735a, "Failed to retrieve rebase() method", e8);
                        }
                        f5747c = true;
                        method = f5746b;
                        if (method != null) {
                            try {
                                method.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e9) {
                                Log.i(i.f5735a, "Failed to invoke rebase() method via reflection", e9);
                                f5746b = null;
                            }
                        }
                    }
                    throw th;
                }
            }
        }

        @t0(29)
        static class b {
            private b() {
            }

            @t
            static void a(@m0 Resources.Theme theme) {
                theme.rebase();
            }
        }

        private h() {
        }

        public static void a(@m0 Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    private i() {
    }

    private static void a(@m0 f fVar, @c.n int i7, @m0 ColorStateList colorStateList, @o0 Resources.Theme theme) {
        synchronized (f5738d) {
            WeakHashMap<f, SparseArray<e>> weakHashMap = f5737c;
            SparseArray<e> sparseArray = weakHashMap.get(fVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(fVar, sparseArray);
            }
            sparseArray.append(i7, new e(colorStateList, fVar.f5743a.getConfiguration(), theme));
        }
    }

    public static void b(@m0 Resources.Theme theme) {
        synchronized (f5738d) {
            Iterator<f> it = f5737c.keySet().iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null && theme.equals(next.f5744b)) {
                    it.remove();
                }
            }
        }
    }

    @o0
    private static ColorStateList c(@m0 f fVar, @c.n int i7) {
        e eVar;
        Resources.Theme theme;
        synchronized (f5738d) {
            SparseArray<e> sparseArray = f5737c.get(fVar);
            if (sparseArray != null && sparseArray.size() > 0 && (eVar = sparseArray.get(i7)) != null) {
                if (eVar.f5741b.equals(fVar.f5743a.getConfiguration()) && (((theme = fVar.f5744b) == null && eVar.f5742c == 0) || (theme != null && eVar.f5742c == theme.hashCode()))) {
                    return eVar.f5740a;
                }
                sparseArray.remove(i7);
            }
            return null;
        }
    }

    @o0
    public static Typeface d(@m0 Context context, @w int i7) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i7, new TypedValue(), 0, null, null, false, true);
    }

    @c.l
    public static int e(@m0 Resources resources, @c.n int i7, @o0 Resources.Theme theme) throws Resources.NotFoundException {
        return c.a(resources, i7, theme);
    }

    @o0
    public static ColorStateList f(@m0 Resources resources, @c.n int i7, @o0 Resources.Theme theme) throws Resources.NotFoundException {
        f fVar = new f(resources, theme);
        ColorStateList colorStateListC = c(fVar, i7);
        if (colorStateListC != null) {
            return colorStateListC;
        }
        ColorStateList colorStateListN = n(resources, i7, theme);
        if (colorStateListN == null) {
            return c.b(resources, i7, theme);
        }
        a(fVar, i7, colorStateListN, theme);
        return colorStateListN;
    }

    @o0
    public static Drawable g(@m0 Resources resources, @u int i7, @o0 Resources.Theme theme) throws Resources.NotFoundException {
        return b.a(resources, i7, theme);
    }

    @o0
    public static Drawable h(@m0 Resources resources, @u int i7, int i8, @o0 Resources.Theme theme) throws Resources.NotFoundException {
        return b.b(resources, i7, i8, theme);
    }

    public static float i(@m0 Resources resources, @c.p int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            return d.a(resources, i7);
        }
        TypedValue typedValueM = m();
        resources.getValue(i7, typedValueM, true);
        if (typedValueM.type == 4) {
            return typedValueM.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i7) + " type #0x" + Integer.toHexString(typedValueM.type) + " is not valid");
    }

    @o0
    public static Typeface j(@m0 Context context, @w int i7) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i7, new TypedValue(), 0, null, null, false, false);
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static Typeface k(@m0 Context context, @w int i7, @m0 TypedValue typedValue, int i8, @o0 g gVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i7, typedValue, i8, gVar, null, true, false);
    }

    public static void l(@m0 Context context, @w int i7, @m0 g gVar, @o0 Handler handler) throws Resources.NotFoundException {
        androidx.core.util.w.l(gVar);
        if (context.isRestricted()) {
            gVar.c(-4, handler);
        } else {
            p(context, i7, new TypedValue(), 0, gVar, handler, false, false);
        }
    }

    @m0
    private static TypedValue m() {
        ThreadLocal<TypedValue> threadLocal = f5736b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @o0
    private static ColorStateList n(Resources resources, int i7, @o0 Resources.Theme theme) {
        if (o(resources, i7)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i7), theme);
        } catch (Exception e8) {
            Log.w(f5735a, "Failed to inflate ColorStateList, leaving it to the framework", e8);
            return null;
        }
    }

    private static boolean o(@m0 Resources resources, @c.n int i7) {
        TypedValue typedValueM = m();
        resources.getValue(i7, typedValueM, true);
        int i8 = typedValueM.type;
        return i8 >= 28 && i8 <= 31;
    }

    private static Typeface p(@m0 Context context, int i7, @m0 TypedValue typedValue, int i8, @o0 g gVar, @o0 Handler handler, boolean z7, boolean z8) {
        Resources resources = context.getResources();
        resources.getValue(i7, typedValue, true);
        Typeface typefaceQ = q(context, resources, typedValue, i7, i8, gVar, handler, z7, z8);
        if (typefaceQ != null || gVar != null || z8) {
            return typefaceQ;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i7) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    private static Typeface q(@m0 Context context, Resources resources, @m0 TypedValue typedValue, int i7, int i8, @o0 g gVar, @o0 Handler handler, boolean z7, boolean z8) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i7) + "\" (" + Integer.toHexString(i7) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (gVar != null) {
                gVar.c(-3, handler);
            }
            return null;
        }
        Typeface typefaceJ = q2.j(resources, i7, string, typedValue.assetCookie, i8);
        if (typefaceJ != null) {
            if (gVar != null) {
                gVar.d(typefaceJ, handler);
            }
            return typefaceJ;
        }
        if (z8) {
            return null;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceG = q2.g(context, resources, i7, string, typedValue.assetCookie, i8);
                if (gVar != null) {
                    if (typefaceG != null) {
                        gVar.d(typefaceG, handler);
                    } else {
                        gVar.c(-3, handler);
                    }
                }
                return typefaceG;
            }
            androidx.core.content.res.f.b bVarB = androidx.core.content.res.f.b(resources.getXml(i7), resources);
            if (bVarB != null) {
                return q2.e(context, bVarB, resources, i7, string, typedValue.assetCookie, i8, gVar, handler, z7);
            }
            Log.e(f5735a, "Failed to find font-family tag");
            if (gVar != null) {
                gVar.c(-3, handler);
            }
            return null;
        } catch (IOException e8) {
            Log.e(f5735a, "Failed to read xml resource " + string, e8);
            if (gVar != null) {
                gVar.c(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e9) {
            Log.e(f5735a, "Failed to parse xml resource " + string, e9);
            if (gVar != null) {
                gVar.c(-3, handler);
            }
            return null;
        }
    }
}
