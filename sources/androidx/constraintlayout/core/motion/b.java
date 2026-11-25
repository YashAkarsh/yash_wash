package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.w;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2530g = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2536f;

    public b(b bVar) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = bVar.f2531a;
        this.f2532b = bVar.f2532b;
        this.f2533c = bVar.f2533c;
        this.f2534d = bVar.f2534d;
        this.f2535e = bVar.f2535e;
        this.f2536f = bVar.f2536f;
    }

    private static int b(int i7) {
        int i8 = (i7 & (~(i7 >> 31))) - 255;
        return (i8 & (i8 >> 31)) + 255;
    }

    public static String c(int i7) {
        String str = "00000000" + Integer.toHexString(i7);
        return "#" + str.substring(str.length() - 8);
    }

    public static int p(float f8, float f9, float f10) {
        float f11 = f8 * 6.0f;
        int i7 = (int) f11;
        float f12 = f11 - i7;
        float f13 = f10 * 255.0f;
        int i8 = (int) (((1.0f - f9) * f13) + 0.5f);
        int i9 = (int) (((1.0f - (f12 * f9)) * f13) + 0.5f);
        int i10 = (int) (((1.0f - ((1.0f - f12) * f9)) * f13) + 0.5f);
        int i11 = (int) (f13 + 0.5f);
        if (i7 == 0) {
            return ((i11 << 16) + (i10 << 8) + i8) | n2.f6743t;
        }
        if (i7 == 1) {
            return ((i9 << 16) + (i11 << 8) + i8) | n2.f6743t;
        }
        if (i7 == 2) {
            return ((i8 << 16) + (i11 << 8) + i10) | n2.f6743t;
        }
        if (i7 == 3) {
            return ((i8 << 16) + (i9 << 8) + i11) | n2.f6743t;
        }
        if (i7 == 4) {
            return ((i10 << 16) + (i8 << 8) + i11) | n2.f6743t;
        }
        if (i7 != 5) {
            return 0;
        }
        return ((i11 << 16) + (i8 << 8) + i9) | n2.f6743t;
    }

    public static int s(float f8, float f9, float f10, float f11) {
        int iB = b((int) (f8 * 255.0f));
        int iB2 = b((int) (f9 * 255.0f));
        return (iB << 16) | (b((int) (f11 * 255.0f)) << 24) | (iB2 << 8) | b((int) (f10 * 255.0f));
    }

    public void a(f fVar) {
        int i7 = this.f2532b;
        switch (i7) {
            case w.b.f3035j /* 900 */:
            case w.b.f3037l /* 902 */:
            case w.b.f3041p /* 906 */:
                fVar.J(this.f2531a, i7, this.f2533c);
                break;
            case w.b.f3036k /* 901 */:
            case w.b.f3040o /* 905 */:
                fVar.I(this.f2531a, i7, this.f2534d);
                break;
            case w.b.f3038m /* 903 */:
                fVar.K(this.f2531a, i7, this.f2535e);
                break;
            case w.b.f3039n /* 904 */:
                fVar.L(this.f2531a, i7, this.f2536f);
                break;
        }
    }

    public b d() {
        return new b(this);
    }

    public boolean e(b bVar) {
        int i7;
        if (bVar == null || (i7 = this.f2532b) != bVar.f2532b) {
            return false;
        }
        switch (i7) {
            case w.b.f3035j /* 900 */:
            case w.b.f3041p /* 906 */:
                return this.f2533c == bVar.f2533c;
            case w.b.f3036k /* 901 */:
                return this.f2534d == bVar.f2534d;
            case w.b.f3037l /* 902 */:
                return this.f2533c == bVar.f2533c;
            case w.b.f3038m /* 903 */:
                return this.f2533c == bVar.f2533c;
            case w.b.f3039n /* 904 */:
                return this.f2536f == bVar.f2536f;
            case w.b.f3040o /* 905 */:
                return this.f2534d == bVar.f2534d;
            default:
                return false;
        }
    }

    public boolean f() {
        return this.f2536f;
    }

    public int g() {
        return this.f2533c;
    }

    public float h() {
        return this.f2534d;
    }

    public int i() {
        return this.f2533c;
    }

    public int j(float[] fArr) {
        return (b((int) (fArr[3] * 255.0f)) << 24) | (b((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (b((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | b((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String k() {
        return this.f2531a;
    }

    public String l() {
        return this.f2535e;
    }

    public int m() {
        return this.f2532b;
    }

    public float n() {
        switch (this.f2532b) {
            case w.b.f3035j /* 900 */:
                return this.f2533c;
            case w.b.f3036k /* 901 */:
                return this.f2534d;
            case w.b.f3037l /* 902 */:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case w.b.f3038m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f3039n /* 904 */:
                return this.f2536f ? 1.0f : 0.0f;
            case w.b.f3040o /* 905 */:
                return this.f2534d;
            default:
                return Float.NaN;
        }
    }

    public void o(float[] fArr) {
        switch (this.f2532b) {
            case w.b.f3035j /* 900 */:
                fArr[0] = this.f2533c;
                return;
            case w.b.f3036k /* 901 */:
                fArr[0] = this.f2534d;
                return;
            case w.b.f3037l /* 902 */:
                int i7 = this.f2533c;
                int i8 = (i7 >> 24) & 255;
                float fPow = (float) Math.pow(((i7 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((i7 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((i7 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i8 / 255.0f;
                return;
            case w.b.f3038m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f3039n /* 904 */:
                fArr[0] = this.f2536f ? 1.0f : 0.0f;
                return;
            case w.b.f3040o /* 905 */:
                fArr[0] = this.f2534d;
                return;
            default:
                return;
        }
    }

    public boolean q() {
        int i7 = this.f2532b;
        return (i7 == 903 || i7 == 904 || i7 == 906) ? false : true;
    }

    public int r() {
        return this.f2532b != 902 ? 1 : 4;
    }

    public void t(boolean z7) {
        this.f2536f = z7;
    }

    public String toString() {
        String str = this.f2531a + ':';
        switch (this.f2532b) {
            case w.b.f3035j /* 900 */:
                return str + this.f2533c;
            case w.b.f3036k /* 901 */:
                return str + this.f2534d;
            case w.b.f3037l /* 902 */:
                return str + c(this.f2533c);
            case w.b.f3038m /* 903 */:
                return str + this.f2535e;
            case w.b.f3039n /* 904 */:
                return str + Boolean.valueOf(this.f2536f);
            case w.b.f3040o /* 905 */:
                return str + this.f2534d;
            default:
                return str + "????";
        }
    }

    public void u(float f8) {
        this.f2534d = f8;
    }

    public void v(int i7) {
        this.f2533c = i7;
    }

    public void w(f fVar, float[] fArr) {
        int i7 = this.f2532b;
        switch (i7) {
            case w.b.f3035j /* 900 */:
                fVar.J(this.f2531a, i7, (int) fArr[0]);
                return;
            case w.b.f3036k /* 901 */:
            case w.b.f3040o /* 905 */:
                fVar.I(this.f2531a, i7, fArr[0]);
                return;
            case w.b.f3037l /* 902 */:
                fVar.J(this.f2531a, this.f2532b, (b((int) (fArr[3] * 255.0f)) << 24) | (b((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (b((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | b((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case w.b.f3038m /* 903 */:
            case w.b.f3041p /* 906 */:
                throw new RuntimeException("unable to interpolate " + this.f2531a);
            case w.b.f3039n /* 904 */:
                fVar.L(this.f2531a, i7, fArr[0] > 0.5f);
                return;
            default:
                return;
        }
    }

    public void x(String str) {
        this.f2535e = str;
    }

    public void y(Object obj) {
        switch (this.f2532b) {
            case w.b.f3035j /* 900 */:
            case w.b.f3041p /* 906 */:
                this.f2533c = ((Integer) obj).intValue();
                break;
            case w.b.f3036k /* 901 */:
                this.f2534d = ((Float) obj).floatValue();
                break;
            case w.b.f3037l /* 902 */:
                this.f2533c = ((Integer) obj).intValue();
                break;
            case w.b.f3038m /* 903 */:
                this.f2535e = (String) obj;
                break;
            case w.b.f3039n /* 904 */:
                this.f2536f = ((Boolean) obj).booleanValue();
                break;
            case w.b.f3040o /* 905 */:
                this.f2534d = ((Float) obj).floatValue();
                break;
        }
    }

    public void z(float[] fArr) {
        switch (this.f2532b) {
            case w.b.f3035j /* 900 */:
            case w.b.f3041p /* 906 */:
                this.f2533c = (int) fArr[0];
                return;
            case w.b.f3036k /* 901 */:
            case w.b.f3040o /* 905 */:
                this.f2534d = fArr[0];
                return;
            case w.b.f3037l /* 902 */:
                this.f2533c = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case w.b.f3038m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f3039n /* 904 */:
                this.f2536f = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public b(String str, int i7, String str2) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2531a = str;
        this.f2532b = i7;
        this.f2535e = str2;
    }

    public b(String str, int i7, int i8) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = str;
        this.f2532b = i7;
        if (i7 == 901) {
            this.f2534d = i8;
        } else {
            this.f2533c = i8;
        }
    }

    public b(String str, int i7, float f8) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2535e = null;
        this.f2531a = str;
        this.f2532b = i7;
        this.f2534d = f8;
    }

    public b(String str, int i7, boolean z7) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = str;
        this.f2532b = i7;
        this.f2536f = z7;
    }

    public b(String str, int i7) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = str;
        this.f2532b = i7;
    }

    public b(String str, int i7, Object obj) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = str;
        this.f2532b = i7;
        y(obj);
    }

    public b(b bVar, Object obj) {
        this.f2533c = Integer.MIN_VALUE;
        this.f2534d = Float.NaN;
        this.f2535e = null;
        this.f2531a = bVar.f2531a;
        this.f2532b = bVar.f2532b;
        y(obj);
    }
}
