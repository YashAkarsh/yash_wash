package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 extends CancellationException implements m0<p2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final o2 f37110a;

    public p2(@a7.d String str, @a7.e Throwable th, @a7.d o2 o2Var) {
        super(str);
        this.f37110a = o2Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.m0
    @a7.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public p2 a() {
        return null;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj != this) {
            if (obj instanceof p2) {
                p2 p2Var = (p2) obj;
                if (!kotlin.jvm.internal.l0.g(p2Var.getMessage(), getMessage()) || !kotlin.jvm.internal.l0.g(p2Var.f37110a, this.f37110a) || !kotlin.jvm.internal.l0.g(p2Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @a7.d
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.l0.m(message);
        int iHashCode = ((message.hashCode() * 31) + this.f37110a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    @a7.d
    public String toString() {
        return super.toString() + "; job=" + this.f37110a;
    }
}
