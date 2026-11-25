package com.google.android.material.shape;

import android.graphics.RectF;
import c.m0;
import c.v;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f18280a;

    public m(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f18280a = f8;
    }

    @Override // com.google.android.material.shape.d
    public float a(@m0 RectF rectF) {
        return this.f18280a * rectF.height();
    }

    @v(from = 0.0d, to = 1.0d)
    public float b() {
        return this.f18280a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.f18280a == ((m) obj).f18280a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f18280a)});
    }
}
