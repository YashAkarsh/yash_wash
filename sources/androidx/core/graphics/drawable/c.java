package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    @a7.d
    public static final ColorDrawable a(@c.l int i7) {
        return new ColorDrawable(i7);
    }

    @a7.d
    @t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorDrawable b(@a7.d Color color) {
        l0.p(color, "<this>");
        return new ColorDrawable(color.toArgb());
    }
}
