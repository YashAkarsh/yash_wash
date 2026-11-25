package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
@j2
public abstract class a<T> extends w2 implements o2, kotlin.coroutines.d<T>, v0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f35499b;

    public a(@a7.d kotlin.coroutines.g gVar, boolean z7, boolean z8) {
        super(z8);
        if (z7) {
            R0((o2) gVar.get(o2.f37103s0));
        }
        this.f35499b = gVar.plus(this);
    }

    public static /* synthetic */ void B1() {
    }

    protected void A1(@a7.e Object obj) {
        Z(obj);
    }

    protected void C1(@a7.d Throwable th, boolean z7) {
    }

    @Override // kotlinx.coroutines.v0
    @a7.d
    public kotlin.coroutines.g D() {
        return this.f35499b;
    }

    protected void D1(T t7) {
    }

    public final <R> void E1(@a7.d x0 x0Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) {
        x0Var.c(pVar, r7, this);
    }

    @Override // kotlinx.coroutines.w2
    public final void P0(@a7.d Throwable th) {
        r0.b(this.f35499b, th);
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.coroutines.w2
    @a7.d
    public String c1() {
        String strB = n0.b(this.f35499b);
        if (strB == null) {
            return super.c1();
        }
        return kotlin.text.h0.f35376b + strB + "\":" + super.c1();
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public final kotlin.coroutines.g d() {
        return this.f35499b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.w2
    protected final void i1(@a7.e Object obj) {
        if (!(obj instanceof e0)) {
            D1(obj);
        } else {
            e0 e0Var = (e0) obj;
            C1(e0Var.f35988a, e0Var.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.w2
    @a7.d
    public String m0() {
        return kotlin.jvm.internal.l0.C(a1.a(this), " was cancelled");
    }

    @Override // kotlin.coroutines.d
    public final void w(@a7.d Object obj) {
        Object objA1 = a1(k0.d(obj, null, 1, null));
        if (objA1 == x2.f37365b) {
            return;
        }
        A1(objA1);
    }
}
