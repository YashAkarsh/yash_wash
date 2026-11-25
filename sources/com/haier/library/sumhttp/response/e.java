package com.haier.library.sumhttp.response;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f28006e = "strategy";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = MessengerShareContentUtility.ATTACHMENT_PAYLOAD)
    private Map<String, o3.e> f28007d;

    public o3.e f() {
        Map<String, o3.e> map = this.f28007d;
        if (map != null) {
            return map.get(f28006e);
        }
        return null;
    }

    public Map<String, o3.e> g() {
        return this.f28007d;
    }

    public void h(Map<String, o3.e> map) {
        this.f28007d = map;
    }
}
