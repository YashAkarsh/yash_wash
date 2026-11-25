package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.n2;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements n0 {
    private static final int A0 = 1;
    private static final int B0 = 2;
    private static final int C0 = 3;
    private static final Property<SwitchCompat, Float> D0 = new a(Float.class, "thumbPos");
    private static final int[] E0 = {R.attr.state_checked};
    private static final int S = 250;
    private static final int T = 0;
    private static final int U = 1;
    private static final int V = 2;
    private static final String W = "android.widget.Switch";
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private final TextPaint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ColorStateList f1626J;
    private Layout K;
    private Layout L;

    @c.o0
    private TransformationMethod M;
    ObjectAnimator N;
    private final t O;

    @c.m0
    private i P;

    @c.o0
    private c Q;
    private final Rect R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f1627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f1633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f1634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f1641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f1642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f1643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f1644r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1645s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1647u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f1648v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f1649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private VelocityTracker f1650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f1652z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1652z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f8) {
            switchCompat.setThumbPosition(f8.floatValue());
        }
    }

    @c.t0(18)
    static class b {
        private b() {
        }

        @c.t
        static void a(ObjectAnimator objectAnimator, boolean z7) {
            objectAnimator.setAutoCancel(z7);
        }
    }

    static class c extends androidx.emoji2.text.f.AbstractC0093f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference<SwitchCompat> f1653a;

        c(SwitchCompat switchCompat) {
            this.f1653a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.f.AbstractC0093f
        public void a(@c.o0 Throwable th) {
            SwitchCompat switchCompat = this.f1653a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }

        @Override // androidx.emoji2.text.f.AbstractC0093f
        public void b() {
            SwitchCompat switchCompat = this.f1653a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }
    }

    public SwitchCompat(@c.m0 Context context) {
        this(context, null);
    }

    private void a(boolean z7) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, D0, z7 ? 1.0f : 0.0f);
        this.N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.N, true);
        this.N.start();
    }

    private void c() {
        Drawable drawable = this.f1627a;
        if (drawable != null) {
            if (this.f1630d || this.f1631e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.d.r(drawable).mutate();
                this.f1627a = drawableMutate;
                if (this.f1630d) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, this.f1628b);
                }
                if (this.f1631e) {
                    androidx.core.graphics.drawable.d.p(this.f1627a, this.f1629c);
                }
                if (this.f1627a.isStateful()) {
                    this.f1627a.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        Drawable drawable = this.f1632f;
        if (drawable != null) {
            if (this.f1635i || this.f1636j) {
                Drawable drawableMutate = androidx.core.graphics.drawable.d.r(drawable).mutate();
                this.f1632f = drawableMutate;
                if (this.f1635i) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, this.f1633g);
                }
                if (this.f1636j) {
                    androidx.core.graphics.drawable.d.p(this.f1632f, this.f1634h);
                }
                if (this.f1632f.isStateful()) {
                    this.f1632f.setState(getDrawableState());
                }
            }
        }
    }

    private void e() {
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void f(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float g(float f8, float f9, float f10) {
        if (f8 < f9) {
            return f9;
        }
        return f8 > f10 ? f10 : f8;
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.P == null) {
            this.P = new i(this);
        }
        return this.P;
    }

    private boolean getTargetCheckedState() {
        return this.f1652z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((r1.b(this) ? 1.0f - this.f1652z : this.f1652z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1632f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1627a;
        Rect rectD = drawable2 != null ? k0.d(drawable2) : k0.f1886c;
        return ((((this.A - this.C) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    @c.o0
    private CharSequence h(@c.o0 CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.M);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    private boolean i(float f8, float f9) {
        if (this.f1627a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1627a.getPadding(this.R);
        int i7 = this.E;
        int i8 = this.f1647u;
        int i9 = i7 - i8;
        int i10 = (this.D + thumbOffset) - i8;
        int i11 = this.C + i10;
        Rect rect = this.R;
        return f8 > ((float) i10) && f8 < ((float) (((i11 + rect.left) + rect.right) + i8)) && f9 > ((float) i9) && f9 < ((float) (this.G + i8));
    }

    private Layout j(CharSequence charSequence) {
        TextPaint textPaint = this.I;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1643q;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            n2.q2(this, string);
        }
    }

    private void m() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1641o;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
            }
            n2.q2(this, string);
        }
    }

    private void n(int i7, int i8) {
        Typeface typeface;
        if (i7 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i7 != 2) {
            typeface = i7 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        setSwitchTypeface(typeface, i8);
    }

    private void o() {
        if (this.Q == null && this.P.b() && androidx.emoji2.text.f.n()) {
            androidx.emoji2.text.f fVarB = androidx.emoji2.text.f.b();
            int iF = fVarB.f();
            if (iF == 3 || iF == 0) {
                c cVar = new c(this);
                this.Q = cVar;
                fVarB.y(cVar);
            }
        }
    }

    private void p(MotionEvent motionEvent) {
        this.f1646t = 0;
        boolean targetCheckedState = true;
        boolean z7 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z7) {
            this.f1650x.computeCurrentVelocity(1000);
            float xVelocity = this.f1650x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f1651y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!r1.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        f(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1643q = charSequence;
        this.f1644r = h(charSequence);
        this.L = null;
        if (this.f1645s) {
            o();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1641o = charSequence;
        this.f1642p = h(charSequence);
        this.K = null;
        if (this.f1645s) {
            o();
        }
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i7;
        int i8;
        Rect rect = this.R;
        int i9 = this.D;
        int i10 = this.E;
        int i11 = this.F;
        int i12 = this.G;
        int thumbOffset = getThumbOffset() + i9;
        Drawable drawable = this.f1627a;
        Rect rectD = drawable != null ? k0.d(drawable) : k0.f1886c;
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i13 = rect.left;
            thumbOffset += i13;
            if (rectD != null) {
                int i14 = rectD.left;
                if (i14 > i13) {
                    i9 += i14 - i13;
                }
                int i15 = rectD.top;
                int i16 = rect.top;
                i7 = i15 > i16 ? (i15 - i16) + i10 : i10;
                int i17 = rectD.right;
                int i18 = rect.right;
                if (i17 > i18) {
                    i11 -= i17 - i18;
                }
                int i19 = rectD.bottom;
                int i20 = rect.bottom;
                if (i19 > i20) {
                    i8 = i12 - (i19 - i20);
                }
                this.f1632f.setBounds(i9, i7, i11, i8);
            } else {
                i7 = i10;
            }
            i8 = i12;
            this.f1632f.setBounds(i9, i7, i11, i8);
        }
        Drawable drawable3 = this.f1627a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i21 = thumbOffset - rect.left;
            int i22 = thumbOffset + this.C + rect.right;
            this.f1627a.setBounds(i21, i10, i22, i12);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.d.l(background, i21, i10, i22, i12);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.f1627a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.k(drawable, f8, f9);
        }
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.d.k(drawable2, f8, f9);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1627a;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!r1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1639m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (r1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1639m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @c.o0
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.u.G(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1645s;
    }

    public boolean getSplitTrack() {
        return this.f1640n;
    }

    public int getSwitchMinWidth() {
        return this.f1638l;
    }

    public int getSwitchPadding() {
        return this.f1639m;
    }

    public CharSequence getTextOff() {
        return this.f1643q;
    }

    public CharSequence getTextOn() {
        return this.f1641o;
    }

    public Drawable getThumbDrawable() {
        return this.f1627a;
    }

    @c.v(from = 0.0d, to = 1.0d)
    protected final float getThumbPosition() {
        return this.f1652z;
    }

    public int getThumbTextPadding() {
        return this.f1637k;
    }

    @c.o0
    public ColorStateList getThumbTintList() {
        return this.f1628b;
    }

    @c.o0
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1629c;
    }

    public Drawable getTrackDrawable() {
        return this.f1632f;
    }

    @c.o0
    public ColorStateList getTrackTintList() {
        return this.f1633g;
    }

    @c.o0
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1634h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1627a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.N.end();
        this.N = null;
    }

    void k() {
        setTextOnInternal(this.f1641o);
        setTextOffInternal(this.f1643q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.R;
        Drawable drawable = this.f1632f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i7 = this.E;
        int i8 = this.G;
        int i9 = i7 + rect.top;
        int i10 = i8 - rect.bottom;
        Drawable drawable2 = this.f1627a;
        if (drawable != null) {
            if (!this.f1640n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = k0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.K : this.L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f1626J;
            if (colorStateList != null) {
                this.I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i9 + i10) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(W);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(W);
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1641o : this.f1643q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int iMax;
        int width;
        int paddingLeft;
        int i11;
        int paddingTop;
        int height;
        super.onLayout(z7, i7, i8, i9, i10);
        int iMax2 = 0;
        if (this.f1627a != null) {
            Rect rect = this.R;
            Drawable drawable = this.f1632f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = k0.d(this.f1627a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (r1.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i11 = this.B;
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.B;
            }
            this.D = paddingLeft;
            this.E = paddingTop;
            this.G = height;
            this.F = width;
        }
        int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        i11 = this.B;
        paddingTop = paddingTop2 - (i11 / 2);
        height = i11 + paddingTop;
        this.D = paddingLeft;
        this.E = paddingTop;
        this.G = height;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f1645s) {
            if (this.K == null) {
                this.K = j(this.f1642p);
            }
            if (this.L == null) {
                this.L = j(this.f1644r);
            }
        }
        Rect rect = this.R;
        Drawable drawable = this.f1627a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f1627a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1627a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.C = Math.max(this.f1645s ? Math.max(this.K.getWidth(), this.L.getWidth()) + (this.f1637k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f1632f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f1627a;
        if (drawable3 != null) {
            Rect rectD = k0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.H ? Math.max(this.f1638l, (this.C * 2) + iMax + iMax2) : this.f1638l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.A = iMax3;
        this.B = iMax4;
        super.onMeasure(i7, i8);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1641o : this.f1643q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f8;
        this.f1650x.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            if (isEnabled() && i(x7, y7)) {
                this.f1646t = 1;
                this.f1648v = x7;
                this.f1649w = y7;
            }
        } else if (actionMasked == 1) {
            if (this.f1646t == 2) {
                p(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1646t = 0;
            this.f1650x.clear();
        } else if (actionMasked == 2) {
            int i7 = this.f1646t;
            if (i7 == 1) {
                float x8 = motionEvent.getX();
                float y8 = motionEvent.getY();
                if (Math.abs(x8 - this.f1648v) > this.f1647u || Math.abs(y8 - this.f1649w) > this.f1647u) {
                    this.f1646t = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.f1648v = x8;
                    this.f1649w = y8;
                    return true;
                }
            } else if (i7 == 2) {
                float x9 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f9 = x9 - this.f1648v;
                if (thumbScrollRange != 0) {
                    f8 = f9 / thumbScrollRange;
                } else {
                    f8 = f9 > 0.0f ? 1.0f : -1.0f;
                }
                if (r1.b(this)) {
                    f8 = -f8;
                }
                float fG = g(this.f1652z + f8, 0.0f, 1.0f);
                if (fG != this.f1652z) {
                    this.f1648v = x9;
                    setThumbPosition(fG);
                }
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.f1646t == 2) {
                p(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1646t = 0;
            this.f1650x.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        super.setChecked(z7);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            m();
        } else {
            l();
        }
        if (getWindowToken() != null && n2.U0(this)) {
            a(zIsChecked);
        } else {
            e();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@c.o0 ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.u.H(this, callback));
    }

    @Override // androidx.appcompat.widget.n0
    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
        setTextOnInternal(this.f1641o);
        setTextOffInternal(this.f1643q);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z7) {
        this.H = z7;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@c.m0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f1645s != z7) {
            this.f1645s = z7;
            requestLayout();
            if (z7) {
                o();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f1640n = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i7) {
        this.f1638l = i7;
        requestLayout();
    }

    public void setSwitchPadding(int i7) {
        this.f1639m = i7;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i7) {
        h1 h1VarE = h1.E(context, i7, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateListD = h1VarE.d(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateListD != null) {
            this.f1626J = colorStateListD;
        } else {
            this.f1626J = getTextColors();
        }
        int iG = h1VarE.g(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (iG != 0) {
            float f8 = iG;
            if (f8 != this.I.getTextSize()) {
                this.I.setTextSize(f8);
                requestLayout();
            }
        }
        n(h1VarE.o(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), h1VarE.o(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (h1VarE.a(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.M = new g.a(getContext());
        } else {
            this.M = null;
        }
        setTextOnInternal(this.f1641o);
        setTextOffInternal(this.f1643q);
        h1VarE.I();
    }

    public void setSwitchTypeface(Typeface typeface, int i7) {
        if (i7 <= 0) {
            this.I.setFakeBoldText(false);
            this.I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i7) : Typeface.create(typeface, i7);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i8 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i7;
            this.I.setFakeBoldText((i8 & 1) != 0);
            this.I.setTextSkewX((i8 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        l();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            m();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1627a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1627a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f8) {
        this.f1652z = f8;
        invalidate();
    }

    public void setThumbResource(int i7) {
        setThumbDrawable(e.a.b(getContext(), i7));
    }

    public void setThumbTextPadding(int i7) {
        this.f1637k = i7;
        requestLayout();
    }

    public void setThumbTintList(@c.o0 ColorStateList colorStateList) {
        this.f1628b = colorStateList;
        this.f1630d = true;
        c();
    }

    public void setThumbTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1629c = mode;
        this.f1631e = true;
        c();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1632f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1632f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i7) {
        setTrackDrawable(e.a.b(getContext(), i7));
    }

    public void setTrackTintList(@c.o0 ColorStateList colorStateList) {
        this.f1633g = colorStateList;
        this.f1635i = true;
        d();
    }

    public void setTrackTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1634h = mode;
        this.f1636j = true;
        d();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1627a || drawable == this.f1632f;
    }

    public SwitchCompat(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1628b = null;
        this.f1629c = null;
        this.f1630d = false;
        this.f1631e = false;
        this.f1633g = null;
        this.f1634h = null;
        this.f1635i = false;
        this.f1636j = false;
        this.f1650x = VelocityTracker.obtain();
        this.H = true;
        this.R = new Rect();
        c1.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        h1 h1VarG = h1.G(context, attributeSet, androidx.appcompat.R.styleable.SwitchCompat, i7, 0);
        n2.z1(this, context, androidx.appcompat.R.styleable.SwitchCompat, attributeSet, h1VarG.B(), i7, 0);
        Drawable drawableH = h1VarG.h(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f1627a = drawableH;
        if (drawableH != null) {
            drawableH.setCallback(this);
        }
        Drawable drawableH2 = h1VarG.h(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f1632f = drawableH2;
        if (drawableH2 != null) {
            drawableH2.setCallback(this);
        }
        setTextOnInternal(h1VarG.x(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(h1VarG.x(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.f1645s = h1VarG.a(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f1637k = h1VarG.g(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1638l = h1VarG.g(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1639m = h1VarG.g(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f1640n = h1VarG.a(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListD = h1VarG.d(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateListD != null) {
            this.f1628b = colorStateListD;
            this.f1630d = true;
        }
        PorterDuff.Mode modeE = k0.e(h1VarG.o(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1629c != modeE) {
            this.f1629c = modeE;
            this.f1631e = true;
        }
        if (this.f1630d || this.f1631e) {
            c();
        }
        ColorStateList colorStateListD2 = h1VarG.d(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateListD2 != null) {
            this.f1633g = colorStateListD2;
            this.f1635i = true;
        }
        PorterDuff.Mode modeE2 = k0.e(h1VarG.o(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1634h != modeE2) {
            this.f1634h = modeE2;
            this.f1636j = true;
        }
        if (this.f1635i || this.f1636j) {
            d();
        }
        int iU = h1VarG.u(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (iU != 0) {
            setSwitchTextAppearance(context, iU);
        }
        t tVar = new t(this);
        this.O = tVar;
        tVar.m(attributeSet, i7);
        h1VarG.I();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1647u = viewConfiguration.getScaledTouchSlop();
        this.f1651y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i7);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.I.getTypeface() == null || this.I.getTypeface().equals(typeface)) && (this.I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
