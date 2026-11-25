package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.d1;
import com.google.android.gms.common.internal.zaaa;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f15026e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f15027f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f15028g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f15029h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f15030i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15031j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f15034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private View.OnClickListener f15035d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public SignInButton(@c.m0 Context context) {
        this(context, null);
    }

    private final void a(Context context) {
        View view = this.f15034c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f15034c = d1.c(context, this.f15032a, this.f15033b);
        } catch (com.google.android.gms.dynamic.h.a unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i7 = this.f15032a;
            int i8 = this.f15033b;
            zaaa zaaaVar = new zaaa(context, null);
            zaaaVar.a(context.getResources(), i7, i8);
            this.f15034c = zaaaVar;
        }
        addView(this.f15034c);
        this.f15034c.setEnabled(isEnabled());
        this.f15034c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@c.m0 View view) {
        View.OnClickListener onClickListener = this.f15035d;
        if (onClickListener == null || view != this.f15034c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i7) {
        setStyle(this.f15032a, i7);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.f15034c.setEnabled(z7);
    }

    @Override // android.view.View
    public void setOnClickListener(@c.o0 View.OnClickListener onClickListener) {
        this.f15035d = onClickListener;
        View view = this.f15034c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(@c.m0 Scope[] scopeArr) {
        setStyle(this.f15032a, this.f15033b);
    }

    public void setSize(int i7) {
        setStyle(i7, this.f15033b);
    }

    public void setStyle(int i7, int i8) {
        this.f15032a = i7;
        this.f15033b = i8;
        a(getContext());
    }

    public SignInButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void setStyle(int i7, int i8, @c.m0 Scope[] scopeArr) {
        setStyle(i7, i8);
    }

    public SignInButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f15035d = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.gms.base.R.styleable.SignInButton, 0, 0);
        try {
            this.f15032a = typedArrayObtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_buttonSize, 0);
            this.f15033b = typedArrayObtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_colorScheme, 2);
            typedArrayObtainStyledAttributes.recycle();
            setStyle(this.f15032a, this.f15033b);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
