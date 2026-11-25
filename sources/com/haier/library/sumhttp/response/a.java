package com.haier.library.sumhttp.response;

import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private o3.a f27999d;

    public o3.a f() {
        return this.f27999d;
    }

    public void g(o3.a aVar) {
        this.f27999d = aVar;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "AppTypeInfoResponse{payload=" + this.f27999d + ", retCode='" + this.f28002a + "', retInfo='" + this.f28003b + "'}";
    }
}
