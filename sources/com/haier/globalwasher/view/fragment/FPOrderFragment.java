package com.haier.globalwasher.view.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.UBluetoothBean;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import easypay.appinvoke.manager.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FPOrderFragment extends com.haier.globalwasher.base.b<OrderDetailsBeen> implements com.haier.globalwasher.mvp_api.adapter.d<OrderDetailsBeen, com.haier.globalwasher.mvp_api.adapter.b>, XListView.c {
    com.haier.globalwasher.modle.utils.bluetoothutil.a.g A;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a B;
    private OrderDetailsBeen C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.haier.globalwasher.presenter.j f26024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a<OrderDetailsBeen, com.haier.globalwasher.mvp_api.adapter.b> f26025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    XListView f26026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MainActivity f26027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Resources f26028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CountDownBroadcastReceiver f26029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private MyBroadcastReceiver f26030y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Map<String, Long> f26031z = new HashMap();
    ArrayList<OrderDetailsBeen> D = new ArrayList<>();
    public int E = 1;
    private String F = "CancelOrderLinsenter";

    public static class MyBroadcastReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<FPOrderFragment> f26032a;

        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || this.f26032a.get() == null || !com.haier.globalwasher.modle.d.f24392a.equals(intent.getAction())) {
                return;
            }
            String stringExtra = intent.getStringExtra(com.haier.globalwasher.modle.d.f24393b);
            long longExtra = intent.getLongExtra(com.haier.globalwasher.modle.d.f24394c, 0L);
            if (this.f26032a.get().f26025t != null) {
                if (longExtra > 0) {
                    this.f26032a.get().Z().put(stringExtra, Long.valueOf(longExtra));
                } else {
                    if (this.f26032a.get().D != null) {
                        for (int i7 = 0; i7 < this.f26032a.get().D.size(); i7++) {
                            if (stringExtra != null && stringExtra.equals(this.f26032a.get().D.get(i7).getOrderId())) {
                                try {
                                    com.haier.globalwasher.modle.enum_.e eVarE = com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(this.f26032a.get().D.get(i7).getOrderStatus()));
                                    if ((eVarE == com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS || eVarE == com.haier.globalwasher.modle.enum_.e.ORDER_CENCEL || eVarE == com.haier.globalwasher.modle.enum_.e.NO_PAY_OUT_TIME || eVarE == com.haier.globalwasher.modle.enum_.e.SECCESS_PAY_OUT_TIME) && this.f26032a.get().B != null) {
                                        this.f26032a.get().B.k();
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                    this.f26032a.get().Z().remove(stringExtra);
                }
                this.f26032a.get().f26025t.notifyDataSetChanged();
            }
        }

        public MyBroadcastReceiver(FPOrderFragment fPOrderFragment) {
            this.f26032a = new WeakReference<>(fPOrderFragment);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f26034b;

        /* JADX INFO: renamed from: com.haier.globalwasher.view.fragment.FPOrderFragment$a$a, reason: collision with other inner class name */
        class C0341a implements n2.c {
            C0341a() {
            }

            @Override // n2.c
            public void a(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar) {
                a aVar = a.this;
                FPOrderFragment fPOrderFragment = FPOrderFragment.this;
                fPOrderFragment.e0(fPOrderFragment.D.get(aVar.f26034b));
                FPOrderFragment.this.g0(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, true);
            }
        }

        a(OrderDetailsBeen orderDetailsBeen, int i7) {
            this.f26033a = orderDetailsBeen;
            this.f26034b = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.modle.g.c(FPOrderFragment.this.f26027v, this.f26033a, new C0341a());
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26037a;

        b(OrderDetailsBeen orderDetailsBeen) {
            this.f26037a = orderDetailsBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.c(FPOrderFragment.this.f26027v, null, this.f26037a.getOrderId(), com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY, 0, 2);
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26039a;

        c(OrderDetailsBeen orderDetailsBeen) {
            this.f26039a = orderDetailsBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.b(FPOrderFragment.this.f26027v, null, this.f26039a.getOrderId(), com.haier.globalwasher.modle.enum_.d.ORDER_PAY_ACTIVITY, 0);
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26041a;

        static {
            int[] iArr = new int[com.jiao.project.bluetoothofabroadwasherapp.enums.c.values().length];
            f26041a = iArr;
            try {
                iArr[com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26041a[com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    class e extends com.haier.globalwasher.modle.utils.bluetoothutil.a.g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(com.haier.globalwasher.modle.utils.bluetoothutil.a aVar, boolean z7, v3.b bVar) {
            super(z7, bVar);
            Objects.requireNonNull(aVar);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a.g, n2.b
        public void d() {
            super.d();
            q.c(FPOrderFragment.this.F, "deviceIsConnent--toNext=" + r());
            if (r()) {
                int i7 = d.f26041a[c().ordinal()];
                if (i7 == 1) {
                    FPOrderFragment.this.f0();
                } else {
                    if (i7 != 2) {
                        return;
                    }
                    FPOrderFragment.this.h0();
                }
            }
        }

        @Override // n2.a
        public void e(boolean z7) {
        }

        @Override // v3.a
        public void g(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, int i7) {
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar2 = com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND;
            if (cVar == cVar2 && i7 == cVar2.b()) {
                q.c(FPOrderFragment.this.F, "订单列表界面   ---设备停止");
                FPOrderFragment.this.a0().setOrderStatus("104");
                FPOrderFragment.this.f26025t.notifyDataSetChanged();
            }
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar3 = com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND;
            if (cVar == cVar3 && i7 == cVar3.b() && FPOrderFragment.this.a0() != null) {
                Message message = new Message();
                message.what = 1;
                message.obj = FPOrderFragment.this.a0().getOrderId();
                com.haier.globalwasher.modle.f.b().sendMessage(message);
                i0.d(FPOrderFragment.this.f26027v, FPOrderFragment.this.getResources().getString(R.string.usdk_device_is_running));
            }
        }
    }

    class f extends com.haier.globalwasher.base.b<OrderDetailsBeen>.a {

        class a extends CountDownBroadcastReceiver {
            a() {
            }

            @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
            public void a(ArrayList<CountDownBeen> arrayList) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    for (int i8 = 0; i8 < FPOrderFragment.this.D.size(); i8++) {
                        if ((arrayList.get(i7).getWashOrderId() + "").equals(FPOrderFragment.this.D.get(i8).getOrderId())) {
                            if (arrayList.get(i7).getOverTime() > 0) {
                                break;
                            }
                            FPOrderFragment.this.D.get(i8).setOrderStatus(arrayList.get(i7).getStatuId() + "");
                            FPOrderFragment.this.f26025t.notifyDataSetChanged();
                            break;
                        }
                    }
                }
            }
        }

        f() {
            super();
        }

        @Override // com.haier.globalwasher.base.b.a
        public void f(ArrayList<OrderDetailsBeen> arrayList) {
            FPOrderFragment fPOrderFragment = FPOrderFragment.this;
            fPOrderFragment.D = arrayList;
            if (fPOrderFragment.f26025t != null) {
                q.c(FPOrderFragment.this.F, "toLoadData 333");
                FPOrderFragment.this.f26025t.notifyDataSetChanged();
                return;
            }
            q.c(FPOrderFragment.this.F, "toLoadData 222");
            FPOrderFragment fPOrderFragment2 = FPOrderFragment.this;
            MainActivity mainActivity = FPOrderFragment.this.f26027v;
            FPOrderFragment fPOrderFragment3 = FPOrderFragment.this;
            fPOrderFragment2.f26025t = new com.haier.globalwasher.mvp_api.adapter.a(mainActivity, fPOrderFragment3.D, fPOrderFragment3);
            FPOrderFragment fPOrderFragment4 = FPOrderFragment.this;
            fPOrderFragment4.f26026u.setAdapter((ListAdapter) fPOrderFragment4.f26025t);
            FPOrderFragment.this.f26029x = new a();
            IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
            if (Build.VERSION.SDK_INT >= 33) {
                FPOrderFragment.this.f26027v.registerReceiver(FPOrderFragment.this.f26029x, intentFilter, 4);
            } else {
                FPOrderFragment.this.f26027v.registerReceiver(FPOrderFragment.this.f26029x, intentFilter);
            }
        }
    }

    class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26045a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.haier.globalwasher.presenter.j jVar = FPOrderFragment.this.f26024s;
                g gVar = g.this;
                String orderId = FPOrderFragment.this.D.get(gVar.f26045a).getOrderId();
                g gVar2 = g.this;
                jVar.g(orderId, FPOrderFragment.this.new n(gVar2.f26045a));
            }
        }

        g(int i7) {
            this.f26045a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.c(FPOrderFragment.this.f26027v, 1, 2, FPOrderFragment.this.f26028w.getString(R.string.order_list_Btn_cancal_Remind), FPOrderFragment.this.f26028w.getString(R.string.order_list_Btn_cancal_Remind_content), FPOrderFragment.this.f26028w.getString(R.string.order_list_Btn_cancal_Remind_left), FPOrderFragment.this.f26028w.getString(R.string.order_list_Btn_cancal_Remind_right), null, new a());
        }
    }

    class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26048a;

        h(int i7) {
            this.f26048a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.c(FPOrderFragment.this.f26027v, null, FPOrderFragment.this.D.get(this.f26048a).getOrderId(), com.haier.globalwasher.modle.enum_.d.ORDER_DETAIL_ACTIVITY, 0, 2);
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26050a;

        i(OrderDetailsBeen orderDetailsBeen) {
            this.f26050a = orderDetailsBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.b(FPOrderFragment.this.f26027v, null, this.f26050a.getOrderId(), com.haier.globalwasher.modle.enum_.d.SEND_CODE_ACTIVITY, 0);
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f26053b;

        class a implements n2.c {
            a() {
            }

            @Override // n2.c
            public void a(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar) {
                j jVar = j.this;
                FPOrderFragment fPOrderFragment = FPOrderFragment.this;
                fPOrderFragment.e0(fPOrderFragment.D.get(jVar.f26053b));
                FPOrderFragment.this.g0(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, true);
            }
        }

        j(OrderDetailsBeen orderDetailsBeen, int i7) {
            this.f26052a = orderDetailsBeen;
            this.f26053b = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.modle.g.c(FPOrderFragment.this.f26027v, this.f26052a, new a());
        }
    }

    class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26056a;

        k(OrderDetailsBeen orderDetailsBeen) {
            this.f26056a = orderDetailsBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.c(FPOrderFragment.this.f26027v, null, this.f26056a.getOrderId(), com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY, 0, 2);
        }
    }

    class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f26059b;

        l(OrderDetailsBeen orderDetailsBeen, int i7) {
            this.f26058a = orderDetailsBeen;
            this.f26059b = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.modle.g.a(FPOrderFragment.this.f26027v, this.f26058a, FPOrderFragment.this.new o(this.f26059b));
        }
    }

    class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OrderDetailsBeen f26061a;

        m(OrderDetailsBeen orderDetailsBeen) {
            this.f26061a = orderDetailsBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.haier.globalwasher.presenter.h.c(FPOrderFragment.this.f26027v, null, this.f26061a.getOrderId(), com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY, 0, 2);
        }
    }

    private class n implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f26063a;

        public n(int i7) {
            this.f26063a = i7;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            q.c("GsonRequest", baseData.toString());
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(FPOrderFragment.this.f26027v, baseData.getRetInfo());
                return;
            }
            String deviceId = FPOrderFragment.this.D.get(this.f26063a).getDeviceList().getDeviceId();
            for (int i7 = 0; i7 < FPOrderFragment.this.D.size(); i7++) {
                if (FPOrderFragment.this.D.get(i7).getOrderStatus().equals("101") && FPOrderFragment.this.D.get(i7).getDeviceList().getDeviceId().equals(deviceId)) {
                    FPOrderFragment.this.D.get(i7).setOrderStatus("102");
                }
            }
            FPOrderFragment.this.D.get(this.f26063a).setOrderStatus("105");
            FPOrderFragment.this.f26025t.notifyDataSetChanged();
        }
    }

    private class o implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f26065a;

        public o(int i7) {
            this.f26065a = i7;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            q.c("GsonRequest", baseData.toString());
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(FPOrderFragment.this.f26027v, baseData.getRetInfo());
                return;
            }
            if (FPOrderFragment.this.D.get(this.f26065a).getOrderDeviType() != 1) {
                FPOrderFragment.this.D.get(this.f26065a).setOrderStatus("104");
                FPOrderFragment.this.f26025t.notifyDataSetChanged();
            } else {
                FPOrderFragment fPOrderFragment = FPOrderFragment.this;
                fPOrderFragment.e0(fPOrderFragment.D.get(this.f26065a));
                FPOrderFragment.this.g0(com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND, true);
            }
        }
    }

    @Override // com.haier.globalwasher.base.b
    public void N(int i7, int i8) {
        this.E = i7;
        q.c(this.F, "toLoadData");
        if (this.f26024s == null) {
            J();
        }
        if (this.f26027v == null) {
            this.f26027v = (MainActivity) getActivity();
        }
        MainActivity mainActivity = this.f26027v;
        if (mainActivity == null || mainActivity.t0() != 1) {
            return;
        }
        q.c(this.F, "toLoadData 111");
        this.f26024s.h(i8, i7, new f());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, OrderDetailsBeen orderDetailsBeen) {
        int i8;
        bVar.b(R.id.tv_orderid, R.id.iv_more, R.id.tv_order_statu, R.id.tv_divice_type_name, R.id.tv_order_price, R.id.tv_order_discount, R.id.tv_cencle, R.id.rly_button, R.id.tv_right_button);
        TextView textView = (TextView) bVar.a(R.id.tv_orderid);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.iv_more);
        TextView textView2 = (TextView) bVar.a(R.id.tv_order_statu);
        TextView textView3 = (TextView) bVar.a(R.id.tv_divice_type_name);
        TextView textView4 = (TextView) bVar.a(R.id.tv_order_price);
        TextView textView5 = (TextView) bVar.a(R.id.tv_order_discount);
        RelativeLayout relativeLayout = (RelativeLayout) bVar.a(R.id.rly_button);
        TextView textView6 = (TextView) bVar.a(R.id.tv_cencle);
        TextView textView7 = (TextView) bVar.a(R.id.tv_right_button);
        textView.setText(this.f26028w.getString(R.string.order_list_orderid) + " " + orderDetailsBeen.getOrderCode());
        textView2.setText(com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(orderDetailsBeen.getOrderStatus())).d());
        textView2.setTextColor(this.f26028w.getColor(com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(orderDetailsBeen.getOrderStatus())).c()));
        if (orderDetailsBeen.getDeviceList() == null || orderDetailsBeen.getDeviceList().getSerialNumber() == null || orderDetailsBeen.getDeviceList().getName() == null) {
            textView3.setText(this.f26028w.getString(R.string.order_list_deviceId) + " ");
        } else {
            textView3.setText(this.f26028w.getString(R.string.order_list_deviceId) + d0.f(orderDetailsBeen.getDeviceList().getSerialNumber()) + " " + orderDetailsBeen.getDeviceList().getName());
        }
        textView4.setText(this.f26028w.getString(R.string.order_list_orderamount) + orderDetailsBeen.getCurrencySymbol() + " " + orderDetailsBeen.getPrice());
        textView6.setOnClickListener(new g(i7));
        linearLayout.setOnClickListener(new h(i7));
        linearLayout.setVisibility(0);
        relativeLayout.setVisibility(0);
        switch (Integer.parseInt(orderDetailsBeen.getOrderStatus())) {
            case 101:
                textView5.setVisibility(8);
                textView6.setVisibility(0);
                textView7.setVisibility(8);
                textView6.setText(this.f26028w.getString(R.string.order_list_Btn_Cancel));
                break;
            case 102:
                textView5.setVisibility(8);
                textView6.setVisibility(0);
                textView7.setVisibility(0);
                textView7.setText(this.f26028w.getString(R.string.order_list_Btn_Confirm));
                textView6.setText(this.f26028w.getString(R.string.order_list_Btn_Cancel));
                textView7.setOnClickListener(new i(orderDetailsBeen));
                break;
            case Constants.ACTION_SUBMIT_BTN_USER_PWD_NB /* 103 */:
                if (orderDetailsBeen.isStart()) {
                    textView7.setVisibility(0);
                    Map<String, Long> map = this.f26031z;
                    if (map == null || map.get(orderDetailsBeen.getOrderId()) == null) {
                        textView7.setText(this.f26028w.getString(R.string.order_list_Btn_Restart));
                        textView7.setEnabled(true);
                    } else {
                        textView7.setEnabled(false);
                        textView7.setText((this.f26031z.get(orderDetailsBeen.getOrderId()).longValue() / 1000) + "s");
                    }
                } else {
                    textView7.setVisibility(8);
                }
                textView5.setVisibility(0);
                textView6.setVisibility(0);
                textView5.setText(this.f26028w.getString(R.string.order_list_actual_payment) + orderDetailsBeen.getCurrencySymbol() + "  " + orderDetailsBeen.getActualPrice());
                textView6.setText(this.f26028w.getString(R.string.order_list_Btn_End_order));
                textView7.setOnClickListener(new j(orderDetailsBeen, i7));
                linearLayout.setOnClickListener(new k(orderDetailsBeen));
                textView6.setOnClickListener(new l(orderDetailsBeen, i7));
                break;
            case 104:
                textView5.setVisibility(0);
                textView7.setVisibility(8);
                textView6.setVisibility(8);
                textView5.setText(this.f26028w.getString(R.string.order_list_actual_payment) + orderDetailsBeen.getCurrencySymbol() + "  " + orderDetailsBeen.getActualPrice());
                relativeLayout.setVisibility(8);
                linearLayout.setOnClickListener(new m(orderDetailsBeen));
                break;
            case 105:
            case Constants.ACTION_SUBMIT_CLICKED /* 106 */:
                textView7.setVisibility(8);
                textView6.setVisibility(8);
                relativeLayout.setVisibility(8);
                textView5.setVisibility(8);
                break;
            case Constants.OTP_FILLER_WEB_SUCCESS /* 107 */:
            case 108:
            case Constants.LOG_ERROR_OTP /* 110 */:
                if (orderDetailsBeen.isStart()) {
                    relativeLayout.setVisibility(0);
                    textView7.setVisibility(0);
                    Map<String, Long> map2 = this.f26031z;
                    if (map2 == null || map2.get(orderDetailsBeen.getOrderId()) == null) {
                        textView7.setText(this.f26028w.getString(R.string.order_list_Btn_Restart));
                        textView7.setEnabled(true);
                    } else {
                        textView7.setEnabled(false);
                        textView7.setText((this.f26031z.get(orderDetailsBeen.getOrderId()).longValue() / 1000) + "s");
                    }
                    i8 = 8;
                } else {
                    i8 = 8;
                    relativeLayout.setVisibility(8);
                    textView7.setVisibility(8);
                }
                textView5.setVisibility(0);
                textView6.setVisibility(i8);
                textView5.setText(this.f26028w.getString(R.string.order_list_actual_payment) + orderDetailsBeen.getCurrencySymbol() + "  " + orderDetailsBeen.getActualPrice());
                textView6.setText(this.f26028w.getString(R.string.order_list_Btn_End_order));
                textView7.setOnClickListener(new a(orderDetailsBeen, i7));
                linearLayout.setOnClickListener(new b(orderDetailsBeen));
                break;
            case 109:
            case 111:
                textView6.setVisibility(0);
                textView7.setVisibility(0);
                textView6.setText(this.f26028w.getString(R.string.order_list_Btn_Cancel));
                textView7.setText(this.f26028w.getString(R.string.order_list_Btn_Pay));
                textView5.setVisibility(8);
                textView7.setOnClickListener(new c(orderDetailsBeen));
                break;
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this.f26027v, LayoutInflater.from(this.f26027v).inflate(R.layout.adapter_first_page_order, viewGroup, false), 1);
    }

    public com.haier.globalwasher.modle.utils.bluetoothutil.a.g X() {
        OrderDetailsBeen orderDetailsBeen;
        v3.b uBluetoothBean;
        if (this.A == null && (orderDetailsBeen = this.C) != null) {
            if (orderDetailsBeen.getDeviceList() != null) {
                uBluetoothBean = Integer.parseInt(this.C.getDeviceList().getBlueToolthInfo().getModuleType()) == 1 ? new UBluetoothBean(a0().getDeviceList().getBlueToolthInfo().getAccessToken(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective()) : new w3.a(a0().getDeviceList().getBlueToolthInfo().getDeviceCode(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective());
            } else {
                uBluetoothBean = null;
            }
            Y();
            com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.B;
            if (aVar != null) {
                Objects.requireNonNull(aVar);
                this.A = new e(aVar, true, uBluetoothBean);
            }
        }
        return this.A;
    }

    public com.haier.globalwasher.modle.utils.bluetoothutil.a Y() {
        OrderDetailsBeen orderDetailsBeen;
        if (this.B == null && (orderDetailsBeen = this.C) != null) {
            this.B = new com.haier.globalwasher.modle.utils.bluetoothutil.a(this.f26027v, Integer.parseInt(orderDetailsBeen.getDeviceList().getBlueToolthInfo().getModuleType()));
        }
        return this.B;
    }

    public Map<String, Long> Z() {
        if (this.f26031z == null) {
            this.f26031z = new HashMap();
        }
        return this.f26031z;
    }

    public OrderDetailsBeen a0() {
        return this.C;
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.first_order_fragment;
    }

    @Override // com.haier.globalwasher.base.b
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public w2.a J() {
        if (this.f26027v == null) {
            this.f26027v = (MainActivity) getActivity();
        }
        com.haier.globalwasher.presenter.j jVar = new com.haier.globalwasher.presenter.j();
        this.f26024s = jVar;
        return jVar;
    }

    @Override // com.haier.globalwasher.base.b
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public XListView K() {
        if (this.f26027v == null) {
            this.f26027v = (MainActivity) getActivity();
        }
        this.f26028w = this.f26027v.getResources();
        XListView xListView = (XListView) findViewById(R.id.lv_);
        this.f26026u = xListView;
        xListView.setXListViewListener(this);
        this.f26026u.setPullLoadEnable(true);
        this.f26026u.setPullRefreshEnable(true);
        d0();
        D(getResources().getString(R.string.no_order_msg));
        return this.f26026u;
    }

    public void d0() {
        this.f26030y = new MyBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.haier.globalwasher.modle.d.f24392a);
        if (Build.VERSION.SDK_INT >= 33) {
            this.f26027v.registerReceiver(this.f26030y, intentFilter, 4);
        } else {
            this.f26027v.registerReceiver(this.f26030y, intentFilter);
        }
    }

    public void e0(OrderDetailsBeen orderDetailsBeen) {
        this.C = orderDetailsBeen;
    }

    public void f0() {
        v3.b uBluetoothBean;
        if (a0() == null) {
            i0.d(this.f26027v, "Parameter exception");
            return;
        }
        if (a0().getDeviceList().getBlueToolthInfo() != null) {
            q.c(this.F, "" + a0().getBlueMac() + "----" + a0().getDirective());
            int i7 = Integer.parseInt(a0().getDeviceList().getBlueToolthInfo().getModuleType());
            if (i7 != 1) {
                uBluetoothBean = i7 != 2 ? null : new w3.a(a0().getDeviceList().getBlueToolthInfo().getAccessToken(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective());
            } else {
                uBluetoothBean = new UBluetoothBean(a0().getDeviceList().getBlueToolthInfo().getAccessToken(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective());
            }
            X().w(uBluetoothBean, X());
        }
    }

    public void g0(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, boolean z7) {
        X().s(cVar);
        Y();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.B;
        if (aVar != null) {
            aVar.u(X());
        }
    }

    public void h0() {
        v3.b uBluetoothBean;
        if (a0() == null) {
            i0.d(this.f26027v, "Parameter exception");
            return;
        }
        if (a0().getDeviceList().getBlueToolthInfo() != null) {
            int i7 = Integer.parseInt(a0().getDeviceList().getBlueToolthInfo().getModuleType());
            if (i7 != 1) {
                uBluetoothBean = i7 != 2 ? null : new w3.a(a0().getDeviceList().getBlueToolthInfo().getAccessToken(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective());
            } else {
                uBluetoothBean = new UBluetoothBean(a0().getDeviceList().getBlueToolthInfo().getAccessToken(), a0().getDeviceList().getBlueToolthInfo().getBlueName(), a0().getDeviceList().getBlueToolthInfo().getDirective());
            }
            X().y(uBluetoothBean, X());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        MyBroadcastReceiver myBroadcastReceiver;
        CountDownBroadcastReceiver countDownBroadcastReceiver;
        try {
            MainActivity mainActivity = this.f26027v;
            if (mainActivity != null && (countDownBroadcastReceiver = this.f26029x) != null) {
                mainActivity.unregisterReceiver(countDownBroadcastReceiver);
                this.f26029x = null;
            }
            MainActivity mainActivity2 = this.f26027v;
            if (mainActivity2 != null && (myBroadcastReceiver = this.f26030y) != null) {
                mainActivity2.unregisterReceiver(myBroadcastReceiver);
                this.f26030y = null;
            }
        } catch (Exception unused) {
        }
        super.onDestroy();
    }
}
