package org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import c.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.TraceEvent;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base")
public class TaskRunnerImpl implements r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f38884k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f38885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object f38888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("mLock")
    protected long f38889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Runnable f38890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f38891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final org.chromium.base.s f38892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    protected LinkedList<Runnable> f38893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    protected List<Pair<Runnable, Long>> f38894j;

    TaskRunnerImpl(u uVar) {
        this(uVar, "TaskRunnerImpl", 0);
    }

    private native void nativeDestroy(long j7);

    private native long nativeInit(int i7, boolean z7, int i8, boolean z8, boolean z9, byte b8, byte[] bArr);

    private native void nativePostDelayedTask(long j7, Runnable runnable, long j8);

    @Override // org.chromium.base.task.r
    public void a() {
        synchronized (this.f38888d) {
            org.chromium.base.s.d(this.f38892h, true);
            this.f38891g = true;
            g();
        }
    }

    @Override // org.chromium.base.task.r
    public void b(Runnable runnable, long j7) {
        synchronized (this.f38888d) {
            LinkedList<Runnable> linkedList = this.f38893i;
            if (linkedList == null) {
                j(runnable, j7);
                return;
            }
            if (j7 == 0) {
                linkedList.add(runnable);
                l();
            } else {
                this.f38894j.add(new Pair<>(runnable, Long.valueOf(j7)));
            }
        }
    }

    @Override // org.chromium.base.task.r
    public void c(Runnable runnable) {
        b(runnable, 0L);
    }

    @Override // org.chromium.base.task.r
    public void d() {
        synchronized (this.f38888d) {
            h();
            i();
        }
    }

    @Override // org.chromium.base.task.r
    public void f() {
        org.chromium.base.s.d(this.f38892h, true);
    }

    @GuardedBy("mLock")
    protected void g() {
        long j7 = this.f38889e;
        if (j7 != 0) {
            nativeDestroy(j7);
        }
        this.f38889e = 0L;
    }

    @GuardedBy("mLock")
    protected void h() {
        if (this.f38889e == 0) {
            int i7 = this.f38887c;
            u uVar = this.f38885a;
            this.f38889e = nativeInit(i7, uVar.f38963a, uVar.f38964b, uVar.f38965c, uVar.f38966d, uVar.f38967e, uVar.f38968f);
        }
    }

    @GuardedBy("mLock")
    protected void i() {
        LinkedList<Runnable> linkedList = this.f38893i;
        if (linkedList != null) {
            Iterator<Runnable> it = linkedList.iterator();
            while (it.hasNext()) {
                j(it.next(), 0L);
            }
            for (Pair<Runnable, Long> pair : this.f38894j) {
                j((Runnable) pair.first, ((Long) pair.second).longValue());
            }
            this.f38893i = null;
            this.f38894j = null;
        }
    }

    @GuardedBy("mLock")
    protected void j(Runnable runnable, long j7) {
        nativePostDelayedTask(this.f38889e, runnable, j7);
    }

    protected void k() {
        TraceEvent traceEventG = TraceEvent.G(this.f38886b);
        try {
            synchronized (this.f38888d) {
                LinkedList<Runnable> linkedList = this.f38893i;
                if (linkedList == null) {
                    if (traceEventG != null) {
                        traceEventG.close();
                        return;
                    }
                    return;
                }
                Runnable runnablePoll = linkedList.poll();
                int i7 = this.f38885a.f38964b;
                if (i7 == 1) {
                    Process.setThreadPriority(0);
                } else if (i7 != 2) {
                    Process.setThreadPriority(10);
                } else {
                    Process.setThreadPriority(-1);
                }
                runnablePoll.run();
                if (traceEventG != null) {
                    traceEventG.close();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (traceEventG != null) {
                    try {
                        traceEventG.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected void l() {
        PostTask.e().execute(this.f38890f);
    }

    protected native boolean nativeBelongsToCurrentThread(long j7);

    protected TaskRunnerImpl(u uVar, String str, int i7) {
        this.f38888d = new Object();
        this.f38890f = new Runnable() { // from class: org.chromium.base.task.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f38944a.k();
            }
        };
        this.f38892h = org.chromium.base.s.b(this);
        this.f38893i = new LinkedList<>();
        this.f38894j = new ArrayList();
        this.f38885a = uVar;
        this.f38886b = str + ".PreNativeTask.run";
        this.f38887c = i7;
        if (PostTask.i(this)) {
            return;
        }
        d();
    }
}
