package com.haier.library.sumhttp.response;

import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private String f28044d;

    public static h f(String str) {
        h hVar = new h();
        hVar.h(str);
        hVar.d("00000");
        hVar.e("成功");
        return hVar;
    }

    public String g() {
        return this.f28044d;
    }

    public void h(String str) {
        this.f28044d = str;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "BindInfoResponse{retCode='" + this.f28002a + "', retInfo='" + this.f28003b + "', payload=" + this.f28044d + '}';
    }
}
