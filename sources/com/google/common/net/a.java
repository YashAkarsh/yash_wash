package com.google.common.net;

import com.google.common.base.e0;
import com.google.common.base.o0;
import com.google.common.base.y;
import java.io.Serializable;
import u1.j;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@j
@s1.b
public final class a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f22125d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f22126e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22129c;

    private a(String str, int i7, boolean z7) {
        this.f22127a = str;
        this.f22128b = i7;
        this.f22129c = z7;
    }

    public static a a(String str) {
        a aVarC = c(str);
        e0.u(!aVarC.h(), "Host has a port: %s", str);
        return aVarC;
    }

    public static a b(String str, int i7) {
        e0.k(i(i7), "Port out of range: %s", i7);
        a aVarC = c(str);
        e0.u(!aVarC.h(), "Host has a port: %s", str);
        return new a(aVarC.f22127a, i7, aVarC.f22129c);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0030 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    public static a c(String str) {
        String strSubstring;
        String strSubstring2;
        e0.E(str);
        int i7 = -1;
        boolean z7 = false;
        if (str.startsWith("[")) {
            String[] strArrE = e(str);
            strSubstring2 = strArrE[0];
            strSubstring = strArrE[1];
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0) {
                int i8 = iIndexOf + 1;
                if (str.indexOf(58, i8) == -1) {
                    strSubstring2 = str.substring(0, iIndexOf);
                    strSubstring = str.substring(i8);
                } else {
                    z7 = iIndexOf >= 0;
                    strSubstring = null;
                    strSubstring2 = str;
                }
            } else {
                if (iIndexOf >= 0) {
                }
                strSubstring = null;
                strSubstring2 = str;
            }
        }
        if (!o0.d(strSubstring)) {
            e0.u(!strSubstring.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i7 = Integer.parseInt(strSubstring);
                e0.u(i(i7), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new a(strSubstring2, i7, z7);
    }

    private static String[] e(String str) {
        e0.u(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(93);
        e0.u(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", str);
        String strSubstring = str.substring(1, iLastIndexOf);
        int i7 = iLastIndexOf + 1;
        if (i7 == str.length()) {
            return new String[]{strSubstring, ""};
        }
        e0.u(str.charAt(i7) == ':', "Only a colon may follow a close bracket: %s", str);
        int i8 = iLastIndexOf + 2;
        for (int i9 = i8; i9 < str.length(); i9++) {
            e0.u(Character.isDigit(str.charAt(i9)), "Port must be numeric: %s", str);
        }
        return new String[]{strSubstring, str.substring(i8)};
    }

    private static boolean i(int i7) {
        return i7 >= 0 && i7 <= 65535;
    }

    public String d() {
        return this.f22127a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return y.a(this.f22127a, aVar.f22127a) && this.f22128b == aVar.f22128b;
    }

    public int f() {
        e0.g0(h());
        return this.f22128b;
    }

    public int g(int i7) {
        return h() ? this.f22128b : i7;
    }

    public boolean h() {
        return this.f22128b >= 0;
    }

    public int hashCode() {
        return y.b(this.f22127a, Integer.valueOf(this.f22128b));
    }

    public a j() {
        e0.u(!this.f22129c, "Possible bracketless IPv6 literal: %s", this.f22127a);
        return this;
    }

    public a k(int i7) {
        e0.d(i(i7));
        return h() ? this : new a(this.f22127a, i7, this.f22129c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f22127a.length() + 8);
        if (this.f22127a.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.f22127a);
            sb.append(']');
        } else {
            sb.append(this.f22127a);
        }
        if (h()) {
            sb.append(':');
            sb.append(this.f22128b);
        }
        return sb.toString();
    }
}
