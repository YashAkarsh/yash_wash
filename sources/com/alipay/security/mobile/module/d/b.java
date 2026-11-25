package com.alipay.security.mobile.module.d;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f13914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t0.a f13915b;

    public b(String str, t0.a aVar) {
        this.f13914a = null;
        this.f13915b = null;
        this.f13914a = new File(str);
        this.f13915b = aVar;
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        File file = this.f13914a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f13914a.isDirectory() && this.f13914a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f13914a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f13915b.a(a(o0.b.a(this.f13914a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i7 = 0; i7 < size; i7++) {
                new File(this.f13914a, (String) arrayList.get(i7)).delete();
            }
        }
    }

    public final void b() {
        new Thread(new c(this)).start();
    }
}
