package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class FontTextView extends TextView {
    public FontTextView(Context context) {
        super(context);
    }

    private Typeface a(Context context, String str) {
        return Typeface.createFromAsset(context.getAssets(), str);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i7) {
        super.setTypeface(a(getContext(), "fonts/helvetica_a.ttf"), i7);
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontTextView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
    }
}
