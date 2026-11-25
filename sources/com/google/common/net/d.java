package com.google.common.net;

import com.google.common.base.e0;
import com.google.common.base.k0;
import com.google.common.base.x;
import com.google.common.collect.ma;
import com.google.common.hash.v;
import com.google.common.primitives.c0;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f22192a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f22193b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final k0 f22194c = k0.h(ClassUtils.PACKAGE_SEPARATOR_CHAR).f(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k0 f22195d = k0.h(':').f(10);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Inet4Address f22196e = (Inet4Address) g("127.0.0.1");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Inet4Address f22197f = (Inet4Address) g("0.0.0.0");

    @s1.a
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Inet4Address f22198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Inet4Address f22199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f22201d;

        public a(Inet4Address inet4Address, Inet4Address inet4Address2, int i7, int i8) {
            e0.k(i7 >= 0 && i7 <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i7);
            e0.k(i8 >= 0 && i8 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", i8);
            this.f22198a = (Inet4Address) x.a(inet4Address, d.f22197f);
            this.f22199b = (Inet4Address) x.a(inet4Address2, d.f22197f);
            this.f22200c = i7;
            this.f22201d = i8;
        }

        public Inet4Address a() {
            return this.f22199b;
        }

        public int b() {
            return this.f22201d;
        }

        public int c() {
            return this.f22200c;
        }

        public Inet4Address d() {
            return this.f22198a;
        }
    }

    private d() {
    }

    public static boolean A(Inet6Address inet6Address) {
        if (D(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean B(String str) {
        byte[] bArrW = w(str);
        if (bArrW == null || bArrW.length != 16) {
            return false;
        }
        int i7 = 0;
        while (true) {
            if (i7 >= 10) {
                for (int i8 = 10; i8 < 12; i8++) {
                    if (bArrW[i8] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (bArrW[i7] != 0) {
                return false;
            }
            i7++;
        }
    }

    public static boolean C(InetAddress inetAddress) {
        for (byte b8 : inetAddress.getAddress()) {
            if (b8 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean D(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean E(String str) {
        return i(str) != null;
    }

    private static short F(String str) {
        int i7 = Integer.parseInt(str, 16);
        if (i7 <= 65535) {
            return (short) i7;
        }
        throw new NumberFormatException();
    }

    private static byte G(String str) {
        int i7 = Integer.parseInt(str);
        if (i7 > 255 || (str.startsWith("0") && str.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte) i7;
    }

    private static byte[] H(String str) {
        byte[] bArr = new byte[4];
        try {
            Iterator<String> it = f22194c.n(str).iterator();
            int i7 = 0;
            while (it.hasNext()) {
                int i8 = i7 + 1;
                bArr[i7] = G(it.next());
                i7 = i8;
            }
            if (i7 == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static byte[] I(String str) {
        int size;
        int size2;
        List<String> listO = f22195d.o(str);
        if (listO.size() < 3 || listO.size() > 9) {
            return null;
        }
        int i7 = -1;
        for (int i8 = 1; i8 < listO.size() - 1; i8++) {
            if (listO.get(i8).length() == 0) {
                if (i7 >= 0) {
                    return null;
                }
                i7 = i8;
            }
        }
        if (i7 >= 0) {
            size2 = (listO.size() - i7) - 1;
            if (listO.get(0).length() == 0) {
                size = i7 - 1;
                if (size != 0) {
                    return null;
                }
            } else {
                size = i7;
            }
            if (((String) ma.w(listO)).length() == 0 && (size2 = size2 - 1) != 0) {
                return null;
            }
        } else {
            size = listO.size();
            size2 = 0;
        }
        int i9 = 8 - (size + size2);
        if (i7 < 0 ? i9 != 0 : i9 < 1) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        for (int i10 = 0; i10 < size; i10++) {
            try {
                byteBufferAllocate.putShort(F(listO.get(i10)));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i11 = 0; i11 < i9; i11++) {
            byteBufferAllocate.putShort((short) 0);
        }
        while (size2 > 0) {
            byteBufferAllocate.putShort(F(listO.get(listO.size() - size2)));
            size2--;
        }
        return byteBufferAllocate.array();
    }

    public static String J(InetAddress inetAddress) {
        e0.E(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        e0.d(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i7 = 0; i7 < 8; i7++) {
            int i8 = i7 * 2;
            iArr[i7] = c0.k((byte) 0, (byte) 0, address[i8], address[i8 + 1]);
        }
        d(iArr);
        return u(iArr);
    }

    public static String K(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return J(inetAddress);
        }
        return "[" + J(inetAddress) + "]";
    }

    private static InetAddress b(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e8) {
            throw new AssertionError(e8);
        }
    }

    public static int c(InetAddress inetAddress) {
        return com.google.common.io.h.h(n(inetAddress).getAddress()).readInt();
    }

    private static void d(int[] iArr) {
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        for (int i10 = 0; i10 < iArr.length + 1; i10++) {
            if (i10 >= iArr.length || iArr[i10] != 0) {
                if (i9 >= 0) {
                    int i11 = i10 - i9;
                    if (i11 > i7) {
                        i8 = i9;
                        i7 = i11;
                    }
                    i9 = -1;
                }
            } else if (i9 < 0) {
                i9 = i10;
            }
        }
        if (i7 >= 2) {
            Arrays.fill(iArr, i8, i7 + i8, -1);
        }
    }

    private static String e(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrH = H(str.substring(iLastIndexOf));
        if (bArrH == null) {
            return null;
        }
        return strSubstring + Integer.toHexString(((bArrH[0] & 255) << 8) | (bArrH[1] & 255)) + ":" + Integer.toHexString((bArrH[3] & 255) | ((bArrH[2] & 255) << 8));
    }

    public static InetAddress f(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        e0.u(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    public static InetAddress g(String str) {
        byte[] bArrW = w(str);
        if (bArrW != null) {
            return b(bArrW);
        }
        throw j("'%s' is not an IP string literal.", str);
    }

    public static InetAddress h(String str) {
        InetAddress inetAddressI = i(str);
        if (inetAddressI != null) {
            return inetAddressI;
        }
        throw j("Not a valid URI IP literal: '%s'", str);
    }

    private static InetAddress i(String str) {
        int i7;
        e0.E(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i7 = 16;
        } else {
            i7 = 4;
        }
        byte[] bArrW = w(str);
        if (bArrW == null || bArrW.length != i7) {
            return null;
        }
        return b(bArrW);
    }

    private static IllegalArgumentException j(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static Inet4Address k(int i7) {
        return q(c0.C(i7));
    }

    public static InetAddress l(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i7 = 0; i7 < bArr.length; i7++) {
            bArr2[i7] = bArr[(bArr.length - i7) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address m(Inet6Address inet6Address) {
        e0.u(x(inet6Address), "Address '%s' is not a 6to4 address.", J(inet6Address));
        return q(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address n(InetAddress inetAddress) {
        boolean z7;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i7 = 0;
        while (true) {
            if (i7 >= 15) {
                z7 = true;
                break;
            }
            if (address[i7] != 0) {
                z7 = false;
                break;
            }
            i7++;
        }
        if (z7 && address[15] == 1) {
            return f22196e;
        }
        if (z7 && address[15] == 0) {
            return f22197f;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int iB = v.y().i(t(inet6Address) ? p(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).b() | (-536870912);
        if (iB == -1) {
            iB = -2;
        }
        return q(c0.C(iB));
    }

    public static Inet4Address o(Inet6Address inet6Address) {
        e0.u(y(inet6Address), "Address '%s' is not IPv4-compatible.", J(inet6Address));
        return q(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address p(Inet6Address inet6Address) {
        if (y(inet6Address)) {
            return o(inet6Address);
        }
        if (x(inet6Address)) {
            return m(inet6Address);
        }
        if (D(inet6Address)) {
            return s(inet6Address).a();
        }
        throw j("'%s' has no embedded IPv4 address.", J(inet6Address));
    }

    private static Inet4Address q(byte[] bArr) {
        e0.k(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) b(bArr);
    }

    public static Inet4Address r(Inet6Address inet6Address) {
        e0.u(A(inet6Address), "Address '%s' is not an ISATAP address.", J(inet6Address));
        return q(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static a s(Inet6Address inet6Address) {
        e0.u(D(inet6Address), "Address '%s' is not a Teredo address.", J(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4AddressQ = q(Arrays.copyOfRange(address, 4, 8));
        int i7 = com.google.common.io.h.i(address, 8).readShort() & g2.f34732d;
        int i8 = 65535 & (~com.google.common.io.h.i(address, 10).readShort());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i9 = 0; i9 < bArrCopyOfRange.length; i9++) {
            bArrCopyOfRange[i9] = (byte) (~bArrCopyOfRange[i9]);
        }
        return new a(inet4AddressQ, q(bArrCopyOfRange), i8, i7);
    }

    public static boolean t(Inet6Address inet6Address) {
        return y(inet6Address) || x(inet6Address) || D(inet6Address);
    }

    private static String u(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i7 = 0;
        boolean z7 = false;
        while (i7 < iArr.length) {
            boolean z8 = iArr[i7] >= 0;
            if (z8) {
                if (z7) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i7]));
            } else if (i7 == 0 || z7) {
                sb.append("::");
            }
            i7++;
            z7 = z8;
        }
        return sb.toString();
    }

    public static InetAddress v(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        e0.u(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return b(address);
    }

    private static byte[] w(String str) {
        boolean z7 = false;
        boolean z8 = false;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '.') {
                z8 = true;
            } else if (cCharAt == ':') {
                if (z8) {
                    return null;
                }
                z7 = true;
            } else if (Character.digit(cCharAt, 16) == -1) {
                return null;
            }
        }
        if (!z7) {
            if (z8) {
                return H(str);
            }
            return null;
        }
        if (z8 && (str = e(str)) == null) {
            return null;
        }
        return I(str);
    }

    public static boolean x(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean y(Inet6Address inet6Address) {
        byte b8;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b8 = address[15]) == 0 || b8 == 1)) ? false : true;
    }

    public static boolean z(String str) {
        return w(str) != null;
    }
}
