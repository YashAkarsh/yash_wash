package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f3200d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3202b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3203c;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3204a;

        static {
            int[] iArr = new int[b.values().length];
            f3204a = iArr;
            try {
                iArr[b.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3204a[b.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3204a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3204a[b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3204a[b.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3204a[b.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    enum b {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public g(String str) {
        this.f3201a = str;
    }

    private c a(c cVar, int i7, b bVar, boolean z7, char[] cArr) {
        c cVarD0;
        if (f3200d) {
            System.out.println("CREATE " + bVar + " at " + cArr[i7]);
        }
        switch (a.f3204a[bVar.ordinal()]) {
            case 1:
                cVarD0 = f.d0(cArr);
                i7++;
                break;
            case 2:
                cVarD0 = androidx.constraintlayout.core.parser.a.z(cArr);
                i7++;
                break;
            case 3:
                cVarD0 = i.x(cArr);
                break;
            case 4:
                cVarD0 = e.x(cArr);
                break;
            case 5:
                cVarD0 = d.z(cArr);
                break;
            case 6:
                cVarD0 = j.x(cArr);
                break;
            default:
                cVarD0 = null;
                break;
        }
        if (cVarD0 == null) {
            return null;
        }
        cVarD0.t(this.f3203c);
        if (z7) {
            cVarD0.u(i7);
        }
        if (cVar instanceof androidx.constraintlayout.core.parser.b) {
            cVarD0.r((androidx.constraintlayout.core.parser.b) cVar);
        }
        return cVarD0;
    }

    private c b(int i7, char c8, c cVar, char[] cArr) throws h {
        if (c8 == '\t' || c8 == '\n' || c8 == '\r' || c8 == ' ') {
            return cVar;
        }
        if (c8 == '\"' || c8 == '\'') {
            return cVar instanceof f ? a(cVar, i7, b.KEY, true, cArr) : a(cVar, i7, b.STRING, true, cArr);
        }
        if (c8 == '[') {
            return a(cVar, i7, b.ARRAY, true, cArr);
        }
        if (c8 != ']') {
            if (c8 == '{') {
                return a(cVar, i7, b.OBJECT, true, cArr);
            }
            if (c8 != '}') {
                switch (c8) {
                    case '+':
                    case '-':
                    case '.':
                    case ConstraintLayout.LayoutParams.a.W /* 48 */:
                    case '1':
                    case '2':
                    case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                    case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                    case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                    case '6':
                    case '7':
                    case com.alibaba.fastjson.asm.j.f12626t /* 56 */:
                    case com.alibaba.fastjson.asm.j.f12627u /* 57 */:
                        return a(cVar, i7, b.NUMBER, true, cArr);
                    case ',':
                    case com.alibaba.fastjson.asm.j.f12628v /* 58 */:
                        return cVar;
                    case '/':
                        int i8 = i7 + 1;
                        if (i8 >= cArr.length || cArr[i8] != '/') {
                            return cVar;
                        }
                        this.f3202b = true;
                        return cVar;
                    default:
                        if (!(cVar instanceof androidx.constraintlayout.core.parser.b) || (cVar instanceof f)) {
                            return a(cVar, i7, b.KEY, true, cArr);
                        }
                        c cVarA = a(cVar, i7, b.TOKEN, true, cArr);
                        j jVar = (j) cVarA;
                        if (jVar.D(c8, i7)) {
                            return cVarA;
                        }
                        throw new h("incorrect token <" + c8 + "> at line " + this.f3203c, jVar);
                }
            }
        }
        cVar.s(i7 - 1);
        c cVarD = cVar.d();
        cVarD.s(i7);
        return cVarD;
    }

    public static f d(String str) throws h {
        return new g(str).c();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x014c A[EDGE_INSN: B:106:0x014c->B:116:? BREAK  A[LOOP:1: B:14:0x0036->B:86:0x0146], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:76:0x011b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0126  */
    public f c() throws h {
        boolean z7;
        long j7;
        char c8;
        long j8;
        j jVar;
        long j9;
        char[] charArray = this.f3201a.toCharArray();
        int length = charArray.length;
        int i7 = 1;
        this.f3203c = 1;
        boolean z8 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            char c9 = charArray[i8];
            if (c9 == '{') {
                break;
            }
            if (c9 == '\n') {
                this.f3203c++;
            }
            i8++;
        }
        if (i8 == -1) {
            throw new h("invalid json content", null);
        }
        f fVarD0 = f.d0(charArray);
        fVarD0.t(this.f3203c);
        fVarD0.u(i8);
        int i9 = i8 + 1;
        c cVarD = fVarD0;
        while (i9 < length) {
            char c10 = charArray[i9];
            if (c10 == '\n') {
                this.f3203c += i7;
            }
            if (this.f3202b) {
                if (c10 == '\n') {
                    this.f3202b = z8;
                    if (cVarD == null) {
                        break;
                        break;
                    }
                    if (cVarD.n()) {
                        cVarD = b(i9, c10, cVarD, charArray);
                    } else if (cVarD instanceof f) {
                        if (c10 == '}') {
                            cVarD.s(i9 - 1);
                        } else {
                            cVarD = b(i9, c10, cVarD, charArray);
                        }
                    } else if (cVarD instanceof androidx.constraintlayout.core.parser.a) {
                        z7 = cVarD instanceof i;
                        if (z7) {
                            j9 = cVarD.f3191b;
                            if (charArray[(int) j9] == c10) {
                                cVarD.u(j9 + 1);
                                cVarD.s(i9 - 1);
                            }
                        } else {
                            if (cVarD instanceof j) {
                                jVar = (j) cVarD;
                                if (!jVar.D(c10, i9)) {
                                    throw new h("parsing incorrect token " + jVar.b() + " at line " + this.f3203c, jVar);
                                }
                            }
                            if (cVarD instanceof d) {
                                j7 = cVarD.f3191b;
                                c8 = charArray[(int) j7];
                                if (c8 != '\'') {
                                    cVarD.u(j7 + 1);
                                    cVarD.s(i9 - 1);
                                } else {
                                    cVarD.u(j7 + 1);
                                    cVarD.s(i9 - 1);
                                }
                            } else {
                                j7 = cVarD.f3191b;
                                c8 = charArray[(int) j7];
                                if (c8 != '\'') {
                                    cVarD.u(j7 + 1);
                                    cVarD.s(i9 - 1);
                                } else {
                                    cVarD.u(j7 + 1);
                                    cVarD.s(i9 - 1);
                                }
                            }
                            if (!cVarD.n()) {
                                j8 = i9 - 1;
                                cVarD.s(j8);
                                if (c10 != '}') {
                                    cVarD = cVarD.d();
                                    cVarD.s(j8);
                                    if (cVarD instanceof d) {
                                        cVarD = cVarD.d();
                                        cVarD.s(j8);
                                    }
                                } else {
                                    cVarD = cVarD.d();
                                    cVarD.s(j8);
                                    if (cVarD instanceof d) {
                                        cVarD = cVarD.d();
                                        cVarD.s(j8);
                                    }
                                }
                            }
                        }
                    } else if (c10 == ']') {
                        cVarD.s(i9 - 1);
                    } else {
                        cVarD = b(i9, c10, cVarD, charArray);
                    }
                    if (!cVarD.n()) {
                    }
                } else {
                    continue;
                }
            } else {
                if (cVarD == null) {
                    break;
                }
                if (cVarD.n()) {
                    cVarD = b(i9, c10, cVarD, charArray);
                } else if (cVarD instanceof f) {
                    if (c10 == '}') {
                        cVarD.s(i9 - 1);
                    } else {
                        cVarD = b(i9, c10, cVarD, charArray);
                    }
                } else if (cVarD instanceof androidx.constraintlayout.core.parser.a) {
                    z7 = cVarD instanceof i;
                    if (z7) {
                        j9 = cVarD.f3191b;
                        if (charArray[(int) j9] == c10) {
                            cVarD.u(j9 + 1);
                            cVarD.s(i9 - 1);
                        }
                    } else {
                        if (cVarD instanceof j) {
                            jVar = (j) cVarD;
                            if (!jVar.D(c10, i9)) {
                                throw new h("parsing incorrect token " + jVar.b() + " at line " + this.f3203c, jVar);
                            }
                        }
                        if ((cVarD instanceof d) || z7) {
                            j7 = cVarD.f3191b;
                            c8 = charArray[(int) j7];
                            if ((c8 != '\'' || c8 == '\"') && c8 == c10) {
                                cVarD.u(j7 + 1);
                                cVarD.s(i9 - 1);
                            }
                        }
                        if (!cVarD.n() && (c10 == '}' || c10 == ']' || c10 == ',' || c10 == ' ' || c10 == '\t' || c10 == '\r' || c10 == '\n' || c10 == ':')) {
                            j8 = i9 - 1;
                            cVarD.s(j8);
                            if (c10 != '}' || c10 == ']') {
                                cVarD = cVarD.d();
                                cVarD.s(j8);
                                if (cVarD instanceof d) {
                                    cVarD = cVarD.d();
                                    cVarD.s(j8);
                                }
                            }
                        }
                    }
                } else if (c10 == ']') {
                    cVarD.s(i9 - 1);
                } else {
                    cVarD = b(i9, c10, cVarD, charArray);
                }
                if (!cVarD.n() && (!(cVarD instanceof d) || ((d) cVarD).f3187h.size() > 0)) {
                    cVarD = cVarD.d();
                }
            }
            i9++;
            i7 = 1;
            z8 = false;
        }
        while (cVarD != null && !cVarD.n()) {
            if (cVarD instanceof i) {
                cVarD.u(((int) cVarD.f3191b) + 1);
            }
            cVarD.s(length - 1);
            cVarD = cVarD.d();
        }
        if (f3200d) {
            System.out.println("Root: " + fVarD0.w());
        }
        return fVarD0;
    }
}
