package org.chromium.base.task;

import android.view.Choreographer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.chromium.base.ThreadUtils;

/* JADX INFO: loaded from: classes3.dex */
class i implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<u, r> f38926a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f38927b;

    i() {
    }

    private synchronized e g() {
        e eVar;
        eVar = (e) ThreadUtils.n(new Callable() { // from class: org.chromium.base.task.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return i.h();
            }
        });
        this.f38926a.put(u.f38957q, eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e h() throws Exception {
        return new e(Choreographer.getInstance());
    }

    @Override // org.chromium.base.task.p
    public boolean a(u uVar) {
        return false;
    }

    @Override // org.chromium.base.task.p
    public n b(u uVar) {
        return uVar.f38969g ? g() : new o(null, uVar);
    }

    @Override // org.chromium.base.task.p
    public j c(u uVar) {
        return uVar.f38969g ? g() : new l(uVar);
    }

    @Override // org.chromium.base.task.p
    public synchronized void d(u uVar, Runnable runnable, long j7) {
        if (uVar.b()) {
            r rVarE = e(uVar);
            rVarE.b(runnable, j7);
            rVarE.a();
        } else {
            r taskRunnerImpl = this.f38926a.get(uVar);
            if (taskRunnerImpl == null) {
                taskRunnerImpl = new TaskRunnerImpl(uVar);
                taskRunnerImpl.f();
                this.f38926a.put(uVar, taskRunnerImpl);
            }
            taskRunnerImpl.b(runnable, j7);
        }
    }

    @Override // org.chromium.base.task.p
    public r e(u uVar) {
        return uVar.f38969g ? g() : new TaskRunnerImpl(uVar);
    }
}
