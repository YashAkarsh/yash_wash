package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.c;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public class DelayInjector extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10173a;

    public DelayInjector(int delayMsec) {
        this.f10173a = delayMsec;
    }

    private void h() {
        try {
            Thread.sleep(this.f10173a);
        } catch (InterruptedException e8) {
            Log.e("DelayInjector", "interrupted", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void c(c description) throws Exception {
        h();
    }

    @Override // org.junit.runner.notification.b
    public void f(c description) throws Exception {
        h();
    }
}
