package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.support.customtabs.c.a f2136a = new a();

    class a extends android.support.customtabs.c.a {
        a() {
        }

        @Override // android.support.customtabs.c
        public void L3(android.support.customtabs.a aVar, String str, Bundle bundle) throws RemoteException {
            aVar.K5(str, bundle);
        }

        @Override // android.support.customtabs.c
        public void Z2(android.support.customtabs.a aVar, Bundle bundle) throws RemoteException {
            aVar.S5(bundle);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2136a;
    }
}
