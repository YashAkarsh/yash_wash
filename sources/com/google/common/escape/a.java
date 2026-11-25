package com.google.common.escape;

import com.google.common.base.e0;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public abstract class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[][] f21515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final char f21517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final char f21518f;

    protected a(Map<Character, String> map, char c8, char c9) {
        this(b.a(map), c8, c9);
    }

    @Override // com.google.common.escape.d, com.google.common.escape.f
    public final String b(String str) {
        e0.E(str);
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if ((cCharAt < this.f21516d && this.f21515c[cCharAt] != null) || cCharAt > this.f21518f || cCharAt < this.f21517e) {
                return d(str, i7);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.d
    protected final char[] c(char c8) {
        char[] cArr;
        if (c8 < this.f21516d && (cArr = this.f21515c[c8]) != null) {
            return cArr;
        }
        if (c8 < this.f21517e || c8 > this.f21518f) {
            return f(c8);
        }
        return null;
    }

    protected abstract char[] f(char c8);

    protected a(b bVar, char c8, char c9) {
        e0.E(bVar);
        char[][] cArrC = bVar.c();
        this.f21515c = cArrC;
        this.f21516d = cArrC.length;
        if (c9 < c8) {
            c9 = 0;
            c8 = r.f34909c;
        }
        this.f21517e = c8;
        this.f21518f = c9;
    }
}
