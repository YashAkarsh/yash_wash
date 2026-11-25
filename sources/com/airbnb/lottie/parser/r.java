package com.airbnb.lottie.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.airbnb.lottie.parser.moshi.c.a f12298a = com.airbnb.lottie.parser.moshi.c.a.a("k");

    private r() {
    }

    static <T> List<com.airbnb.lottie.value.a<T>> a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, float f8, k0<T> k0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.STRING) {
            fVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.q();
        while (cVar.E()) {
            if (cVar.o0(f12298a) != 0) {
                cVar.r0();
            } else if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY) {
                cVar.e();
                if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.NUMBER) {
                    arrayList.add(q.b(cVar, fVar, f8, k0Var, false));
                } else {
                    while (cVar.E()) {
                        arrayList.add(q.b(cVar, fVar, f8, k0Var, true));
                    }
                }
                cVar.r();
            } else {
                arrayList.add(q.b(cVar, fVar, f8, k0Var, false));
            }
        }
        cVar.u();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends com.airbnb.lottie.value.a<T>> list) {
        int i7;
        T t7;
        int size = list.size();
        int i8 = 0;
        while (true) {
            i7 = size - 1;
            if (i8 >= i7) {
                break;
            }
            com.airbnb.lottie.value.a<T> aVar = list.get(i8);
            i8++;
            com.airbnb.lottie.value.a<T> aVar2 = list.get(i8);
            aVar.f12353f = Float.valueOf(aVar2.f12352e);
            if (aVar.f12350c == null && (t7 = aVar2.f12349b) != null) {
                aVar.f12350c = t7;
                if (aVar instanceof com.airbnb.lottie.animation.keyframe.h) {
                    ((com.airbnb.lottie.animation.keyframe.h) aVar).i();
                }
            }
        }
        com.airbnb.lottie.value.a<T> aVar3 = list.get(i7);
        if ((aVar3.f12349b == null || aVar3.f12350c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
