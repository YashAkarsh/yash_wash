package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.d;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class FacebookButtonBase extends Button {
    private String analyticsButtonCreatedEventName;
    private String analyticsButtonTappedEventName;
    private View.OnClickListener externalOnClickListener;
    private View.OnClickListener internalOnClickListener;
    private boolean overrideCompoundPadding;
    private int overrideCompoundPaddingLeft;
    private int overrideCompoundPaddingRight;
    private FragmentWrapper parentFragment;

    protected FacebookButtonBase(Context context, AttributeSet attributeSet, int i7, int i8, String str, String str2) {
        super(context, attributeSet, 0);
        i8 = i8 == 0 ? getDefaultStyleResource() : i8;
        configureButton(context, attributeSet, i7, i8 == 0 ? R.style.com_facebook_button : i8);
        this.analyticsButtonCreatedEventName = str;
        this.analyticsButtonTappedEventName = str2;
        setClickable(true);
        setFocusable(true);
    }

    private void logButtonCreated(Context context) {
        new InternalAppEventsLogger(context).logEventImplicitly(this.analyticsButtonCreatedEventName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logButtonTapped(Context context) {
        new InternalAppEventsLogger(context).logEventImplicitly(this.analyticsButtonTappedEventName);
    }

    private void parseBackgroundAttributes(Context context, AttributeSet attributeSet, int i7, int i8) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.background}, i7, i8);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    setBackgroundResource(resourceId);
                } else {
                    setBackgroundColor(typedArrayObtainStyledAttributes.getColor(0, 0));
                }
            } else {
                setBackgroundColor(d.f(context, R.color.com_facebook_blue));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"ResourceType"})
    private void parseCompoundDrawableAttributes(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.drawableLeft, android.R.attr.drawableTop, android.R.attr.drawableRight, android.R.attr.drawableBottom, android.R.attr.drawablePadding}, i7, i8);
        try {
            setCompoundDrawablesWithIntrinsicBounds(typedArrayObtainStyledAttributes.getResourceId(0, 0), typedArrayObtainStyledAttributes.getResourceId(1, 0), typedArrayObtainStyledAttributes.getResourceId(2, 0), typedArrayObtainStyledAttributes.getResourceId(3, 0));
            setCompoundDrawablePadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void parseContentAttributes(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.paddingLeft, android.R.attr.paddingTop, android.R.attr.paddingRight, android.R.attr.paddingBottom}, i7, i8);
        try {
            setPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void parseTextAttributes(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textColor}, i7, i8);
        try {
            setTextColor(typedArrayObtainStyledAttributes.getColorStateList(0));
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.gravity}, i7, i8);
            try {
                setGravity(typedArrayObtainStyledAttributes2.getInt(0, 17));
                typedArrayObtainStyledAttributes2.recycle();
                TypedArray typedArrayObtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textSize, android.R.attr.textStyle, android.R.attr.text}, i7, i8);
                try {
                    setTextSize(0, typedArrayObtainStyledAttributes3.getDimensionPixelSize(0, 0));
                    setTypeface(Typeface.defaultFromStyle(typedArrayObtainStyledAttributes3.getInt(1, 1)));
                    setText(typedArrayObtainStyledAttributes3.getString(2));
                } finally {
                    typedArrayObtainStyledAttributes3.recycle();
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void setupOnClickListener() {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.FacebookButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FacebookButtonBase facebookButtonBase = FacebookButtonBase.this;
                facebookButtonBase.logButtonTapped(facebookButtonBase.getContext());
                if (FacebookButtonBase.this.internalOnClickListener != null) {
                    FacebookButtonBase.this.internalOnClickListener.onClick(view);
                } else if (FacebookButtonBase.this.externalOnClickListener != null) {
                    FacebookButtonBase.this.externalOnClickListener.onClick(view);
                }
            }
        });
    }

    protected void callExternalOnClickListener(View view) {
        View.OnClickListener onClickListener = this.externalOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    protected void configureButton(Context context, AttributeSet attributeSet, int i7, int i8) {
        parseBackgroundAttributes(context, attributeSet, i7, i8);
        parseCompoundDrawableAttributes(context, attributeSet, i7, i8);
        parseContentAttributes(context, attributeSet, i7, i8);
        parseTextAttributes(context, attributeSet, i7, i8);
        setupOnClickListener();
    }

    protected Activity getActivity() {
        boolean z7;
        Context context = getContext();
        while (true) {
            z7 = context instanceof Activity;
            if (z7 || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z7) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        return this.overrideCompoundPadding ? this.overrideCompoundPaddingLeft : super.getCompoundPaddingLeft();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        return this.overrideCompoundPadding ? this.overrideCompoundPaddingRight : super.getCompoundPaddingRight();
    }

    protected abstract int getDefaultRequestCode();

    protected int getDefaultStyleResource() {
        return 0;
    }

    public Fragment getFragment() {
        FragmentWrapper fragmentWrapper = this.parentFragment;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getSupportFragment();
        }
        return null;
    }

    public android.app.Fragment getNativeFragment() {
        FragmentWrapper fragmentWrapper = this.parentFragment;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getNativeFragment();
        }
        return null;
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    protected int measureTextWidth(String str) {
        return (int) Math.ceil(getPaint().measureText(str));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        logButtonCreated(getContext());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if ((getGravity() & 1) != 0) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int iMin = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.overrideCompoundPaddingLeft = compoundPaddingLeft - iMin;
            this.overrideCompoundPaddingRight = compoundPaddingRight + iMin;
            this.overrideCompoundPadding = true;
        }
        super.onDraw(canvas);
        this.overrideCompoundPadding = false;
    }

    public void setFragment(Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }

    protected void setInternalOnClickListener(View.OnClickListener onClickListener) {
        this.internalOnClickListener = onClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.externalOnClickListener = onClickListener;
    }

    public void setFragment(android.app.Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }
}
