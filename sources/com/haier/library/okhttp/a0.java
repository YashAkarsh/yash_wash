package com.haier.library.okhttp;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    private a0() {
    }

    public static String a(String str, String str2) {
        return b(str, str2, n.d.f27696k);
    }

    public static String b(String str, String str2, Charset charset) {
        return "Basic " + com.haier.library.a.j.k(str + ":" + str2, charset).C();
    }
}
