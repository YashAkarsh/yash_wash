package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class k extends PathMotion {
    private static PointF a(float f8, float f9, float f10, float f11) {
        return f9 > f11 ? new PointF(f10, f9) : new PointF(f8, f11);
    }

    @Override // android.transition.PathMotion
    @m0
    public Path getPath(float f8, float f9, float f10, float f11) {
        Path path = new Path();
        path.moveTo(f8, f9);
        PointF pointFA = a(f8, f9, f10, f11);
        path.quadTo(pointFA.x, pointFA.y, f10, f11);
        return path;
    }
}
