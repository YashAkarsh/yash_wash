package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends kotlin.collections.c<p> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f38425d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final p[] f38426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final int[] f38427c;

    public static final class a {
        private a() {
        }

        private final void a(long j7, m mVar, int i7, List<? extends p> list, int i8, int i9, List<Integer> list2) throws IOException {
            int i10;
            int i11;
            int i12;
            int i13 = i7;
            if (!(i8 < i9)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i14 = i8; i14 < i9; i14++) {
                if (!(list.get(i14).a0() >= i13)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            p pVar = list.get(i8);
            p pVar2 = list.get(i9 - 1);
            int i15 = -1;
            if (i13 == pVar.a0()) {
                int iIntValue = list2.get(i8).intValue();
                int i16 = i8 + 1;
                p pVar3 = list.get(i16);
                i10 = i16;
                i11 = iIntValue;
                pVar = pVar3;
            } else {
                i10 = i8;
                i11 = -1;
            }
            if (pVar.n(i13) == pVar2.n(i13)) {
                int iMin = Math.min(pVar.a0(), pVar2.a0());
                int i17 = 0;
                for (int i18 = i13; i18 < iMin && pVar.n(i18) == pVar2.n(i18); i18++) {
                    i17++;
                }
                long jC = j7 + c(mVar) + ((long) 2) + ((long) i17) + 1;
                mVar.writeInt(-i17);
                mVar.writeInt(i11);
                int i19 = i13 + i17;
                while (i13 < i19) {
                    mVar.writeInt(pVar.n(i13) & 255);
                    i13++;
                }
                if (i10 + 1 == i9) {
                    if (!(i19 == list.get(i10).a0())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    mVar.writeInt(list2.get(i10).intValue());
                    return;
                } else {
                    m mVar2 = new m();
                    mVar.writeInt(((int) (c(mVar2) + jC)) * (-1));
                    a(jC, mVar2, i19, list, i10, i9, list2);
                    mVar.C0(mVar2);
                    return;
                }
            }
            int i20 = 1;
            for (int i21 = i10 + 1; i21 < i9; i21++) {
                if (list.get(i21 - 1).n(i13) != list.get(i21).n(i13)) {
                    i20++;
                }
            }
            long jC2 = j7 + c(mVar) + ((long) 2) + ((long) (i20 * 2));
            mVar.writeInt(i20);
            mVar.writeInt(i11);
            for (int i22 = i10; i22 < i9; i22++) {
                byte bN = list.get(i22).n(i13);
                if (i22 == i10 || bN != list.get(i22 - 1).n(i13)) {
                    mVar.writeInt(bN & 255);
                }
            }
            m mVar3 = new m();
            while (i10 < i9) {
                byte bN2 = list.get(i10).n(i13);
                int i23 = i10 + 1;
                int i24 = i23;
                while (true) {
                    if (i24 >= i9) {
                        i12 = i9;
                        break;
                    } else {
                        if (bN2 != list.get(i24).n(i13)) {
                            i12 = i24;
                            break;
                        }
                        i24++;
                    }
                }
                if (i23 == i12 && i13 + 1 == list.get(i10).a0()) {
                    mVar.writeInt(list2.get(i10).intValue());
                } else {
                    mVar.writeInt(((int) (jC2 + c(mVar3))) * i15);
                    a(jC2, mVar3, i13 + 1, list, i10, i12, list2);
                }
                mVar3 = mVar3;
                i10 = i12;
                i15 = -1;
            }
            mVar.C0(mVar3);
        }

        static /* synthetic */ void b(a aVar, long j7, m mVar, int i7, List list, int i8, int i9, List list2, int i10, Object obj) throws IOException {
            aVar.a((i10 & 1) != 0 ? 0L : j7, mVar, (i10 & 4) != 0 ? 0 : i7, list, (i10 & 16) != 0 ? 0 : i8, (i10 & 32) != 0 ? list.size() : i9, list2);
        }

        private final long c(m mVar) {
            return mVar.B1() / ((long) 4);
        }

        @a7.d
        @h5.l
        public final d0 d(@a7.d p... byteStrings) throws IOException {
            kotlin.jvm.internal.l0.p(byteStrings, "byteStrings");
            int i7 = 0;
            kotlin.jvm.internal.w wVar = null;
            if (byteStrings.length == 0) {
                return new d0(new p[0], new int[]{0, -1}, wVar);
            }
            List listUz = kotlin.collections.p.uz(byteStrings);
            kotlin.collections.c0.k0(listUz);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (p pVar : byteStrings) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List listQ = kotlin.collections.y.Q((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i8 = 0;
            int i9 = 0;
            while (i8 < length) {
                listQ.set(kotlin.collections.y.y(listUz, byteStrings[i8], 0, 0, 6, null), Integer.valueOf(i9));
                i8++;
                i9++;
            }
            if (!(((p) listUz.get(0)).a0() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i10 = 0;
            while (i10 < listUz.size()) {
                p pVar2 = (p) listUz.get(i10);
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 < listUz.size()) {
                    p pVar3 = (p) listUz.get(i12);
                    if (!pVar3.b0(pVar2)) {
                        break;
                    }
                    if (!(pVar3.a0() != pVar2.a0())) {
                        throw new IllegalArgumentException(("duplicate option: " + pVar3).toString());
                    }
                    if (((Number) listQ.get(i12)).intValue() > ((Number) listQ.get(i10)).intValue()) {
                        listUz.remove(i12);
                        listQ.remove(i12);
                    } else {
                        i12++;
                    }
                }
                i10 = i11;
            }
            m mVar = new m();
            b(this, 0L, mVar, 0, listUz, 0, 0, listQ, 53, null);
            int[] iArr = new int[(int) c(mVar)];
            while (!mVar.N()) {
                iArr[i7] = mVar.readInt();
                i7++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            kotlin.jvm.internal.l0.o(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new d0((p[]) objArrCopyOf, iArr, wVar);
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    public /* synthetic */ d0(p[] pVarArr, int[] iArr, kotlin.jvm.internal.w wVar) {
        this(pVarArr, iArr);
    }

    @a7.d
    @h5.l
    public static final d0 k(@a7.d p... pVarArr) {
        return f38425d.d(pVarArr);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int a() {
        return this.f38426b.length;
    }

    public /* bridge */ boolean b(p pVar) {
        return super.contains(pVar);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof p) {
            return b((p) obj);
        }
        return false;
    }

    @Override // kotlin.collections.c, java.util.List
    @a7.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public p get(int i7) {
        return this.f38426b[i7];
    }

    @a7.d
    public final p[] f() {
        return this.f38426b;
    }

    @a7.d
    public final int[] g() {
        return this.f38427c;
    }

    public /* bridge */ int h(p pVar) {
        return super.indexOf(pVar);
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof p) {
            return h((p) obj);
        }
        return -1;
    }

    public /* bridge */ int j(p pVar) {
        return super.lastIndexOf(pVar);
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof p) {
            return j((p) obj);
        }
        return -1;
    }

    private d0(p[] pVarArr, int[] iArr) {
        this.f38426b = pVarArr;
        this.f38427c = iArr;
    }
}
