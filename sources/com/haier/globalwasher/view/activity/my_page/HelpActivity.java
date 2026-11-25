package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.HelpPageBeen;
import com.haier.globalwasher.mvp_api.adapter.b;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class HelpActivity extends BaseListActivity<HelpPageBeen> implements d<HelpPageBeen, b> {
    private com.haier.globalwasher.mvp_api.adapter.a<HelpPageBeen, b> B;
    XListView C;
    private com.haier.globalwasher.presenter.d D = new com.haier.globalwasher.presenter.d();

    class a extends BaseListActivity<HelpPageBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<HelpPageBeen> arrayList) {
            if (HelpActivity.this.B != null) {
                HelpActivity.this.B.notifyDataSetChanged();
                return;
            }
            HelpActivity helpActivity = HelpActivity.this;
            HelpActivity helpActivity2 = HelpActivity.this;
            helpActivity.B = new com.haier.globalwasher.mvp_api.adapter.a(helpActivity2, arrayList, helpActivity2);
            HelpActivity helpActivity3 = HelpActivity.this;
            helpActivity3.C.setAdapter((ListAdapter) helpActivity3.B);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_help;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.D;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        this.C = (XListView) findViewById(R.id.xlv_help);
        d0(getResources().getString(R.string.my_page_help), 1, new View[0]);
        n0(false);
        return this.C;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.D.g(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, b bVar, HelpPageBeen helpPageBeen) {
        bVar.b(R.id.tv_content, R.id.iv_more);
        ((TextView) bVar.a(R.id.tv_content)).setText(helpPageBeen.getContent());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b x(int i7, ViewGroup viewGroup) {
        return new b(this, View.inflate(this, R.layout.help_page_item, null), 1);
    }
}
