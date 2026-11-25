package kotlin.math;

import kotlin.g1;
import kotlin.internal.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class d extends c {
    @g1(version = "1.2")
    @f
    private static final double A(double d8) {
        return Math.cosh(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double A0(double d8) {
        return Math.nextUp(d8);
    }

    @g1(version = "1.2")
    @f
    private static final float B(float f8) {
        return (float) Math.cosh(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float B0(float f8) {
        return Math.nextUp(f8);
    }

    @g1(version = "1.2")
    @f
    private static final double C(double d8) {
        return Math.exp(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double C0(double d8, double d9) {
        return Math.pow(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final float D(float f8) {
        return (float) Math.exp(f8);
    }

    @g1(version = "1.2")
    @f
    private static final double D0(double d8, int i7) {
        return Math.pow(d8, i7);
    }

    @g1(version = "1.2")
    @f
    private static final double E(double d8) {
        return Math.expm1(d8);
    }

    @g1(version = "1.2")
    @f
    private static final float E0(float f8, float f9) {
        return (float) Math.pow(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final float F(float f8) {
        return (float) Math.expm1(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float F0(float f8, int i7) {
        return (float) Math.pow(f8, i7);
    }

    @g1(version = "1.2")
    @f
    private static final double G(double d8) {
        return Math.floor(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double G0(double d8) {
        return Math.rint(d8);
    }

    @g1(version = "1.2")
    @f
    private static final float H(float f8) {
        return (float) Math.floor(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float H0(float f8) {
        return (float) Math.rint(f8);
    }

    private static final double I(double d8) {
        return Math.abs(d8);
    }

    @g1(version = "1.2")
    public static int I0(double d8) {
        if (Double.isNaN(d8)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d8 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d8 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d8);
    }

    private static final float J(float f8) {
        return Math.abs(f8);
    }

    @g1(version = "1.2")
    public static final int J0(float f8) {
        if (Float.isNaN(f8)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f8);
    }

    private static final int K(int i7) {
        return Math.abs(i7);
    }

    @g1(version = "1.2")
    public static long K0(double d8) {
        if (Double.isNaN(d8)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d8);
    }

    private static final long L(long j7) {
        return Math.abs(j7);
    }

    @g1(version = "1.2")
    public static final long L0(float f8) {
        return K0(f8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void M(double d8) {
    }

    @g1(version = "1.2")
    @f
    private static final double M0(double d8) {
        return Math.signum(d8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void N(float f8) {
    }

    @g1(version = "1.2")
    @f
    private static final float N0(float f8) {
        return Math.signum(f8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void O(int i7) {
    }

    @g1(version = "1.2")
    @f
    private static final double O0(double d8) {
        return Math.sin(d8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void P(long j7) {
    }

    @g1(version = "1.2")
    @f
    private static final float P0(float f8) {
        return (float) Math.sin(f8);
    }

    private static final double Q(double d8) {
        return Math.signum(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double Q0(double d8) {
        return Math.sinh(d8);
    }

    private static final float R(float f8) {
        return Math.signum(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float R0(float f8) {
        return (float) Math.sinh(f8);
    }

    public static int S(int i7) {
        if (i7 < 0) {
            return -1;
        }
        return i7 > 0 ? 1 : 0;
    }

    @g1(version = "1.2")
    @f
    private static final double S0(double d8) {
        return Math.sqrt(d8);
    }

    public static int T(long j7) {
        if (j7 < 0) {
            return -1;
        }
        return j7 > 0 ? 1 : 0;
    }

    @g1(version = "1.2")
    @f
    private static final float T0(float f8) {
        return (float) Math.sqrt(f8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void U(double d8) {
    }

    @g1(version = "1.2")
    @f
    private static final double U0(double d8) {
        return Math.tan(d8);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void V(float f8) {
    }

    @g1(version = "1.2")
    @f
    private static final float V0(float f8) {
        return (float) Math.tan(f8);
    }

    @g1(version = "1.2")
    public static /* synthetic */ void W(int i7) {
    }

    @g1(version = "1.2")
    @f
    private static final double W0(double d8) {
        return Math.tanh(d8);
    }

    @g1(version = "1.2")
    public static /* synthetic */ void X(long j7) {
    }

    @g1(version = "1.2")
    @f
    private static final float X0(float f8) {
        return (float) Math.tanh(f8);
    }

    private static final double Y(double d8) {
        return Math.ulp(d8);
    }

    @g1(version = "1.2")
    public static final double Y0(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            return d8;
        }
        return d8 > 0.0d ? Math.floor(d8) : Math.ceil(d8);
    }

    private static final float Z(float f8) {
        return Math.ulp(f8);
    }

    @g1(version = "1.2")
    public static final float Z0(float f8) {
        if (Float.isNaN(f8) || Float.isInfinite(f8)) {
            return f8;
        }
        return (float) (f8 > 0.0f ? Math.floor(f8) : Math.ceil(f8));
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void a0(double d8) {
    }

    @g1(version = "1.2")
    @f
    private static final double a1(double d8, double d9) {
        return Math.copySign(d8, d9);
    }

    @g1(version = "1.2")
    @f
    public static /* synthetic */ void b0(float f8) {
    }

    @g1(version = "1.2")
    @f
    private static final double b1(double d8, int i7) {
        return Math.copySign(d8, i7);
    }

    @g1(version = "1.2")
    @f
    private static final double c(double d8, double d9) {
        return Math.IEEEremainder(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final double c0(double d8, double d9) {
        return Math.hypot(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final float c1(float f8, float f9) {
        return Math.copySign(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final float d(float f8, float f9) {
        return (float) Math.IEEEremainder(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final float d0(float f8, float f9) {
        return (float) Math.hypot(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final float d1(float f8, int i7) {
        return Math.copySign(f8, i7);
    }

    @g1(version = "1.2")
    @f
    private static final double e(double d8) {
        return Math.abs(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double e0(double d8) {
        return Math.log(d8);
    }

    @g1(version = "1.2")
    @f
    private static final float f(float f8) {
        return Math.abs(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float f0(float f8) {
        return (float) Math.log(f8);
    }

    @g1(version = "1.2")
    @f
    private static final int g(int i7) {
        return Math.abs(i7);
    }

    @g1(version = "1.2")
    @f
    private static final double g0(double d8) {
        return Math.log1p(d8);
    }

    @g1(version = "1.2")
    @f
    private static final long h(long j7) {
        return Math.abs(j7);
    }

    @g1(version = "1.2")
    @f
    private static final float h0(float f8) {
        return (float) Math.log1p(f8);
    }

    @g1(version = "1.2")
    @f
    private static final double i(double d8) {
        return Math.acos(d8);
    }

    @g1(version = "1.2")
    public static final double i0(double d8, double d9) {
        if (d9 <= 0.0d) {
            return Double.NaN;
        }
        if (d9 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d8) / Math.log(d9);
    }

    @g1(version = "1.2")
    @f
    private static final float j(float f8) {
        return (float) Math.acos(f8);
    }

    @g1(version = "1.2")
    public static final float j0(float f8, float f9) {
        if (f9 <= 0.0f) {
            return Float.NaN;
        }
        if (f9 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f8) / Math.log(f9));
    }

    @g1(version = "1.2")
    public static final double k(double d8) {
        if (d8 < 1.0d) {
            return Double.NaN;
        }
        if (d8 > a.f34973f) {
            return Math.log(d8) + a.f34969b;
        }
        double d9 = 1;
        double d10 = d8 - d9;
        if (d10 >= a.f34972e) {
            return Math.log(d8 + Math.sqrt((d8 * d8) - d9));
        }
        double dSqrt = Math.sqrt(d10);
        if (dSqrt >= a.f34971d) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / ((double) 12);
        }
        return dSqrt * Math.sqrt(2.0d);
    }

    @g1(version = "1.2")
    @f
    private static final double k0(double d8) {
        return Math.log10(d8);
    }

    @g1(version = "1.2")
    @f
    private static final float l(float f8) {
        return (float) k(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float l0(float f8) {
        return (float) Math.log10(f8);
    }

    @g1(version = "1.2")
    @f
    private static final double m(double d8) {
        return Math.asin(d8);
    }

    @g1(version = "1.2")
    public static final double m0(double d8) {
        return Math.log(d8) / a.f34969b;
    }

    @g1(version = "1.2")
    @f
    private static final float n(float f8) {
        return (float) Math.asin(f8);
    }

    @g1(version = "1.2")
    public static final float n0(float f8) {
        return (float) (Math.log(f8) / a.f34969b);
    }

    @g1(version = "1.2")
    public static final double o(double d8) {
        double d9 = a.f34972e;
        if (d8 < d9) {
            if (d8 <= (-d9)) {
                return -o(-d8);
            }
            return Math.abs(d8) >= a.f34971d ? d8 - (((d8 * d8) * d8) / ((double) 6)) : d8;
        }
        if (d8 <= a.f34974g) {
            return Math.log(d8 + Math.sqrt((d8 * d8) + ((double) 1)));
        }
        if (d8 > a.f34973f) {
            return Math.log(d8) + a.f34969b;
        }
        double d10 = d8 * ((double) 2);
        return Math.log(d10 + (((double) 1) / d10));
    }

    @g1(version = "1.2")
    @f
    private static final double o0(double d8, double d9) {
        return Math.max(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final float p(float f8) {
        return (float) o(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float p0(float f8, float f9) {
        return Math.max(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final double q(double d8) {
        return Math.atan(d8);
    }

    @g1(version = "1.2")
    @f
    private static final int q0(int i7, int i8) {
        return Math.max(i7, i8);
    }

    @g1(version = "1.2")
    @f
    private static final float r(float f8) {
        return (float) Math.atan(f8);
    }

    @g1(version = "1.2")
    @f
    private static final long r0(long j7, long j8) {
        return Math.max(j7, j8);
    }

    @g1(version = "1.2")
    @f
    private static final double s(double d8, double d9) {
        return Math.atan2(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final double s0(double d8, double d9) {
        return Math.min(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final float t(float f8, float f9) {
        return (float) Math.atan2(f8, f9);
    }

    @g1(version = "1.2")
    @f
    private static final float t0(float f8, float f9) {
        return Math.min(f8, f9);
    }

    @g1(version = "1.2")
    public static final double u(double d8) {
        if (Math.abs(d8) < a.f34972e) {
            return Math.abs(d8) > a.f34971d ? d8 + (((d8 * d8) * d8) / ((double) 3)) : d8;
        }
        double d9 = 1;
        return Math.log((d9 + d8) / (d9 - d8)) / ((double) 2);
    }

    @g1(version = "1.2")
    @f
    private static final int u0(int i7, int i8) {
        return Math.min(i7, i8);
    }

    @g1(version = "1.2")
    @f
    private static final float v(float f8) {
        return (float) u(f8);
    }

    @g1(version = "1.2")
    @f
    private static final long v0(long j7, long j8) {
        return Math.min(j7, j8);
    }

    @g1(version = "1.2")
    @f
    private static final double w(double d8) {
        return Math.ceil(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double w0(double d8) {
        return Math.nextAfter(d8, Double.NEGATIVE_INFINITY);
    }

    @g1(version = "1.2")
    @f
    private static final float x(float f8) {
        return (float) Math.ceil(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float x0(float f8) {
        return Math.nextAfter(f8, Double.NEGATIVE_INFINITY);
    }

    @g1(version = "1.2")
    @f
    private static final double y(double d8) {
        return Math.cos(d8);
    }

    @g1(version = "1.2")
    @f
    private static final double y0(double d8, double d9) {
        return Math.nextAfter(d8, d9);
    }

    @g1(version = "1.2")
    @f
    private static final float z(float f8) {
        return (float) Math.cos(f8);
    }

    @g1(version = "1.2")
    @f
    private static final float z0(float f8, float f9) {
        return Math.nextAfter(f8, f9);
    }
}
