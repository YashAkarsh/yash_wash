package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import c.b0;
import c.m0;
import c.o0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f8965b;

        a(int i7, Bundle bundle) {
            this.f8964a = i7;
            this.f8965b = bundle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.e(view).t(this.f8964a, this.f8965b);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f8966a;

        b(m mVar) {
            this.f8966a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.e(view).D(this.f8966a);
        }
    }

    private v() {
    }

    @m0
    public static View.OnClickListener a(@b0 int i7) {
        return b(i7, null);
    }

    @m0
    public static View.OnClickListener b(@b0 int i7, @o0 Bundle bundle) {
        return new a(i7, bundle);
    }

    @m0
    public static View.OnClickListener c(@m0 m mVar) {
        return new b(mVar);
    }

    @m0
    public static NavController d(@m0 Activity activity, @b0 int i7) {
        NavController navControllerF = f(androidx.core.app.b.H(activity, i7));
        if (navControllerF != null) {
            return navControllerF;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i7);
    }

    @m0
    public static NavController e(@m0 View view) {
        NavController navControllerF = f(view);
        if (navControllerF != null) {
            return navControllerF;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    @o0
    private static NavController f(@m0 View view) {
        while (view != null) {
            NavController navControllerG = g(view);
            if (navControllerG != null) {
                return navControllerG;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @o0
    private static NavController g(@m0 View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static void h(@m0 View view, @o0 NavController navController) {
        view.setTag(R.id.nav_controller_view_tag, navController);
    }
}
