package androidx.databinding;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class q extends i<w.a, w, b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f7295h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f7296i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f7297j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f7298k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f7299l = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final androidx.core.util.v.c<b> f7294g = new androidx.core.util.v.c<>(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final i.a<w.a, w, b> f7300m = new a();

    static class a extends i.a<w.a, w, b> {
        a() {
        }

        @Override // androidx.databinding.i.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(w.a aVar, w wVar, int i7, b bVar) {
            if (i7 == 1) {
                aVar.f(wVar, bVar.f7301a, bVar.f7302b);
                return;
            }
            if (i7 == 2) {
                aVar.g(wVar, bVar.f7301a, bVar.f7302b);
                return;
            }
            if (i7 == 3) {
                aVar.h(wVar, bVar.f7301a, bVar.f7303c, bVar.f7302b);
            } else if (i7 != 4) {
                aVar.a(wVar);
            } else {
                aVar.i(wVar, bVar.f7301a, bVar.f7302b);
            }
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7303c;

        b() {
        }
    }

    public q() {
        super(f7300m);
    }

    private static b u(int i7, int i8, int i9) {
        b bVarB = f7294g.b();
        if (bVarB == null) {
            bVarB = new b();
        }
        bVarB.f7301a = i7;
        bVarB.f7303c = i8;
        bVarB.f7302b = i9;
        return bVarB;
    }

    public void A(@m0 w wVar, int i7, int i8) {
        m(wVar, 4, u(i7, 0, i8));
    }

    @Override // androidx.databinding.i
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public synchronized void m(@m0 w wVar, int i7, b bVar) {
        super.m(wVar, i7, bVar);
        if (bVar != null) {
            f7294g.a(bVar);
        }
    }

    public void w(@m0 w wVar) {
        m(wVar, 0, null);
    }

    public void x(@m0 w wVar, int i7, int i8) {
        m(wVar, 1, u(i7, 0, i8));
    }

    public void y(@m0 w wVar, int i7, int i8) {
        m(wVar, 2, u(i7, 0, i8));
    }

    public void z(@m0 w wVar, int i7, int i8, int i9) {
        m(wVar, 3, u(i7, i8, i9));
    }
}
