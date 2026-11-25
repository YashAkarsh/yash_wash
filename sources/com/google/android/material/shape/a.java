package com.google.android.material.shape;

import android.graphics.RectF;
import c.m0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f18213a;

    public a(float f8) {
        this.f18213a = f8;
    }

    @Override // com.google.android.material.shape.d
    public float a(@m0 RectF rectF) {
        return this.f18213a;
    }

    public float b() {
        return this.f18213a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f18213a == ((a) obj).f18213a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f18213a)});
    }
}
