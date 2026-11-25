package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Space extends View {
    @Deprecated
    public Space(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int a(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i7 : size;
        }
        return Math.min(i7, size);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    @Deprecated
    protected void onMeasure(int i7, int i8) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i7), a(getSuggestedMinimumHeight(), i8));
    }

    @Deprecated
    public Space(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(@m0 Context context) {
        this(context, null);
    }
}
