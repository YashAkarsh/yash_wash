package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.n2;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f1969n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f1970o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f1971p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f1972q = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final TextView f1973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f1 f1974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f1 f1975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f1 f1976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f1 f1977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f1 f1978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f1 f1979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f1 f1980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.m0
    private final b0 f1981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1982j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1983k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Typeface f1984l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1985m;

    class a extends androidx.core.content.res.i.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f1988c;

        a(int i7, int i8, WeakReference weakReference) {
            this.f1986a = i7;
            this.f1987b = i8;
            this.f1988c = weakReference;
        }

        @Override // androidx.core.content.res.i.g
        /* JADX INFO: renamed from: h */
        public void f(int i7) {
        }

        @Override // androidx.core.content.res.i.g
        /* JADX INFO: renamed from: i */
        public void g(@c.m0 Typeface typeface) {
            int i7;
            if (Build.VERSION.SDK_INT >= 28 && (i7 = this.f1986a) != -1) {
                typeface = g.a(typeface, i7, (this.f1987b & 2) != 0);
            }
            t.this.n(this.f1988c, typeface);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f1990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f1991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1992c;

        b(TextView textView, Typeface typeface, int i7) {
            this.f1990a = textView;
            this.f1991b = typeface;
            this.f1992c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1990a.setTypeface(this.f1991b, this.f1992c);
        }
    }

    @c.t0(17)
    static class c {
        private c() {
        }

        @c.t
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @c.t
        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @c.t
        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    @c.t0(21)
    static class d {
        private d() {
        }

        @c.t
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @c.t0(24)
    static class e {
        private e() {
        }

        @c.t
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @c.t
        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @c.t0(26)
    static class f {
        private f() {
        }

        @c.t
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @c.t
        static void b(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        @c.t
        static void c(TextView textView, int[] iArr, int i7) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        @c.t
        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @c.t0(28)
    static class g {
        private g() {
        }

        @c.t
        static Typeface a(Typeface typeface, int i7, boolean z7) {
            return Typeface.create(typeface, i7, z7);
        }
    }

    t(@c.m0 TextView textView) {
        this.f1973a = textView;
        this.f1981i = new b0(textView);
    }

    private void B(int i7, float f8) {
        this.f1981i.w(i7, f8);
    }

    private void C(Context context, h1 h1Var) {
        String strW;
        this.f1982j = h1Var.o(R.styleable.TextAppearance_android_textStyle, this.f1982j);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            int iO = h1Var.o(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f1983k = iO;
            if (iO != -1) {
                this.f1982j = (this.f1982j & 2) | 0;
            }
        }
        if (!h1Var.C(R.styleable.TextAppearance_android_fontFamily) && !h1Var.C(R.styleable.TextAppearance_fontFamily)) {
            if (h1Var.C(R.styleable.TextAppearance_android_typeface)) {
                this.f1985m = false;
                int iO2 = h1Var.o(R.styleable.TextAppearance_android_typeface, 1);
                if (iO2 == 1) {
                    this.f1984l = Typeface.SANS_SERIF;
                    return;
                } else if (iO2 == 2) {
                    this.f1984l = Typeface.SERIF;
                    return;
                } else {
                    if (iO2 != 3) {
                        return;
                    }
                    this.f1984l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1984l = null;
        int i8 = h1Var.C(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        int i9 = this.f1983k;
        int i10 = this.f1982j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceK = h1Var.k(i8, this.f1982j, new a(i9, i10, new WeakReference(this.f1973a)));
                if (typefaceK != null) {
                    if (i7 < 28 || this.f1983k == -1) {
                        this.f1984l = typefaceK;
                    } else {
                        this.f1984l = g.a(Typeface.create(typefaceK, 0), this.f1983k, (this.f1982j & 2) != 0);
                    }
                }
                this.f1985m = this.f1984l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1984l != null || (strW = h1Var.w(i8)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1983k == -1) {
            this.f1984l = Typeface.create(strW, this.f1982j);
        } else {
            this.f1984l = g.a(Typeface.create(strW, 0), this.f1983k, (this.f1982j & 2) != 0);
        }
    }

    private void a(Drawable drawable, f1 f1Var) {
        if (drawable == null || f1Var == null) {
            return;
        }
        androidx.appcompat.widget.g.j(drawable, f1Var, this.f1973a.getDrawableState());
    }

    private static f1 d(Context context, androidx.appcompat.widget.g gVar, int i7) {
        ColorStateList colorStateListF = gVar.f(context, i7);
        if (colorStateListF == null) {
            return null;
        }
        f1 f1Var = new f1();
        f1Var.f1832d = true;
        f1Var.f1829a = colorStateListF;
        return f1Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f1973a);
            TextView textView = this.f1973a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f1973a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f1973a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1973a.getCompoundDrawables();
        TextView textView3 = this.f1973a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        f1 f1Var = this.f1980h;
        this.f1974b = f1Var;
        this.f1975c = f1Var;
        this.f1976d = f1Var;
        this.f1977e = f1Var;
        this.f1978f = f1Var;
        this.f1979g = f1Var;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void A(int i7, float f8) {
        if (androidx.core.widget.b.f7024a0 || l()) {
            return;
        }
        B(i7, f8);
    }

    void b() {
        if (this.f1974b != null || this.f1975c != null || this.f1976d != null || this.f1977e != null) {
            Drawable[] compoundDrawables = this.f1973a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1974b);
            a(compoundDrawables[1], this.f1975c);
            a(compoundDrawables[2], this.f1976d);
            a(compoundDrawables[3], this.f1977e);
        }
        if (this.f1978f == null && this.f1979g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f1973a);
        a(drawableArrA[0], this.f1978f);
        a(drawableArrA[2], this.f1979g);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void c() {
        this.f1981i.b();
    }

    int e() {
        return this.f1981i.h();
    }

    int f() {
        return this.f1981i.i();
    }

    int g() {
        return this.f1981i.j();
    }

    int[] h() {
        return this.f1981i.k();
    }

    int i() {
        return this.f1981i.l();
    }

    @c.o0
    ColorStateList j() {
        f1 f1Var = this.f1980h;
        if (f1Var != null) {
            return f1Var.f1829a;
        }
        return null;
    }

    @c.o0
    PorterDuff.Mode k() {
        f1 f1Var = this.f1980h;
        if (f1Var != null) {
            return f1Var.f1830b;
        }
        return null;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    boolean l() {
        return this.f1981i.q();
    }

    @SuppressLint({"NewApi"})
    void m(@c.o0 AttributeSet attributeSet, int i7) {
        boolean zA;
        boolean z7;
        String strW;
        String strW2;
        boolean z8;
        Context context = this.f1973a.getContext();
        androidx.appcompat.widget.g gVarB = androidx.appcompat.widget.g.b();
        h1 h1VarG = h1.G(context, attributeSet, R.styleable.AppCompatTextHelper, i7, 0);
        TextView textView = this.f1973a;
        n2.z1(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, h1VarG.B(), i7, 0);
        int iU = h1VarG.u(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1974b = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1975c = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1976d = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f1977e = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f1978f = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (h1VarG.C(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f1979g = d(context, gVarB, h1VarG.u(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        h1VarG.I();
        boolean z9 = this.f1973a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iU != -1) {
            h1 h1VarE = h1.E(context, iU, R.styleable.TextAppearance);
            if (z9 || !h1VarE.C(R.styleable.TextAppearance_textAllCaps)) {
                zA = false;
                z7 = false;
            } else {
                zA = h1VarE.a(R.styleable.TextAppearance_textAllCaps, false);
                z7 = true;
            }
            C(context, h1VarE);
            strW2 = h1VarE.C(R.styleable.TextAppearance_textLocale) ? h1VarE.w(R.styleable.TextAppearance_textLocale) : null;
            strW = (i8 < 26 || !h1VarE.C(R.styleable.TextAppearance_fontVariationSettings)) ? null : h1VarE.w(R.styleable.TextAppearance_fontVariationSettings);
            h1VarE.I();
        } else {
            zA = false;
            z7 = false;
            strW = null;
            strW2 = null;
        }
        h1 h1VarG2 = h1.G(context, attributeSet, R.styleable.TextAppearance, i7, 0);
        if (z9 || !h1VarG2.C(R.styleable.TextAppearance_textAllCaps)) {
            z8 = z7;
        } else {
            zA = h1VarG2.a(R.styleable.TextAppearance_textAllCaps, false);
            z8 = true;
        }
        if (h1VarG2.C(R.styleable.TextAppearance_textLocale)) {
            strW2 = h1VarG2.w(R.styleable.TextAppearance_textLocale);
        }
        if (i8 >= 26 && h1VarG2.C(R.styleable.TextAppearance_fontVariationSettings)) {
            strW = h1VarG2.w(R.styleable.TextAppearance_fontVariationSettings);
        }
        if (i8 >= 28 && h1VarG2.C(R.styleable.TextAppearance_android_textSize) && h1VarG2.g(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1973a.setTextSize(0, 0.0f);
        }
        C(context, h1VarG2);
        h1VarG2.I();
        if (!z9 && z8) {
            s(zA);
        }
        Typeface typeface = this.f1984l;
        if (typeface != null) {
            if (this.f1983k == -1) {
                this.f1973a.setTypeface(typeface, this.f1982j);
            } else {
                this.f1973a.setTypeface(typeface);
            }
        }
        if (strW != null) {
            f.d(this.f1973a, strW);
        }
        if (strW2 != null) {
            if (i8 >= 24) {
                e.b(this.f1973a, e.a(strW2));
            } else {
                c.c(this.f1973a, d.a(strW2.split(",")[0]));
            }
        }
        this.f1981i.r(attributeSet, i7);
        if (androidx.core.widget.b.f7024a0 && this.f1981i.l() != 0) {
            int[] iArrK = this.f1981i.k();
            if (iArrK.length > 0) {
                if (f.a(this.f1973a) != -1.0f) {
                    f.b(this.f1973a, this.f1981i.i(), this.f1981i.h(), this.f1981i.j(), 0);
                } else {
                    f.c(this.f1973a, iArrK, 0);
                }
            }
        }
        h1 h1VarF = h1.F(context, attributeSet, R.styleable.AppCompatTextView);
        int iU2 = h1VarF.u(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableC = iU2 != -1 ? gVarB.c(context, iU2) : null;
        int iU3 = h1VarF.u(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iU3 != -1 ? gVarB.c(context, iU3) : null;
        int iU4 = h1VarF.u(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iU4 != -1 ? gVarB.c(context, iU4) : null;
        int iU5 = h1VarF.u(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iU5 != -1 ? gVarB.c(context, iU5) : null;
        int iU6 = h1VarF.u(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iU6 != -1 ? gVarB.c(context, iU6) : null;
        int iU7 = h1VarF.u(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iU7 != -1 ? gVarB.c(context, iU7) : null);
        if (h1VarF.C(R.styleable.AppCompatTextView_drawableTint)) {
            androidx.core.widget.u.u(this.f1973a, h1VarF.d(R.styleable.AppCompatTextView_drawableTint));
        }
        if (h1VarF.C(R.styleable.AppCompatTextView_drawableTintMode)) {
            androidx.core.widget.u.v(this.f1973a, k0.e(h1VarF.o(R.styleable.AppCompatTextView_drawableTintMode, -1), null));
        }
        int iG = h1VarF.g(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int iG2 = h1VarF.g(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int iG3 = h1VarF.g(R.styleable.AppCompatTextView_lineHeight, -1);
        h1VarF.I();
        if (iG != -1) {
            androidx.core.widget.u.A(this.f1973a, iG);
        }
        if (iG2 != -1) {
            androidx.core.widget.u.B(this.f1973a, iG2);
        }
        if (iG3 != -1) {
            androidx.core.widget.u.C(this.f1973a, iG3);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1985m) {
            this.f1984l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (n2.O0(textView)) {
                    textView.post(new b(textView, typeface, this.f1982j));
                } else {
                    textView.setTypeface(typeface, this.f1982j);
                }
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void o(boolean z7, int i7, int i8, int i9, int i10) {
        if (androidx.core.widget.b.f7024a0) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i7) {
        String strW;
        h1 h1VarE = h1.E(context, i7, R.styleable.TextAppearance);
        if (h1VarE.C(R.styleable.TextAppearance_textAllCaps)) {
            s(h1VarE.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (h1VarE.C(R.styleable.TextAppearance_android_textSize) && h1VarE.g(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1973a.setTextSize(0, 0.0f);
        }
        C(context, h1VarE);
        if (i8 >= 26 && h1VarE.C(R.styleable.TextAppearance_fontVariationSettings) && (strW = h1VarE.w(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            f.d(this.f1973a, strW);
        }
        h1VarE.I();
        Typeface typeface = this.f1984l;
        if (typeface != null) {
            this.f1973a.setTypeface(typeface, this.f1982j);
        }
    }

    void r(@c.m0 TextView textView, @c.o0 InputConnection inputConnection, @c.m0 EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        androidx.core.view.inputmethod.g.j(editorInfo, textView.getText());
    }

    void s(boolean z7) {
        this.f1973a.setAllCaps(z7);
    }

    void t(int i7, int i8, int i9, int i10) throws IllegalArgumentException {
        this.f1981i.s(i7, i8, i9, i10);
    }

    void u(@c.m0 int[] iArr, int i7) throws IllegalArgumentException {
        this.f1981i.t(iArr, i7);
    }

    void v(int i7) {
        this.f1981i.u(i7);
    }

    void w(@c.o0 ColorStateList colorStateList) {
        if (this.f1980h == null) {
            this.f1980h = new f1();
        }
        f1 f1Var = this.f1980h;
        f1Var.f1829a = colorStateList;
        f1Var.f1832d = colorStateList != null;
        z();
    }

    void x(@c.o0 PorterDuff.Mode mode) {
        if (this.f1980h == null) {
            this.f1980h = new f1();
        }
        f1 f1Var = this.f1980h;
        f1Var.f1830b = mode;
        f1Var.f1831c = mode != null;
        z();
    }
}
