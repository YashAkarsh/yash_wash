package com.alipay.sdk.app;

import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13605a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.alipay.sdk.data.a.C0156a f13606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.alipay.sdk.data.a.C0156a f13607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List<com.alipay.sdk.data.a.C0156a> f13608d;

    static {
        com.alipay.sdk.data.a.C0156a c0156a = new com.alipay.sdk.data.a.C0156a("com.eg.android.AlipayGphone", 73, j0.a.f34212h);
        f13606b = c0156a;
        f13607c = new com.alipay.sdk.data.a.C0156a(PayResultActivity.f13559c, 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        f13608d = Collections.singletonList(c0156a);
    }

    public static String a() {
        return f13605a;
    }

    public static void b(String str) {
        f13605a = str;
        str.hashCode();
        if (str.equals("hk")) {
            f13608d = Collections.singletonList(f13607c);
        } else {
            f13608d = Collections.singletonList(f13606b);
        }
    }

    public static boolean c() {
        return TextUtils.isEmpty(f13605a) || TextUtils.equals("cn", f13605a);
    }
}
