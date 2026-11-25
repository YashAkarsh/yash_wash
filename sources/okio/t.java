package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class t extends q0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private q0 f38536f;

    public t(@a7.d q0 delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.f38536f = delegate;
    }

    @Override // okio.q0
    @a7.d
    public q0 a() {
        return this.f38536f.a();
    }

    @Override // okio.q0
    @a7.d
    public q0 b() {
        return this.f38536f.b();
    }

    @Override // okio.q0
    public long d() {
        return this.f38536f.d();
    }

    @Override // okio.q0
    @a7.d
    public q0 e(long j7) {
        return this.f38536f.e(j7);
    }

    @Override // okio.q0
    public boolean f() {
        return this.f38536f.f();
    }

    @Override // okio.q0
    public void h() throws IOException {
        this.f38536f.h();
    }

    @Override // okio.q0
    @a7.d
    public q0 i(long j7, @a7.d TimeUnit unit) {
        kotlin.jvm.internal.l0.p(unit, "unit");
        return this.f38536f.i(j7, unit);
    }

    @Override // okio.q0
    public long j() {
        return this.f38536f.j();
    }

    @a7.d
    @h5.h(name = "delegate")
    public final q0 l() {
        return this.f38536f;
    }

    @a7.d
    public final t m(@a7.d q0 delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.f38536f = delegate;
        return this;
    }

    public final /* synthetic */ void n(@a7.d q0 q0Var) {
        kotlin.jvm.internal.l0.p(q0Var, "<set-?>");
        this.f38536f = q0Var;
    }
}
