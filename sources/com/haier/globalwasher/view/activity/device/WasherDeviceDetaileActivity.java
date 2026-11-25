package com.haier.globalwasher.view.activity.device;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.RunModeBeen;
import com.haier.globalwasher.modle.bean.ShowRunModeBeen;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class WasherDeviceDetaileActivity extends DeviceBaseActivity {
    private RecyclerView H0;
    com.haier.globalwasher.view.adapter.a I0;
    DeviceBaseActivity.k J0;
    int K0;
    int L0;
    int M0;
    int N0;
    private String O0;
    d T0;
    String P0 = "DETAIL_DEVICE";
    private final String Q0 = "R";
    private ArrayList<ShowRunModeBeen> R0 = new ArrayList<>();
    private ArrayList<RunModeBeen> S0 = new ArrayList<>();
    private int U0 = 0;

    class a extends DeviceBaseActivity.k {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity.k, com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<RunModeBeen> arrayList) {
            super.f(arrayList);
            WasherDeviceDetaileActivity.this.S0.clear();
            WasherDeviceDetaileActivity.this.S0.addAll(arrayList);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity = WasherDeviceDetaileActivity.this;
            com.haier.globalwasher.mvp_api.adapter.a<RunModeBeen, com.haier.globalwasher.mvp_api.adapter.b> aVar = washerDeviceDetaileActivity.R;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                WasherDeviceDetaileActivity washerDeviceDetaileActivity2 = WasherDeviceDetaileActivity.this;
                washerDeviceDetaileActivity2.P0(washerDeviceDetaileActivity2.J0());
                return;
            }
            washerDeviceDetaileActivity.K0 = washerDeviceDetaileActivity.B.getColor(R.color.app_black_6);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity3 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity3.L0 = washerDeviceDetaileActivity3.B.getColor(R.color.app_text);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity4 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity4.M0 = washerDeviceDetaileActivity4.B.getColor(R.color.app_white);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity5 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity5.N0 = washerDeviceDetaileActivity5.B.getColor(R.color.app_zhexian_blue_relg);
            ((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(0)).setSelect(true);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity6 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity6.O0 = ((RunModeBeen) washerDeviceDetaileActivity6.S0.get(0)).getModeId();
            WasherDeviceDetaileActivity washerDeviceDetaileActivity7 = WasherDeviceDetaileActivity.this;
            WasherDeviceDetaileActivity washerDeviceDetaileActivity8 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity7.R = new com.haier.globalwasher.mvp_api.adapter.a<>(washerDeviceDetaileActivity8, washerDeviceDetaileActivity8.S0, WasherDeviceDetaileActivity.this);
            WasherDeviceDetaileActivity.this.J0().setAdapter((ListAdapter) WasherDeviceDetaileActivity.this.R);
            WasherDeviceDetaileActivity.this.a1(0);
            WasherDeviceDetaileActivity washerDeviceDetaileActivity9 = WasherDeviceDetaileActivity.this;
            washerDeviceDetaileActivity9.P0(washerDeviceDetaileActivity9.J0());
            Message message = new Message();
            message.what = 1;
            message.obj = WasherDeviceDetaileActivity.this.S0.get(0);
            WasherDeviceDetaileActivity.this.C0.sendMessage(message);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RunModeBeen f25507b;

        b(int i7, RunModeBeen runModeBeen) {
            this.f25506a = i7;
            this.f25507b = runModeBeen;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WasherDeviceDetaileActivity.this.U.clear();
            for (int i7 = 0; i7 < WasherDeviceDetaileActivity.this.S0.size(); i7++) {
                if (i7 == this.f25506a) {
                    ((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(i7)).setSelect(true ^ ((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(i7)).isSelect());
                    if (((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(i7)).isSelect()) {
                        WasherDeviceDetaileActivity washerDeviceDetaileActivity = WasherDeviceDetaileActivity.this;
                        washerDeviceDetaileActivity.O0 = ((RunModeBeen) washerDeviceDetaileActivity.S0.get(i7)).getModeId();
                    } else {
                        WasherDeviceDetaileActivity washerDeviceDetaileActivity2 = WasherDeviceDetaileActivity.this;
                        washerDeviceDetaileActivity2.O0 = ((RunModeBeen) washerDeviceDetaileActivity2.S0.get(0)).getModeId();
                    }
                } else {
                    ((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(i7)).setSelect(false);
                }
            }
            q.c("RequestNetWork", "    modeID= " + WasherDeviceDetaileActivity.this.O0 + "   --");
            if (((RunModeBeen) WasherDeviceDetaileActivity.this.S0.get(this.f25506a)).isSelect()) {
                WasherDeviceDetaileActivity.this.U0 = this.f25506a;
            } else {
                WasherDeviceDetaileActivity.this.U0 = 0;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = this.f25507b;
            WasherDeviceDetaileActivity.this.C0.sendMessage(message);
            WasherDeviceDetaileActivity.this.a1(this.f25506a);
        }
    }

    public interface c {
        ArrayList<String> a(boolean z7, ShowRunModeBeen showRunModeBeen);
    }

    public class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25509a;

        public d(int i7) {
            this.f25509a = i7;
        }

        @Override // com.haier.globalwasher.view.activity.device.WasherDeviceDetaileActivity.c
        public ArrayList<String> a(boolean z7, ShowRunModeBeen showRunModeBeen) {
            q.c("RequestNetWork", "position==" + this.f25509a);
            if (z7) {
                WasherDeviceDetaileActivity.this.U.add(showRunModeBeen.getCode());
                if ("R".equals(showRunModeBeen.getSelectType().split("_")[0])) {
                    for (int i7 = 0; i7 < WasherDeviceDetaileActivity.this.R0.size(); i7++) {
                        if (showRunModeBeen.getSelectType().equals(((ShowRunModeBeen) WasherDeviceDetaileActivity.this.R0.get(i7)).getSelectType()) && !showRunModeBeen.getCode().equals(((ShowRunModeBeen) WasherDeviceDetaileActivity.this.R0.get(i7)).getCode())) {
                            ((ShowRunModeBeen) WasherDeviceDetaileActivity.this.R0.get(i7)).setSelect(false);
                        }
                    }
                }
            } else {
                Iterator<String> it = WasherDeviceDetaileActivity.this.U.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(showRunModeBeen.getCode())) {
                        it.remove();
                    }
                }
                if (WasherDeviceDetaileActivity.this.U.size() == 0) {
                    WasherDeviceDetaileActivity washerDeviceDetaileActivity = WasherDeviceDetaileActivity.this;
                    washerDeviceDetaileActivity.O0 = ((RunModeBeen) washerDeviceDetaileActivity.S0.get(WasherDeviceDetaileActivity.this.U0)).getModeId();
                    Message message = new Message();
                    message.what = 1;
                    message.obj = WasherDeviceDetaileActivity.this.S0.get(WasherDeviceDetaileActivity.this.U0);
                    WasherDeviceDetaileActivity.this.C0.sendMessage(message);
                    return WasherDeviceDetaileActivity.this.U;
                }
            }
            for (int i8 = 0; i8 < WasherDeviceDetaileActivity.this.V.size(); i8++) {
                String[] strArrSplit = WasherDeviceDetaileActivity.this.V.get(i8).getCode().split("_");
                int size = WasherDeviceDetaileActivity.this.U.size();
                if (strArrSplit.length == size + 1) {
                    int i9 = 0;
                    for (String str : strArrSplit) {
                        for (int i10 = 0; i10 < size; i10++) {
                            if (str.equals(WasherDeviceDetaileActivity.this.U.get(i10))) {
                                i9++;
                            }
                        }
                    }
                    if (i9 == size) {
                        WasherDeviceDetaileActivity washerDeviceDetaileActivity2 = WasherDeviceDetaileActivity.this;
                        washerDeviceDetaileActivity2.W = washerDeviceDetaileActivity2.V.get(i8);
                        WasherDeviceDetaileActivity washerDeviceDetaileActivity3 = WasherDeviceDetaileActivity.this;
                        washerDeviceDetaileActivity3.O0 = washerDeviceDetaileActivity3.W.getModeId();
                        Message message2 = new Message();
                        message2.what = 2;
                        WasherDeviceDetaileActivity washerDeviceDetaileActivity4 = WasherDeviceDetaileActivity.this;
                        message2.obj = washerDeviceDetaileActivity4.W;
                        message2.arg1 = washerDeviceDetaileActivity4.U0;
                        WasherDeviceDetaileActivity.this.C0.sendMessage(message2);
                        System.out.println("----" + WasherDeviceDetaileActivity.this.W.getCode());
                        break;
                    }
                }
            }
            return WasherDeviceDetaileActivity.this.U;
        }

        public void b(int i7) {
            this.f25509a = i7;
        }
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public View D0() {
        View viewInflate = View.inflate(this, R.layout.activity_washer_detaile, null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rcv_run_mode);
        this.H0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.H0.setItemAnimator(new h());
        return viewInflate;
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public String L0() {
        return this.O0;
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public DeviceBaseActivity.k M0() {
        if (this.J0 == null) {
            this.J0 = new a();
        }
        return this.J0;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 23)
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, RunModeBeen runModeBeen) {
        bVar.b(R.id.iv_image, R.id.tv_name, R.id.tv_time_mins, R.id.tv_price, R.id.tv_introduce, R.id.lly_select_model);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_select_model);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_image);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_name);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.tv_time_mins);
        FontTextView fontTextView3 = (FontTextView) bVar.a(R.id.tv_price);
        FontTextView fontTextView4 = (FontTextView) bVar.a(R.id.tv_introduce);
        fontTextView4.setText(runModeBeen.getModeFeature());
        N0(runModeBeen.isSelect(), runModeBeen.getModeImage(), imageView, i7);
        if (runModeBeen.isSelect()) {
            fontTextView.setTextColor(this.M0);
            fontTextView2.setTextColor(this.M0);
            fontTextView3.setTextColor(this.M0);
            if (runModeBeen.getModeFeature() != null) {
                fontTextView4.setVisibility(0);
            }
            linearLayout.setBackground(getResources().getDrawable(R.drawable.cardview_background_appblue));
        } else {
            fontTextView.setTextColor(this.K0);
            fontTextView2.setTextColor(this.L0);
            fontTextView3.setTextColor(this.N0);
            fontTextView4.setVisibility(8);
            linearLayout.setBackground(getResources().getDrawable(R.drawable.cardview_background));
        }
        fontTextView.setText(runModeBeen.getModeName());
        fontTextView2.setText(runModeBeen.getTimeDuration() + getResources().getString(R.string.payment_success_pageds_time_unit));
        if (I0() != null) {
            fontTextView3.setText(I0().getCurrencySymbol() + " " + runModeBeen.getPrice());
        } else {
            fontTextView3.setText(I0().getCurrencySymbol() + " " + runModeBeen.getPrice());
        }
        linearLayout.setOnClickListener(new b(i7, runModeBeen));
    }

    public void a1(int i7) {
        this.V.clear();
        if (this.S0.get(i7).getSubRunMode() != null) {
            this.V.addAll(this.S0.get(i7).getSubRunMode());
        }
        this.R0.clear();
        if (this.S0.get(i7).getShowRunMode() == null || this.S0.get(i7).getShowRunMode().size() <= 0) {
            this.H0.setVisibility(8);
            return;
        }
        if (!this.S0.get(i7).isSelect()) {
            this.H0.setVisibility(8);
            return;
        }
        this.H0.setVisibility(0);
        this.R0.addAll(this.S0.get(i7).getShowRunMode());
        for (int i8 = 0; i8 < this.R0.size(); i8++) {
            this.R0.get(i8).setSelect(false);
        }
        if (this.I0 != null) {
            this.T0.b(i7);
            this.I0.j();
            return;
        }
        d dVar = new d(i7);
        this.T0 = dVar;
        com.haier.globalwasher.view.adapter.a aVar = new com.haier.globalwasher.view.adapter.a(this.R0, 4, dVar);
        this.I0 = aVar;
        this.H0.setAdapter(aVar);
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.device_detail_model_list, null), 4);
    }
}
