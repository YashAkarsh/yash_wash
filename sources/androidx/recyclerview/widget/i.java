package androidx.recyclerview.widget;

import c.g1;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<g> f9525a = new a();

    static class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            int i7 = gVar.f9548a - gVar2.f9548a;
            return i7 == 0 ? gVar.f9549b - gVar2.f9549b : i7;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i7, int i8);

        public abstract boolean b(int i7, int i8);

        @o0
        public Object c(int i7, int i8) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    public static class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f9526h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f9527i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f9528j = 2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f9529k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f9530l = 8;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f9531m = 16;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f9532n = 5;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f9533o = 31;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<g> f9534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f9535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f9536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f9537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f9538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f9540g;

        c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z7) {
            this.f9534a = list;
            this.f9535b = iArr;
            this.f9536c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f9537d = bVar;
            this.f9538e = bVar.e();
            this.f9539f = bVar.d();
            this.f9540g = z7;
            a();
            j();
        }

        private void a() {
            g gVar = this.f9534a.isEmpty() ? null : this.f9534a.get(0);
            if (gVar != null && gVar.f9548a == 0 && gVar.f9549b == 0) {
                return;
            }
            g gVar2 = new g();
            gVar2.f9548a = 0;
            gVar2.f9549b = 0;
            gVar2.f9551d = false;
            gVar2.f9550c = 0;
            gVar2.f9552e = false;
            this.f9534a.add(0, gVar2);
        }

        private void d(List<e> list, t tVar, int i7, int i8, int i9) {
            if (!this.f9540g) {
                tVar.b(i7, i8);
                return;
            }
            for (int i10 = i8 - 1; i10 >= 0; i10--) {
                int i11 = i9 + i10;
                int i12 = this.f9536c[i11];
                int i13 = i12 & 31;
                if (i13 == 0) {
                    tVar.b(i7, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f9542b++;
                    }
                } else if (i13 == 4 || i13 == 8) {
                    int i14 = i12 >> 5;
                    tVar.a(m(list, i14, true).f9542b, i7);
                    if (i13 == 4) {
                        tVar.d(i7, 1, this.f9537d.c(i14, i11));
                    }
                } else {
                    if (i13 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i11 + " " + Long.toBinaryString(i13));
                    }
                    list.add(new e(i11, i7, false));
                }
            }
        }

        private void e(List<e> list, t tVar, int i7, int i8, int i9) {
            if (!this.f9540g) {
                tVar.c(i7, i8);
                return;
            }
            for (int i10 = i8 - 1; i10 >= 0; i10--) {
                int i11 = i9 + i10;
                int i12 = this.f9535b[i11];
                int i13 = i12 & 31;
                if (i13 == 0) {
                    tVar.c(i7 + i10, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f9542b--;
                    }
                } else if (i13 == 4 || i13 == 8) {
                    int i14 = i12 >> 5;
                    e eVarM = m(list, i14, false);
                    tVar.a(i7 + i10, eVarM.f9542b - 1);
                    if (i13 == 4) {
                        tVar.d(eVarM.f9542b - 1, 1, this.f9537d.c(i11, i14));
                    }
                } else {
                    if (i13 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i11 + " " + Long.toBinaryString(i13));
                    }
                    list.add(new e(i11, i7 + i10, true));
                }
            }
        }

        private void h(int i7, int i8, int i9) {
            if (this.f9535b[i7 - 1] != 0) {
                return;
            }
            i(i7, i8, i9, false);
        }

        private boolean i(int i7, int i8, int i9, boolean z7) {
            int i10;
            int i11;
            int i12;
            if (z7) {
                i8--;
                i11 = i7;
                i10 = i8;
            } else {
                i10 = i7 - 1;
                i11 = i10;
            }
            while (i9 >= 0) {
                g gVar = this.f9534a.get(i9);
                int i13 = gVar.f9548a;
                int i14 = gVar.f9550c;
                int i15 = i13 + i14;
                int i16 = gVar.f9549b + i14;
                if (z7) {
                    for (int i17 = i11 - 1; i17 >= i15; i17--) {
                        if (this.f9537d.b(i17, i10)) {
                            i12 = this.f9537d.a(i17, i10) ? 8 : 4;
                            this.f9536c[i10] = (i17 << 5) | 16;
                            this.f9535b[i17] = (i10 << 5) | i12;
                            return true;
                        }
                    }
                } else {
                    for (int i18 = i8 - 1; i18 >= i16; i18--) {
                        if (this.f9537d.b(i10, i18)) {
                            i12 = this.f9537d.a(i10, i18) ? 8 : 4;
                            int i19 = i7 - 1;
                            this.f9535b[i19] = (i18 << 5) | 16;
                            this.f9536c[i18] = (i19 << 5) | i12;
                            return true;
                        }
                    }
                }
                i11 = gVar.f9548a;
                i8 = gVar.f9549b;
                i9--;
            }
            return false;
        }

        private void j() {
            int i7 = this.f9538e;
            int i8 = this.f9539f;
            for (int size = this.f9534a.size() - 1; size >= 0; size--) {
                g gVar = this.f9534a.get(size);
                int i9 = gVar.f9548a;
                int i10 = gVar.f9550c;
                int i11 = i9 + i10;
                int i12 = gVar.f9549b + i10;
                if (this.f9540g) {
                    while (i7 > i11) {
                        h(i7, i8, size);
                        i7--;
                    }
                    while (i8 > i12) {
                        k(i7, i8, size);
                        i8--;
                    }
                }
                for (int i13 = 0; i13 < gVar.f9550c; i13++) {
                    int i14 = gVar.f9548a + i13;
                    int i15 = gVar.f9549b + i13;
                    int i16 = this.f9537d.a(i14, i15) ? 1 : 2;
                    this.f9535b[i14] = (i15 << 5) | i16;
                    this.f9536c[i15] = (i14 << 5) | i16;
                }
                i7 = gVar.f9548a;
                i8 = gVar.f9549b;
            }
        }

        private void k(int i7, int i8, int i9) {
            if (this.f9536c[i8 - 1] != 0) {
                return;
            }
            i(i7, i8, i9, true);
        }

        private static e m(List<e> list, int i7, boolean z7) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.f9541a == i7 && eVar.f9543c == z7) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f9542b += z7 ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public int b(@c.e0(from = 0) int i7) {
            if (i7 >= 0 && i7 < this.f9539f) {
                int i8 = this.f9536c[i7];
                if ((i8 & 31) == 0) {
                    return -1;
                }
                return i8 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i7 + ", new list size = " + this.f9539f);
        }

        public int c(@c.e0(from = 0) int i7) {
            if (i7 >= 0 && i7 < this.f9538e) {
                int i8 = this.f9535b[i7];
                if ((i8 & 31) == 0) {
                    return -1;
                }
                return i8 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i7 + ", old list size = " + this.f9538e);
        }

        public void f(@m0 t tVar) {
            androidx.recyclerview.widget.f fVar = tVar instanceof androidx.recyclerview.widget.f ? (androidx.recyclerview.widget.f) tVar : new androidx.recyclerview.widget.f(tVar);
            List<e> arrayList = new ArrayList<>();
            int i7 = this.f9538e;
            int i8 = this.f9539f;
            for (int size = this.f9534a.size() - 1; size >= 0; size--) {
                g gVar = this.f9534a.get(size);
                int i9 = gVar.f9550c;
                int i10 = gVar.f9548a + i9;
                int i11 = gVar.f9549b + i9;
                if (i10 < i7) {
                    e(arrayList, fVar, i10, i7 - i10, i10);
                }
                if (i11 < i8) {
                    d(arrayList, fVar, i10, i8 - i11, i11);
                }
                for (int i12 = i9 - 1; i12 >= 0; i12--) {
                    int[] iArr = this.f9535b;
                    int i13 = gVar.f9548a;
                    if ((iArr[i13 + i12] & 31) == 2) {
                        fVar.d(i13 + i12, 1, this.f9537d.c(i13 + i12, gVar.f9549b + i12));
                    }
                }
                i7 = gVar.f9548a;
                i8 = gVar.f9549b;
            }
            fVar.e();
        }

        public void g(@m0 RecyclerView.g gVar) {
            f(new androidx.recyclerview.widget.b(gVar));
        }

        @g1
        List<g> l() {
            return this.f9534a;
        }
    }

    public static abstract class d<T> {
        public abstract boolean a(@m0 T t7, @m0 T t8);

        public abstract boolean b(@m0 T t7, @m0 T t8);

        @o0
        public Object c(@m0 T t7, @m0 T t8) {
            return null;
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9543c;

        public e(int i7, int i8, boolean z7) {
            this.f9541a = i7;
            this.f9542b = i8;
            this.f9543c = z7;
        }
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9547d;

        public f() {
        }

        public f(int i7, int i8, int i9, int i10) {
            this.f9544a = i7;
            this.f9545b = i8;
            this.f9546c = i9;
            this.f9547d = i10;
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f9552e;

        g() {
        }
    }

    private i() {
    }

    @m0
    public static c a(@m0 b bVar) {
        return b(bVar, true);
    }

    @m0
    public static c b(@m0 b bVar, boolean z7) {
        int iE = bVar.e();
        int iD = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new f(0, iE, 0, iD));
        int iAbs = iE + iD + Math.abs(iE - iD);
        int i7 = iAbs * 2;
        int[] iArr = new int[i7];
        int[] iArr2 = new int[i7];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            f fVar = (f) arrayList2.remove(arrayList2.size() - 1);
            g gVarC = c(bVar, fVar.f9544a, fVar.f9545b, fVar.f9546c, fVar.f9547d, iArr, iArr2, iAbs);
            if (gVarC != null) {
                if (gVarC.f9550c > 0) {
                    arrayList.add(gVarC);
                }
                gVarC.f9548a += fVar.f9544a;
                gVarC.f9549b += fVar.f9546c;
                f fVar2 = arrayList3.isEmpty() ? new f() : (f) arrayList3.remove(arrayList3.size() - 1);
                fVar2.f9544a = fVar.f9544a;
                fVar2.f9546c = fVar.f9546c;
                if (gVarC.f9552e) {
                    fVar2.f9545b = gVarC.f9548a;
                    fVar2.f9547d = gVarC.f9549b;
                } else if (gVarC.f9551d) {
                    fVar2.f9545b = gVarC.f9548a - 1;
                    fVar2.f9547d = gVarC.f9549b;
                } else {
                    fVar2.f9545b = gVarC.f9548a;
                    fVar2.f9547d = gVarC.f9549b - 1;
                }
                arrayList2.add(fVar2);
                if (!gVarC.f9552e) {
                    int i8 = gVarC.f9548a;
                    int i9 = gVarC.f9550c;
                    fVar.f9544a = i8 + i9;
                    fVar.f9546c = gVarC.f9549b + i9;
                } else if (gVarC.f9551d) {
                    int i10 = gVarC.f9548a;
                    int i11 = gVarC.f9550c;
                    fVar.f9544a = i10 + i11 + 1;
                    fVar.f9546c = gVarC.f9549b + i11;
                } else {
                    int i12 = gVarC.f9548a;
                    int i13 = gVarC.f9550c;
                    fVar.f9544a = i12 + i13;
                    fVar.f9546c = gVarC.f9549b + i13 + 1;
                }
                arrayList2.add(fVar);
            } else {
                arrayList3.add(fVar);
            }
        }
        Collections.sort(arrayList, f9525a);
        return new c(bVar, arrayList, iArr, iArr2, z7);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00ca
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static androidx.recyclerview.widget.i.g c(androidx.recyclerview.widget.i.b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.c(androidx.recyclerview.widget.i$b, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.i$g");
    }
}
