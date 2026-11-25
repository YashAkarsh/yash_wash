package okio;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f38431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j0 f38432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f38435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o f38436f;

    public f0(@a7.d o upstream) {
        kotlin.jvm.internal.l0.p(upstream, "upstream");
        this.f38436f = upstream;
        m mVarP = upstream.p();
        this.f38431a = mVarP;
        j0 j0Var = mVarP.f38494a;
        this.f38432b = j0Var;
        this.f38433c = j0Var != null ? j0Var.f38469b : -1;
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38434d = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    @Override // okio.o0
    public long read(@a7.d m sink, long j7) {
        j0 j0Var;
        kotlin.jvm.internal.l0.p(sink, "sink");
        boolean z7 = false;
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!this.f38434d)) {
            throw new IllegalStateException("closed".toString());
        }
        j0 j0Var2 = this.f38432b;
        if (j0Var2 == null) {
            z7 = true;
        } else {
            j0 j0Var3 = this.f38431a.f38494a;
            if (j0Var2 == j0Var3) {
                int i7 = this.f38433c;
                kotlin.jvm.internal.l0.m(j0Var3);
                if (i7 == j0Var3.f38469b) {
                    z7 = true;
                }
            }
        }
        if (!z7) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
        }
        if (j7 == 0) {
            return 0L;
        }
        if (!this.f38436f.K0(this.f38435e + 1)) {
            return -1L;
        }
        if (this.f38432b == null && (j0Var = this.f38431a.f38494a) != null) {
            this.f38432b = j0Var;
            kotlin.jvm.internal.l0.m(j0Var);
            this.f38433c = j0Var.f38469b;
        }
        long jMin = Math.min(j7, this.f38431a.B1() - this.f38435e);
        this.f38431a.Q(sink, this.f38435e, jMin);
        this.f38435e += jMin;
        return jMin;
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return this.f38436f.timeout();
    }
}
