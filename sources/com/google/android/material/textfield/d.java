package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.m;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes.dex */
class d extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f18683q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f18684r = 50;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f18685s = 67;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f18687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.e f18688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.h f18689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.i f18690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private StateListDrawable f18694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.google.android.material.shape.j f18695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private AccessibilityManager f18696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueAnimator f18697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f18698p;

    class a extends m {

        /* JADX INFO: renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        class RunnableC0208a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f18700a;

            RunnableC0208a(AutoCompleteTextView autoCompleteTextView) {
                this.f18700a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f18700a.isPopupShowing();
                d.this.E(zIsPopupShowing);
                d.this.f18691i = zIsPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.m, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewY = d.y(d.this.f18714a.getEditText());
            if (d.this.f18696n.isTouchExplorationEnabled() && d.D(autoCompleteTextViewY) && !d.this.f18716c.hasFocus()) {
                autoCompleteTextViewY.dismissDropDown();
            }
            autoCompleteTextViewY.post(new RunnableC0208a(autoCompleteTextViewY));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            d.this.f18716c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            d.this.f18714a.setEndIconActivated(z7);
            if (z7) {
                return;
            }
            d.this.E(false);
            d.this.f18691i = false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    class C0209d extends TextInputLayout.e {
        C0209d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            if (!d.D(d.this.f18714a.getEditText())) {
                l0Var.W0(Spinner.class.getName());
            }
            if (l0Var.z0()) {
                l0Var.l1(null);
            }
        }

        @Override // androidx.core.view.a
        public void h(View view, @m0 AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewY = d.y(d.this.f18714a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f18696n.isTouchExplorationEnabled() && !d.D(d.this.f18714a.getEditText())) {
                d.this.H(autoCompleteTextViewY);
            }
        }
    }

    class e implements TextInputLayout.h {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@m0 TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewY = d.y(textInputLayout.getEditText());
            d.this.F(autoCompleteTextViewY);
            d.this.v(autoCompleteTextViewY);
            d.this.G(autoCompleteTextViewY);
            autoCompleteTextViewY.setThreshold(0);
            autoCompleteTextViewY.removeTextChangedListener(d.this.f18686d);
            autoCompleteTextViewY.addTextChangedListener(d.this.f18686d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(autoCompleteTextViewY)) {
                n2.R1(d.this.f18716c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f18688f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    class f implements TextInputLayout.i {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f18707a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f18707a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18707a.removeTextChangedListener(d.this.f18686d);
            }
        }

        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@m0 TextInputLayout textInputLayout, int i7) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i7 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f18687e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f18683q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.f18714a.getEditText());
        }
    }

    class h implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f18710a;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f18710a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@m0 View view, @m0 MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f18691i = false;
                }
                d.this.H(this.f18710a);
            }
            return false;
        }
    }

    class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f18691i = true;
            d.this.f18693k = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f18716c.setChecked(dVar.f18692j);
            d.this.f18698p.start();
        }
    }

    d(@m0 TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18686d = new a();
        this.f18687e = new c();
        this.f18688f = new C0209d(this.f18714a);
        this.f18689g = new e();
        this.f18690h = new f();
        this.f18691i = false;
        this.f18692j = false;
        this.f18693k = Long.MAX_VALUE;
    }

    private com.google.android.material.shape.j A(float f8, float f9, float f10, int i7) {
        o oVarM = o.a().K(f8).P(f8).x(f9).C(f9).m();
        com.google.android.material.shape.j jVarN = com.google.android.material.shape.j.n(this.f18715b, f10);
        jVarN.setShapeAppearanceModel(oVarM);
        jVarN.p0(0, i7, 0, i7);
        return jVarN;
    }

    private void B() {
        this.f18698p = z(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorZ = z(50, 1.0f, 0.0f);
        this.f18697o = valueAnimatorZ;
        valueAnimatorZ.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f18693k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(@m0 EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z7) {
        if (this.f18692j != z7) {
            this.f18692j = z7;
            this.f18698p.cancel();
            this.f18697o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@m0 AutoCompleteTextView autoCompleteTextView) {
        if (f18683q) {
            int boxBackgroundMode = this.f18714a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f18695m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f18694l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(@m0 AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f18687e);
        if (f18683q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@o0 AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f18691i = false;
        }
        if (this.f18691i) {
            this.f18691i = false;
            return;
        }
        if (f18683q) {
            E(!this.f18692j);
        } else {
            this.f18692j = !this.f18692j;
            this.f18716c.toggle();
        }
        if (!this.f18692j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@m0 AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f18714a.getBoxBackgroundMode();
        com.google.android.material.shape.j boxBackground = this.f18714a.getBoxBackground();
        int iD = k1.a.d(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(autoCompleteTextView, iD, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(autoCompleteTextView, iD, iArr, boxBackground);
        }
    }

    private void w(@m0 AutoCompleteTextView autoCompleteTextView, int i7, int[][] iArr, @m0 com.google.android.material.shape.j jVar) {
        int boxBackgroundColor = this.f18714a.getBoxBackgroundColor();
        int[] iArr2 = {k1.a.h(i7, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f18683q) {
            n2.I1(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), jVar, jVar));
            return;
        }
        com.google.android.material.shape.j jVar2 = new com.google.android.material.shape.j(jVar.getShapeAppearanceModel());
        jVar2.n0(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar, jVar2});
        int iK0 = n2.k0(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iJ0 = n2.j0(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        n2.I1(autoCompleteTextView, layerDrawable);
        n2.d2(autoCompleteTextView, iK0, paddingTop, iJ0, paddingBottom);
    }

    private void x(@m0 AutoCompleteTextView autoCompleteTextView, int i7, int[][] iArr, @m0 com.google.android.material.shape.j jVar) {
        LayerDrawable layerDrawable;
        int iD = k1.a.d(autoCompleteTextView, R.attr.colorSurface);
        com.google.android.material.shape.j jVar2 = new com.google.android.material.shape.j(jVar.getShapeAppearanceModel());
        int iH = k1.a.h(i7, iD, 0.1f);
        jVar2.n0(new ColorStateList(iArr, new int[]{iH, 0}));
        if (f18683q) {
            jVar2.setTint(iD);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iH, iD});
            com.google.android.material.shape.j jVar3 = new com.google.android.material.shape.j(jVar.getShapeAppearanceModel());
            jVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar2, jVar3), jVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar});
        }
        n2.I1(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i7, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16846a);
        valueAnimatorOfFloat.setDuration(i7);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        float dimensionPixelOffset = this.f18715b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f18715b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f18715b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.shape.j jVarA = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.shape.j jVarA2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f18695m = jVarA;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f18694l = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, jVarA);
        this.f18694l.addState(new int[0], jVarA2);
        this.f18714a.setEndIconDrawable(e.a.b(this.f18715b, f18683q ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f18714a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f18714a.setEndIconOnClickListener(new g());
        this.f18714a.e(this.f18689g);
        this.f18714a.f(this.f18690h);
        B();
        this.f18696n = (AccessibilityManager) this.f18715b.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i7) {
        return i7 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return true;
    }
}
