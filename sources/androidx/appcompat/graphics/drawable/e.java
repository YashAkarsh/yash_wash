package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.w0;
import androidx.core.content.res.q;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@SuppressLint({"RestrictedAPI"})
class e extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f1002r = "StateListDrawable";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final boolean f1003s = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private a f1004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1005q;

    static class a extends b.d {

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int[][] f1006J;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.f1006J = aVar.f1006J;
            } else {
                this.f1006J = new int[g()][];
            }
        }

        int D(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.f1006J[iA] = iArr;
            return iA;
        }

        int E(int[] iArr) {
            int[][] iArr2 = this.f1006J;
            int i7 = i();
            for (int i8 = 0; i8 < i7; i8++) {
                if (StateSet.stateSetMatches(iArr2[i8], iArr)) {
                    return i8;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.b.d
        public void r(int i7, int i8) {
            super.r(i7, i8);
            int[][] iArr = new int[i8][];
            System.arraycopy(this.f1006J, 0, iArr, 0, i7);
            this.f1006J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.b.d
        void v() {
            int[][] iArr = this.f1006J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.f1006J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.f1006J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e() {
        this(null, null);
    }

    private void w(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.f1004p;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = typedArrayS.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawableJ = resourceId > 0 ? w0.h().j(context, resourceId) : null;
                typedArrayS.recycle();
                int[] iArrP = p(attributeSet);
                if (drawableJ == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    drawableJ = f.a.c.a(resources, xmlPullParser, attributeSet, theme);
                }
                aVar.D(iArrP, drawableJ);
            }
        }
    }

    private void x(TypedArray typedArray) {
        a aVar = this.f1004p;
        aVar.f961d |= f.a.c.b(typedArray);
        aVar.f966i = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f966i);
        aVar.f969l = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f969l);
        aVar.A = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.A);
        aVar.B = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.B);
        aVar.f981x = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f981x);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @t0(21)
    public void applyTheme(@m0 Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.b
    void b() {
        super.b();
        this.f1005q = false;
    }

    @Override // androidx.appcompat.graphics.drawable.b
    void i(@m0 b.d dVar) {
        super.i(dVar);
        if (dVar instanceof a) {
            this.f1004p = (a) dVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @m0
    public Drawable mutate() {
        if (!this.f1005q && super.mutate() == this) {
            this.f1004p.v();
            this.f1005q = true;
        }
        return this;
    }

    public void n(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.f1004p.D(iArr, drawable);
            onStateChange(getState());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.b
    public a o() {
        return new a(this.f1004p, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(@m0 int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iE = this.f1004p.E(iArr);
        if (iE < 0) {
            iE = this.f1004p.E(StateSet.WILD_CARD);
        }
        return h(iE) || zOnStateChange;
    }

    int[] p(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i7 = 0;
        for (int i8 = 0; i8 < attributeCount; i8++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i8);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i9 = i7 + 1;
                if (!attributeSet.getAttributeBooleanValue(i8, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i7] = attributeNameResource;
                i7 = i9;
            }
        }
        return StateSet.trimStateSet(iArr, i7);
    }

    int q() {
        return this.f1004p.i();
    }

    Drawable r(int i7) {
        return this.f1004p.h(i7);
    }

    int s(int[] iArr) {
        return this.f1004p.E(iArr);
    }

    a t() {
        return this.f1004p;
    }

    int[] u(int i7) {
        return this.f1004p.f1006J[i7];
    }

    public void v(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(typedArrayS.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        x(typedArrayS);
        m(resources);
        typedArrayS.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    e(a aVar, Resources resources) {
        i(new a(aVar, this, resources));
        onStateChange(getState());
    }

    e(@o0 a aVar) {
        if (aVar != null) {
            i(aVar);
        }
    }
}
