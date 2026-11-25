package com.haier.library.okhttp.b.e;

import com.haier.uhome.account.api.Const;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private f() {
    }

    public static boolean a(String str) {
        return str.equals(Const.HTTP_REQUEST_TYPE_POST) || str.equals(com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return str.equals(Const.HTTP_REQUEST_TYPE_POST) || str.equals("PUT") || str.equals(com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean c(String str) {
        return (str.equals(Const.HTTP_REQUEST_TYPE_GET) || str.equals("HEAD")) ? false : true;
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return !str.equals("PROPFIND");
    }
}
