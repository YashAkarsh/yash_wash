package com.haier.globalwasher.modle.enum_;

import c.a1;
import c.n;
import com.haier.globalwasher.R;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
public enum e {
    YUYUE(101, R.string.order_list_status_101, R.color.app_zhexian_blue_relg),
    RESUERVE_VERIFICATION(102, R.string.order_list_status_102, R.color.app_zhexian_blue_relg),
    PAY_SUCCESS(Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, R.string.order_list_status_103, R.color.order_state_blue),
    ORDER_SUCCESS(104, R.string.order_list_status_104, R.color.order_state_blue),
    ORDER_CENCEL(105, R.string.order_list_status_105, R.color.app_order_coler),
    NO_PAY_OUT_TIME(Constants.ACTION_SUBMIT_CLICKED, R.string.order_list_status_106, R.color.app_order_coler),
    FAULT_CLOSE(Constants.OTP_FILLER_WEB_SUCCESS, R.string.order_list_status_107, R.color.app_order_coler),
    SECCESS_PAY_OUT_TIME(108, R.string.order_list_status_108, R.color.app_order_coler),
    VERIFICATION_NO_PAY(109, R.string.order_list_status_109, R.color.app_zhexian_blue_relg),
    SUCCESS_PAY_FAULT(Constants.LOG_ERROR_OTP, R.string.order_list_status_110, R.color.app_order_coler),
    CLEANING(111, R.string.order_list_status_111, R.color.app_zhexian_blue_relg);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f24447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a1
    int f24448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n
    int f24449c;

    e(int i7, int i8, int i9) {
        this.f24447a = i7;
        this.f24448b = i8;
        this.f24449c = i9;
    }

    public static e e(int i7) {
        for (e eVar : values()) {
            if (eVar.b() == i7) {
                return eVar;
            }
        }
        return ORDER_CENCEL;
    }

    public int b() {
        return this.f24447a;
    }

    public int c() {
        return this.f24449c;
    }

    public int d() {
        return this.f24448b;
    }
}
