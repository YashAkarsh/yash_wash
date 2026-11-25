package androidx.test.internal.runner;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.l;
import org.junit.runner.manipulation.b;
import org.junit.runner.manipulation.d;
import org.junit.runner.manipulation.e;
import org.junit.runner.notification.c;

/* JADX INFO: loaded from: classes.dex */
class NonExecutingRunner extends l implements d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f9977a;

    NonExecutingRunner(l runner) {
        this.f9977a = runner;
    }

    private void f(c runNotifier, org.junit.runner.c description) {
        ArrayList<org.junit.runner.c> arrayListM = description.m();
        if (arrayListM.isEmpty()) {
            runNotifier.l(description);
            runNotifier.h(description);
        } else {
            Iterator<org.junit.runner.c> it = arrayListM.iterator();
            while (it.hasNext()) {
                f(runNotifier, it.next());
            }
        }
    }

    @Override // org.junit.runner.l
    public void a(c notifier) {
        f(notifier, b());
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        return this.f9977a.b();
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a filter) throws org.junit.runner.manipulation.c {
        filter.a(this.f9977a);
    }

    @Override // org.junit.runner.manipulation.d
    public void e(e sorter) {
        sorter.a(this.f9977a);
    }
}
