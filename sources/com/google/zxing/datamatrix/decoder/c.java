package com.google.zxing.datamatrix.decoder;

import androidx.recyclerview.widget.m;
import com.alibaba.fastjson.asm.j;
import com.google.zxing.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.h0;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.chromium.net.v;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f23625a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f23626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f23627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f23628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f23629e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23630a;

        static {
            int[] iArr = new int[b.values().length];
            f23630a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23630a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23630a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23630a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23630a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', h0.f35376b, '#', '$', '%', h0.f35378d, '\'', '(', ')', '*', '+', ',', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', ':', ';', h0.f35379e, '=', h0.f35380f, '?', '@', '[', '\\', ']', '^', '_'};
        f23626b = cArr;
        f23627c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f23628d = cArr;
        f23629e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', com.google.common.base.c.N};
    }

    private c() {
    }

    static com.google.zxing.common.e a(byte[] bArr) throws h {
        com.google.zxing.common.c cVar = new com.google.zxing.common.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarC = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarC == bVar) {
                bVarC = c(cVar, sb, sb2);
            } else {
                int i7 = a.f23630a[bVarC.ordinal()];
                if (i7 == 1) {
                    e(cVar, sb);
                } else if (i7 == 2) {
                    g(cVar, sb);
                } else if (i7 == 3) {
                    b(cVar, sb);
                } else if (i7 == 4) {
                    f(cVar, sb);
                } else {
                    if (i7 != 5) {
                        throw h.a();
                    }
                    d(cVar, sb, arrayList);
                }
                bVarC = bVar;
            }
            if (bVarC == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.google.zxing.common.e(bArr, string, arrayList, null);
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb) throws h {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0) {
                    sb.append(CharUtils.CR);
                } else if (i8 == 1) {
                    sb.append('*');
                } else if (i8 == 2) {
                    sb.append(h0.f35380f);
                } else if (i8 == 3) {
                    sb.append(' ');
                } else if (i8 < 14) {
                    sb.append((char) (i8 + 44));
                } else {
                    if (i8 >= 40) {
                        throw h.a();
                    }
                    sb.append((char) (i8 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static b c(com.google.zxing.common.c cVar, StringBuilder sb, StringBuilder sb2) throws h {
        boolean z7 = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw h.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z7 = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw h.a();
                                }
                                break;
                        }
                    } else {
                        int i7 = iD + v.M2;
                        if (i7 < 10) {
                            sb.append('0');
                        }
                        sb.append(i7);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z7) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return b.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb, Collection<byte[]> collection) throws h {
        int iC = cVar.c() + 1;
        int i7 = iC + 1;
        int i8 = i(cVar.d(8), iC);
        if (i8 == 0) {
            i8 = cVar.a() / 8;
        } else if (i8 >= 250) {
            i8 = ((i8 - 249) * m.f.f9644c) + i(cVar.d(8), i7);
            i7++;
        }
        if (i8 < 0) {
            throw h.a();
        }
        byte[] bArr = new byte[i8];
        int i9 = 0;
        while (i9 < i8) {
            if (cVar.a() < 8) {
                throw h.a();
            }
            bArr[i9] = (byte) i(cVar.d(8), i7);
            i9++;
            i7++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e8)));
        }
    }

    private static void e(com.google.zxing.common.c cVar, StringBuilder sb) throws h {
        int iD;
        int[] iArr = new int[3];
        boolean z7 = false;
        int i7 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i8 = 0; i8 < 3; i8++) {
                int i9 = iArr[i8];
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 == 2) {
                            char[] cArr = f23626b;
                            if (i9 < cArr.length) {
                                char c8 = cArr[i9];
                                if (z7) {
                                    sb.append((char) (c8 + 128));
                                    z7 = false;
                                } else {
                                    sb.append(c8);
                                }
                            } else if (i9 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i9 != 30) {
                                    throw h.a();
                                }
                                z7 = true;
                            }
                        } else {
                            if (i7 != 3) {
                                throw h.a();
                            }
                            if (z7) {
                                sb.append((char) (i9 + 224));
                                z7 = false;
                            } else {
                                sb.append((char) (i9 + 96));
                            }
                        }
                    } else if (z7) {
                        sb.append((char) (i9 + 128));
                        z7 = false;
                    } else {
                        sb.append((char) i9);
                    }
                    i7 = 0;
                } else if (i9 < 3) {
                    i7 = i9 + 1;
                } else {
                    char[] cArr2 = f23625a;
                    if (i9 >= cArr2.length) {
                        throw h.a();
                    }
                    char c9 = cArr2[i9];
                    if (z7) {
                        sb.append((char) (c9 + 128));
                        z7 = false;
                    } else {
                        sb.append(c9);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(com.google.zxing.common.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i7 = 0; i7 < 4; i7++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(com.google.zxing.common.c cVar, StringBuilder sb) throws h {
        int iD;
        int[] iArr = new int[3];
        boolean z7 = false;
        int i7 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i8 = 0; i8 < 3; i8++) {
                int i9 = iArr[i8];
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 == 2) {
                            char[] cArr = f23628d;
                            if (i9 < cArr.length) {
                                char c8 = cArr[i9];
                                if (z7) {
                                    sb.append((char) (c8 + 128));
                                    z7 = false;
                                } else {
                                    sb.append(c8);
                                }
                            } else if (i9 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i9 != 30) {
                                    throw h.a();
                                }
                                z7 = true;
                            }
                        } else {
                            if (i7 != 3) {
                                throw h.a();
                            }
                            char[] cArr2 = f23629e;
                            if (i9 >= cArr2.length) {
                                throw h.a();
                            }
                            char c9 = cArr2[i9];
                            if (z7) {
                                sb.append((char) (c9 + 128));
                                z7 = false;
                            } else {
                                sb.append(c9);
                            }
                        }
                    } else if (z7) {
                        sb.append((char) (i9 + 128));
                        z7 = false;
                    } else {
                        sb.append((char) i9);
                    }
                    i7 = 0;
                } else if (i9 < 3) {
                    i7 = i9 + 1;
                } else {
                    char[] cArr3 = f23627c;
                    if (i9 >= cArr3.length) {
                        throw h.a();
                    }
                    char c10 = cArr3[i9];
                    if (z7) {
                        sb.append((char) (c10 + 128));
                        z7 = false;
                    } else {
                        sb.append(c10);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i7, int i8, int[] iArr) {
        int i9 = ((i7 << 8) + i8) - 1;
        int i10 = i9 / 1600;
        iArr[0] = i10;
        int i11 = i9 - (i10 * 1600);
        int i12 = i11 / 40;
        iArr[1] = i12;
        iArr[2] = i11 - (i12 * 40);
    }

    private static int i(int i7, int i8) {
        int i9 = i7 - (((i8 * j.D) % 255) + 1);
        return i9 >= 0 ? i9 : i9 + 256;
    }
}
