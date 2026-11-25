package androidx.test.internal.runner.junit4.statement;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.d;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class RunBefores extends UiThreadStatement {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f10146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<d> f10148f;

    public RunBefores(d method, j next, List<d> befores, Object target) {
        super(next, UiThreadStatement.g(method));
        this.f10146d = next;
        this.f10148f = befores;
        this.f10147e = target;
    }

    @Override // androidx.test.internal.runner.junit4.statement.UiThreadStatement, org.junit.runners.model.j
    public void a() throws Throwable {
        final AtomicReference atomicReference = new AtomicReference();
        for (final d dVar : this.f10148f) {
            if (UiThreadStatement.g(dVar)) {
                UiThreadStatement.f(new Runnable() { // from class: androidx.test.internal.runner.junit4.statement.RunBefores.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            dVar.m(RunBefores.this.f10147e, new Object[0]);
                        } catch (Throwable th) {
                            atomicReference.set(th);
                        }
                    }
                });
                Throwable th = (Throwable) atomicReference.get();
                if (th != null) {
                    throw th;
                }
            } else {
                dVar.m(this.f10147e, new Object[0]);
            }
        }
        this.f10146d.a();
    }
}
