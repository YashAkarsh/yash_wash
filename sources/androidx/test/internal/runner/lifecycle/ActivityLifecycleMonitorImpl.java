package androidx.test.internal.runner.lifecycle;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ActivityLifecycleCallback;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityLifecycleMonitorImpl implements ActivityLifecycleMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10157d = "LifecycleMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<WeakReference<ActivityLifecycleCallback>> f10159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ActivityStatus> f10160c;

    private static class ActivityStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f10161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Stage f10162b;

        ActivityStatus(Activity activity, Stage stage) {
            this.f10161a = new WeakReference<>((Activity) Checks.f(activity));
            this.f10162b = (Stage) Checks.f(stage);
        }
    }

    public ActivityLifecycleMonitorImpl() {
        this(false);
    }

    private void e() {
        if (!this.f10158a && !Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Querying activity state off main thread is not allowed.");
        }
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public void a(ActivityLifecycleCallback callback) {
        Checks.f(callback);
        synchronized (this.f10159b) {
            Iterator<WeakReference<ActivityLifecycleCallback>> it = this.f10159b.iterator();
            boolean z7 = true;
            while (it.hasNext()) {
                ActivityLifecycleCallback activityLifecycleCallback = it.next().get();
                if (activityLifecycleCallback == null) {
                    it.remove();
                } else if (activityLifecycleCallback == callback) {
                    z7 = false;
                }
            }
            if (z7) {
                this.f10159b.add(new WeakReference<>(callback));
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public Stage b(Activity activity) {
        e();
        Checks.f(activity);
        Iterator<ActivityStatus> it = this.f10160c.iterator();
        while (it.hasNext()) {
            ActivityStatus next = it.next();
            Activity activity2 = (Activity) next.f10161a.get();
            if (activity2 == null) {
                it.remove();
            } else if (activity == activity2) {
                return next.f10162b;
            }
        }
        String strValueOf = String.valueOf(activity);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
        sb.append("Unknown activity: ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public void c(ActivityLifecycleCallback callback) {
        Checks.f(callback);
        synchronized (this.f10159b) {
            Iterator<WeakReference<ActivityLifecycleCallback>> it = this.f10159b.iterator();
            while (it.hasNext()) {
                ActivityLifecycleCallback activityLifecycleCallback = it.next().get();
                if (activityLifecycleCallback == null) {
                    it.remove();
                } else if (activityLifecycleCallback == callback) {
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public Collection<Activity> d(Stage stage) {
        e();
        Checks.f(stage);
        ArrayList arrayList = new ArrayList();
        Iterator<ActivityStatus> it = this.f10160c.iterator();
        while (it.hasNext()) {
            ActivityStatus next = it.next();
            Activity activity = (Activity) next.f10161a.get();
            if (activity == null) {
                it.remove();
            } else if (stage == next.f10162b) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    public void f(Stage stage, Activity activity) {
        String strValueOf = String.valueOf(activity);
        String strValueOf2 = String.valueOf(stage);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 30 + strValueOf2.length());
        sb.append("Lifecycle status change: ");
        sb.append(strValueOf);
        sb.append(" in: ");
        sb.append(strValueOf2);
        Log.d(f10157d, sb.toString());
        Iterator<ActivityStatus> it = this.f10160c.iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            ActivityStatus next = it.next();
            Activity activity2 = (Activity) next.f10161a.get();
            if (activity2 == null) {
                it.remove();
            } else if (activity == activity2) {
                next.f10162b = stage;
                z7 = false;
            }
        }
        if (z7) {
            this.f10160c.add(new ActivityStatus(activity, stage));
        }
        synchronized (this.f10159b) {
            Iterator<WeakReference<ActivityLifecycleCallback>> it2 = this.f10159b.iterator();
            while (it2.hasNext()) {
                ActivityLifecycleCallback activityLifecycleCallback = it2.next().get();
                if (activityLifecycleCallback == null) {
                    it2.remove();
                } else {
                    try {
                        String strValueOf3 = String.valueOf(activityLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 18);
                        sb2.append("running callback: ");
                        sb2.append(strValueOf3);
                        Log.d(f10157d, sb2.toString());
                        activityLifecycleCallback.a(activity, stage);
                        String strValueOf4 = String.valueOf(activityLifecycleCallback);
                        StringBuilder sb3 = new StringBuilder(strValueOf4.length() + 20);
                        sb3.append("callback completes: ");
                        sb3.append(strValueOf4);
                        Log.d(f10157d, sb3.toString());
                    } catch (RuntimeException e8) {
                        Log.e(f10157d, String.format("Callback threw exception! (callback: %s activity: %s stage: %s)", activityLifecycleCallback, activity, stage), e8);
                    }
                }
            }
        }
    }

    public ActivityLifecycleMonitorImpl(boolean declawThreadCheck) {
        this.f10159b = new ArrayList();
        this.f10160c = new ArrayList();
        this.f10158a = declawThreadCheck;
    }
}
