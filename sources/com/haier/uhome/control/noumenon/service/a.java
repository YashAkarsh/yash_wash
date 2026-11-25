package com.haier.uhome.control.noumenon.service;

import android.text.TextUtils;
import android.util.Base64;
import com.haier.uhome.smart.service.NativeService;
import com.haier.uhome.usdk.base.json.BasicReq;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NoumenonControlNative f29475a;

    /* JADX INFO: renamed from: com.haier.uhome.control.noumenon.service.a$a, reason: collision with other inner class name */
    private static class C0370a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f29476a = new a();

        private C0370a() {
        }
    }

    public static a a() {
        return C0370a.f29476a;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        String strBuildJson = basicReq.buildJson();
        try {
            Object objInvoke = NativeService.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Method method = NativeService.class.getMethod("callback", String.class);
            String str = new String(Base64.encode(strBuildJson.getBytes(), 2));
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            method.invoke(objInvoke, str);
        } catch (Exception e8) {
            e3.a.h("NativeService send error <%s>", e8.getMessage());
        }
        return 0;
    }

    private a() {
        NoumenonControlNative noumenonControlNative = new NoumenonControlNative();
        this.f29475a = noumenonControlNative;
        noumenonControlNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    public void a(String str) {
        this.f29475a.callback(str);
    }
}
