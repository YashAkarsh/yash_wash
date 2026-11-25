package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10163b = "ApplicationLifecycleMonitorImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<WeakReference<ApplicationLifecycleCallback>> f10164a = new ArrayList();

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void a(ApplicationLifecycleCallback callback) {
        Checks.f(callback);
        synchronized (this.f10164a) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.f10164a.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else if (applicationLifecycleCallback == callback) {
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void b(ApplicationLifecycleCallback callback) {
        Checks.f(callback);
        synchronized (this.f10164a) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.f10164a.iterator();
            boolean z7 = true;
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else if (applicationLifecycleCallback == callback) {
                    z7 = false;
                }
            }
            if (z7) {
                this.f10164a.add(new WeakReference<>(callback));
            }
        }
    }

    public void c(Application app, ApplicationStage stage) {
        synchronized (this.f10164a) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.f10164a.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else {
                    try {
                        String strValueOf = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                        sb.append("running callback: ");
                        sb.append(strValueOf);
                        Log.d(f10163b, sb.toString());
                        applicationLifecycleCallback.a(app, stage);
                        String strValueOf2 = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 20);
                        sb2.append("callback completes: ");
                        sb2.append(strValueOf2);
                        Log.d(f10163b, sb2.toString());
                    } catch (RuntimeException e8) {
                        Log.e(f10163b, String.format("Callback threw exception! (callback: %s stage: %s)", applicationLifecycleCallback, stage), e8);
                    }
                }
            }
        }
    }
}
