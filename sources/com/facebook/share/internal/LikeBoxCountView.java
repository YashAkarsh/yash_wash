package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.R;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    /* JADX INFO: renamed from: com.facebook.share.internal.LikeBoxCountView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition;

        static {
            int[] iArr = new int[LikeBoxCountViewCaretPosition.values().length];
            $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition = iArr;
            try {
                iArr[LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        this.caretPosition = LikeBoxCountViewCaretPosition.LEFT;
        initialize(context);
    }

    private void drawBorder(Canvas canvas, float f8, float f9, float f10, float f11) {
        Path path = new Path();
        float f12 = this.borderRadius * 2.0f;
        float f13 = f8 + f12;
        float f14 = f9 + f12;
        path.addArc(new RectF(f8, f9, f13, f14), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            float f15 = f10 - f8;
            path.lineTo(((f15 - this.caretWidth) / 2.0f) + f8, f9);
            path.lineTo((f15 / 2.0f) + f8, f9 - this.caretHeight);
            path.lineTo(((f15 + this.caretWidth) / 2.0f) + f8, f9);
        }
        path.lineTo(f10 - this.borderRadius, f9);
        float f16 = f10 - f12;
        path.addArc(new RectF(f16, f9, f10, f14), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            float f17 = f11 - f9;
            path.lineTo(f10, ((f17 - this.caretWidth) / 2.0f) + f9);
            path.lineTo(this.caretHeight + f10, (f17 / 2.0f) + f9);
            path.lineTo(f10, ((f17 + this.caretWidth) / 2.0f) + f9);
        }
        path.lineTo(f10, f11 - this.borderRadius);
        float f18 = f11 - f12;
        path.addArc(new RectF(f16, f18, f10, f11), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f19 = f10 - f8;
            path.lineTo(((this.caretWidth + f19) / 2.0f) + f8, f11);
            path.lineTo((f19 / 2.0f) + f8, this.caretHeight + f11);
            path.lineTo(((f19 - this.caretWidth) / 2.0f) + f8, f11);
        }
        path.lineTo(this.borderRadius + f8, f11);
        path.addArc(new RectF(f8, f18, f13, f11), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            float f20 = f11 - f9;
            path.lineTo(f8, ((this.caretWidth + f20) / 2.0f) + f9);
            path.lineTo(f8 - this.caretHeight, (f20 / 2.0f) + f9);
            path.lineTo(f8, ((f20 - this.caretWidth) / 2.0f) + f9);
        }
        path.lineTo(f8, f9 + this.borderRadius);
        canvas.drawPath(path, this.borderPaint);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context context) {
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int i7, int i8, int i9, int i10) {
        TextView textView = this.likeCountLabel;
        int i11 = this.textPadding;
        textView.setPadding(i7 + i11, i8 + i11, i9 + i11, i11 + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i7 = AnonymousClass1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[this.caretPosition.ordinal()];
        if (i7 == 1) {
            paddingLeft = (int) (paddingLeft + this.caretHeight);
        } else if (i7 == 2) {
            paddingTop = (int) (paddingTop + this.caretHeight);
        } else if (i7 == 3) {
            width = (int) (width - this.caretHeight);
        } else if (i7 == 4) {
            height = (int) (height - this.caretHeight);
        }
        drawBorder(canvas, paddingLeft, paddingTop, width, height);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.caretPosition = likeBoxCountViewCaretPosition;
        int i7 = AnonymousClass1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[likeBoxCountViewCaretPosition.ordinal()];
        if (i7 == 1) {
            setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
            return;
        }
        if (i7 == 2) {
            setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
        } else if (i7 == 3) {
            setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
        } else {
            if (i7 != 4) {
                return;
            }
            setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
        }
    }

    @Deprecated
    public void setText(String str) {
        this.likeCountLabel.setText(str);
    }
}
