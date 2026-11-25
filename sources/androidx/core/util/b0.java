package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class b0 {
    @t0(21)
    public static final float a(@a7.d SizeF sizeF) {
        l0.p(sizeF, "<this>");
        return sizeF.getWidth();
    }

    public static final float b(@a7.d a0 a0Var) {
        l0.p(a0Var, "<this>");
        return a0Var.b();
    }

    @t0(21)
    public static final int c(@a7.d Size size) {
        l0.p(size, "<this>");
        return size.getWidth();
    }

    @t0(21)
    public static final float d(@a7.d SizeF sizeF) {
        l0.p(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final float e(@a7.d a0 a0Var) {
        l0.p(a0Var, "<this>");
        return a0Var.a();
    }

    @t0(21)
    public static final int f(@a7.d Size size) {
        l0.p(size, "<this>");
        return size.getHeight();
    }
}
