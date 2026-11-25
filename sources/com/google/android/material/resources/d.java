package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.i;
import androidx.core.view.n2;
import c.b1;
import c.g1;
import c.m0;
import c.o0;
import c.w;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f18134r = "TextAppearance";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f18135s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f18136t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f18137u = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    public final ColorStateList f18138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    public final ColorStateList f18139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    public final ColorStateList f18140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    public final ColorStateList f18141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    public final String f18142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f18146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f18147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f18148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f18149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f18150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f18151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @w
    private final int f18152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18153p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f18154q;

    class a extends i.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f18155a;

        a(f fVar) {
            this.f18155a = fVar;
        }

        @Override // androidx.core.content.res.i.g
        /* JADX INFO: renamed from: h */
        public void f(int i7) {
            d.this.f18153p = true;
            this.f18155a.a(i7);
        }

        @Override // androidx.core.content.res.i.g
        /* JADX INFO: renamed from: i */
        public void g(@m0 Typeface typeface) {
            d dVar = d.this;
            dVar.f18154q = Typeface.create(typeface, dVar.f18143f);
            d.this.f18153p = true;
            this.f18155a.b(d.this.f18154q, false);
        }
    }

    class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextPaint f18157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f18158b;

        b(TextPaint textPaint, f fVar) {
            this.f18157a = textPaint;
            this.f18158b = fVar;
        }

        @Override // com.google.android.material.resources.f
        public void a(int i7) {
            this.f18158b.a(i7);
        }

        @Override // com.google.android.material.resources.f
        public void b(@m0 Typeface typeface, boolean z7) {
            d.this.l(this.f18157a, typeface);
            this.f18158b.b(typeface, z7);
        }
    }

    public d(@m0 Context context, @b1 int i7) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, R.styleable.TextAppearance);
        this.f18151n = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f18138a = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f18139b = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f18140c = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f18143f = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f18144g = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int iE = c.e(typedArrayObtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f18152o = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f18142e = typedArrayObtainStyledAttributes.getString(iE);
        this.f18145h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f18141d = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f18146i = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f18147j = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f18148k = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i7, R.styleable.MaterialTextAppearance);
        this.f18149l = typedArrayObtainStyledAttributes2.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.f18150m = typedArrayObtainStyledAttributes2.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f18154q == null && (str = this.f18142e) != null) {
            this.f18154q = Typeface.create(str, this.f18143f);
        }
        if (this.f18154q == null) {
            int i7 = this.f18144g;
            if (i7 == 1) {
                this.f18154q = Typeface.SANS_SERIF;
            } else if (i7 == 2) {
                this.f18154q = Typeface.SERIF;
            } else if (i7 != 3) {
                this.f18154q = Typeface.DEFAULT;
            } else {
                this.f18154q = Typeface.MONOSPACE;
            }
            this.f18154q = Typeface.create(this.f18154q, this.f18143f);
        }
    }

    private boolean i(Context context) {
        if (e.b()) {
            return true;
        }
        int i7 = this.f18152o;
        return (i7 != 0 ? i.d(context, i7) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f18154q;
    }

    @m0
    @g1
    public Typeface f(@m0 Context context) {
        if (this.f18153p) {
            return this.f18154q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = i.j(context, this.f18152o);
                this.f18154q = typefaceJ;
                if (typefaceJ != null) {
                    this.f18154q = Typeface.create(typefaceJ, this.f18143f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e8) {
                Log.d(f18134r, "Error loading font " + this.f18142e, e8);
            }
        }
        d();
        this.f18153p = true;
        return this.f18154q;
    }

    public void g(@m0 Context context, @m0 TextPaint textPaint, @m0 f fVar) {
        l(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(@m0 Context context, @m0 f fVar) {
        if (i(context)) {
            f(context);
        } else {
            d();
        }
        int i7 = this.f18152o;
        if (i7 == 0) {
            this.f18153p = true;
        }
        if (this.f18153p) {
            fVar.b(this.f18154q, true);
            return;
        }
        try {
            i.l(context, i7, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f18153p = true;
            fVar.a(1);
        } catch (Exception e8) {
            Log.d(f18134r, "Error loading font " + this.f18142e, e8);
            this.f18153p = true;
            fVar.a(-3);
        }
    }

    public void j(@m0 Context context, @m0 TextPaint textPaint, @m0 f fVar) {
        k(context, textPaint, fVar);
        ColorStateList colorStateList = this.f18138a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : n2.f6743t);
        float f8 = this.f18148k;
        float f9 = this.f18146i;
        float f10 = this.f18147j;
        ColorStateList colorStateList2 = this.f18141d;
        textPaint.setShadowLayer(f8, f9, f10, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void k(@m0 Context context, @m0 TextPaint textPaint, @m0 f fVar) {
        if (i(context)) {
            l(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void l(@m0 TextPaint textPaint, @m0 Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i7 = (~typeface.getStyle()) & this.f18143f;
        textPaint.setFakeBoldText((i7 & 1) != 0);
        textPaint.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f18151n);
        if (this.f18149l) {
            textPaint.setLetterSpacing(this.f18150m);
        }
    }
}
