package com.haier.globalwasher.presenter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import c.a1;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.OrderDetailUIBeen;
import com.haier.globalwasher.modle.bean.OrderDetailUIBeen.KeyVelauBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.OrderTimeBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.order.OrderDetailsActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Resources f25175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f25176e = "orderId";

    class a extends com.haier.globalwasher.modle.network.a<BaseData<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OrderDetailsActivity.d f25177g;

        a(OrderDetailsActivity.d dVar) {
            this.f25177g = dVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25177g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<OrderDetailsBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                return;
            }
            this.f25177g.h(baseData);
            i.this.l(baseData, this.f25177g);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData<OrderTimeBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25179g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25179g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25179g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<OrderTimeBeen> baseData) {
            this.f25179g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25174c = baseActivity;
        this.f25175d = baseActivity.getResources();
        return baseActivity;
    }

    public int g(@c.n int i7) {
        return this.f25175d.getColor(i7);
    }

    public Drawable h(@c.u int i7) {
        return this.f25175d.getDrawable(i7);
    }

    public void i(String str, BaseData<OrderDetailsBeen> baseData, OrderDetailsActivity.d dVar) {
        if (baseData != null) {
            dVar.h(baseData);
            l(baseData, dVar);
            return;
        }
        HashMap map = new HashMap();
        map.put("orderId", str + "");
        new a(dVar).j(1, this.f25174c, i2.a.f34092d1, i2.a.f34095e1, map, OrderDetailsBeen.class, 1);
    }

    public void j(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderTimeBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        new b(bVar).j(0, this.f25174c, i2.a.f34143u1, i2.a.f34146v1, map, OrderTimeBeen.class, 1);
    }

    public String k(@a1 int i7) {
        return this.f25175d.getString(i7);
    }

    public void l(BaseData<OrderDetailsBeen> baseData, OrderDetailsActivity.d dVar) {
        BaseListDate baseListDate = new BaseListDate();
        baseListDate.setRetCode("00000");
        ArrayList arrayList = new ArrayList();
        baseListDate.setData(arrayList);
        OrderDetailUIBeen orderDetailUIBeen = new OrderDetailUIBeen();
        orderDetailUIBeen.setTitle(k(R.string.order_list_orderid) + " " + baseData.getData().getOrderCode());
        ArrayList<OrderDetailUIBeen.KeyVelauBeen> arrayList2 = new ArrayList<>();
        orderDetailUIBeen.setArrayList(arrayList2);
        OrderDetailUIBeen.KeyVelauBeen keyVelauBeen = orderDetailUIBeen.new KeyVelauBeen();
        keyVelauBeen.key = k(R.string.order_details_washmode);
        keyVelauBeen.value = baseData.getData().getRunMode().getModeName() + " " + (Integer.parseInt(baseData.getData().getRunMode().getTimeDuration()) * Integer.parseInt(baseData.getData().getRunCount())) + k(R.string.payment_success_pageds_time_unit);
        keyVelauBeen.tag = 1;
        arrayList2.add(keyVelauBeen);
        OrderDetailUIBeen.KeyVelauBeen keyVelauBeen2 = orderDetailUIBeen.new KeyVelauBeen();
        keyVelauBeen2.key = k(R.string.order_details_createime);
        keyVelauBeen2.value = d0.b(baseData.getData().getOrderTime(), "yyyy-MM-dd  HH:mm:ss");
        keyVelauBeen2.tag = 2;
        arrayList2.add(keyVelauBeen2);
        if (baseData.getData().getFinishTime() != null && !"".equals(baseData.getData().getFinishTime())) {
            OrderDetailUIBeen.KeyVelauBeen keyVelauBeen3 = orderDetailUIBeen.new KeyVelauBeen();
            keyVelauBeen3.key = k(R.string.order_details_Completetime);
            keyVelauBeen3.value = d0.b(baseData.getData().getFinishTime(), "yyyy-MM-dd  HH:mm:ss");
            keyVelauBeen3.tag = 3;
            arrayList2.add(keyVelauBeen3);
        }
        orderDetailUIBeen.setArrayList(arrayList2);
        arrayList.add(orderDetailUIBeen);
        OrderDetailUIBeen orderDetailUIBeen2 = new OrderDetailUIBeen();
        ArrayList<OrderDetailUIBeen.KeyVelauBeen> arrayList3 = new ArrayList<>();
        OrderDetailUIBeen.KeyVelauBeen keyVelauBeen4 = orderDetailUIBeen2.new KeyVelauBeen();
        keyVelauBeen4.key = k(R.string.order_details_Order_amount);
        keyVelauBeen4.value = baseData.getData().getCurrencySymbol() + " " + baseData.getData().getPrice();
        keyVelauBeen4.tag = 4;
        arrayList3.add(keyVelauBeen4);
        if (baseData.getData().getCoupunPrice() != null && !"".equals(baseData.getData().getCoupunPrice()) && !"null".equals(baseData.getData().getCoupunPrice())) {
            OrderDetailUIBeen.KeyVelauBeen keyVelauBeen5 = orderDetailUIBeen2.new KeyVelauBeen();
            keyVelauBeen5.key = k(R.string.order_details_Coupon);
            keyVelauBeen5.value = baseData.getData().getCurrencySymbol() + " " + baseData.getData().getCoupunPrice();
            keyVelauBeen5.tag = 5;
            arrayList3.add(keyVelauBeen5);
        }
        if (baseData.getData().getActualPrice() != null && !"".equals(baseData.getData().getActualPrice()) && !"null".equals(baseData.getData().getActualPrice())) {
            OrderDetailUIBeen.KeyVelauBeen keyVelauBeen6 = orderDetailUIBeen2.new KeyVelauBeen();
            keyVelauBeen6.key = k(R.string.order_details_ActualPayMent);
            keyVelauBeen6.value = baseData.getData().getCurrencySymbol() + " " + baseData.getData().getActualPrice();
            keyVelauBeen6.tag = 6;
            arrayList3.add(keyVelauBeen6);
        }
        if (baseData.getData().getActualName() != null && !"".equals(baseData.getData().getActualName()) && !"null".equals(baseData.getData().getActualName())) {
            OrderDetailUIBeen.KeyVelauBeen keyVelauBeen7 = orderDetailUIBeen2.new KeyVelauBeen();
            keyVelauBeen7.key = k(R.string.order_details_PaymentMet);
            keyVelauBeen7.value = baseData.getData().getActualName();
            keyVelauBeen7.tag = 7;
            arrayList3.add(keyVelauBeen7);
        }
        orderDetailUIBeen2.setArrayList(arrayList3);
        arrayList.add(orderDetailUIBeen2);
        OrderDetailUIBeen orderDetailUIBeen3 = new OrderDetailUIBeen();
        ArrayList<OrderDetailUIBeen.KeyVelauBeen> arrayList4 = new ArrayList<>();
        OrderDetailUIBeen.KeyVelauBeen keyVelauBeen8 = orderDetailUIBeen3.new KeyVelauBeen();
        keyVelauBeen8.key = k(R.string.order_details_Customer_care);
        keyVelauBeen8.value = (baseData.getData().getDeviceInfo() == null || baseData.getData().getDeviceInfo().getLaundryInfo() == null || baseData.getData().getDeviceInfo().getLaundryInfo().getHotLine() == null || "".equals(baseData.getData().getDeviceInfo().getLaundryInfo().getHotLine())) ? baseData.getData().getHotLine() : baseData.getData().getDeviceInfo().getLaundryInfo().getHotLine();
        keyVelauBeen8.tag = 11;
        arrayList4.add(keyVelauBeen8);
        orderDetailUIBeen3.setArrayList(arrayList4);
        arrayList.add(orderDetailUIBeen3);
        dVar.b(baseListDate);
    }
}
