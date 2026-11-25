package com.haier.library.okhttp.b.e;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27088d = 307;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f27089e = 308;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f27090f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.haier.library.okhttp.d f27091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f27092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f27093c;

    public k(com.haier.library.okhttp.d dVar, int i7, String str) {
        this.f27091a = dVar;
        this.f27092b = i7;
        this.f27093c = str;
    }

    public static k a(com.haier.library.okhttp.a aVar) {
        return new k(aVar.r0(), aVar.u(), aVar.g0());
    }

    public static k b(String str) throws IOException {
        com.haier.library.okhttp.d dVar;
        int i7;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i7 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                dVar = com.haier.library.okhttp.d.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                dVar = com.haier.library.okhttp.d.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            dVar = com.haier.library.okhttp.d.HTTP_1_0;
            i7 = 4;
        }
        int i8 = i7 + 3;
        if (str.length() < i8) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i9 = Integer.parseInt(str.substring(i7, i8));
            if (str.length() <= i8) {
                strSubstring = "";
            } else {
                if (str.charAt(i8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i7 + 4);
            }
            return new k(dVar, i9, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27091a == com.haier.library.okhttp.d.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f27092b);
        if (this.f27093c != null) {
            sb.append(' ');
            sb.append(this.f27093c);
        }
        return sb.toString();
    }
}
