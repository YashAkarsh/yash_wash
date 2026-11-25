package com.google.android.gms.common.api;

import android.text.TextUtils;
import c.m0;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.collection.a<com.google.android.gms.common.api.internal.c<?>, ConnectionResult> f15084a;

    public c(@m0 androidx.collection.a<com.google.android.gms.common.api.internal.c<?>, ConnectionResult> aVar) {
        this.f15084a = aVar;
    }

    @m0
    public ConnectionResult a(@m0 j<? extends a.d> jVar) {
        com.google.android.gms.common.api.internal.c<O> cVarB = jVar.b();
        boolean z7 = this.f15084a.get(cVarB) != null;
        String strB = cVarB.b();
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 58);
        sb.append("The given API (");
        sb.append(strB);
        sb.append(") was not part of the availability request.");
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
        return (ConnectionResult) com.google.android.gms.common.internal.u.k(this.f15084a.get(cVarB));
    }

    @m0
    public ConnectionResult b(@m0 l<? extends a.d> lVar) {
        com.google.android.gms.common.api.internal.c<O> cVarB = lVar.b();
        boolean z7 = this.f15084a.get(cVarB) != null;
        String strB = cVarB.b();
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 58);
        sb.append("The given API (");
        sb.append(strB);
        sb.append(") was not part of the availability request.");
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
        return (ConnectionResult) com.google.android.gms.common.internal.u.k(this.f15084a.get(cVarB));
    }

    @Override // java.lang.Throwable
    @m0
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z7 = true;
        for (com.google.android.gms.common.api.internal.c<?> cVar : this.f15084a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) com.google.android.gms.common.internal.u.k(this.f15084a.get(cVar));
            z7 &= !connectionResult.s0();
            String strB = cVar.b();
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 2 + strValueOf.length());
            sb.append(strB);
            sb.append(": ");
            sb.append(strValueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z7) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
