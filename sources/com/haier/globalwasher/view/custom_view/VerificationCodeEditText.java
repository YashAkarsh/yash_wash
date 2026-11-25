package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.d;
import c.n;
import c.t0;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class VerificationCodeEditText extends AppCompatEditText implements a, TextWatcher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f25834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f25835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a.InterfaceC0339a f25836l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f25837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f25838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Paint f25839o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Paint f25840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f25841q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Paint f25842r;

    public VerificationCodeEditText(Context context) {
        this(context, null);
    }

    private int d(int i7) {
        return (int) TypedValue.applyDimension(1, i7, getResources().getDisplayMetrics());
    }

    private int e(@n int i7) {
        return d.f(getContext(), i7);
    }

    static int f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @t0(api = 17)
    private void g(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerCodeEditText);
        this.f25830f = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerCodeEditText_figures, 4);
        this.f25831g = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.VerCodeEditText_verCodeMargin, 0.0f);
        this.f25832h = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_bottomLineSelectedColor, getCurrentTextColor());
        this.f25833i = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_bottomLineNormalColor, e(android.R.color.darker_gray));
        this.f25834j = typedArrayObtainStyledAttributes.getDimension(R.styleable.VerCodeEditText_bottomLineHeight, d(5));
        this.f25835k = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_selectedBackgroundColor, e(android.R.color.darker_gray));
        typedArrayObtainStyledAttributes.recycle();
        setLayoutDirection(0);
    }

    private void h() {
        Paint paint = new Paint();
        this.f25839o = paint;
        paint.setColor(this.f25835k);
        Paint paint2 = new Paint();
        this.f25840p = paint2;
        paint2.setColor(e(android.R.color.transparent));
        this.f25841q = new Paint();
        this.f25842r = new Paint();
        this.f25841q.setColor(this.f25832h);
        this.f25842r.setColor(this.f25833i);
        this.f25841q.setStrokeWidth(this.f25834j);
        this.f25842r.setStrokeWidth(this.f25834j);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f25837m = getText().length();
        postInvalidate();
        if (getText().length() != this.f25830f) {
            if (getText().length() > this.f25830f) {
                getText().delete(this.f25830f, getText().length());
            }
        } else {
            a.InterfaceC0339a interfaceC0339a = this.f25836l;
            if (interfaceC0339a != null) {
                interfaceC0339a.a(getText());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        this.f25837m = getText().length();
        postInvalidate();
    }

    public void i(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(this, 2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f25837m = getText().length();
        int paddingLeft = (this.f25838n - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i7 = 0; i7 < this.f25830f; i7++) {
            canvas.save();
            int i8 = (paddingLeft * i7) + (this.f25831g * i7);
            int i9 = paddingLeft + i8;
            if (i7 == this.f25837m) {
                canvas.drawRect(i8, 0.0f, i9, measuredHeight, this.f25839o);
            } else {
                canvas.drawRect(i8, 0.0f, i9, measuredHeight, this.f25840p);
            }
            canvas.restore();
        }
        String string = getText().toString();
        for (int i10 = 0; i10 < string.length(); i10++) {
            canvas.save();
            float f8 = (paddingLeft * i10) + (this.f25831g * i10) + (paddingLeft / 2);
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f9 = measuredHeight - fontMetrics.bottom;
            float f10 = fontMetrics.top;
            canvas.drawText(String.valueOf(string.charAt(i10)), f8, ((f9 + f10) / 2.0f) - f10, paint);
            canvas.restore();
        }
        for (int i11 = 0; i11 < this.f25830f; i11++) {
            canvas.save();
            float f11 = measuredHeight - (this.f25834j / 2.0f);
            int i12 = (paddingLeft * i11) + (this.f25831g * i11);
            int i13 = paddingLeft + i12;
            if (i11 < this.f25837m) {
                canvas.drawLine(i12, f11, i13, f11, this.f25841q);
            } else {
                canvas.drawLine(i12, f11, i13, f11, this.f25842r);
            }
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        if (mode != 1073741824) {
            size = f(getContext());
        }
        int i9 = this.f25831g;
        int i10 = this.f25830f;
        this.f25838n = (size - (i9 * (i10 - 1))) / i10;
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode2 != 1073741824) {
            size2 = this.f25838n;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        this.f25837m = getText().length();
        postInvalidate();
        a.InterfaceC0339a interfaceC0339a = this.f25836l;
        if (interfaceC0339a != null) {
            interfaceC0339a.b(getText(), i7, i8, i9);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        requestFocus();
        setSelection(getText().length());
        i(getContext());
        return false;
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setBottomLineHeight(int i7) {
        this.f25834j = i7;
        postInvalidate();
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setBottomNormalColor(@n int i7) {
        this.f25832h = e(i7);
        postInvalidate();
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setBottomSelectedColor(@n int i7) {
        this.f25832h = e(i7);
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void setCursorVisible(boolean z7) {
        super.setCursorVisible(false);
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setFigures(int i7) {
        this.f25830f = i7;
        postInvalidate();
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setOnVerificationCodeChangedListener(a.InterfaceC0339a interfaceC0339a) {
        this.f25836l = interfaceC0339a;
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setSelectedBackgroundColor(@n int i7) {
        this.f25835k = e(i7);
        postInvalidate();
    }

    @Override // com.haier.globalwasher.view.custom_view.a
    public void setVerCodeMargin(int i7) {
        this.f25831g = i7;
        postInvalidate();
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25837m = 0;
        this.f25838n = 0;
        g(attributeSet);
        setBackgroundColor(d.f(context, android.R.color.transparent));
        h();
        setFocusableInTouchMode(true);
        super.addTextChangedListener(this);
    }
}
