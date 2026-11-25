package org.chromium.base.task;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import c.o0;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base")
public class o extends TaskRunnerImpl implements n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final /* synthetic */ boolean f38936n = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private final Handler f38937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f38938m;

    public o(Handler handler, u uVar, boolean z7) {
        super(uVar, "SingleThreadTaskRunnerImpl", 2);
        this.f38937l = handler;
        this.f38938m = z7;
    }

    @SuppressLint({"NewApi"})
    private void m() {
        Message messageObtain = Message.obtain(this.f38937l, this.f38890f);
        messageObtain.setAsynchronous(true);
        this.f38937l.sendMessageAtFrontOfQueue(messageObtain);
    }

    @Override // org.chromium.base.task.n
    public boolean e() {
        synchronized (this.f38888d) {
            long j7 = this.f38889e;
            if (j7 != 0) {
                return nativeBelongsToCurrentThread(j7);
            }
            Handler handler = this.f38937l;
            return handler != null && handler.getLooper().getThread() == Thread.currentThread();
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    protected void l() {
        Handler handler = this.f38937l;
        if (handler == null) {
            return;
        }
        if (this.f38938m) {
            m();
        } else {
            handler.post(this.f38890f);
        }
    }

    public o(Handler handler, u uVar) {
        this(handler, uVar, false);
    }
}
