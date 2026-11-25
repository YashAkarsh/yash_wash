package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.q;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements Handler.Callback {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14732e = "RMRetriever";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f14733f = "com.bumptech.glide.manager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final k f14734g = new k();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f14735h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f14736i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile q f14737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<FragmentManager, j> f14738b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, n> f14739c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f14740d = new Handler(Looper.getMainLooper(), this);

    k() {
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static k h() {
        return f14734g;
    }

    private q i(Context context) {
        if (this.f14737a == null) {
            synchronized (this) {
                if (this.f14737a == null) {
                    this.f14737a = new q(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.f14737a;
    }

    @TargetApi(11)
    q b(Context context, FragmentManager fragmentManager) {
        j jVarJ = j(fragmentManager);
        q qVarD = jVarJ.d();
        if (qVarD != null) {
            return qVarD;
        }
        q qVar = new q(context, jVarJ.c(), jVarJ.e());
        jVarJ.h(qVar);
        return qVar;
    }

    @TargetApi(11)
    public q c(Activity activity) {
        if (com.bumptech.glide.util.i.j()) {
            return e(activity.getApplicationContext());
        }
        a(activity);
        return b(activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    public q d(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.bumptech.glide.util.i.j()) {
            return e(fragment.getActivity().getApplicationContext());
        }
        return b(fragment.getActivity(), fragment.getChildFragmentManager());
    }

    public q e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.util.i.k() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return g((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return c((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return e(((ContextWrapper) context).getBaseContext());
            }
        }
        return i(context);
    }

    public q f(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.bumptech.glide.util.i.j()) {
            return e(fragment.getActivity().getApplicationContext());
        }
        return l(fragment.getActivity(), fragment.getChildFragmentManager());
    }

    public q g(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.i.j()) {
            return e(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return l(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks componentCallbacksRemove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i7 = message.what;
        boolean z7 = true;
        if (i7 != 1) {
            if (i7 != 2) {
                componentCallbacks = null;
                z7 = false;
                obj2 = null;
            } else {
                obj = (androidx.fragment.app.FragmentManager) message.obj;
                componentCallbacksRemove = this.f14739c.remove(obj);
            }
            if (z7 && componentCallbacks == null && Log.isLoggable(f14732e, 5)) {
                Log.w(f14732e, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z7;
        }
        obj = (FragmentManager) message.obj;
        componentCallbacksRemove = this.f14738b.remove(obj);
        ComponentCallbacks componentCallbacks2 = componentCallbacksRemove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z7) {
            Log.w(f14732e, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z7;
    }

    @TargetApi(17)
    j j(FragmentManager fragmentManager) {
        j jVar = (j) fragmentManager.findFragmentByTag(f14733f);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = this.f14738b.get(fragmentManager);
        if (jVar2 != null) {
            return jVar2;
        }
        j jVar3 = new j();
        this.f14738b.put(fragmentManager, jVar3);
        fragmentManager.beginTransaction().add(jVar3, f14733f).commitAllowingStateLoss();
        this.f14740d.obtainMessage(1, fragmentManager).sendToTarget();
        return jVar3;
    }

    n k(androidx.fragment.app.FragmentManager fragmentManager) {
        n nVar = (n) fragmentManager.q0(f14733f);
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = this.f14739c.get(fragmentManager);
        if (nVar2 != null) {
            return nVar2;
        }
        n nVar3 = new n();
        this.f14739c.put(fragmentManager, nVar3);
        fragmentManager.r().l(nVar3, f14733f).s();
        this.f14740d.obtainMessage(2, fragmentManager).sendToTarget();
        return nVar3;
    }

    q l(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        n nVarK = k(fragmentManager);
        q qVarD = nVarK.D();
        if (qVarD != null) {
            return qVarD;
        }
        q qVar = new q(context, nVarK.C(), nVarK.E());
        nVarK.H(qVar);
        return qVar;
    }
}
