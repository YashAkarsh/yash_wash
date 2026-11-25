package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f16855a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f16855a = new Matrix();
    }

    @Override // android.util.Property
    @m0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(@m0 ImageView imageView) {
        this.f16855a.set(imageView.getImageMatrix());
        return this.f16855a;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@m0 ImageView imageView, @m0 Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
