package androidx.test.internal.runner.junit4.statement;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runners.model.d;
import org.junit.runners.model.f;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class RunAfters extends UiThreadStatement {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f10140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<d> f10142f;

    public RunAfters(d method, j next, List<d> afters, Object target) {
        super(next, UiThreadStatement.g(method));
        this.f10140d = next;
        this.f10142f = afters;
        this.f10141e = target;
    }

    @Override // androidx.test.internal.runner.junit4.statement.UiThreadStatement, org.junit.runners.model.j
    public void a() throws Exception {
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            this.f10140d.a();
            for (final d dVar : this.f10142f) {
                if (UiThreadStatement.g(dVar)) {
                    UiThreadStatement.f(new Runnable() { // from class: androidx.test.internal.runner.junit4.statement.RunAfters.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                dVar.m(RunAfters.this.f10141e, new Object[0]);
                            } catch (Throwable th) {
                                copyOnWriteArrayList.add(th);
                            }
                        }
                    });
                } else {
                    try {
                        dVar.m(this.f10141e, new Object[0]);
                    } catch (Throwable th) {
                        copyOnWriteArrayList.add(th);
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                copyOnWriteArrayList.add(th2);
                for (final d dVar2 : this.f10142f) {
                    if (UiThreadStatement.g(dVar2)) {
                        UiThreadStatement.f(new Runnable() { // from class: androidx.test.internal.runner.junit4.statement.RunAfters.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    dVar2.m(RunAfters.this.f10141e, new Object[0]);
                                } catch (Throwable th3) {
                                    copyOnWriteArrayList.add(th3);
                                }
                            }
                        });
                    } else {
                        try {
                            dVar2.m(this.f10141e, new Object[0]);
                        } catch (Throwable th3) {
                            copyOnWriteArrayList.add(th3);
                        }
                    }
                }
            } catch (Throwable th4) {
                for (final d dVar3 : this.f10142f) {
                    if (UiThreadStatement.g(dVar3)) {
                        UiThreadStatement.f(new Runnable() { // from class: androidx.test.internal.runner.junit4.statement.RunAfters.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    dVar3.m(RunAfters.this.f10141e, new Object[0]);
                                } catch (Throwable th5) {
                                    copyOnWriteArrayList.add(th5);
                                }
                            }
                        });
                    } else {
                        try {
                            dVar3.m(this.f10141e, new Object[0]);
                        } catch (Throwable th5) {
                            copyOnWriteArrayList.add(th5);
                        }
                    }
                }
                throw th4;
            }
        }
        f.a(copyOnWriteArrayList);
    }
}
