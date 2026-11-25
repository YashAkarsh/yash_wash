package androidx.core.content;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5613b = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.core.app.unusedapprestrictions.b.AbstractBinderC0056b f5614a = new a();

    class a extends androidx.core.app.unusedapprestrictions.b.AbstractBinderC0056b {
        a() {
        }

        @Override // androidx.core.app.unusedapprestrictions.b
        public void m2(@o0 androidx.core.app.unusedapprestrictions.a aVar) throws RemoteException {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new z(aVar));
        }
    }

    protected abstract void a(@m0 z zVar);

    @Override // android.app.Service
    @o0
    public IBinder onBind(@o0 Intent intent) {
        return this.f5614a;
    }
}
