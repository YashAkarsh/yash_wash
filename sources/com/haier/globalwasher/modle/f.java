package com.haier.globalwasher.modle;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.haier.globalwasher.MyApplication;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24479a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Long> f24480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f24481c;

    private f() {
    }

    public static f b() {
        if (f24480b == null) {
            f24480b = new HashMap();
        }
        if (f24481c == null) {
            f24481c = new f();
        }
        return f24481c;
    }

    private void c() {
        if (f24480b.size() == 0) {
            f24480b = null;
            f24481c = null;
        }
    }

    public Map<String, Long> a() {
        return f24480b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        String str = (String) message.obj;
        if (f24480b == null) {
            f24480b = new HashMap();
        }
        if (f24480b.get(str) == null || f24480b.get(str).longValue() == 0) {
            f24480b.put(str, 15000L);
        } else {
            Map<String, Long> map = f24480b;
            map.put(str, Long.valueOf(map.get(str).longValue() - 1000));
            if (f24480b.get(str) != null && f24480b.get(str).longValue() == 0) {
                Intent intent = new Intent();
                intent.setAction(d.f24392a);
                intent.putExtra(d.f24393b, str);
                intent.putExtra(d.f24394c, f24480b.get(str).longValue());
                MyApplication.k().sendBroadcast(intent);
                f24480b.remove(str);
                c();
                return;
            }
        }
        Intent intent2 = new Intent();
        intent2.setAction(d.f24392a);
        intent2.putExtra(d.f24393b, str);
        intent2.putExtra(d.f24394c, f24480b.get(str).longValue());
        MyApplication.k().sendBroadcast(intent2);
        Message message2 = new Message();
        message2.what = 1;
        message2.obj = str;
        sendMessageDelayed(message2, 1000L);
    }
}
