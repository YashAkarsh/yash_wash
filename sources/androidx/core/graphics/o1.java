package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;

/* JADX INFO: loaded from: classes.dex */
public final class o1 {
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float A(long j7) {
        return Color.luminance(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float B(long j7) {
        return Color.red(j7);
    }

    public static final int C(@c.l int i7) {
        return (i7 >> 16) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean D(long j7) {
        return Color.isSrgb(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean E(long j7) {
        return Color.isWideGamut(j7);
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color F(@a7.d Color color, @a7.d Color c8) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        kotlin.jvm.internal.l0.p(c8, "c");
        Color colorU = v1.u(c8, color);
        kotlin.jvm.internal.l0.o(colorU, "compositeColors(c, this)");
        return colorU;
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color G(@c.l int i7) {
        Color colorValueOf = Color.valueOf(i7);
        kotlin.jvm.internal.l0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color H(long j7) {
        Color colorValueOf = Color.valueOf(j7);
        kotlin.jvm.internal.l0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    @c.l
    public static final int I(long j7) {
        return Color.toArgb(j7);
    }

    @c.l
    public static final int J(@a7.d String str) {
        kotlin.jvm.internal.l0.p(str, "<this>");
        return Color.parseColor(str);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long K(@c.l int i7) {
        return Color.pack(i7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float a(long j7) {
        return Color.red(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float b(@a7.d Color color) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        return color.getComponent(0);
    }

    public static final int c(@c.l int i7) {
        return (i7 >> 24) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float d(long j7) {
        return Color.green(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float e(@a7.d Color color) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        return color.getComponent(1);
    }

    public static final int f(@c.l int i7) {
        return (i7 >> 16) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float g(long j7) {
        return Color.blue(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float h(@a7.d Color color) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        return color.getComponent(2);
    }

    public static final int i(@c.l int i7) {
        return (i7 >> 8) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float j(long j7) {
        return Color.alpha(j7);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float k(@a7.d Color color) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        return color.getComponent(3);
    }

    public static final int l(@c.l int i7) {
        return i7 & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long m(@c.l int i7, @a7.d ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        return Color.convert(i7, ColorSpace.get(colorSpace));
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long n(@c.l int i7, @a7.d ColorSpace colorSpace) {
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        return Color.convert(i7, colorSpace);
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long o(long j7, @a7.d ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        return Color.convert(j7, ColorSpace.get(colorSpace));
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long p(long j7, @a7.d ColorSpace colorSpace) {
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        return Color.convert(j7, colorSpace);
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color q(@a7.d Color color, @a7.d ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        Color colorConvert = color.convert(ColorSpace.get(colorSpace));
        kotlin.jvm.internal.l0.o(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color r(@a7.d Color color, @a7.d ColorSpace colorSpace) {
        kotlin.jvm.internal.l0.p(color, "<this>");
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        Color colorConvert = color.convert(colorSpace);
        kotlin.jvm.internal.l0.o(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float s(long j7) {
        return Color.alpha(j7);
    }

    public static final int t(@c.l int i7) {
        return (i7 >> 24) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float u(long j7) {
        return Color.blue(j7);
    }

    public static final int v(@c.l int i7) {
        return i7 & 255;
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorSpace w(long j7) {
        ColorSpace colorSpace = Color.colorSpace(j7);
        kotlin.jvm.internal.l0.o(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float x(long j7) {
        return Color.green(j7);
    }

    public static final int y(@c.l int i7) {
        return (i7 >> 8) & 255;
    }

    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float z(@c.l int i7) {
        return Color.luminance(i7);
    }
}
