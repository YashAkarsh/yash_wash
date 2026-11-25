package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class z3 extends CancellationException implements m0<z3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    @a7.e
    public final o2 f37397a;

    public z3(@a7.d String str, @a7.e o2 o2Var) {
        super(str);
        this.f37397a = o2Var;
    }

    @Override // kotlinx.coroutines.m0
    @a7.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public z3 a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        z3 z3Var = new z3(message, this.f37397a);
        z3Var.initCause(this);
        return z3Var;
    }

    public z3(@a7.d String str) {
        this(str, null);
    }
}
