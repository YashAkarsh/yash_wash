package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f32914a = 2048;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.nostra13.universalimageloader.core.assist.e f32915b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32916a;

        static {
            int[] iArr = new int[h.values().length];
            f32916a = iArr;
            try {
                iArr[h.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32916a[h.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        f32915b = new com.nostra13.universalimageloader.core.assist.e(iMax, iMax);
    }

    private b() {
    }

    public static int a(com.nostra13.universalimageloader.core.assist.e eVar, com.nostra13.universalimageloader.core.assist.e eVar2, h hVar, boolean z7) {
        int iMax;
        int iB = eVar.b();
        int iA = eVar.a();
        int iB2 = eVar2.b();
        int iA2 = eVar2.a();
        int i7 = iB / iB2;
        int i8 = iA / iA2;
        int i9 = a.f32916a[hVar.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                iMax = 1;
            } else if (z7) {
                iMax = 1;
                while (true) {
                    iB /= 2;
                    if (iB < iB2 || (iA = iA / 2) < iA2) {
                        break;
                    }
                    iMax *= 2;
                }
            } else {
                iMax = Math.min(i7, i8);
            }
        } else if (z7) {
            iMax = 1;
            while (true) {
                iB /= 2;
                if (iB < iB2 && iA / 2 < iA2) {
                    break;
                }
                iA /= 2;
                iMax *= 2;
            }
        } else {
            iMax = Math.max(i7, i8);
        }
        if (iMax < 1) {
            return 1;
        }
        return iMax;
    }

    public static float b(com.nostra13.universalimageloader.core.assist.e eVar, com.nostra13.universalimageloader.core.assist.e eVar2, h hVar, boolean z7) {
        int iB = eVar.b();
        int iA = eVar.a();
        int iB2 = eVar2.b();
        int iA2 = eVar2.a();
        float f8 = iB;
        float f9 = f8 / iB2;
        float f10 = iA;
        float f11 = f10 / iA2;
        if ((hVar != h.FIT_INSIDE || f9 < f11) && (hVar != h.CROP || f9 >= f11)) {
            iB2 = (int) (f8 / f11);
        } else {
            iA2 = (int) (f10 / f9);
        }
        if ((z7 || iB2 >= iB || iA2 >= iA) && (!z7 || iB2 == iB || iA2 == iA)) {
            return 1.0f;
        }
        return iB2 / f8;
    }

    public static int c(com.nostra13.universalimageloader.core.assist.e eVar) {
        return Math.max((int) Math.ceil(eVar.b() / f32915b.b()), (int) Math.ceil(eVar.a() / f32915b.a()));
    }

    public static com.nostra13.universalimageloader.core.assist.e d(com.nostra13.universalimageloader.core.imageaware.a aVar, com.nostra13.universalimageloader.core.assist.e eVar) {
        int iB = aVar.b();
        if (iB <= 0) {
            iB = eVar.b();
        }
        int iE = aVar.e();
        if (iE <= 0) {
            iE = eVar.a();
        }
        return new com.nostra13.universalimageloader.core.assist.e(iB, iE);
    }
}
