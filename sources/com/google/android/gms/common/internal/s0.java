package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseIntArray f15792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.android.gms.common.h f15793b;

    public s0() {
        this(com.google.android.gms.common.g.x());
    }

    public final int a(Context context, int i7) {
        return this.f15792a.get(i7, -1);
    }

    public final int b(@c.m0 Context context, @c.m0 com.google.android.gms.common.api.a.f fVar) {
        u.k(context);
        u.k(fVar);
        int i7 = 0;
        if (!fVar.p()) {
            return 0;
        }
        int iR = fVar.r();
        int iA = a(context, iR);
        if (iA == -1) {
            int i8 = 0;
            while (true) {
                if (i8 >= this.f15792a.size()) {
                    i7 = -1;
                    break;
                }
                int iKeyAt = this.f15792a.keyAt(i8);
                if (iKeyAt > iR && this.f15792a.get(iKeyAt) == 0) {
                    break;
                }
                i8++;
            }
            iA = i7 == -1 ? this.f15793b.k(context, iR) : i7;
            this.f15792a.put(iR, iA);
        }
        return iA;
    }

    public final void c() {
        this.f15792a.clear();
    }

    public s0(@c.m0 com.google.android.gms.common.h hVar) {
        this.f15792a = new SparseIntArray();
        u.k(hVar);
        this.f15793b = hVar;
    }
}
