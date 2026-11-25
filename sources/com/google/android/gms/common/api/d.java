package com.google.android.gms.common.api;

import c.m0;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d extends BasePendingResult<e> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f15086r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f15087s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15088t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final n<?>[] f15089u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Object f15090v;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<n<?>> f15091a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private k f15092b;

        public a(@m0 k kVar) {
            this.f15092b = kVar;
        }

        @m0
        public <R extends t> f<R> a(@m0 n<R> nVar) {
            f<R> fVar = new f<>(this.f15091a.size());
            this.f15091a.add(nVar);
            return fVar;
        }

        @m0
        public d b() {
            return new d(this.f15091a, this.f15092b, null);
        }
    }

    /* synthetic */ d(List list, k kVar, b0 b0Var) {
        super(kVar);
        this.f15090v = new Object();
        int size = list.size();
        this.f15086r = size;
        n<?>[] nVarArr = new n[size];
        this.f15089u = nVarArr;
        if (list.isEmpty()) {
            o(new e(Status.f15063f, nVarArr));
            return;
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            n<?> nVar = (n) list.get(i7);
            this.f15089u[i7] = nVar;
            nVar.c(new a0(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.n
    public void f() {
        super.f();
        for (n<?> nVar : this.f15089u) {
            nVar.f();
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @m0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public e k(@m0 Status status) {
        return new e(status, this.f15089u);
    }
}
