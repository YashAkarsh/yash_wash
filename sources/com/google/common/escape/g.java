package com.google.common.escape;

import com.google.common.base.e0;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f21534a = new a();

    static class a extends d {
        a() {
        }

        @Override // com.google.common.escape.d, com.google.common.escape.f
        public String b(String str) {
            return (String) e0.E(str);
        }

        @Override // com.google.common.escape.d
        protected char[] c(char c8) {
            return null;
        }
    }

    static class b extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f21535c;

        b(d dVar) {
            this.f21535c = dVar;
        }

        @Override // com.google.common.escape.i
        protected char[] d(int i7) {
            if (i7 < 65536) {
                return this.f21535c.c((char) i7);
            }
            char[] cArr = new char[2];
            Character.toChars(i7, cArr, 0);
            char[] cArrC = this.f21535c.c(cArr[0]);
            char[] cArrC2 = this.f21535c.c(cArr[1]);
            if (cArrC == null && cArrC2 == null) {
                return null;
            }
            int length = cArrC != null ? cArrC.length : 1;
            char[] cArr2 = new char[(cArrC2 != null ? cArrC2.length : 1) + length];
            if (cArrC != null) {
                for (int i8 = 0; i8 < cArrC.length; i8++) {
                    cArr2[i8] = cArrC[i8];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (cArrC2 != null) {
                for (int i9 = 0; i9 < cArrC2.length; i9++) {
                    cArr2[length + i9] = cArrC2[i9];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    @s1.a
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Character, String> f21536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private char f21537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private char f21538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f21539d;

        class a extends com.google.common.escape.a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final char[] f21540g;

            a(Map map, char c8, char c9) {
                super((Map<Character, String>) map, c8, c9);
                this.f21540g = c.this.f21539d != null ? c.this.f21539d.toCharArray() : null;
            }

            @Override // com.google.common.escape.a
            protected char[] f(char c8) {
                return this.f21540g;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @u1.a
        public c b(char c8, String str) {
            e0.E(str);
            this.f21536a.put(Character.valueOf(c8), str);
            return this;
        }

        public f c() {
            return new a(this.f21536a, this.f21537b, this.f21538c);
        }

        @u1.a
        public c d(char c8, char c9) {
            this.f21537b = c8;
            this.f21538c = c9;
            return this;
        }

        @u1.a
        public c e(String str) {
            this.f21539d = str;
            return this;
        }

        private c() {
            this.f21536a = new HashMap();
            this.f21537b = (char) 0;
            this.f21538c = r.f34909c;
            this.f21539d = null;
        }
    }

    private g() {
    }

    static i a(f fVar) {
        e0.E(fVar);
        if (fVar instanceof i) {
            return (i) fVar;
        }
        if (fVar instanceof d) {
            return g((d) fVar);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + fVar.getClass().getName());
    }

    public static c b() {
        return new c(null);
    }

    public static String c(d dVar, char c8) {
        return f(dVar.c(c8));
    }

    public static String d(i iVar, int i7) {
        return f(iVar.d(i7));
    }

    public static f e() {
        return f21534a;
    }

    private static String f(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static i g(d dVar) {
        return new b(dVar);
    }
}
