package com.haier.uhome.nfc.service;

import android.text.TextUtils;
import com.haier.uhome.nfc.service.entity.NFCInfo;
import com.haier.uhome.nfc.service.entity.NFCInfoResp;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class NFCUtil {
    private static final int ERROR_CODE_PARAMS = -10001;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$parseNFCTagData$0(NFCInfo nFCInfo, ICallback iCallback, NFCInfoResp nFCInfoResp) {
        NFCInfo nFCInfoOf = NFCInfoResp.of(nFCInfoResp);
        nFCInfoOf.setCustom(nFCInfo.getCustom());
        iCallback.onSuccess(nFCInfoOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$parseNFCTagData$1(ICallback iCallback, int i7, String str) {
        iCallback.onFailure(uSDKError.a(i7, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateNFCDeviceInfo$2(ICallback iCallback, int i7, String str) {
        iCallback.onFailure(uSDKError.a(i7, str));
    }

    @Keep
    public static void parseNFCTagData(String str, final ICallback<NFCInfo> iCallback) {
        if (TextUtils.isEmpty(str)) {
            iCallback.onFailure(uSDKError.a(ERROR_CODE_PARAMS, "ndefRecord is required!"));
            return;
        }
        final NFCInfo nFCInfoA = a.a(str);
        if (TextUtils.isEmpty(nFCInfoA.getNFCSerialNumber())) {
            iCallback.onFailure(uSDKError.a(ERROR_CODE_PARAMS, "NFCSerialNumber is required!"));
        } else {
            HttpHelper.getNfc(nFCInfoA, new com.haier.library.sumhttp.plugin.a() { // from class: com.haier.uhome.nfc.service.b
                @Override // com.haier.library.sumhttp.plugin.a
                public final void a(Object obj) {
                    NFCUtil.lambda$parseNFCTagData$0(nFCInfoA, iCallback, (NFCInfoResp) obj);
                }
            }, new com.haier.library.sumhttp.plugin.b() { // from class: com.haier.uhome.nfc.service.c
                @Override // com.haier.library.sumhttp.plugin.b
                public final void a(int i7, String str2) {
                    NFCUtil.lambda$parseNFCTagData$1(iCallback, i7, str2);
                }
            });
        }
    }

    @Keep
    @Deprecated
    public static void updateNFCDeviceInfo(NFCInfo nFCInfo, final ICallback<Void> iCallback) {
        String str;
        if (nFCInfo == null) {
            str = "NFCInfo is required!";
        } else if (TextUtils.isEmpty(nFCInfo.getDeviceID())) {
            str = "deviceID is required!";
        } else if (TextUtils.isEmpty(nFCInfo.getNFCSerialNumber())) {
            str = "NFCSerialNumber is required!";
        } else if (TextUtils.isEmpty(nFCInfo.getMAC())) {
            str = "MAC is required!";
        } else {
            str = TextUtils.isEmpty(nFCInfo.getProductCode()) ? "productCode is required!" : null;
        }
        if (str != null) {
            iCallback.onFailure(uSDKError.a(ERROR_CODE_PARAMS, str));
        } else {
            iCallback.getClass();
            HttpHelper.a(nFCInfo, new com.haier.library.sumhttp.plugin.a() { // from class: com.haier.uhome.nfc.service.d
                @Override // com.haier.library.sumhttp.plugin.a
                public final void a(Object obj) {
                    iCallback.onSuccess((Void) obj);
                }
            }, new com.haier.library.sumhttp.plugin.b() { // from class: com.haier.uhome.nfc.service.e
                @Override // com.haier.library.sumhttp.plugin.b
                public final void a(int i7, String str2) {
                    NFCUtil.lambda$updateNFCDeviceInfo$2(iCallback, i7, str2);
                }
            });
        }
    }
}
