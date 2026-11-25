package com.airbnb.lottie.parser;

import c.o0;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private d() {
    }

    @o0
    private static <T> List<com.airbnb.lottie.value.a<T>> a(com.airbnb.lottie.parser.moshi.c cVar, float f8, com.airbnb.lottie.f fVar, k0<T> k0Var) throws IOException {
        return r.a(cVar, fVar, f8, k0Var);
    }

    @o0
    private static <T> List<com.airbnb.lottie.value.a<T>> b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, k0<T> k0Var) throws IOException {
        return r.a(cVar, fVar, 1.0f, k0Var);
    }

    static com.airbnb.lottie.model.animatable.a c(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.a(b(cVar, fVar, f.f12191a));
    }

    static com.airbnb.lottie.model.animatable.j d(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.j(b(cVar, fVar, h.f12195a));
    }

    public static com.airbnb.lottie.model.animatable.b e(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return f(cVar, fVar, true);
    }

    public static com.airbnb.lottie.model.animatable.b f(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, boolean z7) throws IOException {
        return new com.airbnb.lottie.model.animatable.b(a(cVar, z7 ? com.airbnb.lottie.utils.j.e() : 1.0f, fVar, i.f12198a));
    }

    static com.airbnb.lottie.model.animatable.c g(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, int i7) throws IOException {
        return new com.airbnb.lottie.model.animatable.c(b(cVar, fVar, new l(i7)));
    }

    static com.airbnb.lottie.model.animatable.d h(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.d(b(cVar, fVar, o.f12291a));
    }

    static com.airbnb.lottie.model.animatable.f i(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.f(a(cVar, com.airbnb.lottie.utils.j.e(), fVar, z.f12309a));
    }

    static com.airbnb.lottie.model.animatable.g j(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.g((List<com.airbnb.lottie.value.a<com.airbnb.lottie.value.k>>) b(cVar, fVar, d0.f12187a));
    }

    static com.airbnb.lottie.model.animatable.h k(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        return new com.airbnb.lottie.model.animatable.h(a(cVar, com.airbnb.lottie.utils.j.e(), fVar, e0.f12189a));
    }
}
