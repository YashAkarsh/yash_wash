package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.d;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class a extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9854c = 503316480;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9855d = 1023410176;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f9856e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f9857f = 1.75f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f9858g = 3.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9859h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f9860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9861b;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    private class C0126a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RadialGradient f9862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Paint f9863b = new Paint();

        C0126a(int i7) {
            a.this.f9861b = i7;
            a((int) rect().width());
        }

        private void a(int i7) {
            float f8 = i7 / 2;
            RadialGradient radialGradient = new RadialGradient(f8, f8, a.this.f9861b, new int[]{a.f9855d, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f9862a = radialGradient;
            this.f9863b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f8 = width;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(f8, height, f8, this.f9863b);
            canvas.drawCircle(f8, height, width - a.this.f9861b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f8, float f9) {
            super.onResize(f8, f9);
            a((int) f8);
        }
    }

    a(Context context, int i7) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f8 = getContext().getResources().getDisplayMetrics().density;
        int i8 = (int) (f9857f * f8);
        int i9 = (int) (0.0f * f8);
        this.f9861b = (int) (f9858g * f8);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            n2.N1(this, f8 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0126a(this.f9861b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f9861b, i9, i8, f9854c);
            int i10 = this.f9861b;
            setPadding(i10, i10, i10, i10);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i7);
        n2.I1(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f9860a = animationListener;
    }

    public void c(int i7) {
        setBackgroundColor(d.f(getContext(), i7));
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f9860a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f9860a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f9861b * 2), getMeasuredHeight() + (this.f9861b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i7);
        }
    }
}
