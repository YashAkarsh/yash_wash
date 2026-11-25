package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final String f37088a = " @";

    static final class a extends kotlin.jvm.internal.n0 implements i5.p<kotlin.coroutines.g, kotlin.coroutines.g.b, kotlin.coroutines.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f37089a = new a();

        a() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.coroutines.g a0(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.g.b bVar) {
            return bVar instanceof l0 ? gVar.plus(((l0) bVar).r0()) : gVar.plus(bVar);
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.p<kotlin.coroutines.g, kotlin.coroutines.g.b, kotlin.coroutines.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.k1.h<kotlin.coroutines.g> f37090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37091b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.k1.h<kotlin.coroutines.g> hVar, boolean z7) {
            super(2);
            this.f37090a = hVar;
            this.f37091b = z7;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.g] */
        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.coroutines.g a0(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.g.b bVar) {
            if (!(bVar instanceof l0)) {
                return gVar.plus(bVar);
            }
            kotlin.coroutines.g.b bVar2 = this.f37090a.f34872a.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.k1.h<kotlin.coroutines.g> hVar = this.f37090a;
                hVar.f34872a = hVar.f34872a.minusKey(bVar.getKey());
                return gVar.plus(((l0) bVar).v(bVar2));
            }
            l0 l0VarR0 = (l0) bVar;
            if (this.f37091b) {
                l0VarR0 = l0VarR0.r0();
            }
            return gVar.plus(l0VarR0);
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.p<Boolean, kotlin.coroutines.g.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f37092a = new c();

        c() {
            super(2);
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ Boolean a0(Boolean bool, kotlin.coroutines.g.b bVar) {
            return b(bool.booleanValue(), bVar);
        }

        @a7.d
        public final Boolean b(boolean z7, @a7.d kotlin.coroutines.g.b bVar) {
            return Boolean.valueOf(z7 || (bVar instanceof l0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final kotlin.coroutines.g a(kotlin.coroutines.g gVar, kotlin.coroutines.g gVar2, boolean z7) {
        boolean zC = c(gVar);
        boolean zC2 = c(gVar2);
        if (!zC && !zC2) {
            return gVar.plus(gVar2);
        }
        kotlin.jvm.internal.k1.h hVar = new kotlin.jvm.internal.k1.h();
        hVar.f34872a = gVar2;
        kotlin.coroutines.i iVar = kotlin.coroutines.i.f34682a;
        kotlin.coroutines.g gVar3 = (kotlin.coroutines.g) gVar.fold(iVar, new b(hVar, z7));
        if (zC2) {
            hVar.f34872a = ((kotlin.coroutines.g) hVar.f34872a).fold(iVar, a.f37089a);
        }
        return gVar3.plus((kotlin.coroutines.g) hVar.f34872a);
    }

    @a7.e
    public static final String b(@a7.d kotlin.coroutines.g gVar) {
        return null;
    }

    private static final boolean c(kotlin.coroutines.g gVar) {
        return ((Boolean) gVar.fold(Boolean.FALSE, c.f37092a)).booleanValue();
    }

    @a7.d
    @j2
    public static final kotlin.coroutines.g d(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.g gVar2) {
        return !c(gVar2) ? gVar.plus(gVar2) : a(gVar, gVar2, false);
    }

    @a7.d
    @d2
    public static final kotlin.coroutines.g e(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar) {
        kotlin.coroutines.g gVarA = a(v0Var.D(), gVar, true);
        return (gVarA == n1.a() || gVarA.get(kotlin.coroutines.e.f34677q0) != null) ? gVarA : gVarA.plus(n1.a());
    }

    @a7.e
    public static final d4<?> f(@a7.d kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof j1) && (eVar = eVar.i()) != null) {
            if (eVar instanceof d4) {
                return (d4) eVar;
            }
        }
        return null;
    }

    @a7.e
    public static final d4<?> g(@a7.d kotlin.coroutines.d<?> dVar, @a7.d kotlin.coroutines.g gVar, @a7.e Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.get(e4.f35989a) != null)) {
            return null;
        }
        d4<?> d4VarF = f((kotlin.coroutines.jvm.internal.e) dVar);
        if (d4VarF != null) {
            d4VarF.H1(gVar, obj);
        }
        return d4VarF;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022 A[DONT_GENERATE] */
    public static final <T> T h(@a7.d kotlin.coroutines.d<?> dVar, @a7.e Object obj, @a7.d i5.a<? extends T> aVar) {
        kotlin.coroutines.g gVarD = dVar.d();
        Object objC = kotlinx.coroutines.internal.w0.c(gVarD, obj);
        d4<?> d4VarG = objC != kotlinx.coroutines.internal.w0.f37028a ? g(dVar, gVarD, objC) : null;
        try {
            return aVar.invoke();
        } finally {
            kotlin.jvm.internal.i0.d(1);
            if (d4VarG == null || d4VarG.G1()) {
                kotlinx.coroutines.internal.w0.a(gVarD, objC);
            }
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final <T> T i(@a7.d kotlin.coroutines.g gVar, @a7.e Object obj, @a7.d i5.a<? extends T> aVar) {
        Object objC = kotlinx.coroutines.internal.w0.c(gVar, obj);
        try {
            return aVar.invoke();
        } finally {
            kotlin.jvm.internal.i0.d(1);
            kotlinx.coroutines.internal.w0.a(gVar, objC);
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
