package a2;

import com.google.zxing.m;
import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f22b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f23a;

    public b(com.google.zxing.common.b bVar) {
        this.f23a = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    /* JADX WARN: Code duplicated, block: B:40:0x0056  */
    /* JADX WARN: Code duplicated, block: B:68:0x002b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0031 A[EDGE_INSN: B:70:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0031 A[EDGE_INSN: B:72:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0067 A[EDGE_INSN: B:86:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0067 A[EDGE_INSN: B:88:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0067 A[EDGE_INSN: B:90:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0053 A[SYNTHETIC] */
    private int[] a(int i7, int i8, int i9, int i10, boolean z7) {
        int i11;
        com.google.zxing.common.b bVar;
        int i12;
        com.google.zxing.common.b bVar2;
        int i13 = (i9 + i10) / 2;
        int i14 = i13;
        while (i14 >= i9) {
            com.google.zxing.common.b bVar3 = this.f23a;
            if (!z7) {
                if (!bVar3.j(i7, i14)) {
                    i12 = i14;
                    while (true) {
                        i12--;
                        if (i12 >= i9) {
                            break;
                            break;
                        }
                        bVar2 = this.f23a;
                        if (z7) {
                            if (bVar2.j(i12, i7)) {
                                break;
                                break;
                            }
                        } else if (bVar2.j(i7, i12)) {
                            break;
                            break;
                        }
                    }
                    int i15 = i14 - i12;
                    if (i12 < i9) {
                        break;
                    }
                    break;
                    break;
                }
                i14--;
            } else if (bVar3.j(i14, i7)) {
                i14--;
            } else {
                i12 = i14;
                while (true) {
                    i12--;
                    if (i12 >= i9) {
                        break;
                    }
                    bVar2 = this.f23a;
                    if (z7) {
                        if (bVar2.j(i12, i7)) {
                            break;
                        }
                    } else if (bVar2.j(i7, i12)) {
                        break;
                    }
                }
                int i16 = i14 - i12;
                if (i12 < i9 || i16 > i8) {
                    break;
                }
                i14 = i12;
            }
        }
        int i17 = i14 + 1;
        while (i13 < i10) {
            com.google.zxing.common.b bVar4 = this.f23a;
            if (!z7) {
                if (!bVar4.j(i7, i13)) {
                    i11 = i13;
                    while (true) {
                        i11++;
                        if (i11 < i10) {
                            break;
                            break;
                        }
                        bVar = this.f23a;
                        if (z7) {
                            if (bVar.j(i11, i7)) {
                                break;
                                break;
                            }
                        } else if (bVar.j(i7, i11)) {
                            break;
                            break;
                        }
                    }
                    int i18 = i11 - i13;
                    if (i11 >= i10) {
                        break;
                    }
                    break;
                    break;
                }
                i13++;
            } else if (bVar4.j(i13, i7)) {
                i13++;
            } else {
                i11 = i13;
                while (true) {
                    i11++;
                    if (i11 < i10) {
                        break;
                    }
                    bVar = this.f23a;
                    if (z7) {
                        if (bVar.j(i11, i7)) {
                            break;
                        }
                    } else if (bVar.j(i7, i11)) {
                        break;
                    }
                }
                int i19 = i11 - i13;
                if (i11 >= i10 || i19 > i8) {
                    break;
                }
                i13 = i11;
            }
        }
        int i20 = i13 - 1;
        if (i20 > i17) {
            return new int[]{i17, i20};
        }
        return null;
    }

    private t c(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) throws m {
        int[] iArr = null;
        int i16 = i7;
        int i17 = i11;
        while (i17 < i14 && i17 >= i13 && i16 < i10 && i16 >= i9) {
            int[] iArrA = i8 == 0 ? a(i17, i15, i9, i10, true) : a(i16, i15, i13, i14, false);
            if (iArrA == null) {
                if (iArr == null) {
                    throw m.a();
                }
                if (i8 == 0) {
                    int i18 = i17 - i12;
                    int i19 = iArr[0];
                    if (i19 >= i7) {
                        return new t(iArr[1], i18);
                    }
                    if (iArr[1] > i7) {
                        return new t(iArr[i12 <= 0 ? (char) 1 : (char) 0], i18);
                    }
                    return new t(i19, i18);
                }
                int i20 = i16 - i8;
                int i21 = iArr[0];
                if (i21 >= i11) {
                    return new t(i20, iArr[1]);
                }
                if (iArr[1] > i11) {
                    return new t(i20, iArr[i8 >= 0 ? (char) 1 : (char) 0]);
                }
                return new t(i20, i21);
            }
            i17 += i12;
            i16 += i8;
            iArr = iArrA;
        }
        throw m.a();
    }

    public t[] b() throws m {
        int iM = this.f23a.m();
        int iQ = this.f23a.q();
        int i7 = iM / 2;
        int i8 = iQ / 2;
        int iMax = Math.max(1, iM / 256);
        int iMax2 = Math.max(1, iQ / 256);
        int i9 = -iMax;
        int i10 = i8 / 2;
        int iD = ((int) c(i8, 0, 0, iQ, i7, i9, 0, iM, i10).d()) - 1;
        int i11 = i7 / 2;
        t tVarC = c(i8, -iMax2, 0, iQ, i7, 0, iD, iM, i11);
        int iC = ((int) tVarC.c()) - 1;
        t tVarC2 = c(i8, iMax2, iC, iQ, i7, 0, iD, iM, i11);
        int iC2 = ((int) tVarC2.c()) + 1;
        t tVarC3 = c(i8, 0, iC, iC2, i7, iMax, iD, iM, i10);
        return new t[]{c(i8, 0, iC, iC2, i7, i9, iD, ((int) tVarC3.d()) + 1, i8 / 4), tVarC, tVarC2, tVarC3};
    }
}
