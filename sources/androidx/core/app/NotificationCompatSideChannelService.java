package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    private class a extends android.support.v4.app.a.b {
        a() {
        }

        @Override // android.support.v4.app.a
        public void U5(String str, int i7, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.d(str, i7, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.a
        public void h2(String str) {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.b(str);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.a
        public void i4(String str, int i7, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.a(str, i7, str2);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public abstract void a(String str, int i7, String str2);

    public abstract void b(String str);

    void c(int i7, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(i7)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i7 + " is not authorized for package " + str);
    }

    public abstract void d(String str, int i7, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        intent.getAction().equals(n5.f5416g);
        return null;
    }
}
