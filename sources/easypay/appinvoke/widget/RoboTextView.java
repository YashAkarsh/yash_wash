package easypay.appinvoke.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import easypay.appinvoke.manager.Constants;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoboTextView extends AppCompatTextView {
    public RoboTextView(Context context) {
        super(context);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoboTextView);
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.RoboTextView_fontType, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (integer != 0) {
                if (integer == 1) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF_LIGHT, 0));
                    return;
                }
                if (integer == 2) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF, 0));
                    return;
                }
                if (integer == 3) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF_MEDIUM, 0));
                } else if (integer == 4) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF, 1));
                } else {
                    if (integer != 5) {
                        return;
                    }
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF, 2));
                }
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public RoboTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        h(context, attributeSet);
    }

    public RoboTextView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        if (isInEditMode()) {
            return;
        }
        h(context, attributeSet);
    }
}
