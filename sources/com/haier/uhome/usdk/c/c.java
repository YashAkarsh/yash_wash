package com.haier.uhome.usdk.c;

import android.util.SparseArray;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31981a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31982b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseArray<com.haier.uhome.usdk.bind.a.a> f31983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f31984d = 1000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f31985e = 2000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f31986f = 2001;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f31987g = 2002;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f31988h = 2003;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f31989i = 2004;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f31990j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f31991k = 3000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f31992l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f31993m = 4000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f31994n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f31995o = 5000;

    static {
        SparseArray<com.haier.uhome.usdk.bind.a.a> sparseArray = new SparseArray<>();
        f31983c = sparseArray;
        sparseArray.append(1000, new com.haier.uhome.usdk.bind.a.a(1000, "正常", "正常"));
        sparseArray.append(1001, new com.haier.uhome.usdk.bind.a.a(1001, "无路由", "路由断电等找不到路由器"));
        sparseArray.append(1002, new com.haier.uhome.usdk.bind.a.a(1002, "路由密码错误（路由信息被修改）", "用户修改路由信息导致无法连上路由"));
        sparseArray.append(1003, new com.haier.uhome.usdk.bind.a.a(1003, "连接不上主网关", "连接主网关失败"));
        sparseArray.append(1004, new com.haier.uhome.usdk.bind.a.a(1004, "连接不上接入网关", "连接接入网关失败"));
        sparseArray.append(f31985e, new com.haier.uhome.usdk.bind.a.a(f31985e, "正常", "正常进配置中"));
        sparseArray.append(2001, new com.haier.uhome.usdk.bind.a.a(2001, "无路由", "收到配置信息但是找不到路由"));
        sparseArray.append(2002, new com.haier.uhome.usdk.bind.a.a(2002, "配置信息错误", "密码错误"));
        sparseArray.append(2003, new com.haier.uhome.usdk.bind.a.a(2003, "配置信息疑似错误", "疑似密码错误"));
        sparseArray.append(f31989i, new com.haier.uhome.usdk.bind.a.a(f31989i, "配网信息不完整", "配置信息不完整"));
        sparseArray.append(3000, new com.haier.uhome.usdk.bind.a.a(3000, "正常", "可触发"));
        sparseArray.append(3001, new com.haier.uhome.usdk.bind.a.a(3001, "无路由", "收到配置信息但找不到路由"));
        sparseArray.append(3002, new com.haier.uhome.usdk.bind.a.a(3002, "配置信息错误", "密码错误"));
        sparseArray.append(3003, new com.haier.uhome.usdk.bind.a.a(3003, "配置信息疑似错误", "疑似密码错误"));
        sparseArray.append(3004, new com.haier.uhome.usdk.bind.a.a(3004, "配置信息不完整", "配置信息不完整"));
        sparseArray.append(4000, new com.haier.uhome.usdk.bind.a.a(4000, "正常", "正常进入此状态"));
        sparseArray.append(4001, new com.haier.uhome.usdk.bind.a.a(4001, "连接主网关失败", "连接主网关失败"));
        sparseArray.append(4002, new com.haier.uhome.usdk.bind.a.a(4002, "连接接入网关失败", "连接接入网关失败"));
        sparseArray.append(5000, new com.haier.uhome.usdk.bind.a.a(5000, "正常", "正常进入此状态（首次配置）"));
        sparseArray.append(f4.i.f33946i, new com.haier.uhome.usdk.bind.a.a(f4.i.f33946i, "已解绑", "设备被解绑"));
        sparseArray.append(f4.i.f33947j, new com.haier.uhome.usdk.bind.a.a(f4.i.f33947j, "绑定达到上限", "绑定达到上限"));
        sparseArray.append(f4.i.f33948k, new com.haier.uhome.usdk.bind.a.a(f4.i.f33948k, "Token失效", "Token失效"));
    }

    public static boolean a(int i7, int i8) {
        if (i7 != 2) {
            return false;
        }
        return i8 == 2001 || i8 == 2002 || i8 == 2003;
    }

    public static uSDKError b(int i7) {
        return a(a(i7));
    }

    public static com.haier.uhome.usdk.bind.a.a a(int i7) {
        return f31983c.get(i7);
    }

    public static uSDKError a(com.haier.uhome.usdk.bind.a.a aVar) {
        if (aVar == null || aVar.a() == 1000 || aVar.a() == f31985e || aVar.a() == 3000 || aVar.a() == 4000 || aVar.a() == 5000) {
            return null;
        }
        uSDKError usdkerror = new uSDKError();
        usdkerror.setCode(aVar.a());
        usdkerror.setDescription(aVar.c());
        return usdkerror;
    }
}
