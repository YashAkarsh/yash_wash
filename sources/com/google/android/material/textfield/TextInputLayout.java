package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.k0;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.s0;
import androidx.core.widget.u;
import androidx.customview.view.AbsSavedState;
import c.a1;
import c.b1;
import c.g1;
import c.l;
import c.m0;
import c.n;
import c.o0;
import c.p;
import c.r0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.chromium.net.v;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static final int f18601m1 = R.style.Widget_Design_TextInputLayout;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final int f18602n1 = 167;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private static final int f18603o1 = -1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int f18604p1 = -1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private static final String f18605q1 = "TextInputLayout";

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f18606r1 = 0;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f18607s1 = 1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f18608t1 = 2;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f18609u1 = -1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f18610v1 = 0;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f18611w1 = 1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f18612x1 = 2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f18613y1 = 3;
    private boolean A;
    private boolean A0;
    private CharSequence B;

    @o0
    private Drawable B0;
    private boolean C;
    private int C0;

    @o0
    private com.google.android.material.shape.j D;
    private View.OnLongClickListener D0;

    @o0
    private com.google.android.material.shape.j E;
    private final LinkedHashSet<h> E0;

    @m0
    private o F;
    private int F0;
    private final int G;
    private final SparseArray<com.google.android.material.textfield.e> G0;
    private int H;

    @m0
    private final CheckableImageButton H0;
    private int I;
    private final LinkedHashSet<i> I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f18614J;
    private ColorStateList J0;
    private int K;
    private boolean K0;
    private int L;
    private PorterDuff.Mode L0;
    private int M;
    private boolean M0;

    @l
    private int N;

    @o0
    private Drawable N0;

    @l
    private int O;
    private int O0;
    private final Rect P;
    private Drawable P0;
    private final Rect Q;
    private View.OnLongClickListener Q0;
    private final RectF R;
    private View.OnLongClickListener R0;
    private Typeface S;

    @m0
    private final CheckableImageButton S0;

    @m0
    private final CheckableImageButton T;
    private ColorStateList T0;
    private ColorStateList U;
    private ColorStateList U0;
    private boolean V;
    private ColorStateList V0;
    private PorterDuff.Mode W;

    @l
    private int W0;

    @l
    private int X0;

    @l
    private int Y0;
    private ColorStateList Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final FrameLayout f18615a;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    @l
    private int f18616a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final LinearLayout f18617b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    @l
    private int f18618b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final LinearLayout f18619c;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    @l
    private int f18620c1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final FrameLayout f18621d;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    @l
    private int f18622d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    EditText f18623e;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    @l
    private int f18624e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f18625f;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private boolean f18626f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18627g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    final com.google.android.material.internal.a f18628g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18629h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private boolean f18630h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.material.textfield.f f18631i;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private boolean f18632i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f18633j;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private ValueAnimator f18634j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18635k;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private boolean f18636k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18637l;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private boolean f18638l1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private TextView f18639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f18642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f18644r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private ColorStateList f18645s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f18646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @o0
    private ColorStateList f18647u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @o0
    private ColorStateList f18648v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @o0
    private CharSequence f18649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @m0
    private final TextView f18650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @o0
    private CharSequence f18651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @m0
    private final TextView f18652z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        CharSequence f18653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f18654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        CharSequence f18655e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        CharSequence f18656f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        CharSequence f18657g;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @o0
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @m0
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f18653c) + " hint=" + ((Object) this.f18655e) + " helperText=" + ((Object) this.f18656f) + " placeholderText=" + ((Object) this.f18657g) + com.alipay.sdk.util.j.f13808d;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            TextUtils.writeToParcel(this.f18653c, parcel, i7);
            parcel.writeInt(this.f18654d ? 1 : 0);
            TextUtils.writeToParcel(this.f18655e, parcel, i7);
            TextUtils.writeToParcel(this.f18656f, parcel, i7);
            TextUtils.writeToParcel(this.f18657g, parcel, i7);
        }

        SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18653c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f18654d = parcel.readInt() == 1;
            this.f18655e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f18656f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f18657g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@m0 Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.K0(!textInputLayout.f18638l1);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f18633j) {
                textInputLayout2.C0(editable.length());
            }
            if (TextInputLayout.this.f18643q) {
                TextInputLayout.this.O0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.H0.performClick();
            TextInputLayout.this.H0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f18623e.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            TextInputLayout.this.f18628g1.u0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f18662d;

        public e(@m0 TextInputLayout textInputLayout) {
            this.f18662d = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void g(@m0 View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            EditText editText = this.f18662d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f18662d.getHint();
            CharSequence error = this.f18662d.getError();
            CharSequence placeholderText = this.f18662d.getPlaceholderText();
            int counterMaxLength = this.f18662d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f18662d.getCounterOverflowDescription();
            boolean z7 = !TextUtils.isEmpty(text);
            boolean z8 = !TextUtils.isEmpty(hint);
            boolean z9 = !this.f18662d.X();
            boolean z10 = !TextUtils.isEmpty(error);
            boolean z11 = z10 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z8 ? hint.toString() : "";
            if (z7) {
                l0Var.L1(text);
            } else if (!TextUtils.isEmpty(string)) {
                l0Var.L1(string);
                if (z9 && placeholderText != null) {
                    l0Var.L1(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                l0Var.L1(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    l0Var.l1(string);
                } else {
                    if (z7) {
                        string = ((Object) text) + ", " + string;
                    }
                    l0Var.L1(string);
                }
                l0Var.H1(!z7);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            l0Var.u1(counterMaxLength);
            if (z11) {
                if (!z10) {
                    error = counterOverflowDescription;
                }
                l0Var.h1(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    public interface h {
        void a(@m0 TextInputLayout textInputLayout);
    }

    public interface i {
        void a(@m0 TextInputLayout textInputLayout, int i7);
    }

    public TextInputLayout(@m0 Context context) {
        this(context, null);
    }

    private void A() {
        if (C()) {
            ((com.google.android.material.textfield.c) this.D).R0();
        }
    }

    private void A0(@m0 Rect rect) {
        com.google.android.material.shape.j jVar = this.E;
        if (jVar != null) {
            int i7 = rect.bottom;
            jVar.setBounds(rect.left, i7 - this.M, rect.right, i7);
        }
    }

    private void B(boolean z7) {
        ValueAnimator valueAnimator = this.f18634j1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f18634j1.cancel();
        }
        if (z7 && this.f18632i1) {
            i(1.0f);
        } else {
            this.f18628g1.u0(1.0f);
        }
        this.f18626f1 = false;
        if (C()) {
            f0();
        }
        N0();
        Q0();
        T0();
    }

    private void B0() {
        if (this.f18639m != null) {
            EditText editText = this.f18623e;
            C0(editText == null ? 0 : editText.getText().length());
        }
    }

    private boolean C() {
        return this.A && !TextUtils.isEmpty(this.B) && (this.D instanceof com.google.android.material.textfield.c);
    }

    private static void D0(@m0 Context context, @m0 TextView textView, int i7, int i8, boolean z7) {
        textView.setContentDescription(context.getString(z7 ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    private void E() {
        Iterator<h> it = this.E0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void E0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f18639m;
        if (textView != null) {
            t0(textView, this.f18637l ? this.f18640n : this.f18641o);
            if (!this.f18637l && (colorStateList2 = this.f18647u) != null) {
                this.f18639m.setTextColor(colorStateList2);
            }
            if (!this.f18637l || (colorStateList = this.f18648v) == null) {
                return;
            }
            this.f18639m.setTextColor(colorStateList);
        }
    }

    private void F(int i7) {
        Iterator<i> it = this.I0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i7);
        }
    }

    private void F0() {
        if (!C() || this.f18626f1 || this.H == this.K) {
            return;
        }
        A();
        f0();
    }

    private void G(Canvas canvas) {
        com.google.android.material.shape.j jVar = this.E;
        if (jVar != null) {
            Rect bounds = jVar.getBounds();
            bounds.top = bounds.bottom - this.K;
            this.E.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    private boolean G0() {
        boolean z7;
        if (this.f18623e == null) {
            return false;
        }
        boolean z8 = true;
        if (v0()) {
            int measuredWidth = this.f18617b.getMeasuredWidth() - this.f18623e.getPaddingLeft();
            if (this.B0 == null || this.C0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.B0 = colorDrawable;
                this.C0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrH = u.h(this.f18623e);
            Drawable drawable = drawableArrH[0];
            Drawable drawable2 = this.B0;
            if (drawable != drawable2) {
                u.w(this.f18623e, drawable2, drawableArrH[1], drawableArrH[2], drawableArrH[3]);
                z7 = true;
            } else {
                z7 = false;
            }
        } else if (this.B0 != null) {
            Drawable[] drawableArrH2 = u.h(this.f18623e);
            u.w(this.f18623e, null, drawableArrH2[1], drawableArrH2[2], drawableArrH2[3]);
            this.B0 = null;
            z7 = true;
        } else {
            z7 = false;
        }
        if (u0()) {
            int measuredWidth2 = this.f18652z.getMeasuredWidth() - this.f18623e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + s0.c((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrH3 = u.h(this.f18623e);
            Drawable drawable3 = this.N0;
            if (drawable3 == null || this.O0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.N0 = colorDrawable2;
                    this.O0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrH3[2];
                Drawable drawable5 = this.N0;
                if (drawable4 != drawable5) {
                    this.P0 = drawable4;
                    u.w(this.f18623e, drawableArrH3[0], drawableArrH3[1], drawable5, drawableArrH3[3]);
                } else {
                    z8 = z7;
                }
            } else {
                this.O0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                u.w(this.f18623e, drawableArrH3[0], drawableArrH3[1], this.N0, drawableArrH3[3]);
            }
        } else {
            if (this.N0 == null) {
                return z7;
            }
            Drawable[] drawableArrH4 = u.h(this.f18623e);
            if (drawableArrH4[2] == this.N0) {
                u.w(this.f18623e, drawableArrH4[0], drawableArrH4[1], this.P0, drawableArrH4[3]);
            } else {
                z8 = z7;
            }
            this.N0 = null;
        }
        return z8;
    }

    private void H(@m0 Canvas canvas) {
        if (this.A) {
            this.f18628g1.m(canvas);
        }
    }

    private void I(boolean z7) {
        ValueAnimator valueAnimator = this.f18634j1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f18634j1.cancel();
        }
        if (z7 && this.f18632i1) {
            i(0.0f);
        } else {
            this.f18628g1.u0(0.0f);
        }
        if (C() && ((com.google.android.material.textfield.c) this.D).O0()) {
            A();
        }
        this.f18626f1 = true;
        M();
        Q0();
        T0();
    }

    private boolean I0() {
        int iMax;
        if (this.f18623e == null || this.f18623e.getMeasuredHeight() >= (iMax = Math.max(this.f18619c.getMeasuredHeight(), this.f18617b.getMeasuredHeight()))) {
            return false;
        }
        this.f18623e.setMinimumHeight(iMax);
        return true;
    }

    private int J(int i7, boolean z7) {
        int compoundPaddingLeft = i7 + this.f18623e.getCompoundPaddingLeft();
        return (this.f18649w == null || z7) ? compoundPaddingLeft : (compoundPaddingLeft - this.f18650x.getMeasuredWidth()) + this.f18650x.getPaddingLeft();
    }

    private void J0() {
        if (this.I != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f18615a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.f18615a.requestLayout();
            }
        }
    }

    private int K(int i7, boolean z7) {
        int compoundPaddingRight = i7 - this.f18623e.getCompoundPaddingRight();
        return (this.f18649w == null || !z7) ? compoundPaddingRight : compoundPaddingRight + (this.f18650x.getMeasuredWidth() - this.f18650x.getPaddingRight());
    }

    private boolean L() {
        return this.F0 != 0;
    }

    private void L0(boolean z7, boolean z8) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f18623e;
        boolean z9 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f18623e;
        boolean z10 = editText2 != null && editText2.hasFocus();
        boolean zL = this.f18631i.l();
        ColorStateList colorStateList2 = this.U0;
        if (colorStateList2 != null) {
            this.f18628g1.f0(colorStateList2);
            this.f18628g1.p0(this.U0);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.U0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f18624e1) : this.f18624e1;
            this.f18628g1.f0(ColorStateList.valueOf(colorForState));
            this.f18628g1.p0(ColorStateList.valueOf(colorForState));
        } else if (zL) {
            this.f18628g1.f0(this.f18631i.q());
        } else if (this.f18637l && (textView = this.f18639m) != null) {
            this.f18628g1.f0(textView.getTextColors());
        } else if (z10 && (colorStateList = this.V0) != null) {
            this.f18628g1.f0(colorStateList);
        }
        if (z9 || !this.f18630h1 || (isEnabled() && z10)) {
            if (z8 || this.f18626f1) {
                B(z7);
                return;
            }
            return;
        }
        if (z8 || !this.f18626f1) {
            I(z7);
        }
    }

    private void M() {
        TextView textView = this.f18644r;
        if (textView == null || !this.f18643q) {
            return;
        }
        textView.setText((CharSequence) null);
        this.f18644r.setVisibility(4);
    }

    private void M0() {
        EditText editText;
        if (this.f18644r == null || (editText = this.f18623e) == null) {
            return;
        }
        this.f18644r.setGravity(editText.getGravity());
        this.f18644r.setPadding(this.f18623e.getCompoundPaddingLeft(), this.f18623e.getCompoundPaddingTop(), this.f18623e.getCompoundPaddingRight(), this.f18623e.getCompoundPaddingBottom());
    }

    private void N0() {
        EditText editText = this.f18623e;
        O0(editText == null ? 0 : editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i7) {
        if (i7 != 0 || this.f18626f1) {
            M();
        } else {
            x0();
        }
    }

    private void P0() {
        if (this.f18623e == null) {
            return;
        }
        n2.d2(this.f18650x, c0() ? 0 : n2.k0(this.f18623e), this.f18623e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f18623e.getCompoundPaddingBottom());
    }

    private void Q0() {
        this.f18650x.setVisibility((this.f18649w == null || X()) ? 8 : 0);
        G0();
    }

    private boolean R() {
        return this.S0.getVisibility() == 0;
    }

    private void R0(boolean z7, boolean z8) {
        int defaultColor = this.Z0.getDefaultColor();
        int colorForState = this.Z0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.Z0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z7) {
            this.N = colorForState2;
        } else if (z8) {
            this.N = colorForState;
        } else {
            this.N = defaultColor;
        }
    }

    private void S0() {
        if (this.f18623e == null) {
            return;
        }
        n2.d2(this.f18652z, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f18623e.getPaddingTop(), (P() || R()) ? 0 : n2.j0(this.f18623e), this.f18623e.getPaddingBottom());
    }

    private void T0() {
        int visibility = this.f18652z.getVisibility();
        boolean z7 = (this.f18651y == null || X()) ? false : true;
        this.f18652z.setVisibility(z7 ? 0 : 8);
        if (visibility != this.f18652z.getVisibility()) {
            getEndIconDelegate().c(z7);
        }
        G0();
    }

    private boolean a0() {
        return this.I == 1 && this.f18623e.getMinLines() <= 1;
    }

    private int[] d0(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    private void e0() {
        p();
        p0();
        U0();
        z0();
        h();
        if (this.I != 0) {
            J0();
        }
    }

    private void f0() {
        if (C()) {
            RectF rectF = this.R;
            this.f18628g1.p(rectF, this.f18623e.getWidth(), this.f18623e.getGravity());
            l(rectF);
            int i7 = this.K;
            this.H = i7;
            rectF.top = 0.0f;
            rectF.bottom = i7;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.c) this.D).U0(rectF);
        }
    }

    private void g() {
        TextView textView = this.f18644r;
        if (textView != null) {
            this.f18615a.addView(textView);
            this.f18644r.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.G0.get(this.F0);
        return eVar != null ? eVar : this.G0.get(0);
    }

    @o0
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.S0.getVisibility() == 0) {
            return this.S0;
        }
        if (L() && P()) {
            return this.H0;
        }
        return null;
    }

    private void h() {
        if (this.f18623e == null || this.I != 1) {
            return;
        }
        if (com.google.android.material.resources.c.h(getContext())) {
            EditText editText = this.f18623e;
            n2.d2(editText, n2.k0(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), n2.j0(this.f18623e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (com.google.android.material.resources.c.g(getContext())) {
            EditText editText2 = this.f18623e;
            n2.d2(editText2, n2.k0(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), n2.j0(this.f18623e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private static void h0(@m0 ViewGroup viewGroup, boolean z7) {
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            childAt.setEnabled(z7);
            if (childAt instanceof ViewGroup) {
                h0((ViewGroup) childAt, z7);
            }
        }
    }

    private void j() {
        com.google.android.material.shape.j jVar = this.D;
        if (jVar == null) {
            return;
        }
        jVar.setShapeAppearanceModel(this.F);
        if (w()) {
            this.D.C0(this.K, this.N);
        }
        int iQ = q();
        this.O = iQ;
        this.D.n0(ColorStateList.valueOf(iQ));
        if (this.F0 == 3) {
            this.f18623e.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    private void k() {
        if (this.E == null) {
            return;
        }
        if (x()) {
            this.E.n0(ColorStateList.valueOf(this.N));
        }
        invalidate();
    }

    private void k0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(d0(checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = androidx.core.graphics.drawable.d.r(drawable).mutate();
        androidx.core.graphics.drawable.d.o(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private void l(@m0 RectF rectF) {
        float f8 = rectF.left;
        int i7 = this.G;
        rectF.left = f8 - i7;
        rectF.right += i7;
    }

    private void m() {
        n(this.H0, this.K0, this.J0, this.M0, this.L0);
    }

    private void n(@m0 CheckableImageButton checkableImageButton, boolean z7, ColorStateList colorStateList, boolean z8, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z7 || z8)) {
            drawable = androidx.core.graphics.drawable.d.r(drawable).mutate();
            if (z7) {
                androidx.core.graphics.drawable.d.o(drawable, colorStateList);
            }
            if (z8) {
                androidx.core.graphics.drawable.d.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void o() {
        n(this.T, this.V, this.U, this.A0, this.W);
    }

    private void o0() {
        TextView textView = this.f18644r;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void p() {
        int i7 = this.I;
        if (i7 == 0) {
            this.D = null;
            this.E = null;
            return;
        }
        if (i7 == 1) {
            this.D = new com.google.android.material.shape.j(this.F);
            this.E = new com.google.android.material.shape.j();
        } else {
            if (i7 != 2) {
                throw new IllegalArgumentException(this.I + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.A || (this.D instanceof com.google.android.material.textfield.c)) {
                this.D = new com.google.android.material.shape.j(this.F);
            } else {
                this.D = new com.google.android.material.textfield.c(this.F);
            }
            this.E = null;
        }
    }

    private void p0() {
        if (w0()) {
            n2.I1(this.f18623e, this.D);
        }
    }

    private int q() {
        return this.I == 1 ? k1.a.g(k1.a.e(this, R.attr.colorSurface, 0), this.O) : this.O;
    }

    private static void q0(@m0 CheckableImageButton checkableImageButton, @o0 View.OnLongClickListener onLongClickListener) {
        boolean zK0 = n2.K0(checkableImageButton);
        boolean z7 = onLongClickListener != null;
        boolean z8 = zK0 || z7;
        checkableImageButton.setFocusable(z8);
        checkableImageButton.setClickable(zK0);
        checkableImageButton.setPressable(zK0);
        checkableImageButton.setLongClickable(z7);
        n2.R1(checkableImageButton, z8 ? 1 : 2);
    }

    @m0
    private Rect r(@m0 Rect rect) {
        if (this.f18623e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.Q;
        boolean z7 = n2.Z(this) == 1;
        rect2.bottom = rect.bottom;
        int i7 = this.I;
        if (i7 == 1) {
            rect2.left = J(rect.left, z7);
            rect2.top = rect.top + this.f18614J;
            rect2.right = K(rect.right, z7);
            return rect2;
        }
        if (i7 != 2) {
            rect2.left = J(rect.left, z7);
            rect2.top = getPaddingTop();
            rect2.right = K(rect.right, z7);
            return rect2;
        }
        rect2.left = rect.left + this.f18623e.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.f18623e.getPaddingRight();
        return rect2;
    }

    private static void r0(@m0 CheckableImageButton checkableImageButton, @o0 View.OnClickListener onClickListener, @o0 View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        q0(checkableImageButton, onLongClickListener);
    }

    private int s(@m0 Rect rect, @m0 Rect rect2, float f8) {
        return a0() ? (int) (rect2.top + f8) : rect.bottom - this.f18623e.getCompoundPaddingBottom();
    }

    private static void s0(@m0 CheckableImageButton checkableImageButton, @o0 View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q0(checkableImageButton, onLongClickListener);
    }

    private void setEditText(EditText editText) {
        if (this.f18623e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.F0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i(f18605q1, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f18623e = editText;
        setMinWidth(this.f18627g);
        setMaxWidth(this.f18629h);
        e0();
        setTextInputAccessibilityDelegate(new e(this));
        this.f18628g1.H0(this.f18623e.getTypeface());
        this.f18628g1.r0(this.f18623e.getTextSize());
        int gravity = this.f18623e.getGravity();
        this.f18628g1.g0((gravity & v.f39676w2) | 48);
        this.f18628g1.q0(gravity);
        this.f18623e.addTextChangedListener(new a());
        if (this.U0 == null) {
            this.U0 = this.f18623e.getHintTextColors();
        }
        if (this.A) {
            if (TextUtils.isEmpty(this.B)) {
                CharSequence hint = this.f18623e.getHint();
                this.f18625f = hint;
                setHint(hint);
                this.f18623e.setHint((CharSequence) null);
            }
            this.C = true;
        }
        if (this.f18639m != null) {
            C0(this.f18623e.getText().length());
        }
        H0();
        this.f18631i.e();
        this.f18617b.bringToFront();
        this.f18619c.bringToFront();
        this.f18621d.bringToFront();
        this.S0.bringToFront();
        E();
        P0();
        S0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        L0(false, true);
    }

    private void setErrorIconVisible(boolean z7) {
        this.S0.setVisibility(z7 ? 0 : 8);
        this.f18621d.setVisibility(z7 ? 8 : 0);
        S0();
        if (L()) {
            return;
        }
        G0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.B)) {
            return;
        }
        this.B = charSequence;
        this.f18628g1.F0(charSequence);
        if (this.f18626f1) {
            return;
        }
        f0();
    }

    private void setPlaceholderTextEnabled(boolean z7) {
        if (this.f18643q == z7) {
            return;
        }
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f18644r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            n2.D1(this.f18644r, 1);
            setPlaceholderTextAppearance(this.f18646t);
            setPlaceholderTextColor(this.f18645s);
            g();
        } else {
            o0();
            this.f18644r = null;
        }
        this.f18643q = z7;
    }

    private int t(@m0 Rect rect, float f8) {
        return a0() ? (int) (rect.centerY() - (f8 / 2.0f)) : rect.top + this.f18623e.getCompoundPaddingTop();
    }

    @m0
    private Rect u(@m0 Rect rect) {
        if (this.f18623e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.Q;
        float fD = this.f18628g1.D();
        rect2.left = rect.left + this.f18623e.getCompoundPaddingLeft();
        rect2.top = t(rect, fD);
        rect2.right = rect.right - this.f18623e.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fD);
        return rect2;
    }

    private boolean u0() {
        return (this.S0.getVisibility() == 0 || ((L() && P()) || this.f18651y != null)) && this.f18619c.getMeasuredWidth() > 0;
    }

    private int v() {
        float fS;
        if (!this.A) {
            return 0;
        }
        int i7 = this.I;
        if (i7 == 0 || i7 == 1) {
            fS = this.f18628g1.s();
        } else {
            if (i7 != 2) {
                return 0;
            }
            fS = this.f18628g1.s() / 2.0f;
        }
        return (int) fS;
    }

    private boolean v0() {
        return !(getStartIconDrawable() == null && this.f18649w == null) && this.f18617b.getMeasuredWidth() > 0;
    }

    private boolean w() {
        return this.I == 2 && x();
    }

    private boolean w0() {
        EditText editText = this.f18623e;
        return (editText == null || this.D == null || editText.getBackground() != null || this.I == 0) ? false : true;
    }

    private boolean x() {
        return this.K > -1 && this.N != 0;
    }

    private void x0() {
        TextView textView = this.f18644r;
        if (textView == null || !this.f18643q) {
            return;
        }
        textView.setText(this.f18642p);
        this.f18644r.setVisibility(0);
        this.f18644r.bringToFront();
    }

    private void y0(boolean z7) {
        if (!z7 || getEndIconDrawable() == null) {
            m();
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.d.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.d.n(drawableMutate, this.f18631i.p());
        this.H0.setImageDrawable(drawableMutate);
    }

    private void z0() {
        if (this.I == 1) {
            if (com.google.android.material.resources.c.h(getContext())) {
                this.f18614J = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (com.google.android.material.resources.c.g(getContext())) {
                this.f18614J = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    void C0(int i7) {
        boolean z7 = this.f18637l;
        int i8 = this.f18635k;
        if (i8 == -1) {
            this.f18639m.setText(String.valueOf(i7));
            this.f18639m.setContentDescription(null);
            this.f18637l = false;
        } else {
            this.f18637l = i7 > i8;
            D0(getContext(), this.f18639m, i7, this.f18635k, this.f18637l);
            if (z7 != this.f18637l) {
                E0();
            }
            this.f18639m.setText(androidx.core.text.a.c().q(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i7), Integer.valueOf(this.f18635k))));
        }
        if (this.f18623e == null || z7 == this.f18637l) {
            return;
        }
        K0(false);
        U0();
        H0();
    }

    @g1
    boolean D() {
        return C() && ((com.google.android.material.textfield.c) this.D).O0();
    }

    void H0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f18623e;
        if (editText == null || this.I != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (k0.a(background)) {
            background = background.mutate();
        }
        if (this.f18631i.l()) {
            background.setColorFilter(androidx.appcompat.widget.g.e(this.f18631i.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.f18637l && (textView = this.f18639m) != null) {
            background.setColorFilter(androidx.appcompat.widget.g.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.d.c(background);
            this.f18623e.refreshDrawableState();
        }
    }

    void K0(boolean z7) {
        L0(z7, false);
    }

    public boolean N() {
        return this.f18633j;
    }

    public boolean O() {
        return this.H0.a();
    }

    public boolean P() {
        return this.f18621d.getVisibility() == 0 && this.H0.getVisibility() == 0;
    }

    public boolean Q() {
        return this.f18631i.C();
    }

    public boolean S() {
        return this.f18630h1;
    }

    @g1
    final boolean T() {
        return this.f18631i.v();
    }

    public boolean U() {
        return this.f18631i.D();
    }

    void U0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.D == null || this.I == 0) {
            return;
        }
        boolean z7 = false;
        boolean z8 = isFocused() || ((editText2 = this.f18623e) != null && editText2.hasFocus());
        boolean z9 = isHovered() || ((editText = this.f18623e) != null && editText.isHovered());
        if (!isEnabled()) {
            this.N = this.f18624e1;
        } else if (this.f18631i.l()) {
            if (this.Z0 != null) {
                R0(z8, z9);
            } else {
                this.N = this.f18631i.p();
            }
        } else if (!this.f18637l || (textView = this.f18639m) == null) {
            if (z8) {
                this.N = this.Y0;
            } else if (z9) {
                this.N = this.X0;
            } else {
                this.N = this.W0;
            }
        } else if (this.Z0 != null) {
            R0(z8, z9);
        } else {
            this.N = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.f18631i.C() && this.f18631i.l()) {
            z7 = true;
        }
        setErrorIconVisible(z7);
        j0();
        l0();
        i0();
        if (getEndIconDelegate().d()) {
            y0(this.f18631i.l());
        }
        if (z8 && isEnabled()) {
            this.K = this.M;
        } else {
            this.K = this.L;
        }
        if (this.I == 2) {
            F0();
        }
        if (this.I == 1) {
            if (!isEnabled()) {
                this.O = this.f18618b1;
            } else if (z9 && !z8) {
                this.O = this.f18622d1;
            } else if (z8) {
                this.O = this.f18620c1;
            } else {
                this.O = this.f18616a1;
            }
        }
        j();
    }

    public boolean V() {
        return this.f18632i1;
    }

    public boolean W() {
        return this.A;
    }

    @g1
    final boolean X() {
        return this.f18626f1;
    }

    @Deprecated
    public boolean Y() {
        return this.F0 == 1;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean Z() {
        return this.C;
    }

    @Override // android.view.ViewGroup
    public void addView(@m0 View view, int i7, @m0 ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i7, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & v.f39676w2) | 16;
        this.f18615a.addView(view, layoutParams2);
        this.f18615a.setLayoutParams(layoutParams);
        J0();
        setEditText((EditText) view);
    }

    public boolean b0() {
        return this.T.a();
    }

    public boolean c0() {
        return this.T.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@m0 ViewStructure viewStructure, int i7) {
        EditText editText = this.f18623e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i7);
            return;
        }
        if (this.f18625f != null) {
            boolean z7 = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.f18623e.setHint(this.f18625f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i7);
                return;
            } finally {
                this.f18623e.setHint(hint);
                this.C = z7;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i7);
        onProvideAutofillVirtualStructure(viewStructure, i7);
        viewStructure.setChildCount(this.f18615a.getChildCount());
        for (int i8 = 0; i8 < this.f18615a.getChildCount(); i8++) {
            View childAt = this.f18615a.getChildAt(i8);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i8);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i7);
            if (childAt == this.f18623e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@m0 SparseArray<Parcelable> sparseArray) {
        this.f18638l1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f18638l1 = false;
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        super.draw(canvas);
        H(canvas);
        G(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f18636k1) {
            return;
        }
        this.f18636k1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.f18628g1;
        boolean zE0 = aVar != null ? aVar.E0(drawableState) | false : false;
        if (this.f18623e != null) {
            K0(n2.U0(this) && isEnabled());
        }
        H0();
        U0();
        if (zE0) {
            invalidate();
        }
        this.f18636k1 = false;
    }

    public void e(@m0 h hVar) {
        this.E0.add(hVar);
        if (this.f18623e != null) {
            hVar.a(this);
        }
    }

    public void f(@m0 i iVar) {
        this.I0.add(iVar);
    }

    @Deprecated
    public void g0(boolean z7) {
        if (this.F0 == 1) {
            this.H0.performClick();
            if (z7) {
                this.H0.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f18623e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    @m0
    com.google.android.material.shape.j getBoxBackground() {
        int i7 = this.I;
        if (i7 == 1 || i7 == 2) {
            return this.D;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.O;
    }

    public int getBoxBackgroundMode() {
        return this.I;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.D.t();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.D.u();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.D.S();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.D.R();
    }

    public int getBoxStrokeColor() {
        return this.Y0;
    }

    @o0
    public ColorStateList getBoxStrokeErrorColor() {
        return this.Z0;
    }

    public int getBoxStrokeWidth() {
        return this.L;
    }

    public int getBoxStrokeWidthFocused() {
        return this.M;
    }

    public int getCounterMaxLength() {
        return this.f18635k;
    }

    @o0
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f18633j && this.f18637l && (textView = this.f18639m) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @o0
    public ColorStateList getCounterOverflowTextColor() {
        return this.f18647u;
    }

    @o0
    public ColorStateList getCounterTextColor() {
        return this.f18647u;
    }

    @o0
    public ColorStateList getDefaultHintTextColor() {
        return this.U0;
    }

    @o0
    public EditText getEditText() {
        return this.f18623e;
    }

    @o0
    public CharSequence getEndIconContentDescription() {
        return this.H0.getContentDescription();
    }

    @o0
    public Drawable getEndIconDrawable() {
        return this.H0.getDrawable();
    }

    public int getEndIconMode() {
        return this.F0;
    }

    @m0
    CheckableImageButton getEndIconView() {
        return this.H0;
    }

    @o0
    public CharSequence getError() {
        if (this.f18631i.C()) {
            return this.f18631i.o();
        }
        return null;
    }

    @o0
    public CharSequence getErrorContentDescription() {
        return this.f18631i.n();
    }

    @l
    public int getErrorCurrentTextColors() {
        return this.f18631i.p();
    }

    @o0
    public Drawable getErrorIconDrawable() {
        return this.S0.getDrawable();
    }

    @g1
    final int getErrorTextCurrentColor() {
        return this.f18631i.p();
    }

    @o0
    public CharSequence getHelperText() {
        if (this.f18631i.D()) {
            return this.f18631i.r();
        }
        return null;
    }

    @l
    public int getHelperTextCurrentTextColor() {
        return this.f18631i.t();
    }

    @o0
    public CharSequence getHint() {
        if (this.A) {
            return this.B;
        }
        return null;
    }

    @g1
    final float getHintCollapsedTextHeight() {
        return this.f18628g1.s();
    }

    @g1
    final int getHintCurrentCollapsedTextColor() {
        return this.f18628g1.x();
    }

    @o0
    public ColorStateList getHintTextColor() {
        return this.V0;
    }

    @r0
    public int getMaxWidth() {
        return this.f18629h;
    }

    @r0
    public int getMinWidth() {
        return this.f18627g;
    }

    @o0
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.H0.getContentDescription();
    }

    @o0
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.H0.getDrawable();
    }

    @o0
    public CharSequence getPlaceholderText() {
        if (this.f18643q) {
            return this.f18642p;
        }
        return null;
    }

    @b1
    public int getPlaceholderTextAppearance() {
        return this.f18646t;
    }

    @o0
    public ColorStateList getPlaceholderTextColor() {
        return this.f18645s;
    }

    @o0
    public CharSequence getPrefixText() {
        return this.f18649w;
    }

    @o0
    public ColorStateList getPrefixTextColor() {
        return this.f18650x.getTextColors();
    }

    @m0
    public TextView getPrefixTextView() {
        return this.f18650x;
    }

    @o0
    public CharSequence getStartIconContentDescription() {
        return this.T.getContentDescription();
    }

    @o0
    public Drawable getStartIconDrawable() {
        return this.T.getDrawable();
    }

    @o0
    public CharSequence getSuffixText() {
        return this.f18651y;
    }

    @o0
    public ColorStateList getSuffixTextColor() {
        return this.f18652z.getTextColors();
    }

    @m0
    public TextView getSuffixTextView() {
        return this.f18652z;
    }

    @o0
    public Typeface getTypeface() {
        return this.S;
    }

    @g1
    void i(float f8) {
        if (this.f18628g1.G() == f8) {
            return;
        }
        if (this.f18634j1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f18634j1 = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.f16847b);
            this.f18634j1.setDuration(167L);
            this.f18634j1.addUpdateListener(new d());
        }
        this.f18634j1.setFloatValues(this.f18628g1.G(), f8);
        this.f18634j1.start();
    }

    public void i0() {
        k0(this.H0, this.J0);
    }

    public void j0() {
        k0(this.S0, this.T0);
    }

    public void l0() {
        k0(this.T, this.U);
    }

    public void m0(@m0 h hVar) {
        this.E0.remove(hVar);
    }

    public void n0(@m0 i iVar) {
        this.I0.remove(iVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        EditText editText = this.f18623e;
        if (editText != null) {
            Rect rect = this.P;
            com.google.android.material.internal.c.a(this, editText, rect);
            A0(rect);
            if (this.A) {
                this.f18628g1.r0(this.f18623e.getTextSize());
                int gravity = this.f18623e.getGravity();
                this.f18628g1.g0((gravity & v.f39676w2) | 48);
                this.f18628g1.q0(gravity);
                this.f18628g1.c0(r(rect));
                this.f18628g1.m0(u(rect));
                this.f18628g1.Y();
                if (!C() || this.f18626f1) {
                    return;
                }
                f0();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        boolean zI0 = I0();
        boolean zG0 = G0();
        if (zI0 || zG0) {
            this.f18623e.post(new c());
        }
        M0();
        P0();
        S0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@o0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f18653c);
        if (savedState.f18654d) {
            this.H0.post(new b());
        }
        setHint(savedState.f18655e);
        setHelperText(savedState.f18656f);
        setPlaceholderText(savedState.f18657g);
        requestLayout();
    }

    @Override // android.view.View
    @o0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f18631i.l()) {
            savedState.f18653c = getError();
        }
        savedState.f18654d = L() && this.H0.isChecked();
        savedState.f18655e = getHint();
        savedState.f18656f = getHelperText();
        savedState.f18657g = getPlaceholderText();
        return savedState;
    }

    public void setBoxBackgroundColor(@l int i7) {
        if (this.O != i7) {
            this.O = i7;
            this.f18616a1 = i7;
            this.f18620c1 = i7;
            this.f18622d1 = i7;
            j();
        }
    }

    public void setBoxBackgroundColorResource(@n int i7) {
        setBoxBackgroundColor(androidx.core.content.d.f(getContext(), i7));
    }

    public void setBoxBackgroundColorStateList(@m0 ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f18616a1 = defaultColor;
        this.O = defaultColor;
        this.f18618b1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f18620c1 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.f18622d1 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i7) {
        if (i7 == this.I) {
            return;
        }
        this.I = i7;
        if (this.f18623e != null) {
            e0();
        }
    }

    public void setBoxCornerRadii(float f8, float f9, float f10, float f11) {
        com.google.android.material.shape.j jVar = this.D;
        if (jVar != null && jVar.R() == f8 && this.D.S() == f9 && this.D.u() == f11 && this.D.t() == f10) {
            return;
        }
        this.F = this.F.v().K(f8).P(f9).C(f11).x(f10).m();
        j();
    }

    public void setBoxCornerRadiiResources(@p int i7, @p int i8, @p int i9, @p int i10) {
        setBoxCornerRadii(getContext().getResources().getDimension(i7), getContext().getResources().getDimension(i8), getContext().getResources().getDimension(i10), getContext().getResources().getDimension(i9));
    }

    public void setBoxStrokeColor(@l int i7) {
        if (this.Y0 != i7) {
            this.Y0 = i7;
            U0();
        }
    }

    public void setBoxStrokeColorStateList(@m0 ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.W0 = colorStateList.getDefaultColor();
            this.f18624e1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.X0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.Y0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.Y0 != colorStateList.getDefaultColor()) {
            this.Y0 = colorStateList.getDefaultColor();
        }
        U0();
    }

    public void setBoxStrokeErrorColor(@o0 ColorStateList colorStateList) {
        if (this.Z0 != colorStateList) {
            this.Z0 = colorStateList;
            U0();
        }
    }

    public void setBoxStrokeWidth(int i7) {
        this.L = i7;
        U0();
    }

    public void setBoxStrokeWidthFocused(int i7) {
        this.M = i7;
        U0();
    }

    public void setBoxStrokeWidthFocusedResource(@p int i7) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i7));
    }

    public void setBoxStrokeWidthResource(@p int i7) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i7));
    }

    public void setCounterEnabled(boolean z7) {
        if (this.f18633j != z7) {
            if (z7) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f18639m = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.S;
                if (typeface != null) {
                    this.f18639m.setTypeface(typeface);
                }
                this.f18639m.setMaxLines(1);
                this.f18631i.d(this.f18639m, 2);
                s0.h((ViewGroup.MarginLayoutParams) this.f18639m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                E0();
                B0();
            } else {
                this.f18631i.E(this.f18639m, 2);
                this.f18639m = null;
            }
            this.f18633j = z7;
        }
    }

    public void setCounterMaxLength(int i7) {
        if (this.f18635k != i7) {
            if (i7 > 0) {
                this.f18635k = i7;
            } else {
                this.f18635k = -1;
            }
            if (this.f18633j) {
                B0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i7) {
        if (this.f18640n != i7) {
            this.f18640n = i7;
            E0();
        }
    }

    public void setCounterOverflowTextColor(@o0 ColorStateList colorStateList) {
        if (this.f18648v != colorStateList) {
            this.f18648v = colorStateList;
            E0();
        }
    }

    public void setCounterTextAppearance(int i7) {
        if (this.f18641o != i7) {
            this.f18641o = i7;
            E0();
        }
    }

    public void setCounterTextColor(@o0 ColorStateList colorStateList) {
        if (this.f18647u != colorStateList) {
            this.f18647u = colorStateList;
            E0();
        }
    }

    public void setDefaultHintTextColor(@o0 ColorStateList colorStateList) {
        this.U0 = colorStateList;
        this.V0 = colorStateList;
        if (this.f18623e != null) {
            K0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        h0(this, z7);
        super.setEnabled(z7);
    }

    public void setEndIconActivated(boolean z7) {
        this.H0.setActivated(z7);
    }

    public void setEndIconCheckable(boolean z7) {
        this.H0.setCheckable(z7);
    }

    public void setEndIconContentDescription(@a1 int i7) {
        setEndIconContentDescription(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void setEndIconDrawable(@c.u int i7) {
        setEndIconDrawable(i7 != 0 ? e.a.b(getContext(), i7) : null);
    }

    public void setEndIconMode(int i7) {
        int i8 = this.F0;
        this.F0 = i7;
        F(i8);
        setEndIconVisible(i7 != 0);
        if (getEndIconDelegate().b(this.I)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.I + " is not supported by the end icon mode " + i7);
    }

    public void setEndIconOnClickListener(@o0 View.OnClickListener onClickListener) {
        r0(this.H0, onClickListener, this.Q0);
    }

    public void setEndIconOnLongClickListener(@o0 View.OnLongClickListener onLongClickListener) {
        this.Q0 = onLongClickListener;
        s0(this.H0, onLongClickListener);
    }

    public void setEndIconTintList(@o0 ColorStateList colorStateList) {
        if (this.J0 != colorStateList) {
            this.J0 = colorStateList;
            this.K0 = true;
            m();
        }
    }

    public void setEndIconTintMode(@o0 PorterDuff.Mode mode) {
        if (this.L0 != mode) {
            this.L0 = mode;
            this.M0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z7) {
        if (P() != z7) {
            this.H0.setVisibility(z7 ? 0 : 8);
            S0();
            G0();
        }
    }

    public void setError(@o0 CharSequence charSequence) {
        if (!this.f18631i.C()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f18631i.x();
        } else {
            this.f18631i.R(charSequence);
        }
    }

    public void setErrorContentDescription(@o0 CharSequence charSequence) {
        this.f18631i.G(charSequence);
    }

    public void setErrorEnabled(boolean z7) {
        this.f18631i.H(z7);
    }

    public void setErrorIconDrawable(@c.u int i7) {
        setErrorIconDrawable(i7 != 0 ? e.a.b(getContext(), i7) : null);
        j0();
    }

    public void setErrorIconOnClickListener(@o0 View.OnClickListener onClickListener) {
        r0(this.S0, onClickListener, this.R0);
    }

    public void setErrorIconOnLongClickListener(@o0 View.OnLongClickListener onLongClickListener) {
        this.R0 = onLongClickListener;
        s0(this.S0, onLongClickListener);
    }

    public void setErrorIconTintList(@o0 ColorStateList colorStateList) {
        this.T0 = colorStateList;
        Drawable drawable = this.S0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.d.r(drawable).mutate();
            androidx.core.graphics.drawable.d.o(drawable, colorStateList);
        }
        if (this.S0.getDrawable() != drawable) {
            this.S0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@o0 PorterDuff.Mode mode) {
        Drawable drawable = this.S0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.d.r(drawable).mutate();
            androidx.core.graphics.drawable.d.p(drawable, mode);
        }
        if (this.S0.getDrawable() != drawable) {
            this.S0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@b1 int i7) {
        this.f18631i.I(i7);
    }

    public void setErrorTextColor(@o0 ColorStateList colorStateList) {
        this.f18631i.J(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z7) {
        if (this.f18630h1 != z7) {
            this.f18630h1 = z7;
            K0(false);
        }
    }

    public void setHelperText(@o0 CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (U()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!U()) {
                setHelperTextEnabled(true);
            }
            this.f18631i.S(charSequence);
        }
    }

    public void setHelperTextColor(@o0 ColorStateList colorStateList) {
        this.f18631i.M(colorStateList);
    }

    public void setHelperTextEnabled(boolean z7) {
        this.f18631i.L(z7);
    }

    public void setHelperTextTextAppearance(@b1 int i7) {
        this.f18631i.K(i7);
    }

    public void setHint(@o0 CharSequence charSequence) {
        if (this.A) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z7) {
        this.f18632i1 = z7;
    }

    public void setHintEnabled(boolean z7) {
        if (z7 != this.A) {
            this.A = z7;
            if (z7) {
                CharSequence hint = this.f18623e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.B)) {
                        setHint(hint);
                    }
                    this.f18623e.setHint((CharSequence) null);
                }
                this.C = true;
            } else {
                this.C = false;
                if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.f18623e.getHint())) {
                    this.f18623e.setHint(this.B);
                }
                setHintInternal(null);
            }
            if (this.f18623e != null) {
                J0();
            }
        }
    }

    public void setHintTextAppearance(@b1 int i7) {
        this.f18628g1.d0(i7);
        this.V0 = this.f18628g1.q();
        if (this.f18623e != null) {
            K0(false);
            J0();
        }
    }

    public void setHintTextColor(@o0 ColorStateList colorStateList) {
        if (this.V0 != colorStateList) {
            if (this.U0 == null) {
                this.f18628g1.f0(colorStateList);
            }
            this.V0 = colorStateList;
            if (this.f18623e != null) {
                K0(false);
            }
        }
    }

    public void setMaxWidth(@r0 int i7) {
        this.f18629h = i7;
        EditText editText = this.f18623e;
        if (editText == null || i7 == -1) {
            return;
        }
        editText.setMaxWidth(i7);
    }

    public void setMaxWidthResource(@p int i7) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i7));
    }

    public void setMinWidth(@r0 int i7) {
        this.f18627g = i7;
        EditText editText = this.f18623e;
        if (editText == null || i7 == -1) {
            return;
        }
        editText.setMinWidth(i7);
    }

    public void setMinWidthResource(@p int i7) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i7));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@a1 int i7) {
        setPasswordVisibilityToggleContentDescription(i7 != 0 ? getResources().getText(i7) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@c.u int i7) {
        setPasswordVisibilityToggleDrawable(i7 != 0 ? e.a.b(getContext(), i7) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z7) {
        if (z7 && this.F0 != 1) {
            setEndIconMode(1);
        } else {
            if (z7) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@o0 ColorStateList colorStateList) {
        this.J0 = colorStateList;
        this.K0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@o0 PorterDuff.Mode mode) {
        this.L0 = mode;
        this.M0 = true;
        m();
    }

    public void setPlaceholderText(@o0 CharSequence charSequence) {
        if (this.f18643q && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f18643q) {
                setPlaceholderTextEnabled(true);
            }
            this.f18642p = charSequence;
        }
        N0();
    }

    public void setPlaceholderTextAppearance(@b1 int i7) {
        this.f18646t = i7;
        TextView textView = this.f18644r;
        if (textView != null) {
            u.E(textView, i7);
        }
    }

    public void setPlaceholderTextColor(@o0 ColorStateList colorStateList) {
        if (this.f18645s != colorStateList) {
            this.f18645s = colorStateList;
            TextView textView = this.f18644r;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@o0 CharSequence charSequence) {
        this.f18649w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f18650x.setText(charSequence);
        Q0();
    }

    public void setPrefixTextAppearance(@b1 int i7) {
        u.E(this.f18650x, i7);
    }

    public void setPrefixTextColor(@m0 ColorStateList colorStateList) {
        this.f18650x.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z7) {
        this.T.setCheckable(z7);
    }

    public void setStartIconContentDescription(@a1 int i7) {
        setStartIconContentDescription(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void setStartIconDrawable(@c.u int i7) {
        setStartIconDrawable(i7 != 0 ? e.a.b(getContext(), i7) : null);
    }

    public void setStartIconOnClickListener(@o0 View.OnClickListener onClickListener) {
        r0(this.T, onClickListener, this.D0);
    }

    public void setStartIconOnLongClickListener(@o0 View.OnLongClickListener onLongClickListener) {
        this.D0 = onLongClickListener;
        s0(this.T, onLongClickListener);
    }

    public void setStartIconTintList(@o0 ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            this.V = true;
            o();
        }
    }

    public void setStartIconTintMode(@o0 PorterDuff.Mode mode) {
        if (this.W != mode) {
            this.W = mode;
            this.A0 = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z7) {
        if (c0() != z7) {
            this.T.setVisibility(z7 ? 0 : 8);
            P0();
            G0();
        }
    }

    public void setSuffixText(@o0 CharSequence charSequence) {
        this.f18651y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f18652z.setText(charSequence);
        T0();
    }

    public void setSuffixTextAppearance(@b1 int i7) {
        u.E(this.f18652z, i7);
    }

    public void setSuffixTextColor(@m0 ColorStateList colorStateList) {
        this.f18652z.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@o0 e eVar) {
        EditText editText = this.f18623e;
        if (editText != null) {
            n2.B1(editText, eVar);
        }
    }

    public void setTypeface(@o0 Typeface typeface) {
        if (typeface != this.S) {
            this.S = typeface;
            this.f18628g1.H0(typeface);
            this.f18631i.O(typeface);
            TextView textView = this.f18639m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void t0(@m0 TextView textView, @b1 int i7) {
        boolean z7 = true;
        try {
            u.E(textView, i7);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z7 = false;
            }
        } catch (Exception unused) {
        }
        if (z7) {
            u.E(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.d.f(getContext(), R.color.design_error));
        }
    }

    public void y() {
        this.E0.clear();
    }

    public void z() {
        this.I0.clear();
    }

    public TextInputLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@o0 CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.H0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@o0 Drawable drawable) {
        this.H0.setImageDrawable(drawable);
        i0();
    }

    public void setStartIconContentDescription(@o0 CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.T.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@o0 Drawable drawable) {
        this.T.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            l0();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v61 */
    public TextInputLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        ?? r7;
        int i8 = f18601m1;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f18627g = -1;
        this.f18629h = -1;
        this.f18631i = new com.google.android.material.textfield.f(this);
        this.P = new Rect();
        this.Q = new Rect();
        this.R = new RectF();
        this.E0 = new LinkedHashSet<>();
        this.F0 = 0;
        SparseArray<com.google.android.material.textfield.e> sparseArray = new SparseArray<>();
        this.G0 = sparseArray;
        this.I0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f18628g1 = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f18615a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f18617b = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, n0.f6717b));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f18619c = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, n0.f6718c));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f18621d = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = com.google.android.material.animation.a.f16846a;
        aVar.G0(timeInterpolator);
        aVar.C0(timeInterpolator);
        aVar.g0(BadgeDrawable.f16995r);
        h1 h1VarK = com.google.android.material.internal.n.k(context2, attributeSet, R.styleable.TextInputLayout, i7, i8, R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance);
        this.A = h1VarK.a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(h1VarK.x(R.styleable.TextInputLayout_android_hint));
        this.f18632i1 = h1VarK.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f18630h1 = h1VarK.a(R.styleable.TextInputLayout_expandedHintEnabled, true);
        if (h1VarK.C(R.styleable.TextInputLayout_android_minWidth)) {
            setMinWidth(h1VarK.g(R.styleable.TextInputLayout_android_minWidth, -1));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_android_maxWidth)) {
            setMaxWidth(h1VarK.g(R.styleable.TextInputLayout_android_maxWidth, -1));
        }
        this.F = o.e(context2, attributeSet, i7, i8).m();
        this.G = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f18614J = h1VarK.f(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.L = h1VarK.g(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.M = h1VarK.g(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.K = this.L;
        float fE = h1VarK.e(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fE2 = h1VarK.e(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fE3 = h1VarK.e(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fE4 = h1VarK.e(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        o.b bVarV = this.F.v();
        if (fE >= 0.0f) {
            bVarV.K(fE);
        }
        if (fE2 >= 0.0f) {
            bVarV.P(fE2);
        }
        if (fE3 >= 0.0f) {
            bVarV.C(fE3);
        }
        if (fE4 >= 0.0f) {
            bVarV.x(fE4);
        }
        this.F = bVarV.m();
        ColorStateList colorStateListB = com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f18616a1 = defaultColor;
            this.O = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f18618b1 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f18620c1 = colorStateListB.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.f18622d1 = colorStateListB.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.f18620c1 = this.f18616a1;
                ColorStateList colorStateListA = e.a.a(context2, R.color.mtrl_filled_background_color);
                this.f18618b1 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f18622d1 = colorStateListA.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.O = 0;
            this.f18616a1 = 0;
            this.f18618b1 = 0;
            this.f18620c1 = 0;
            this.f18622d1 = 0;
        }
        if (h1VarK.C(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListD = h1VarK.d(R.styleable.TextInputLayout_android_textColorHint);
            this.V0 = colorStateListD;
            this.U0 = colorStateListD;
        }
        ColorStateList colorStateListB2 = com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_boxStrokeColor);
        this.Y0 = h1VarK.c(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.W0 = androidx.core.content.d.f(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f18624e1 = androidx.core.content.d.f(context2, R.color.mtrl_textinput_disabled_color);
        this.X0 = androidx.core.content.d.f(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (h1VarK.C(R.styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (h1VarK.u(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            r7 = 0;
            setHintTextAppearance(h1VarK.u(R.styleable.TextInputLayout_hintTextAppearance, 0));
        } else {
            r7 = 0;
        }
        int iU = h1VarK.u(R.styleable.TextInputLayout_errorTextAppearance, r7);
        CharSequence charSequenceX = h1VarK.x(R.styleable.TextInputLayout_errorContentDescription);
        boolean zA = h1VarK.a(R.styleable.TextInputLayout_errorEnabled, r7);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, linearLayout2, (boolean) r7);
        this.S0 = checkableImageButton;
        checkableImageButton.setId(R.id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (com.google.android.material.resources.c.g(context2)) {
            s0.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r7);
        }
        if (h1VarK.C(R.styleable.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(h1VarK.h(R.styleable.TextInputLayout_errorIconDrawable));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_errorIconTint));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(com.google.android.material.internal.v.k(h1VarK.o(R.styleable.TextInputLayout_errorIconTintMode, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        n2.R1(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int iU2 = h1VarK.u(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = h1VarK.a(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceX2 = h1VarK.x(R.styleable.TextInputLayout_helperText);
        int iU3 = h1VarK.u(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceX3 = h1VarK.x(R.styleable.TextInputLayout_placeholderText);
        int iU4 = h1VarK.u(R.styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence charSequenceX4 = h1VarK.x(R.styleable.TextInputLayout_prefixText);
        int iU5 = h1VarK.u(R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence charSequenceX5 = h1VarK.x(R.styleable.TextInputLayout_suffixText);
        boolean zA3 = h1VarK.a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(h1VarK.o(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f18641o = h1VarK.u(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.f18640n = h1VarK.u(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) linearLayout, false);
        this.T = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (com.google.android.material.resources.c.g(context2)) {
            s0.g((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (h1VarK.C(R.styleable.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(h1VarK.h(R.styleable.TextInputLayout_startIconDrawable));
            if (h1VarK.C(R.styleable.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(h1VarK.x(R.styleable.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(h1VarK.a(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_startIconTint)) {
            setStartIconTintList(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_startIconTint));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(com.google.android.material.internal.v.k(h1VarK.o(R.styleable.TextInputLayout_startIconTintMode, -1), null));
        }
        setBoxBackgroundMode(h1VarK.o(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.H0 = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (com.google.android.material.resources.c.g(context2)) {
            s0.h((ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams(), 0);
        }
        sparseArray.append(-1, new com.google.android.material.textfield.b(this));
        sparseArray.append(0, new com.google.android.material.textfield.g(this));
        sparseArray.append(1, new com.google.android.material.textfield.h(this));
        sparseArray.append(2, new com.google.android.material.textfield.a(this));
        sparseArray.append(3, new com.google.android.material.textfield.d(this));
        if (h1VarK.C(R.styleable.TextInputLayout_endIconMode)) {
            setEndIconMode(h1VarK.o(R.styleable.TextInputLayout_endIconMode, 0));
            if (h1VarK.C(R.styleable.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(h1VarK.h(R.styleable.TextInputLayout_endIconDrawable));
            }
            if (h1VarK.C(R.styleable.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(h1VarK.x(R.styleable.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(h1VarK.a(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (h1VarK.C(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(h1VarK.a(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(h1VarK.h(R.styleable.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(h1VarK.x(R.styleable.TextInputLayout_passwordToggleContentDescription));
            if (h1VarK.C(R.styleable.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_passwordToggleTint));
            }
            if (h1VarK.C(R.styleable.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.v.k(h1VarK.o(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!h1VarK.C(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            if (h1VarK.C(R.styleable.TextInputLayout_endIconTint)) {
                setEndIconTintList(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.TextInputLayout_endIconTint));
            }
            if (h1VarK.C(R.styleable.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.v.k(h1VarK.o(R.styleable.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.f18650x = appCompatTextView;
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        n2.D1(appCompatTextView, 1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.f18652z = appCompatTextView2;
        appCompatTextView2.setId(R.id.textinput_suffix_text);
        appCompatTextView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        n2.D1(appCompatTextView2, 1);
        linearLayout2.addView(appCompatTextView2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceX2);
        setHelperTextTextAppearance(iU2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iU);
        setErrorContentDescription(charSequenceX);
        setCounterTextAppearance(this.f18641o);
        setCounterOverflowTextAppearance(this.f18640n);
        setPlaceholderText(charSequenceX3);
        setPlaceholderTextAppearance(iU3);
        setPrefixText(charSequenceX4);
        setPrefixTextAppearance(iU4);
        setSuffixText(charSequenceX5);
        setSuffixTextAppearance(iU5);
        if (h1VarK.C(R.styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(h1VarK.d(R.styleable.TextInputLayout_errorTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(h1VarK.d(R.styleable.TextInputLayout_helperTextTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(h1VarK.d(R.styleable.TextInputLayout_hintTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(h1VarK.d(R.styleable.TextInputLayout_counterTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(h1VarK.d(R.styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(h1VarK.d(R.styleable.TextInputLayout_placeholderTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(h1VarK.d(R.styleable.TextInputLayout_prefixTextColor));
        }
        if (h1VarK.C(R.styleable.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(h1VarK.d(R.styleable.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(zA3);
        setEnabled(h1VarK.a(R.styleable.TextInputLayout_android_enabled, true));
        h1VarK.I();
        n2.R1(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            n2.S1(this, 1);
        }
    }

    public void setErrorIconDrawable(@o0 Drawable drawable) {
        this.S0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f18631i.C());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@o0 CharSequence charSequence) {
        this.H0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@o0 Drawable drawable) {
        this.H0.setImageDrawable(drawable);
    }

    public void setHint(@a1 int i7) {
        setHint(i7 != 0 ? getResources().getText(i7) : null);
    }
}
