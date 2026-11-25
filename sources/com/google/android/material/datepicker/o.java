package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class o<S> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final LinkedHashSet<n<S>> f17578a = new LinkedHashSet<>();

    o() {
    }

    boolean A(n<S> nVar) {
        return this.f17578a.add(nVar);
    }

    void B() {
        this.f17578a.clear();
    }

    abstract DateSelector<S> C();

    boolean D(n<S> nVar) {
        return this.f17578a.remove(nVar);
    }
}
