package com.haier.globalwasher.view.activity.my_page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.DefaultPageBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AuthenticationCenterActivity extends BaseListActivity<DefaultPageBeen> implements com.haier.globalwasher.mvp_api.adapter.d<DefaultPageBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    CountDownBroadcastReceiver C;
    private XListView D;
    com.haier.globalwasher.mvp_api.adapter.a E;
    FontTextView F;
    com.haier.globalwasher.presenter.authentication.a B = new com.haier.globalwasher.presenter.authentication.a();
    private ArrayList<DefaultPageBeen> G = new ArrayList<>();

    class a extends CountDownBroadcastReceiver {
        a() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
        @SuppressLint({"SetTextI18n"})
        public void a(ArrayList<CountDownBeen> arrayList) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (arrayList.get(i7).getWashOrderId().equals("1001")) {
                    q.c("BaseAct", "" + arrayList.get(i7).getWashOrderId());
                    FontTextView fontTextView = (AuthenticationCenterActivity.this.D == null || AuthenticationCenterActivity.this.D.getChildCount() <= 2) ? null : (FontTextView) AuthenticationCenterActivity.this.D.getChildAt(2).findViewById(R.id.tv_send_code);
                    if (fontTextView != null) {
                        long overTime = arrayList.get(i7).getOverTime();
                        if (overTime <= 0) {
                            fontTextView.setText(AuthenticationCenterActivity.this.getResources().getString(R.string.authentication_center_get_code_again));
                            fontTextView.setEnabled(true);
                            return;
                        }
                        fontTextView.setEnabled(false);
                        fontTextView.setText((overTime / 1000) + "s");
                        return;
                    }
                    return;
                }
            }
        }
    }

    class b extends QuitLoginBroadcastReceiver {
        b() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver
        protected void a(Intent intent) {
        }
    }

    class c extends BaseListActivity<DefaultPageBeen>.a {
        c() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<DefaultPageBeen> arrayList) {
            AuthenticationCenterActivity.this.G.addAll(arrayList);
            AuthenticationCenterActivity authenticationCenterActivity = AuthenticationCenterActivity.this;
            AuthenticationCenterActivity authenticationCenterActivity2 = AuthenticationCenterActivity.this;
            authenticationCenterActivity.E = new com.haier.globalwasher.mvp_api.adapter.a(authenticationCenterActivity2, authenticationCenterActivity2.G, AuthenticationCenterActivity.this);
            AuthenticationCenterActivity.this.D.setAdapter((ListAdapter) AuthenticationCenterActivity.this.E);
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseData> {
        d() {
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                AuthenticationCenterActivity.this.u0();
            } else {
                i0.d(AuthenticationCenterActivity.this, baseData.getRetInfo());
            }
        }
    }

    class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            AuthenticationCenterActivity.this.v0(charSequence != null && charSequence.toString().length() > 0);
        }
    }

    class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FontTextView f25642a;

        class a extends com.haier.globalwasher.modle.network.a<BaseData> {
            a() {
            }

            @Override // com.haier.globalwasher.modle.network.a
            public void i(Exception exc) {
            }

            @Override // com.haier.globalwasher.modle.network.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public void p(BaseData baseData) {
                if (!"00000".equals(baseData.getRetCode())) {
                    i0.d(AuthenticationCenterActivity.this, baseData.getRetInfo());
                    return;
                }
                f.this.f25642a.setEnabled(false);
                AuthenticationCenterActivity authenticationCenterActivity = AuthenticationCenterActivity.this;
                i0.d(authenticationCenterActivity, authenticationCenterActivity.getResources().getString(R.string.verify_code_send_SMS));
                CountDownBeen countDownBeen = new CountDownBeen();
                countDownBeen.setOverTime(DateUtils.MILLIS_PER_MINUTE);
                Objects.requireNonNull(AuthenticationCenterActivity.this.C);
                countDownBeen.setWashOrderId("1001");
                MyApplication.s(countDownBeen);
            }
        }

        f(FontTextView fontTextView) {
            this.f25642a = fontTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AuthenticationCenterActivity.this.B.i(t2.a.a(AuthenticationCenterActivity.this, t2.a.f40354a, t2.a.f40357d), "3", new a());
        }
    }

    class g implements View.OnClickListener {

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
            a() {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseData baseData) {
                if ("00000".equals(baseData.getRetCode())) {
                    AuthenticationCenterActivity.this.B.j();
                    i0.d(AuthenticationCenterActivity.this, "" + baseData.getRetInfo());
                }
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AuthenticationCenterActivity.this.B.g(new a());
        }
    }

    public static void w0(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, (Class<?>) AuthenticationCenterActivity.class));
    }

    @Override // com.haier.globalwasher.base.BaseListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        super.a();
        this.D.setPullRefreshEnable(false);
        this.D.setPullLoadEnable(false);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_authentication_center;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.B;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        this.D = (XListView) findViewById(R.id.xlv_page);
        this.F = (FontTextView) findViewById(R.id.tv_submit);
        d0(getResources().getString(R.string.authentication_center_nav_title), 1, new View[0]);
        this.C = new a();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            registerReceiver(this.C, intentFilter, 4);
        } else {
            registerReceiver(this.C, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(i2.a.f34126p);
        b bVar = new b();
        if (i7 >= 33) {
            registerReceiver(bVar, intentFilter2, 4);
        } else {
            registerReceiver(bVar, intentFilter2);
        }
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_submit) {
            EditText editText = this.D.getChildCount() > 2 ? (EditText) this.D.getChildAt(2).findViewById(R.id.et_edit) : null;
            if (editText == null || editText.getText().toString().length() <= 0) {
                return;
            }
            this.B.k(t2.a.a(this, t2.a.f40354a, t2.a.f40357d), "3", editText.getText().toString(), new d());
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.C);
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.B.h(new c());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, DefaultPageBeen defaultPageBeen) {
        bVar.b(R.id.lly_content_center, R.id.tv_title_not_frame, R.id.et_edit, R.id.tv_phone, R.id.tv_send_code, R.id.tv_warning);
        RelativeLayout relativeLayout = (RelativeLayout) bVar.a(R.id.lly_content_center);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_title_not_frame);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.tv_phone);
        FontTextView fontTextView3 = (FontTextView) bVar.a(R.id.tv_send_code);
        EditText editText = (EditText) bVar.a(R.id.et_edit);
        fontTextView.setText(defaultPageBeen.getTitle());
        if (defaultPageBeen.getItemId() == 0) {
            relativeLayout.setBackground(getResources().getDrawable(R.drawable.cardview_background_huise_not_projection, null));
            fontTextView3.setVisibility(8);
            editText.setVisibility(8);
            fontTextView2.setVisibility(0);
            fontTextView2.setText(defaultPageBeen.getContent());
            return;
        }
        relativeLayout.setBackground(getResources().getDrawable(R.drawable.cardview_background_whit_not_projection, null));
        fontTextView3.setVisibility(0);
        editText.setVisibility(0);
        fontTextView2.setVisibility(8);
        editText.addTextChangedListener(new e());
        ((LinearLayout.LayoutParams) fontTextView.getLayoutParams()).topMargin = 0;
        fontTextView3.setOnClickListener(new f(fontTextView3));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.authentication_center, null), 4);
    }

    public void u0() {
        z.f(this, getResources().getString(R.string.cancellation_account_alert_title), getResources().getString(R.string.cancellation_account_alert_msg), getResources().getString(R.string.cancellation_account_alert_no), getResources().getString(R.string.cancellation_account_alert_yes), null, new g());
    }

    public void v0(boolean z7) {
        if (z7) {
            this.F.setOnClickListener(this);
            this.F.setBackground(getResources().getDrawable(R.drawable.background_blue_button, null));
        } else {
            this.F.setOnClickListener(null);
            this.F.setBackground(getResources().getDrawable(R.drawable.background_huise_button, null));
        }
    }
}
