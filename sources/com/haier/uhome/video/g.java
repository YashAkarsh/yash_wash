package com.haier.uhome.video;

import android.app.Application;
import android.content.Context;
import com.tencentcs.iotvideo.IoTVideoSdk;
import com.tencentcs.iotvideo.messagemgr.IAppLinkListener;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f32167a = new g();

        private a() {
        }
    }

    public static g a() {
        return a.f32167a;
    }

    public void b() {
        IoTVideoSdk.unregister();
    }

    public void c() {
        IoTVideoSdk.setLogPath(com.haier.uhome.usdk.base.service.e.a().b().getFilesDir() + File.separator + "xLog");
    }

    void d() {
        IoTVideoSdk.getMessageMgr().removeAppLinkListeners();
    }

    public void a(Context context) {
        IoTVideoSdk.init((Application) context, (HashMap) null);
    }

    public boolean a(String str) {
        return IoTVideoSdk.updateToken(str);
    }

    public void a(long j7, String str) {
        IoTVideoSdk.register(j7, str);
    }

    public void a(int i7) {
        if (i7 == 1) {
            IoTVideoSdk.setDebugMode(5);
            return;
        }
        if (i7 == 2) {
            IoTVideoSdk.setDebugMode(4);
            return;
        }
        if (i7 == 4) {
            IoTVideoSdk.setDebugMode(3);
        } else if (i7 == 8) {
            IoTVideoSdk.setDebugMode(2);
        } else {
            if (i7 != 16) {
                return;
            }
            IoTVideoSdk.setDebugMode(0);
        }
    }

    void a(IAppLinkListener iAppLinkListener) {
        IoTVideoSdk.getMessageMgr().addAppLinkListener(iAppLinkListener);
    }
}
