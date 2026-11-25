package com.haier.uhome.usdk.base.c;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i {
    public static String a(int i7) {
        if (i7 == 1) {
            return "蓝牙关闭";
        }
        if (i7 == 2) {
            return "蓝牙打开";
        }
        if (i7 == 3) {
            return "蓝牙正在关闭";
        }
        return i7 == 4 ? "蓝牙正在打开" : "状态未知";
    }
}
