package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class s0 extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a.f, p0> f15399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a1 f15400c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(a1 a1Var, Map<com.google.android.gms.common.api.a.f, p0> map) {
        super(a1Var, null);
        this.f15400c = a1Var;
        this.f15399b = map;
    }

    @Override // com.google.android.gms.common.api.internal.z0
    @c.h1
    @GuardedBy("mLock")
    public final void a() {
        com.google.android.gms.common.internal.s0 s0Var = new com.google.android.gms.common.internal.s0(this.f15400c.f15147d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.google.android.gms.common.api.a.f fVar : this.f15399b.keySet()) {
            if (!fVar.p() || this.f15399b.get(fVar).f15381c) {
                arrayList2.add(fVar);
            } else {
                arrayList.add(fVar);
            }
        }
        int iB = -1;
        int i7 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i7 < size) {
                iB = s0Var.b(this.f15400c.f15146c, (com.google.android.gms.common.api.a.f) arrayList.get(i7));
                i7++;
                if (iB != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i7 < size2) {
                iB = s0Var.b(this.f15400c.f15146c, (com.google.android.gms.common.api.a.f) arrayList2.get(i7));
                i7++;
                if (iB == 0) {
                    break;
                }
            }
        }
        if (iB != 0) {
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            a1 a1Var = this.f15400c;
            a1Var.f15144a.s(new q0(this, a1Var, connectionResult));
            return;
        }
        a1 a1Var2 = this.f15400c;
        if (a1Var2.f15156m && a1Var2.f15154k != null) {
            a1Var2.f15154k.e();
        }
        for (com.google.android.gms.common.api.a.f fVar2 : this.f15399b.keySet()) {
            p0 p0Var = this.f15399b.get(fVar2);
            if (!fVar2.p() || s0Var.b(this.f15400c.f15146c, fVar2) == 0) {
                fVar2.l(p0Var);
            } else {
                a1 a1Var3 = this.f15400c;
                a1Var3.f15144a.s(new r0(this, a1Var3, p0Var));
            }
        }
    }
}
