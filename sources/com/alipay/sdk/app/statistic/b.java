package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.k;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f13623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f13624b;

    b(Context context, String str) {
        this.f13623a = context;
        this.f13624b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = new d();
        try {
            String strD = k.d(this.f13623a, a.f13622b, null);
            if (!TextUtils.isEmpty(strD) && dVar.b(this.f13623a, strD) != null) {
                k.e(this.f13623a, a.f13622b);
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(this.f13624b)) {
                return;
            }
            dVar.b(this.f13623a, this.f13624b);
        } catch (IOException unused2) {
            k.b(this.f13623a, a.f13622b, this.f13624b);
        } catch (Throwable unused3) {
        }
    }
}
