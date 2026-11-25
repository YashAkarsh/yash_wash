package com.google.zxing.aztec.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f23377c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f23378d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f23379e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f23380f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f23381g = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[][] f23383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int[][] f23384j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f23385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f23376b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[][] f23382h = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f23383i = iArr;
        iArr[0][32] = 1;
        for (int i7 = 65; i7 <= 90; i7++) {
            f23383i[0][i7] = (i7 - 65) + 2;
        }
        f23383i[1][32] = 1;
        for (int i8 = 97; i8 <= 122; i8++) {
            f23383i[1][i8] = (i8 - 97) + 2;
        }
        f23383i[2][32] = 1;
        for (int i9 = 48; i9 <= 57; i9++) {
            f23383i[2][i9] = (i9 - 48) + 2;
        }
        int[] iArr2 = f23383i[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i10 = 0; i10 < 28; i10++) {
            f23383i[3][iArr3[i10]] = i10;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i11 = 0; i11 < 31; i11++) {
            int i12 = iArr4[i11];
            if (i12 > 0) {
                f23383i[4][i12] = i11;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f23384j = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f23384j;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public d(byte[] bArr) {
        this.f23385a = bArr;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        boolean z7;
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z7 = true;
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.g(fVar)) {
                    z7 = false;
                    break;
                }
                if (fVar.g(fVar2)) {
                    it.remove();
                }
            }
            if (z7) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i7, Collection<f> collection) {
        char c8 = (char) (this.f23385a[i7] & 255);
        boolean z7 = f23383i[fVar.e()][c8] > 0;
        f fVarB = null;
        for (int i8 = 0; i8 <= 4; i8++) {
            int i9 = f23383i[i8][c8];
            if (i9 > 0) {
                if (fVarB == null) {
                    fVarB = fVar.b(i7);
                }
                if (!z7 || i8 == fVar.e() || i8 == 2) {
                    collection.add(fVarB.h(i8, i9));
                }
                if (!z7 && f23384j[fVar.e()][i8] >= 0) {
                    collection.add(fVarB.i(i8, i9));
                }
            }
        }
        if (fVar.c() > 0 || f23383i[fVar.e()][c8] == 0) {
            collection.add(fVar.a(i7));
        }
    }

    private static void d(f fVar, int i7, int i8, Collection<f> collection) {
        f fVarB = fVar.b(i7);
        collection.add(fVarB.h(4, i8));
        if (fVar.e() != 4) {
            collection.add(fVarB.i(4, i8));
        }
        if (i8 == 3 || i8 == 4) {
            collection.add(fVarB.h(2, 16 - i8).h(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i7).a(i7 + 1));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i7) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i7, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i7, int i8) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i7, i8, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    public com.google.zxing.common.a a() {
        int i7;
        Collection<f> collectionSingletonList = Collections.singletonList(f.f23389e);
        int i8 = 0;
        while (true) {
            byte[] bArr = this.f23385a;
            if (i8 >= bArr.length) {
                return ((f) Collections.min(collectionSingletonList, new a())).j(this.f23385a);
            }
            int i9 = i8 + 1;
            byte b8 = i9 < bArr.length ? bArr[i9] : (byte) 0;
            byte b9 = bArr[i8];
            if (b9 != 13) {
                if (b9 != 44) {
                    if (b9 != 46) {
                        if (b9 == 58 && b8 == 32) {
                            i7 = 5;
                        } else {
                            i7 = 0;
                        }
                    } else if (b8 == 32) {
                        i7 = 3;
                    } else {
                        i7 = 0;
                    }
                } else if (b8 == 32) {
                    i7 = 4;
                } else {
                    i7 = 0;
                }
            } else if (b8 == 10) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (i7 > 0) {
                collectionSingletonList = f(collectionSingletonList, i8, i7);
                i8 = i9;
            } else {
                collectionSingletonList = e(collectionSingletonList, i8);
            }
            i8++;
        }
    }
}
