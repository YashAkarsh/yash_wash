package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k {
    public static final <T> T a(@a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) throws InterruptedException {
        u1 u1VarA;
        kotlin.coroutines.g gVarE;
        Thread threadCurrentThread = Thread.currentThread();
        kotlin.coroutines.e eVar = (kotlin.coroutines.e) gVar.get(kotlin.coroutines.e.f34677q0);
        if (eVar == null) {
            u1VarA = v3.f37337a.b();
            gVarE = n0.e(f2.f36000a, gVar.plus(u1VarA));
        } else {
            u1 u1Var = null;
            u1 u1Var2 = eVar instanceof u1 ? (u1) eVar : null;
            if (u1Var2 != null && u1Var2.Y1()) {
                u1Var = u1Var2;
            }
            u1VarA = u1Var == null ? v3.f37337a.a() : u1Var;
            gVarE = n0.e(f2.f36000a, gVar);
        }
        h hVar = new h(gVarE, threadCurrentThread, u1VarA);
        hVar.E1(x0.DEFAULT, hVar, pVar);
        return (T) hVar.F1();
    }

    public static /* synthetic */ Object b(kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) throws InterruptedException {
        if ((i7 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        return j.f(gVar, pVar);
    }
}
