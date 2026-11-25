package p1;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f40075a = 1.0E-4f;

    private a() {
    }

    public static float a(float f8, float f9, float f10, float f11) {
        return (float) Math.hypot(f10 - f8, f11 - f9);
    }

    public static float b(float f8, float f9, float f10, float f11, float f12, float f13) {
        return g(a(f8, f9, f10, f11), a(f8, f9, f12, f11), a(f8, f9, f12, f13), a(f8, f9, f10, f13));
    }

    public static float c(float f8, int i7) {
        float f9 = i7;
        int i8 = (int) (f8 / f9);
        if (Math.signum(f8) * f9 < 0.0f && i8 * i7 != f8) {
            i8--;
        }
        return f8 - (i8 * i7);
    }

    public static int d(int i7, int i8) {
        int i9 = i7 / i8;
        if ((i7 ^ i8) < 0 && i9 * i8 != i7) {
            i9--;
        }
        return i7 - (i9 * i8);
    }

    public static boolean e(float f8, float f9, float f10) {
        return f8 + f10 >= f9;
    }

    public static float f(float f8, float f9, float f10) {
        return ((1.0f - f10) * f8) + (f10 * f9);
    }

    private static float g(float f8, float f9, float f10, float f11) {
        if (f8 > f9 && f8 > f10 && f8 > f11) {
            return f8;
        }
        if (f9 <= f10 || f9 <= f11) {
            return f10 > f11 ? f10 : f11;
        }
        return f9;
    }
}
