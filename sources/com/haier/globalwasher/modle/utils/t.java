package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.CountryCode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f24690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f24691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListView f24692c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f24694e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f24696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f24697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.globalwasher.view.custom_view.popupwindow.a f24698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f24699j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<CountryCode> f24693d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24695f = 0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f24696g.a(t.this.f24695f, (CountryCode) t.this.f24693d.get(t.this.f24695f));
            t.this.f24698i.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f24698i.dismiss();
        }
    }

    class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f24702a;

        c(ArrayList arrayList) {
            this.f24702a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f24702a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i7) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            View viewInflate;
            f fVar;
            if (view == null) {
                fVar = new f();
                viewInflate = LayoutInflater.from(t.this.f24694e).inflate(R.layout.adapter_text_popup, (ViewGroup) null);
                fVar.f24706a = (TextView) viewInflate.findViewById(R.id.pop_text);
                fVar.f24708c = (TextView) viewInflate.findViewById(R.id.pop_textphone);
                fVar.f24707b = viewInflate.findViewById(R.id.pop_line);
                viewInflate.setTag(fVar);
            } else {
                viewInflate = view;
                fVar = (f) view.getTag();
            }
            fVar.f24706a.setText(((CountryCode) this.f24702a.get(i7)).getEnname());
            if (!TextUtils.isEmpty(((CountryCode) this.f24702a.get(i7)).getRegionCode())) {
                String strReplace = ((CountryCode) this.f24702a.get(i7)).getRegionCode().replace("00", "");
                fVar.f24708c.setText("+" + strReplace);
            }
            if (i7 == t.this.f24695f) {
                fVar.f24707b.setBackgroundColor(t.this.f24694e.getResources().getColor(R.color.app_zhexian_blue));
            } else {
                fVar.f24707b.setBackgroundColor(t.this.f24694e.getResources().getColor(R.color.app_line_defult_color));
            }
            return viewInflate;
        }
    }

    class d implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseAdapter f24704a;

        d(BaseAdapter baseAdapter) {
            this.f24704a = baseAdapter;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            t.this.f24695f = i7;
            t.this.f24693d.get(t.this.f24695f);
            this.f24704a.notifyDataSetChanged();
        }
    }

    public interface e {
        void a(int i7, CountryCode countryCode);
    }

    private class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f24706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View f24707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f24708c;

        private f() {
        }
    }

    public t(Context context, View view, ArrayList<CountryCode> arrayList) {
        this.f24694e = context;
        this.f24699j = view;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.popup_bottom, (ViewGroup) null);
        this.f24697h = linearLayout;
        this.f24690a = (TextView) linearLayout.findViewById(R.id.tv_finish);
        this.f24691b = (TextView) this.f24697h.findViewById(R.id.iv_cancel);
        this.f24692c = (ListView) this.f24697h.findViewById(R.id.pop_list);
        this.f24698i = new com.haier.globalwasher.view.custom_view.popupwindow.a(context, this.f24697h);
        g();
        h(arrayList);
    }

    private void g() {
        this.f24690a.setOnClickListener(new a());
        this.f24691b.setOnClickListener(new b());
    }

    private void h(ArrayList<CountryCode> arrayList) {
        this.f24693d = arrayList;
        c cVar = new c(arrayList);
        this.f24692c.setAdapter((ListAdapter) cVar);
        this.f24692c.setOnItemClickListener(new d(cVar));
    }

    public void i(e eVar) {
        this.f24696g = eVar;
    }

    public void j() {
        if (this.f24698i.isShowing()) {
            return;
        }
        h(this.f24693d);
        this.f24698i.showAtLocation(this.f24699j, 81, 0, 0);
    }
}
