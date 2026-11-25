package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i4 extends Fragment implements m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WeakHashMap<FragmentActivity, WeakReference<i4>> f15277d = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, LifecycleCallback> f15278a = Collections.synchronizedMap(new androidx.collection.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15279b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private Bundle f15280c;

    public static i4 C(FragmentActivity fragmentActivity) {
        i4 i4Var;
        WeakHashMap<FragmentActivity, WeakReference<i4>> weakHashMap = f15277d;
        WeakReference<i4> weakReference = weakHashMap.get(fragmentActivity);
        if (weakReference != null && (i4Var = weakReference.get()) != null) {
            return i4Var;
        }
        try {
            i4 i4Var2 = (i4) fragmentActivity.getSupportFragmentManager().q0("SupportLifecycleFragmentImpl");
            if (i4Var2 == null || i4Var2.isRemoving()) {
                i4Var2 = new i4();
                fragmentActivity.getSupportFragmentManager().r().l(i4Var2, "SupportLifecycleFragmentImpl").s();
            }
            weakHashMap.put(fragmentActivity, new WeakReference<>(i4Var2));
            return i4Var2;
        } catch (ClassCastException e8) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final boolean c() {
        return this.f15279b > 0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final void h(String str, @c.m0 LifecycleCallback lifecycleCallback) {
        if (this.f15278a.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f15278a.put(str, lifecycleCallback);
        if (this.f15279b > 0) {
            new com.google.android.gms.internal.common.t(Looper.getMainLooper()).post(new h4(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    @c.o0
    public final <T extends LifecycleCallback> T l(String str, Class<T> cls) {
        return cls.cast(this.f15278a.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.m
    @c.o0
    public final /* synthetic */ Activity m() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i7, int i8, @c.o0 Intent intent) {
        super.onActivityResult(i7, i8, intent);
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().f(i7, i8, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        this.f15279b = 1;
        this.f15280c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f15278a.entrySet()) {
            entry.getValue().g(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f15279b = 5;
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f15279b = 3;
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f15278a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().j(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f15279b = 2;
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f15279b = 4;
        Iterator<LifecycleCallback> it = this.f15278a.values().iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final boolean p() {
        return this.f15279b >= 2;
    }
}
