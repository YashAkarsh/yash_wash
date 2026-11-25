package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1893c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProgressBar f1894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f1895b;

    @c.t0(23)
    private static class a {
        private a() {
        }

        public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i7) {
            layerDrawable2.setLayerGravity(i7, layerDrawable.getLayerGravity(i7));
            layerDrawable2.setLayerWidth(i7, layerDrawable.getLayerWidth(i7));
            layerDrawable2.setLayerHeight(i7, layerDrawable.getLayerHeight(i7));
            layerDrawable2.setLayerInsetLeft(i7, layerDrawable.getLayerInsetLeft(i7));
            layerDrawable2.setLayerInsetRight(i7, layerDrawable.getLayerInsetRight(i7));
            layerDrawable2.setLayerInsetTop(i7, layerDrawable.getLayerInsetTop(i7));
            layerDrawable2.setLayerInsetBottom(i7, layerDrawable.getLayerInsetBottom(i7));
            layerDrawable2.setLayerInsetStart(i7, layerDrawable.getLayerInsetStart(i7));
            layerDrawable2.setLayerInsetEnd(i7, layerDrawable.getLayerInsetEnd(i7));
        }
    }

    l(ProgressBar progressBar) {
        this.f1894a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i7 = 0; i7 < numberOfFrames; i7++) {
            Drawable drawableD = d(animationDrawable.getFrame(i7), true);
            drawableD.setLevel(com.haier.library.sumhttp.plugin.h.f27948e);
            animationDrawable2.addFrame(drawableD, animationDrawable.getDuration(i7));
        }
        animationDrawable2.setLevel(com.haier.library.sumhttp.plugin.h.f27948e);
        return animationDrawable2;
    }

    Bitmap b() {
        return this.f1895b;
    }

    void c(AttributeSet attributeSet, int i7) {
        h1 h1VarG = h1.G(this.f1894a.getContext(), attributeSet, f1893c, i7, 0);
        Drawable drawableI = h1VarG.i(0);
        if (drawableI != null) {
            this.f1894a.setIndeterminateDrawable(e(drawableI));
        }
        Drawable drawableI2 = h1VarG.i(1);
        if (drawableI2 != null) {
            this.f1894a.setProgressDrawable(d(drawableI2, false));
        }
        h1VarG.I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c.g1
    Drawable d(Drawable drawable, boolean z7) {
        if (drawable instanceof androidx.core.graphics.drawable.s) {
            androidx.core.graphics.drawable.s sVar = (androidx.core.graphics.drawable.s) drawable;
            Drawable drawableB = sVar.b();
            if (drawableB != null) {
                sVar.a(d(drawableB, z7));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i7 = 0; i7 < numberOfLayers; i7++) {
                    int id = layerDrawable.getId(i7);
                    drawableArr[i7] = d(layerDrawable.getDrawable(i7), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i8 = 0; i8 < numberOfLayers; i8++) {
                    layerDrawable2.setId(i8, layerDrawable.getId(i8));
                    a.a(layerDrawable, layerDrawable2, i8);
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f1895b == null) {
                    this.f1895b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(a());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z7 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
