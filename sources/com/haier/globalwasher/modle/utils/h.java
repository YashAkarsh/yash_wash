package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderTimeBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownBeen f24610a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f24613d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24611b = "CountDown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24612c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24614e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24615f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<com.haier.globalwasher.mvp_api.volley.myvolley.c> f24616g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Handler f24617h = new b();

    class a extends com.haier.globalwasher.modle.network.a<BaseData<OrderTimeBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f24618g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f24618g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f24618g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<OrderTimeBeen> baseData) {
            this.f24618g.b(baseData);
        }
    }

    class b extends Handler {

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderTimeBeen>> {
            a() {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
                h.this.f24617h.sendMessageDelayed(new Message(), RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseData<OrderTimeBeen> baseData) {
                if (h.this.f24616g.size() > 1) {
                    for (int i7 = 0; i7 < h.this.f24616g.size(); i7++) {
                        h.this.f24616g.get(i7).c();
                    }
                }
                if ("00000".equals(baseData.getRetCode())) {
                    q.c("OrderActivityManager", baseData.getData().getStatus() + "--" + baseData.getData().getRemainingTime());
                    if (com.haier.globalwasher.modle.enum_.e.VERIFICATION_NO_PAY.b() == Integer.parseInt(baseData.getData().getStatus())) {
                        h hVar = h.this;
                        hVar.f24612c = true;
                        MyApplication.s(new CountDownBeen(hVar.f24610a.getWashOrderId(), Long.parseLong(baseData.getData().getRemainingTime()), Integer.parseInt(baseData.getData().getStatus()), 0L));
                    } else {
                        if (com.haier.globalwasher.modle.enum_.e.FAULT_CLOSE.b() == Integer.parseInt(baseData.getData().getStatus()) || com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS.b() == Integer.parseInt(baseData.getData().getStatus()) || com.haier.globalwasher.modle.enum_.e.NO_PAY_OUT_TIME.b() == Integer.parseInt(baseData.getData().getStatus()) || com.haier.globalwasher.modle.enum_.e.ORDER_CENCEL.b() == Integer.parseInt(baseData.getData().getStatus())) {
                            MyApplication.s(new CountDownBeen(h.this.f24610a.getWashOrderId(), 0L, Integer.parseInt(baseData.getData().getStatus()), 0L));
                            return;
                        }
                        if (com.haier.globalwasher.modle.enum_.e.CLEANING.b() == Integer.parseInt(baseData.getData().getStatus())) {
                            h.this.f24617h.sendMessageDelayed(new Message(), DateUtils.MILLIS_PER_MINUTE);
                            h.this.f24612c = false;
                        } else if (com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.b() == Integer.parseInt(baseData.getData().getStatus())) {
                            MyApplication.s(new CountDownBeen(h.this.f24610a.getWashOrderId(), 60 * Long.parseLong(baseData.getData().getRemainingTime()) * 1000, Integer.parseInt(baseData.getData().getStatus()), 0L));
                        }
                    }
                }
            }
        }

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            h hVar = h.this;
            hVar.a(hVar.f24610a.getWashOrderId(), new a());
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24622a;

        static {
            int[] iArr = new int[com.haier.globalwasher.modle.enum_.e.values().length];
            f24622a = iArr;
            try {
                iArr[com.haier.globalwasher.modle.enum_.e.CLEANING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24622a[com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(CountDownBeen countDownBeen, Context context) {
        this.f24610a = countDownBeen;
        this.f24613d = context;
    }

    public void a(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderTimeBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        this.f24616g.add(new a(bVar).j(0, null, i2.a.f34143u1, i2.a.f34146v1, map, OrderTimeBeen.class, 1));
    }

    public CountDownBeen b(CountDownBeen countDownBeen, int i7) {
        ArrayList<CountDownBeen> arrayListL = MyApplication.l();
        for (int i8 = 0; i8 < arrayListL.size(); i8++) {
            if (arrayListL.get(i8).equals(countDownBeen)) {
                if (i7 != 2) {
                    arrayListL.get(i8).setOverTime(countDownBeen.getOverTime());
                }
                arrayListL.get(i8).setClearbucketCountDownTime(countDownBeen.getClearbucketCountDownTime());
                return arrayListL.get(i8);
            }
        }
        return countDownBeen;
    }

    public boolean c() {
        return this.f24612c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        do {
            long clearbucketCountDownTime = this.f24610a.getClearbucketCountDownTime();
            if (clearbucketCountDownTime > 0) {
                this.f24610a.setClearbucketCountDownTime(clearbucketCountDownTime - 1000);
                b(this.f24610a, 2);
                Intent intent = new Intent(i2.a.f34153y);
                intent.putExtra(i2.a.f34150x, this.f24610a);
                this.f24613d.sendBroadcast(intent);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                }
            } else if (c.f24622a[com.haier.globalwasher.modle.enum_.e.e(this.f24610a.getStatuId()).ordinal()] != 1) {
                long overTime = this.f24610a.getOverTime() - 1000;
                this.f24610a.setOverTime(overTime);
                b(this.f24610a, 1);
                if (overTime <= 0) {
                    if (this.f24610a.getStatuId() == com.haier.globalwasher.modle.enum_.e.RESUERVE_VERIFICATION.b()) {
                        this.f24610a.setStatuId(com.haier.globalwasher.modle.enum_.e.ORDER_CENCEL.b());
                    } else if (this.f24610a.getStatuId() == com.haier.globalwasher.modle.enum_.e.VERIFICATION_NO_PAY.b()) {
                        this.f24610a.setStatuId(com.haier.globalwasher.modle.enum_.e.NO_PAY_OUT_TIME.b());
                    }
                    this.f24612c = false;
                } else {
                    this.f24612c = true;
                }
                Intent intent2 = new Intent(i2.a.f34153y);
                intent2.putExtra(i2.a.f34150x, this.f24610a);
                this.f24613d.sendBroadcast(intent2);
                if (com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.b() == this.f24610a.getStatuId() && overTime % 60 == 0) {
                    this.f24617h.sendEmptyMessage(1);
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e9) {
                    e9.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
                    this.f24617h.sendEmptyMessage(1);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        } while (this.f24612c);
    }
}
