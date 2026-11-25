package a2;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private a() {
    }

    public static float a(float f8, float f9, float f10, float f11) {
        float f12 = f8 - f10;
        float f13 = f9 - f11;
        return (float) Math.sqrt((f12 * f12) + (f13 * f13));
    }

    public static float b(int i7, int i8, int i9, int i10) {
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        return (float) Math.sqrt((i11 * i11) + (i12 * i12));
    }

    public static int c(float f8) {
        return (int) (f8 + (f8 < 0.0f ? -0.5f : 0.5f));
    }

    public static int d(int[] iArr) {
        int i7 = 0;
        for (int i8 : iArr) {
            i7 += i8;
        }
        return i7;
    }
}
