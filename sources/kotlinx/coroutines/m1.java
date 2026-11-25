package kotlinx.coroutines;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class m1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final o0 f37084a;

    public m1(@a7.d o0 o0Var) {
        this.f37084a = o0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@a7.d Runnable runnable) {
        this.f37084a.T0(kotlin.coroutines.i.f34682a, runnable);
    }

    @a7.d
    public String toString() {
        return this.f37084a.toString();
    }
}
