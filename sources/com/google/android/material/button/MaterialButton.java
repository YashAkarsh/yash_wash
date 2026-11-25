package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.d;
import androidx.core.view.n2;
import androidx.core.widget.u;
import androidx.customview.view.AbsSavedState;
import c.l;
import c.m0;
import c.n;
import c.o0;
import c.p;
import c.q;
import c.r0;
import c.t0;
import c.x0;
import com.google.android.material.internal.v;
import com.google.android.material.shape.k;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, s {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f17212s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f17213t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17214u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17215v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f17216w = 16;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f17217x = 32;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f17218y = "MaterialButton";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final com.google.android.material.button.a f17220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private final LinkedHashSet<b> f17221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private c f17222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private PorterDuff.Mode f17223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private ColorStateList f17224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private Drawable f17225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @r0
    private int f17226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @r0
    private int f17227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @r0
    private int f17228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @r0
    private int f17229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f17232p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f17210q = {R.attr.state_checkable};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f17211r = {R.attr.state_checked};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f17219z = com.google.android.material.R.style.Widget_MaterialComponents_Button;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f17233c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@m0 Parcel parcel) {
            this.f17233c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f17233c ? 1 : 0);
        }

        public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            b(parcel);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z7);
    }

    interface c {
        void a(MaterialButton materialButton, boolean z7);
    }

    public MaterialButton(@m0 Context context) {
        this(context, null);
    }

    private boolean e() {
        int i7 = this.f17232p;
        return i7 == 3 || i7 == 4;
    }

    private boolean f() {
        int i7 = this.f17232p;
        return i7 == 1 || i7 == 2;
    }

    private boolean g() {
        int i7 = this.f17232p;
        return i7 == 16 || i7 == 32;
    }

    @m0
    private String getA11yClassName() {
        return (d() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    private boolean h() {
        return n2.Z(this) == 1;
    }

    private boolean i() {
        com.google.android.material.button.a aVar = this.f17220d;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void k() {
        if (f()) {
            u.w(this, this.f17225i, null, null, null);
        } else if (e()) {
            u.w(this, null, null, this.f17225i, null);
        } else if (g()) {
            u.w(this, null, this.f17225i, null, null);
        }
    }

    private void l(boolean z7) {
        Drawable drawable = this.f17225i;
        if (drawable != null) {
            Drawable drawableMutate = d.r(drawable).mutate();
            this.f17225i = drawableMutate;
            d.o(drawableMutate, this.f17224h);
            PorterDuff.Mode mode = this.f17223g;
            if (mode != null) {
                d.p(this.f17225i, mode);
            }
            int intrinsicWidth = this.f17226j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f17225i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f17226j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f17225i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f17225i;
            int i7 = this.f17227k;
            int i8 = this.f17228l;
            drawable2.setBounds(i7, i8, intrinsicWidth + i7, intrinsicHeight + i8);
        }
        if (z7) {
            k();
            return;
        }
        Drawable[] drawableArrH = u.h(this);
        boolean z8 = false;
        Drawable drawable3 = drawableArrH[0];
        Drawable drawable4 = drawableArrH[1];
        Drawable drawable5 = drawableArrH[2];
        if ((f() && drawable3 != this.f17225i) || ((e() && drawable5 != this.f17225i) || (g() && drawable4 != this.f17225i))) {
            z8 = true;
        }
        if (z8) {
            k();
        }
    }

    private void m(int i7, int i8) {
        if (this.f17225i == null || getLayout() == null) {
            return;
        }
        if (!f() && !e()) {
            if (g()) {
                this.f17227k = 0;
                if (this.f17232p == 16) {
                    this.f17228l = 0;
                    l(false);
                    return;
                }
                int intrinsicHeight = this.f17226j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f17225i.getIntrinsicHeight();
                }
                int textHeight = (((((i8 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f17229m) - getPaddingBottom()) / 2;
                if (this.f17228l != textHeight) {
                    this.f17228l = textHeight;
                    l(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f17228l = 0;
        int i9 = this.f17232p;
        if (i9 == 1 || i9 == 3) {
            this.f17227k = 0;
            l(false);
            return;
        }
        int intrinsicWidth = this.f17226j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f17225i.getIntrinsicWidth();
        }
        int textWidth = (((((i7 - getTextWidth()) - n2.j0(this)) - intrinsicWidth) - this.f17229m) - n2.k0(this)) / 2;
        if (h() != (this.f17232p == 4)) {
            textWidth = -textWidth;
        }
        if (this.f17227k != textWidth) {
            this.f17227k = textWidth;
            l(false);
        }
    }

    public void a(@m0 b bVar) {
        this.f17221e.add(bVar);
    }

    public void c() {
        this.f17221e.clear();
    }

    public boolean d() {
        com.google.android.material.button.a aVar = this.f17220d;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    @o0
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @o0
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @r0
    public int getCornerRadius() {
        if (i()) {
            return this.f17220d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f17225i;
    }

    public int getIconGravity() {
        return this.f17232p;
    }

    @r0
    public int getIconPadding() {
        return this.f17229m;
    }

    @r0
    public int getIconSize() {
        return this.f17226j;
    }

    public ColorStateList getIconTint() {
        return this.f17224h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f17223g;
    }

    @q
    public int getInsetBottom() {
        return this.f17220d.c();
    }

    @q
    public int getInsetTop() {
        return this.f17220d.d();
    }

    @o0
    public ColorStateList getRippleColor() {
        if (i()) {
            return this.f17220d.h();
        }
        return null;
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        if (i()) {
            return this.f17220d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (i()) {
            return this.f17220d.j();
        }
        return null;
    }

    @r0
    public int getStrokeWidth() {
        if (i()) {
            return this.f17220d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.j2
    @o0
    @x0({x0.a.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return i() ? this.f17220d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.j2
    @o0
    @x0({x0.a.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return i() ? this.f17220d.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f17230n;
    }

    public void j(@m0 b bVar) {
        this.f17221e.remove(bVar);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (i()) {
            k.f(this, this.f17220d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 2);
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17210q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17211r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@m0 AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@o0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f17233c);
    }

    @Override // android.widget.TextView, android.view.View
    @m0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17233c = this.f17230n;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        m(i7, i8);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        m(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@m0 Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@l int i7) {
        if (i()) {
            this.f17220d.r(i7);
        } else {
            super.setBackgroundColor(i7);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@m0 Drawable drawable) {
        if (!i()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w(f17218y, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f17220d.s();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@c.u int i7) {
        setBackgroundDrawable(i7 != 0 ? e.a.b(getContext(), i7) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@o0 ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@o0 PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z7) {
        if (i()) {
            this.f17220d.t(z7);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (d() && isEnabled() && this.f17230n != z7) {
            this.f17230n = z7;
            refreshDrawableState();
            if (this.f17231o) {
                return;
            }
            this.f17231o = true;
            Iterator<b> it = this.f17221e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f17230n);
            }
            this.f17231o = false;
        }
    }

    public void setCornerRadius(@r0 int i7) {
        if (i()) {
            this.f17220d.u(i7);
        }
    }

    public void setCornerRadiusResource(@p int i7) {
        if (i()) {
            setCornerRadius(getResources().getDimensionPixelSize(i7));
        }
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        if (i()) {
            this.f17220d.f().m0(f8);
        }
    }

    public void setIcon(@o0 Drawable drawable) {
        if (this.f17225i != drawable) {
            this.f17225i = drawable;
            l(true);
            m(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i7) {
        if (this.f17232p != i7) {
            this.f17232p = i7;
            m(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@r0 int i7) {
        if (this.f17229m != i7) {
            this.f17229m = i7;
            setCompoundDrawablePadding(i7);
        }
    }

    public void setIconResource(@c.u int i7) {
        setIcon(i7 != 0 ? e.a.b(getContext(), i7) : null);
    }

    public void setIconSize(@r0 int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f17226j != i7) {
            this.f17226j = i7;
            l(true);
        }
    }

    public void setIconTint(@o0 ColorStateList colorStateList) {
        if (this.f17224h != colorStateList) {
            this.f17224h = colorStateList;
            l(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f17223g != mode) {
            this.f17223g = mode;
            l(false);
        }
    }

    public void setIconTintResource(@n int i7) {
        setIconTint(e.a.a(getContext(), i7));
    }

    public void setInsetBottom(@q int i7) {
        this.f17220d.v(i7);
    }

    public void setInsetTop(@q int i7) {
        this.f17220d.w(i7);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(@o0 c cVar) {
        this.f17222f = cVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z7) {
        c cVar = this.f17222f;
        if (cVar != null) {
            cVar.a(this, z7);
        }
        super.setPressed(z7);
    }

    public void setRippleColor(@o0 ColorStateList colorStateList) {
        if (i()) {
            this.f17220d.x(colorStateList);
        }
    }

    public void setRippleColorResource(@n int i7) {
        if (i()) {
            setRippleColor(e.a.a(getContext(), i7));
        }
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        if (!i()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f17220d.y(oVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z7) {
        if (i()) {
            this.f17220d.z(z7);
        }
    }

    public void setStrokeColor(@o0 ColorStateList colorStateList) {
        if (i()) {
            this.f17220d.A(colorStateList);
        }
    }

    public void setStrokeColorResource(@n int i7) {
        if (i()) {
            setStrokeColor(e.a.a(getContext(), i7));
        }
    }

    public void setStrokeWidth(@r0 int i7) {
        if (i()) {
            this.f17220d.B(i7);
        }
    }

    public void setStrokeWidthResource(@p int i7) {
        if (i()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i7));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.j2
    @x0({x0.a.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@o0 ColorStateList colorStateList) {
        if (i()) {
            this.f17220d.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.j2
    @x0({x0.a.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@o0 PorterDuff.Mode mode) {
        if (i()) {
            this.f17220d.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f17230n);
    }

    public MaterialButton(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f17219z;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17221e = new LinkedHashSet<>();
        this.f17230n = false;
        this.f17231o = false;
        Context context2 = getContext();
        TypedArray typedArrayJ = com.google.android.material.internal.n.j(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i7, i8, new int[0]);
        this.f17229m = typedArrayJ.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.f17223g = v.k(typedArrayJ.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f17224h = com.google.android.material.resources.c.a(getContext(), typedArrayJ, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.f17225i = com.google.android.material.resources.c.d(getContext(), typedArrayJ, com.google.android.material.R.styleable.MaterialButton_icon);
        this.f17232p = typedArrayJ.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.f17226j = typedArrayJ.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, o.e(context2, attributeSet, i7, i8).m());
        this.f17220d = aVar;
        aVar.q(typedArrayJ);
        typedArrayJ.recycle();
        setCompoundDrawablePadding(this.f17229m);
        l(this.f17225i != null);
    }
}
