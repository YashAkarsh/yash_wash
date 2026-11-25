package com.haier.library.sumhttp.plugin.resp;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.uhome.account.okhttp.uAccountRequest;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27966d = "00000";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = uAccountRequest.KEY_RET_CODE)
    private String f27967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = uAccountRequest.KEY_RET_INFO)
    private String f27968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private String f27969c;

    public String a() {
        return this.f27967a;
    }

    public String b() {
        return this.f27969c;
    }

    public String c() {
        return this.f27968b;
    }

    public void d(String str) {
        this.f27967a = str;
    }

    public void e(String str) {
        this.f27969c = str;
    }

    public void f(String str) {
        this.f27968b = str;
    }

    public String toString() {
        return "ResponseData{code='" + this.f27967a + "', message='" + this.f27968b + "', data='" + this.f27969c + "'}";
    }
}
