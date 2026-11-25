package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class d implements Comparator<Scope> {
    d() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Scope scope, Scope scope2) {
        return scope.K().compareTo(scope2.K());
    }
}
