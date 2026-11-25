package easypay.appinvoke.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.text.p0;
import androidx.core.view.n2;
import c.l;
import c.o0;
import java.util.Locale;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class OtpEditText extends AppCompatEditText {
    private static final String O = "OtpEditText";
    protected float A;
    protected float B;
    protected Paint C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;

    @l
    protected int H;

    @l
    protected int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @l
    protected int f33857J;

    @l
    protected int K;

    @l
    protected int L;
    private boolean M;
    protected ColorStateList N;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f33858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f33859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected RectF[] f33860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected float[] f33861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Paint f33862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Paint f33863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Drawable f33864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Rect f33865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f33866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f33867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected StringBuilder f33868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f33869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f33870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected float f33871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float f33872t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected float f33873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected float f33874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected View.OnClickListener f33875w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected View.OnLongClickListener f33876x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected i f33877y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected j f33878z;

    class a implements ActionMode.Callback {
        a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtpEditText otpEditText = OtpEditText.this;
            otpEditText.setSelection(otpEditText.getText().length());
            View.OnClickListener onClickListener = OtpEditText.this.f33875w;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            OtpEditText otpEditText = OtpEditText.this;
            otpEditText.setSelection(otpEditText.getText().length());
            View.OnLongClickListener onLongClickListener = OtpEditText.this.f33876x;
            if (onLongClickListener == null) {
                return false;
            }
            return onLongClickListener.onLongClick(view);
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OtpEditText.this.f33863k.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
            OtpEditText.this.invalidate();
        }
    }

    class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OtpEditText otpEditText = OtpEditText.this;
            otpEditText.f33877y.a(otpEditText.getText());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33884a;

        f(int i7) {
            this.f33884a = i7;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OtpEditText.this.f33861i[this.f33884a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            OtpEditText.this.invalidate();
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OtpEditText.this.f33863k.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class h implements Animator.AnimatorListener {
        h() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OtpEditText otpEditText = OtpEditText.this;
            otpEditText.f33877y.a(otpEditText.getText());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface i {
        void a(CharSequence charSequence);
    }

    public interface j {
        void a();

        void b();
    }

    public OtpEditText(Context context) {
        super(context);
        this.f33859g = 6;
        this.f33865m = new Rect();
        this.f33866n = false;
        this.f33867o = null;
        this.f33868p = null;
        this.f33869q = 0;
        this.f33870r = 0;
        this.f33871s = 24.0f;
        this.f33873u = 6.0f;
        this.f33874v = 8.0f;
        this.f33877y = null;
        this.f33878z = null;
        this.A = 1.0f;
        this.B = 2.0f;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.M = true;
    }

    private void e(CharSequence charSequence, int i7) {
        float[] fArr = this.f33861i;
        float f8 = this.f33860h[i7].bottom - this.f33874v;
        fArr[i7] = f8;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f8 + getPaint().getTextSize(), this.f33861i[i7]);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new f(i7));
        this.f33863k.setAlpha(255);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new g());
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f33859g && this.f33877y != null) {
            animatorSet.addListener(new h());
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        animatorSet.start();
    }

    private void f() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "translationY", 0.0f, 0.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f));
        animatorSet.start();
    }

    private void g() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, getPaint().getTextSize());
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new d());
        if (getText().length() == this.f33859g && this.f33877y != null) {
            valueAnimatorOfFloat.addListener(new e());
        }
        valueAnimatorOfFloat.start();
    }

    private CharSequence getFullText() {
        return this.f33867o == null ? getText() : getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.f33868p == null) {
            this.f33868p = new StringBuilder();
        }
        int length = getText().length();
        while (this.f33868p.length() != length) {
            if (this.f33868p.length() < length) {
                this.f33868p.append(this.f33867o);
            } else {
                StringBuilder sb = this.f33868p;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.f33868p;
    }

    private void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "translationX", 0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f));
        animatorSet.start();
    }

    private int j(int i7) {
        return (int) TypedValue.applyDimension(1, i7, getContext().getApplicationContext().getResources().getDisplayMetrics());
    }

    private void l(Context context, AttributeSet attributeSet) {
        float f8 = context.getResources().getDisplayMetrics().density;
        this.A *= f8;
        this.B *= f8;
        this.f33871s *= f8;
        this.f33874v = f8 * this.f33874v;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OtpEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainStyledAttributes.getValue(R.styleable.OtpEditText_otpInputAnimStyle, typedValue);
            this.f33869q = typedValue.data;
            typedArrayObtainStyledAttributes.getValue(R.styleable.OtpEditText_otpErrorAnimStyle, typedValue);
            this.f33870r = typedValue.data;
            this.A = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineHeight, this.A);
            this.B = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineSelectedHeight, this.B);
            this.f33871s = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpCharacterSpacing, this.f33871s);
            this.f33874v = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpTextBottomLinePadding, this.f33874v);
            this.f33866n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OtpEditText_otpBackgroundIsSquare, this.f33866n);
            this.f33864l = typedArrayObtainStyledAttributes.getDrawable(R.styleable.OtpEditText_otpBackgroundDrawable);
            this.H = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpErrorTextColor, -7829368);
            this.L = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineErrorColor, getTextColors().getColorForState(new int[]{android.R.attr.state_active}, Color.parseColor("#fd5c5c")));
            this.f33857J = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineFocusedColor, getTextColors().getColorForState(new int[]{android.R.attr.state_focused}, -12303292));
            this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineNextCharColor, getTextColors().getColorForState(new int[]{android.R.attr.state_focused}, -12303292));
            this.I = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineUnFocusedColor, getTextColors().getColorForState(new int[]{android.R.attr.state_active}, -7829368));
            typedArrayObtainStyledAttributes.recycle();
            this.f33862j = new Paint(getPaint());
            this.f33863k = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.C = paint;
            paint.setStrokeWidth(this.A);
            setBackgroundResource(0);
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 6);
            this.f33859g = attributeIntValue;
            float f9 = attributeIntValue;
            this.f33873u = f9;
            this.f33858f = new float[(int) f9];
            super.setCustomSelectionActionModeCallback(new a());
            super.setOnClickListener(new b());
            super.setOnLongClickListener(new c());
            if ((getInputType() & 128) == 128 || (getInputType() & 16) == 16) {
                this.f33867o = "●";
            }
            if (!TextUtils.isEmpty(this.f33867o)) {
                this.f33868p = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.f33865m);
            this.D = this.f33869q > -1;
            this.E = this.f33870r > -1;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void o(int i7, int i8) {
        int i9;
        if (this.F) {
            this.C.setColor(this.L);
            return;
        }
        if (!isFocused()) {
            this.C.setStrokeWidth(this.A);
            this.C.setColor(this.I);
            return;
        }
        this.C.setStrokeWidth(this.B);
        if (i7 == i8 || (i8 == (i9 = this.f33859g) && i7 == i9 - 1 && this.M)) {
            this.C.setColor(this.K);
        } else if (i7 < i8) {
            this.C.setColor(this.f33857J);
        } else {
            this.C.setColor(this.I);
        }
    }

    public void d() {
        this.G = true;
        this.F = true;
        this.f33862j.setColor(this.H);
        this.f33863k.setColor(this.H);
        invalidate();
        if (this.E) {
            if (this.f33870r == 0) {
                h();
            } else {
                f();
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getError() {
        return super.getError();
    }

    public void i(boolean z7) {
        this.D = z7;
    }

    public void k() {
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public boolean m() {
        return this.M;
    }

    public boolean n() {
        return this.F;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = this.f33858f;
        if (length > fArr.length) {
            length = fArr.length;
        }
        int i7 = length;
        getPaint().getTextWidths(fullText, 0, i7, this.f33858f);
        int i8 = 0;
        while (i8 < this.f33873u) {
            if (this.f33864l != null) {
                p(i8 < i7, i8 == i7);
                Drawable drawable = this.f33864l;
                RectF rectF = this.f33860h[i8];
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.f33864l.draw(canvas);
            }
            float f8 = this.f33860h[i8].left + (this.f33872t / 2.0f);
            if (i7 > i8) {
                if (this.D && i8 == i7 - 1) {
                    canvas.drawText(fullText, i8, i8 + 1, f8 - (this.f33858f[i8] / 2.0f), this.f33861i[i8], this.f33863k);
                } else {
                    canvas.drawText(fullText, i8, i8 + 1, f8 - (this.f33858f[i8] / 2.0f), this.f33861i[i8], this.f33862j);
                }
            }
            if (this.f33864l == null) {
                o(i8, i7);
                RectF rectF2 = this.f33860h[i8];
                canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.C);
            }
            i8++;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        int iK0;
        super.onSizeChanged(i7, i8, i9, i10);
        ColorStateList textColors = getTextColors();
        this.N = textColors;
        if (textColors != null) {
            this.f33863k.setColor(textColors.getDefaultColor());
            this.f33862j.setColor(this.N.getDefaultColor());
        }
        int width = (getWidth() - n2.j0(this)) - n2.k0(this);
        float f8 = this.f33871s;
        if (f8 < 0.0f) {
            this.f33872t = width / ((this.f33873u * 2.0f) - 1.0f);
        } else {
            float f9 = this.f33873u;
            this.f33872t = ((width - (f8 * (f9 - 1.0f))) / f9) + j(2);
        }
        float f10 = this.f33873u;
        this.f33860h = new RectF[(int) f10];
        this.f33861i = new float[(int) f10];
        int height = getHeight() - getPaddingBottom();
        int i11 = 1;
        if (p0.b(Locale.getDefault()) == 1) {
            iK0 = (int) ((getWidth() - n2.k0(this)) - this.f33872t);
            i11 = -1;
        } else {
            iK0 = n2.k0(this) + j(2);
        }
        for (int i12 = 0; i12 < this.f33873u; i12++) {
            float f11 = iK0;
            float f12 = height;
            this.f33860h[i12] = new RectF(f11, f12, this.f33872t + f11, f12);
            if (this.f33864l != null) {
                if (this.f33866n) {
                    this.f33860h[i12].top = getPaddingTop();
                    RectF rectF = this.f33860h[i12];
                    rectF.right = rectF.height() + f11;
                } else {
                    this.f33860h[i12].top -= this.f33865m.height() + (this.f33874v * 2.0f);
                }
            }
            float f13 = this.f33871s;
            iK0 = (int) (f13 < 0.0f ? f11 + (i11 * this.f33872t * 2.0f) : f11 + (i11 * (this.f33872t + f13)));
            this.f33861i[i12] = this.f33860h[i12].bottom - this.f33874v;
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        setError(false);
        j jVar = this.f33878z;
        if (jVar != null) {
            jVar.a();
        }
        if (this.G || this.F) {
            this.G = false;
            this.F = false;
            ColorStateList colorStateList = this.N;
            if (colorStateList != null) {
                this.f33863k.setColor(colorStateList.getDefaultColor());
                this.f33862j.setColor(this.N.getDefaultColor());
            }
        }
        if (this.f33860h == null || !this.D) {
            if (this.f33877y == null || charSequence.length() != this.f33859g) {
                return;
            }
            this.f33877y.a(charSequence);
            return;
        }
        int i10 = this.f33869q;
        if (i10 == -1) {
            invalidate();
        } else if (i9 > i8) {
            if (i10 == 0) {
                g();
            } else {
                e(charSequence, i7);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i7) {
        boolean zOnTextContextMenuItem = super.onTextContextMenuItem(i7);
        if (i7 == 16908322) {
            this.f33878z.b();
        }
        return zOnTextContextMenuItem;
    }

    protected void p(boolean z7, boolean z8) {
        if (this.F) {
            this.f33864l.setState(new int[]{android.R.attr.state_active});
            return;
        }
        if (!isFocused()) {
            this.f33864l.setState(new int[]{-16842908});
            return;
        }
        this.f33864l.setState(new int[]{android.R.attr.state_focused});
        if (z8) {
            this.f33864l.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected});
        } else if (z7) {
            this.f33864l.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_checked});
        }
    }

    public void setActive(boolean z7) {
        this.M = z7;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() is not allowed.");
    }

    public void setError(boolean z7) {
        this.F = z7;
    }

    public void setMaxLength(int i7) {
        this.f33859g = i7;
        float f8 = i7;
        this.f33873u = f8;
        this.f33858f = new float[(int) f8];
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i7)});
        setText((CharSequence) null);
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f33875w = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(@o0 View.OnLongClickListener onLongClickListener) {
        this.f33876x = onLongClickListener;
    }

    public void setOnPinEnteredListener(i iVar) {
        this.f33877y = iVar;
    }

    public void setOnTextChangedListener(j jVar) {
        this.f33878z = jVar;
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence) {
        Log.e(O, "setError(CharSequence error) is not supported");
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence, Drawable drawable) {
        Log.e(O, "setError(CharSequence error, Drawable icon) is not supported");
    }

    public OtpEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33859g = 6;
        this.f33865m = new Rect();
        this.f33866n = false;
        this.f33867o = null;
        this.f33868p = null;
        this.f33869q = 0;
        this.f33870r = 0;
        this.f33871s = 24.0f;
        this.f33873u = 6.0f;
        this.f33874v = 8.0f;
        this.f33877y = null;
        this.f33878z = null;
        this.A = 1.0f;
        this.B = 2.0f;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.M = true;
        l(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f33859g = 6;
        this.f33865m = new Rect();
        this.f33866n = false;
        this.f33867o = null;
        this.f33868p = null;
        this.f33869q = 0;
        this.f33870r = 0;
        this.f33871s = 24.0f;
        this.f33873u = 6.0f;
        this.f33874v = 8.0f;
        this.f33877y = null;
        this.f33878z = null;
        this.A = 1.0f;
        this.B = 2.0f;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.M = true;
        l(context, attributeSet);
    }

    @TargetApi(21)
    public OtpEditText(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7);
        this.f33859g = 6;
        this.f33865m = new Rect();
        this.f33866n = false;
        this.f33867o = null;
        this.f33868p = null;
        this.f33869q = 0;
        this.f33870r = 0;
        this.f33871s = 24.0f;
        this.f33873u = 6.0f;
        this.f33874v = 8.0f;
        this.f33877y = null;
        this.f33878z = null;
        this.A = 1.0f;
        this.B = 2.0f;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.M = true;
        l(context, attributeSet);
    }
}
