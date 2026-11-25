package com.haier.uhome.usdk.base.service;

import android.content.Context;
import android.content.res.AssetManager;
import com.haier.library.common.thread.m;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.l;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import com.haier.uhome.usdk.base.json.req.DeviceGetProtocolTypeReq;
import com.haier.uhome.usdk.base.json.req.ModuleStartReq;
import com.haier.uhome.usdk.base.json.req.SetLogLevelReq;
import com.haier.uhome.usdk.base.json.resp.DeviceGetProtocolTypeResp;
import com.haier.uhome.usdk.base.json.resp.ModuleStartResp;
import com.haier.uhome.usdk.base.json.resp.SetLogLevelResp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f31347b = c.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f31346a = new AtomicBoolean(false);

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static d f31348a = new d();

        private a() {
        }
    }

    protected d() {
    }

    public static d p() {
        return a.f31348a;
    }

    public uSDKError q() {
        a();
        if (!this.f31346a.compareAndSet(false, true)) {
            e3.a.e("SDKBaseService start server is already start so return ok", new Object[0]);
            return ErrorConst.RET_USDK_OK.toError();
        }
        e3.a.e("SDKBaseService start", new Object[0]);
        int iB = this.f31347b.b();
        e3.a.e("SDKBaseService start : ret %d", Integer.valueOf(iB));
        return ErrorConst.getErrorConstById(iB).toError();
    }

    public ErrorConst r() {
        return ErrorConst.RET_USDK_OK;
    }

    public ErrorConst s() {
        if (!this.f31346a.compareAndSet(true, false)) {
            e3.a.e("SDKBaseService start server is already stop so return ok", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        e3.a.e("SDKBaseService unInit", new Object[0]);
        int iC = this.f31347b.c();
        e3.a.e("SDKBaseService unInit : ret %d", Integer.valueOf(iC));
        return ErrorConst.getErrorConstById(iC);
    }

    public long t() {
        e3.a.e("SDKBaseService getProfileHandle", new Object[0]);
        long jD = this.f31347b.d();
        e3.a.e("SDKBaseService getProfileHandle : handle %d", Long.valueOf(jD));
        return jD;
    }

    private void a() {
        e3.a.e("SDKBaseService loadFiles start", new Object[0]);
        a(e.a().b());
        b(e.a().b());
        e3.a.e("SDKBaseService loadFiles end ", new Object[0]);
    }

    private void b(final Context context) {
        File fileA = com.haier.uhome.usdk.base.utils.f.a(context, com.haier.uhome.usdk.base.a.N);
        if (fileA.exists() || fileA.mkdirs()) {
            m.execute(new Runnable() { // from class: com.haier.uhome.usdk.base.service.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31385a.e(context);
                }
            });
        } else {
            e3.a.h("create SDK OTA file dir failed", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void f(Context context) {
        AssetManager assets = context.getAssets();
        File fileB = com.haier.uhome.usdk.base.utils.f.b(context);
        try {
            String[] list = assets.list(com.haier.uhome.usdk.base.a.M);
            if (list == null) {
                return;
            }
            for (String str : list) {
                a(assets, fileB, com.haier.uhome.usdk.base.a.M, str);
            }
        } catch (IOException e8) {
            e3.a.v("copyProFile error -> %s", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(Context context) {
        AssetManager assets = context.getAssets();
        File fileA = com.haier.uhome.usdk.base.utils.f.a(context, com.haier.uhome.usdk.base.a.N);
        try {
            String[] list = assets.list(com.haier.uhome.usdk.base.a.N);
            if (list == null) {
                return;
            }
            for (String str : list) {
                a(assets, fileA, com.haier.uhome.usdk.base.a.N, str);
            }
        } catch (IOException e8) {
            e3.a.v("copyOTAFile error -> %s", e8);
        }
    }

    public void e(final o oVar) {
        ModuleStartReq moduleStartReq = new ModuleStartReq();
        moduleStartReq.setClientId(e.a().k());
        moduleStartReq.setProfileUrl(e.a().m());
        moduleStartReq.setProfileSavePath(e.a().q());
        if (e.a().c() == 0) {
            moduleStartReq.setAppId(e.a().i());
            moduleStartReq.setAppKey(e.a().h());
            moduleStartReq.setAppVer(e.a().j());
            moduleStartReq.setSdkVer(VersionManager.getInstance().getSDKVersion());
            moduleStartReq.setSdkType(VersionManager.getInstance().getSDKTypeName());
            moduleStartReq.setProfileM_ApiLevel(1);
        }
        moduleStartReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.a.a().a(moduleStartReq, new l() { // from class: com.haier.uhome.usdk.base.service.h
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                d.b(oVar, basicResp);
            }
        });
    }

    private void a(final Context context) {
        File fileB = com.haier.uhome.usdk.base.utils.f.b(context);
        if (!fileB.exists() && !fileB.mkdirs()) {
            e3.a.h("create SDK file dir failed", new Object[0]);
        } else {
            m.execute(new Runnable() { // from class: com.haier.uhome.usdk.base.service.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31388a.f(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(o oVar, BasicResp basicResp) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.getErrorConstById(((ModuleStartResp) basicResp).getErrNo()));
    }

    public void c(String str, final ICallback<com.haier.uhome.usdk.base.api.a> iCallback) {
        if (com.haier.library.common.util.c.m(str)) {
            e3.a.v("getProtocolType uplusId is null", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_UPLUSID_INVALID.toError());
        } else {
            DeviceGetProtocolTypeReq deviceGetProtocolTypeReq = new DeviceGetProtocolTypeReq();
            deviceGetProtocolTypeReq.setUplusId(str);
            deviceGetProtocolTypeReq.setNativeSender(this.f31347b);
            com.haier.uhome.usdk.base.d.a.a().a(deviceGetProtocolTypeReq, new l() { // from class: com.haier.uhome.usdk.base.service.k
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    d.a(iCallback, basicResp);
                }
            });
        }
    }

    private void a(AssetManager assetManager, File file, String str, String str2) {
        File file2 = new File(file, str2);
        if (file2.exists()) {
            e3.a.e("copy file:%s done, file already exists", str2);
            return;
        }
        e3.a.e("begin to copy file:%s", str2);
        try {
            InputStream inputStreamOpen = assetManager.open(String.format("%s/%s", str, str2));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[512];
                    while (true) {
                        int i7 = inputStreamOpen.read(bArr);
                        if (-1 != i7) {
                            fileOutputStream.write(bArr, 0, i7);
                        } else {
                            fileOutputStream.flush();
                            e3.a.e("copy file:%s done.", file2.getAbsolutePath());
                            fileOutputStream.close();
                            inputStreamOpen.close();
                            return;
                        }
                        try {
                            throw th;
                        } catch (Throwable th) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                throw th6;
            }
        } catch (Exception e8) {
            e3.a.v("copy  Exception exp:%e", e8);
        }
    }

    public void a(int i7, final o oVar) {
        SetLogLevelReq setLogLevelReq = new SetLogLevelReq();
        setLogLevelReq.setLogLevel(i7);
        setLogLevelReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.a.a().a(setLogLevelReq, new l() { // from class: com.haier.uhome.usdk.base.service.j
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                d.a(oVar, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(o oVar, BasicResp basicResp) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.getErrorConstById(((SetLogLevelResp) basicResp).getErrNo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        DeviceGetProtocolTypeResp deviceGetProtocolTypeResp = (DeviceGetProtocolTypeResp) basicResp;
        if (basicResp.getErrNo() == ErrorConst.RET_USDK_OK.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.usdk.base.api.a>) iCallback, deviceGetProtocolTypeResp.getDeviceProtocolType() == 1 ? com.haier.uhome.usdk.base.api.a.APP_PROT_STD : com.haier.uhome.usdk.base.api.a.APP_PROT_SIXID);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, com.haier.uhome.usdk.base.utils.c.a(basicResp));
        }
    }
}
