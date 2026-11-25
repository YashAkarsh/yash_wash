package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.UpDataProfileBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.q;
import com.haier.globalwasher.presenter.t;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class UpDataProfileActivity extends BaseListActivity<UpDataProfileBeen> implements com.haier.globalwasher.mvp_api.adapter.d<UpDataProfileBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private com.haier.globalwasher.mvp_api.adapter.a<UpDataProfileBeen, com.haier.globalwasher.mvp_api.adapter.b> C;
    ListView D;
    private t B = new t();
    int E = 0;
    private ArrayList<UpDataProfileBeen> F = new ArrayList<>();

    class a extends BaseListActivity<UpDataProfileBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<UpDataProfileBeen> arrayList) {
            UpDataProfileActivity.this.F.addAll(arrayList);
            UpDataProfileActivity upDataProfileActivity = UpDataProfileActivity.this;
            UpDataProfileActivity upDataProfileActivity2 = UpDataProfileActivity.this;
            upDataProfileActivity.C = new com.haier.globalwasher.mvp_api.adapter.a(upDataProfileActivity2, upDataProfileActivity2.F, UpDataProfileActivity.this);
            UpDataProfileActivity upDataProfileActivity3 = UpDataProfileActivity.this;
            upDataProfileActivity3.D.setAdapter((ListAdapter) upDataProfileActivity3.C);
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(UpDataProfileActivity.this, baseData.getRetInfo());
                return;
            }
            i0.d(UpDataProfileActivity.this, baseData.getRetInfo());
            new q().p(UpDataProfileActivity.this, 2);
            UpDataProfileActivity.this.finish();
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f25707a;

        c(EditText editText) {
            this.f25707a = editText;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(UpDataProfileActivity.this, baseData.getRetInfo());
                return;
            }
            t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40359f, this.f25707a.getText().toString());
            ProfileAvatarImageBeen.getInstance().setUserName(this.f25707a.getText().toString());
            i0.d(UpDataProfileActivity.this, baseData.getRetInfo());
            UpDataProfileActivity upDataProfileActivity = UpDataProfileActivity.this;
            if (upDataProfileActivity.E == 2) {
                upDataProfileActivity.setResult(1005);
            }
            UpDataProfileActivity.this.finish();
        }
    }

    class d implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f25709a;

        d(EditText editText) {
            this.f25709a = editText;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (z7) {
                this.f25709a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                this.f25709a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_up_data_profile;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.B;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        this.D = (ListView) findViewById(R.id.lv);
        int intExtra = getIntent().getIntExtra(t.f25316i, 1);
        this.E = intExtra;
        if (intExtra == 2) {
            d0(getResources().getString(R.string.modified_data_name), 1, new View[0]);
        } else {
            d0(getResources().getString(R.string.modified_data_password), 1, new View[0]);
        }
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_submit) {
            int i7 = this.E;
            if (i7 != 1) {
                if (i7 == 2) {
                    View childAt = this.D.getChildAt(0);
                    EditText editText = (EditText) childAt.findViewById(R.id.et_edit);
                    FontTextView fontTextView = (FontTextView) childAt.findViewById(R.id.tv_warning);
                    if (editText.getText() == null) {
                        fontTextView.setText(getResources().getString(R.string.register_name_easy));
                        return;
                    } else if (editText.getText().toString().length() < 4 || editText.getText().toString().length() > 15) {
                        fontTextView.setText(getResources().getString(R.string.register_name_easy));
                        return;
                    } else {
                        fontTextView.setText("");
                        this.B.s(editText.getText().toString(), new c(editText));
                        return;
                    }
                }
                return;
            }
            View childAt2 = this.D.getChildAt(0);
            EditText editText2 = (EditText) childAt2.findViewById(R.id.et_edit);
            FontTextView fontTextView2 = (FontTextView) childAt2.findViewById(R.id.tv_warning);
            com.haier.globalwasher.modle.utils.q.a("newPassWord", "" + editText2.getText().toString().trim());
            View childAt3 = this.D.getChildAt(1);
            EditText editText3 = (EditText) childAt3.findViewById(R.id.et_edit);
            FontTextView fontTextView3 = (FontTextView) childAt3.findViewById(R.id.tv_warning);
            com.haier.globalwasher.modle.utils.q.a("newPassWord", "" + editText3.getText().toString().trim());
            if (editText2.getText() == null || editText3.getText() == null) {
                fontTextView3.setText(getResources().getString(R.string.change_password_delif));
                return;
            }
            if (editText2.getText().length() < 6) {
                fontTextView2.setText(getResources().getString(R.string.change_password_delif));
                return;
            }
            fontTextView2.setText("");
            if (editText3.getText().length() < 6) {
                fontTextView3.setText(getResources().getString(R.string.change_password_delif));
            } else {
                fontTextView3.setText("");
                this.B.t(editText2.getText().toString().trim(), editText3.getText().toString().trim(), new b());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.B.j(this.E, new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, UpDataProfileBeen upDataProfileBeen) {
        bVar.b(R.id.tv_title_not_frame, R.id.et_edit, R.id.cb_image, R.id.tv_warning);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_title_not_frame);
        CheckBox checkBox = (CheckBox) bVar.a(R.id.cb_image);
        EditText editText = (EditText) bVar.a(R.id.et_edit);
        TextView textView = (TextView) bVar.a(R.id.tv_warning);
        int i8 = this.E;
        if (i8 == 2) {
            fontTextView.setVisibility(8);
            checkBox.setVisibility(8);
            editText.setText(upDataProfileBeen.getHint());
            editText.setInputType(1);
            editText.setFilters(new InputFilter[]{new d0.a()});
            return;
        }
        if (i8 == 1) {
            fontTextView.setVisibility(0);
            fontTextView.setText(upDataProfileBeen.getTitle());
            textView.setVisibility(0);
            if (i7 == 0) {
                checkBox.setVisibility(8);
                checkBox.setOnClickListener(null);
                ((LinearLayout.LayoutParams) fontTextView.getLayoutParams()).topMargin = n0.c(this, 15);
            } else {
                ((LinearLayout.LayoutParams) fontTextView.getLayoutParams()).topMargin = 0;
                checkBox.setVisibility(0);
                checkBox.setOnCheckedChangeListener(new d(editText));
            }
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.updata_item_not_frame, null), 2);
    }
}
