package com.airbnb.lottie.parser.moshi;

import c.o0;
import java.io.EOFException;
import java.io.IOException;
import okio.m;
import okio.o;
import okio.p;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes.dex */
final class e extends c {
    private static final int A = 7;
    private static final int B = 8;
    private static final int C = 9;
    private static final int D = 10;
    private static final int E = 11;
    private static final int F = 12;
    private static final int G = 13;
    private static final int H = 14;
    private static final int I = 15;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f12236J = 16;
    private static final int K = 17;
    private static final int L = 18;
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int P = 3;
    private static final int Q = 4;
    private static final int R = 5;
    private static final int S = 6;
    private static final int T = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f12237n = -922337203685477580L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final p f12238o = p.k("'\\");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final p f12239p = p.k("\"\\");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final p f12240q = p.k("{}[]:, \n\t\r\f/\\;#=");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final p f12241r = p.k("\n\r");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final p f12242s = p.k("*/");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f12243t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f12244u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f12245v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f12246w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f12247x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f12248y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f12249z = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final o f12250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final m f12251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12252j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f12254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private String f12255m;

    e(o oVar) {
        if (oVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f12250h = oVar;
        this.f12251i = oVar.p();
        l0(6);
    }

    private int G0() throws IOException {
        int[] iArr = this.f12210b;
        int i7 = this.f12209a;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else if (i8 == 2) {
            int iQ0 = Q0(true);
            this.f12251i.readByte();
            if (iQ0 != 44) {
                if (iQ0 != 59) {
                    if (iQ0 != 93) {
                        throw v0("Unterminated array");
                    }
                    this.f12252j = 4;
                    return 4;
                }
                x0();
            }
        } else {
            if (i8 == 3 || i8 == 5) {
                iArr[i7 - 1] = 4;
                if (i8 == 5) {
                    int iQ1 = Q0(true);
                    this.f12251i.readByte();
                    if (iQ1 != 44) {
                        if (iQ1 != 59) {
                            if (iQ1 != 125) {
                                throw v0("Unterminated object");
                            }
                            this.f12252j = 2;
                            return 2;
                        }
                        x0();
                    }
                }
                int iQ2 = Q0(true);
                if (iQ2 == 34) {
                    this.f12251i.readByte();
                    this.f12252j = 13;
                    return 13;
                }
                if (iQ2 == 39) {
                    this.f12251i.readByte();
                    x0();
                    this.f12252j = 12;
                    return 12;
                }
                if (iQ2 != 125) {
                    x0();
                    if (!L0((char) iQ2)) {
                        throw v0("Expected name");
                    }
                    this.f12252j = 14;
                    return 14;
                }
                if (i8 == 5) {
                    throw v0("Expected name");
                }
                this.f12251i.readByte();
                this.f12252j = 2;
                return 2;
            }
            if (i8 == 4) {
                iArr[i7 - 1] = 5;
                int iQ3 = Q0(true);
                this.f12251i.readByte();
                if (iQ3 != 58) {
                    if (iQ3 != 61) {
                        throw v0("Expected ':'");
                    }
                    x0();
                    if (this.f12250h.K0(1L) && this.f12251i.v0(0L) == 62) {
                        this.f12251i.readByte();
                    }
                }
            } else if (i8 == 6) {
                iArr[i7 - 1] = 7;
            } else if (i8 == 7) {
                if (Q0(false) == -1) {
                    this.f12252j = 18;
                    return 18;
                }
                x0();
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iQ4 = Q0(true);
        if (iQ4 == 34) {
            this.f12251i.readByte();
            this.f12252j = 9;
            return 9;
        }
        if (iQ4 == 39) {
            x0();
            this.f12251i.readByte();
            this.f12252j = 8;
            return 8;
        }
        if (iQ4 != 44 && iQ4 != 59) {
            if (iQ4 == 91) {
                this.f12251i.readByte();
                this.f12252j = 3;
                return 3;
            }
            if (iQ4 != 93) {
                if (iQ4 == 123) {
                    this.f12251i.readByte();
                    this.f12252j = 1;
                    return 1;
                }
                int iY0 = Y0();
                if (iY0 != 0) {
                    return iY0;
                }
                int iA1 = a1();
                if (iA1 != 0) {
                    return iA1;
                }
                if (!L0(this.f12251i.v0(0L))) {
                    throw v0("Expected value");
                }
                x0();
                this.f12252j = 10;
                return 10;
            }
            if (i8 == 1) {
                this.f12251i.readByte();
                this.f12252j = 4;
                return 4;
            }
        }
        if (i8 != 1 && i8 != 2) {
            throw v0("Unexpected value");
        }
        x0();
        this.f12252j = 7;
        return 7;
    }

    private int I0(String str, c.a aVar) {
        int length = aVar.f12215a.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.equals(aVar.f12215a[i7])) {
                this.f12252j = 0;
                this.f12211c[this.f12209a - 1] = str;
                return i7;
            }
        }
        return -1;
    }

    private int J0(String str, c.a aVar) {
        int length = aVar.f12215a.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.equals(aVar.f12215a[i7])) {
                this.f12252j = 0;
                int[] iArr = this.f12212d;
                int i8 = this.f12209a - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
        }
        return -1;
    }

