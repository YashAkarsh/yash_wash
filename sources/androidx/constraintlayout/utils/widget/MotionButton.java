package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Path f4428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ViewOutlineProvider f4429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    RectF f4430h;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = MotionButton.this.getWidth();
            int height = MotionButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionButton.this.f4426d) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f4427e);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f4426d = 0.0f;
        this.f4427e = Float.NaN;
        d(context, null);
    }

    private void d(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f4427e;
    }

    public float getRoundPercent() {
        return this.f4426d;
    }

    @t0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f4427e = round;
            float f8 = this.f4426d;
            this.f4426d = -1.0f;
            setRoundPercent(f8);
            return;
        }
        boolean z7 = this.f4427e != round;
        this.f4427e = round;
        if (round != 0.0f) {
            if (this.f4428f == null) {
                this.f4428f = new Path();
            }
            if (this.f4430h == null) {
                this.f4430h = new RectF();
            }
            if (this.f4429g == null) {
                b bVar = new b();
                this.f4429g = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f4430h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f4428f.reset();
            Path path = this.f4428f;
            RectF rectF = this.f4430h;
            float f9 = this.f4427e;
            path.addRoundRect(rectF, f9, f9, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    @t0(21)
    public void setRoundPercent(float round) {
        boolean z7 = this.f4426d != round;
        this.f4426d = round;
        if (round != 0.0f) {
            if (this.f4428f == null) {
                this.f4428f = new Path();
            }
            if (this.f4430h == null) {
                this.f4430h = new RectF();
            }
            if (this.f4429g == null) {
                a aVar = new a();
                this.f4429g = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f4426d) / 2.0f;
            this.f4430h.set(0.0f, 0.0f, width, height);
            this.f4428f.reset();
            this.f4428f.addRoundRect(this.f4430h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4426d = 0.0f;
        this.f4427e = Float.NaN;
        d(context, attrs);
    }

    public MotionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4426d = 0.0f;
        this.f4427e = Float.NaN;
        d(context, attrs);
    }
}
