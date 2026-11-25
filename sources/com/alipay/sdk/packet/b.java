package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13718b;

    public b(String str, String str2) {
        this.f13717a = str;
        this.f13718b = str2;
    }

    public String a() {
        return this.f13717a;
    }

    public String b() {
        return this.f13718b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f13718b)) {
            return null;
        }
        try {
            return new JSONObject(this.f13718b);
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f13717a, this.f13718b);
    }
}
