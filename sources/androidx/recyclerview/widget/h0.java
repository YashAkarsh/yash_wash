package androidx.recyclerview.widget;

import c.g1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f9511c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g1
    final androidx.collection.i<RecyclerView.d0, a> f9512a = new androidx.collection.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g1
    final androidx.collection.f<RecyclerView.d0> f9513b = new androidx.collection.f<>();

    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f9514d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f9515e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f9516f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f9517g = 8;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f9518h = 3;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f9519i = 12;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f9520j = 14;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static androidx.core.util.v.a<a> f9521k = new androidx.core.util.v.b(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        RecyclerView.l.d f9523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        RecyclerView.l.d f9524c;

        private a() {
        }

        static void a() {
            while (f9521k.b() != null) {
            }
        }

        static a b() {
            a aVarB = f9521k.b();
            return aVarB == null ? new a() : aVarB;
        }

        static void c(a aVar) {
            aVar.f9522a = 0;
            aVar.f9523b = null;
            aVar.f9524c = null;
            f9521k.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, @o0 RecyclerView.l.d dVar, RecyclerView.l.d dVar2);

        void c(RecyclerView.d0 d0Var, @m0 RecyclerView.l.d dVar, @o0 RecyclerView.l.d dVar2);

        void d(RecyclerView.d0 d0Var, @m0 RecyclerView.l.d dVar, @m0 RecyclerView.l.d dVar2);
    }

    h0() {
    }

    private RecyclerView.l.d l(RecyclerView.d0 d0Var, int i7) {
        a aVarO;
        RecyclerView.l.d dVar;
        int iF = this.f9512a.f(d0Var);
        if (iF >= 0 && (aVarO = this.f9512a.o(iF)) != null) {
            int i8 = aVarO.f9522a;
            if ((i8 & i7) != 0) {
                int i9 = (~i7) & i8;
                aVarO.f9522a = i9;
                if (i7 == 4) {
                    dVar = aVarO.f9523b;
                } else {
                    if (i7 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    dVar = aVarO.f9524c;
                }
                if ((i9 & 12) == 0) {
                    this.f9512a.m(iF);
                    a.c(aVarO);
                }
                return dVar;
            }
        }
        return null;
    }

    void a(RecyclerView.d0 d0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f9512a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f9512a.put(d0Var, aVarB);
        }
        aVarB.f9522a |= 2;
        aVarB.f9523b = dVar;
    }

    void b(RecyclerView.d0 d0Var) {
        a aVarB = this.f9512a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f9512a.put(d0Var, aVarB);
        }
        aVarB.f9522a |= 1;
    }

    void c(long j7, RecyclerView.d0 d0Var) {
        this.f9513b.s(j7, d0Var);
    }

    void d(RecyclerView.d0 d0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f9512a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f9512a.put(d0Var, aVarB);
        }
        aVarB.f9524c = dVar;
        aVarB.f9522a |= 8;
    }

    void e(RecyclerView.d0 d0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f9512a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f9512a.put(d0Var, aVarB);
        }
        aVarB.f9523b = dVar;
        aVarB.f9522a |= 4;
    }

    void f() {
        this.f9512a.clear();
        this.f9513b.e();
    }

    RecyclerView.d0 g(long j7) {
        return this.f9513b.m(j7);
    }

    boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f9512a.get(d0Var);
        return (aVar == null || (aVar.f9522a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f9512a.get(d0Var);
        return (aVar == null || (aVar.f9522a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    @o0
    RecyclerView.l.d m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    @o0
    RecyclerView.l.d n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    void o(b bVar) {
        for (int size = this.f9512a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0VarK = this.f9512a.k(size);
            a aVarM = this.f9512a.m(size);
            int i7 = aVarM.f9522a;
            if ((i7 & 3) == 3) {
                bVar.a(d0VarK);
            } else if ((i7 & 1) != 0) {
                RecyclerView.l.d dVar = aVarM.f9523b;
                if (dVar == null) {
                    bVar.a(d0VarK);
                } else {
                    bVar.c(d0VarK, dVar, aVarM.f9524c);
                }
            } else if ((i7 & 14) == 14) {
                bVar.b(d0VarK, aVarM.f9523b, aVarM.f9524c);
            } else if ((i7 & 12) == 12) {
                bVar.d(d0VarK, aVarM.f9523b, aVarM.f9524c);
            } else if ((i7 & 4) != 0) {
                bVar.c(d0VarK, aVarM.f9523b, null);
            } else if ((i7 & 8) != 0) {
                bVar.b(d0VarK, aVarM.f9523b, aVarM.f9524c);
            }
            a.c(aVarM);
        }
    }

    void p(RecyclerView.d0 d0Var) {
        a aVar = this.f9512a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f9522a &= -2;
    }

    void q(RecyclerView.d0 d0Var) {
        for (int iB = this.f9513b.B() - 1; iB >= 0; iB--) {
            if (d0Var == this.f9513b.C(iB)) {
                this.f9513b.x(iB);
                break;
            }
        }
        a aVarRemove = this.f9512a.remove(d0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
