package com.google.zxing.oned.rss.expanded.decoders;

import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.a f23942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f23943b;

    j(com.google.zxing.common.a aVar) {
        this.f23942a = aVar;
        this.f23943b = new s(aVar);
    }

    public static j a(com.google.zxing.common.a aVar) {
        if (aVar.k(1)) {
            return new g(aVar);
        }
        if (!aVar.k(2)) {
            return new k(aVar);
        }
        int iG = s.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = s.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (s.g(aVar, 1, 7)) {
            case com.alibaba.fastjson.asm.j.f12626t /* 56 */:
                return new e(aVar, "310", "11");
            case com.alibaba.fastjson.asm.j.f12627u /* 57 */:
                return new e(aVar, "320", "11");
            case com.alibaba.fastjson.asm.j.f12628v /* 58 */:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case b0.f36952q /* 61 */:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case androidx.core.text.f.f6258k /* 63 */:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }

    protected final s b() {
        return this.f23943b;
    }

    protected final com.google.zxing.common.a c() {
        return this.f23942a;
    }

    public abstract String d() throws com.google.zxing.m, com.google.zxing.h;
}
