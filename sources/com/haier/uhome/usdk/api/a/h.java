package com.haier.uhome.usdk.api.a;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c implements m3.a<com.haier.library.sumhttp.response.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICallback<List<uSDKDevice>> f30400b;

    private void j() {
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.a.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f30424a.i();
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public void a(uSDKDevice usdkdevice, ICallback<List<uSDKDevice>> iCallback) {
        if (usdkdevice == null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        int channel = usdkdevice.getChannel();
        if (!com.haier.uhome.usdk.base.api.e.a(channel, 4) && !com.haier.uhome.usdk.base.api.e.a(channel, 16)) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_SUPPORT_GROUP.toError());
            return;
        }
        if (g()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!f()) {
            e3.a.v("query group current object occur parallel invoked!", new Object[0]);
            return;
        }
        this.f30399a = usdkdevice;
        this.f30400b = iCallback;
        a(15L);
        i();
    }

    @Override // m3.a
    public void onError(Exception exc) {
        e3.a.g("GroupQueryHandler query error %s", exc);
        if (c()) {
            return;
        }
        if (exc instanceof SocketTimeoutException) {
            j();
            return;
        }
        if (exc instanceof ConnectException) {
            j();
            return;
        }
        if (exc instanceof SocketException) {
            j();
        } else if (exc instanceof IOException) {
            j();
        } else {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        com.haier.library.sumhttp.request.a.h().a(eVarA.i(), eVarA.h(), eVarA.l(), eVarA.g(), this.f30399a.getDeviceId(), "", this);
    }

    @Override // m3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.haier.library.sumhttp.response.d dVar) {
        e3.a.e("group query return: timeout = %s,  data = %s", Boolean.valueOf(c()), dVar);
        if (c()) {
            return;
        }
        if (dVar.c()) {
            a(dVar.f());
        } else {
            uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
            error.a(dVar.b());
            this.f30400b.onFailure(error);
        }
        h();
    }

    private void a(List<com.haier.library.sumhttp.response.d.a> list) {
        if (com.haier.library.common.util.u.h(list)) {
            this.f30400b.onFailure(ErrorConst.ERR_USDK_NO_GROUPABLE_DEVICE.toError());
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.haier.library.sumhttp.response.d.a> it = list.iterator();
        while (it.hasNext()) {
            uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(it.next().a());
            if (device != null) {
                arrayList.add(device);
            }
        }
        this.f30400b.onSuccess(arrayList);
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        this.f30400b.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
        h();
    }
}
