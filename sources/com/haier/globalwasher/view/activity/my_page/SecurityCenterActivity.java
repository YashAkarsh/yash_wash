package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.DefaultPageBeen;
import com.haier.globalwasher.mvp_api.adapter.b;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.q;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.custom_view.xlist.XListView;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityCenterActivity extends BaseListActivity<DefaultPageBeen> implements d<DefaultPageBeen, b> {
    XListView B;
    private com.haier.globalwasher.mvp_api.adapter.a<DefaultPageBeen, b> C;
    private q D = new q();

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<DefaultPageBeen>> {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.activity.my_page.SecurityCenterActivity$a$a, reason: collision with other inner class name */
        class C0336a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseListDate f25668a;

            C0336a(BaseListDate baseListDate) {
                this.f25668a = baseListDate;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                int itemId = ((DefaultPageBeen) this.f25668a.getData().get(i7 - 1)).getItemId();
                if (itemId == 0) {
                    CancellationAccountActivity.i0(SecurityCenterActivity.this);
                } else {
                    if (itemId != 1) {
                        return;
                    }
                    SecurityCenterActivity securityCenterActivity = SecurityCenterActivity.this;
                    WebActivity.j0(securityCenterActivity, securityCenterActivity.getResources().getString(R.string.pop_title_network), i2.a.R1);
                }
            }
        }

        a() {
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<DefaultPageBeen> baseListDate) {
            if (SecurityCenterActivity.this.C == null) {
                SecurityCenterActivity.this.C = new com.haier.globalwasher.mvp_api.adapter.a(SecurityCenterActivity.this, baseListDate.getData(), SecurityCenterActivity.this);
                SecurityCenterActivity securityCenterActivity = SecurityCenterActivity.this;
                securityCenterActivity.B.setAdapter((ListAdapter) securityCenterActivity.C);
            } else {
                SecurityCenterActivity.this.C.notifyDataSetChanged();
            }
            SecurityCenterActivity.this.B.setOnItemClickListener(new C0336a(baseListDate));
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_security_center;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.D;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0(getResources().getString(R.string.secuity_center_nav_title), 1, new View[0]);
        this.B = (XListView) findViewById(R.id.xlv);
        n0(false);
        return this.B;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.D.o(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, b bVar, DefaultPageBeen defaultPageBeen) {
        bVar.b(R.id.tv_title, R.id.tv_content, R.id.iv_right_arrow, R.id.sb_push_switch);
        TextView textView = (TextView) bVar.a(R.id.tv_title);
        textView.setText(defaultPageBeen.getTitle());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b x(int i7, ViewGroup viewGroup) {
        return new b(this, View.inflate(this, R.layout.security_center_page, null), 1);
    }
}
