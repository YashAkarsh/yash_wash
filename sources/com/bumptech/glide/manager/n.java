package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class n extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14744f = "SupportRMFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f14745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f14746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f14747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<n> f14748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private n f14749e;

    private class b implements l {
        private b() {
        }

        @Override // com.bumptech.glide.manager.l
        public Set<q> a() {
            Set<n> setB = n.this.B();
            HashSet hashSet = new HashSet(setB.size());
            for (n nVar : setB) {
                if (nVar.D() != null) {
                    hashSet.add(nVar.D());
                }
            }
            return hashSet;
        }
    }

    public n() {
        this(new com.bumptech.glide.manager.a());
    }

    private void A(n nVar) {
        this.f14748d.add(nVar);
    }

    private boolean F(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void G(n nVar) {
        this.f14748d.remove(nVar);
    }

    public Set<n> B() {
        n nVar = this.f14749e;
        if (nVar == null) {
            return Collections.emptySet();
        }
        if (nVar == this) {
            return Collections.unmodifiableSet(this.f14748d);
        }
        HashSet hashSet = new HashSet();
        for (n nVar2 : this.f14749e.B()) {
            if (F(nVar2.getParentFragment())) {
                hashSet.add(nVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.manager.a C() {
        return this.f14746b;
    }

    public q D() {
        return this.f14745a;
    }

    public l E() {
        return this.f14747c;
    }

    public void H(q qVar) {
        this.f14745a = qVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            n nVarK = k.h().k(getActivity().getSupportFragmentManager());
            this.f14749e = nVarK;
            if (nVarK != this) {
                nVarK.A(this);
            }
        } catch (IllegalStateException e8) {
            if (Log.isLoggable(f14744f, 5)) {
                Log.w(f14744f, "Unable to register fragment with root", e8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14746b.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        n nVar = this.f14749e;
        if (nVar != null) {
            nVar.G(this);
            this.f14749e = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        q qVar = this.f14745a;
        if (qVar != null) {
            qVar.L();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14746b.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14746b.d();
    }

    @SuppressLint({"ValidFragment"})
    public n(com.bumptech.glide.manager.a aVar) {
        this.f14747c = new b();
        this.f14748d = new HashSet<>();
        this.f14746b = aVar;
    }
}
