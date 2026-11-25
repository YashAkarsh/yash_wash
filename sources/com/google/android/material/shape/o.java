package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import c.b1;
import c.m0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f18282m = new m(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f18283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e f18284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f18285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    e f18286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f18287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d f18288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    d f18289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    d f18290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    g f18291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    g f18292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    g f18293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f18294l;

    @x0({x0.a.LIBRARY_GROUP})
    public interface c {
        @m0
        d a(@m0 d dVar);
    }

    @m0
    public static b a() {
        return new b();
    }

    @m0
    public static b b(Context context, @b1 int i7, @b1 int i8) {
        return c(context, i7, i8, 0);
    }

    @m0
    private static b c(Context context, @b1 int i7, @b1 int i8, int i9) {
        return d(context, i7, i8, new com.google.android.material.shape.a(i9));
    }

    @m0
    private static b d(Context context, @b1 int i7, @b1 int i8, @m0 d dVar) {
        if (i8 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i7);
            i7 = i8;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, R.styleable.ShapeAppearance);
        try {
            int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i9);
            int i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i9);
            int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i9);
            int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i9);
            d dVarM = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d dVarM2 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, dVarM);
            d dVarM3 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, dVarM);
            d dVarM4 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, dVarM);
            return new b().I(i10, dVarM2).N(i11, dVarM3).A(i12, dVarM4).v(i13, m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, dVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @m0
    public static b e(@m0 Context context, AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        return f(context, attributeSet, i7, i8, 0);
    }

    @m0
    public static b f(@m0 Context context, AttributeSet attributeSet, @c.f int i7, @b1 int i8, int i9) {
        return g(context, attributeSet, i7, i8, new com.google.android.material.shape.a(i9));
    }

    @m0
    public static b g(@m0 Context context, AttributeSet attributeSet, @c.f int i7, @b1 int i8, @m0 d dVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    @m0
    private static d m(TypedArray typedArray, int i7, @m0 d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i7);
        if (typedValuePeekValue == null) {
            return dVar;
        }
        int i8 = typedValuePeekValue.type;
        if (i8 == 5) {
            return new com.google.android.material.shape.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i8 == 6 ? new m(typedValuePeekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @m0
    public g h() {
        return this.f18293k;
    }

    @m0
    public e i() {
        return this.f18286d;
    }

    @m0
    public d j() {
        return this.f18290h;
    }

    @m0
    public e k() {
        return this.f18285c;
    }

    @m0
    public d l() {
        return this.f18289g;
    }

    @m0
    public g n() {
        return this.f18294l;
    }

    @m0
    public g o() {
        return this.f18292j;
    }

    @m0
    public g p() {
        return this.f18291i;
    }

    @m0
    public e q() {
        return this.f18283a;
    }

    @m0
    public d r() {
        return this.f18287e;
    }

    @m0
    public e s() {
        return this.f18284b;
    }

    @m0
    public d t() {
        return this.f18288f;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean u(@m0 RectF rectF) {
        boolean z7 = this.f18294l.getClass().equals(g.class) && this.f18292j.getClass().equals(g.class) && this.f18291i.getClass().equals(g.class) && this.f18293k.getClass().equals(g.class);
        float fA = this.f18287e.a(rectF);
        return z7 && ((this.f18288f.a(rectF) > fA ? 1 : (this.f18288f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f18290h.a(rectF) > fA ? 1 : (this.f18290h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f18289g.a(rectF) > fA ? 1 : (this.f18289g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f18284b instanceof n) && (this.f18283a instanceof n) && (this.f18285c instanceof n) && (this.f18286d instanceof n));
    }

    @m0
    public b v() {
        return new b(this);
    }

    @m0
    public o w(float f8) {
        return v().o(f8).m();
    }

    @m0
    public o x(@m0 d dVar) {
        return v().p(dVar).m();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public o y(@m0 c cVar) {
        return v().L(cVar.a(r())).Q(cVar.a(t())).y(cVar.a(j())).D(cVar.a(l())).m();
    }

    private o(@m0 b bVar) {
        this.f18283a = bVar.f18295a;
        this.f18284b = bVar.f18296b;
        this.f18285c = bVar.f18297c;
        this.f18286d = bVar.f18298d;
        this.f18287e = bVar.f18299e;
        this.f18288f = bVar.f18300f;
        this.f18289g = bVar.f18301g;
        this.f18290h = bVar.f18302h;
        this.f18291i = bVar.f18303i;
        this.f18292j = bVar.f18304j;
        this.f18293k = bVar.f18305k;
        this.f18294l = bVar.f18306l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private e f18295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private e f18296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private e f18297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private e f18298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @m0
        private d f18299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @m0
        private d f18300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @m0
        private d f18301g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @m0
        private d f18302h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @m0
        private g f18303i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @m0
        private g f18304j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @m0
        private g f18305k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @m0
        private g f18306l;

        public b() {
            this.f18295a = k.b();
            this.f18296b = k.b();
            this.f18297c = k.b();
            this.f18298d = k.b();
            this.f18299e = new com.google.android.material.shape.a(0.0f);
            this.f18300f = new com.google.android.material.shape.a(0.0f);
            this.f18301g = new com.google.android.material.shape.a(0.0f);
            this.f18302h = new com.google.android.material.shape.a(0.0f);
            this.f18303i = k.c();
            this.f18304j = k.c();
            this.f18305k = k.c();
            this.f18306l = k.c();
        }

        private static float n(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).f18281a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f18218a;
            }
            return -1.0f;
        }

        @m0
        public b A(int i7, @m0 d dVar) {
            return B(k.a(i7)).D(dVar);
        }

        @m0
        public b B(@m0 e eVar) {
            this.f18297c = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                C(fN);
            }
            return this;
        }

        @m0
        public b C(@c.q float f8) {
            this.f18301g = new com.google.android.material.shape.a(f8);
            return this;
        }

        @m0
        public b D(@m0 d dVar) {
            this.f18301g = dVar;
            return this;
        }

        @m0
        public b E(@m0 g gVar) {
            this.f18306l = gVar;
            return this;
        }

        @m0
        public b F(@m0 g gVar) {
            this.f18304j = gVar;
            return this;
        }

        @m0
        public b G(@m0 g gVar) {
            this.f18303i = gVar;
            return this;
        }

        @m0
        public b H(int i7, @c.q float f8) {
            return J(k.a(i7)).K(f8);
        }

        @m0
        public b I(int i7, @m0 d dVar) {
            return J(k.a(i7)).L(dVar);
        }

        @m0
        public b J(@m0 e eVar) {
            this.f18295a = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                K(fN);
            }
            return this;
        }

        @m0
        public b K(@c.q float f8) {
            this.f18299e = new com.google.android.material.shape.a(f8);
            return this;
        }

        @m0
        public b L(@m0 d dVar) {
            this.f18299e = dVar;
            return this;
        }

        @m0
        public b M(int i7, @c.q float f8) {
            return O(k.a(i7)).P(f8);
        }

        @m0
        public b N(int i7, @m0 d dVar) {
            return O(k.a(i7)).Q(dVar);
        }

        @m0
        public b O(@m0 e eVar) {
            this.f18296b = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                P(fN);
            }
            return this;
        }

        @m0
        public b P(@c.q float f8) {
            this.f18300f = new com.google.android.material.shape.a(f8);
            return this;
        }

        @m0
        public b Q(@m0 d dVar) {
            this.f18300f = dVar;
            return this;
        }

        @m0
        public o m() {
            return new o(this);
        }

        @m0
        public b o(@c.q float f8) {
            return K(f8).P(f8).C(f8).x(f8);
        }

        @m0
        public b p(@m0 d dVar) {
            return L(dVar).Q(dVar).D(dVar).y(dVar);
        }

        @m0
        public b q(int i7, @c.q float f8) {
            return r(k.a(i7)).o(f8);
        }

        @m0
        public b r(@m0 e eVar) {
            return J(eVar).O(eVar).B(eVar).w(eVar);
        }

        @m0
        public b s(@m0 g gVar) {
            return E(gVar).G(gVar).F(gVar).t(gVar);
        }

        @m0
        public b t(@m0 g gVar) {
            this.f18305k = gVar;
            return this;
        }

        @m0
        public b u(int i7, @c.q float f8) {
            return w(k.a(i7)).x(f8);
        }

        @m0
        public b v(int i7, @m0 d dVar) {
            return w(k.a(i7)).y(dVar);
        }

        @m0
        public b w(@m0 e eVar) {
            this.f18298d = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                x(fN);
            }
            return this;
        }

        @m0
        public b x(@c.q float f8) {
            this.f18302h = new com.google.android.material.shape.a(f8);
            return this;
        }

        @m0
        public b y(@m0 d dVar) {
            this.f18302h = dVar;
            return this;
        }

        @m0
        public b z(int i7, @c.q float f8) {
            return B(k.a(i7)).C(f8);
        }

        public b(@m0 o oVar) {
            this.f18295a = k.b();
            this.f18296b = k.b();
            this.f18297c = k.b();
            this.f18298d = k.b();
            this.f18299e = new com.google.android.material.shape.a(0.0f);
            this.f18300f = new com.google.android.material.shape.a(0.0f);
            this.f18301g = new com.google.android.material.shape.a(0.0f);
            this.f18302h = new com.google.android.material.shape.a(0.0f);
            this.f18303i = k.c();
            this.f18304j = k.c();
            this.f18305k = k.c();
            this.f18306l = k.c();
            this.f18295a = oVar.f18283a;
            this.f18296b = oVar.f18284b;
            this.f18297c = oVar.f18285c;
            this.f18298d = oVar.f18286d;
            this.f18299e = oVar.f18287e;
            this.f18300f = oVar.f18288f;
            this.f18301g = oVar.f18289g;
            this.f18302h = oVar.f18290h;
            this.f18303i = oVar.f18291i;
            this.f18304j = oVar.f18292j;
            this.f18305k = oVar.f18293k;
            this.f18306l = oVar.f18294l;
        }
    }

    public o() {
        this.f18283a = k.b();
        this.f18284b = k.b();
        this.f18285c = k.b();
        this.f18286d = k.b();
        this.f18287e = new com.google.android.material.shape.a(0.0f);
        this.f18288f = new com.google.android.material.shape.a(0.0f);
        this.f18289g = new com.google.android.material.shape.a(0.0f);
        this.f18290h = new com.google.android.material.shape.a(0.0f);
        this.f18291i = k.c();
        this.f18292j = k.c();
        this.f18293k = k.c();
        this.f18294l = k.c();
    }
}
