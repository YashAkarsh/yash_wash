package com.haier.uhome.account.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.model.ReqModel;
import com.haier.uhome.account.model.uwsmodel.DeviceBaseInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    String a();

    String a(Context context);

    void a(Context context, CustomReqInfo customReqInfo, IAccountListener<String> iAccountListener);

    void a(Context context, IAccountListener iAccountListener);

    void a(Context context, ReqModel reqModel, IAccountListener<String> iAccountListener);

    void a(Context context, String str, IAccountListener iAccountListener);

    void a(Context context, String str, String str2, IAccountListener iAccountListener);

    void a(Context context, String str, String str2, String str3, IAccountListener iAccountListener);

    void a(Context context, String str, Map<String, Object> map, IAccountListener iAccountListener);

    String b();

    String b(Context context);

    void b(Context context, IAccountListener iAccountListener);

    void b(Context context, String str, IAccountListener<DeviceBaseInfo> iAccountListener);

    void b(Context context, String str, String str2, IAccountListener iAccountListener);

    void b(Context context, String str, String str2, String str3, IAccountListener iAccountListener);

    void c(Context context, IAccountListener<Bitmap> iAccountListener);

    void c(Context context, String str, IAccountListener iAccountListener);

    void c(Context context, String str, String str2, IAccountListener iAccountListener);

    void c(Context context, String str, String str2, String str3, IAccountListener iAccountListener);

    void d(Context context, IAccountListener iAccountListener);

    void d(Context context, String str, IAccountListener iAccountListener);

    void d(Context context, String str, String str2, IAccountListener iAccountListener);

    void e(Context context, String str, String str2, IAccountListener iAccountListener);
}
