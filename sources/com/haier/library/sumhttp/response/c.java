package com.haier.library.sumhttp.response;

import com.haier.uhome.account.okhttp.uAccountRequest;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f28001c = "00000";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = uAccountRequest.KEY_RET_CODE)
    protected String f28002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = uAccountRequest.KEY_RET_INFO)
    protected String f28003b;

    public String a() {
        return this.f28002a;
    }

    public String b() {
        return this.f28003b;
    }

    public boolean c() {
        return "00000".equals(this.f28002a);
    }

    public void d(String str) {
        this.f28002a = str;
    }

    public void e(String str) {
        this.f28003b = str;
    }

    public String toString() {
        return "CommonResponse{retCode='" + this.f28002a + "', retInfo='" + this.f28003b + "'}";
    }
}
