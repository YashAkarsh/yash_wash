package v5;

import i5.q;
import kotlin.collections.o;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import okio.j;
import okio.j0;
import okio.m;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final int b(@a7.d int[] binarySearch, int i7, int i8, int i9) {
        l0.p(binarySearch, "$this$binarySearch");
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            int i12 = binarySearch[i11];
            if (i12 < i7) {
                i8 = i11 + 1;
            } else {
                if (i12 <= i7) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return (-i8) - 1;
    }

    public static final boolean c(@a7.d okio.l0 commonEquals, @a7.e Object obj) {
        l0.p(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.a0() == commonEquals.a0() && commonEquals.S(0, pVar, 0, commonEquals.a0())) {
                return true;
            }
        }
        return false;
    }

    public static final int d(@a7.d okio.l0 commonGetSize) {
        l0.p(commonGetSize, "$this$commonGetSize");
        return commonGetSize.o0()[commonGetSize.p0().length - 1];
    }

    public static final int e(@a7.d okio.l0 commonHashCode) {
        l0.p(commonHashCode, "$this$commonHashCode");
        int iP = commonHashCode.p();
        if (iP != 0) {
            return iP;
        }
        int length = commonHashCode.p0().length;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        while (i7 < length) {
            int i10 = commonHashCode.o0()[length + i7];
            int i11 = commonHashCode.o0()[i7];
            byte[] bArr = commonHashCode.p0()[i7];
            int i12 = (i11 - i9) + i10;
            while (i10 < i12) {
                i8 = (i8 * 31) + bArr[i10];
                i10++;
            }
            i7++;
            i9 = i11;
        }
        commonHashCode.V(i8);
        return i8;
    }

    public static final byte f(@a7.d okio.l0 commonInternalGet, int i7) {
        l0.p(commonInternalGet, "$this$commonInternalGet");
        j.e(commonInternalGet.o0()[commonInternalGet.p0().length - 1], i7, 1L);
        int iN = n(commonInternalGet, i7);
        return commonInternalGet.p0()[iN][(i7 - (iN == 0 ? 0 : commonInternalGet.o0()[iN - 1])) + commonInternalGet.o0()[commonInternalGet.p0().length + iN]];
    }

    public static final boolean g(@a7.d okio.l0 commonRangeEquals, int i7, @a7.d p other, int i8, int i9) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(other, "other");
        if (i7 < 0 || i7 > commonRangeEquals.a0() - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iN = n(commonRangeEquals, i7);
        while (i7 < i10) {
            int i11 = iN == 0 ? 0 : commonRangeEquals.o0()[iN - 1];
            int i12 = commonRangeEquals.o0()[iN] - i11;
            int i13 = commonRangeEquals.o0()[commonRangeEquals.p0().length + iN];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!other.T(i8, commonRangeEquals.p0()[iN], i13 + (i7 - i11), iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iN++;
        }
        return true;
    }

    public static final boolean h(@a7.d okio.l0 commonRangeEquals, int i7, @a7.d byte[] other, int i8, int i9) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(other, "other");
        if (i7 < 0 || i7 > commonRangeEquals.a0() - i9 || i8 < 0 || i8 > other.length - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iN = n(commonRangeEquals, i7);
        while (i7 < i10) {
            int i11 = iN == 0 ? 0 : commonRangeEquals.o0()[iN - 1];
            int i12 = commonRangeEquals.o0()[iN] - i11;
            int i13 = commonRangeEquals.o0()[commonRangeEquals.p0().length + iN];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!j.d(commonRangeEquals.p0()[iN], i13 + (i7 - i11), other, i8, iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iN++;
        }
        return true;
    }

    @a7.d
    public static final p i(@a7.d okio.l0 commonSubstring, int i7, int i8) {
        l0.p(commonSubstring, "$this$commonSubstring");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i7 + " < 0").toString());
        }
        if (!(i8 <= commonSubstring.a0())) {
            throw new IllegalArgumentException(("endIndex=" + i8 + " > length(" + commonSubstring.a0() + ')').toString());
        }
        int i9 = i8 - i7;
        if (!(i9 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i8 + " < beginIndex=" + i7).toString());
        }
        if (i7 == 0 && i8 == commonSubstring.a0()) {
            return commonSubstring;
        }
        if (i7 == i8) {
            return p.f38507e;
        }
        int iN = n(commonSubstring, i7);
        int iN2 = n(commonSubstring, i8 - 1);
        byte[][] bArr = (byte[][]) o.M1(commonSubstring.p0(), iN, iN2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iN <= iN2) {
            int i10 = 0;
            int i11 = iN;
            while (true) {
                iArr[i10] = Math.min(commonSubstring.o0()[i11] - i7, i9);
                int i12 = i10 + 1;
                iArr[i10 + bArr.length] = commonSubstring.o0()[commonSubstring.p0().length + i11];
                if (i11 == iN2) {
                    break;
                }
                i11++;
                i10 = i12;
            }
        }
        int i13 = iN != 0 ? commonSubstring.o0()[iN - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i7 - i13);
        return new okio.l0(bArr, iArr);
    }

    @a7.d
    public static final byte[] j(@a7.d okio.l0 commonToByteArray) {
        l0.p(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.a0()];
        int length = commonToByteArray.p0().length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            int i10 = commonToByteArray.o0()[length + i7];
            int i11 = commonToByteArray.o0()[i7];
            int i12 = i11 - i8;
            o.W0(commonToByteArray.p0()[i7], bArr, i9, i10, i10 + i12);
            i9 += i12;
            i7++;
            i8 = i11;
        }
        return bArr;
    }

    public static final void k(@a7.d okio.l0 commonWrite, @a7.d m buffer, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(buffer, "buffer");
        int i9 = i8 + i7;
        int iN = n(commonWrite, i7);
        while (i7 < i9) {
            int i10 = iN == 0 ? 0 : commonWrite.o0()[iN - 1];
            int i11 = commonWrite.o0()[iN] - i10;
            int i12 = commonWrite.o0()[commonWrite.p0().length + iN];
            int iMin = Math.min(i9, i11 + i10) - i7;
            int i13 = i12 + (i7 - i10);
            j0 j0Var = new j0(commonWrite.p0()[iN], i13, i13 + iMin, true, false);
            j0 j0Var2 = buffer.f38494a;
            if (j0Var2 == null) {
                j0Var.f38474g = j0Var;
                j0Var.f38473f = j0Var;
                buffer.f38494a = j0Var;
            } else {
                l0.m(j0Var2);
                j0 j0Var3 = j0Var2.f38474g;
                l0.m(j0Var3);
                j0Var3.c(j0Var);
            }
            i7 += iMin;
            iN++;
        }
        buffer.s1(buffer.B1() + ((long) commonWrite.a0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(okio.l0 l0Var, int i7, int i8, q<? super byte[], ? super Integer, ? super Integer, l2> qVar) {
        int iN = n(l0Var, i7);
        while (i7 < i8) {
            int i9 = iN == 0 ? 0 : l0Var.o0()[iN - 1];
            int i10 = l0Var.o0()[iN] - i9;
            int i11 = l0Var.o0()[l0Var.p0().length + iN];
            int iMin = Math.min(i8, i10 + i9) - i7;
            qVar.v(l0Var.p0()[iN], Integer.valueOf(i11 + (i7 - i9)), Integer.valueOf(iMin));
            i7 += iMin;
            iN++;
        }
    }

    public static final void m(@a7.d okio.l0 forEachSegment, @a7.d q<? super byte[], ? super Integer, ? super Integer, l2> action) {
        l0.p(forEachSegment, "$this$forEachSegment");
        l0.p(action, "action");
        int length = forEachSegment.p0().length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = forEachSegment.o0()[length + i7];
            int i10 = forEachSegment.o0()[i7];
            action.v(forEachSegment.p0()[i7], Integer.valueOf(i9), Integer.valueOf(i10 - i8));
            i7++;
            i8 = i10;
        }
    }

    public static final int n(@a7.d okio.l0 segment, int i7) {
        l0.p(segment, "$this$segment");
        int iB = b(segment.o0(), i7 + 1, 0, segment.p0().length);
        return iB >= 0 ? iB : ~iB;
    }
}
