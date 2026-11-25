package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.l2;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@w.b(l2.f5210q0)
public class o extends w<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f8898a;

    public o(@m0 x xVar) {
        this.f8898a = xVar;
    }

    @Override // androidx.navigation.w
    public boolean e() {
        return true;
    }

    @Override // androidx.navigation.w
    @m0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public n a() {
        return new n(this);
    }

    @Override // androidx.navigation.w
    @o0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public l b(@m0 n nVar, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar) {
        int iO = nVar.O();
        if (iO == 0) {
            throw new IllegalStateException("no start destination defined via app:startDestination for " + nVar.k());
        }
        l lVarM = nVar.M(iO, false);
        if (lVarM != null) {
            return this.f8898a.e(lVarM.o()).b(lVarM, lVarM.f(bundle), tVar, aVar);
        }
        throw new IllegalArgumentException("navigation destination " + nVar.N() + " is not a direct child of this NavGraph");
    }
}
