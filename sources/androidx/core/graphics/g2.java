package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5843a = "PathParser";

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5845b;

        a() {
        }
    }

    private g2() {
    }

    private static void a(ArrayList<b> arrayList, char c8, float[] fArr) {
        arrayList.add(new b(c8, fArr));
    }

    public static boolean b(@c.o0 b[] bVarArr, @c.o0 b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            b bVar = bVarArr[i7];
            char c8 = bVar.f5846a;
            b bVar2 = bVarArr2[i7];
            if (c8 != bVar2.f5846a || bVar.f5847b.length != bVar2.f5847b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i7, int i8) {
        if (i7 > i8) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i7 < 0 || i7 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = i8 - i7;
        int iMin = Math.min(i9, length - i7);
        float[] fArr2 = new float[i9];
        System.arraycopy(fArr, i7, fArr2, 0, iMin);
        return fArr2;
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i7 = 1;
        int i8 = 0;
        while (i7 < str.length()) {
            int iJ = j(str, i7);
            String strTrim = str.substring(i8, iJ).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i8 = iJ;
            i7 = iJ + 1;
        }
        if (i7 - i8 == 1 && i8 < str.length()) {
            a(arrayList, str.charAt(i8), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] bVarArrD = d(str);
        if (bVarArrD == null) {
            return null;
        }
        try {
            b.e(bVarArrD, path);
            return path;
        } catch (RuntimeException e8) {
            throw new RuntimeException("Error in parsing " + str, e8);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            bVarArr2[i7] = new b(bVarArr[i7]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0035  */
    private static void g(String str, int i7, a aVar) {
        aVar.f5845b = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i8 = i7; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt == ' ') {
                z7 = false;
                z9 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z7 = false;
                        z9 = true;
                        break;
                    case '-':
                        if (i8 == i7 || z7) {
                            z7 = false;
                        } else {
                            aVar.f5845b = true;
                            z7 = false;
                            z9 = true;
                        }
                        break;
                    case '.':
                        if (z8) {
                            aVar.f5845b = true;
                            z7 = false;
                            z9 = true;
                        } else {
                            z7 = false;
                            z8 = true;
                        }
                        break;
                    default:
                        z7 = false;
                        break;
                }
            } else {
                z7 = true;
            }
            if (z9) {
                aVar.f5844a = i8;
            }
        }
        aVar.f5844a = i8;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i7 = 1;
            int i8 = 0;
            while (i7 < length) {
                g(str, i7, aVar);
                int i9 = aVar.f5844a;
                if (i7 < i9) {
                    fArr[i8] = Float.parseFloat(str.substring(i7, i9));
                    i8++;
                }
                i7 = aVar.f5845b ? i9 : i9 + 1;
            }
            return c(fArr, 0, i8);
        } catch (NumberFormatException e8) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e8);
        }
    }

    public static boolean i(b[] bVarArr, b[] bVarArr2, b[] bVarArr3, float f8) {
        if (bVarArr == null || bVarArr2 == null || bVarArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (bVarArr.length != bVarArr2.length || bVarArr2.length != bVarArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!b(bVarArr2, bVarArr3)) {
            return false;
        }
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            bVarArr[i7].d(bVarArr2[i7], bVarArr3[i7], f8);
        }
        return true;
    }

    private static int j(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i7;
            }
            i7++;
        }
        return i7;
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i7 = 0; i7 < bVarArr2.length; i7++) {
            bVarArr[i7].f5846a = bVarArr2[i7].f5846a;
            int i8 = 0;
            while (true) {
                float[] fArr = bVarArr2[i7].f5847b;
                if (i8 < fArr.length) {
                    bVarArr[i7].f5847b[i8] = fArr[i8];
                    i8++;
                }
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f5846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float[] f5847b;

        b(char c8, float[] fArr) {
            this.f5846a = c8;
            this.f5847b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c8, char c9, float[] fArr2) {
            int i7;
            int i8;
            int i9;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            char c10 = c9;
            boolean z7 = false;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c10) {
                case 'A':
                case 'a':
                    i7 = 7;
                    i8 = i7;
                    break;
                case ConstraintLayout.LayoutParams.a.f4583h0 /* 67 */:
                case com.haier.uhome.ble.a.f28150x /* 99 */:
                    i7 = 6;
                    i8 = i7;
                    break;
                case f4.d.f33918h /* 72 */:
                case 'V':
                case 'h':
                case 'v':
                    i8 = 1;
                    break;
                case f4.d.f33920j /* 76 */:
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i8 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i8 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                    i8 = 2;
                    break;
            }
            float f22 = f16;
            float f23 = f17;
            float f24 = f20;
            float f25 = f21;
            int i10 = 0;
            char c11 = c8;
            while (i10 < fArr2.length) {
                if (c10 != 'A') {
                    if (c10 == 'C') {
                        i9 = i10;
                        int i11 = i9 + 2;
                        int i12 = i9 + 3;
                        int i13 = i9 + 4;
                        int i14 = i9 + 5;
                        path.cubicTo(fArr2[i9 + 0], fArr2[i9 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                        f22 = fArr2[i13];
                        float f26 = fArr2[i14];
                        float f27 = fArr2[i11];
                        float f28 = fArr2[i12];
                        f23 = f26;
                        f19 = f28;
                        f18 = f27;
                    } else if (c10 == 'H') {
                        i9 = i10;
                        int i15 = i9 + 0;
                        path.lineTo(fArr2[i15], f23);
                        f22 = fArr2[i15];
                    } else if (c10 == 'Q') {
                        i9 = i10;
                        int i16 = i9 + 0;
                        int i17 = i9 + 1;
                        int i18 = i9 + 2;
                        int i19 = i9 + 3;
                        path.quadTo(fArr2[i16], fArr2[i17], fArr2[i18], fArr2[i19]);
                        float f29 = fArr2[i16];
                        float f30 = fArr2[i17];
                        f22 = fArr2[i18];
                        f23 = fArr2[i19];
                        f18 = f29;
                        f19 = f30;
                    } else if (c10 == 'V') {
                        i9 = i10;
                        int i20 = i9 + 0;
                        path.lineTo(f22, fArr2[i20]);
                        f23 = fArr2[i20];
                    } else if (c10 != 'a') {
                        if (c10 != 'c') {
                            if (c10 == 'h') {
                                int i21 = i10 + 0;
                                path.rLineTo(fArr2[i21], 0.0f);
                                f22 += fArr2[i21];
                            } else if (c10 != 'q') {
                                if (c10 == 'v') {
                                    int i22 = i10 + 0;
                                    path.rLineTo(0.0f, fArr2[i22]);
                                    f11 = fArr2[i22];
                                } else if (c10 == 'L') {
                                    int i23 = i10 + 0;
                                    int i24 = i10 + 1;
                                    path.lineTo(fArr2[i23], fArr2[i24]);
                                    f22 = fArr2[i23];
                                    f23 = fArr2[i24];
                                } else if (c10 == 'M') {
                                    f22 = fArr2[i10 + 0];
                                    f23 = fArr2[i10 + 1];
                                    if (i10 > 0) {
                                        path.lineTo(f22, f23);
                                    } else {
                                        path.moveTo(f22, f23);
                                        i9 = i10;
                                        f25 = f23;
                                        f24 = f22;
                                    }
                                } else if (c10 == 'S') {
                                    if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                        f22 = (f22 * 2.0f) - f18;
                                        f23 = (f23 * 2.0f) - f19;
                                    }
                                    float f31 = f23;
                                    int i25 = i10 + 0;
                                    int i26 = i10 + 1;
                                    int i27 = i10 + 2;
                                    int i28 = i10 + 3;
                                    path.cubicTo(f22, f31, fArr2[i25], fArr2[i26], fArr2[i27], fArr2[i28]);
                                    f8 = fArr2[i25];
                                    f9 = fArr2[i26];
                                    f22 = fArr2[i27];
                                    f23 = fArr2[i28];
                                    f18 = f8;
                                    f19 = f9;
                                } else if (c10 == 'T') {
                                    if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                        f22 = (f22 * 2.0f) - f18;
                                        f23 = (f23 * 2.0f) - f19;
                                    }
                                    int i29 = i10 + 0;
                                    int i30 = i10 + 1;
                                    path.quadTo(f22, f23, fArr2[i29], fArr2[i30]);
                                    float f32 = fArr2[i29];
                                    float f33 = fArr2[i30];
                                    i9 = i10;
                                    f19 = f23;
                                    f18 = f22;
                                    f22 = f32;
                                    f23 = f33;
                                } else if (c10 == 'l') {
                                    int i31 = i10 + 0;
                                    int i32 = i10 + 1;
                                    path.rLineTo(fArr2[i31], fArr2[i32]);
                                    f22 += fArr2[i31];
                                    f11 = fArr2[i32];
                                } else if (c10 == 'm') {
                                    float f34 = fArr2[i10 + 0];
                                    f22 += f34;
                                    float f35 = fArr2[i10 + 1];
                                    f23 += f35;
                                    if (i10 > 0) {
                                        path.rLineTo(f34, f35);
                                    } else {
                                        path.rMoveTo(f34, f35);
                                        i9 = i10;
                                        f25 = f23;
                                        f24 = f22;
                                    }
                                } else if (c10 == 's') {
                                    if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                        float f36 = f22 - f18;
                                        f12 = f23 - f19;
                                        f13 = f36;
                                    } else {
                                        f13 = 0.0f;
                                        f12 = 0.0f;
                                    }
                                    int i33 = i10 + 0;
                                    int i34 = i10 + 1;
                                    int i35 = i10 + 2;
                                    int i36 = i10 + 3;
                                    path.rCubicTo(f13, f12, fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                                    f8 = fArr2[i33] + f22;
                                    f9 = fArr2[i34] + f23;
                                    f22 += fArr2[i35];
                                    f10 = fArr2[i36];
                                } else if (c10 == 't') {
                                    if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                        f14 = f22 - f18;
                                        f15 = f23 - f19;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i37 = i10 + 0;
                                    int i38 = i10 + 1;
                                    path.rQuadTo(f14, f15, fArr2[i37], fArr2[i38]);
                                    float f37 = f14 + f22;
                                    float f38 = f15 + f23;
                                    f22 += fArr2[i37];
                                    f23 += fArr2[i38];
                                    f19 = f38;
                                    f18 = f37;
                                }
                                f23 += f11;
                            } else {
                                int i39 = i10 + 0;
                                int i40 = i10 + 1;
                                int i41 = i10 + 2;
                                int i42 = i10 + 3;
                                path.rQuadTo(fArr2[i39], fArr2[i40], fArr2[i41], fArr2[i42]);
                                f8 = fArr2[i39] + f22;
                                f9 = fArr2[i40] + f23;
                                f22 += fArr2[i41];
                                f10 = fArr2[i42];
                            }
                            i9 = i10;
                        } else {
                            int i43 = i10 + 2;
                            int i44 = i10 + 3;
                            int i45 = i10 + 4;
                            int i46 = i10 + 5;
                            path.rCubicTo(fArr2[i10 + 0], fArr2[i10 + 1], fArr2[i43], fArr2[i44], fArr2[i45], fArr2[i46]);
                            f8 = fArr2[i43] + f22;
                            f9 = fArr2[i44] + f23;
                            f22 += fArr2[i45];
                            f10 = fArr2[i46];
                        }
                        f23 += f10;
                        f18 = f8;
                        f19 = f9;
                        i9 = i10;
                    } else {
                        int i47 = i10 + 5;
                        int i48 = i10 + 6;
                        i9 = i10;
                        c(path, f22, f23, fArr2[i47] + f22, fArr2[i48] + f23, fArr2[i10 + 0], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f, fArr2[i10 + 4] != 0.0f);
                        f22 += fArr2[i47];
                        f23 += fArr2[i48];
                    }
                    i10 = i9 + i8;
                    c11 = c9;
                    c10 = c11;
                    z7 = false;
                } else {
                    i9 = i10;
                    int i49 = i9 + 5;
                    int i50 = i9 + 6;
                    c(path, f22, f23, fArr2[i49], fArr2[i50], fArr2[i9 + 0], fArr2[i9 + 1], fArr2[i9 + 2], fArr2[i9 + 3] != 0.0f, fArr2[i9 + 4] != 0.0f);
                    f22 = fArr2[i49];
                    f23 = fArr2[i50];
                }
                f19 = f23;
                f18 = f22;
                i10 = i9 + i8;
                c11 = c9;
                c10 = c11;
                z7 = false;
            }
            fArr[z7 ? 1 : 0] = f22;
            fArr[1] = f23;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f24;
            fArr[5] = f25;
        }

        private static void b(Path path, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
            double d17 = d10;
            int iCeil = (int) Math.ceil(Math.abs((d16 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d14);
            double dSin = Math.sin(d14);
            double dCos2 = Math.cos(d15);
            double dSin2 = Math.sin(d15);
            double d18 = -d17;
            double d19 = d18 * dCos;
            double d20 = d11 * dSin;
            double d21 = (d19 * dSin2) - (d20 * dCos2);
            double d22 = d18 * dSin;
            double d23 = d11 * dCos;
            double d24 = (dSin2 * d22) + (dCos2 * d23);
            double d25 = d16 / ((double) iCeil);
            double d26 = d24;
            double d27 = d21;
            int i7 = 0;
            double d28 = d12;
            double d29 = d13;
            double d30 = d15;
            while (i7 < iCeil) {
                double d31 = d30 + d25;
                double dSin3 = Math.sin(d31);
                double dCos3 = Math.cos(d31);
                double d32 = (d8 + ((d17 * dCos) * dCos3)) - (d20 * dSin3);
                double d33 = d9 + (d17 * dSin * dCos3) + (d23 * dSin3);
                double d34 = (d19 * dSin3) - (d20 * dCos3);
                double d35 = (dSin3 * d22) + (dCos3 * d23);
                double d36 = d31 - d30;
                double dTan = Math.tan(d36 / 2.0d);
                double dSin4 = (Math.sin(d36) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d37 = d28 + (d27 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d37, (float) (d29 + (d26 * dSin4)), (float) (d32 - (dSin4 * d34)), (float) (d33 - (dSin4 * d35)), (float) d32, (float) d33);
                i7++;
                d25 = d25;
                dSin = dSin;
                d28 = d32;
                d22 = d22;
                dCos = dCos;
                d30 = d31;
                d26 = d35;
                d27 = d34;
                iCeil = iCeil;
                d29 = d33;
                d17 = d10;
            }
        }

        private static void c(Path path, float f8, float f9, float f10, float f11, float f12, float f13, float f14, boolean z7, boolean z8) {
            double d8;
            double d9;
            double radians = Math.toRadians(f14);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d10 = f8;
            double d11 = d10 * dCos;
            double d12 = f9;
            double d13 = f12;
            double d14 = (d11 + (d12 * dSin)) / d13;
            double d15 = (((double) (-f8)) * dSin) + (d12 * dCos);
            double d16 = f13;
            double d17 = d15 / d16;
            double d18 = f11;
            double d19 = ((((double) f10) * dCos) + (d18 * dSin)) / d13;
            double d20 = ((((double) (-f10)) * dSin) + (d18 * dCos)) / d16;
            double d21 = d14 - d19;
            double d22 = d17 - d20;
            double d23 = (d14 + d19) / 2.0d;
            double d24 = (d17 + d20) / 2.0d;
            double d25 = (d21 * d21) + (d22 * d22);
            if (d25 == 0.0d) {
                Log.w(g2.f5843a, " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                Log.w(g2.f5843a, "Points are too far apart " + d25);
                float fSqrt = (float) (Math.sqrt(d25) / 1.99999d);
                c(path, f8, f9, f10, f11, f12 * fSqrt, f13 * fSqrt, f14, z7, z8);
                return;
            }
            double dSqrt = Math.sqrt(d26);
            double d27 = d21 * dSqrt;
            double d28 = dSqrt * d22;
            if (z7 == z8) {
                d8 = d23 - d28;
                d9 = d24 + d27;
            } else {
                d8 = d23 + d28;
                d9 = d24 - d27;
            }
            double dAtan2 = Math.atan2(d17 - d9, d14 - d8);
            double dAtan3 = Math.atan2(d20 - d9, d19 - d8) - dAtan2;
            if (z8 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d29 = d8 * d13;
            double d30 = d9 * d16;
            b(path, (d29 * dCos) - (d30 * dSin), (d29 * dSin) + (d30 * dCos), d13, d16, d10, d12, radians, dAtan2, dAtan3);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c8 = 'm';
            for (int i7 = 0; i7 < bVarArr.length; i7++) {
                b bVar = bVarArr[i7];
                a(path, fArr, c8, bVar.f5846a, bVar.f5847b);
                c8 = bVarArr[i7].f5846a;
            }
        }

        public void d(b bVar, b bVar2, float f8) {
            this.f5846a = bVar.f5846a;
            int i7 = 0;
            while (true) {
                float[] fArr = bVar.f5847b;
                if (i7 >= fArr.length) {
                    return;
                }
                this.f5847b[i7] = (fArr[i7] * (1.0f - f8)) + (bVar2.f5847b[i7] * f8);
                i7++;
            }
        }

        b(b bVar) {
            this.f5846a = bVar.f5846a;
            float[] fArr = bVar.f5847b;
            this.f5847b = g2.c(fArr, 0, fArr.length);
        }
    }
}
