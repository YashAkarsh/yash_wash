package com.haier.globalwasher.modle;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.View;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.BluetoothInfoBean;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    class a extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f24482g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f24482g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f24482g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f24482g.b(baseData);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f24483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n2.c f24484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f24485c;

        class a extends com.haier.globalwasher.modle.network.a<BaseData> {
            a() {
            }

            @Override // com.haier.globalwasher.modle.network.a
            public void i(Exception exc) {
                i0.d((Context) b.this.f24485c.get(), "");
            }

            @Override // com.haier.globalwasher.modle.network.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public void p(BaseData baseData) {
                if ("00000".equals(baseData.getRetCode())) {
                    Message message = new Message();
                    message.what = 1;
                    message.obj = b.this.f24483a.getOrderId();
                    f.b().sendMessage(message);
                }
                i0.d((Context) b.this.f24485c.get(), "" + baseData.getRetInfo());
            }
        }

        b(OrderDetailsBeen orderDetailsBeen, n2.c cVar, WeakReference weakReference) {
            this.f24483a = orderDetailsBeen;
            this.f24484b = cVar;
            this.f24485c = weakReference;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BluetoothInfoBean blueToolthInfo;
            Long l7 = f.b().a().get(this.f24483a.getOrderId());
            if (l7 != null && l7.longValue() != 0) {
                i0.d((Context) this.f24485c.get(), (l7.longValue() / 1000) + "");
                return;
            }
            String deviceId = null;
            if (this.f24483a.getDeviceInfo() != null) {
                blueToolthInfo = this.f24483a.getDeviceInfo().getBlueToolthInfo();
            } else {
                blueToolthInfo = this.f24483a.getDeviceList() != null ? this.f24483a.getDeviceList().getBlueToolthInfo() : null;
            }
            if (blueToolthInfo != null) {
                q.c("OrderStatuManager", "forcedStartDeviceAlertdialog。startSDK ");
                this.f24484b.a(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND);
                return;
            }
            q.c("OrderStatuManager", "forcedStartDeviceAlertdialog。api ");
            if (this.f24483a.getDeviceInfo() != null && this.f24483a.getDeviceInfo().getDeviceId() != null) {
                deviceId = this.f24483a.getDeviceInfo().getDeviceId();
            } else if (this.f24483a.getDeviceList() != null) {
                deviceId = this.f24483a.getDeviceList().getDeviceId();
            }
            g.b((Context) this.f24485c.get(), this.f24483a.getOrderId(), deviceId, new a());
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f[] f24487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f24488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f24489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f24490d;

        c(f[] fVarArr, OrderDetailsBeen orderDetailsBeen, WeakReference weakReference, com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f24487a = fVarArr;
            this.f24488b = orderDetailsBeen;
            this.f24489c = weakReference;
            this.f24490d = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24487a[0] = f.b();
            Long l7 = this.f24487a[0].a().get(this.f24488b.getOrderId());
            if (l7 == null || l7.longValue() == 0) {
                if (this.f24488b.getDeviceInfo() == null || this.f24488b.getDeviceInfo().getDeviceId() == null) {
                    g.e((Context) this.f24489c.get(), this.f24488b.getOrderId(), this.f24488b.getDeviceList().getDeviceId(), "2", this.f24490d);
                    return;
                } else {
                    g.e((Context) this.f24489c.get(), this.f24488b.getOrderId(), this.f24488b.getDeviceInfo().getDeviceId(), "2", this.f24490d);
                    return;
                }
            }
            i0.d((Context) this.f24489c.get(), (l7.longValue() / 1000) + "");
        }
    }

    public static void a(Context context, OrderDetailsBeen orderDetailsBeen, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        WeakReference weakReference = new WeakReference(context);
        z.b((Activity) weakReference.get(), 1, 2, 1, ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_cancal_Remind), ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_End_order_content), ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_End_order_Sure), new c(new f[1], orderDetailsBeen, weakReference, bVar), null);
    }

    public static void b(Context context, String str, String str2, com.haier.globalwasher.modle.network.a<BaseData> aVar) {
        q.c("OrderStatuManager", "forcedStartDevice" + str);
        WeakReference weakReference = new WeakReference(context);
        if (weakReference.get() != null) {
            HashMap map = new HashMap();
            if (str != null) {
                map.put("orderId", str);
            }
            if (str2 != null) {
                map.put(o.f25218y, str2);
            }
            aVar.g(1, (Context) weakReference.get(), i2.a.L1, i2.a.M1, map, null, 1);
        }
    }

    public static void c(Context context, OrderDetailsBeen orderDetailsBeen, n2.c cVar) {
        WeakReference weakReference = new WeakReference(context);
        z.b((Activity) weakReference.get(), 1, 2, 1, ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_cancal_Remind), ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_Restart_content), ((Context) weakReference.get()).getResources().getString(R.string.order_list_Btn_Restart_Sure), new b(orderDetailsBeen, cVar, weakReference), null);
    }

    public static void e(Context context, String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        WeakReference weakReference = new WeakReference(context);
        if (weakReference.get() != null) {
            HashMap map = new HashMap();
            map.put("orderId", str);
            map.put(o.f25218y, str2);
            map.put("type", str3);
            new a(bVar).g(1, (Context) weakReference.get(), i2.a.J1, i2.a.K1, map, null, 1);
        }
    }

    public void d(Context context, String str, com.haier.globalwasher.modle.network.a<BaseData> aVar) {
        WeakReference weakReference = new WeakReference(context);
        if (weakReference.get() != null) {
            HashMap map = new HashMap();
            map.put("orderId", "" + str);
            aVar.g(1, (Context) weakReference.get(), i2.a.f34085b1, i2.a.f34089c1, map, null, 1);
        }
    }
}
