package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* JADX INFO: loaded from: classes.dex */
class i implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f13861a;

    i(h hVar) {
        this.f13861a = hVar;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j7) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f13861a.f13858a.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
