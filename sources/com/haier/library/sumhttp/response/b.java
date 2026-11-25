package com.haier.library.sumhttp.response;

import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private o3.b f28000d;

    public o3.b f() {
        return this.f28000d;
    }

    public void g(o3.b bVar) {
        this.f28000d = bVar;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "BindInfoResponse{retCode='" + this.f28002a + "', retInfo='" + this.f28003b + "', bindInfo=" + this.f28000d + '}';
    }
}
