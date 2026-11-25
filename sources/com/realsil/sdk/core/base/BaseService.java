package com.realsil.sdk.core.base;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.view.Display;
import androidx.annotation.Keep;
import androidx.core.app.b1;
import androidx.core.app.c1;
import androidx.core.app.l2;
import androidx.core.app.l4;
import androidx.core.app.m4;
import c.t0;
import com.facebook.internal.ServerProtocol;
import k4.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DisplayManager f33115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f33116b;

    @Keep
    public Context mContext;

    @Keep
    public int notificationId = 1230;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DisplayManager.DisplayListener f33117c = new a(this);

    public class a implements DisplayManager.DisplayListener {
        public a(BaseService baseService) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i7) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i7) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i7) {
        }
    }

    @t0(26)
    public final String a(String str, String str2) {
        c1.a();
        NotificationChannel notificationChannelA = b1.a(str, str2, 0);
        notificationChannelA.setLightColor(-16776961);
        notificationChannelA.setLockscreenVisibility(0);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return str;
    }

    public Notification b(Context context) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            m4.a();
            builder = l4.a(getApplicationContext(), c());
        } else {
            builder = new Notification.Builder(getApplicationContext());
        }
        builder.setContentText("GuardService").setWhen(System.currentTimeMillis());
        return builder.build();
    }

    public String c() {
        return "rtk_channel_id";
    }

    public String d() {
        return "rtk_channel_name";
    }

    public Notification e(String str, String str2) {
        l2.g gVarH0 = new l2.g(this, c()).O(str2).P(str).i0(true).k0(1).H0(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            gVarH0.H(c());
        }
        return gVarH0.h();
    }

    public int f() {
        return this.notificationId;
    }

    public boolean g() {
        Display[] displays;
        DisplayManager displayManager = this.f33115a;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return false;
        }
        for (Display display : displays) {
            if (display.getState() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean h(Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (getClass().getName().equals(runningServiceInfo.service.getClassName()) && runningServiceInfo.foreground) {
                return true;
            }
        }
        return false;
    }

    public void i(int i7) {
        this.notificationId = i7;
    }

    public void j(String str, String str2, PendingIntent pendingIntent, int i7, int i8) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            m4.a();
            builder = l4.a(getApplicationContext(), c());
        } else {
            builder = new Notification.Builder(getApplicationContext());
        }
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        if (i7 != -1) {
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), i7));
        }
        if (i8 != -1) {
            builder.setSmallIcon(i8);
        }
        builder.setContentTitle(str).setContentText(str2).setWhen(System.currentTimeMillis());
        Notification notificationBuild = builder.build();
        if (notificationBuild != null) {
            notificationBuild.flags = 34;
            startForeground(f(), notificationBuild);
        }
    }

    public void k(String str, String str2, ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        j(str, str2, PendingIntent.getActivity(this, 0, intent, 0), -1, -1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b.p("in onBind()");
        return this.f33116b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        DisplayManager displayManager = (DisplayManager) getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        this.f33115a = displayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f33117c, null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            a(c(), d());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DisplayManager displayManager = this.f33115a;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.f33117c);
        }
        stopForeground(true);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        b.p("in onRebind()");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i7, int i8) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        b.s("Last client unbound from service");
        return true;
    }
}
