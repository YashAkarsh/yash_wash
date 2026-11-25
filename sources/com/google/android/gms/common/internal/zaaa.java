package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @c.o0 AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int b(int i7, int i8, int i9, int i10) {
        if (i7 == 0) {
            return i8;
        }
        if (i7 == 1) {
            return i9;
        }
        if (i7 == 2) {
            return i10;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i7);
        throw new IllegalStateException(sb.toString());
    }

    public final void a(Resources resources, int i7, int i8) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i9 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i9);
        setMinWidth(i9);
        int i10 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark;
        int i11 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light;
        int iB = b(i8, i10, i11, i11);
        int i12 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark;
        int i13 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light;
        int iB2 = b(i8, i12, i13, i13);
        if (i7 == 0 || i7 == 1) {
            iB = iB2;
        } else if (i7 != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i7);
            throw new IllegalStateException(sb.toString());
        }
        Drawable drawableR = androidx.core.graphics.drawable.d.r(resources.getDrawable(iB));
        androidx.core.graphics.drawable.d.o(drawableR, resources.getColorStateList(com.google.android.gms.base.R.color.common_google_signin_btn_tint));
        androidx.core.graphics.drawable.d.p(drawableR, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableR);
        int i14 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark;
        int i15 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) u.k(resources.getColorStateList(b(i8, i14, i15, i15))));
        if (i7 == 0) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text));
        } else if (i7 == 1) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text_long));
        } else {
            if (i7 != 2) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i7);
                throw new IllegalStateException(sb2.toString());
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (g1.l.k(getContext())) {
            setGravity(19);
        }
    }
}
