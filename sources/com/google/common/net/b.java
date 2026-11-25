package com.google.common.net;

import com.google.common.base.e0;
import java.net.InetAddress;
import java.text.ParseException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22130a;

    private b(String str) {
        this.f22130a = str;
    }

    public static b a(String str) throws ParseException {
        try {
            return b(str);
        } catch (IllegalArgumentException e8) {
            ParseException parseException = new ParseException("Invalid host specifier: " + str, 0);
            parseException.initCause(e8);
            throw parseException;
        }
    }

    public static b b(String str) {
        InetAddress inetAddressG;
        a aVarC = a.c(str);
        e0.d(!aVarC.h());
        String strD = aVarC.d();
        try {
            inetAddressG = d.g(strD);
        } catch (IllegalArgumentException unused) {
            inetAddressG = null;
        }
        if (inetAddressG != null) {
            return new b(d.K(inetAddressG));
        }
        e eVarD = e.d(strD);
        if (eVarD.f()) {
            return new b(eVarD.toString());
        }
        throw new IllegalArgumentException("Domain name does not have a recognized public suffix: " + strD);
    }

    public static boolean c(String str) {
        try {
            b(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f22130a.equals(((b) obj).f22130a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22130a.hashCode();
    }

    public String toString() {
        return this.f22130a;
    }
}
