package androidx.core.graphics;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public final class c2 {
    @a7.d
    public static final Matrix a(float f8, float f9, float f10) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f8, f9, f10);
        return matrix;
    }

    public static /* synthetic */ Matrix b(float f8, float f9, float f10, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            f9 = 0.0f;
        }
        if ((i7 & 4) != 0) {
            f10 = 0.0f;
        }
        return a(f8, f9, f10);
    }

    @a7.d
    public static final Matrix c(float f8, float f9) {
        Matrix matrix = new Matrix();
        matrix.setScale(f8, f9);
        return matrix;
    }

    public static /* synthetic */ Matrix d(float f8, float f9, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 1.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 1.0f;
        }
        return c(f8, f9);
    }

    @a7.d
    public static final Matrix e(@a7.d Matrix matrix, @a7.d Matrix m7) {
        kotlin.jvm.internal.l0.p(matrix, "<this>");
        kotlin.jvm.internal.l0.p(m7, "m");
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preConcat(m7);
        return matrix2;
    }

    @a7.d
    public static final Matrix f(float f8, float f9) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f8, f9);
        return matrix;
    }

    public static /* synthetic */ Matrix g(float f8, float f9, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 0.0f;
        }
        if ((i7 & 2) != 0) {
            f9 = 0.0f;
        }
        return f(f8, f9);
    }

    @a7.d
    public static final float[] h(@a7.d Matrix matrix) {
        kotlin.jvm.internal.l0.p(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
