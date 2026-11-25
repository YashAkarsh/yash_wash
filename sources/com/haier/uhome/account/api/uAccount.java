package com.haier.uhome.account.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.model.ReqModel;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.account.model.RespModel;
import com.haier.uhome.account.model.uacmodel.UacDevice;
import com.haier.uhome.account.model.uacmodel.UacUserBase;
import com.haier.uhome.account.model.uwsmodel.DeviceBaseInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uAccount {
    private static com.haier.uhome.account.a.a.a sAccountService = com.haier.uhome.account.a.a.c();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uAccount f28108a = new uAccount();

        private a() {
        }
    }

    public static uAccount getSingleInstance() {
        return a.f28108a;
    }

    public void applyActivationCode(Context context, String str, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.a(context, str, iAccountListener);
    }

    public void applyBindMobileCode(Context context, String str, String str2, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.d(context, str, str2, iAccountListener);
    }

    public void bindDevice(Context context, String str, String str2, String str3, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.a(context, str, str2, str3, iAccountListener);
    }

    public void bindMobile(Context context, String str, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.c(context, str, iAccountListener);
    }

    public void captcha(Context context, IAccountListener<Bitmap> iAccountListener) {
        sAccountService.c(context, iAccountListener);
    }

    public String findPassword(Context context) {
        return sAccountService.a(context);
    }

    public String getAccessToken() {
        return sAccountService.a();
    }

    public void getDeviceBaseInfo(Context context, String str, IAccountListener<DeviceBaseInfo> iAccountListener) {
        sAccountService.b(context, str, iAccountListener);
    }

    public void getDeviceList(Context context, IAccountListener<RespModel> iAccountListener) {
        sAccountService.d(context, iAccountListener);
    }

    public void getUserBaseInfo(Context context, IAccountListener<UacUserBase> iAccountListener) {
        sAccountService.b(context, iAccountListener);
    }

    public String getUserId() {
        return sAccountService.b();
    }

    public void login(Context context, String str, String str2, IAccountListener<String> iAccountListener) {
        sAccountService.a(context, str, str2, iAccountListener);
    }

    public void logout(Context context, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.a(context, iAccountListener);
    }

    public String modifyPassword(Context context) {
        return sAccountService.b(context);
    }

    public void register(Context context, String str, String str2, String str3, IAccountListener<RespModel> iAccountListener) {
        sAccountService.c(context, str, str2, str3, iAccountListener);
    }

    public void registerAndlogin(Context context, String str, String str2, IAccountListener<String> iAccountListener) {
        sAccountService.c(context, str, str2, iAccountListener);
    }

    public void sendCustomRequest(Context context, String str, Map<String, Object> map, IAccountListener<String> iAccountListener) {
        sAccountService.a(context, str, map, iAccountListener);
    }

    public void sendCustomRequestBody(Context context, ReqModel reqModel, IAccountListener<String> iAccountListener) {
        sAccountService.a(context, reqModel, iAccountListener);
    }

    public void unbindDevice(Context context, String str, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.d(context, str, iAccountListener);
    }

    public void updateNickname(Context context, String str, String str2, IAccountListener<RespCommonModel> iAccountListener) {
        sAccountService.e(context, str, str2, iAccountListener);
    }

    public void getDeviceList(Context context, String str, String str2, IAccountListener<UacDevice[]> iAccountListener) {
        sAccountService.b(context, str, str2, iAccountListener);
    }

    public void login(Context context, String str, String str2, String str3, IAccountListener<RespModel> iAccountListener) {
        sAccountService.b(context, str, str2, str3, iAccountListener);
    }

    public void sendCustomRequest(Context context, CustomReqInfo customReqInfo, IAccountListener<String> iAccountListener) {
        sAccountService.a(context, customReqInfo, iAccountListener);
    }
}
