package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class j extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14725f = "RMFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f14726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f14727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private q f14728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<j> f14729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f14730e;

    private class b implements l {
        private b() {
        }

        @Override // com.bumptech.glide.manager.l
        public Set<q> a() {
            Set<j> setB = j.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (j jVar : setB) {
                if (jVar.d() != null) {
                    hashSet.add(jVar.d());
                }
            }
            return hashSet;
        }
    }

    public j() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a(j jVar) {
        this.f14729d.add(jVar);
    }

    @TargetApi(17)
    private boolean f(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void g(j jVar) {
        this.f14729d.remove(jVar);
    }

    @TargetApi(17)
    public Set<j> b() {
        j jVar = this.f14730e;
        if (jVar == this) {
            return Collections.unmodifiableSet(this.f14729d);
        }
        if (jVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (j jVar2 : this.f14730e.b()) {
            if (f(jVar2.getParentFragment())) {
                hashSet.add(jVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.manager.a c() {
        return this.f14726a;
    }

    public q d() {
        return this.f14728c;
    }

    public l e() {
        return this.f14727b;
    }

    public void h(q qVar) {
        this.f14728c = qVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            j jVarJ = k.h().j(getActivity().getFragmentManager());
            this.f14730e = jVarJ;
            if (jVarJ != this) {
                jVarJ.a(this);
            }
        } catch (IllegalStateException e8) {
            if (Log.isLoggable(f14725f, 5)) {
                Log.w(f14725f, "Unable to register fragment with root", e8);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14726a.b();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        j jVar = this.f14730e;
        if (jVar != null) {
            jVar.g(this);
            this.f14730e = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        q qVar = this.f14728c;
        if (qVar != null) {
            qVar.L();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14726a.c();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14726a.d();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i7) {
        q qVar = this.f14728c;
        if (qVar != null) {
            qVar.M(i7);
        }
    }

    @SuppressLint({"ValidFragment"})
    j(com.bumptech.glide.manager.a aVar) {
        this.f14727b = new b();
        this.f14729d = new HashSet<>();
        this.f14726a = aVar;
    }
}
