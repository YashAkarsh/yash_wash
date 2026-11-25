package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.c1;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.resources.b;
import com.google.android.material.resources.c;
import q1.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@m0 Context context) {
        this(context, null);
    }

    private void h(@m0 Resources.Theme theme, int i7) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i7, R.styleable.MaterialTextAppearance);
        int iK = k(getContext(), typedArrayObtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iK >= 0) {
            setLineHeight(iK);
        }
    }

    private static boolean i(Context context) {
        return b.b(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int j(@m0 Resources.Theme theme, @o0 AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int k(@m0 Context context, @m0 TypedArray typedArray, @m0 @c1 int... iArr) {
        int iC = -1;
        for (int i7 = 0; i7 < iArr.length && iC < 0; i7++) {
            iC = c.c(context, typedArray, iArr[i7], -1);
        }
        return iC;
    }

    private static boolean l(@m0 Context context, @m0 Resources.Theme theme, @o0 AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i7, i8);
        int iK = k(context, typedArrayObtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iK != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@m0 Context context, int i7) {
        super.setTextAppearance(context, i7);
        if (i(context)) {
            h(context.getTheme(), i7);
        }
    }

    public MaterialTextView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public MaterialTextView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public MaterialTextView(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        int iJ;
        super(a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        if (i(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (l(context2, theme, attributeSet, i7, i8) || (iJ = j(theme, attributeSet, i7, i8)) == -1) {
                return;
            }
            h(theme, iJ);
        }
    }
}
