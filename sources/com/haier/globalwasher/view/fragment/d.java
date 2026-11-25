package com.haier.globalwasher.view.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.DeviceListBeen;
import com.haier.globalwasher.modle.bean.LaundryRealted;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.presenter.g;
import com.haier.globalwasher.view.activity.device.DeviceBaseActivity;
import com.haier.globalwasher.view.activity.device.DryerDetaileActivity;
import com.haier.globalwasher.view.activity.device.WasherDeviceDetaileActivity;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.globalwasher.base.b<DeviceListBeen> implements com.haier.globalwasher.mvp_api.adapter.d<DeviceListBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    private static final int D = 4;
    private static final String E = "laundryId";
    private static final String F = "type";
    private static final String G = "floorNumber";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private XListView f26128s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Resources f26129t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private BaseActivity f26130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private g f26131v = new g();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a f26132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    LaundryRealted f26133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f26134y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    String f26135z;

    class a extends com.haier.globalwasher.base.b<DeviceListBeen>.a {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.fragment.d$a$a, reason: collision with other inner class name */
        class C0345a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f26137a;

            C0345a(ArrayList arrayList) {
                this.f26137a = arrayList;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                if (i.a()) {
                    return;
                }
                int i8 = i7 - 1;
                if (((DeviceListBeen) this.f26137a.get(i8)).getStatus().equals("1") || ((DeviceListBeen) this.f26137a.get(i8)).getStatus().equals("2")) {
                    if ("1".equals(d.this.f26134y) || "3".equals(d.this.f26134y)) {
                        DeviceBaseActivity.O0(d.this.f26130u, WasherDeviceDetaileActivity.class, ((DeviceListBeen) this.f26137a.get(i8)).getDeviceId(), null);
                        return;
                    } else {
                        DeviceBaseActivity.O0(d.this.f26130u, DryerDetaileActivity.class, ((DeviceListBeen) this.f26137a.get(i8)).getDeviceId(), null);
                        return;
                    }
                }
                if (((DeviceListBeen) this.f26137a.get(i8)).getStatus().equals("3")) {
                    z.d(d.this.f26130u, 1, d.this.f26129t.getString(R.string.reservations_are_not_available_APPOINTMENT), d.this.f26129t.getString(R.string.reservations_are_not_available_details), "", null);
                } else if (((DeviceListBeen) this.f26137a.get(i8)).getStatus().equals("4")) {
                    z.b(d.this.f26130u, 1, 1, 1, d.this.f26129t.getString(R.string.reservations_are_not_available_SERVICE), d.this.f26129t.getString(R.string.reservations_are_not_available_machine), d.this.f26129t.getString(R.string.reservations_are_not_available_one), null, null);
                }
            }
        }

        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.b.a
        public void f(ArrayList<DeviceListBeen> arrayList) {
            if (d.this.f26132w != null) {
                d.this.f26132w.notifyDataSetChanged();
                return;
            }
            d.this.f26132w = new com.haier.globalwasher.mvp_api.adapter.a(d.this.f26130u, arrayList, d.this);
            d.this.f26128s.setAdapter((ListAdapter) d.this.f26132w);
            d.this.f26128s.setOnItemClickListener(new C0345a(arrayList));
        }
    }

    public static d V(LaundryRealted laundryRealted, String str, String str2) {
        Bundle bundle;
        d dVar = new d();
        if (dVar.getArguments() != null) {
            bundle = dVar.getArguments();
        } else {
            bundle = new Bundle();
            dVar.setArguments(bundle);
        }
        bundle.putSerializable(E, laundryRealted);
        bundle.putString("type", str);
        bundle.putString(G, str2);
        return dVar;
    }

    @Override // com.haier.globalwasher.base.b
    public com.haier.globalwasher.mvp_api.presenter.b J() {
        this.f26130u = (BaseActivity) getActivity();
        Bundle arguments = getArguments();
        this.f26133x = (LaundryRealted) arguments.getSerializable(E);
        this.f26134y = arguments.getString("type");
        this.f26135z = arguments.getString(G);
        return this.f26131v;
    }

    @Override // com.haier.globalwasher.base.b
    public ListView K() {
        this.f26129t = getResources();
        this.f26128s = (XListView) findViewById(R.id.xlv_details);
        this.f26130u = (BaseActivity) getActivity();
        return this.f26128s;
    }

    @Override // com.haier.globalwasher.base.b
    public void N(int i7, int i8) {
        LaundryRealted laundryRealted = this.f26133x;
        if (laundryRealted != null) {
            this.f26131v.g(laundryRealted.getLaundry().getLaundryId(), this.f26134y, i7, this.f26135z, new a());
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, DeviceListBeen deviceListBeen) {
        int i8 = 0;
        bVar.b(R.id.details_laundry_name, R.id.details_laundry_available, R.id.details_laundry_line, R.id.details_laundry_time, R.id.details_laundry_floor, R.id.v_padding, R.id.laundry_lin);
        TextView textView = (TextView) bVar.a(R.id.details_laundry_name);
        TextView textView2 = (TextView) bVar.a(R.id.details_laundry_available);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.laundry_lin);
        ((View) bVar.a(R.id.v_padding)).getLayoutParams().height = 15;
        View view = (View) bVar.a(R.id.details_laundry_line);
        TextView textView3 = (TextView) bVar.a(R.id.details_laundry_time);
        TextView textView4 = (TextView) bVar.a(R.id.details_laundry_floor);
        textView.setText("#" + d0.f(deviceListBeen.getSerialNumber()) + " " + deviceListBeen.getName());
        StringBuilder sb = new StringBuilder();
        sb.append(d0.c(deviceListBeen.getSerialNumber()));
        sb.append(this.f26129t.getString(R.string.the_laundry_is_floor_F));
        textView4.setText(sb.toString());
        if (deviceListBeen.getTimeRemaining() != null && !"".equals(deviceListBeen.getTimeRemaining()) && !"null".equals(deviceListBeen.getTimeRemaining())) {
            textView3.setText(this.f26129t.getString(R.string.laundry_details_pages_remaining) + " " + deviceListBeen.getTimeRemaining() + this.f26129t.getString(R.string.laundry_details_pages_time_min));
        }
        int i9 = Integer.parseInt(deviceListBeen.getStatus());
        if (i9 == 1) {
            textView2.setText(this.f26129t.getString(R.string.Nearby_laundry_atlas_available));
            linearLayout.setBackgroundResource(R.drawable.details_laundry_item_background);
            textView2.setTextColor(this.f26129t.getColor(R.color.app_zhexian_blue_relg));
            view.setVisibility(8);
            textView3.setVisibility(8);
            if (this.f26134y.equals("1")) {
                i8 = R.drawable.icon_xiyiji_kongxian;
            } else if (this.f26134y.equals("2")) {
                i8 = R.drawable.icon_dryer;
            } else if (this.f26134y.equals("3")) {
                i8 = R.drawable.icon_shoesi_kongxian;
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(i8), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (i9 == 2) {
            textView2.setText(this.f26129t.getString(R.string.laundry_details_pages_inuse));
            textView2.setTextColor(this.f26129t.getColor(R.color.laundry_coler));
            linearLayout.setBackgroundResource(R.drawable.details_laundry_item_hong_background);
            textView3.setTextColor(this.f26129t.getColor(R.color.laundry_coler));
            textView3.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(R.drawable.icon_dengdai_red_xiyidianxiangqing), (Drawable) null, (Drawable) null, (Drawable) null);
            view.setVisibility(0);
            textView3.setVisibility(0);
            if (this.f26134y.equals("1")) {
                i8 = R.drawable.icon_xiyiji_shiyong;
            } else if (this.f26134y.equals("2")) {
                i8 = R.drawable.icon_dryer_use;
            } else if (this.f26134y.equals("3")) {
                i8 = R.drawable.icon_shoes_shiyong;
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(i8), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (i9 != 3) {
            if (i9 != 4) {
                return;
            }
            textView2.setText(this.f26129t.getString(R.string.laundry_details_pages_service));
            textView2.setTextColor(this.f26129t.getColor(R.color.laundry_coler_hui));
            linearLayout.setBackgroundResource(R.drawable.details_laundry_item_hui_background);
            view.setVisibility(8);
            textView3.setVisibility(8);
            textView2.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(R.drawable.icon_remain), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView2.setText(this.f26129t.getString(R.string.laundry_details_pages_inuse));
        textView2.setTextColor(this.f26129t.getColor(R.color.laundry_coler_hui));
        linearLayout.setBackgroundResource(R.drawable.details_laundry_item_hui_background);
        textView3.setTextColor(this.f26129t.getColor(R.color.laundry_coler_hui));
        textView3.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(R.drawable.icon_dengdai_gray_xiyidianxiangqing), (Drawable) null, (Drawable) null, (Drawable) null);
        view.setVisibility(0);
        textView3.setVisibility(0);
        if (this.f26134y.equals("1")) {
            i8 = R.drawable.icon_xiyi_dis;
        } else if (this.f26134y.equals("2")) {
            i8 = R.drawable.icon_dryer_dis;
        } else if (this.f26134y.equals("3")) {
            i8 = R.drawable.icon_shoes_dis;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(this.f26129t.getDrawable(i8), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this.f26130u, View.inflate(this.f26130u, R.layout.details_laundry_item, null), 1);
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.wash_device_list_fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
