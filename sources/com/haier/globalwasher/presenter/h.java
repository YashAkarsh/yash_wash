package com.haier.globalwasher.presenter;

import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.order.OrderDetailsActivity;
import com.haier.globalwasher.view.activity.order.OrderIsPaidToRunActivity;
import com.haier.globalwasher.view.activity.order.SubscriptSuccessfulActivity;
import com.haier.globalwasher.view.activity.pay.OrderPayActivity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25164a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25165b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f25166c = "OrderActivityManager";

    class a extends com.haier.globalwasher.modle.network.a<BaseData<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25167g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25167g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25167g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<OrderDetailsBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                this.f25167g.a(new Exception(baseData.getRetInfo()));
            } else {
                this.f25167g.b(baseData);
            }
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f25169b;

        static {
            int[] iArr = new int[com.haier.globalwasher.modle.enum_.d.values().length];
            f25169b = iArr;
            try {
                iArr[com.haier.globalwasher.modle.enum_.d.SEND_CODE_ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25169b[com.haier.globalwasher.modle.enum_.d.ORDER_PAY_ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25169b[com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25169b[com.haier.globalwasher.modle.enum_.d.ORDER_DETAIL_ACTIVITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.haier.globalwasher.modle.enum_.e.values().length];
            f25168a = iArr2;
            try {
                iArr2[com.haier.globalwasher.modle.enum_.e.RESUERVE_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.ORDER_CENCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.NO_PAY_OUT_TIME.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.FAULT_CLOSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.SECCESS_PAY_OUT_TIME.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.SUCCESS_PAY_FAULT.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.VERIFICATION_NO_PAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f25168a[com.haier.globalwasher.modle.enum_.e.CLEANING.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private static void a(BaseActivity baseActivity, String str, com.haier.globalwasher.mvp_api.moudle.b bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str + "");
        new a(bVar).j(1, baseActivity, i2.a.f34092d1, i2.a.f34095e1, map, OrderDetailsBeen.class, 1);
    }

    public static void b(BaseActivity baseActivity, BaseData<OrderDetailsBeen> baseData, String str, com.haier.globalwasher.modle.enum_.d dVar, int i7) {
        c cVar = new c(baseActivity, dVar, i7);
        if (baseData == null) {
            a(baseActivity, str, cVar);
        } else {
            cVar.b(baseData);
        }
    }

    public static void c(BaseActivity baseActivity, BaseData<OrderDetailsBeen> baseData, String str, com.haier.globalwasher.modle.enum_.d dVar, int i7, int i8) {
        c cVar = new c(baseActivity, dVar, i7, i8);
        if (baseData == null) {
            a(baseActivity, str, cVar);
        } else {
            cVar.b(baseData);
        }
    }

    private static class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BaseActivity f25170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.haier.globalwasher.modle.enum_.d f25171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f25172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f25173d;

        public c(BaseActivity baseActivity, com.haier.globalwasher.modle.enum_.d dVar, int i7) {
            this.f25170a = baseActivity;
            this.f25171b = dVar;
            this.f25172c = i7;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<OrderDetailsBeen> baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                switch (b.f25168a[com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(baseData.getData().getOrderStatus())).ordinal()]) {
                    case 1:
                        MyApplication.s(new CountDownBeen(baseData.getData().getOrderId(), 1000 * Long.parseLong(baseData.getData().getPayWindowRemainingTime()), Integer.parseInt(baseData.getData().getOrderStatus()), 0L));
                        break;
                    case 2:
                        MyApplication.s(new CountDownBeen(baseData.getData().getOrderId(), Long.parseLong(baseData.getData().getDeviceInfo().getTimeRemaining()) * 60 * 1000, Integer.parseInt(baseData.getData().getOrderStatus()), 0L));
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        MyApplication.s(new CountDownBeen(baseData.getData().getOrderId(), 0L, Integer.parseInt(baseData.getData().getOrderStatus()), 0L));
                        break;
                    case 9:
                        MyApplication.s(new CountDownBeen(baseData.getData().getOrderId(), Long.parseLong(baseData.getData().getPayWindowRemainingTime()) * 1000, Integer.parseInt(baseData.getData().getOrderStatus()), 0L));
                        break;
                    case 10:
                        MyApplication.s(new CountDownBeen(baseData.getData().getOrderId(), Long.parseLong(baseData.getData().getPayWindowRemainingTime()) * 1000, com.haier.globalwasher.modle.enum_.e.CLEANING.b(), Long.parseLong("0".equals(baseData.getData().getDeviceInfo().getTimeRemaining()) ? "1" : baseData.getData().getDeviceInfo().getTimeRemaining()) * 60 * 1000));
                        break;
                }
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "--VERIFICATION_NO_PAY--orderDetailEnum=" + this.f25171b);
                int i7 = b.f25169b[this.f25171b.ordinal()];
                if (i7 == 1) {
                    SubscriptSuccessfulActivity.h0(baseData.getData(), this.f25170a);
                    return;
                }
                if (i7 == 2) {
                    OrderPayActivity.a1(baseData.getData(), this.f25170a);
                    BaseActivity baseActivity = this.f25170a;
                    if (baseActivity instanceof MainActivity) {
                        return;
                    }
                    baseActivity.finish();
                    return;
                }
                if (i7 != 3) {
                    if (i7 != 4) {
                        return;
                    }
                    OrderDetailsActivity.z0(this.f25170a, baseData);
                } else {
                    OrderIsPaidToRunActivity.s0(baseData.getData(), this.f25170a, this.f25173d);
                    BaseActivity baseActivity2 = this.f25170a;
                    if (baseActivity2 instanceof OrderIsPaidToRunActivity) {
                        baseActivity2.finish();
                    }
                }
            }
        }

        public c(BaseActivity baseActivity, com.haier.globalwasher.modle.enum_.d dVar, int i7, int i8) {
            this.f25170a = baseActivity;
            this.f25171b = dVar;
            this.f25172c = i7;
            this.f25173d = i8;
        }
    }
}
