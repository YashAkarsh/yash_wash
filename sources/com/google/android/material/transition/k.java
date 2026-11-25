package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.transition.PathMotion;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class k extends PathMotion {
    private static PointF b(float f8, float f9, float f10, float f11) {
        return f9 > f11 ? new PointF(f10, f9) : new PointF(f8, f11);
    }

    @Override // androidx.transition.PathMotion
    @m0
    public Path a(float f8, float f9, float f10, float f11) {
        Path path = new Path();
        path.moveTo(f8, f9);
        PointF pointFB = b(f8, f9, f10, f11);
        path.quadTo(pointFB.x, pointFB.y, f10, f11);
        return path;
    }
}
