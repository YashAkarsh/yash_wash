package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class SpacingText extends FontTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f25827b;

    public class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f25828b = 0.0f;

        public a() {
        }
    }

    public SpacingText(Context context) {
        super(context);
        this.f25826a = 0.0f;
        this.f25827b = "";
    }

    private void b() {
        if (this.f25827b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < this.f25827b.length()) {
            sb.append(this.f25827b.charAt(i7));
            i7++;
            if (i7 < this.f25827b.length()) {
                sb.append(" ");
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i8 = 1; i8 < sb.toString().length(); i8 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f25826a + 1.0f) / 10.0f), i8, i8 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public float getSpacing() {
        return this.f25826a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.f25827b;
    }

    public void setSpacing(float f8) {
        this.f25826a = f8;
        b();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f25827b = charSequence;
        b();
    }

    public SpacingText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25826a = 0.0f;
        this.f25827b = "";
    }

    public SpacingText(Context context, @Nullable AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25826a = 0.0f;
        this.f25827b = "";
    }
}
