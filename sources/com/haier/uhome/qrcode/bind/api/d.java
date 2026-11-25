package com.haier.uhome.qrcode.bind.api;

import android.util.Log;
import com.haier.uhome.qrcode.bind.api.a;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import retrofit2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T extends a> implements retrofit2.d<T> {
    public abstract void a(g gVar);

    public abstract void a(r<T> rVar);

    @Override // retrofit2.d
    public void onFailure(retrofit2.b<T> bVar, Throwable th) {
        g gVar = new g();
        if (th instanceof SocketTimeoutException) {
            gVar.a("SocketTimeoutException");
        } else if (th instanceof ConnectException) {
            gVar.a("ConnectException");
        } else if (th instanceof RuntimeException) {
            gVar.a("RuntimeException");
        } else {
            gVar.a(th.getMessage());
        }
        gVar.b(th.getMessage());
        a(gVar);
    }

    @Override // retrofit2.d
    public void onResponse(retrofit2.b<T> bVar, r<T> rVar) {
        g gVar = new g();
        if (rVar.i().code() != 200) {
            onFailure(bVar, new RuntimeException("response error,detail = " + rVar.i().toString()));
            return;
        }
        Log.d("QrCodeBindCallback", "onResponse:" + rVar.a().toString());
        if ("00000".equals(rVar.a().f29564a)) {
            a(rVar);
            return;
        }
        gVar.a(rVar.a().f29564a);
        gVar.b(rVar.a().f29565b);
        a(gVar);
    }
}
