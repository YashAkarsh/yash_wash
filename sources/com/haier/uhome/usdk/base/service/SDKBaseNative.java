package com.haier.uhome.usdk.base.service;

import com.haier.library.common.util.w;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SDKBaseNative extends BaseNative {
    private static com.haier.library.okhttp.a.a DNS = new com.haier.library.okhttp.a.a();

    protected SDKBaseNative() {
    }

    public static native void bleSearchLogOutSpin();

    public static native String genPasswdMd5(String str);

    public static String resolveIpByName(String str) {
        try {
            List<InetAddress> listA = DNS.a(str);
            if (listA == null) {
                return null;
            }
            return listA.get(0).getHostAddress();
        } catch (Exception e8) {
            e3.a.h("resolveIpByName Exception: " + e8.toString(), new Object[0]);
            return w.e(str);
        }
    }

    public native long getProfileHandle();

    public native int init();

    public native int sendRequest(String str);

    public native int setCertPath(String str);

    public native int unInit();
}
