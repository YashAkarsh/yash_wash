package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g4 extends Fragment implements m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g4>> f15231d = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, LifecycleCallback> f15232a = Collections.synchronizedMap(new androidx.collection.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15233b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private Bundle f15234c;

    public static g4 d(Activity activity) {
        g4 g4Var;
        WeakHashMap<Activity, WeakReference<g4>> weakHashMap = f15231d;
        WeakReference<g4> weakReference = weakHashMap.get(activity);
        if (weakReference != null && (g4Var = weakReference.get()) != null) {
            return g4Var;
        }
        try {
            g4 g4Var2 = (g4) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (g4Var2 == null || g4Var2.isRemoving()) {
                g4Var2 = new g4();
                activity.getFragmentManager().beginTransaction().add(g4Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference<>(g4Var2));
            return g4Var2;
        } catch (ClassCastException e8) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final boolean c() {
        return this.f15233b > 0;
    }

    @Override // android.app.Fragment
    public final void dump(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final void h(String str, @c.m0 LifecycleCallback lifecycleCallback) {
        if (this.f15232a.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f15232a.put(str, lifecycleCallback);
        if (this.f15233b > 0) {
            new com.google.android.gms.internal.common.t(Looper.getMainLooper()).post(new f4(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    @c.o0
    public final <T extends LifecycleCallback> T l(String str, Class<T> cls) {
        return cls.cast(this.f15232a.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.m
    @c.o0
    public final Activity m() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i7, int i8, @c.o0 Intent intent) {
        super.onActivityResult(i7, i8, intent);
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().f(i7, i8, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        this.f15233b = 1;
        this.f15234c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f15232a.entrySet()) {
            entry.getValue().g(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f15233b = 5;
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f15233b = 3;
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f15232a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().j(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f15233b = 2;
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f15233b = 4;
        Iterator<LifecycleCallback> it = this.f15232a.values().iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final boolean p() {
        return this.f15233b >= 2;
    }
}
