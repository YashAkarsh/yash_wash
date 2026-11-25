package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8676a = "MediaButtonReceiver";

    private static class a extends MediaBrowserCompat.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f8677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Intent f8678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f8679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MediaBrowserCompat f8680f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f8677c = context;
            this.f8678d = intent;
            this.f8679e = pendingResult;
        }

        private void e() {
            this.f8680f.b();
            this.f8679e.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            try {
                new MediaControllerCompat(this.f8677c, this.f8680f.h()).d((KeyEvent) this.f8678d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e8) {
                Log.e(MediaButtonReceiver.f8676a, "Failed to create a media controller", e8);
            }
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            e();
        }

        void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f8680f = mediaBrowserCompat;
        }
    }

    public static PendingIntent a(Context context, long j7) {
        ComponentName componentNameC = c(context);
        if (componentNameC != null) {
            return b(context, componentNameC, j7);
        }
        Log.w(f8676a, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    public static PendingIntent b(Context context, ComponentName componentName, long j7) {
        if (componentName == null) {
            Log.w(f8676a, "The component name of media button receiver should be provided.");
            return null;
        }
        int iS = PlaybackStateCompat.s(j7);
        if (iS != 0) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, iS));
            return PendingIntent.getBroadcast(context, iS, intent, 0);
        }
        Log.w(f8676a, "Cannot build a media button pending intent with the given action: " + j7);
        return null;
    }

    @x0({x0.a.LIBRARY})
    public static ComponentName c(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (listQueryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w(f8676a, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName d(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }

    public static KeyEvent e(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.e().d(keyEvent);
        return keyEvent;
    }

    private static void f(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(f8676a, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameD = d(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameD != null) {
            intent.setComponent(componentNameD);
            f(context, intent);
            return;
        }
        ComponentName componentNameD2 = d(context, MediaBrowserServiceCompat.f8506i);
        if (componentNameD2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        a aVar = new a(applicationContext, intent, pendingResultGoAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameD2, aVar, null);
        aVar.f(mediaBrowserCompat);
        mediaBrowserCompat.a();
    }
}
