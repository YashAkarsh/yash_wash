package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements ServiceConnection {

    class a extends b {
        a(android.support.customtabs.b bVar, ComponentName componentName) {
            super(bVar, componentName);
        }
    }

    public abstract void a(ComponentName componentName, b bVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new a(android.support.customtabs.b.a.i0(iBinder), componentName));
    }
}
