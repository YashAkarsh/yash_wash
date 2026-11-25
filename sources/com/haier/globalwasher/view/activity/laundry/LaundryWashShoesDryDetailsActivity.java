package com.haier.globalwasher.view.activity.laundry;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.l;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.SelectListActivity;
import com.haier.globalwasher.modle.bean.LaundryInfo;
import com.haier.globalwasher.modle.bean.LaundryRealted;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i;
import com.haier.globalwasher.modle.utils.v;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.g;
import com.haier.globalwasher.view.adapter.f;
import com.haier.globalwasher.view.adapter.h;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.mlistview.FixItemListView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class LaundryWashShoesDryDetailsActivity extends SelectListActivity {
    ArrayList<com.haier.globalwasher.base.d> B0;
    LaundryRealted D0;
    private Resources O;
    private View P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private String V;
    d W;
    RelativeLayout X;
    ListView Y;
    FontTextView Z;
    ArrayList<com.haier.globalwasher.base.a> A0 = new ArrayList<>();
    private g C0 = new g();

    class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<LaundryInfo>> {
        a() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<LaundryInfo> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                return;
            }
            LaundryWashShoesDryDetailsActivity.this.D0.setLaundry(baseData.getData());
            LaundryWashShoesDryDetailsActivity.this.r0();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LaundryWashShoesDryDetailsActivity.this.t0();
        }
    }

    class c implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f25513a;

        c(ImageView imageView) {
            this.f25513a = imageView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            ImageView imageView = this.f25513a;
            if (imageView != null) {
                imageView.callOnClick();
            }
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!i2.a.f34156z.equals(intent.getAction()) || LaundryWashShoesDryDetailsActivity.this.A0.size() <= 0) {
                return;
            }
            Iterator<com.haier.globalwasher.base.a> it = LaundryWashShoesDryDetailsActivity.this.A0.iterator();
            while (it.hasNext()) {
                ((com.haier.globalwasher.view.fragment.d) it.next()).N(1, 1);
            }
        }
    }

    public static void s0(BaseActivity baseActivity, LaundryRealted laundryRealted, String str) {
        Intent intent = new Intent(baseActivity, (Class<?>) LaundryWashShoesDryDetailsActivity.class);
        intent.putExtra(g.f25149p, laundryRealted);
        intent.putExtra("type", str);
        baseActivity.startActivityForResult(intent, 1010);
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.C0.h(this.D0.getLaundry().getLaundryId(), this.V, new a());
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        n0(true);
        q0(30);
        Intent intent = getIntent();
        this.V = intent.getStringExtra("type");
        LaundryRealted laundryRealted = (LaundryRealted) intent.getSerializableExtra(g.f25149p);
        this.D0 = laundryRealted;
        if (laundryRealted == null) {
            return;
        }
        r0();
        this.W = new d();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34156z);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.W, intentFilter, 4);
        } else {
            registerReceiver(this.W, intentFilter);
        }
        d0("", 1, new View[0]);
        super.d();
        this.f24298x.setSlide(true);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return this.C0;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<com.haier.globalwasher.base.a> h0() {
        this.A0.clear();
        for (int i7 = 0; i7 < this.B0.size(); i7++) {
            this.A0.add(com.haier.globalwasher.view.fragment.d.V(this.D0, this.V, this.B0.get(i7).c()));
        }
        return this.A0;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<com.haier.globalwasher.base.d> i0() {
        com.haier.globalwasher.base.d dVar;
        ArrayList<com.haier.globalwasher.base.d> arrayList = new ArrayList<>();
        this.B0 = arrayList;
        arrayList.add(new com.haier.globalwasher.base.d(this.O.getString(R.string.the_laundry_is_floor_ALL), 0, ""));
        for (int i7 = 0; i7 < this.D0.getLaundry().getFloorNumbers().size(); i7++) {
            if (!"".equals(this.D0.getLaundry().getFloorNumbers().get(i7)) && this.D0.getLaundry().getFloorNumbers().get(i7) != null) {
                try {
                    dVar = new com.haier.globalwasher.base.d(Integer.parseInt(this.D0.getLaundry().getFloorNumbers().get(i7)) + this.O.getString(R.string.the_laundry_is_floor_F), i7 + 1, "");
                } catch (NumberFormatException unused) {
                    dVar = new com.haier.globalwasher.base.d(this.D0.getLaundry().getFloorNumbers().get(i7) + this.O.getString(R.string.the_laundry_is_floor_F), i7 + 1, "");
                }
                dVar.g(this.D0.getLaundry().getFloorNumbers().get(i7));
                this.B0.add(dVar);
            }
        }
        return this.B0;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public int j0() {
        return 1;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public boolean k0() {
        return true;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<Drawable> o0() {
        return new ArrayList<>();
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        d dVar = this.W;
        if (dVar != null) {
            unregisterReceiver(dVar);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, KeyEvent keyEvent) {
        if (i7 == 4) {
            Intent intent = new Intent();
            intent.putExtra("LAUNDRY_REALTED", this.D0);
            setResult(1011, intent);
        }
        return super.onKeyUp(i7, keyEvent);
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<Drawable> p0() {
        return new ArrayList<>();
    }

    public View r0() {
        this.O = getResources();
        if (this.P == null) {
            View viewInflate = View.inflate(this, R.layout.activity_top_laundry_wash_shoes_dry_details, null);
            this.P = viewInflate;
            this.Q = (TextView) viewInflate.findViewById(R.id.laundry_name);
            this.R = (TextView) this.P.findViewById(R.id.laundry_open);
            this.S = (TextView) this.P.findViewById(R.id.laundry_available);
            this.U = (ImageView) this.P.findViewById(R.id.laundry_img);
            this.X = (RelativeLayout) this.P.findViewById(R.id.rly_detail_activity_view);
            this.Y = (ListView) this.P.findViewById(R.id.lv_activitys);
            this.Z = (FontTextView) this.P.findViewById(R.id.ftv_notify);
            this.T = (TextView) this.P.findViewById(R.id.laundry_num);
            this.Q.setTextColor(this.O.getColor(R.color.app_white));
            this.S.setTextColor(this.O.getColor(R.color.app_white));
            this.T.setTextColor(this.O.getColor(R.color.app_white));
            addViewInToolbarBottom(this.P);
        }
        if (this.D0.getLaundry().getPicture() == null || this.D0.getLaundry().getPicture().size() <= 0 || this.D0.getLaundry().getPicture().get(0) == null) {
            this.U.setImageResource(R.drawable.icon_xiyidiantupian);
        } else {
            l.O(this).E(this.D0.getLaundry().getPicture().get(0).toString().trim()).c0(new com.haier.globalwasher.modle.utils.l(this)).E(this.U);
        }
        this.Q.setText(this.D0.getLaundry().getName() + "");
        if ("1".equals(this.D0.getLaundry().getBusinessStatus())) {
            this.R.setText(getResources().getString(R.string.Nearby_laundry_atlas_btn_close));
            this.R.setBackgroundResource(R.drawable.my_fragment_profile_edit);
        } else {
            this.R.setText(getResources().getString(R.string.Nearby_laundry_atlas_btn_open));
            this.R.setBackgroundResource(R.drawable.my_fragment_profile_edit);
        }
        this.S.setText(this.D0.getLaundry().getSpareDeviceNumber() + " " + this.O.getString(R.string.Nearby_laundry_atlas_available));
        this.T.setText(this.D0.getDistance() + "");
        if (d0.j(this.D0.getLaundry().getNotice())) {
            this.Z.setVisibility(0);
            this.Z.setText(this.D0.getLaundry().getNotice());
        } else {
            this.Z.setVisibility(8);
        }
        this.Z.setOnClickListener(new b());
        if (this.D0.getLaundry().getActivityList() == null || this.D0.getLaundry().getActivityList().size() <= 0) {
            this.Y.setVisibility(8);
        } else {
            this.Y.setVisibility(0);
            this.Y.setAdapter((ListAdapter) new f(this, this.D0.getLaundry().getActivityList()));
        }
        if (this.D0.getLaundry().getActivityList() == null || this.D0.getLaundry().getActivityList().size() <= 0 || !d0.j(this.D0.getLaundry().getNotice())) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
        return this.P;
    }

    @SuppressLint({"SetTextI18n"})
    public void t0() {
        if (i.a() || this.D0.getLaundry() == null) {
            return;
        }
        View viewInflate = View.inflate(this, R.layout.popupwindow_activitys_detail, null);
        FontTextView fontTextView = (FontTextView) viewInflate.findViewById(R.id.ftv_notify);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_close);
        FixItemListView fixItemListView = (FixItemListView) viewInflate.findViewById(R.id.lv_activity);
        fixItemListView.setFixItemCount(2);
        fixItemListView.setOnItemClickListener(new c(imageView));
        if (d0.j(this.D0.getLaundry().getNotice())) {
            fontTextView.setText(this.D0.getLaundry().getNotice() + "");
        }
        if (this.D0.getLaundry().getActivityList() == null || this.D0.getLaundry().getActivityList().size() <= 0) {
            fixItemListView.setVisibility(8);
        } else {
            fixItemListView.setAdapter((ListAdapter) new h(this, this.D0.getLaundry().getActivityList()));
        }
        v.k(this, viewInflate, imageView);
    }
}
