package com.google.common.escape;

import com.google.common.base.e0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21529b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Character, String> f21528a = new HashMap();

    private static class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char[][] f21530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f21531d;

        a(char[][] cArr) {
            this.f21530c = cArr;
            this.f21531d = cArr.length;
        }

        @Override // com.google.common.escape.d, com.google.common.escape.f
        public String b(String str) {
            int length = str.length();
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                char[][] cArr = this.f21530c;
                if (cCharAt < cArr.length && cArr[cCharAt] != null) {
                    return d(str, i7);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.d
        protected char[] c(char c8) {
            if (c8 < this.f21531d) {
                return this.f21530c[c8];
            }
            return null;
        }
    }

    @u1.a
    public e a(char c8, String str) {
        this.f21528a.put(Character.valueOf(c8), (String) e0.E(str));
        if (c8 > this.f21529b) {
            this.f21529b = c8;
        }
        return this;
    }

    @u1.a
    public e b(char[] cArr, String str) {
        e0.E(str);
        for (char c8 : cArr) {
            a(c8, str);
        }
        return this;
    }

    public char[][] c() {
        char[][] cArr = new char[this.f21529b + 1][];
        for (Map.Entry<Character, String> entry : this.f21528a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public f d() {
        return new a(c());
    }
}
