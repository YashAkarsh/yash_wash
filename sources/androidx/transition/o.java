package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Matrix f10760a = new a();

    static class a extends Matrix {
        a() {
        }

        void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f8, float f9, float f10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f8, float f9, float f10, float f11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f8, float f9, float f10, float f11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f8, float f9, float f10) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f8, float f9, float f10, float f11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f8, float f9, float f10, float f11) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            a();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i7, float[] fArr2, int i8, int i9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f8, float f9, float f10) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f8, float f9, float f10, float f11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f8, float f9, float f10, float f11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f8, float f9, float f10, float f11) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f8, float f9) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f8) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f8) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f8, float f9) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f8) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f8, float f9) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f8, float f9) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f8, float f9) {
            a();
        }
    }

    private o() {
    }
}
