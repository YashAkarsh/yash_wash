package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class b0 extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8251b = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8252a;

    interface a {
        void i();

        void j();

        void onStart();
    }

    @c.t0(29)
    static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@c.m0 Activity activity, @c.o0 Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@c.m0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@c.m0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(@c.m0 Activity activity, @c.o0 Bundle bundle) {
            b0.a(activity, m.b.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@c.m0 Activity activity) {
            b0.a(activity, m.b.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(@c.m0 Activity activity) {
            b0.a(activity, m.b.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@c.m0 Activity activity) {
            b0.a(activity, m.b.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(@c.m0 Activity activity) {
            b0.a(activity, m.b.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(@c.m0 Activity activity) {
            b0.a(activity, m.b.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@c.m0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@c.m0 Activity activity, @c.m0 Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@c.m0 Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@c.m0 Activity activity) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(@c.m0 Activity activity, @c.m0 m.b bVar) {
        if (activity instanceof t) {
            ((t) activity).getLifecycle().j(bVar);
        } else if (activity instanceof q) {
            m lifecycle = ((q) activity).getLifecycle();
            if (lifecycle instanceof r) {
                ((r) lifecycle).j(bVar);
            }
        }
    }

    private void b(@c.m0 m.b bVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), bVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.j();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.i();
        }
    }

    private void e(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    static b0 f(Activity activity) {
        return (b0) activity.getFragmentManager().findFragmentByTag(f8251b);
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag(f8251b) == null) {
            fragmentManager.beginTransaction().add(new b0(), f8251b).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    void h(a aVar) {
        this.f8252a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f8252a);
        b(m.b.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b(m.b.ON_DESTROY);
        this.f8252a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        b(m.b.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.f8252a);
        b(m.b.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(this.f8252a);
        b(m.b.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        b(m.b.ON_STOP);
    }
}
