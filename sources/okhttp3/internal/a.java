package okhttp3.internal;

import a7.e;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.l0;
import kotlin.text.b0;
import kotlin.text.c0;
import okio.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final boolean a(String str) {
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (l0.t(cCharAt, 31) <= 0 || l0.t(cCharAt, 127) >= 0 || c0.q3(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean b(String str, int i7, int i8, byte[] bArr, int i9) {
        int i10 = i9;
        while (i7 < i8) {
            if (i10 == bArr.length) {
                return false;
            }
            if (i10 != i9) {
                if (str.charAt(i7) != '.') {
                    return false;
                }
                i7++;
            }
            int i11 = i7;
            int i12 = 0;
            while (i11 < i8) {
                char cCharAt = str.charAt(i11);
                if (l0.t(cCharAt, 48) < 0 || l0.t(cCharAt, 57) > 0) {
                    break;
                }
                if ((i12 == 0 && i7 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i11++;
            }
            if (i11 - i7 == 0) {
                return false;
            }
            bArr[i10] = (byte) i12;
            i10++;
            i7 = i11;
        }
        return i10 == i9 + 4;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076 A[LOOP:1: B:30:0x0069->B:34:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x007c A[EDGE_INSN: B:55:0x007c->B:35:0x007c BREAK  A[LOOP:1: B:30:0x0069->B:34:0x0076], SYNTHETIC] */
    private static final InetAddress c(String str, int i7, int i8) {
        int i9;
        int i10;
        int iN;
        byte[] bArr = new byte[16];
        int i11 = i7;
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        while (i11 < i8) {
            if (i14 == 16) {
                return null;
            }
            int i15 = i11 + 2;
            if (i15 <= i8 && b0.t2(str, "::", i11, false, 4, null)) {
                if (i12 != -1) {
                    return null;
                }
                i14 += 2;
                if (i15 == i8) {
                    i12 = i14;
                    break;
                }
                i13 = i15;
                i12 = i14;
                i11 = i13;
                i9 = 0;
                while (i11 < i8) {
                    iN = d.N(str.charAt(i11));
                    if (iN == -1) {
                        break;
                        break;
                    }
                    i9 = (i9 << 4) + iN;
                    i11++;
                }
                i10 = i11 - i13;
                if (i10 != 0) {
                }
                return null;
            }
            if (i14 != 0) {
                if (!b0.t2(str, ":", i11, false, 4, null)) {
                    if (!b0.t2(str, com.alibaba.android.arouter.utils.b.f12515h, i11, false, 4, null) || !b(str, i13, i8, bArr, i14 - 2)) {
                        return null;
                    }
                    i14 += 2;
                    break;
                }
                i11++;
            }
            i13 = i11;
            i11 = i13;
            i9 = 0;
            while (i11 < i8) {
                iN = d.N(str.charAt(i11));
                if (iN == -1) {
                    break;
                }
                i9 = (i9 << 4) + iN;
                i11++;
            }
            i10 = i11 - i13;
            if (i10 != 0 || i10 > 4) {
                return null;
            }
            int i16 = i14 + 1;
            bArr[i14] = (byte) ((i9 >>> 8) & 255);
            i14 = i16 + 1;
            bArr[i16] = (byte) (i9 & 255);
        }
        if (i14 != 16) {
            if (i12 == -1) {
                return null;
            }
            int i17 = i14 - i12;
            System.arraycopy(bArr, i12, bArr, 16 - i17, i17);
            Arrays.fill(bArr, i12, (16 - i14) + i12, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String d(byte[] bArr) {
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < bArr.length) {
            int i11 = i9;
            while (i11 < 16 && bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                i11 += 2;
            }
            int i12 = i11 - i9;
            if (i12 > i10 && i12 >= 4) {
                i7 = i9;
                i10 = i12;
            }
            i9 = i11 + 2;
        }
        m mVar = new m();
        while (i8 < bArr.length) {
            if (i8 == i7) {
                mVar.writeByte(58);
                i8 += i10;
                if (i8 == 16) {
                    mVar.writeByte(58);
                }
            } else {
                if (i8 > 0) {
                    mVar.writeByte(58);
                }
                mVar.D0((d.b(bArr[i8], 255) << 8) | d.b(bArr[i8 + 1], 255));
                i8 += 2;
            }
        }
        return mVar.m1();
    }

    @e
    public static final String e(@a7.d String toCanonicalHost) {
        l0.p(toCanonicalHost, "$this$toCanonicalHost");
        if (!c0.V2(toCanonicalHost, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                l0.o(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                l0.o(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!(lowerCase.length() == 0) && !a(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressC = (b0.u2(toCanonicalHost, "[", false, 2, null) && b0.J1(toCanonicalHost, "]", false, 2, null)) ? c(toCanonicalHost, 1, toCanonicalHost.length() - 1) : c(toCanonicalHost, 0, toCanonicalHost.length());
        if (inetAddressC == null) {
            return null;
        }
        byte[] address = inetAddressC.getAddress();
        if (address.length == 16) {
            l0.o(address, "address");
            return d(address);
        }
        if (address.length == 4) {
            return inetAddressC.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
    }
}
