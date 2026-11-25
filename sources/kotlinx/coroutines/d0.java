package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Object f35889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    @a7.e
    public final o f35890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    @a7.e
    public final i5.l<Throwable, kotlin.l2> f35891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Object f35892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Throwable f35893e;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@a7.e Object obj, @a7.e o oVar, @a7.e i5.l<? super Throwable, kotlin.l2> lVar, @a7.e Object obj2, @a7.e Throwable th) {
        this.f35889a = obj;
        this.f35890b = oVar;
        this.f35891c = lVar;
        this.f35892d = obj2;
        this.f35893e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d0 g(d0 d0Var, Object obj, o oVar, i5.l lVar, Object obj2, Throwable th, int i7, Object obj3) {
        if ((i7 & 1) != 0) {
            obj = d0Var.f35889a;
        }
        if ((i7 & 2) != 0) {
            oVar = d0Var.f35890b;
        }
        o oVar2 = oVar;
        if ((i7 & 4) != 0) {
            lVar = d0Var.f35891c;
        }
        i5.l lVar2 = lVar;
        if ((i7 & 8) != 0) {
            obj2 = d0Var.f35892d;
        }
        Object obj4 = obj2;
        if ((i7 & 16) != 0) {
            th = d0Var.f35893e;
        }
        return d0Var.f(obj, oVar2, lVar2, obj4, th);
    }

    @a7.e
    public final Object a() {
        return this.f35889a;
    }

    @a7.e
    public final o b() {
        return this.f35890b;
    }

    @a7.e
    public final i5.l<Throwable, kotlin.l2> c() {
        return this.f35891c;
    }

    @a7.e
    public final Object d() {
        return this.f35892d;
    }

    @a7.e
    public final Throwable e() {
        return this.f35893e;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return kotlin.jvm.internal.l0.g(this.f35889a, d0Var.f35889a) && kotlin.jvm.internal.l0.g(this.f35890b, d0Var.f35890b) && kotlin.jvm.internal.l0.g(this.f35891c, d0Var.f35891c) && kotlin.jvm.internal.l0.g(this.f35892d, d0Var.f35892d) && kotlin.jvm.internal.l0.g(this.f35893e, d0Var.f35893e);
    }

    @a7.d
    public final d0 f(@a7.e Object obj, @a7.e o oVar, @a7.e i5.l<? super Throwable, kotlin.l2> lVar, @a7.e Object obj2, @a7.e Throwable th) {
        return new d0(obj, oVar, lVar, obj2, th);
    }

    public final boolean h() {
        return this.f35893e != null;
    }

    public int hashCode() {
        Object obj = this.f35889a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        o oVar = this.f35890b;
        int iHashCode2 = (iHashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
        i5.l<Throwable, kotlin.l2> lVar = this.f35891c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f35892d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f35893e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void i(@a7.d r<?> rVar, @a7.d Throwable th) {
        o oVar = this.f35890b;
        if (oVar != null) {
            rVar.n(oVar, th);
        }
        i5.l<Throwable, kotlin.l2> lVar = this.f35891c;
        if (lVar == null) {
            return;
        }
        rVar.p(lVar, th);
    }

    @a7.d
    public String toString() {
        return "CompletedContinuation(result=" + this.f35889a + ", cancelHandler=" + this.f35890b + ", onCancellation=" + this.f35891c + ", idempotentResume=" + this.f35892d + ", cancelCause=" + this.f35893e + ')';
    }

    public /* synthetic */ d0(Object obj, o oVar, i5.l lVar, Object obj2, Throwable th, int i7, kotlin.jvm.internal.w wVar) {
        this(obj, (i7 & 2) != 0 ? null : oVar, (i7 & 4) != 0 ? null : lVar, (i7 & 8) != 0 ? null : obj2, (i7 & 16) != 0 ? null : th);
    }
}
