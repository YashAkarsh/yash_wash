package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.LatestVersion;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.SettingPageBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.q;
import com.haier.globalwasher.view.custom_view.switch_view.SwitchButton;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SettingActivity extends BaseListActivity<SettingPageBeen> implements com.haier.globalwasher.mvp_api.adapter.d<SettingPageBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private com.haier.globalwasher.mvp_api.adapter.a<SettingPageBeen, com.haier.globalwasher.mvp_api.adapter.b> B;
    XListView D;
    private g E;
    private f F;
    private Resources H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private e f25670J;
    private q C = new q();
    private String G = "T";
    public int I = -1;
    public final String K = "SettingActivity";

    class a extends BaseListActivity<SettingPageBeen>.a {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.activity.my_page.SettingActivity$a$a, reason: collision with other inner class name */
        class C0337a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f25672a;

            C0337a(ArrayList arrayList) {
                this.f25672a = arrayList;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                int itemId = ((SettingPageBeen) this.f25672a.get(i7 - 1)).getItemId();
                if (itemId == 0) {
                    SwitchButton switchButton = (SwitchButton) SettingActivity.this.D.getChildAt(i7).findViewById(R.id.sb_push_switch);
                    switchButton.performClick();
                    switchButton.setChecked(true ^ switchButton.g());
                    return;
                }
                if (itemId == 1) {
                    SettingActivity.this.startActivity(new Intent(SettingActivity.this, (Class<?>) SecurityCenterActivity.class));
                    return;
                }
                if (itemId != 2) {
                    if (itemId != 3) {
                        return;
                    }
                    SettingActivity.this.C.j(SettingActivity.this.f25670J);
                    return;
                }
                try {
                    if (com.haier.globalwasher.modle.utils.f.e(SettingActivity.this) == 0) {
                        SettingActivity settingActivity = SettingActivity.this;
                        i0.d(settingActivity, settingActivity.getResources().getString(R.string.no_need_to_clean_up));
                        return;
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                SettingActivity.this.C.h();
                ((TextView) SettingActivity.this.D.getChildAt(i7).findViewById(R.id.tv_content)).setText(SettingActivity.this.C.k());
                i0.d(SettingActivity.this, ((SettingPageBeen) this.f25672a.get(2)).getContent() + "\n" + SettingActivity.this.getResources().getString(R.string.clear_cache_cleared));
                ((SettingPageBeen) this.f25672a.get(2)).setContent(SettingActivity.this.C.k());
                if (MyApplication.f24259o) {
                    t2.a.b(SettingActivity.this, t2.a.f40362i, t2.a.f40364k, "");
                }
            }
        }

        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<SettingPageBeen> arrayList) {
            if (SettingActivity.this.B == null) {
                SettingActivity settingActivity = SettingActivity.this;
                SettingActivity settingActivity2 = SettingActivity.this;
                settingActivity.B = new com.haier.globalwasher.mvp_api.adapter.a(settingActivity2, arrayList, settingActivity2);
                SettingActivity settingActivity3 = SettingActivity.this;
                settingActivity3.D.setAdapter((ListAdapter) settingActivity3.B);
            } else {
                SettingActivity settingActivity4 = SettingActivity.this;
                settingActivity4.D.setAdapter((ListAdapter) settingActivity4.B);
            }
            SettingActivity.this.D.setOnItemClickListener(new C0337a(arrayList));
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.E == null) {
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.E = settingActivity.new g();
            }
            SettingActivity.this.C.l(SettingActivity.this.E);
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwitchButton f25675a;

        c(SwitchButton switchButton) {
            this.f25675a = switchButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strA = t2.a.a(SettingActivity.this, t2.a.f40362i, t2.a.f40366m);
            SettingActivity.this.G = strA.equals("T") ? "F" : "T";
            if (!SettingActivity.this.G.equals("T")) {
                SettingActivity.this.C0(this.f25675a);
            } else {
                SettingActivity.this.F.f(this.f25675a);
                SettingActivity.this.C.m(SettingActivity.this.G, SettingActivity.this.F);
            }
        }
    }

    class d extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwitchButton f25677a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingActivity.this.G = "T";
                d.this.f25677a.setChecked(true);
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingActivity.this.G = "F";
                SettingActivity.this.F.f(d.this.f25677a);
                SettingActivity.this.C.m(SettingActivity.this.G, SettingActivity.this.F);
            }
        }

        d(SwitchButton switchButton) {
            this.f25677a = switchButton;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            SettingActivity settingActivity = SettingActivity.this;
            z.c(settingActivity, 2, 2, settingActivity.H.getString(R.string.popview_hint_notifications_Prompts), SettingActivity.this.H.getString(R.string.popview_hint_notifications), SettingActivity.this.H.getString(R.string.order_list_Btn_cancal_Remind_left), SettingActivity.this.H.getString(R.string.order_list_Btn_cancal_Remind_right), new a(), new b());
        }
    }

    class e implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<LatestVersion>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SettingActivity f25681a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingActivity.this.D0();
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingActivity.this.D0();
            }
        }

        public e(SettingActivity settingActivity) {
            this.f25681a = settingActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<LatestVersion> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || TextUtils.isEmpty(baseData.getData().toString())) {
                return;
            }
            int i7 = Integer.parseInt(baseData.getData().getVersionNumber());
            SettingActivity settingActivity = SettingActivity.this;
            if (i7 <= settingActivity.I) {
                i0.d(this.f25681a, settingActivity.H.getString(R.string.new_latest));
                return;
            }
            if (("" + baseData.getData().getIsMandatory()).equals("N")) {
                SettingActivity settingActivity2 = SettingActivity.this;
                z.c(settingActivity2, 1, 2, "", settingActivity2.H.getString(R.string.version_update), SettingActivity.this.H.getString(R.string.areacodelist_choose_cancel), SettingActivity.this.H.getString(R.string.areacodelist_choose_determine), null, new a());
            } else {
                SettingActivity settingActivity3 = SettingActivity.this;
                z.b(settingActivity3, 2, 2, 1, "", settingActivity3.H.getString(R.string.version_update), SettingActivity.this.H.getString(R.string.areacodelist_choose_determine), new b(), null);
            }
        }
    }

    class f implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SwitchButton f25685a;

        f() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        public void f(SwitchButton switchButton) {
            this.f25685a = switchButton;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                SettingActivity settingActivity = SettingActivity.this;
                t2.a.b(settingActivity, t2.a.f40362i, t2.a.f40366m, settingActivity.G);
                ProfileAvatarImageBeen.getInstance().setIsReceiveMessage(SettingActivity.this.G);
            } else {
                SettingActivity.this.G = ProfileAvatarImageBeen.getInstance().getIsReceiveMessage();
                this.f25685a.setChecked("T".equals(SettingActivity.this.G));
                i0.d(SettingActivity.this, baseData.getRetInfo());
            }
        }
    }

    class g implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
        g() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(SettingActivity.this, baseData.getRetInfo());
                return;
            }
            q qVar = SettingActivity.this.C;
            SettingActivity settingActivity = SettingActivity.this;
            q unused = settingActivity.C;
            qVar.p(settingActivity, 2);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, SettingPageBeen settingPageBeen) {
        bVar.b(R.id.tv_title, R.id.tv_content, R.id.iv_right_arrow, R.id.sb_push_switch);
        TextView textView = (TextView) bVar.a(R.id.tv_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_content);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_right_arrow);
        SwitchButton switchButton = (SwitchButton) bVar.a(R.id.sb_push_switch);
        textView.setText(settingPageBeen.getTitle());
        textView2.setText(settingPageBeen.getContent());
        if (settingPageBeen.getItemId() == 1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (i7 != 0) {
            switchButton.setVisibility(8);
            return;
        }
        switchButton.setVisibility(0);
        String strA = t2.a.a(this, t2.a.f40362i, t2.a.f40366m);
        if (strA == null || !strA.equals(this.G)) {
            switchButton.setChecked(false);
        } else {
            switchButton.setChecked(true);
        }
        switchButton.setOnClickListener(new c(switchButton));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.setting_item, null), 1);
    }

    public void C0(SwitchButton switchButton) {
        runOnUiThread(new d(switchButton));
    }

    public void D0() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(i2.a.f34093e));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            return;
        }
        intent.setData(Uri.parse(i2.a.f34090d));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            i0.d(this, this.H.getString(R.string.new_latest_browser));
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        n0(false);
        super.a();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_setting;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.C;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0(getResources().getString(R.string.my_page_setting), 1, new View[0]);
        this.H = getResources();
        this.D = (XListView) findViewById(R.id.xlv);
        S(R.id.tv_sign_out, true);
        this.F = new f();
        this.f25670J = new e(this);
        this.I = this.C.g(this);
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_sign_out) {
            z.c(this, 1, 2, this.H.getString(R.string.order_list_Btn_cancal_Remind), this.H.getString(R.string.sign_out_popview_hint), this.H.getString(R.string.order_list_Btn_cancal_Remind_left), this.H.getString(R.string.order_list_Btn_cancal_Remind_right), null, new b());
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.C.n(new a());
    }
}
