package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class o implements k0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12291a = new o();

    private o() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        return Integer.valueOf(Math.round(p.g(cVar) * f8));
    }
}
