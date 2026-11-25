package com.google.android.material.shape;

import android.graphics.RectF;
import c.m0;
import c.x0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f18214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f18215b;

    public b(float f8, @m0 d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f18214a;
            f8 += ((b) dVar).f18215b;
        }
        this.f18214a = dVar;
        this.f18215b = f8;
    }

    @Override // com.google.android.material.shape.d
    public float a(@m0 RectF rectF) {
        return Math.max(0.0f, this.f18214a.a(rectF) + this.f18215b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18214a.equals(bVar.f18214a) && this.f18215b == bVar.f18215b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f18214a, Float.valueOf(this.f18215b)});
    }
}
