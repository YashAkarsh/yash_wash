package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.e eVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f5083a = (IconCompat) eVar.h0(remoteActionCompat.f5083a, 1);
        remoteActionCompat.f5084b = eVar.w(remoteActionCompat.f5084b, 2);
        remoteActionCompat.f5085c = eVar.w(remoteActionCompat.f5085c, 3);
        remoteActionCompat.f5086d = (PendingIntent) eVar.W(remoteActionCompat.f5086d, 4);
        remoteActionCompat.f5087e = eVar.m(remoteActionCompat.f5087e, 5);
        remoteActionCompat.f5088f = eVar.m(remoteActionCompat.f5088f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.e eVar) {
        eVar.j0(false, false);
        eVar.m1(remoteActionCompat.f5083a, 1);
        eVar.z0(remoteActionCompat.f5084b, 2);
        eVar.z0(remoteActionCompat.f5085c, 3);
        eVar.X0(remoteActionCompat.f5086d, 4);
        eVar.n0(remoteActionCompat.f5087e, 5);
        eVar.n0(remoteActionCompat.f5088f, 6);
    }
}
