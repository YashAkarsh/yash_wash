package androidx.constraintlayout.core.motion;

import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2511i = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f2513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f2518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2519h;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0037a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2520a;

        static {
            int[] iArr = new int[b.values().length];
            f2520a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2520a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2520a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2520a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2520a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2520a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2520a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2520a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String str, b bVar) {
        this.f2512a = false;
        this.f2513b = str;
        this.f2514c = bVar;
    }

    private static int a(int i7) {
        int i8 = (i7 & (~(i7 >> 31))) - 255;
        return (i8 & (i8 >> 31)) + 255;
    }

    public static int f(float f8, float f9, float f10) {
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

    public boolean b(a aVar) {
        b bVar;
        if (aVar == null || (bVar = this.f2514c) != aVar.f2514c) {
            return false;
        }
        switch (C0037a.f2520a[bVar.ordinal()]) {
            case 1:
            case 6:
                return this.f2515d == aVar.f2515d;
            case 2:
                return this.f2518g == aVar.f2518g;
            case 3:
                return this.f2515d == aVar.f2515d;
            case 4:
            case 5:
                return this.f2519h == aVar.f2519h;
            case 7:
                return this.f2516e == aVar.f2516e;
            case 8:
                return this.f2516e == aVar.f2516e;
            default:
                return false;
        }
    }

    public b c() {
        return this.f2514c;
    }

    public float d() {
        switch (C0037a.f2520a[this.f2514c.ordinal()]) {
            case 2:
                return this.f2518g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f2515d;
            case 7:
                return this.f2516e;
            case 8:
                return this.f2516e;
            default:
                return Float.NaN;
        }
    }

    public void e(float[] fArr) {
        switch (C0037a.f2520a[this.f2514c.ordinal()]) {
            case 2:
                fArr[0] = this.f2518g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i7 = this.f2519h;
                int i8 = (i7 >> 24) & 255;
                float fPow = (float) Math.pow(((i7 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((i7 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((i7 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i8 / 255.0f;
                return;
            case 6:
                fArr[0] = this.f2515d;
                return;
            case 7:
                fArr[0] = this.f2516e;
                return;
            case 8:
                fArr[0] = this.f2516e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i7 = C0037a.f2520a[this.f2514c.ordinal()];
        return (i7 == 1 || i7 == 2 || i7 == 3) ? false : true;
    }

    public int h() {
        int i7 = C0037a.f2520a[this.f2514c.ordinal()];
        return (i7 == 4 || i7 == 5) ? 4 : 1;
    }

    public void i(int i7) {
        this.f2519h = i7;
    }

    public void j(float f8) {
        this.f2516e = f8;
    }

    public void k(int i7) {
        this.f2515d = i7;
    }

    public void l(String str) {
        this.f2517f = str;
    }

    public void m(Object obj) {
        switch (C0037a.f2520a[this.f2514c.ordinal()]) {
            case 1:
            case 6:
                this.f2515d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f2518g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f2517f = (String) obj;
                break;
            case 4:
            case 5:
                this.f2519h = ((Integer) obj).intValue();
                break;
            case 7:
                this.f2516e = ((Float) obj).floatValue();
                break;
            case 8:
                this.f2516e = ((Float) obj).floatValue();
                break;
        }
    }

    public void n(float[] fArr) {
        switch (C0037a.f2520a[this.f2514c.ordinal()]) {
            case 1:
            case 6:
                this.f2515d = (int) fArr[0];
                return;
            case 2:
                this.f2518g = ((double) fArr[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iF = f(fArr[0], fArr[1], fArr[2]);
                this.f2519h = iF;
                this.f2519h = (a((int) (fArr[3] * 255.0f)) << 24) | (iF & n2.f6742s);
                return;
            case 7:
                this.f2516e = fArr[0];
                return;
            case 8:
                this.f2516e = fArr[0];
                return;
            default:
                return;
        }
    }

    public a(String str, b bVar, Object obj, boolean z7) {
        this.f2513b = str;
        this.f2514c = bVar;
        this.f2512a = z7;
        m(obj);
    }

    public a(a aVar, Object obj) {
        this.f2512a = false;
        this.f2513b = aVar.f2513b;
        this.f2514c = aVar.f2514c;
        m(obj);
    }
}
