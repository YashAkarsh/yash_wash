package com.haier.globalwasher.view.activity.laundry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.l;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.LatLng;
import com.haier.globalwasher.modle.bean.LaundryRealted;
import com.haier.globalwasher.modle.e;
import com.haier.globalwasher.modle.e.c;
import com.haier.globalwasher.modle.utils.f0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.presenter.g;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NerabyLaundryWashShoesDryListActivity extends BaseListActivity<LaundryRealted> implements com.haier.globalwasher.mvp_api.adapter.d<LaundryRealted, com.haier.globalwasher.mvp_api.adapter.b> {
    XListView B;
    Resources C;
    private com.haier.globalwasher.mvp_api.adapter.a<LaundryRealted, com.haier.globalwasher.mvp_api.adapter.b> D;
    private Intent E;
    private String F;
    private double H;
    private double I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private MyApplication f25516J;
    private d L;
    private LocationManager N;
    private e.c O;
    private String G = "";
    private ArrayList<LaundryRealted> K = new ArrayList<>();
    private g M = new g();
    private String P = "NerabyLaundryWashShoesDryListActivity";
    Handler Q = new c();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!f0.a(NerabyLaundryWashShoesDryListActivity.this, "com.android.vending")) {
                NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity = NerabyLaundryWashShoesDryListActivity.this;
                z.d(nerabyLaundryWashShoesDryListActivity, 1, "", nerabyLaundryWashShoesDryListActivity.C.getString(R.string.Nearby_laundry_atlas_Please), "", null);
            } else {
                Intent intent = new Intent(NerabyLaundryWashShoesDryListActivity.this, (Class<?>) NerabyLaundryWashShoesDryMapActivity.class);
                intent.putExtra("id", NerabyLaundryWashShoesDryListActivity.this.F);
                intent.putExtra(g.f25148o, NerabyLaundryWashShoesDryListActivity.this.K);
                NerabyLaundryWashShoesDryListActivity.this.startActivity(intent);
            }
        }
    }

    class b extends BaseListActivity<LaundryRealted>.a {

        class a implements AdapterView.OnItemClickListener {
            a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                int i8 = i7 - 1;
                if (((LaundryRealted) NerabyLaundryWashShoesDryListActivity.this.K.get(i8)).getLaundry().getBusinessStatus().equals("2")) {
                    NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity = NerabyLaundryWashShoesDryListActivity.this;
                    LaundryWashShoesDryDetailsActivity.s0(nerabyLaundryWashShoesDryListActivity, (LaundryRealted) nerabyLaundryWashShoesDryListActivity.K.get(i8), NerabyLaundryWashShoesDryListActivity.this.F);
                    return;
                }
                String str = NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_ondetails) + "\n" + NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_working) + " " + ((LaundryRealted) NerabyLaundryWashShoesDryListActivity.this.K.get(i8)).getLaundry().getWorkStartTime() + " " + NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_to) + " " + ((LaundryRealted) NerabyLaundryWashShoesDryListActivity.this.K.get(i8)).getLaundry().getWorkEndTime() + "\n" + NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_saturday) + " " + ((LaundryRealted) NerabyLaundryWashShoesDryListActivity.this.K.get(i8)).getLaundry().getWeekStartTime() + " " + NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_to) + " " + ((LaundryRealted) NerabyLaundryWashShoesDryListActivity.this.K.get(i8)).getLaundry().getWorkEndTime();
                NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity2 = NerabyLaundryWashShoesDryListActivity.this;
                z.d(nerabyLaundryWashShoesDryListActivity2, 1, nerabyLaundryWashShoesDryListActivity2.C.getString(R.string.the_laundry_is_closed_title), NerabyLaundryWashShoesDryListActivity.this.C.getString(R.string.the_laundry_is_closed_smalltitle), str, null);
            }
        }

        b() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<LaundryRealted> arrayList) {
            NerabyLaundryWashShoesDryListActivity.this.K = arrayList;
            if (NerabyLaundryWashShoesDryListActivity.this.D != null) {
                NerabyLaundryWashShoesDryListActivity.this.D.notifyDataSetChanged();
                return;
            }
            NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity = NerabyLaundryWashShoesDryListActivity.this;
            NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity2 = NerabyLaundryWashShoesDryListActivity.this;
            nerabyLaundryWashShoesDryListActivity.D = new com.haier.globalwasher.mvp_api.adapter.a(nerabyLaundryWashShoesDryListActivity2, nerabyLaundryWashShoesDryListActivity2.K, NerabyLaundryWashShoesDryListActivity.this);
            NerabyLaundryWashShoesDryListActivity nerabyLaundryWashShoesDryListActivity3 = NerabyLaundryWashShoesDryListActivity.this;
            nerabyLaundryWashShoesDryListActivity3.B.setAdapter((ListAdapter) nerabyLaundryWashShoesDryListActivity3.D);
            NerabyLaundryWashShoesDryListActivity.this.B.setOnItemClickListener(new a());
        }
    }

    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i7 = message.what;
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (i2.a.f34156z.equals(intent.getAction())) {
                NerabyLaundryWashShoesDryListActivity.this.p0(1, 1);
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_neraby_laundry_washshoes_dry;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.M;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        Intent intent = getIntent();
        this.E = intent;
        this.F = intent.getStringExtra("id");
        this.C = getResources();
        this.B = (XListView) findViewById(R.id.xlv_laundry);
        if (this.f25516J == null) {
            this.f25516J = new MyApplication();
        }
        this.L = new d();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34156z);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.L, intentFilter, 4);
        } else {
            registerReceiver(this.L, intentFilter);
        }
        LatLng latLng = LatLng.getInstance(this);
        this.H = latLng.getLongitude();
        this.I = latLng.getLatitude();
        if (this.F.equals("1")) {
            this.G = this.C.getString(R.string.Nearby_laundry_atlas_title);
        } else if (this.F.equals("3")) {
            this.G = this.C.getString(R.string.Nearby_laundry_atlas_shoes_title);
        } else if (this.F.equals("2")) {
            this.G = this.C.getString(R.string.Nearby_laundry_atlas_dryer_title);
        }
        d0(this.G, 1, N(R.drawable.icon_map_xiyidianliebiao, new a()));
        return this.B;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        LaundryRealted laundryRealted;
        super.onActivityResult(i7, i8, intent);
        q.c(this.P, "NerabyLaundryWashShoesDryListActivity.onActivityResult  requestCode=" + i7 + "   resultCode=" + i8);
        if (1010 == i7) {
            if (intent == null || (laundryRealted = (LaundryRealted) intent.getSerializableExtra("LAUNDRY_REALTED")) == null) {
                return;
            }
            for (int i9 = 0; i9 < this.K.size(); i9++) {
                if (this.K.get(i9).getLaundry().getLaundryId().equals(laundryRealted.getLaundry().getLaundryId())) {
                    this.K.get(i9).setLaundry(laundryRealted.getLaundry());
                    this.D.notifyDataSetChanged();
                    return;
                }
            }
            return;
        }
        if (1007 == i7) {
            if (this.N == null) {
                this.N = (LocationManager) getSystemService("location");
            }
            if (this.O == null) {
                this.O = new e(this).new c();
            }
            q.c(this.P, "NerabyLaundryWashShoesDryListActivity.onActivityResult  1");
            if (androidx.core.content.d.a(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                q.c(this.P, "NerabyLaundryWashShoesDryListActivity.onActivityResult  false");
                return;
            }
            this.N.requestLocationUpdates("network", 1000L, 10.0f, this.O);
            this.B.l();
            q.c(this.P, "NerabyLaundryWashShoesDryListActivity.onActivityResult  true");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        d dVar = this.L;
        if (dVar != null) {
            unregisterReceiver(dVar);
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.M.i(i8, i7, this.H, this.I, i2.a.f34114l, this.F, new b());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, LaundryRealted laundryRealted) {
        bVar.b(R.id.laundry_name, R.id.laundry_open, R.id.laundry_available, R.id.laundry_img, R.id.laundry_num, R.id.laundry_din, R.id.lv_activity);
        TextView textView = (TextView) bVar.a(R.id.laundry_name);
        TextView textView2 = (TextView) bVar.a(R.id.laundry_open);
        TextView textView3 = (TextView) bVar.a(R.id.laundry_available);
        ImageView imageView = (ImageView) bVar.a(R.id.laundry_img);
        TextView textView4 = (TextView) bVar.a(R.id.laundry_num);
        TextView textView5 = (TextView) bVar.a(R.id.laundry_din);
        ListView listView = (ListView) bVar.a(R.id.lv_activity);
        if (laundryRealted.getActivityList() == null || laundryRealted.getActivityList().size() <= 0) {
            listView.setVisibility(8);
        } else {
            listView.setEnabled(false);
            listView.setVisibility(0);
            listView.setAdapter((ListAdapter) new com.haier.globalwasher.view.adapter.d(context, laundryRealted.getActivityList()));
        }
        textView.setText(laundryRealted.getLaundry().getName());
        textView3.setText(laundryRealted.getLaundry().getSpareDeviceNumber() + " " + this.C.getString(R.string.Nearby_laundry_atlas_available));
        textView4.setText(laundryRealted.getDistance());
        if (laundryRealted.getLaundry().getPicture() == null || laundryRealted.getLaundry().getPicture().size() <= 0 || laundryRealted.getLaundry().getPicture().get(0) == null) {
            imageView.setImageResource(R.drawable.icon_xiyidiantupian);
        } else {
            l.O(this).E(laundryRealted.getLaundry().getPicture().get(0).trim()).c0(new com.haier.globalwasher.modle.utils.l(this)).E(imageView);
        }
        textView5.setText(laundryRealted.getLaundry().getAddress());
        if (!laundryRealted.getLaundry().getBusinessStatus().equals("2")) {
            textView2.setBackgroundResource(R.drawable.background_huise_button);
            textView2.setText(this.C.getString(R.string.Nearby_laundry_atlas_btn_close));
            textView3.setTextColor(this.C.getColor(R.color.app_text));
        } else {
            textView2.setBackgroundResource(R.drawable.background_blue_button);
            textView2.setText(this.C.getString(R.string.Nearby_laundry_atlas_btn_open));
            if (laundryRealted.getLaundry().getSpareDeviceNumber().equals("0")) {
                textView3.setTextColor(this.C.getColor(R.color.laundry_coler));
            } else {
                textView3.setTextColor(this.C.getColor(R.color.app_zhexian_blue_relg));
            }
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.laundry_item, null), 1);
    }
}
