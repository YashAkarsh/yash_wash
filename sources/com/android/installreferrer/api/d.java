package com.android.installreferrer.api;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13948b = "install_referrer";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13949c = "referrer_click_timestamp_seconds";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13950d = "install_begin_timestamp_seconds";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f13951a;

    public d(Bundle bundle) {
        this.f13951a = bundle;
    }

    public long a() {
        return this.f13951a.getLong(f13950d);
    }

    public String b() {
        return this.f13951a.getString(f13948b);
    }

    public long c() {
        return this.f13951a.getLong(f13949c);
    }
}
