package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final String W = "android:changeImageTransform:matrix";
    private static final String X = "android:changeImageTransform:bounds";
    private static final String[] Y = {W, X};
    private static final TypeEvaluator<Matrix> Z = new a();
    private static final Property<ImageView, Matrix> A0 = new b(Matrix.class, "animatedTransform");

    static class a implements TypeEvaluator<Matrix> {
        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f8, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    static class b extends Property<ImageView, Matrix> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            n.a(imageView, matrix);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10578a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f10578a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10578a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChangeImageTransform() {
    }

    private void D0(d0 d0Var) {
        View view = d0Var.f10675b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = d0Var.f10674a;
            map.put(X, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put(W, F0(imageView));
        }
    }

    private static Matrix E0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f8 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f9 = intrinsicHeight;
        float fMax = Math.max(width / f8, height / f9);
        int iRound = Math.round((width - (f8 * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f9 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }

    @c.m0
    private static Matrix F0(@c.m0 ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i7 = c.f10578a[imageView.getScaleType().ordinal()];
            if (i7 == 1) {
                return I0(imageView);
            }
            if (i7 == 2) {
                return E0(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    private ObjectAnimator G0(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) A0, (TypeEvaluator) new c0.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    @c.m0
    private ObjectAnimator H0(@c.m0 ImageView imageView) {
        Property<ImageView, Matrix> property = A0;
        TypeEvaluator<Matrix> typeEvaluator = Z;
        Matrix matrix = o.f10760a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    private static Matrix I0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public String[] V() {
        return Y;
    }

    @Override // androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public Animator r(@c.m0 ViewGroup viewGroup, d0 d0Var, d0 d0Var2) {
        if (d0Var == null || d0Var2 == null) {
            return null;
        }
        Rect rect = (Rect) d0Var.f10674a.get(X);
        Rect rect2 = (Rect) d0Var2.f10674a.get(X);
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) d0Var.f10674a.get(W);
        Matrix matrix2 = (Matrix) d0Var2.f10674a.get(W);
        boolean z7 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z7) {
            return null;
        }
        ImageView imageView = (ImageView) d0Var2.f10675b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return H0(imageView);
        }
        if (matrix == null) {
            matrix = o.f10760a;
        }
        if (matrix2 == null) {
            matrix2 = o.f10760a;
        }
        A0.set(imageView, matrix);
        return G0(imageView, matrix, matrix2);
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
