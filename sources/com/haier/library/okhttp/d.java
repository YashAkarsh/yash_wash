package com.haier.library.okhttp;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27520a;

    d(String str) {
        this.f27520a = str;
    }

    public static d a(String str) throws IOException {
        d dVar = HTTP_1_0;
        if (str.equals(dVar.f27520a)) {
            return dVar;
        }
        d dVar2 = HTTP_1_1;
        if (str.equals(dVar2.f27520a)) {
            return dVar2;
        }
        d dVar3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(dVar3.f27520a)) {
            return dVar3;
        }
        d dVar4 = HTTP_2;
        if (str.equals(dVar4.f27520a)) {
            return dVar4;
        }
        d dVar5 = SPDY_3;
        if (str.equals(dVar5.f27520a)) {
            return dVar5;
        }
        d dVar6 = QUIC;
        if (str.equals(dVar6.f27520a)) {
            return dVar6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f27520a;
    }
}
