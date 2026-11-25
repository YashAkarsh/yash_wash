package com.haier.globalwasher.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.m0;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.APIContralViewBean;
import com.haier.globalwasher.modle.bean.FirstPageLaundry;
import com.haier.globalwasher.modle.bean.advertis.FirstPagePopupWindowAdvertisBean;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.CaptureActivity;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.laundry.NerabyLaundryWashShoesDryListActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.globalwasher.base.a implements com.haier.globalwasher.mvp_api.adapter.d<FirstPageLaundry, d> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a f26067m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.haier.globalwasher.presenter.c f26068n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ListView f26074t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MainActivity f26075u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Resources f26076v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Window f26077w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ArrayList<FirstPageLaundry> f26078x;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f26069o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f26070p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f26071q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f26072r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f26073s = 200;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f26079y = "FPLaundryFragment";

    /* JADX INFO: renamed from: com.haier.globalwasher.view.fragment.a$a, reason: collision with other inner class name */
    class C0342a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.fragment.a$a$a, reason: collision with other inner class name */
        class C0343a implements u4.c.a {
            C0343a() {
            }

            @Override // u4.c.a
            public void a(int i7) {
            }

            @Override // u4.c.a
            public void b(int i7) {
                a.this.startActivity(new Intent(a.this.f26075u, (Class<?>) CaptureActivity.class));
            }
        }

        C0342a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            if (i7 == 0) {
                u4.c.t(a.this.f26075u).o("android.permission.CAMERA").q(new C0343a());
                return;
            }
            if (i7 == 1) {
                Intent intent = new Intent(a.this.f26075u, (Class<?>) NerabyLaundryWashShoesDryListActivity.class);
                intent.putExtra("id", "1");
                a.this.startActivity(intent);
            } else if (i7 == 2) {
                Intent intent2 = new Intent(a.this.f26075u, (Class<?>) NerabyLaundryWashShoesDryListActivity.class);
                intent2.putExtra("id", "2");
                a.this.startActivity(intent2);
            } else {
                if (i7 != 3) {
                    return;
                }
                Intent intent3 = new Intent(a.this.f26075u, (Class<?>) NerabyLaundryWashShoesDryListActivity.class);
                intent3.putExtra("id", "3");
                a.this.startActivity(intent3);
            }
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<APIContralViewBean>> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<APIContralViewBean> baseData) {
            a aVar;
            ArrayList<FirstPageLaundry> arrayList;
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null || !"1".equals(baseData.getData().getShowModule()) || (arrayList = (aVar = a.this).f26078x) == null) {
                return;
            }
            arrayList.add(new FirstPageLaundry(aVar.f26076v.getString(R.string.haier_home_page_nearbyshoes), a.this.f26076v.getDrawable(R.drawable.icon_xixieji_shouye), false));
            a.this.f26067m.notifyDataSetChanged();
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<FirstPagePopupWindowAdvertisBean>> {
        c() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c("useAppContext", "e  " + exc.toString());
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<FirstPagePopupWindowAdvertisBean> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode()) || baseListDate.getData() == null || baseListDate.getData().size() <= 0) {
                return;
            }
            new com.haier.globalwasher.modle.advertis.a().g(a.this.f26075u, baseListDate.getData());
        }
    }

    class d extends com.haier.globalwasher.mvp_api.adapter.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f26084f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f26085g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final LinearLayout f26086h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final View f26087i;

        public d(View view) {
            super(a.this.f26075u, view, 1);
            this.f26087i = this.f24789a.findViewById(R.id.v_padding);
            this.f26086h = (LinearLayout) view.findViewById(R.id.lly_margin);
            this.f26084f = (ImageView) view.findViewById(R.id.iv_image);
            this.f26085g = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public void H() {
        this.f26068n.j(new c());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, d dVar, FirstPageLaundry firstPageLaundry) {
        if (i7 == 0) {
            dVar.f26087i.setVisibility(0);
        } else {
            dVar.f26087i.setVisibility(8);
        }
        dVar.f26084f.setImageDrawable(firstPageLaundry.getDrawable());
        dVar.f26085g.setText(firstPageLaundry.getTitle());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public d x(int i7, ViewGroup viewGroup) {
        return new d(LayoutInflater.from(getActivity()).inflate(R.layout.first_laundry_item, viewGroup, false));
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    @t0(api = 26)
    public void a() {
        ArrayList<FirstPageLaundry> arrayList = new ArrayList<>();
        this.f26078x = arrayList;
        arrayList.add(new FirstPageLaundry(this.f26076v.getString(R.string.haier_home_page_scan), this.f26076v.getDrawable(R.drawable.icon_saoma_shouye), false));
        this.f26078x.add(new FirstPageLaundry(this.f26076v.getString(R.string.haier_home_page_near), this.f26076v.getDrawable(R.drawable.icon_xiyidian_shouye), false));
        this.f26078x.add(new FirstPageLaundry(this.f26076v.getString(R.string.haier_home_page_nearbydryer), this.f26076v.getDrawable(R.drawable.icon_ganyiji_shouye), false));
        H();
        com.haier.globalwasher.mvp_api.adapter.a aVar = this.f26067m;
        if (aVar == null) {
            com.haier.globalwasher.mvp_api.adapter.a aVar2 = new com.haier.globalwasher.mvp_api.adapter.a(this.f26075u, this.f26078x, this);
            this.f26067m = aVar2;
            this.f26074t.setAdapter((ListAdapter) aVar2);
        } else {
            aVar.notifyDataSetChanged();
        }
        this.f26074t.setOnItemClickListener(new C0342a());
        this.f26068n.i(new b());
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.first_laundry_fragment;
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        if (this.f26075u == null) {
            this.f26075u = (MainActivity) getActivity();
        }
        this.f26076v = this.f26075u.getResources();
        this.f26077w = this.f26075u.getWindow();
        this.f26074t = (ListView) findViewById(R.id.lv_);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        if (this.f26075u == null) {
            this.f26075u = (MainActivity) getActivity();
        }
        com.haier.globalwasher.presenter.c cVar = (com.haier.globalwasher.presenter.c) this.f26075u.f();
        this.f26068n = cVar;
        return cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
    }
}
