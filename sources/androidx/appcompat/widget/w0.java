package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public final class w0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f2004h = "ResourceManagerInternal";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f2005i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f2007k = "appcompat_skip_skip";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f2008l = "android.graphics.drawable.VectorDrawable";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static w0 f2009m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, androidx.collection.j<ColorStateList>> f2011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.collection.i<String, e> f2012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.collection.j<String> f2013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, androidx.collection.f<WeakReference<Drawable.ConstantState>>> f2014d = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f2015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f2017g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final PorterDuff.Mode f2006j = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final c f2010n = new c(6);

    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.w0.e
        public Drawable a(@c.m0 Context context, @c.m0 XmlPullParser xmlPullParser, @c.m0 AttributeSet attributeSet, @c.o0 Resources.Theme theme) {
            try {
                return androidx.appcompat.graphics.drawable.a.C(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e8);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.w0.e
        public Drawable a(@c.m0 Context context, @c.m0 XmlPullParser xmlPullParser, @c.m0 AttributeSet attributeSet, @c.o0 Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.c.f(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e8);
                return null;
            }
        }
    }

    private static class c extends androidx.collection.g<Integer, PorterDuffColorFilter> {
        public c(int i7) {
            super(i7);
        }

        private static int u(int i7, PorterDuff.Mode mode) {
            return ((i7 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter v(int i7, PorterDuff.Mode mode) {
            return h(Integer.valueOf(u(i7, mode)));
        }

        PorterDuffColorFilter w(int i7, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return l(Integer.valueOf(u(i7, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.w0.e
        public Drawable a(@c.m0 Context context, @c.m0 XmlPullParser xmlPullParser, @c.m0 AttributeSet attributeSet, @c.o0 Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    f.a.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e8) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e8);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(@c.m0 Context context, @c.m0 XmlPullParser xmlPullParser, @c.m0 AttributeSet attributeSet, @c.o0 Resources.Theme theme);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public interface f {
        boolean a(@c.m0 Context context, @c.u int i7, @c.m0 Drawable drawable);

        @c.o0
        PorterDuff.Mode b(int i7);

        @c.o0
        Drawable c(@c.m0 w0 w0Var, @c.m0 Context context, @c.u int i7);

        @c.o0
        ColorStateList d(@c.m0 Context context, @c.u int i7);

        boolean e(@c.m0 Context context, @c.u int i7, @c.m0 Drawable drawable);
    }

    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.w0.e
        public Drawable a(@c.m0 Context context, @c.m0 XmlPullParser xmlPullParser, @c.m0 AttributeSet attributeSet, @c.o0 Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.i.f(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e8);
                return null;
            }
        }
    }

    private void a(@c.m0 String str, @c.m0 e eVar) {
        if (this.f2012b == null) {
            this.f2012b = new androidx.collection.i<>();
        }
        this.f2012b.put(str, eVar);
    }

    private synchronized boolean b(@c.m0 Context context, long j7, @c.m0 Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.f<WeakReference<Drawable.ConstantState>> fVar = this.f2014d.get(context);
        if (fVar == null) {
            fVar = new androidx.collection.f<>();
            this.f2014d.put(context, fVar);
        }
        fVar.s(j7, new WeakReference<>(constantState));
        return true;
    }

    private void c(@c.m0 Context context, @c.u int i7, @c.m0 ColorStateList colorStateList) {
        if (this.f2011a == null) {
            this.f2011a = new WeakHashMap<>();
        }
        androidx.collection.j<ColorStateList> jVar = this.f2011a.get(context);
        if (jVar == null) {
            jVar = new androidx.collection.j<>();
            this.f2011a.put(context, jVar);
        }
        jVar.a(i7, colorStateList);
    }

    private void d(@c.m0 Context context) {
        if (this.f2016f) {
            return;
        }
        this.f2016f = true;
        Drawable drawableJ = j(context, R.drawable.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f2016f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(@c.m0 Context context, @c.u int i7) {
        if (this.f2015e == null) {
            this.f2015e = new TypedValue();
        }
        TypedValue typedValue = this.f2015e;
        context.getResources().getValue(i7, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f2017g;
        Drawable drawableC = fVar == null ? null : fVar.c(this, context, i7);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableC);
        }
        return drawableC;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized w0 h() {
        if (f2009m == null) {
            w0 w0Var = new w0();
            f2009m = w0Var;
            p(w0Var);
        }
        return f2009m;
    }

    private synchronized Drawable i(@c.m0 Context context, long j7) {
        androidx.collection.f<WeakReference<Drawable.ConstantState>> fVar = this.f2014d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceM = fVar.m(j7);
        if (weakReferenceM != null) {
            Drawable.ConstantState constantState = weakReferenceM.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.v(j7);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i7, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterV;
        c cVar = f2010n;
        porterDuffColorFilterV = cVar.v(i7, mode);
        if (porterDuffColorFilterV == null) {
            porterDuffColorFilterV = new PorterDuffColorFilter(i7, mode);
            cVar.w(i7, mode, porterDuffColorFilterV);
        }
        return porterDuffColorFilterV;
    }

    private ColorStateList n(@c.m0 Context context, @c.u int i7) {
        androidx.collection.j<ColorStateList> jVar;
        WeakHashMap<Context, androidx.collection.j<ColorStateList>> weakHashMap = this.f2011a;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.m(i7);
    }

    private static void p(@c.m0 w0 w0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            w0Var.a("vector", new g());
            w0Var.a("animated-vector", new b());
            w0Var.a("animated-selector", new a());
            w0Var.a("drawable", new d());
        }
    }

    private static boolean q(@c.m0 Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.i) || f2008l.equals(drawable.getClass().getName());
    }

    private Drawable r(@c.m0 Context context, @c.u int i7) {
        int next;
        androidx.collection.i<String, e> iVar = this.f2012b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        androidx.collection.j<String> jVar = this.f2013c;
        if (jVar != null) {
            String strM = jVar.m(i7);
            if (f2007k.equals(strM) || (strM != null && this.f2012b.get(strM) == null)) {
                return null;
            }
        } else {
            this.f2013c = new androidx.collection.j<>();
        }
        if (this.f2015e == null) {
            this.f2015e = new TypedValue();
        }
        TypedValue typedValue = this.f2015e;
        Resources resources = context.getResources();
        resources.getValue(i7, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i7);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2013c.a(i7, name);
                e eVar = this.f2012b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e8) {
                Log.e(f2004h, "Exception while inflating drawable", e8);
            }
        }
        if (drawableI == null) {
            this.f2013c.a(i7, f2007k);
        }
        return drawableI;
    }

    private Drawable v(@c.m0 Context context, @c.u int i7, boolean z7, @c.m0 Drawable drawable) {
        ColorStateList colorStateListM = m(context, i7);
        if (colorStateListM == null) {
            f fVar = this.f2017g;
            if ((fVar == null || !fVar.e(context, i7, drawable)) && !x(context, i7, drawable) && z7) {
                return null;
            }
            return drawable;
        }
        if (k0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = androidx.core.graphics.drawable.d.r(drawable);
        androidx.core.graphics.drawable.d.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i7);
        if (modeO == null) {
            return drawableR;
        }
        androidx.core.graphics.drawable.d.p(drawableR, modeO);
        return drawableR;
    }

    static void w(Drawable drawable, f1 f1Var, int[] iArr) {
        int[] state = drawable.getState();
        if (k0.a(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                Log.d(f2004h, "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z7 = f1Var.f1832d;
        if (z7 || f1Var.f1831c) {
            drawable.setColorFilter(g(z7 ? f1Var.f1829a : null, f1Var.f1831c ? f1Var.f1830b : f2006j, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(@c.m0 Context context, @c.u int i7) {
        return k(context, i7, false);
    }

    synchronized Drawable k(@c.m0 Context context, @c.u int i7, boolean z7) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i7);
        if (drawableR == null) {
            drawableR = f(context, i7);
        }
        if (drawableR == null) {
            drawableR = androidx.core.content.d.i(context, i7);
        }
        if (drawableR != null) {
            drawableR = v(context, i7, z7, drawableR);
        }
        if (drawableR != null) {
            k0.b(drawableR);
        }
        return drawableR;
    }

    synchronized ColorStateList m(@c.m0 Context context, @c.u int i7) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i7);
        if (colorStateListN == null) {
            f fVar = this.f2017g;
            colorStateListN = fVar == null ? null : fVar.d(context, i7);
            if (colorStateListN != null) {
                c(context, i7, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i7) {
        f fVar = this.f2017g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i7);
    }

    public synchronized void s(@c.m0 Context context) {
        androidx.collection.f<WeakReference<Drawable.ConstantState>> fVar = this.f2014d.get(context);
        if (fVar != null) {
            fVar.e();
        }
    }

    synchronized Drawable t(@c.m0 Context context, @c.m0 q1 q1Var, @c.u int i7) {
        Drawable drawableR = r(context, i7);
        if (drawableR == null) {
            drawableR = q1Var.a(i7);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i7, false, drawableR);
    }

    public synchronized void u(f fVar) {
        this.f2017g = fVar;
    }

    boolean x(@c.m0 Context context, @c.u int i7, @c.m0 Drawable drawable) {
        f fVar = this.f2017g;
        return fVar != null && fVar.a(context, i7, drawable);
    }
}
