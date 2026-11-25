package com.google.common.escape;

import com.google.common.base.e0;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public abstract class c extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[][] f21521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final char f21525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final char f21526h;

    protected c(Map<Character, String> map, int i7, int i8, String str) {
        this(b.a(map), i7, i8, str);
    }

    @Override // com.google.common.escape.i, com.google.common.escape.f
    public final String b(String str) {
        e0.E(str);
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if ((cCharAt < this.f21522d && this.f21521c[cCharAt] != null) || cCharAt > this.f21526h || cCharAt < this.f21525g) {
                return e(str, i7);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.i
    protected final char[] d(int i7) {
        char[] cArr;
        if (i7 < this.f21522d && (cArr = this.f21521c[i7]) != null) {
            return cArr;
        }
        if (i7 < this.f21523e || i7 > this.f21524f) {
            return h(i7);
        }
        return null;
    }

    @Override // com.google.common.escape.i
    protected final int g(CharSequence charSequence, int i7, int i8) {
        while (i7 < i8) {
            char cCharAt = charSequence.charAt(i7);
            if ((cCharAt < this.f21522d && this.f21521c[cCharAt] != null) || cCharAt > this.f21526h || cCharAt < this.f21525g) {
                break;
            }
            i7++;
        }
        return i7;
    }

    protected abstract char[] h(int i7);

    protected c(b bVar, int i7, int i8, String str) {
        e0.E(bVar);
        char[][] cArrC = bVar.c();
        this.f21521c = cArrC;
        this.f21522d = cArrC.length;
        if (i8 < i7) {
            i8 = -1;
            i7 = Integer.MAX_VALUE;
        }
        this.f21523e = i7;
        this.f21524f = i8;
        if (i7 >= 55296) {
            this.f21525g = r.f34909c;
            this.f21526h = (char) 0;
        } else {
            this.f21525g = (char) i7;
            this.f21526h = (char) Math.min(i8, 55295);
        }
    }
}
