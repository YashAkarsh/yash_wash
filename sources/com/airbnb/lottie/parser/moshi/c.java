package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.d0;
import okio.m;
import okio.n;
import okio.o;
import okio.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f12208g = new String[128];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f12210b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f12211c = new String[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f12212d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12214f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String[] f12215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d0 f12216b;

        private a(String[] strArr, d0 d0Var) {
            this.f12215a = strArr;
            this.f12216b = d0Var;
        }

        public static a a(String... strArr) {
            try {
                p[] pVarArr = new p[strArr.length];
                m mVar = new m();
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    c.s0(mVar, strArr[i7]);
                    mVar.readByte();
                    pVarArr[i7] = mVar.E0();
                }
                return new a((String[]) strArr.clone(), d0.k(pVarArr));
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i7 = 0; i7 <= 31; i7++) {
            f12208g[i7] = String.format("\\u%04x", Integer.valueOf(i7));
        }
        String[] strArr = f12208g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    public static c g0(o oVar) {
        return new e(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    public static void s0(n nVar, String str) throws IOException {
        String str2;
        String[] strArr = f12208g;
        nVar.writeByte(34);
        int length = str.length();
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i7 < i8) {
                        nVar.B0(str, i7, i8);
                    }
                    nVar.q0(str2);
                    i7 = i8 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i7 < i8) {
                    nVar.B0(str, i7, i8);
                }
                nVar.q0(str2);
                i7 = i8 + 1;
            }
        }
        if (i7 < length) {
            nVar.B0(str, i7, length);
        }
        nVar.writeByte(34);
    }

    public final String C() {
        return d.a(this.f12209a, this.f12210b, this.f12211c, this.f12212d);
    }

    public abstract boolean E() throws IOException;

    public abstract boolean F() throws IOException;

    public abstract double G() throws IOException;

    public abstract int H() throws IOException;

    public abstract String K() throws IOException;

    public abstract String Q() throws IOException;

    public abstract void e() throws IOException;

    public abstract b h0() throws IOException;

    final void l0(int i7) {
        int i8 = this.f12209a;
        int[] iArr = this.f12210b;
        if (i8 == iArr.length) {
            if (i8 == 256) {
                throw new com.airbnb.lottie.parser.moshi.a("Nesting too deep at " + C());
            }
            this.f12210b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f12211c;
            this.f12211c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f12212d;
            this.f12212d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f12210b;
        int i9 = this.f12209a;
        this.f12209a = i9 + 1;
        iArr3[i9] = i7;
    }

    public abstract int o0(a aVar) throws IOException;

    public abstract void p0() throws IOException;

    public abstract void q() throws IOException;

    public abstract void r() throws IOException;

    public abstract void r0() throws IOException;

    public abstract void u() throws IOException;

    final com.airbnb.lottie.parser.moshi.b v0(String str) throws com.airbnb.lottie.parser.moshi.b {
        throw new com.airbnb.lottie.parser.moshi.b(str + " at path " + C());
    }
}
