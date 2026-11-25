package v5;

import com.alibaba.fastjson.asm.j;
import java.util.Arrays;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import okio.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    @a7.d
    public static final byte[] a(@a7.d String commonAsUtf8ToByteArray) {
        int i7;
        int i8;
        char cCharAt;
        l0.p(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i9 = 0;
        while (i9 < length) {
            char cCharAt2 = commonAsUtf8ToByteArray.charAt(i9);
            if (l0.t(cCharAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i10 = i9;
                while (i9 < length2) {
                    char cCharAt3 = commonAsUtf8ToByteArray.charAt(i9);
                    if (l0.t(cCharAt3, 128) < 0) {
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) cCharAt3;
                        i9++;
                        while (i9 < length2 && l0.t(commonAsUtf8ToByteArray.charAt(i9), 128) < 0) {
                            bArr[i11] = (byte) commonAsUtf8ToByteArray.charAt(i9);
                            i9++;
                            i11++;
                        }
                        i10 = i11;
                    } else {
                        if (l0.t(cCharAt3, 2048) < 0) {
                            int i12 = i10 + 1;
                            bArr[i10] = (byte) ((cCharAt3 >> 6) | j.f12606c0);
                            byte b8 = (byte) ((cCharAt3 & '?') | 128);
                            i7 = i12 + 1;
                            bArr[i12] = b8;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i13 = i10 + 1;
                            bArr[i10] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b9 = (byte) ((cCharAt3 & '?') | 128);
                            i7 = i14 + 1;
                            bArr[i14] = b9;
                        } else {
                            if (l0.t(cCharAt3, 56319) > 0 || length2 <= (i8 = i9 + 1) || 56320 > (cCharAt = commonAsUtf8ToByteArray.charAt(i8)) || 57343 < cCharAt) {
                                i7 = i10 + 1;
                                bArr[i10] = r0.f38528a;
                            } else {
                                int iCharAt = ((cCharAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i8)) - 56613888;
                                int i15 = i10 + 1;
                                bArr[i10] = (byte) ((iCharAt >> 18) | 240);
                                int i16 = i15 + 1;
                                bArr[i15] = (byte) (((iCharAt >> 12) & 63) | 128);
                                int i17 = i16 + 1;
                                bArr[i16] = (byte) (((iCharAt >> 6) & 63) | 128);
                                byte b10 = (byte) ((iCharAt & 63) | 128);
                                i7 = i17 + 1;
                                bArr[i17] = b10;
                                i9 += 2;
                            }
                            i10 = i7;
                        }
                        i9++;
                        i10 = i7;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
                l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i9] = (byte) cCharAt2;
            i9++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        l0.o(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @a7.d
    public static final String b(@a7.d byte[] commonToUtf8String, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = i7;
        l0.p(commonToUtf8String, "$this$commonToUtf8String");
        if (i13 < 0 || i8 > commonToUtf8String.length || i13 > i8) {
            throw new ArrayIndexOutOfBoundsException("size=" + commonToUtf8String.length + " beginIndex=" + i13 + " endIndex=" + i8);
        }
        char[] cArr = new char[i8 - i13];
        int i14 = 0;
        while (i13 < i8) {
            byte b8 = commonToUtf8String[i13];
            if (b8 >= 0) {
                i9 = i14 + 1;
                cArr[i14] = (char) b8;
                i13++;
                while (i13 < i8) {
                    byte b9 = commonToUtf8String[i13];
                    if (b9 < 0) {
                        break;
                    }
                    i13++;
                    cArr[i9] = (char) b9;
                    i9++;
                }
            } else if ((b8 >> 5) == -2) {
                int i15 = i13 + 1;
                if (i8 <= i15) {
                    i9 = i14 + 1;
                    cArr[i14] = (char) r0.f38530c;
                } else {
                    byte b10 = commonToUtf8String[i15];
                    if ((b10 & 192) == 128) {
                        int i16 = (b8 << 6) ^ (b10 ^ 3968);
                        if (i16 < 128) {
                            i9 = i14 + 1;
                            cArr[i14] = (char) r0.f38530c;
                        } else {
                            i9 = i14 + 1;
                            cArr[i14] = (char) i16;
                        }
                        l2 l2Var = l2.f34958a;
                        i10 = 2;
                        i13 += i10;
                    } else {
                        i9 = i14 + 1;
                        cArr[i14] = (char) r0.f38530c;
                    }
                }
                l2 l2Var2 = l2.f34958a;
                i10 = 1;
                i13 += i10;
            } else if ((b8 >> 4) == -2) {
                int i17 = i13 + 2;
                if (i8 <= i17) {
                    i9 = i14 + 1;
                    cArr[i14] = (char) r0.f38530c;
                    l2 l2Var3 = l2.f34958a;
                    int i18 = i13 + 1;
                    if (i8 > i18) {
                        if ((commonToUtf8String[i18] & 192) == 128) {
                            i10 = 2;
                        }
                    }
                    i10 = 1;
                } else {
                    byte b11 = commonToUtf8String[i13 + 1];
                    if ((b11 & 192) == 128) {
                        byte b12 = commonToUtf8String[i17];
                        if ((b12 & 192) == 128) {
                            int i19 = (b8 << com.google.common.base.c.f19314n) ^ ((b12 ^ (-123008)) ^ (b11 << 6));
                            if (i19 < 2048) {
                                i9 = i14 + 1;
                                cArr[i14] = (char) r0.f38530c;
                            } else if (55296 <= i19 && 57343 >= i19) {
                                i9 = i14 + 1;
                                cArr[i14] = (char) r0.f38530c;
                            } else {
                                i9 = i14 + 1;
                                cArr[i14] = (char) i19;
                            }
                            l2 l2Var4 = l2.f34958a;
                            i10 = 3;
                        } else {
                            i9 = i14 + 1;
                            cArr[i14] = (char) r0.f38530c;
                            l2 l2Var5 = l2.f34958a;
                            i10 = 2;
                        }
                    } else {
                        i9 = i14 + 1;
                        cArr[i14] = (char) r0.f38530c;
                        l2 l2Var6 = l2.f34958a;
                        i10 = 1;
                    }
                }
                i13 += i10;
            } else {
                if ((b8 >> 3) == -2) {
                    int i20 = i13 + 3;
                    if (i8 <= i20) {
                        i11 = i14 + 1;
                        cArr[i14] = r0.f38529b;
                        l2 l2Var7 = l2.f34958a;
                        int i21 = i13 + 1;
                        if (i8 > i21) {
                            if ((commonToUtf8String[i21] & 192) == 128) {
                                int i22 = i13 + 2;
                                if (i8 > i22) {
                                    if ((commonToUtf8String[i22] & 192) == 128) {
                                        i12 = 3;
                                    }
                                }
                                i12 = 2;
                            }
                        }
                        i12 = 1;
                    } else {
                        byte b13 = commonToUtf8String[i13 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = commonToUtf8String[i13 + 2];
                            if ((b14 & 192) == 128) {
                                byte b15 = commonToUtf8String[i20];
                                if ((b15 & 192) == 128) {
                                    int i23 = (b8 << com.google.common.base.c.f19321u) ^ (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << com.google.common.base.c.f19314n));
                                    if (i23 > 1114111) {
                                        i11 = i14 + 1;
                                        cArr[i14] = r0.f38529b;
                                    } else if ((55296 <= i23 && 57343 >= i23) || i23 < 65536 || i23 == 65533) {
                                        i11 = i14 + 1;
                                        cArr[i14] = r0.f38529b;
                                    } else {
                                        int i24 = i14 + 1;
                                        cArr[i14] = (char) ((i23 >>> 10) + r0.f38531d);
                                        char c8 = (char) ((i23 & 1023) + r0.f38532e);
                                        i11 = i24 + 1;
                                        cArr[i24] = c8;
                                    }
                                    l2 l2Var8 = l2.f34958a;
                                    i12 = 4;
                                } else {
                                    i11 = i14 + 1;
                                    cArr[i14] = r0.f38529b;
                                    l2 l2Var9 = l2.f34958a;
                                    i12 = 3;
                                }
                            } else {
                                i11 = i14 + 1;
                                cArr[i14] = r0.f38529b;
                                l2 l2Var10 = l2.f34958a;
                                i12 = 2;
                            }
                        } else {
                            i11 = i14 + 1;
                            cArr[i14] = r0.f38529b;
                            l2 l2Var11 = l2.f34958a;
                            i12 = 1;
                        }
                    }
                    i13 += i12;
                } else {
                    i11 = i14 + 1;
                    cArr[i14] = r0.f38529b;
                    i13++;
                }
                i14 = i11;
            }
            i14 = i9;
        }
        return new String(cArr, 0, i14);
    }

    public static /* synthetic */ String c(byte[] bArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = bArr.length;
        }
        return b(bArr, i7, i8);
    }
}
