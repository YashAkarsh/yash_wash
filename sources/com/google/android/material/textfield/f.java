package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.n2;
import androidx.core.widget.u;
import c.b1;
import c.l;
import c.m0;
import c.o0;
import c.p;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class f {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f18717v = 217;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f18718w = 167;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f18719x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f18720y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f18721z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f18722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final TextInputLayout f18723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f18724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f18726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private Animator f18727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f18728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private CharSequence f18731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private TextView f18733l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private CharSequence f18734m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18735n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private ColorStateList f18736o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f18737p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18738q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private TextView f18739r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f18740s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @o0
    private ColorStateList f18741t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Typeface f18742u;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f18744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f18745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f18746d;

        a(int i7, TextView textView, int i8, TextView textView2) {
            this.f18743a = i7;
            this.f18744b = textView;
            this.f18745c = i8;
            this.f18746d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f18729h = this.f18743a;
            f.this.f18727f = null;
            TextView textView = this.f18744b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f18745c == 1 && f.this.f18733l != null) {
                    f.this.f18733l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f18746d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f18746d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f18746d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(@m0 TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f18722a = context;
        this.f18723b = textInputLayout;
        this.f18728g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private boolean A(int i7) {
        return (i7 != 2 || this.f18739r == null || TextUtils.isEmpty(this.f18737p)) ? false : true;
    }

    private void F(int i7, int i8) {
        TextView textViewM;
        TextView textViewM2;
        if (i7 == i8) {
            return;
        }
        if (i8 != 0 && (textViewM2 = m(i8)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i7 != 0 && (textViewM = m(i7)) != null) {
            textViewM.setVisibility(4);
            if (i7 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f18729h = i8;
    }

    private void N(@o0 TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void P(@m0 ViewGroup viewGroup, int i7) {
        if (i7 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean Q(@o0 TextView textView, @o0 CharSequence charSequence) {
        return n2.U0(this.f18723b) && this.f18723b.isEnabled() && !(this.f18730i == this.f18729h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void T(int i7, int i8, boolean z7) {
        if (i7 == i8) {
            return;
        }
        if (z7) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f18727f = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f18738q, this.f18739r, 2, i7, i8);
            h(arrayList, this.f18732k, this.f18733l, 1, i7, i8);
            com.google.android.material.animation.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i8, m(i7), i7, m(i8)));
            animatorSet.start();
        } else {
            F(i7, i8);
        }
        this.f18723b.H0();
        this.f18723b.K0(z7);
        this.f18723b.U0();
    }

    private boolean f() {
        return (this.f18724c == null || this.f18723b.getEditText() == null) ? false : true;
    }

    private void h(@m0 List<Animator> list, boolean z7, @o0 TextView textView, int i7, int i8, int i9) {
        if (textView == null || !z7) {
            return;
        }
        if (i7 == i9 || i7 == i8) {
            list.add(i(textView, i9 == i7));
            if (i9 == i7) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z7) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z7 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16846a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f18728g, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16849d);
        return objectAnimatorOfFloat;
    }

    @o0
    private TextView m(int i7) {
        if (i7 == 1) {
            return this.f18733l;
        }
        if (i7 != 2) {
            return null;
        }
        return this.f18739r;
    }

    private int u(boolean z7, @p int i7, int i8) {
        return z7 ? this.f18722a.getResources().getDimensionPixelSize(i7) : i8;
    }

    private boolean z(int i7) {
        return (i7 != 1 || this.f18733l == null || TextUtils.isEmpty(this.f18731j)) ? false : true;
    }

    boolean B(int i7) {
        return i7 == 0 || i7 == 1;
    }

    boolean C() {
        return this.f18732k;
    }

    boolean D() {
        return this.f18738q;
    }

    void E(TextView textView, int i7) {
        FrameLayout frameLayout;
        if (this.f18724c == null) {
            return;
        }
        if (!B(i7) || (frameLayout = this.f18726e) == null) {
            this.f18724c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i8 = this.f18725d - 1;
        this.f18725d = i8;
        P(this.f18724c, i8);
    }

    void G(@o0 CharSequence charSequence) {
        this.f18734m = charSequence;
        TextView textView = this.f18733l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void H(boolean z7) {
        if (this.f18732k == z7) {
            return;
        }
        g();
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f18722a);
            this.f18733l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            this.f18733l.setTextAlignment(5);
            Typeface typeface = this.f18742u;
            if (typeface != null) {
                this.f18733l.setTypeface(typeface);
            }
            I(this.f18735n);
            J(this.f18736o);
            G(this.f18734m);
            this.f18733l.setVisibility(4);
            n2.D1(this.f18733l, 1);
            d(this.f18733l, 0);
        } else {
            x();
            E(this.f18733l, 0);
            this.f18733l = null;
            this.f18723b.H0();
            this.f18723b.U0();
        }
        this.f18732k = z7;
    }

    void I(@b1 int i7) {
        this.f18735n = i7;
        TextView textView = this.f18733l;
        if (textView != null) {
            this.f18723b.t0(textView, i7);
        }
    }

    void J(@o0 ColorStateList colorStateList) {
        this.f18736o = colorStateList;
        TextView textView = this.f18733l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void K(@b1 int i7) {
        this.f18740s = i7;
        TextView textView = this.f18739r;
        if (textView != null) {
            u.E(textView, i7);
        }
    }

    void L(boolean z7) {
        if (this.f18738q == z7) {
            return;
        }
        g();
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f18722a);
            this.f18739r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            this.f18739r.setTextAlignment(5);
            Typeface typeface = this.f18742u;
            if (typeface != null) {
                this.f18739r.setTypeface(typeface);
            }
            this.f18739r.setVisibility(4);
            n2.D1(this.f18739r, 1);
            K(this.f18740s);
            M(this.f18741t);
            d(this.f18739r, 1);
        } else {
            y();
            E(this.f18739r, 1);
            this.f18739r = null;
            this.f18723b.H0();
            this.f18723b.U0();
        }
        this.f18738q = z7;
    }

    void M(@o0 ColorStateList colorStateList) {
        this.f18741t = colorStateList;
        TextView textView = this.f18739r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void O(Typeface typeface) {
        if (typeface != this.f18742u) {
            this.f18742u = typeface;
            N(this.f18733l, typeface);
            N(this.f18739r, typeface);
        }
    }

    void R(CharSequence charSequence) {
        g();
        this.f18731j = charSequence;
        this.f18733l.setText(charSequence);
        int i7 = this.f18729h;
        if (i7 != 1) {
            this.f18730i = 1;
        }
        T(i7, this.f18730i, Q(this.f18733l, charSequence));
    }

    void S(CharSequence charSequence) {
        g();
        this.f18737p = charSequence;
        this.f18739r.setText(charSequence);
        int i7 = this.f18729h;
        if (i7 != 2) {
            this.f18730i = 2;
        }
        T(i7, this.f18730i, Q(this.f18739r, charSequence));
    }

    void d(TextView textView, int i7) {
        if (this.f18724c == null && this.f18726e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f18722a);
            this.f18724c = linearLayout;
            linearLayout.setOrientation(0);
            this.f18723b.addView(this.f18724c, -1, -2);
            this.f18726e = new FrameLayout(this.f18722a);
            this.f18724c.addView(this.f18726e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f18723b.getEditText() != null) {
                e();
            }
        }
        if (B(i7)) {
            this.f18726e.setVisibility(0);
            this.f18726e.addView(textView);
        } else {
            this.f18724c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f18724c.setVisibility(0);
        this.f18725d++;
    }

    void e() {
        if (f()) {
            EditText editText = this.f18723b.getEditText();
            boolean zG = com.google.android.material.resources.c.g(this.f18722a);
            n2.d2(this.f18724c, u(zG, R.dimen.material_helper_text_font_1_3_padding_horizontal, n2.k0(editText)), u(zG, R.dimen.material_helper_text_font_1_3_padding_top, this.f18722a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), u(zG, R.dimen.material_helper_text_font_1_3_padding_horizontal, n2.j0(editText)), 0);
        }
    }

    void g() {
        Animator animator = this.f18727f;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean k() {
        return z(this.f18729h);
    }

    boolean l() {
        return z(this.f18730i);
    }

    @o0
    CharSequence n() {
        return this.f18734m;
    }

    @o0
    CharSequence o() {
        return this.f18731j;
    }

    @l
    int p() {
        TextView textView = this.f18733l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @o0
    ColorStateList q() {
        TextView textView = this.f18733l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence r() {
        return this.f18737p;
    }

    @o0
    ColorStateList s() {
        TextView textView = this.f18739r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @l
    int t() {
        TextView textView = this.f18739r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    boolean v() {
        return A(this.f18729h);
    }

    boolean w() {
        return A(this.f18730i);
    }

    void x() {
        this.f18731j = null;
        g();
        if (this.f18729h == 1) {
            if (!this.f18738q || TextUtils.isEmpty(this.f18737p)) {
                this.f18730i = 0;
            } else {
                this.f18730i = 2;
            }
        }
        T(this.f18729h, this.f18730i, Q(this.f18733l, null));
    }

    void y() {
        g();
        int i7 = this.f18729h;
        if (i7 == 2) {
            this.f18730i = 0;
        }
        T(i7, this.f18730i, Q(this.f18739r, null));
    }
}
