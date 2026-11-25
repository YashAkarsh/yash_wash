package com.haier.uhome.control.cloud.b;

import android.os.Environment;
import com.haier.globalwasher.presenter.o;
import com.haier.library.common.thread.m;
import com.haier.library.common.util.r;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static FOTAInfo b(DevCheckFWVerResp devCheckFWVerResp) {
        if (devCheckFWVerResp == null) {
            return null;
        }
        return new FOTAInfo.a().a(devCheckFWVerResp).a();
    }

    public static void a(String str, int i7, final ICallback<FOTAInfo> iCallback) {
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl("https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/ota/v1/protected/fota/checkDevFMVersion");
        HashMap map = new HashMap(2);
        map.put(o.f25218y, str);
        customReqInfo.setBody(map);
        customReqInfo.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setNotUwsType(false);
        customReqInfo.setTimeout(i7);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.control.cloud.b.c.1
            /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
            
                if (r5 == null) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
            
                if (r5 == null) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
            
                r1.onFailure(com.haier.uhome.usdk.base.api.ErrorConst.ERR_INTERNAL.toError());
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
            
                r1.onSuccess(r5);
             */
            /* JADX WARN: Undo finally extract visitor
            java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
            	at jadx.core.utils.Pair.hashCode(Pair.java:35)
            	at java.base/java.util.HashMap.hash(HashMap.java:338)
            	at java.base/java.util.HashMap.getNode(HashMap.java:602)
            	at java.base/java.util.HashMap.containsKey(HashMap.java:628)
            	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
            	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
            	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
            	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
            	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
            	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
             */
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponseSuccess(java.lang.String r5) {
                /*
                    r4 = this;
                    r0 = 0
                    com.haier.library.json.e r5 = com.haier.library.json.a.t(r5)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                    java.lang.String r1 = "devFWVersionDto"
                    java.lang.String r5 = r5.R0(r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                    java.lang.Class<com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp> r1 = com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp.class
                    java.lang.Object r5 = com.haier.library.json.a.z(r5, r1)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                    com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp r5 = (com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp) r5     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                    com.haier.uhome.control.cloud.api.FOTAInfo r5 = com.haier.uhome.control.cloud.b.c.a(r5)
                    if (r5 != 0) goto L25
                L19:
                    com.haier.uhome.usdk.base.api.ICallback r5 = r1
                    com.haier.uhome.usdk.base.api.ErrorConst r0 = com.haier.uhome.usdk.base.api.ErrorConst.ERR_INTERNAL
                    com.haier.uhome.usdk.base.api.uSDKError r0 = r0.toError()
                    r5.onFailure(r0)
                    goto L40
                L25:
                    com.haier.uhome.usdk.base.api.ICallback r0 = r1
                    r0.onSuccess(r5)
                    goto L40
                L2b:
                    r5 = move-exception
                    goto L41
                L2d:
                    r5 = move-exception
                    java.lang.String r1 = "checkBoardFOTAInfo result parse to json error -> %s"
                    r2 = 1
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L2b
                    r3 = 0
                    r2[r3] = r5     // Catch: java.lang.Throwable -> L2b
                    e3.a.v(r1, r2)     // Catch: java.lang.Throwable -> L2b
                    com.haier.uhome.control.cloud.api.FOTAInfo r5 = com.haier.uhome.control.cloud.b.c.a(r0)
                    if (r5 != 0) goto L25
                    goto L19
                L40:
                    return
                L41:
                    com.haier.uhome.control.cloud.api.FOTAInfo r0 = com.haier.uhome.control.cloud.b.c.a(r0)
                    if (r0 != 0) goto L53
                    com.haier.uhome.usdk.base.api.ICallback r0 = r1
                    com.haier.uhome.usdk.base.api.ErrorConst r1 = com.haier.uhome.usdk.base.api.ErrorConst.ERR_INTERNAL
                    com.haier.uhome.usdk.base.api.uSDKError r1 = r1.toError()
                    r0.onFailure(r1)
                    goto L58
                L53:
                    com.haier.uhome.usdk.base.api.ICallback r1 = r1
                    r1.onSuccess(r0)
                L58:
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.haier.uhome.control.cloud.b.c.AnonymousClass1.onResponseSuccess(java.lang.String):void");
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                uSDKError usdkerror = new uSDKError(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.getErrorId());
                usdkerror.a(respCommonModel.getRetCode());
                usdkerror.setDescription(respCommonModel.getRetInfo());
                iCallback.onFailure(usdkerror);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                uSDKError usdkerror = new uSDKError(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.getErrorId());
                usdkerror.a(respCommonModel.getRetCode());
                usdkerror.setDescription(respCommonModel.getRetInfo());
                iCallback.onFailure(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, String str2, String str3, int i7, ICallback iCallback) {
        File fileB = b();
        try {
            File fileH = com.haier.library.okhttp.api.e.m(30L, TimeUnit.SECONDS).h(str, fileB.getPath(), URLEncoder.encode(str, "UTF-8"));
            File fileA = a(fileB, fileH, str2, str3, i7);
            if (fileH != null) {
                iCallback.onSuccess(new b(fileH, fileA));
            } else {
                iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL.toError());
            }
        } catch (Exception e8) {
            e3.a.g("Download file error", e8);
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, ICallback iCallback) {
        File fileB = b();
        try {
            File fileH = com.haier.library.okhttp.api.e.m(30L, TimeUnit.SECONDS).h(str, fileB.getPath(), URLEncoder.encode(str, "UTF-8"));
            if (fileH != null) {
                iCallback.onSuccess(fileH);
            } else {
                iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL.toError());
            }
        } catch (Exception e8) {
            e3.a.g("Download file error", e8);
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL.toError());
        }
    }

    public static File a(String str) {
        try {
            return new File(b(), URLEncoder.encode(str, "UTF-8"));
        } catch (Exception e8) {
            e3.a.g("Create file name encode error", e8);
            return null;
        }
    }

    public static File a() {
        return new File(b(), "IoT-uPlugBLE_V1.0.01_H2.0.00_image_all_20200820.bin");
    }

    public static void a(final String str, final String str2, final String str3, final int i7, final ICallback<b> iCallback) {
        m.execute(new Runnable() { // from class: com.haier.uhome.control.cloud.b.d
            @Override // java.lang.Runnable
            public final void run() {
                c.b(str, str2, str3, i7, iCallback);
            }
        });
    }

    private static File b() {
        File externalFilesDir = com.haier.uhome.usdk.base.service.e.a().b().getExternalFilesDir("ota");
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "ota");
        if (!file.exists()) {
            e3.a.e("Create external storage ota dir %s", Boolean.valueOf(file.mkdir()));
        }
        return file;
    }

    public static void a(final String str, final ICallback<File> iCallback) {
        m.execute(new Runnable() { // from class: com.haier.uhome.control.cloud.b.e
            @Override // java.lang.Runnable
            public final void run() {
                c.b(str, iCallback);
            }
        });
    }

    private static File a(File file, File file2, String str, String str2, int i7) {
        try {
            String name = file2.getName();
            File file3 = new File(file, name.substring(0, name.lastIndexOf(com.alibaba.android.arouter.utils.b.f12515h)).concat("-decode.bin"));
            byte[] bArrB = com.haier.library.common.util.a.b(r.f(file2), str, str2);
            if (bArrB != null && bArrB.length != 0) {
                byte[] bArr = new byte[i7];
                System.arraycopy(bArrB, 0, bArr, 0, i7);
                r.e(bArr, file3);
                e3.a.e("Ble ota: decode file: %s, len: %d", file3.getName(), Long.valueOf(file3.length()));
                return file3;
            }
            e3.a.v("Ble ota: decode file data is null!", new Object[0]);
            return null;
        } catch (Exception e8) {
            e3.a.v("Decode file error", e8);
            return null;
        }
    }

    public static void a(String str, String str2, int i7, int i8, final s sVar) {
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl("https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/channel-m2m/dev-rpt-gw/add/device/upgrade-status");
        HashMap map = new HashMap(4);
        map.put(o.f25218y, str);
        map.put("upgradeSn", str2);
        map.put("status", Integer.valueOf(i7));
        map.put("errNo", Integer.valueOf(i8));
        customReqInfo.setBody(map);
        customReqInfo.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setNotUwsType(false);
        customReqInfo.setTimeout(30L);
        customReqInfo.setApiVersion("v1");
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.control.cloud.b.c.2
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str3) {
                e3.a.e("Ota stage: submit upgrade result : %s", str3);
                a((RespCommonModel) com.haier.library.json.a.z(str3, RespCommonModel.class));
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.u("Ota stage: submit upgrade error, code: %s, desc: %s", respCommonModel.getRetCode(), respCommonModel.getRetInfo(), new Object[0]);
                a(respCommonModel);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.u("Ota stage: submit upgrade error, code: %s, desc: %s", respCommonModel.getRetCode(), respCommonModel.getRetInfo(), new Object[0]);
                a(respCommonModel);
            }

            private void a(RespCommonModel respCommonModel) {
                s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.onCallback(com.haier.library.common.util.c.c("00000", respCommonModel.getRetCode()) ? uSDKError.RET_USDK_OK : ErrorConst.ERR_INTERNAL.toError());
                }
            }
        });
    }

    public static <T> void a(Map<String, Object> map, m3.a<T> aVar) {
        com.haier.library.sumhttp.request.a.h().v(map, "", aVar);
    }
}
