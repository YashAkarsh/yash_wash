package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends kotlin.coroutines.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f37321b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final String f37322a;

    public static final class a implements kotlin.coroutines.g.c<u0> {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
        }
    }

    public u0(@a7.d String str) {
        super(f37321b);
        this.f37322a = str;
    }

    public static /* synthetic */ u0 Y0(u0 u0Var, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = u0Var.f37322a;
        }
        return u0Var.V0(str);
    }

    @a7.d
    public final String T0() {
        return this.f37322a;
    }

    @a7.d
    public final u0 V0(@a7.d String str) {
        return new u0(str);
    }

    @a7.d
    public final String a1() {
        return this.f37322a;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u0) && kotlin.jvm.internal.l0.g(this.f37322a, ((u0) obj).f37322a);
    }

    public int hashCode() {
        return this.f37322a.hashCode();
    }

    @a7.d
    public String toString() {
        return "CoroutineName(" + this.f37322a + ')';
    }
}
