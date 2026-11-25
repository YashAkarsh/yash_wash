package com.haier.globalwasher.view.activity.device;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.RunModeBeen;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.seekbar.RangeSeekBar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DryerDetaileActivity extends DeviceBaseActivity {
    private BigDecimal H0;
    RangeSeekBar I0;
    FontTextView J0;
    private String L0;
    private DeviceBaseActivity.k N0;
    private RunModeBeen K0 = new RunModeBeen();
    private String M0 = "BaseListAdapter";
    private ArrayList<RunModeBeen> O0 = new ArrayList<>();
    private ArrayList<RunModeBeen> P0 = new ArrayList<>();

    class a implements RangeSeekBar.c {
        a() {
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.RangeSeekBar.c
        public void a(int i7) {
            if (DryerDetaileActivity.this.O0.size() > 0) {
                DryerDetaileActivity dryerDetaileActivity = DryerDetaileActivity.this;
                dryerDetaileActivity.O = i7;
                dryerDetaileActivity.H0 = new BigDecimal(DryerDetaileActivity.this.P * ((double) i7));
                DryerDetaileActivity dryerDetaileActivity2 = DryerDetaileActivity.this;
                dryerDetaileActivity2.H0 = dryerDetaileActivity2.H0.setScale(2, 4);
                q.c(DryerDetaileActivity.this.M0, "count=" + i7 + "CurrentTime=" + DryerDetaileActivity.this.O + "price=" + DryerDetaileActivity.this.H0.toString() + " unitCost=" + DryerDetaileActivity.this.P);
                DryerDetaileActivity dryerDetaileActivity3 = DryerDetaileActivity.this;
                dryerDetaileActivity3.K0 = dryerDetaileActivity3.e1((RunModeBeen) dryerDetaileActivity3.O0.get(DryerDetaileActivity.this.K0()));
                RunModeBeen runModeBeen = DryerDetaileActivity.this.K0;
                StringBuilder sb = new StringBuilder();
                DryerDetaileActivity dryerDetaileActivity4 = DryerDetaileActivity.this;
                sb.append(dryerDetaileActivity4.O * dryerDetaileActivity4.N);
                sb.append("");
                runModeBeen.setTimeDuration(sb.toString());
                DryerDetaileActivity.this.K0.setPrice(DryerDetaileActivity.this.H0 + "");
                DryerDetaileActivity dryerDetaileActivity5 = DryerDetaileActivity.this;
                dryerDetaileActivity5.L0 = dryerDetaileActivity5.K0.getModeId();
                Message message = new Message();
                message.what = 1;
                message.obj = DryerDetaileActivity.this.K0;
                DryerDetaileActivity.this.C0.sendMessage(message);
            }
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.RangeSeekBar.c
        public void b(int i7, int i8) {
        }
    }

    class b extends DeviceBaseActivity.k {

        class a extends com.haier.globalwasher.mvp_api.adapter.a {
            a(Context context, List list, d dVar) {
                super(context, list, dVar);
            }

            @Override // com.haier.globalwasher.mvp_api.adapter.a, android.widget.Adapter
            public int getCount() {
                return (DryerDetaileActivity.this.O0.size() / 2) + (DryerDetaileActivity.this.O0.size() % 2);
            }
        }

        b() {
            super();
        }

        @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity.k, com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<RunModeBeen> arrayList) {
            super.f(arrayList);
            DryerDetaileActivity.this.O0.clear();
            DryerDetaileActivity.this.O0.addAll(arrayList);
            DryerDetaileActivity.this.P0 = arrayList;
            DryerDetaileActivity dryerDetaileActivity = DryerDetaileActivity.this;
            if (dryerDetaileActivity.R != null) {
                dryerDetaileActivity.P0(dryerDetaileActivity.J0());
                return;
            }
            if (dryerDetaileActivity.O0.size() == 0) {
                return;
            }
            DryerDetaileActivity.this.Q0(0);
            DryerDetaileActivity dryerDetaileActivity2 = DryerDetaileActivity.this;
            dryerDetaileActivity2.L0 = ((RunModeBeen) dryerDetaileActivity2.O0.get(0)).getModeId();
            ((RunModeBeen) DryerDetaileActivity.this.O0.get(0)).setSelect(true);
            DryerDetaileActivity dryerDetaileActivity3 = DryerDetaileActivity.this;
            dryerDetaileActivity3.P = Double.valueOf(((RunModeBeen) dryerDetaileActivity3.O0.get(0)).getPrice()).doubleValue();
            DryerDetaileActivity dryerDetaileActivity4 = DryerDetaileActivity.this;
            dryerDetaileActivity4.I0.setDefaultCount(dryerDetaileActivity4.O);
            DryerDetaileActivity dryerDetaileActivity5 = DryerDetaileActivity.this;
            DryerDetaileActivity dryerDetaileActivity6 = DryerDetaileActivity.this;
            dryerDetaileActivity5.R = new a(dryerDetaileActivity6, dryerDetaileActivity6.O0, DryerDetaileActivity.this);
            DryerDetaileActivity.this.J0().setAdapter((ListAdapter) DryerDetaileActivity.this.R);
            DryerDetaileActivity dryerDetaileActivity7 = DryerDetaileActivity.this;
            dryerDetaileActivity7.P0(dryerDetaileActivity7.J0());
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25503a;

        c(int i7) {
            this.f25503a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i7 = 0; i7 < DryerDetaileActivity.this.O0.size(); i7++) {
                if (i7 == this.f25503a) {
                    DryerDetaileActivity.this.O0.clear();
                    DryerDetaileActivity.this.O0.addAll(DryerDetaileActivity.this.P0);
                    ((RunModeBeen) DryerDetaileActivity.this.O0.get(this.f25503a)).setSelect(!((RunModeBeen) DryerDetaileActivity.this.O0.get(this.f25503a)).isSelect());
                    Message message = new Message();
                    message.what = 1;
                    if (((RunModeBeen) DryerDetaileActivity.this.O0.get(this.f25503a)).isSelect()) {
                        DryerDetaileActivity dryerDetaileActivity = DryerDetaileActivity.this;
                        dryerDetaileActivity.P = Double.valueOf(((RunModeBeen) dryerDetaileActivity.O0.get(this.f25503a)).getPrice()).doubleValue();
                        DryerDetaileActivity dryerDetaileActivity2 = DryerDetaileActivity.this;
                        dryerDetaileActivity2.O = 9;
                        DryerDetaileActivity dryerDetaileActivity3 = DryerDetaileActivity.this;
                        dryerDetaileActivity2.H0 = new BigDecimal(dryerDetaileActivity3.P * ((double) dryerDetaileActivity3.O));
                        DryerDetaileActivity dryerDetaileActivity4 = DryerDetaileActivity.this;
                        dryerDetaileActivity4.H0 = dryerDetaileActivity4.H0.setScale(2, 4);
                        DryerDetaileActivity dryerDetaileActivity5 = DryerDetaileActivity.this;
                        dryerDetaileActivity5.I0.setDefaultCount(dryerDetaileActivity5.O);
                        DryerDetaileActivity.this.Q0(this.f25503a);
                        DryerDetaileActivity dryerDetaileActivity6 = DryerDetaileActivity.this;
                        dryerDetaileActivity6.K0 = dryerDetaileActivity6.e1((RunModeBeen) dryerDetaileActivity6.O0.get(this.f25503a));
                        RunModeBeen runModeBeen = DryerDetaileActivity.this.K0;
                        StringBuilder sb = new StringBuilder();
                        DryerDetaileActivity dryerDetaileActivity7 = DryerDetaileActivity.this;
                        sb.append(dryerDetaileActivity7.O * dryerDetaileActivity7.N);
                        sb.append("");
                        runModeBeen.setTimeDuration(sb.toString());
                        DryerDetaileActivity.this.K0.setPrice(DryerDetaileActivity.this.H0 + "");
                        DryerDetaileActivity dryerDetaileActivity8 = DryerDetaileActivity.this;
                        dryerDetaileActivity8.L0 = dryerDetaileActivity8.K0.getModeId();
                        message.obj = DryerDetaileActivity.this.K0;
                    } else {
                        DryerDetaileActivity dryerDetaileActivity9 = DryerDetaileActivity.this;
                        dryerDetaileActivity9.P = Double.valueOf(((RunModeBeen) dryerDetaileActivity9.O0.get(0)).getPrice()).doubleValue();
                        DryerDetaileActivity dryerDetaileActivity10 = DryerDetaileActivity.this;
                        dryerDetaileActivity10.O = 9;
                        DryerDetaileActivity dryerDetaileActivity11 = DryerDetaileActivity.this;
                        dryerDetaileActivity10.H0 = new BigDecimal(dryerDetaileActivity11.P * ((double) dryerDetaileActivity11.O));
                        DryerDetaileActivity dryerDetaileActivity12 = DryerDetaileActivity.this;
                        dryerDetaileActivity12.H0 = dryerDetaileActivity12.H0.setScale(2, 4);
                        DryerDetaileActivity dryerDetaileActivity13 = DryerDetaileActivity.this;
                        dryerDetaileActivity13.K0 = dryerDetaileActivity13.e1((RunModeBeen) dryerDetaileActivity13.O0.get(0));
                        RunModeBeen runModeBeen2 = DryerDetaileActivity.this.K0;
                        StringBuilder sb2 = new StringBuilder();
                        DryerDetaileActivity dryerDetaileActivity14 = DryerDetaileActivity.this;
                        sb2.append(dryerDetaileActivity14.O * dryerDetaileActivity14.N);
                        sb2.append("");
                        runModeBeen2.setTimeDuration(sb2.toString());
                        DryerDetaileActivity.this.K0.setPrice(DryerDetaileActivity.this.H0 + "");
                        DryerDetaileActivity dryerDetaileActivity15 = DryerDetaileActivity.this;
                        dryerDetaileActivity15.L0 = dryerDetaileActivity15.K0.getModeId();
                        DryerDetaileActivity dryerDetaileActivity16 = DryerDetaileActivity.this;
                        dryerDetaileActivity16.I0.setDefaultCount(dryerDetaileActivity16.O);
                        DryerDetaileActivity.this.Q0(0);
                        message.obj = DryerDetaileActivity.this.K0;
                    }
                    q.c(DryerDetaileActivity.this.M0, "unitCost=" + DryerDetaileActivity.this.P + " CurrentTime=" + DryerDetaileActivity.this.O + "  viewPosition=" + this.f25503a + "  price=" + DryerDetaileActivity.this.H0 + "=====");
                    DryerDetaileActivity.this.C0.sendMessage(message);
                } else {
                    ((RunModeBeen) DryerDetaileActivity.this.O0.get(i7)).setSelect(false);
                }
            }
        }
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public View D0() {
        View viewInflate = View.inflate(this, R.layout.activity_dryer_detaile, null);
        this.J0 = (FontTextView) viewInflate.findViewById(R.id.tv_desc);
        RangeSeekBar rangeSeekBar = (RangeSeekBar) viewInflate.findViewById(R.id.range_seekBar);
        this.I0 = rangeSeekBar;
        rangeSeekBar.setOnRangeChangeListener(new a());
        return viewInflate;
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public String L0() {
        return this.L0;
    }

    @Override // com.haier.globalwasher.view.activity.device.DeviceBaseActivity
    public DeviceBaseActivity.k M0() {
        if (this.N0 == null) {
            this.N0 = new b();
        }
        return this.N0;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, RunModeBeen runModeBeen) {
        int i8;
        int i9;
        int i10;
        bVar.b(R.id.lly_margin_1, R.id.lly_margin_2, R.id.iv_image_1, R.id.tv_name_1, R.id.iv_image_2, R.id.tv_name_2, R.id.tv_introduce);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_margin_1);
        LinearLayout linearLayout2 = (LinearLayout) bVar.a(R.id.lly_margin_2);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_image_1);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_name_1);
        ImageView imageView2 = (ImageView) bVar.a(R.id.iv_image_2);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.tv_name_2);
        FontTextView fontTextView3 = (FontTextView) bVar.a(R.id.tv_introduce);
        if (i7 == 0) {
            i9 = 1;
            i8 = 0;
        } else {
            int i11 = i7 * 2;
            i8 = i11;
            i9 = i11 + 1;
        }
        J0().setVisibility(0);
        if (this.O0.size() <= i8) {
            i10 = i9;
        } else if (this.O0.size() > i9) {
            i10 = i9;
            f1(i9, i8, imageView, fontTextView, linearLayout, fontTextView3);
        } else {
            i10 = i9;
            f1(-1, i8, imageView, fontTextView, linearLayout, fontTextView3);
        }
        if (this.O0.size() <= i10) {
            linearLayout2.setVisibility(4);
        } else {
            linearLayout2.setVisibility(0);
            f1(i8, i10, imageView2, fontTextView2, linearLayout2, fontTextView3);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.device_detail_model_dryer, null), 4);
    }

    public RunModeBeen e1(RunModeBeen runModeBeen) {
        this.K0.setPrice(this.H0 + "");
        this.K0.setTimeDuration((this.O * this.N) + "");
        this.K0.setSelect(runModeBeen.isSelect());
        this.K0.setCode(runModeBeen.getCode());
        this.K0.setIsDisply(runModeBeen.getIsDisply());
        this.K0.setModeDescription(runModeBeen.getModeDescription());
        this.K0.setModeId(runModeBeen.getModeId());
        this.K0.setModeFeature(runModeBeen.getModeFeature());
        this.K0.setModeImage(runModeBeen.getModeImage());
        this.K0.setModeName(runModeBeen.getModeName());
        this.K0.setSubRunMode(runModeBeen.getSubRunMode());
        this.K0.setShowRunMode(runModeBeen.getShowRunMode());
        return this.K0;
    }

    public void f1(int i7, int i8, ImageView imageView, FontTextView fontTextView, LinearLayout linearLayout, FontTextView fontTextView2) {
        q.c(this.M0, "runModeBeens.get(" + i8 + ")" + this.O0.get(i8).isSelect());
        if (this.O0.get(i8).isSelect()) {
            if (this.O0.get(i8).getModeFeature() != null) {
                fontTextView2.setVisibility(0);
                fontTextView2.setText(this.O0.get(i8).getModeFeature());
            }
            if (this.E0.get(this.O0.get(i8).getModeImage()) != null) {
                imageView.setImageDrawable(this.E0.get(this.O0.get(i8).getModeImage()));
            } else if (this.O0.get(i8).getModeImage() != null && !"".equals(this.O0.get(i8).getModeImage())) {
                N0(this.O0.get(i8).isSelect(), this.O0.get(i8).getModeImage(), imageView, i8);
            }
            fontTextView.setTextColor(this.B.getColor(R.color.app_white));
            linearLayout.setBackground(this.B.getDrawable(R.drawable.cardview_background_appblue));
        } else {
            if (this.D0.get(this.O0.get(i8).getModeImage()) != null) {
                imageView.setImageDrawable(this.D0.get(this.O0.get(i8).getModeImage()));
            } else if (this.O0.get(i8).getModeImage() != null && !"".equals(this.O0.get(i8).getModeImage())) {
                N0(this.O0.get(i8).isSelect(), this.O0.get(i8).getModeImage(), imageView, i8);
            }
            fontTextView.setTextColor(this.B.getColor(R.color.app_black_6));
            if (i7 == -1 || !this.O0.get(i7).isSelect()) {
                fontTextView2.setVisibility(8);
            }
            linearLayout.setBackground(this.B.getDrawable(R.drawable.cardview_background));
        }
        fontTextView.setText(this.O0.get(i8).getModeName());
        linearLayout.setOnClickListener(new c(i8));
    }
}
