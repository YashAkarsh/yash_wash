package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKHTTPDNSManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.haier.library.okhttp.a.a f30920a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uSDKHTTPDNSManager f30924a = new uSDKHTTPDNSManager();

        private a() {
        }
    }

    public static uSDKHTTPDNSManager a() {
        return a.f30924a;
    }

    @Keep
    public void lookup(final String str, final IuSDKResultCallback<List<InetAddress>> iuSDKResultCallback) {
        if (a(str)) {
            new com.haier.library.common.thread.m<Void, Void, List<InetAddress>>(-2) { // from class: com.haier.uhome.usdk.api.uSDKHTTPDNSManager.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public List<InetAddress> doInBackground(Void... voidArr) {
                    try {
                        return uSDKHTTPDNSManager.this.f30920a.a(str);
                    } catch (UnknownHostException e8) {
                        e3.a.v("lookup excp -> %s", e8);
                        return null;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(List<InetAddress> list) {
                    if (iuSDKResultCallback == null) {
                        e3.a.o("lookupIp callback is null,so give up this callback.", new Object[0]);
                    } else if (com.haier.library.common.util.u.h(list)) {
                        iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_HTTP_DNS_ERROR);
                    } else {
                        iuSDKResultCallback.onSuccess(list);
                    }
                }
            }.execute(new Void[0]);
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.h6
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKHTTPDNSManager.a(iuSDKResultCallback);
                }
            });
        }
    }

    private uSDKHTTPDNSManager() {
        this.f30920a = new com.haier.library.okhttp.a.a();
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_INVALID_PARAM);
        }
    }
}
