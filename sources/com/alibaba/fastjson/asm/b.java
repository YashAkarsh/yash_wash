package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.r0;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f12540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f12541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12544f;

    public b(InputStream inputStream, boolean z7) throws IOException {
        int i7;
        this.f12544f = z7;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i8 = inputStream.read(bArr);
            i7 = 0;
            if (i8 == -1) {
                break;
            } else if (i8 > 0) {
                byteArrayOutputStream.write(bArr, 0, i8);
            }
        }
        inputStream.close();
        this.f12539a = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[g(8)];
        this.f12540b = iArr;
        int length = iArr.length;
        this.f12541c = new String[length];
        int i9 = 10;
        int i10 = 1;
        while (i10 < length) {
            int i11 = i9 + 1;
            this.f12540b[i10] = i11;
            byte b8 = this.f12539a[i9];
            int iG = 3;
            if (b8 == 1) {
                iG = 3 + g(i11);
                if (iG > i7) {
                    i7 = iG;
                }
            } else if (b8 != 15) {
                iG = 5;
                if (b8 != 18 && b8 != 3 && b8 != 4) {
                    if (b8 != 5 && b8 != 6) {
                        switch (b8) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                break;
                            default:
                                continue;
                        }
                    } else {
                        i10++;
                        iG = 9;
                    }
                }
            } else {
                iG = 4;
            }
            i9 += iG;
            i10++;
        }
        this.f12542d = i7;
        this.f12543e = i9;
    }

    private int b() {
        int i7 = this.f12543e;
        int iG = i7 + 8 + (g(i7 + 6) * 2);
        for (int iG2 = g(iG); iG2 > 0; iG2--) {
            for (int iG3 = g(iG + 8); iG3 > 0; iG3--) {
                iG += c(iG + 12) + 6;
            }
            iG += 8;
        }
        int iC = iG + 2;
        for (int iG4 = g(iC); iG4 > 0; iG4--) {
            for (int iG5 = g(iC + 8); iG5 > 0; iG5--) {
                iC += c(iC + 12) + 6;
            }
            iC += 8;
        }
        return iC + 2;
    }

    private int c(int i7) {
        byte[] bArr = this.f12539a;
        return (bArr[i7 + 3] & 255) | ((bArr[i7] & 255) << 24) | ((bArr[i7 + 1] & 255) << 16) | ((bArr[i7 + 2] & 255) << 8);
    }

    private int d(l lVar, char[] cArr, int i7) {
        int iG = g(i7);
        String strF = f(i7 + 2, cArr);
        String strF2 = f(i7 + 4, cArr);
        int i8 = i7 + 8;
        int i9 = 0;
        int i10 = 0;
        for (int iG2 = g(i7 + 6); iG2 > 0; iG2--) {
            String strF3 = f(i8, cArr);
            int iC = c(i8 + 2);
            int i11 = i8 + 6;
            if (strF3.equals("Code")) {
                i10 = i11;
            }
            i8 = i11 + iC;
        }
        g gVarF = lVar.f(iG, strF, strF2);
        if (gVarF != null && i10 != 0) {
            int iC2 = i10 + 8 + c(i10 + 4);
            int i12 = iC2 + 2;
            for (int iG3 = g(iC2); iG3 > 0; iG3--) {
                i12 += 8;
            }
            int iC3 = i12 + 2;
            int i13 = 0;
            for (int iG4 = g(i12); iG4 > 0; iG4--) {
                String strF4 = f(iC3, cArr);
                if (strF4.equals("LocalVariableTable")) {
                    i9 = iC3 + 6;
                } else if (strF4.equals("LocalVariableTypeTable")) {
                    i13 = iC3 + 6;
                }
                iC3 += c(iC3 + 2) + 6;
            }
            if (i9 != 0) {
                if (i13 != 0) {
                    int iG5 = g(i13) * 3;
                    int i14 = i13 + 2;
                    int[] iArr = new int[iG5];
                    while (iG5 > 0) {
                        int i15 = iG5 - 1;
                        iArr[i15] = i14 + 6;
                        int i16 = i15 - 1;
                        iArr[i16] = g(i14 + 8);
                        iG5 = i16 - 1;
                        iArr[iG5] = g(i14);
                        i14 += 10;
                    }
                }
                int i17 = i9 + 2;
                for (int iG6 = g(i9); iG6 > 0; iG6--) {
                    gVarF.b(f(i17 + 4, cArr), g(i17 + 8));
                    i17 += 10;
                }
            }
        }
        return i8;
    }

    private String e(int i7, int i8, char[] cArr) {
        int i9;
        int i10 = i8 + i7;
        byte[] bArr = this.f12539a;
        int i11 = 0;
        char c8 = 0;
        char c9 = 0;
        while (i7 < i10) {
            int i12 = i7 + 1;
            byte b8 = bArr[i7];
            if (c8 == 0) {
                int i13 = b8 & 255;
                if (i13 < 128) {
                    cArr[i11] = (char) i13;
                    i11++;
                } else if (i13 >= 224 || i13 <= 191) {
                    c9 = (char) (i13 & 15);
                    c8 = 2;
                } else {
                    i9 = i13 & 31;
                    c9 = (char) i9;
                    c8 = 1;
                }
            } else if (c8 == 1) {
                cArr[i11] = (char) ((b8 & r0.f38528a) | (c9 << 6));
                i11++;
                c8 = 0;
            } else if (c8 == 2) {
                i9 = (b8 & r0.f38528a) | (c9 << 6);
                c9 = (char) i9;
                c8 = 1;
            }
            i7 = i12;
        }
        return new String(cArr, 0, i11);
    }

    private String f(int i7, char[] cArr) {
        int iG = g(i7);
        String[] strArr = this.f12541c;
        String str = strArr[iG];
        if (str != null) {
            return str;
        }
        int i8 = this.f12540b[iG];
        String strE = e(i8 + 2, g(i8), cArr);
        strArr[iG] = strE;
        return strE;
    }

    private int g(int i7) {
        byte[] bArr = this.f12539a;
        return (bArr[i7 + 1] & 255) | ((bArr[i7] & 255) << 8);
    }

    public void a(l lVar) {
        int i7;
        char[] cArr = new char[this.f12542d];
        if (!this.f12544f) {
            i7 = 0;
            break;
        }
        int iB = b();
        int iG = g(iB);
        while (true) {
            if (iG <= 0) {
                i7 = 0;
                break;
            } else if ("RuntimeVisibleAnnotations".equals(f(iB + 2, cArr))) {
                i7 = iB + 8;
                break;
            } else {
                iB += c(iB + 4) + 6;
                iG--;
            }
        }
        int i8 = this.f12543e;
        int i9 = this.f12540b[g(i8 + 4)];
        int iG2 = g(i8 + 6);
        int i10 = i8 + 8;
        for (int i11 = 0; i11 < iG2; i11++) {
            i10 += 2;
        }
        int iC = i10 + 2;
        int iC2 = iC;
        for (int iG3 = g(i10); iG3 > 0; iG3--) {
            iC2 += 8;
            for (int iG4 = g(iC2 + 6); iG4 > 0; iG4--) {
                iC2 += c(iC2 + 2) + 6;
            }
        }
        int iC3 = iC2 + 2;
        for (int iG5 = g(iC2); iG5 > 0; iG5--) {
            iC3 += 8;
            for (int iG6 = g(iC3 + 6); iG6 > 0; iG6--) {
                iC3 += c(iC3 + 2) + 6;
            }
        }
        int iC4 = iC3 + 2;
        for (int iG7 = g(iC3); iG7 > 0; iG7--) {
            iC4 += c(iC4 + 2) + 6;
        }
        if (i7 != 0) {
            int i12 = i7 + 2;
            for (int iG8 = g(i7); iG8 > 0; iG8--) {
                lVar.e(f(i12, cArr));
            }
        }
        for (int iG9 = g(i10); iG9 > 0; iG9--) {
            iC += 8;
            for (int iG10 = g(iC + 6); iG10 > 0; iG10--) {
                iC += c(iC + 2) + 6;
            }
        }
        int iD = iC + 2;
        for (int iG11 = g(iC); iG11 > 0; iG11--) {
            iD = d(lVar, cArr, iD);
        }
    }
}
