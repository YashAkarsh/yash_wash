package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Activity f13858a;

    public g(Activity activity) {
        super(activity);
        this.f13858a = activity;
    }

    public abstract void i();

    public abstract void j(String str);

    public void k(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f13858a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean l();
}
