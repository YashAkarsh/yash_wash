package com.haier.globalwasher.presenter.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.b1;
import androidx.core.app.c1;
import androidx.core.app.l2;
import com.alibaba.android.arouter.utils.b;
import com.google.common.net.c;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.j;
import com.haier.globalwasher.modle.utils.k0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.library.sumhttp.plugin.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateIntentService extends IntentService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25306g = "com.haier.globalwasher.action.UPDATE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f25307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RemoteViews f25308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Notification f25309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f25310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f25311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Resources f25312f;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.arg1;
            if (i7 == 0) {
                UpdateIntentService.this.c();
            } else if (i7 != 1) {
                if (i7 == 2) {
                    UpdateIntentService.this.i(message);
                } else if (i7 == 3) {
                }
                UpdateIntentService.this.i(message);
            } else {
                UpdateIntentService.this.k(message);
            }
            return true;
        }
    }

    public UpdateIntentService() {
        super("MyIntentService");
        this.f25311e = "updateChannel";
    }

    private void b() {
        Message messageObtainMessage = this.f25310d.obtainMessage();
        messageObtainMessage.arg1 = 0;
        this.f25310d.sendMessage(messageObtainMessage);
    }

    private void d(File file) {
        Message messageObtainMessage = this.f25310d.obtainMessage();
        messageObtainMessage.arg1 = 2;
        messageObtainMessage.obj = file;
        this.f25310d.sendMessage(messageObtainMessage);
    }

    private void g() {
        this.f25310d = new Handler(Looper.getMainLooper(), new a());
    }

    private void h(Intent intent) {
        g();
        b();
        d(j(intent));
    }

    private File j(Intent intent) {
        File fileD = j.d(getApplicationContext(), intent.getStringExtra("name") + System.currentTimeMillis() + ".apk");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(intent.getStringExtra("downUrl")).openConnection();
            httpURLConnection.setConnectTimeout(h.f27948e);
            httpURLConnection.setRequestProperty(c.f22150j, "identity");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(fileD, true);
            byte[] bArr = new byte[8192];
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = inputStream.read(bArr);
                i7 += i9;
                int i10 = (int) ((i7 / contentLength) * 100.0f);
                if (i10 > i8) {
                    l(i10);
                    i8 = i10;
                }
                if (i9 <= 0) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return fileD;
                }
                fileOutputStream.write(bArr, 0, i9);
                fileOutputStream.flush();
            }
        } catch (Exception e8) {
            Log.i("updateException", e8.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Message message) {
        Integer num = (Integer) message.obj;
        this.f25308b.setProgressBar(R.id.notificationProgress, 100, num.intValue(), false);
        this.f25308b.setTextViewText(R.id.notification_note_tv, this.f25312f.getString(R.string.version_downloading) + num + "%");
        this.f25307a.notify(0, this.f25309c);
    }

    private void l(int i7) {
        Message messageObtainMessage = this.f25310d.obtainMessage();
        messageObtainMessage.arg1 = 1;
        messageObtainMessage.obj = Integer.valueOf(i7);
        this.f25310d.sendMessage(messageObtainMessage);
    }

    public void c() {
        l2.g gVar;
        this.f25312f = getResources();
        this.f25307a = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            gVar = new l2.g(getApplicationContext(), this.f25311e);
            c1.a();
            this.f25307a.createNotificationChannel(b1.a(this.f25311e, getString(R.string.app_name), 3));
        } else {
            gVar = new l2.g(getApplicationContext());
        }
        gVar.t0(R.mipmap.logo);
        gVar.B0(this.f25312f.getString(R.string.version_downloading));
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_update);
        this.f25308b = remoteViews;
        remoteViews.setProgressBar(R.id.notificationProgress, 100, 0, false);
        gVar.R(this.f25308b);
        this.f25309c = gVar.h();
        new l2.e();
        Notification notification = this.f25309c;
        notification.flags = 40;
        notification.icon = R.mipmap.logo;
        this.f25307a.notify(0, notification);
    }

    public Intent e(File file) {
        Uri uriE = k0.e(getBaseContext(), file);
        String strF = f(file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435459);
        intent.setDataAndType(uriE, strF);
        return intent;
    }

    public String f(File file) {
        return file.getName().substring(file.getName().lastIndexOf(b.f12515h) + 1, file.getName().length()).equals("apk") ? "application/vnd.android.package-archive" : "*/*";
    }

    public void i(Message message) {
        q.c("installApk", "'" + message.obj);
        this.f25312f = getResources();
        File file = (File) message.obj;
        if (file == null || file.length() == 0) {
            this.f25308b.setTextViewText(R.id.notification_note_tv, this.f25312f.getString(R.string.version_failure));
            Notification notification = this.f25309c;
            notification.flags = 16;
            this.f25307a.notify(0, notification);
            return;
        }
        this.f25307a.cancel(0);
        this.f25308b.setProgressBar(R.id.notificationProgress, 100, 100, false);
        this.f25308b.setTextViewText(R.id.notification_note_tv, this.f25312f.getString(R.string.version_completion));
        this.f25309c.flags = 24;
        Intent intentE = e(file);
        this.f25309c.contentIntent = PendingIntent.getActivity(this, 0, intentE, 0);
        this.f25307a.notify(1, this.f25309c);
        startActivity(intentE);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals(f25306g)) {
                h(intent);
            }
        }
    }
}
