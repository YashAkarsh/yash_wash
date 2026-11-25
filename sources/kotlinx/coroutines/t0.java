package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
@z6.a
public final class t0 extends kotlin.coroutines.a implements t3<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f37299b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f37300a;

    public static final class a implements kotlin.coroutines.g.c<t0> {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
        }
    }

    public t0(long j7) {
        super(f37299b);
        this.f37300a = j7;
    }

    public static /* synthetic */ t0 Y0(t0 t0Var, long j7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            j7 = t0Var.f37300a;
        }
        return t0Var.V0(j7);
    }

    public final long T0() {
        return this.f37300a;
    }

    @a7.d
    public final t0 V0(long j7) {
        return new t0(j7);
    }

    public final long a1() {
        return this.f37300a;
    }

    @Override // kotlinx.coroutines.t3
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void v0(@a7.d kotlin.coroutines.g gVar, @a7.d String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.t3
    @a7.d
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public String L0(@a7.d kotlin.coroutines.g gVar) {
        String strA1;
        u0 u0Var = (u0) gVar.get(u0.f37321b);
        String str = "coroutine";
        if (u0Var != null && (strA1 = u0Var.a1()) != null) {
            str = strA1;
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iF3 = kotlin.text.c0.F3(name, " @", 0, false, 6, null);
        if (iF3 < 0) {
            iF3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + iF3 + 10);
        String strSubstring = name.substring(0, iF3);
        kotlin.jvm.internal.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(a1());
        String string = sb.toString();
        kotlin.jvm.internal.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t0) && this.f37300a == ((t0) obj).f37300a;
    }

    public int hashCode() {
        return s0.a(this.f37300a);
    }

    @a7.d
    public String toString() {
        return "CoroutineId(" + this.f37300a + ')';
    }
}
