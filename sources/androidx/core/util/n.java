package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class n {
    @a7.d
    @t0(26)
    public static final Half a(double d8) {
        Half halfValueOf = Half.valueOf((float) d8);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @a7.d
    @t0(26)
    public static final Half b(float f8) {
        Half halfValueOf = Half.valueOf(f8);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @a7.d
    @t0(26)
    public static final Half c(@a7.d String str) {
        l0.p(str, "<this>");
        Half halfValueOf = Half.valueOf(str);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @a7.d
    @t0(26)
    public static final Half d(short s7) {
        Half halfValueOf = Half.valueOf(s7);
        l0.o(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
