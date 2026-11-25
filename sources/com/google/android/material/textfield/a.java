package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
class a extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18663j = 100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f18664k = 150;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f18665l = 0.8f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f18667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.h f18668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.i f18669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AnimatorSet f18670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ValueAnimator f18671i;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    class C0206a implements TextWatcher {
        C0206a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@m0 Editable editable) {
            if (a.this.f18714a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.f18714a.hasFocus() && a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            a.this.i((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z7);
        }
    }

    class c implements TextInputLayout.h {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@m0 TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f18667e);
            editText.removeTextChangedListener(a.this.f18666d);
            editText.addTextChangedListener(a.this.f18666d);
        }
    }

    class d implements TextInputLayout.i {

        /* JADX INFO: renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        class RunnableC0207a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ EditText f18676a;

            RunnableC0207a(EditText editText) {
                this.f18676a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18676a.removeTextChangedListener(a.this.f18666d);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@m0 TextInputLayout textInputLayout, int i7) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i7 != 2) {
                return;
            }
            editText.post(new RunnableC0207a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f18667e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f18714a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f18714a.i0();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f18714a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f18714a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            a.this.f18716c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f18716c.setScaleX(fFloatValue);
            a.this.f18716c.setScaleY(fFloatValue);
        }
    }

    a(@m0 TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18666d = new C0206a();
        this.f18667e = new b();
        this.f18668f = new c();
        this.f18669g = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z7) {
        boolean z8 = this.f18714a.P() == z7;
        if (z7 && !this.f18670h.isRunning()) {
            this.f18671i.cancel();
            this.f18670h.start();
            if (z8) {
                this.f18670h.end();
                return;
            }
            return;
        }
        if (z7) {
            return;
        }
        this.f18670h.cancel();
        this.f18671i.start();
        if (z8) {
            this.f18671i.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16846a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f18665l, 1.0f);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16849d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(@m0 Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator valueAnimatorK = k();
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f18670h = animatorSet;
        animatorSet.playTogether(valueAnimatorK, valueAnimatorJ);
        this.f18670h.addListener(new f());
        ValueAnimator valueAnimatorJ2 = j(1.0f, 0.0f);
        this.f18671i = valueAnimatorJ2;
        valueAnimatorJ2.addListener(new g());
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f18714a.setEndIconDrawable(e.a.b(this.f18715b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f18714a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f18714a.setEndIconOnClickListener(new e());
        this.f18714a.e(this.f18668f);
        this.f18714a.f(this.f18669g);
        m();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z7) {
        if (this.f18714a.getSuffixText() == null) {
            return;
        }
        i(z7);
    }
}
