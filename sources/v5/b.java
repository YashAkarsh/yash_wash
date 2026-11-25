package v5;

import java.util.Arrays;
import kotlin.collections.o;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlin.text.b0;
import okio.i;
import okio.j;
import okio.m;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final char[] f40436a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @a7.d
    public static final p A(@a7.d p commonToAsciiLowercase) {
        byte b8;
        l0.p(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i7 = 0; i7 < commonToAsciiLowercase.o().length; i7++) {
            byte b9 = commonToAsciiLowercase.o()[i7];
            byte b10 = (byte) 65;
            if (b9 >= b10 && b9 <= (b8 = (byte) 90)) {
                byte[] bArrO = commonToAsciiLowercase.o();
                byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
                l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b9 + 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b11 = bArrCopyOf[i8];
                    if (b11 >= b10 && b11 <= b8) {
                        bArrCopyOf[i8] = (byte) (b11 + 32);
                    }
                }
                return new p(bArrCopyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @a7.d
    public static final p B(@a7.d p commonToAsciiUppercase) {
        byte b8;
        l0.p(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i7 = 0; i7 < commonToAsciiUppercase.o().length; i7++) {
            byte b9 = commonToAsciiUppercase.o()[i7];
            byte b10 = (byte) 97;
            if (b9 >= b10 && b9 <= (b8 = (byte) 122)) {
                byte[] bArrO = commonToAsciiUppercase.o();
                byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
                l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b9 - 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b11 = bArrCopyOf[i8];
                    if (b11 >= b10 && b11 <= b8) {
                        bArrCopyOf[i8] = (byte) (b11 - 32);
                    }
                }
                return new p(bArrCopyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @a7.d
    public static final byte[] C(@a7.d p commonToByteArray) {
        l0.p(commonToByteArray, "$this$commonToByteArray");
        byte[] bArrO = commonToByteArray.o();
        byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
        l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @a7.d
    public static final p D(@a7.d byte[] commonToByteString, int i7, int i8) {
        l0.p(commonToByteString, "$this$commonToByteString");
        j.e(commonToByteString.length, i7, i8);
        return new p(o.G1(commonToByteString, i7, i8 + i7));
    }

    @a7.d
    public static final String E(@a7.d p pVar) {
        p commonToString = pVar;
        l0.p(commonToString, "$this$commonToString");
        if (pVar.o().length == 0) {
            return "[size=0]";
        }
        int iC = c(pVar.o(), 64);
        if (iC != -1) {
            String strL0 = pVar.l0();
            if (strL0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strL0.substring(0, iC);
            l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strK2 = b0.k2(b0.k2(b0.k2(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iC >= strL0.length()) {
                return "[text=" + strK2 + ']';
            }
            return "[size=" + pVar.o().length + " text=" + strK2 + "…]";
        }
        if (pVar.o().length <= 64) {
            return "[hex=" + pVar.t() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(pVar.o().length);
        sb.append(" hex=");
        if (64 <= pVar.o().length) {
            if (64 != pVar.o().length) {
                commonToString = new p(o.G1(pVar.o(), 0, 64));
            }
            sb.append(commonToString.t());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + pVar.o().length + ')').toString());
    }

    @a7.d
    public static final String F(@a7.d p commonUtf8) {
        l0.p(commonUtf8, "$this$commonUtf8");
        String strR = commonUtf8.r();
        if (strR != null) {
            return strR;
        }
        String strC = i.c(commonUtf8.E());
        commonUtf8.W(strC);
        return strC;
    }

    public static final void G(@a7.d p commonWrite, @a7.d m buffer, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(buffer, "buffer");
        buffer.write(commonWrite.o(), i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(char c8) {
        if ('0' <= c8 && '9' >= c8) {
            return c8 - '0';
        }
        char c9 = 'a';
        if ('a' > c8 || 'f' < c8) {
            c9 = 'A';
            if ('A' > c8 || 'F' < c8) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c8);
            }
        }
        return (c8 - c9) + 10;
    }

    @a7.d
    public static final char[] I() {
        return f40436a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:138:0x0132  */
    /* JADX WARN: Code duplicated, block: B:141:0x0138  */
    /* JADX WARN: Code duplicated, block: B:143:0x013c  */
    /* JADX WARN: Code duplicated, block: B:144:0x013f  */
    /* JADX WARN: Code duplicated, block: B:209:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:212:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:214:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:215:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:228:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x006a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x006c  */
    /* JADX WARN: Code duplicated, block: B:46:0x006f  */
    /* JADX WARN: Code duplicated, block: B:81:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00be  */
    public static final int c(byte[] bArr, int i7) {
        byte b8;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int length = bArr.length;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < length) {
            byte b9 = bArr[i13];
            if (b9 >= 0) {
                int i16 = i15 + 1;
                if (i15 == i7) {
                    return i14;
                }
                if (b9 != 10 && b9 != 13) {
                    if (!((b9 >= 0 && 31 >= b9) || (127 <= b9 && 159 >= b9))) {
                    }
                    return -1;
                }
                if (b9 == 65533) {
                    return -1;
                }
                i14 += b9 < 65536 ? 1 : 2;
                i13++;
                while (true) {
                    i15 = i16;
                    if (i13 >= length || (b8 = bArr[i13]) < 0) {
                        break;
                    }
                    i13++;
                    i16 = i15 + 1;
                    if (i15 == i7) {
                        return i14;
                    }
                    if (b8 != 10 && b8 != 13) {
                        if (!((b8 >= 0 && 31 >= b8) || (127 <= b8 && 159 >= b8))) {
                            if (b8 == 65533) {
                                if (b8 < 65536) {
                                    i8 = 1;
                                } else {
                                    i8 = 2;
                                }
                                i14 += i8;
                            }
                        }
                    } else if (b8 == 65533) {
                        if (b8 < 65536) {
                            i8 = 1;
                        } else {
                            i8 = 2;
                        }
                        i14 += i8;
                    }
                    return -1;
                }
            }
            if ((b9 >> 5) == -2) {
                int i17 = i13 + 1;
                if (length <= i17) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                byte b10 = bArr[i17];
                if (!((b10 & 192) == 128)) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                int i18 = (b10 ^ 3968) ^ (b9 << 6);
                if (i18 < 128) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                i9 = i15 + 1;
                if (i15 == i7) {
                    return i14;
                }
                if (i18 != 10 && i18 != 13) {
                    if (!((i18 >= 0 && 31 >= i18) || (127 <= i18 && 159 >= i18))) {
                        if (i18 == 65533) {
                            if (i18 < 65536) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            i14 += i12;
                            l2 l2Var = l2.f34958a;
                            i13 += 2;
                        }
                    }
                } else if (i18 == 65533) {
                    if (i18 < 65536) {
                        i12 = 1;
                    } else {
                        i12 = 2;
                    }
                    i14 += i12;
                    l2 l2Var2 = l2.f34958a;
                    i13 += 2;
                }
                return -1;
            }
            if ((b9 >> 4) == -2) {
                int i19 = i13 + 2;
                if (length <= i19) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                byte b11 = bArr[i13 + 1];
                if (!((b11 & 192) == 128)) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                byte b12 = bArr[i19];
                if (!((b12 & 192) == 128)) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                int i20 = ((b12 ^ (-123008)) ^ (b11 << 6)) ^ (b9 << com.google.common.base.c.f19314n);
                if (i20 < 2048) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                if (55296 <= i20 && 57343 >= i20) {
                    if (i15 == i7) {
                        return i14;
                    }
                    return -1;
                }
                i9 = i15 + 1;
                if (i15 == i7) {
                    return i14;
                }
                if (i20 != 10 && i20 != 13) {
                    if (!((i20 >= 0 && 31 >= i20) || (127 <= i20 && 159 >= i20))) {
                        if (i20 == 65533) {
                            if (i20 < 65536) {
                                i11 = 1;
                            } else {
                                i11 = 2;
                            }
                            i14 += i11;
                            l2 l2Var3 = l2.f34958a;
                            i13 += 3;
                        }
                    }
                } else if (i20 == 65533) {
                    if (i20 < 65536) {
                        i11 = 1;
                    } else {
                        i11 = 2;
                    }
                    i14 += i11;
                    l2 l2Var4 = l2.f34958a;
                    i13 += 3;
                }
                return -1;
            }
            if ((b9 >> 3) != -2) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            int i21 = i13 + 3;
            if (length <= i21) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            byte b13 = bArr[i13 + 1];
            if (!((b13 & 192) == 128)) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            byte b14 = bArr[i13 + 2];
            if (!((b14 & 192) == 128)) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            byte b15 = bArr[i21];
            if (!((b15 & 192) == 128)) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            int i22 = (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << com.google.common.base.c.f19314n)) ^ (b9 << com.google.common.base.c.f19321u);
            if (i22 > 1114111) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            if (55296 <= i22 && 57343 >= i22) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            if (i22 < 65536) {
                if (i15 == i7) {
                    return i14;
                }
                return -1;
            }
            i9 = i15 + 1;
            if (i15 == i7) {
                return i14;
            }
            if (i22 != 10 && i22 != 13) {
                if (!((i22 >= 0 && 31 >= i22) || (127 <= i22 && 159 >= i22))) {
                    if (i22 == 65533) {
                        if (i22 < 65536) {
                            i10 = 1;
                        } else {
                            i10 = 2;
                        }
                        i14 += i10;
                        l2 l2Var5 = l2.f34958a;
                        i13 += 4;
                    }
                }
            } else if (i22 == 65533) {
                if (i22 < 65536) {
                    i10 = 1;
                } else {
                    i10 = 2;
                }
                i14 += i10;
                l2 l2Var6 = l2.f34958a;
                i13 += 4;
            }
            return -1;
            i15 = i9;
        }
        return i14;
    }

    @a7.d
    public static final String d(@a7.d p commonBase64) {
        l0.p(commonBase64, "$this$commonBase64");
        return okio.a.c(commonBase64.o(), null, 1, null);
    }

    @a7.d
    public static final String e(@a7.d p commonBase64Url) {
        l0.p(commonBase64Url, "$this$commonBase64Url");
        return okio.a.b(commonBase64Url.o(), okio.a.e());
    }

    public static final int f(@a7.d p commonCompareTo, @a7.d p other) {
        l0.p(commonCompareTo, "$this$commonCompareTo");
        l0.p(other, "other");
        int iA0 = commonCompareTo.a0();
        int iA1 = other.a0();
        int iMin = Math.min(iA0, iA1);
        for (int i7 = 0; i7 < iMin; i7++) {
            int iN = commonCompareTo.n(i7) & 255;
            int iN2 = other.n(i7) & 255;
            if (iN != iN2) {
                return iN < iN2 ? -1 : 1;
            }
        }
        if (iA0 == iA1) {
            return 0;
        }
        return iA0 < iA1 ? -1 : 1;
    }

    @a7.e
    public static final p g(@a7.d String commonDecodeBase64) {
        l0.p(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] bArrA = okio.a.a(commonDecodeBase64);
        if (bArrA != null) {
            return new p(bArrA);
        }
        return null;
    }

    @a7.d
    public static final p h(@a7.d String commonDecodeHex) {
        l0.p(commonDecodeHex, "$this$commonDecodeHex");
        if (!(commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
        }
        int length = commonDecodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) ((H(commonDecodeHex.charAt(i8)) << 4) + H(commonDecodeHex.charAt(i8 + 1)));
        }
        return new p(bArr);
    }

    @a7.d
    public static final p i(@a7.d String commonEncodeUtf8) {
        l0.p(commonEncodeUtf8, "$this$commonEncodeUtf8");
        p pVar = new p(i.a(commonEncodeUtf8));
        pVar.W(commonEncodeUtf8);
        return pVar;
    }

    public static final boolean j(@a7.d p commonEndsWith, @a7.d p suffix) {
        l0.p(commonEndsWith, "$this$commonEndsWith");
        l0.p(suffix, "suffix");
        return commonEndsWith.S(commonEndsWith.a0() - suffix.a0(), suffix, 0, suffix.a0());
    }

    public static final boolean k(@a7.d p commonEndsWith, @a7.d byte[] suffix) {
        l0.p(commonEndsWith, "$this$commonEndsWith");
        l0.p(suffix, "suffix");
        return commonEndsWith.T(commonEndsWith.a0() - suffix.length, suffix, 0, suffix.length);
    }

    public static final boolean l(@a7.d p commonEquals, @a7.e Object obj) {
        l0.p(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.a0() == commonEquals.o().length && pVar.T(0, commonEquals.o(), 0, commonEquals.o().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte m(@a7.d p commonGetByte, int i7) {
        l0.p(commonGetByte, "$this$commonGetByte");
        return commonGetByte.o()[i7];
    }

    public static final int n(@a7.d p commonGetSize) {
        l0.p(commonGetSize, "$this$commonGetSize");
        return commonGetSize.o().length;
    }

    public static final int o(@a7.d p commonHashCode) {
        l0.p(commonHashCode, "$this$commonHashCode");
        int iP = commonHashCode.p();
        if (iP != 0) {
            return iP;
        }
        int iHashCode = Arrays.hashCode(commonHashCode.o());
        commonHashCode.V(iHashCode);
        return iHashCode;
    }

    @a7.d
    public static final String p(@a7.d p commonHex) {
        l0.p(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.o().length * 2];
        int i7 = 0;
        for (byte b8 : commonHex.o()) {
            int i8 = i7 + 1;
            cArr[i7] = I()[(b8 >> 4) & 15];
            i7 = i8 + 1;
            cArr[i8] = I()[b8 & com.google.common.base.c.f19317q];
        }
        return new String(cArr);
    }

    public static final int q(@a7.d p commonIndexOf, @a7.d byte[] other, int i7) {
        l0.p(commonIndexOf, "$this$commonIndexOf");
        l0.p(other, "other");
        int length = commonIndexOf.o().length - other.length;
        int iMax = Math.max(i7, 0);
        if (iMax > length) {
            return -1;
        }
        while (!j.d(commonIndexOf.o(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    @a7.d
    public static final byte[] r(@a7.d p commonInternalArray) {
        l0.p(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.o();
    }

    public static final int s(@a7.d p commonLastIndexOf, @a7.d p other, int i7) {
        l0.p(commonLastIndexOf, "$this$commonLastIndexOf");
        l0.p(other, "other");
        return commonLastIndexOf.K(other.E(), i7);
    }

    public static final int t(@a7.d p commonLastIndexOf, @a7.d byte[] other, int i7) {
        l0.p(commonLastIndexOf, "$this$commonLastIndexOf");
        l0.p(other, "other");
        for (int iMin = Math.min(i7, commonLastIndexOf.o().length - other.length); iMin >= 0; iMin--) {
            if (j.d(commonLastIndexOf.o(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    @a7.d
    public static final p u(@a7.d byte[] data) {
        l0.p(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new p(bArrCopyOf);
    }

    public static final boolean v(@a7.d p commonRangeEquals, int i7, @a7.d p other, int i8, int i9) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(other, "other");
        return other.T(i8, commonRangeEquals.o(), i7, i9);
    }

    public static final boolean w(@a7.d p commonRangeEquals, int i7, @a7.d byte[] other, int i8, int i9) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(other, "other");
        return i7 >= 0 && i7 <= commonRangeEquals.o().length - i9 && i8 >= 0 && i8 <= other.length - i9 && j.d(commonRangeEquals.o(), i7, other, i8, i9);
    }

    public static final boolean x(@a7.d p commonStartsWith, @a7.d p prefix) {
        l0.p(commonStartsWith, "$this$commonStartsWith");
        l0.p(prefix, "prefix");
        return commonStartsWith.S(0, prefix, 0, prefix.a0());
    }

    public static final boolean y(@a7.d p commonStartsWith, @a7.d byte[] prefix) {
        l0.p(commonStartsWith, "$this$commonStartsWith");
        l0.p(prefix, "prefix");
        return commonStartsWith.T(0, prefix, 0, prefix.length);
    }

    @a7.d
    public static final p z(@a7.d p commonSubstring, int i7, int i8) {
        l0.p(commonSubstring, "$this$commonSubstring");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i8 <= commonSubstring.o().length) {
            if (i8 - i7 >= 0) {
                return (i7 == 0 && i8 == commonSubstring.o().length) ? commonSubstring : new p(o.G1(commonSubstring.o(), i7, i8));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.o().length + ')').toString());
    }
}
