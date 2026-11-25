package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f1848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1849c;

    @c.t0(21)
    static class a {
        private a() {
        }

        @c.t
        static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @c.t
        static int b(TypedArray typedArray, int i7) {
            return typedArray.getType(i7);
        }
    }

    private h1(Context context, TypedArray typedArray) {
        this.f1847a = context;
        this.f1848b = typedArray;
    }

    public static h1 E(Context context, int i7, int[] iArr) {
        return new h1(context, context.obtainStyledAttributes(i7, iArr));
    }

    public static h1 F(Context context, AttributeSet attributeSet, int[] iArr) {
        return new h1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static h1 G(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8) {
        return new h1(context, context.obtainStyledAttributes(attributeSet, iArr, i7, i8));
    }

    public boolean A(int i7, TypedValue typedValue) {
        return this.f1848b.getValue(i7, typedValue);
    }

    public TypedArray B() {
        return this.f1848b;
    }

    public boolean C(int i7) {
        return this.f1848b.hasValue(i7);
    }

    public int D() {
        return this.f1848b.length();
    }

    public TypedValue H(int i7) {
        return this.f1848b.peekValue(i7);
    }

    public void I() {
        this.f1848b.recycle();
    }

    public boolean a(int i7, boolean z7) {
        return this.f1848b.getBoolean(i7, z7);
    }

    @c.t0(21)
    public int b() {
        return a.a(this.f1848b);
    }

    public int c(int i7, int i8) {
        return this.f1848b.getColor(i7, i8);
    }

    public ColorStateList d(int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f1848b.hasValue(i7) || (resourceId = this.f1848b.getResourceId(i7, 0)) == 0 || (colorStateListA = e.a.a(this.f1847a, resourceId)) == null) ? this.f1848b.getColorStateList(i7) : colorStateListA;
    }

    public float e(int i7, float f8) {
        return this.f1848b.getDimension(i7, f8);
    }

    public int f(int i7, int i8) {
        return this.f1848b.getDimensionPixelOffset(i7, i8);
    }

    public int g(int i7, int i8) {
        return this.f1848b.getDimensionPixelSize(i7, i8);
    }

    public Drawable h(int i7) {
        int resourceId;
        return (!this.f1848b.hasValue(i7) || (resourceId = this.f1848b.getResourceId(i7, 0)) == 0) ? this.f1848b.getDrawable(i7) : e.a.b(this.f1847a, resourceId);
    }

    public Drawable i(int i7) {
        int resourceId;
        if (!this.f1848b.hasValue(i7) || (resourceId = this.f1848b.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return g.b().d(this.f1847a, resourceId, true);
    }

    public float j(int i7, float f8) {
        return this.f1848b.getFloat(i7, f8);
    }

    @c.o0
    public Typeface k(@c.c1 int i7, int i8, @c.o0 androidx.core.content.res.i.g gVar) {
        int resourceId = this.f1848b.getResourceId(i7, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1849c == null) {
            this.f1849c = new TypedValue();
        }
        return androidx.core.content.res.i.k(this.f1847a, resourceId, this.f1849c, i8, gVar);
    }

    public float l(int i7, int i8, int i9, float f8) {
        return this.f1848b.getFraction(i7, i8, i9, f8);
    }

    public int m(int i7) {
        return this.f1848b.getIndex(i7);
    }

    public int n() {
        return this.f1848b.getIndexCount();
    }

    public int o(int i7, int i8) {
        return this.f1848b.getInt(i7, i8);
    }

    public int p(int i7, int i8) {
        return this.f1848b.getInteger(i7, i8);
    }

    public int q(int i7, int i8) {
        return this.f1848b.getLayoutDimension(i7, i8);
    }

    public int r(int i7, String str) {
        return this.f1848b.getLayoutDimension(i7, str);
    }

    public String s(int i7) {
        return this.f1848b.getNonResourceString(i7);
    }

    public String t() {
        return this.f1848b.getPositionDescription();
    }

    public int u(int i7, int i8) {
        return this.f1848b.getResourceId(i7, i8);
    }

    public Resources v() {
        return this.f1848b.getResources();
    }

    public String w(int i7) {
        return this.f1848b.getString(i7);
    }

    public CharSequence x(int i7) {
        return this.f1848b.getText(i7);
    }

    public CharSequence[] y(int i7) {
        return this.f1848b.getTextArray(i7);
    }

    public int z(int i7) {
        return a.b(this.f1848b, i7);
    }
}
