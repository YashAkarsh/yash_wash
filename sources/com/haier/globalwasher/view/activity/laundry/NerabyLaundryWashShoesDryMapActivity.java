package com.haier.globalwasher.view.activity.laundry;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.l;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.f;
import com.google.android.gms.maps.g;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.h;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.LaundryInfo;
import com.haier.globalwasher.modle.bean.LaundryRealted;
import com.haier.globalwasher.modle.utils.z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NerabyLaundryWashShoesDryMapActivity extends BaseActivity implements g, c.q {
    private c B;
    private com.google.android.gms.maps.model.a C;
    private com.google.android.gms.maps.model.a D;
    private com.google.android.gms.maps.model.a E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.haier.globalwasher.presenter.g f25522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SupportMapFragment f25523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Intent f25524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f25525x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Resources f25527z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f25526y = "";
    private ArrayList<LaundryRealted> A = new ArrayList<>();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NerabyLaundryWashShoesDryMapActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f25529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LaundryInfo f25530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LaundryRealted f25531c;

        b(androidx.appcompat.app.c cVar, LaundryInfo laundryInfo, LaundryRealted laundryRealted) {
            this.f25529a = cVar;
            this.f25530b = laundryInfo;
            this.f25531c = laundryRealted;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.c cVar = this.f25529a;
            if (cVar != null) {
                cVar.dismiss();
            }
            if (!this.f25530b.getBusinessStatus().equals("2")) {
                NerabyLaundryWashShoesDryMapActivity.this.h0(this.f25530b);
            } else {
                NerabyLaundryWashShoesDryMapActivity nerabyLaundryWashShoesDryMapActivity = NerabyLaundryWashShoesDryMapActivity.this;
                LaundryWashShoesDryDetailsActivity.s0(nerabyLaundryWashShoesDryMapActivity, this.f25531c, nerabyLaundryWashShoesDryMapActivity.f25525x);
            }
        }
    }

    private void i0(LatLng latLng) {
        ArrayList<LaundryRealted> arrayList = this.A;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i7 = 0;
        while (i7 < this.A.size()) {
            if (this.A.get(i7).getLaundry().getLatitude().equals("" + latLng.f16585a)) {
                if (this.A.get(i7).getLaundry().getLongitude().equals("" + latLng.f16586b)) {
                    break;
                }
            }
            i7++;
        }
        if (i7 >= this.A.size()) {
            return;
        }
        LaundryRealted laundryRealted = this.A.get(i7);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(this).a();
        cVarA.show();
        Window window = cVarA.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = defaultDisplay.getWidth() - 50;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setGravity(80);
        window.setContentView(com.haier.globalwasher.R.layout.laundry_item);
        cVarA.setCanceledOnTouchOutside(true);
        if (laundryRealted == null || laundryRealted.getLaundry() == null) {
            return;
        }
        LaundryInfo laundry = laundryRealted.getLaundry();
        window.findViewById(com.haier.globalwasher.R.id.laundry_id).setBackgroundResource(com.haier.globalwasher.R.drawable.cardview_background);
        window.findViewById(com.haier.globalwasher.R.id.laundry_id).setOnClickListener(new b(cVarA, laundry, laundryRealted));
        TextView textView = (TextView) window.findViewById(com.haier.globalwasher.R.id.laundry_open);
        ((TextView) window.findViewById(com.haier.globalwasher.R.id.laundry_name)).setText("" + laundry.getName());
        ((TextView) window.findViewById(com.haier.globalwasher.R.id.laundry_num)).setText("" + laundryRealted.getDistance());
        ((TextView) window.findViewById(com.haier.globalwasher.R.id.laundry_din)).setText("" + laundry.getAddress());
        TextView textView2 = (TextView) window.findViewById(com.haier.globalwasher.R.id.laundry_available);
        ImageView imageView = (ImageView) window.findViewById(com.haier.globalwasher.R.id.laundry_img);
        if (laundry.getPicture() == null || laundry.getPicture().size() <= 0 || laundry.getPicture().get(0) == null) {
            imageView.setImageResource(com.haier.globalwasher.R.drawable.icon_xiyidiantupian);
        } else {
            l.O(this).E(laundry.getPicture().get(0).toString().trim()).c0(new com.haier.globalwasher.modle.utils.l(this)).E(imageView);
        }
        textView2.setText(laundry.getSpareDeviceNumber() + "" + this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_available));
        if (!laundry.getBusinessStatus().equals("2")) {
            textView.setBackgroundResource(com.haier.globalwasher.R.drawable.background_huise_button);
            textView.setText(this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_btn_close));
            textView2.setTextColor(this.f25527z.getColor(com.haier.globalwasher.R.color.app_text));
        } else {
            textView.setBackgroundResource(com.haier.globalwasher.R.drawable.background_blue_button);
            textView.setText(this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_btn_open));
            if (laundry.getSpareDeviceNumber().equals("0")) {
                textView2.setTextColor(this.f25527z.getColor(com.haier.globalwasher.R.color.laundry_coler));
            } else {
                textView2.setTextColor(this.f25527z.getColor(com.haier.globalwasher.R.color.app_zhexian_blue_relg));
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return com.haier.globalwasher.R.layout.activity_neraby_laundry_shoes_dry_map;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        Intent intent = getIntent();
        this.f25524w = intent;
        this.f25525x = intent.getStringExtra("id");
        this.A = (ArrayList) this.f25524w.getSerializableExtra(com.haier.globalwasher.presenter.g.f25148o);
        this.f25527z = getResources();
        if (this.f25525x.equals("1")) {
            this.f25526y = this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_title);
        } else if (this.f25525x.equals("3")) {
            this.f25526y = this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_shoes_title);
        } else if (this.f25525x.equals("2")) {
            this.f25526y = this.f25527z.getString(com.haier.globalwasher.R.string.Nearby_laundry_atlas_dryer_title);
        }
        d0(this.f25526y, 1, N(com.haier.globalwasher.R.drawable.icon_liebiao_map, new a()));
        f.a(this);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().p0(com.haier.globalwasher.R.id.map);
        this.f25523v = supportMapFragment;
        supportMapFragment.A(this);
        this.C = com.google.android.gms.maps.model.b.g(com.haier.globalwasher.R.drawable.icon_dingwei_blue);
        this.D = com.google.android.gms.maps.model.b.g(com.haier.globalwasher.R.drawable.icon_dingwei_red);
        this.E = com.google.android.gms.maps.model.b.g(com.haier.globalwasher.R.drawable.icon_dingwei_gray);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        if (this.f25522u == null) {
            this.f25522u = new com.haier.globalwasher.presenter.g();
        }
        return this.f25522u;
    }

    public void h0(LaundryInfo laundryInfo) {
        z.d(this, 1, this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_title), this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_smalltitle), this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_ondetails) + "\n" + this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_working) + " " + laundryInfo.getWorkStartTime() + " " + this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_to) + " " + laundryInfo.getWorkEndTime() + "\n" + this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_saturday) + " " + laundryInfo.getWeekStartTime() + " " + this.f25527z.getString(com.haier.globalwasher.R.string.the_laundry_is_closed_to) + " " + laundryInfo.getWorkEndTime(), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.google.android.gms.maps.c.q
    public boolean s(h hVar) {
        i0(hVar.c());
        return false;
    }

    @Override // com.google.android.gms.maps.g
    public void v(c cVar) {
        this.B = cVar;
        cVar.w(com.google.android.gms.maps.b.e(new LatLng(com.haier.globalwasher.modle.bean.LatLng.getInstance(this).getLatitude(), com.haier.globalwasher.modle.bean.LatLng.getInstance(this).getLongitude()), 13.0f));
        this.B.c(new MarkerOptions().Y0(com.google.android.gms.maps.model.b.g(com.haier.globalwasher.R.drawable.icon_point_xinxitixing)).K(0.0f, 1.0f).q1(new LatLng(com.haier.globalwasher.modle.bean.LatLng.getInstance(this).getLatitude(), com.haier.globalwasher.modle.bean.LatLng.getInstance(this).getLongitude())));
        if (this.A.size() > 0) {
            for (int i7 = 0; i7 < this.A.size(); i7++) {
                LaundryRealted laundryRealted = this.A.get(i7);
                this.B.c(new MarkerOptions().Y0(laundryRealted.getLaundry().getBusinessStatus().equals("2") ? Integer.parseInt(laundryRealted.getLaundry().getSpareDeviceNumber()) > 0 ? this.C : this.D : this.E).K(0.0f, 1.0f).q1(new LatLng(Double.parseDouble(this.A.get(i7).getLaundry().getLatitude()), Double.parseDouble(this.A.get(i7).getLaundry().getLongitude()))));
            }
        }
        this.B.X(this);
    }
}
