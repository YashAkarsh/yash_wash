package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import c.g1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class a0 implements ServiceConnection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    androidx.concurrent.futures.e<Integer> f5617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f5618c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    @g1
    androidx.core.app.unusedapprestrictions.b f5616a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5619d = false;

    class a extends androidx.core.app.unusedapprestrictions.a.b {
        a() {
        }

        @Override // androidx.core.app.unusedapprestrictions.a
        public void q5(boolean z7, boolean z8) throws RemoteException {
            if (!z7) {
                a0.this.f5617b.p(0);
                Log.e(v.f5766a, "Unable to retrieve the permission revocation setting from the backport");
            } else if (z8) {
                a0.this.f5617b.p(3);
            } else {
                a0.this.f5617b.p(2);
            }
        }
    }

    a0(@m0 Context context) {
        this.f5618c = context;
    }

    private androidx.core.app.unusedapprestrictions.a c() {
        return new a();
    }

    public void a(@m0 androidx.concurrent.futures.e<Integer> eVar) {
        if (this.f5619d) {
            throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
        }
        this.f5619d = true;
        this.f5617b = eVar;
        this.f5618c.bindService(new Intent(UnusedAppRestrictionsBackportService.f5613b).setPackage(v.b(this.f5618c.getPackageManager())), this, 1);
    }

    public void b() {
        if (!this.f5619d) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.f5619d = false;
        this.f5618c.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        androidx.core.app.unusedapprestrictions.b bVarI0 = androidx.core.app.unusedapprestrictions.b.AbstractBinderC0056b.i0(iBinder);
        this.f5616a = bVarI0;
        try {
            bVarI0.m2(c());
        } catch (RemoteException unused) {
            this.f5617b.p(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f5616a = null;
    }
}
