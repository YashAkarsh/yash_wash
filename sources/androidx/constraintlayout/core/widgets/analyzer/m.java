package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3481h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3482i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3483j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f3484k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    p f3487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f3488d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3491g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3485a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3486b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<p> f3489e = new ArrayList<>();

    public m(p pVar, int i7) {
        this.f3487c = null;
        this.f3488d = null;
        int i8 = f3484k;
        this.f3490f = i8;
        f3484k = i8 + 1;
        this.f3487c = pVar;
        this.f3488d = pVar;
        this.f3491g = i7;
    }

    private boolean c(p pVar, int i7) {
        f fVar;
        p pVar2;
        f fVar2;
        p pVar3;
        if (!pVar.f3512b.f3612g[i7]) {
            return false;
        }
        for (d dVar : pVar.f3518h.f3459k) {
            if ((dVar instanceof f) && (pVar3 = (fVar2 = (f) dVar).f3452d) != pVar && fVar2 == pVar3.f3518h) {
                if (pVar instanceof c) {
                    Iterator<p> it = ((c) pVar).f3437k.iterator();
                    while (it.hasNext()) {
                        c(it.next(), i7);
                    }
                } else if (!(pVar instanceof k)) {
                    pVar.f3512b.f3612g[i7] = false;
                }
                c(fVar2.f3452d, i7);
            }
        }
        for (d dVar2 : pVar.f3519i.f3459k) {
            if ((dVar2 instanceof f) && (pVar2 = (fVar = (f) dVar2).f3452d) != pVar && fVar == pVar2.f3518h) {
                if (pVar instanceof c) {
                    Iterator<p> it2 = ((c) pVar).f3437k.iterator();
                    while (it2.hasNext()) {
                        c(it2.next(), i7);
                    }
                } else if (!(pVar instanceof k)) {
                    pVar.f3512b.f3612g[i7] = false;
                }
                c(fVar.f3452d, i7);
            }
        }
        return false;
    }

    private long e(f fVar, long j7) {
        p pVar = fVar.f3452d;
        if (pVar instanceof k) {
            return j7;
        }
        int size = fVar.f3459k.size();
        long jMin = j7;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = fVar.f3459k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3452d != pVar) {
                    jMin = Math.min(jMin, e(fVar2, ((long) fVar2.f3454f) + j7));
                }
            }
        }
        if (fVar != pVar.f3519i) {
            return jMin;
        }
        long j8 = j7 - pVar.j();
        return Math.min(Math.min(jMin, e(pVar.f3518h, j8)), j8 - ((long) pVar.f3518h.f3454f));
    }

    private long f(f fVar, long j7) {
        p pVar = fVar.f3452d;
        if (pVar instanceof k) {
            return j7;
        }
        int size = fVar.f3459k.size();
        long jMax = j7;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = fVar.f3459k.get(i7);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3452d != pVar) {
                    jMax = Math.max(jMax, f(fVar2, ((long) fVar2.f3454f) + j7));
                }
            }
        }
        if (fVar != pVar.f3518h) {
            return jMax;
        }
        long j8 = j7 + pVar.j();
        return Math.max(Math.max(jMax, f(pVar.f3519i, j8)), j8 - ((long) pVar.f3519i.f3454f));
    }

    public void a(p pVar) {
        this.f3489e.add(pVar);
        this.f3488d = pVar;
    }

    public long b(androidx.constraintlayout.core.widgets.f fVar, int i7) {
        long j7;
        int i8;
        p pVar = this.f3487c;
        if (pVar instanceof c) {
            if (((c) pVar).f3516f != i7) {
                return 0L;
            }
        } else if (i7 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i7 == 0 ? fVar.f3608e : fVar.f3610f).f3518h;
        f fVar3 = (i7 == 0 ? fVar.f3608e : fVar.f3610f).f3519i;
        boolean zContains = pVar.f3518h.f3460l.contains(fVar2);
        boolean zContains2 = this.f3487c.f3519i.f3460l.contains(fVar3);
        long j8 = this.f3487c.j();
        if (zContains && zContains2) {
            long jF = f(this.f3487c.f3518h, 0L);
            long jE = e(this.f3487c.f3519i, 0L);
            long j9 = jF - j8;
            p pVar2 = this.f3487c;
            int i9 = pVar2.f3519i.f3454f;
            if (j9 >= (-i9)) {
                j9 += (long) i9;
            }
            int i10 = pVar2.f3518h.f3454f;
            long j10 = ((-jE) - j8) - ((long) i10);
            if (j10 >= i10) {
                j10 -= (long) i10;
            }
            float fU = pVar2.f3512b.u(i7);
            float f8 = fU > 0.0f ? (long) ((j10 / fU) + (j9 / (1.0f - fU))) : 0L;
            long j11 = ((long) ((f8 * fU) + 0.5f)) + j8 + ((long) ((f8 * (1.0f - fU)) + 0.5f));
            p pVar3 = this.f3487c;
            j7 = ((long) pVar3.f3518h.f3454f) + j11;
            i8 = pVar3.f3519i.f3454f;
        } else {
            if (zContains) {
                f fVar4 = this.f3487c.f3518h;
                return Math.max(f(fVar4, fVar4.f3454f), ((long) this.f3487c.f3518h.f3454f) + j8);
            }
            if (zContains2) {
                f fVar5 = this.f3487c.f3519i;
                return Math.max(-e(fVar5, fVar5.f3454f), ((long) (-this.f3487c.f3519i.f3454f)) + j8);
            }
            p pVar4 = this.f3487c;
            j7 = ((long) pVar4.f3518h.f3454f) + pVar4.j();
            i8 = this.f3487c.f3519i.f3454f;
        }
        return j7 - ((long) i8);
    }

    public void d(boolean z7, boolean z8) {
        if (z7) {
            p pVar = this.f3487c;
            if (pVar instanceof l) {
                c(pVar, 0);
            }
        }
        if (z8) {
            p pVar2 = this.f3487c;
            if (pVar2 instanceof n) {
                c(pVar2, 1);
            }
        }
    }
}
