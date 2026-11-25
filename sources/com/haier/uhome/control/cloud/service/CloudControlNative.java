package com.haier.uhome.control.cloud.service;

import com.haier.uhome.usdk.base.service.BaseNative;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CloudControlNative extends BaseNative {
    private static final com.haier.library.okhttp.a.a DNS = new com.haier.library.okhttp.a.a();
    private long handle;

    public static int onHttpReq(int i7, String str, String str2, String str3, long j7, int i8, int i9, long j8, long j9, long j10, String str4) {
        d.a(i7, str, str2, str3, j7, i8, i9, j8, j9, j10, str4);
        return 0;
    }

    public static String resolveIpByName(String str) {
        try {
            List<InetAddress> listA = DNS.a(str);
            if (listA == null) {
                return null;
            }
            return listA.get(0).getHostAddress();
        } catch (Exception e8) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "resolveIpByName Exception: " + e8.toString(), new Object[0]);
            return com.haier.library.common.util.w.e(str);
        }
    }

    public native int caeCloudState();

    public native int devControl(String str);

    public native int devLogin(String str, String str2);

    public native int devLogout(String str);

    public long getHandle() {
        return this.handle;
    }

    @Override // com.haier.uhome.usdk.base.service.BaseNative
    protected String getLogMainModule() {
        return com.haier.uhome.control.base.b.a.f28847a;
    }

    @Override // com.haier.uhome.usdk.base.service.BaseNative
    protected String getLogSubModule() {
        return com.haier.uhome.control.cloud.a.f29013k;
    }

    public native void sendHttpResp(int i7, int i8, String str, long j7);

    public native int userCreate(long j7, int i7, int i8, String str, String str2, String str3, int i9);

    public native void userDelete();

    public native int userStart();

    public native int userStop();
}
