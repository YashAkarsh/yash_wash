package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.i;
import c.m0;
import c.o0;
import c.p;
import c.q;
import c.r0;
import c.t0;
import c.u;
import com.google.android.material.R;
import com.google.android.material.animation.h;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.resources.d;
import com.google.android.material.resources.f;
import com.google.android.material.shape.k;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements com.google.android.material.chip.a.InterfaceC0193a, s {
    private static final String B = "http://schemas.android.com/apk/res/android";
    private static final int C = 48;
    private static final String D = "android.widget.Button";
    private static final String E = "android.widget.CompoundButton";
    private static final String F = "android.view.View";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f17315u = "Chip";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f17317w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f17318x = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private com.google.android.material.chip.a f17321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private InsetDrawable f17322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private RippleDrawable f17323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private View.OnClickListener f17324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private CompoundButton.OnCheckedChangeListener f17325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f17326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f17331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @q(unit = 1)
    private int f17332p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @m0
    private final c f17333q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f17334r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final RectF f17335s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final f f17336t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f17316v = R.style.Widget_MaterialComponents_Chip_Action;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Rect f17319y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f17320z = {android.R.attr.state_selected};
    private static final int[] A = {android.R.attr.state_checkable};

    class a extends f {
        a() {
        }

        @Override // com.google.android.material.resources.f
        public void a(int i7) {
        }

        @Override // com.google.android.material.resources.f
        public void b(@m0 Typeface typeface, boolean z7) {
            Chip chip = Chip.this;
            chip.setText(chip.f17321e.H3() ? Chip.this.f17321e.O1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @m0 Outline outline) {
            if (Chip.this.f17321e != null) {
                Chip.this.f17321e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends androidx.customview.widget.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.a
        protected int C(float f8, float f9) {
            return (Chip.this.o() && Chip.this.getCloseIconTouchBounds().contains(f8, f9)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.a
        protected void D(@m0 List<Integer> list) {
            list.add(0);
            if (Chip.this.o() && Chip.this.y() && Chip.this.f17324h != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.a
        protected boolean N(int i7, int i8, Bundle bundle) {
            if (i8 != 16) {
                return false;
            }
            if (i7 == 0) {
                return Chip.this.performClick();
            }
            if (i7 == 1) {
                return Chip.this.z();
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        protected void Q(@m0 l0 l0Var) {
            l0Var.U0(Chip.this.s());
            l0Var.X0(Chip.this.isClickable());
            if (Chip.this.s() || Chip.this.isClickable()) {
                l0Var.W0(Chip.this.s() ? Chip.E : Chip.D);
            } else {
                l0Var.W0(Chip.F);
            }
            l0Var.L1(Chip.this.getText());
        }

        @Override // androidx.customview.widget.a
        protected void R(int i7, @m0 l0 l0Var) {
            if (i7 != 1) {
                l0Var.a1("");
                l0Var.R0(Chip.f17319y);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                l0Var.a1(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i8 = R.string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                l0Var.a1(context.getString(i8, objArr).trim());
            }
            l0Var.R0(Chip.this.getCloseIconTouchBoundsInt());
            l0Var.b(l0.a.f6496j);
            l0Var.g1(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.a
        protected void S(int i7, boolean z7) {
            if (i7 == 1) {
                Chip.this.f17329m = z7;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f17322f != null) {
            this.f17322f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            E();
        }
    }

    private void C(@o0 com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.j3(null);
        }
    }

    private void D() {
        if (o() && y() && this.f17324h != null) {
            n2.B1(this, this.f17333q);
        } else {
            n2.B1(this, null);
        }
    }

    private void E() {
        if (com.google.android.material.ripple.b.f18164a) {
            F();
            return;
        }
        this.f17321e.G3(true);
        n2.I1(this, getBackgroundDrawable());
        G();
        m();
    }

    private void F() {
        this.f17323g = new RippleDrawable(com.google.android.material.ripple.b.d(this.f17321e.M1()), getBackgroundDrawable(), null);
        this.f17321e.G3(false);
        n2.I1(this, this.f17323g);
        G();
    }

    private void G() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f17321e) == null) {
            return;
        }
        int iO1 = (int) (aVar.o1() + this.f17321e.Q1() + this.f17321e.U0());
        int iT1 = (int) (this.f17321e.t1() + this.f17321e.R1() + this.f17321e.Q0());
        if (this.f17322f != null) {
            Rect rect = new Rect();
            this.f17322f.getPadding(rect);
            iT1 += rect.left;
            iO1 += rect.right;
        }
        n2.d2(this, iT1, getPaddingTop(), iO1, getPaddingBottom());
    }

    private void H() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.j(getContext(), paint, this.f17336t);
        }
    }

    private void I(@o0 AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(B, "background") != null) {
            Log.w(f17315u, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(B, "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(B, "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(B, "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue(B, "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue(B, "singleLine", true) || attributeSet.getAttributeIntValue(B, "lines", 1) != 1 || attributeSet.getAttributeIntValue(B, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(B, "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue(B, "gravity", 8388627) != 8388627) {
            Log.w(f17315u, "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public RectF getCloseIconTouchBounds() {
        this.f17335s.setEmpty();
        if (o() && this.f17324h != null) {
            this.f17321e.E1(this.f17335s);
        }
        return this.f17335s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f17334r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f17334r;
    }

    @o0
    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.P1();
        }
        return null;
    }

    private void j(@m0 com.google.android.material.chip.a aVar) {
        aVar.j3(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @m0
    private int[] k() {
        ?? IsEnabled = isEnabled();
        int i7 = IsEnabled;
        if (this.f17329m) {
            i7 = IsEnabled + 1;
        }
        int i8 = i7;
        if (this.f17328l) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (this.f17327k) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (isChecked()) {
            i10 = i9 + 1;
        }
        int[] iArr = new int[i10];
        int i11 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i11 = 1;
        }
        if (this.f17329m) {
            iArr[i11] = 16842908;
            i11++;
        }
        if (this.f17328l) {
            iArr[i11] = 16843623;
            i11++;
        }
        if (this.f17327k) {
            iArr[i11] = 16842919;
            i11++;
        }
        if (isChecked()) {
            iArr[i11] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f17322f && this.f17321e.getCallback() == null) {
            this.f17321e.setCallback(this.f17322f);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean n(@m0 MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.widget.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f17333q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.widget.a.class.getDeclaredMethod("Z", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f17333q, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e8) {
                Log.e(f17315u, "Unable to send Accessibility Exit event", e8);
            } catch (NoSuchFieldException e9) {
                Log.e(f17315u, "Unable to send Accessibility Exit event", e9);
            } catch (NoSuchMethodException e10) {
                Log.e(f17315u, "Unable to send Accessibility Exit event", e10);
            } catch (InvocationTargetException e11) {
                Log.e(f17315u, "Unable to send Accessibility Exit event", e11);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        com.google.android.material.chip.a aVar = this.f17321e;
        return (aVar == null || aVar.x1() == null) ? false : true;
    }

    private void p(Context context, @o0 AttributeSet attributeSet, int i7) {
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.Chip, i7, f17316v, new int[0]);
        this.f17330n = typedArrayJ.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f17332p = (int) Math.ceil(typedArrayJ.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(v.e(getContext(), 48))));
        typedArrayJ.recycle();
    }

    private void q() {
        setOutlineProvider(new b());
    }

    private void r(int i7, int i8, int i9, int i10) {
        this.f17322f = new InsetDrawable((Drawable) this.f17321e, i7, i8, i9, i10);
    }

    private void setCloseIconHovered(boolean z7) {
        if (this.f17328l != z7) {
            this.f17328l = z7;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z7) {
        if (this.f17327k != z7) {
            this.f17327k = z7;
            refreshDrawableState();
        }
    }

    public boolean B() {
        return this.f17330n;
    }

    @Override // com.google.android.material.chip.a.InterfaceC0193a
    public void a() {
        l(this.f17332p);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@m0 MotionEvent motionEvent) {
        return n(motionEvent) || this.f17333q.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f17333q.w(keyEvent) || this.f17333q.B() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f17321e;
        if ((aVar == null || !aVar.b2()) ? false : this.f17321e.e3(k())) {
            invalidate();
        }
    }

    @o0
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f17322f;
        return insetDrawable == null ? this.f17321e : insetDrawable;
    }

    @o0
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.k1();
        }
        return null;
    }

    @o0
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.l1();
        }
        return null;
    }

    @o0
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.m1();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.n1());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f17321e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.o1();
        }
        return 0.0f;
    }

    @o0
    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.p1();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.q1();
        }
        return 0.0f;
    }

    @o0
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.r1();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.s1();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.t1();
        }
        return 0.0f;
    }

    @o0
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.u1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.v1();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @o0
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.x1();
        }
        return null;
    }

    @o0
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.y1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.z1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.A1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.B1();
        }
        return 0.0f;
    }

    @o0
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.D1();
        }
        return null;
    }

    @Override // android.widget.TextView
    @o0
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.H1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@m0 Rect rect) {
        if (this.f17333q.B() == 1 || this.f17333q.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @o0
    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.I1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.J1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.K1();
        }
        return 0.0f;
    }

    @o0
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.M1();
        }
        return null;
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return this.f17321e.getShapeAppearanceModel();
    }

    @o0
    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.N1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.Q1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            return aVar.R1();
        }
        return 0.0f;
    }

    public boolean l(@q int i7) {
        this.f17332p = i7;
        if (!B()) {
            if (this.f17322f != null) {
                A();
            } else {
                E();
            }
            return false;
        }
        int iMax = Math.max(0, i7 - this.f17321e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i7 - this.f17321e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f17322f != null) {
                A();
            } else {
                E();
            }
            return false;
        }
        int i8 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i9 = iMax > 0 ? iMax / 2 : 0;
        if (this.f17322f != null) {
            Rect rect = new Rect();
            this.f17322f.getPadding(rect);
            if (rect.top == i9 && rect.bottom == i9 && rect.left == i8 && rect.right == i8) {
                E();
                return true;
            }
        }
        if (getMinHeight() != i7) {
            setMinHeight(i7);
        }
        if (getMinWidth() != i7) {
            setMinWidth(i7);
        }
        r(i8, i9, i8, i9);
        E();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.f17321e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17320z);
        }
        if (s()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z7, int i7, Rect rect) {
        super.onFocusChanged(z7, i7, rect);
        this.f17333q.M(z7, i7, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@m0 MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (s() || isClickable()) {
            accessibilityNodeInfo.setClassName(s() ? E : D);
        } else {
            accessibilityNodeInfo.setClassName(F);
        }
        accessibilityNodeInfo.setCheckable(s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            l0.X1(accessibilityNodeInfo).Z0(l0.c.h(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.o(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @o0
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@m0 MotionEvent motionEvent, int i7) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i7) {
        super.onRtlPropertiesChanged(i7);
        if (this.f17331o != i7) {
            this.f17331o = i7;
            G();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@m0 MotionEvent motionEvent) {
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.f17327k) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z7 = true;
                }
                z7 = false;
            } else {
                if (this.f17327k) {
                    z();
                    z7 = true;
                }
                setCloseIconPressed(false);
            }
            z7 = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z7 = true;
        } else {
            z7 = false;
        }
        return z7 || super.onTouchEvent(motionEvent);
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f17321e;
        return aVar != null && aVar.V1();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f17323g) {
            super.setBackground(drawable);
        } else {
            Log.w(f17315u, "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        Log.w(f17315u, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f17323g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w(f17315u, "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i7) {
        Log.w(f17315u, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@o0 ColorStateList colorStateList) {
        Log.w(f17315u, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@o0 PorterDuff.Mode mode) {
        Log.w(f17315u, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.k2(z7);
        }
    }

    public void setCheckableResource(@c.h int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.l2(i7);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar == null) {
            this.f17326j = z7;
            return;
        }
        if (aVar.V1()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z7);
            if (zIsChecked == z7 || (onCheckedChangeListener = this.f17325i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z7);
        }
    }

    public void setCheckedIcon(@o0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.m2(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z7) {
        setCheckedIconVisible(z7);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@c.h int i7) {
        setCheckedIconVisible(i7);
    }

    public void setCheckedIconResource(@u int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.p2(i7);
        }
    }

    public void setCheckedIconTint(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.q2(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.r2(i7);
        }
    }

    public void setCheckedIconVisible(@c.h int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.s2(i7);
        }
    }

    public void setChipBackgroundColor(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.u2(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.v2(i7);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.w2(f8);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.x2(i7);
        }
    }

    public void setChipDrawable(@m0 com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f17321e;
        if (aVar2 != aVar) {
            C(aVar2);
            this.f17321e = aVar;
            aVar.u3(false);
            j(this.f17321e);
            l(this.f17332p);
        }
    }

    public void setChipEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.y2(f8);
        }
    }

    public void setChipEndPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.z2(i7);
        }
    }

    public void setChipIcon(@o0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.A2(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z7) {
        setChipIconVisible(z7);
    }

    @Deprecated
    public void setChipIconEnabledResource(@c.h int i7) {
        setChipIconVisible(i7);
    }

    public void setChipIconResource(@u int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.D2(i7);
        }
    }

    public void setChipIconSize(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.E2(f8);
        }
    }

    public void setChipIconSizeResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.F2(i7);
        }
    }

    public void setChipIconTint(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.G2(colorStateList);
        }
    }

    public void setChipIconTintResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.H2(i7);
        }
    }

    public void setChipIconVisible(@c.h int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.I2(i7);
        }
    }

    public void setChipMinHeight(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.K2(f8);
        }
    }

    public void setChipMinHeightResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.L2(i7);
        }
    }

    public void setChipStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.M2(f8);
        }
    }

    public void setChipStartPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.N2(i7);
        }
    }

    public void setChipStrokeColor(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.O2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.P2(i7);
        }
    }

    public void setChipStrokeWidth(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.Q2(f8);
        }
    }

    public void setChipStrokeWidthResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.R2(i7);
        }
    }

    @Deprecated
    public void setChipText(@o0 CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@a1 int i7) {
        setText(getResources().getString(i7));
    }

    public void setCloseIcon(@o0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.T2(drawable);
        }
        D();
    }

    public void setCloseIconContentDescription(@o0 CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.U2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z7) {
        setCloseIconVisible(z7);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@c.h int i7) {
        setCloseIconVisible(i7);
    }

    public void setCloseIconEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.X2(f8);
        }
    }

    public void setCloseIconEndPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.Y2(i7);
        }
    }

    public void setCloseIconResource(@u int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.Z2(i7);
        }
        D();
    }

    public void setCloseIconSize(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.a3(f8);
        }
    }

    public void setCloseIconSizeResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.b3(i7);
        }
    }

    public void setCloseIconStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.c3(f8);
        }
    }

    public void setCloseIconStartPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.d3(i7);
        }
    }

    public void setCloseIconTint(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.f3(colorStateList);
        }
    }

    public void setCloseIconTintResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.g3(i7);
        }
    }

    public void setCloseIconVisible(@c.h int i7) {
        setCloseIconVisible(getResources().getBoolean(i7));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(@o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i7, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i7, i8, i9, i10);
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.m0(f8);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f17321e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.k3(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        this.f17330n = z7;
        l(this.f17332p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i7) {
        if (i7 != 8388627) {
            Log.w(f17315u, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i7);
        }
    }

    public void setHideMotionSpec(@o0 h hVar) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.l3(hVar);
        }
    }

    public void setHideMotionSpecResource(@c.b int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.m3(i7);
        }
    }

    public void setIconEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.n3(f8);
        }
    }

    public void setIconEndPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.o3(i7);
        }
    }

    public void setIconStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.p3(f8);
        }
    }

    public void setIconStartPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.q3(i7);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i7) {
        if (this.f17321e == null) {
            return;
        }
        super.setLayoutDirection(i7);
    }

    @Override // android.widget.TextView
    public void setLines(int i7) {
        if (i7 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i7);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i7) {
        if (i7 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i7);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@r0 int i7) {
        super.setMaxWidth(i7);
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.r3(i7);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i7) {
        if (i7 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i7);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f17325i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f17324h = onClickListener;
        D();
    }

    public void setRippleColor(@o0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.s3(colorStateList);
        }
        if (this.f17321e.T1()) {
            return;
        }
        F();
    }

    public void setRippleColorResource(@c.n int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.t3(i7);
            if (this.f17321e.T1()) {
                return;
            }
            F();
        }
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        this.f17321e.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(@o0 h hVar) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.v3(hVar);
        }
    }

    public void setShowMotionSpecResource(@c.b int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.w3(i7);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z7) {
        if (!z7) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z7);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.H3() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f17321e;
        if (aVar2 != null) {
            aVar2.x3(charSequence);
        }
    }

    public void setTextAppearance(@o0 d dVar) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.y3(dVar);
        }
        H();
    }

    public void setTextAppearanceResource(@b1 int i7) {
        setTextAppearance(getContext(), i7);
    }

    public void setTextEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.A3(f8);
        }
    }

    public void setTextEndPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.B3(i7);
        }
    }

    public void setTextStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.E3(f8);
        }
    }

    public void setTextStartPaddingResource(@p int i7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.F3(i7);
        }
    }

    @Deprecated
    public boolean t() {
        return u();
    }

    public boolean u() {
        com.google.android.material.chip.a aVar = this.f17321e;
        return aVar != null && aVar.X1();
    }

    @Deprecated
    public boolean v() {
        return w();
    }

    public boolean w() {
        com.google.android.material.chip.a aVar = this.f17321e;
        return aVar != null && aVar.Z1();
    }

    @Deprecated
    public boolean x() {
        return y();
    }

    public boolean y() {
        com.google.android.material.chip.a aVar = this.f17321e;
        return aVar != null && aVar.c2();
    }

    @i
    public boolean z() {
        boolean z7 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f17324h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z7 = true;
        }
        this.f17333q.Y(1, 1);
        return z7;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.i3(z7);
        }
        D();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i7) {
        int i8 = f17316v;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17334r = new Rect();
        this.f17335s = new RectF();
        this.f17336t = new a();
        Context context2 = getContext();
        I(attributeSet);
        com.google.android.material.chip.a aVarZ0 = com.google.android.material.chip.a.Z0(context2, attributeSet, i7, i8);
        p(context2, attributeSet, i7);
        setChipDrawable(aVarZ0);
        aVarZ0.m0(n2.R(this));
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.Chip, i7, i8, new int[0]);
        boolean zHasValue = typedArrayJ.hasValue(R.styleable.Chip_shapeAppearance);
        typedArrayJ.recycle();
        this.f17333q = new c(this);
        D();
        if (!zHasValue) {
            q();
        }
        setChecked(this.f17326j);
        setText(aVarZ0.O1());
        setEllipsize(aVarZ0.H1());
        H();
        if (!this.f17321e.H3()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        G();
        if (B()) {
            setMinHeight(this.f17332p);
        }
        this.f17331o = n2.Z(this);
    }

    public void setCheckedIconVisible(boolean z7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.t2(z7);
        }
    }

    public void setChipIconVisible(boolean z7) {
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.J2(z7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.z3(i7);
        }
        H();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i7) {
        super.setTextAppearance(i7);
        com.google.android.material.chip.a aVar = this.f17321e;
        if (aVar != null) {
            aVar.z3(i7);
        }
        H();
    }
}
