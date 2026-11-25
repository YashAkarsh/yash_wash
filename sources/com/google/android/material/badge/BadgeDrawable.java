package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.c1;
import c.f;
import c.i1;
import c.l;
import c.m0;
import c.o0;
import c.q;
import c.q0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import com.google.android.material.resources.c;
import com.google.android.material.resources.d;
import com.google.android.material.shape.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements k.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f16994q = 8388661;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f16995r = 8388659;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f16996s = 8388693;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f16997t = 8388691;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f16998u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f16999v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f17000w = 9;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @b1
    private static final int f17001x = R.style.Widget_MaterialComponents_Badge;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @f
    private static final int f17002y = R.attr.badgeStyle;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final String f17003z = "+";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final WeakReference<Context> f17004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final j f17005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final k f17006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final Rect f17007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f17008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f17009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f17010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m0
    private final SavedState f17011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f17012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f17013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f17015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f17016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f17017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private WeakReference<View> f17018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private WeakReference<FrameLayout> f17019p;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f17034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f17035b;

        a(View view, FrameLayout frameLayout) {
            this.f17034a = view;
            this.f17035b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.S(this.f17034a, this.f17035b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private BadgeDrawable(@m0 Context context) {
        this.f17004a = new WeakReference<>(context);
        n.c(context);
        Resources resources = context.getResources();
        this.f17007d = new Rect();
        this.f17005b = new j();
        this.f17008e = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.f17010g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f17009f = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        k kVar = new k(this);
        this.f17006c = kVar;
        kVar.e().setTextAlign(Paint.Align.CENTER);
        this.f17011h = new SavedState(context);
        L(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void K(@o0 d dVar) {
        Context context;
        if (this.f17006c.d() == dVar || (context = this.f17004a.get()) == null) {
            return;
        }
        this.f17006c.i(dVar, context);
        T();
    }

    private void L(@b1 int i7) {
        Context context = this.f17004a.get();
        if (context == null) {
            return;
        }
        K(new d(context, i7));
    }

    private void O(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f17019p;
            if (weakReference == null || weakReference.get() != viewGroup) {
                P(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f17019p = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    private static void P(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void T() {
        Context context = this.f17004a.get();
        WeakReference<View> weakReference = this.f17018o;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f17007d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.f17019p;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || com.google.android.material.badge.a.f17037a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        com.google.android.material.badge.a.l(this.f17007d, this.f17012i, this.f17013j, this.f17016m, this.f17017n);
        this.f17005b.j0(this.f17015l);
        if (rect.equals(this.f17007d)) {
            return;
        }
        this.f17005b.setBounds(this.f17007d);
    }

    private void U() {
        this.f17014k = ((int) Math.pow(10.0d, ((double) r()) - 1.0d)) - 1;
    }

    private void b(@m0 Context context, @m0 Rect rect, @m0 View view) {
        int i7 = this.f17011h.f17031l + this.f17011h.f17033n;
        int i8 = this.f17011h.f17028i;
        if (i8 == 8388691 || i8 == 8388693) {
            this.f17013j = rect.bottom - i7;
        } else {
            this.f17013j = rect.top + i7;
        }
        if (s() <= 9) {
            float f8 = !v() ? this.f17008e : this.f17009f;
            this.f17015l = f8;
            this.f17017n = f8;
            this.f17016m = f8;
        } else {
            float f9 = this.f17009f;
            this.f17015l = f9;
            this.f17017n = f9;
            this.f17016m = (this.f17006c.f(m()) / 2.0f) + this.f17010g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(v() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i9 = this.f17011h.f17030k + this.f17011h.f17032m;
        int i10 = this.f17011h.f17028i;
        if (i10 == 8388659 || i10 == 8388691) {
            this.f17012i = n2.Z(view) == 0 ? (rect.left - this.f17016m) + dimensionPixelSize + i9 : ((rect.right + this.f17016m) - dimensionPixelSize) - i9;
        } else {
            this.f17012i = n2.Z(view) == 0 ? ((rect.right + this.f17016m) - dimensionPixelSize) - i9 : (rect.left - this.f17016m) + dimensionPixelSize + i9;
        }
    }

    @m0
    public static BadgeDrawable d(@m0 Context context) {
        return e(context, null, f17002y, f17001x);
    }

    @m0
    private static BadgeDrawable e(@m0 Context context, AttributeSet attributeSet, @f int i7, @b1 int i8) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.w(context, attributeSet, i7, i8);
        return badgeDrawable;
    }

    @m0
    public static BadgeDrawable f(@m0 Context context, @i1 int i7) {
        AttributeSet attributeSetA = m1.a.a(context, i7, "badge");
        int styleAttribute = attributeSetA.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = f17001x;
        }
        return e(context, attributeSetA, f17002y, styleAttribute);
    }

    @m0
    static BadgeDrawable g(@m0 Context context, @m0 SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.y(savedState);
        return badgeDrawable;
    }

    private void h(Canvas canvas) {
        Rect rect = new Rect();
        String strM = m();
        this.f17006c.e().getTextBounds(strM, 0, strM.length(), rect);
        canvas.drawText(strM, this.f17012i, this.f17013j + (rect.height() / 2), this.f17006c.e());
    }

    @m0
    private String m() {
        if (s() <= this.f17014k) {
            return NumberFormat.getInstance().format(s());
        }
        Context context = this.f17004a.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f17014k), f17003z);
    }

    private void w(Context context, AttributeSet attributeSet, @f int i7, @b1 int i8) {
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.Badge, i7, i8, new int[0]);
        I(typedArrayJ.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (typedArrayJ.hasValue(R.styleable.Badge_number)) {
            J(typedArrayJ.getInt(R.styleable.Badge_number, 0));
        }
        B(x(context, typedArrayJ, R.styleable.Badge_backgroundColor));
        if (typedArrayJ.hasValue(R.styleable.Badge_badgeTextColor)) {
            D(x(context, typedArrayJ, R.styleable.Badge_badgeTextColor));
        }
        C(typedArrayJ.getInt(R.styleable.Badge_badgeGravity, f16994q));
        H(typedArrayJ.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        M(typedArrayJ.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        typedArrayJ.recycle();
    }

    private static int x(Context context, @m0 TypedArray typedArray, @c1 int i7) {
        return c.a(context, typedArray, i7).getDefaultColor();
    }

    private void y(@m0 SavedState savedState) {
        I(savedState.f17024e);
        if (savedState.f17023d != -1) {
            J(savedState.f17023d);
        }
        B(savedState.f17020a);
        D(savedState.f17021b);
        C(savedState.f17028i);
        H(savedState.f17030k);
        M(savedState.f17031l);
        z(savedState.f17032m);
        A(savedState.f17033n);
        N(savedState.f17029j);
    }

    void A(int i7) {
        this.f17011h.f17033n = i7;
        T();
    }

    public void B(@l int i7) {
        this.f17011h.f17020a = i7;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i7);
        if (this.f17005b.y() != colorStateListValueOf) {
            this.f17005b.n0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void C(int i7) {
        if (this.f17011h.f17028i != i7) {
            this.f17011h.f17028i = i7;
            WeakReference<View> weakReference = this.f17018o;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.f17018o.get();
            WeakReference<FrameLayout> weakReference2 = this.f17019p;
            S(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void D(@l int i7) {
        this.f17011h.f17021b = i7;
        if (this.f17006c.e().getColor() != i7) {
            this.f17006c.e().setColor(i7);
            invalidateSelf();
        }
    }

    public void E(@a1 int i7) {
        this.f17011h.f17027h = i7;
    }

    public void F(CharSequence charSequence) {
        this.f17011h.f17025f = charSequence;
    }

    public void G(@q0 int i7) {
        this.f17011h.f17026g = i7;
    }

    public void H(int i7) {
        this.f17011h.f17030k = i7;
        T();
    }

    public void I(int i7) {
        if (this.f17011h.f17024e != i7) {
            this.f17011h.f17024e = i7;
            U();
            this.f17006c.j(true);
            T();
            invalidateSelf();
        }
    }

    public void J(int i7) {
        int iMax = Math.max(0, i7);
        if (this.f17011h.f17023d != iMax) {
            this.f17011h.f17023d = iMax;
            this.f17006c.j(true);
            T();
            invalidateSelf();
        }
    }

    public void M(int i7) {
        this.f17011h.f17031l = i7;
        T();
    }

    public void N(boolean z7) {
        setVisible(z7, false);
        this.f17011h.f17029j = z7;
        if (!com.google.android.material.badge.a.f17037a || p() == null || z7) {
            return;
        }
        ((ViewGroup) p().getParent()).invalidate();
    }

    public void Q(@m0 View view) {
        S(view, null);
    }

    @Deprecated
    public void R(@m0 View view, @o0 ViewGroup viewGroup) {
        if (!(viewGroup instanceof FrameLayout)) {
            throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        S(view, (FrameLayout) viewGroup);
    }

    public void S(@m0 View view, @o0 FrameLayout frameLayout) {
        this.f17018o = new WeakReference<>(view);
        boolean z7 = com.google.android.material.badge.a.f17037a;
        if (z7 && frameLayout == null) {
            O(view);
        } else {
            this.f17019p = new WeakReference<>(frameLayout);
        }
        if (!z7) {
            P(view);
        }
        T();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.k.b
    @x0({x0.a.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    public void c() {
        this.f17011h.f17023d = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f17005b.draw(canvas);
        if (v()) {
            h(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17011h.f17022c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17007d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17007d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    int i() {
        return this.f17011h.f17032m;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    int j() {
        return this.f17011h.f17033n;
    }

    @l
    public int k() {
        return this.f17005b.y().getDefaultColor();
    }

    public int l() {
        return this.f17011h.f17028i;
    }

    @l
    public int n() {
        return this.f17006c.e().getColor();
    }

    @o0
    public CharSequence o() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!v()) {
            return this.f17011h.f17025f;
        }
        if (this.f17011h.f17026g <= 0 || (context = this.f17004a.get()) == null) {
            return null;
        }
        return s() <= this.f17014k ? context.getResources().getQuantityString(this.f17011h.f17026g, s(), Integer.valueOf(s())) : context.getString(this.f17011h.f17027h, Integer.valueOf(this.f17014k));
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @o0
    public FrameLayout p() {
        WeakReference<FrameLayout> weakReference = this.f17019p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int q() {
        return this.f17011h.f17030k;
    }

    public int r() {
        return this.f17011h.f17024e;
    }

    public int s() {
        if (v()) {
            return this.f17011h.f17023d;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f17011h.f17022c = i7;
        this.f17006c.e().setAlpha(i7);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @m0
    public SavedState t() {
        return this.f17011h;
    }

    public int u() {
        return this.f17011h.f17031l;
    }

    public boolean v() {
        return this.f17011h.f17023d != -1;
    }

    void z(int i7) {
        this.f17011h.f17032m = i7;
        T();
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        private int f17020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        private int f17021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f17022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f17023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f17024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        private CharSequence f17025f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @q0
        private int f17026g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @a1
        private int f17027h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f17028i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f17029j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @q(unit = 1)
        private int f17030k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @q(unit = 1)
        private int f17031l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @q(unit = 1)
        private int f17032m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @q(unit = 1)
        private int f17033n;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(@m0 Context context) {
            this.f17022c = 255;
            this.f17023d = -1;
            this.f17021b = new d(context, R.style.TextAppearance_MaterialComponents_Badge).f18138a.getDefaultColor();
            this.f17025f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.f17026g = R.plurals.mtrl_badge_content_description;
            this.f17027h = R.string.mtrl_exceed_max_badge_number_content_description;
            this.f17029j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            parcel.writeInt(this.f17020a);
            parcel.writeInt(this.f17021b);
            parcel.writeInt(this.f17022c);
            parcel.writeInt(this.f17023d);
            parcel.writeInt(this.f17024e);
            parcel.writeString(this.f17025f.toString());
            parcel.writeInt(this.f17026g);
            parcel.writeInt(this.f17028i);
            parcel.writeInt(this.f17030k);
            parcel.writeInt(this.f17031l);
            parcel.writeInt(this.f17032m);
            parcel.writeInt(this.f17033n);
            parcel.writeInt(this.f17029j ? 1 : 0);
        }

        protected SavedState(@m0 Parcel parcel) {
            this.f17022c = 255;
            this.f17023d = -1;
            this.f17020a = parcel.readInt();
            this.f17021b = parcel.readInt();
            this.f17022c = parcel.readInt();
            this.f17023d = parcel.readInt();
            this.f17024e = parcel.readInt();
            this.f17025f = parcel.readString();
            this.f17026g = parcel.readInt();
            this.f17028i = parcel.readInt();
            this.f17030k = parcel.readInt();
            this.f17031l = parcel.readInt();
            this.f17032m = parcel.readInt();
            this.f17033n = parcel.readInt();
            this.f17029j = parcel.readInt() != 0;
        }
    }
}