    private boolean L0(int i7) throws IOException {
        if (i7 == 9 || i7 == 10 || i7 == 12 || i7 == 13 || i7 == 32) {
            return false;
        }
        if (i7 != 35) {
            if (i7 == 44) {
                return false;
            }
            if (i7 != 47 && i7 != 61) {
                if (i7 == 123 || i7 == 125 || i7 == 58) {
                    return false;
                }
                if (i7 != 59) {
                    switch (i7) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        x0();
        return false;
    }

    private int Q0(boolean z7) throws IOException {
        int i7;
        byte bV0;
        while (true) {
            int i8 = 0;
            while (true) {
                i7 = i8 + 1;
                if (!this.f12250h.K0(i7)) {
                    if (z7) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                bV0 = this.f12251i.v0(i8);
                if (bV0 == 10 || bV0 == 32 || bV0 == 13 || bV0 == 9) {
                    i8 = i7;
                }
            }
            this.f12251i.skip(i7 - 1);
            if (bV0 == 47) {
                if (!this.f12250h.K0(2L)) {
                    return bV0;
                }
                x0();
                byte bV1 = this.f12251i.v0(1L);
                if (bV1 == 42) {
                    this.f12251i.readByte();
                    this.f12251i.readByte();
                    if (!i1()) {
                        throw v0("Unterminated comment");
                    }
                } else {
                    if (bV1 != 47) {
                        return bV0;
                    }
                    this.f12251i.readByte();
                    this.f12251i.readByte();
                    q1();
                }
            } else {
                if (bV0 != 35) {
                    return bV0;
                }
                x0();
                q1();
            }
        }
    }

    private String T0(p pVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jZ = this.f12250h.Z(pVar);
            if (jZ == -1) {
                throw v0("Unterminated string");
            }
            if (this.f12251i.v0(jZ) != 92) {
                if (sb == null) {
                    String strH = this.f12251i.h(jZ);
                    this.f12251i.readByte();
                    return strH;
                }
                sb.append(this.f12251i.h(jZ));
                this.f12251i.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f12251i.h(jZ));
            this.f12251i.readByte();
            sb.append(d1());
        }
    }

    private String V0() throws IOException {
        long jZ = this.f12250h.Z(f12240q);
        return jZ != -1 ? this.f12251i.h(jZ) : this.f12251i.m1();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int Y0() throws IOException {
        String str;
        String str2;
        int i7;
        byte bV0 = this.f12251i.v0(0L);
        if (bV0 == 116 || bV0 == 84) {
            str = "true";
            str2 = "TRUE";
            i7 = 5;
        } else if (bV0 == 102 || bV0 == 70) {
            str = com.paytm.pgsdk.d.G;
            str2 = "FALSE";
            i7 = 6;
        } else {
            if (bV0 != 110 && bV0 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i7 = 7;
        }
        int length = str.length();
        int i8 = 1;
        while (i8 < length) {
            int i9 = i8 + 1;
            if (!this.f12250h.K0(i9)) {
                return 0;
            }
            byte bV1 = this.f12251i.v0(i8);
            if (bV1 != str.charAt(i8) && bV1 != str2.charAt(i8)) {
                return 0;
            }
            i8 = i9;
        }
        if (this.f12250h.K0(length + 1) && L0(this.f12251i.v0(length))) {
            return 0;
        }
        this.f12251i.skip(length);
        this.f12252j = i7;
        return i7;
    }

    private int a1() throws IOException {
        char c8;
        boolean z7 = true;
        long j7 = 0;
        int i7 = 0;
        char c9 = 0;
        boolean z8 = false;
        boolean z9 = true;
        while (true) {
            int i8 = i7 + 1;
            if (!this.f12250h.K0(i8)) {
                break;
            }
            byte bV0 = this.f12251i.v0(i7);
            if (bV0 != 43) {
                if (bV0 == 69 || bV0 == 101) {
                    if (c9 != 2 && c9 != 4) {
                        return 0;
                    }
                    c9 = 5;
                } else if (bV0 == 45) {
                    c8 = 6;
                    if (c9 == 0) {
                        c9 = 1;
                        z8 = true;
                    } else if (c9 != 5) {
                        return 0;
                    }
                } else if (bV0 != 46) {
                    if (bV0 < 48 || bV0 > 57) {
                        if (!L0(bV0)) {
                            break;
                        }
                        return 0;
                    }
                    if (c9 == z7 || c9 == 0) {
                        j7 = -(bV0 - 48);
                        c9 = 2;
                    } else if (c9 == 2) {
                        if (j7 == 0) {
                            return 0;
                        }
                        long j8 = (10 * j7) - ((long) (bV0 - 48));
                        z9 &= j7 > -922337203685477580L || (j7 == -922337203685477580L && j8 < j7);
                        j7 = j8;
                    } else if (c9 == 3) {
                        c9 = 4;
                    } else if (c9 == 5 || c9 == 6) {
                        c9 = 7;
                    }
                } else {
                    if (c9 != 2) {
                        return 0;
                    }
                    c9 = 3;
                }
                i7 = i8;
                z7 = true;
            } else {
                c8 = 6;
                if (c9 != 5) {
                    return 0;
                }
            }
            c9 = c8;
            i7 = i8;
            z7 = true;
        }
        if (c9 == 2 && z9 && ((j7 != Long.MIN_VALUE || z8) && (j7 != 0 || !z8))) {
            if (!z8) {
                j7 = -j7;
            }
            this.f12253k = j7;
            this.f12251i.skip(i7);
            this.f12252j = 16;
            return 16;
        }
        if (c9 != 2 && c9 != 4 && c9 != 7) {
            return 0;
        }
        this.f12254l = i7;
        this.f12252j = 17;
        return 17;
    }

    private char d1() throws IOException {
        int i7;
        int i8;
        if (!this.f12250h.K0(1L)) {
            throw v0("Unterminated escape sequence");
        }
        byte b8 = this.f12251i.readByte();
        if (b8 == 10 || b8 == 34 || b8 == 39 || b8 == 47 || b8 == 92) {
            return (char) b8;
        }
        if (b8 == 98) {
            return '\b';
        }
        if (b8 == 102) {
            return '\f';
        }
        if (b8 == 110) {
            return '\n';
        }
        if (b8 == 114) {
            return CharUtils.CR;
        }
        if (b8 == 116) {
            return '\t';
        }
        if (b8 != 117) {
            if (this.f12213e) {
                return (char) b8;
            }
            throw v0("Invalid escape sequence: \\" + ((char) b8));
        }
        if (!this.f12250h.K0(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + C());
        }
        char c8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            byte bV0 = this.f12251i.v0(i9);
            char c9 = (char) (c8 << 4);
            if (bV0 < 48 || bV0 > 57) {
                if (bV0 >= 97 && bV0 <= 102) {
                    i7 = bV0 - 97;
                } else {
                    if (bV0 < 65 || bV0 > 70) {
                        throw v0("\\u" + this.f12251i.h(4L));
                    }
                    i7 = bV0 - 65;
                }
                i8 = i7 + 10;
            } else {
                i8 = bV0 - 48;
            }
            c8 = (char) (c9 + i8);
        }
        this.f12251i.skip(4L);
        return c8;
    }

    private void e1(p pVar) throws IOException {
        while (true) {
            long jZ = this.f12250h.Z(pVar);
            if (jZ == -1) {
                throw v0("Unterminated string");
            }
            if (this.f12251i.v0(jZ) != 92) {
                this.f12251i.skip(jZ + 1);
                return;
            } else {
                this.f12251i.skip(jZ + 1);
                d1();
            }
        }
    }

    private boolean i1() throws IOException {
        o oVar = this.f12250h;
        p pVar = f12242s;
        long J2 = oVar.J(pVar);
        boolean z7 = J2 != -1;
        m mVar = this.f12251i;
        mVar.skip(z7 ? J2 + ((long) pVar.a0()) : mVar.B1());
        return z7;
    }

    private void q1() throws IOException {
        long jZ = this.f12250h.Z(f12241r);
        m mVar = this.f12251i;
        mVar.skip(jZ != -1 ? jZ + 1 : mVar.B1());
    }

    private void s1() throws IOException {
        long jZ = this.f12250h.Z(f12240q);
        m mVar = this.f12251i;
        if (jZ == -1) {
            jZ = mVar.B1();
        }
        mVar.skip(jZ);
    }

    private void x0() throws IOException {
        if (!this.f12213e) {
            throw v0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public boolean E() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        return (iG0 == 2 || iG0 == 4 || iG0 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public boolean F() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 5) {
            this.f12252j = 0;
            int[] iArr = this.f12212d;
            int i7 = this.f12209a - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (iG0 == 6) {
            this.f12252j = 0;
            int[] iArr2 = this.f12212d;
            int i8 = this.f12209a - 1;
            iArr2[i8] = iArr2[i8] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + h0() + " at path " + C());
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public double G() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 16) {
            this.f12252j = 0;
            int[] iArr = this.f12212d;
            int i7 = this.f12209a - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f12253k;
        }
        if (iG0 == 17) {
            this.f12255m = this.f12251i.h(this.f12254l);
        } else if (iG0 == 9) {
            this.f12255m = T0(f12239p);
        } else if (iG0 == 8) {
            this.f12255m = T0(f12238o);
        } else if (iG0 == 10) {
            this.f12255m = V0();
        } else if (iG0 != 11) {
            throw new a("Expected a double but was " + h0() + " at path " + C());
        }
        this.f12252j = 11;
        try {
            double d8 = Double.parseDouble(this.f12255m);
            if (this.f12213e || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
                this.f12255m = null;
                this.f12252j = 0;
                int[] iArr2 = this.f12212d;
                int i8 = this.f12209a - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return d8;
            }
            throw new b("JSON forbids NaN and infinities: " + d8 + " at path " + C());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f12255m + " at path " + C());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public int H() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 16) {
            long j7 = this.f12253k;
            int i7 = (int) j7;
            if (j7 == i7) {
                this.f12252j = 0;
                int[] iArr = this.f12212d;
                int i8 = this.f12209a - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new a("Expected an int but was " + this.f12253k + " at path " + C());
        }
        if (iG0 == 17) {
            this.f12255m = this.f12251i.h(this.f12254l);
        } else if (iG0 == 9 || iG0 == 8) {
            String strT0 = iG0 == 9 ? T0(f12239p) : T0(f12238o);
            this.f12255m = strT0;
            try {
                int i9 = Integer.parseInt(strT0);
                this.f12252j = 0;
                int[] iArr2 = this.f12212d;
                int i10 = this.f12209a - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return i9;
            } catch (NumberFormatException unused) {
            }
        } else if (iG0 != 11) {
            throw new a("Expected an int but was " + h0() + " at path " + C());
        }
        this.f12252j = 11;
        try {
            double d8 = Double.parseDouble(this.f12255m);
            int i11 = (int) d8;
            if (i11 == d8) {
                this.f12255m = null;
                this.f12252j = 0;
                int[] iArr3 = this.f12212d;
                int i12 = this.f12209a - 1;
                iArr3[i12] = iArr3[i12] + 1;
                return i11;
            }
            throw new a("Expected an int but was " + this.f12255m + " at path " + C());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f12255m + " at path " + C());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public String K() throws IOException {
        String strT0;
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 14) {
            strT0 = V0();
        } else if (iG0 == 13) {
            strT0 = T0(f12239p);
        } else if (iG0 == 12) {
            strT0 = T0(f12238o);
        } else {
            if (iG0 != 15) {
                throw new a("Expected a name but was " + h0() + " at path " + C());
            }
            strT0 = this.f12255m;
        }
        this.f12252j = 0;
        this.f12211c[this.f12209a - 1] = strT0;
        return strT0;
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public String Q() throws IOException {
        String strH;
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 10) {
            strH = V0();
        } else if (iG0 == 9) {
            strH = T0(f12239p);
        } else if (iG0 == 8) {
            strH = T0(f12238o);
        } else if (iG0 == 11) {
            strH = this.f12255m;
            this.f12255m = null;
        } else if (iG0 == 16) {
            strH = Long.toString(this.f12253k);
        } else {
            if (iG0 != 17) {
                throw new a("Expected a string but was " + h0() + " at path " + C());
            }
            strH = this.f12251i.h(this.f12254l);
        }
        this.f12252j = 0;
        int[] iArr = this.f12212d;
        int i7 = this.f12209a - 1;
        iArr[i7] = iArr[i7] + 1;
        return strH;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12252j = 0;
        this.f12210b[0] = 8;
        this.f12209a = 1;
        this.f12251i.q();
        this.f12250h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void e() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 3) {
            l0(1);
            this.f12212d[this.f12209a - 1] = 0;
            this.f12252j = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + h0() + " at path " + C());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public c.b h0() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        switch (iG0) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public int o0(c.a aVar) throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 < 12 || iG0 > 15) {
            return -1;
        }
        if (iG0 == 15) {
            return I0(this.f12255m, aVar);
        }
        int iV1 = this.f12250h.V1(aVar.f12216b);
        if (iV1 != -1) {
            this.f12252j = 0;
            this.f12211c[this.f12209a - 1] = aVar.f12215a[iV1];
            return iV1;
        }
        String str = this.f12211c[this.f12209a - 1];
        String strK = K();
        int iI0 = I0(strK, aVar);
        if (iI0 == -1) {
            this.f12252j = 15;
            this.f12255m = strK;
            this.f12211c[this.f12209a - 1] = str;
        }
        return iI0;
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void p0() throws IOException {
        if (this.f12214f) {
            throw new a("Cannot skip unexpected " + h0() + " at " + C());
        }
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 14) {
            s1();
        } else if (iG0 == 13) {
            e1(f12239p);
        } else if (iG0 == 12) {
            e1(f12238o);
        } else if (iG0 != 15) {
            throw new a("Expected a name but was " + h0() + " at path " + C());
        }
        this.f12252j = 0;
        this.f12211c[this.f12209a - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void q() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 == 1) {
            l0(3);
            this.f12252j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + h0() + " at path " + C());
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void r() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 != 4) {
            throw new a("Expected END_ARRAY but was " + h0() + " at path " + C());
        }
        int i7 = this.f12209a - 1;
        this.f12209a = i7;
        int[] iArr = this.f12212d;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f12252j = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void r0() throws IOException {
        if (this.f12214f) {
            throw new a("Cannot skip unexpected " + h0() + " at " + C());
        }
        int i7 = 0;
        do {
            int iG0 = this.f12252j;
            if (iG0 == 0) {
                iG0 = G0();
            }
            if (iG0 == 3) {
                l0(1);
            } else {
                if (iG0 == 1) {
                    l0(3);
                } else if (iG0 == 4) {
                    i7--;
                    if (i7 < 0) {
                        throw new a("Expected a value but was " + h0() + " at path " + C());
                    }
                    this.f12209a--;
                } else if (iG0 == 2) {
                    i7--;
                    if (i7 < 0) {
                        throw new a("Expected a value but was " + h0() + " at path " + C());
                    }
                    this.f12209a--;
                } else if (iG0 == 14 || iG0 == 10) {
                    s1();
                } else if (iG0 == 9 || iG0 == 13) {
                    e1(f12239p);
                } else if (iG0 == 8 || iG0 == 12) {
                    e1(f12238o);
                } else if (iG0 == 17) {
                    this.f12251i.skip(this.f12254l);
                } else if (iG0 == 18) {
                    throw new a("Expected a value but was " + h0() + " at path " + C());
                }
                this.f12252j = 0;
            }
            i7++;
            this.f12252j = 0;
        } while (i7 != 0);
        int[] iArr = this.f12212d;
        int i8 = this.f12209a;
        int i9 = i8 - 1;
        iArr[i9] = iArr[i9] + 1;
        this.f12211c[i8 - 1] = "null";
    }

    public String toString() {
        return "JsonReader(" + this.f12250h + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.c
    public void u() throws IOException {
        int iG0 = this.f12252j;
        if (iG0 == 0) {
            iG0 = G0();
        }
        if (iG0 != 2) {
            throw new a("Expected END_OBJECT but was " + h0() + " at path " + C());
        }
        int i7 = this.f12209a - 1;
        this.f12209a = i7;
        this.f12211c[i7] = null;
        int[] iArr = this.f12212d;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f12252j = 0;
    }
}
