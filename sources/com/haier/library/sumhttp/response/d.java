package com.haier.library.sumhttp.response;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.globalwasher.presenter.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private List<a> f28004d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g3.b(name = o.f25218y)
        private String f28005a;

        public String a() {
            return this.f28005a;
        }

        public void b(String str) {
            this.f28005a = str;
        }

        public String toString() {
            return "PayloadBean{deviceId='" + this.f28005a + "'}";
        }
    }

    public List<a> f() {
        return this.f28004d;
    }

    public void g(List<a> list) {
        this.f28004d = list;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "CreateGroupDevListResponse{payload=" + this.f28004d + ", retCode='" + this.f28002a + "', retInfo='" + this.f28003b + "'}";
    }
}
