package androidx.core.graphics;

import android.graphics.Color;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f5902a = 95.047d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f5903b = 100.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f5904c = 108.883d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double f5905d = 0.008856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final double f5906e = 903.3d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f5907f = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5908g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadLocal<double[]> f5909h = new ThreadLocal<>();

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static Color a(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = color2.alpha() * (1.0f - fAlpha);
            int componentCount = color2.getComponentCount() - 1;
            float f8 = fAlpha + fAlpha2;
            components2[componentCount] = f8;
            if (f8 > 0.0f) {
                fAlpha /= f8;
                fAlpha2 /= f8;
            }
            for (int i7 = 0; i7 < componentCount; i7++) {
                components2[i7] = (components[i7] * fAlpha) + (components2[i7] * fAlpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private v1() {
    }

    private static double A(double d8) {
        return d8 > f5905d ? Math.pow(d8, 0.3333333333333333d) : ((d8 * f5906e) + 16.0d) / 116.0d;
    }

    @c.l
    public static int B(@c.l int i7, @c.e0(from = 0, to = 255) int i8) {
        if (i8 < 0 || i8 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i7 & androidx.core.view.n2.f6742s) | (i8 << 24);
    }

    @c.l
    public static int a(@c.m0 float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f8 = fArr[0];
        float f9 = fArr[1];
        float f10 = fArr[2];
        float fAbs = (1.0f - Math.abs((f10 * 2.0f) - 1.0f)) * f9;
        float f11 = f10 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f8 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f8) / 60) {
            case 0:
                iRound = Math.round((fAbs + f11) * 255.0f);
                iRound2 = Math.round((fAbs2 + f11) * 255.0f);
                iRound3 = Math.round(f11 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f11) * 255.0f);
                iRound2 = Math.round((fAbs + f11) * 255.0f);
                iRound3 = Math.round(f11 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f11 * 255.0f);
                iRound2 = Math.round((fAbs + f11) * 255.0f);
                iRound3 = Math.round((fAbs2 + f11) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f11 * 255.0f);
                iRound2 = Math.round((fAbs2 + f11) * 255.0f);
                iRound3 = Math.round((fAbs + f11) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f11) * 255.0f);
                iRound2 = Math.round(f11 * 255.0f);
                iRound3 = Math.round((fAbs + f11) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f11) * 255.0f);
                iRound2 = Math.round(f11 * 255.0f);
                iRound3 = Math.round((fAbs2 + f11) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(x(iRound, 0, 255), x(iRound2, 0, 255), x(iRound3, 0, 255));
    }

    @c.l
    public static int b(@c.v(from = 0.0d, to = f5903b) double d8, @c.v(from = -128.0d, to = 127.0d) double d9, @c.v(from = -128.0d, to = 127.0d) double d10) {
        double[] dArrZ = z();
        c(d8, d9, d10, dArrZ);
        return g(dArrZ[0], dArrZ[1], dArrZ[2]);
    }

    public static void c(@c.v(from = 0.0d, to = f5903b) double d8, @c.v(from = -128.0d, to = 127.0d) double d9, @c.v(from = -128.0d, to = 127.0d) double d10, @c.m0 double[] dArr) {
        double d11 = (d8 + 16.0d) / 116.0d;
        double d12 = (d9 / 500.0d) + d11;
        double d13 = d11 - (d10 / 200.0d);
        double dPow = Math.pow(d12, 3.0d);
        if (dPow <= f5905d) {
            dPow = ((d12 * 116.0d) - 16.0d) / f5906e;
        }
        double dPow2 = d8 > 7.9996247999999985d ? Math.pow(d11, 3.0d) : d8 / f5906e;
        double dPow3 = Math.pow(d13, 3.0d);
        if (dPow3 <= f5905d) {
            dPow3 = ((d13 * 116.0d) - 16.0d) / f5906e;
        }
        dArr[0] = dPow * f5902a;
        dArr[1] = dPow2 * f5903b;
        dArr[2] = dPow3 * f5904c;
    }

    public static void d(@c.e0(from = 0, to = 255) int i7, @c.e0(from = 0, to = 255) int i8, @c.e0(from = 0, to = 255) int i9, @c.m0 float[] fArr) {
        float f8;
        float fAbs;
        float f9 = i7 / 255.0f;
        float f10 = i8 / 255.0f;
        float f11 = i9 / 255.0f;
        float fMax = Math.max(f9, Math.max(f10, f11));
        float fMin = Math.min(f9, Math.min(f10, f11));
        float f12 = fMax - fMin;
        float f13 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f8 = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f9) {
                f8 = ((f10 - f11) / f12) % 6.0f;
            } else {
                f8 = fMax == f10 ? ((f11 - f9) / f12) + 2.0f : 4.0f + ((f9 - f10) / f12);
            }
            fAbs = f12 / (1.0f - Math.abs((2.0f * f13) - 1.0f));
        }
        float f14 = (f8 * 60.0f) % 360.0f;
        if (f14 < 0.0f) {
            f14 += 360.0f;
        }
        fArr[0] = w(f14, 0.0f, 360.0f);
        fArr[1] = w(fAbs, 0.0f, 1.0f);
        fArr[2] = w(f13, 0.0f, 1.0f);
    }

    public static void e(@c.e0(from = 0, to = 255) int i7, @c.e0(from = 0, to = 255) int i8, @c.e0(from = 0, to = 255) int i9, @c.m0 double[] dArr) {
        f(i7, i8, i9, dArr);
        h(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void f(@c.e0(from = 0, to = 255) int i7, @c.e0(from = 0, to = 255) int i8, @c.e0(from = 0, to = 255) int i9, @c.m0 double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d8 = ((double) i7) / 255.0d;
        double dPow = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        double d9 = ((double) i8) / 255.0d;
        double dPow2 = d9 < 0.04045d ? d9 / 12.92d : Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
        double d10 = ((double) i9) / 255.0d;
        double dPow3 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * f5903b;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * f5903b;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * f5903b;
    }

    @c.l
    public static int g(@c.v(from = 0.0d, to = f5902a) double d8, @c.v(from = 0.0d, to = f5903b) double d9, @c.v(from = 0.0d, to = f5904c) double d10) {
        double d11 = (((3.2406d * d8) + ((-1.5372d) * d9)) + ((-0.4986d) * d10)) / f5903b;
        double d12 = ((((-0.9689d) * d8) + (1.8758d * d9)) + (0.0415d * d10)) / f5903b;
        double d13 = (((0.0557d * d8) + ((-0.204d) * d9)) + (1.057d * d10)) / f5903b;
        return Color.rgb(x((int) Math.round((d11 > 0.0031308d ? (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d : d11 * 12.92d) * 255.0d), 0, 255), x((int) Math.round((d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d) * 255.0d), 0, 255), x((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, 255));
    }

    public static void h(@c.v(from = 0.0d, to = f5902a) double d8, @c.v(from = 0.0d, to = f5903b) double d9, @c.v(from = 0.0d, to = f5904c) double d10, @c.m0 double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dA = A(d8 / f5902a);
        double dA2 = A(d9 / f5903b);
        double dA3 = A(d10 / f5904c);
        dArr[0] = Math.max(0.0d, (116.0d * dA2) - 16.0d);
        dArr[1] = (dA - dA2) * 500.0d;
        dArr[2] = (dA2 - dA3) * 200.0d;
    }

    @c.l
    public static int i(@c.l int i7, @c.l int i8, @c.v(from = 0.0d, to = 1.0d) float f8) {
        float f9 = 1.0f - f8;
        return Color.argb((int) ((Color.alpha(i7) * f9) + (Color.alpha(i8) * f8)), (int) ((Color.red(i7) * f9) + (Color.red(i8) * f8)), (int) ((Color.green(i7) * f9) + (Color.green(i8) * f8)), (int) ((Color.blue(i7) * f9) + (Color.blue(i8) * f8)));
    }

    public static void j(@c.m0 float[] fArr, @c.m0 float[] fArr2, @c.v(from = 0.0d, to = 1.0d) float f8, @c.m0 float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f9 = 1.0f - f8;
        fArr3[0] = o(fArr[0], fArr2[0], f8);
        fArr3[1] = (fArr[1] * f9) + (fArr2[1] * f8);
        fArr3[2] = (fArr[2] * f9) + (fArr2[2] * f8);
    }

    public static void k(@c.m0 double[] dArr, @c.m0 double[] dArr2, @c.v(from = 0.0d, to = 1.0d) double d8, @c.m0 double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d9 = 1.0d - d8;
        dArr3[0] = (dArr[0] * d9) + (dArr2[0] * d8);
        dArr3[1] = (dArr[1] * d9) + (dArr2[1] * d8);
        dArr3[2] = (dArr[2] * d9) + (dArr2[2] * d8);
    }

    public static double l(@c.l int i7, @c.l int i8) {
        if (Color.alpha(i8) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i8));
        }
        if (Color.alpha(i7) < 255) {
            i7 = t(i7, i8);
        }
        double dM = m(i7) + 0.05d;
        double dM2 = m(i8) + 0.05d;
        return Math.max(dM, dM2) / Math.min(dM, dM2);
    }

    @c.v(from = 0.0d, to = 1.0d)
    public static double m(@c.l int i7) {
        double[] dArrZ = z();
        r(i7, dArrZ);
        return dArrZ[1] / f5903b;
    }

    public static int n(@c.l int i7, @c.l int i8, float f8) {
        int i9 = 255;
        if (Color.alpha(i8) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i8));
        }
        double d8 = f8;
        if (l(B(i7, 255), i8) < d8) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 <= 10 && i9 - i10 > 1; i11++) {
            int i12 = (i10 + i9) / 2;
            if (l(B(i7, i12), i8) < d8) {
                i10 = i12;
            } else {
                i9 = i12;
            }
        }
        return i9;
    }

    @c.g1
    static float o(float f8, float f9, float f10) {
        if (Math.abs(f9 - f8) > 180.0f) {
            if (f9 > f8) {
                f8 += 360.0f;
            } else {
                f9 += 360.0f;
            }
        }
        return (f8 + ((f9 - f8) * f10)) % 360.0f;
    }

    public static void p(@c.l int i7, @c.m0 float[] fArr) {
        d(Color.red(i7), Color.green(i7), Color.blue(i7), fArr);
    }

    public static void q(@c.l int i7, @c.m0 double[] dArr) {
        e(Color.red(i7), Color.green(i7), Color.blue(i7), dArr);
    }

    public static void r(@c.l int i7, @c.m0 double[] dArr) {
        f(Color.red(i7), Color.green(i7), Color.blue(i7), dArr);
    }

    private static int s(int i7, int i8) {
        return 255 - (((255 - i8) * (255 - i7)) / 255);
    }

    public static int t(@c.l int i7, @c.l int i8) {
        int iAlpha = Color.alpha(i8);
        int iAlpha2 = Color.alpha(i7);
        int iS = s(iAlpha2, iAlpha);
        return Color.argb(iS, v(Color.red(i7), iAlpha2, Color.red(i8), iAlpha, iS), v(Color.green(i7), iAlpha2, Color.green(i8), iAlpha, iS), v(Color.blue(i7), iAlpha2, Color.blue(i8), iAlpha, iS));
    }

    @c.t0(26)
    @c.m0
    public static Color u(@c.m0 Color color, @c.m0 Color color2) {
        return a.a(color, color2);
    }

    private static int v(int i7, int i8, int i9, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        return (((i7 * 255) * i8) + ((i9 * i10) * (255 - i8))) / (i11 * 255);
    }

    private static float w(float f8, float f9, float f10) {
        return f8 < f9 ? f9 : Math.min(f8, f10);
    }

    private static int x(int i7, int i8, int i9) {
        return i7 < i8 ? i8 : Math.min(i7, i9);
    }

    public static double y(@c.m0 double[] dArr, @c.m0 double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] z() {
        ThreadLocal<double[]> threadLocal = f5909h;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }
}
