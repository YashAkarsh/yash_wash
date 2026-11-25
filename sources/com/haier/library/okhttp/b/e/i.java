package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.h0;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private i() {
    }

    public static String a(com.haier.library.okhttp.f fVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.d());
        sb.append(' ');
        if (c(fVar, type)) {
            sb.append(fVar.a());
        } else {
            sb.append(b(fVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String b(h0 h0Var) {
        String strI = h0Var.I();
        String strL = h0Var.L();
        if (strL == null) {
            return strI;
        }
        return strI + '?' + strL;
    }

    private static boolean c(com.haier.library.okhttp.f fVar, Proxy.Type type) {
        return !fVar.k() && type == Proxy.Type.HTTP;
    }
}
