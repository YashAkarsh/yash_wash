package com.haier.uhome.config.service;

import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f28658a = 60;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f28659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f28660c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static m f28661a = new m();

        private a() {
        }
    }

    private enum b {
        SMART_LINK_STATUS_NOT_STARTED,
        SMART_LINK_STATUS_REQUEST_SERVER
    }

    public static m a() {
        return a.f28661a;
    }

    private synchronized b c() {
        return this.f28660c;
    }

    public uSDKError b() {
        b bVarC = c();
        b bVar = b.SMART_LINK_STATUS_NOT_STARTED;
        if (bVarC == bVar) {
            return ErrorConst.RET_USDK_OK.toError();
        }
        int iB = this.f28659b.b();
        if (iB == 0) {
            a(bVar);
        }
        return ErrorConst.getErrorConstById(iB).toError();
    }

    private m() {
        this.f28659b = n.a();
        ConfigProtocol.registerSmartlink();
        a(b.SMART_LINK_STATUS_NOT_STARTED);
    }

    private synchronized void a(b bVar) {
        this.f28660c = bVar;
    }

    public uSDKError a(String str, String str2, String str3, String str4, List<String> list, boolean z7, int i7, int i8) {
        synchronized (this) {
            b bVarC = c();
            b bVar = b.SMART_LINK_STATUS_NOT_STARTED;
            if (bVarC != bVar) {
                ErrorConst errorConst = ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS;
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "SmartLink error, error id is <%d>", Integer.valueOf(errorConst.getErrorId()));
                return errorConst.toError();
            }
            a(b.SMART_LINK_STATUS_REQUEST_SERVER);
            e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "configDeviceBySmartLink begin......", new Object[0]);
            int iA = this.f28659b.a(str, str2, str3, str4, com.haier.uhome.usdk.base.utils.f.a(list), z7 ? 1 : 0, i7, Math.min(i8, 60));
            e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "configDeviceBySmartLink end ......ret = %d", Integer.valueOf(iA));
            ErrorConst errorConst2 = ErrorConst.RET_USDK_OK;
            uSDKError error = errorConst2.toError();
            if (iA != 0) {
                error = ErrorConst.ERR_INTERNAL.toError();
                error.a("ret = " + iA);
            }
            if (!error.a(errorConst2)) {
                a(bVar);
            }
            return error;
        }
    }
}
