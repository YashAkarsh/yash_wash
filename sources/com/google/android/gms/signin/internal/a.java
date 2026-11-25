package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a extends com.google.android.gms.common.internal.i<f> implements com.google.android.gms.signin.f {
    public static final /* synthetic */ int S = 0;
    private final boolean O;
    private final com.google.android.gms.common.internal.f P;
    private final Bundle Q;

    @o0
    private final Integer R;

    public a(@m0 Context context, @m0 Looper looper, boolean z7, @m0 com.google.android.gms.common.internal.f fVar, @m0 Bundle bundle, @m0 k.b bVar, @m0 k.c cVar) {
        super(context, looper, 44, fVar, bVar, cVar);
        this.O = true;
        this.P = fVar;
        this.Q = bundle;
        this.R = fVar.l();
    }

    @c1.a
    @m0
    public static Bundle u0(@m0 com.google.android.gms.common.internal.f fVar) {
        fVar.k();
        Integer numL = fVar.l();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", fVar.b());
        if (numL != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numL.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final /* synthetic */ IInterface A(@m0 IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new f(iBinder);
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final Bundle I() {
        if (!G().getPackageName().equals(this.P.h())) {
            this.Q.putString("com.google.android.gms.signin.internal.realClientPackageName", this.P.h());
        }
        return this.Q;
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final String N() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final String O() {
        return "com.google.android.gms.signin.service.START";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.f
    public final void b() {
        try {
            ((f) M()).t6(((Integer) u.k(this.R)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.signin.f
    public final void e() {
        l(new com.google.android.gms.common.internal.e.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.f
    public final void q(e eVar) {
        u.l(eVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountD = this.P.d();
            ((f) M()).v6(new zai(1, new zat(accountD, ((Integer) u.k(this.R)).intValue(), "<<default account>>".equals(accountD.name) ? com.google.android.gms.auth.api.signin.internal.b.b(G()).c() : null)), eVar);
        } catch (RemoteException e8) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                eVar.O1(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e8);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.e, com.google.android.gms.common.api.a.f
    public final int r() {
        return 12451000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.f
    public final void t(@m0 m mVar, boolean z7) {
        try {
            ((f) M()).u6(mVar, ((Integer) u.k(this.R)).intValue(), z7);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.common.internal.e, com.google.android.gms.common.api.a.f
    public final boolean w() {
        return this.O;
    }
}
