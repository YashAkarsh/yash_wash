package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.t0;
import com.bumptech.glide.l;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.ProfilePageBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.presenter.p;
import com.haier.globalwasher.presenter.t;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileActivity extends BaseListActivity<ProfilePageBeen> implements d<ProfilePageBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private com.haier.globalwasher.mvp_api.adapter.a<ProfilePageBeen, com.haier.globalwasher.mvp_api.adapter.b> B;
    ListView C;
    private p D = new p();
    ArrayList<ProfilePageBeen> E;

    class a extends BaseListActivity<ProfilePageBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<ProfilePageBeen> arrayList) {
            ProfileActivity profileActivity = ProfileActivity.this;
            profileActivity.E = arrayList;
            if (profileActivity.B != null) {
                ProfileActivity.this.B.notifyDataSetChanged();
                return;
            }
            ProfileActivity profileActivity2 = ProfileActivity.this;
            ProfileActivity profileActivity3 = ProfileActivity.this;
            profileActivity2.B = new com.haier.globalwasher.mvp_api.adapter.a(profileActivity3, profileActivity3.E, profileActivity3);
            ProfileActivity profileActivity4 = ProfileActivity.this;
            profileActivity4.C.setAdapter((ListAdapter) profileActivity4.B);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f25665b;

        b(int i7, ImageView imageView) {
            this.f25664a = i7;
            this.f25665b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i7 = this.f25664a;
            if (i7 == 0) {
                ProfileActivity.this.D.l(this.f25665b);
                return;
            }
            if (i7 == 1) {
                Intent intent = new Intent(ProfileActivity.this, (Class<?>) UpDataProfileActivity.class);
                intent.putExtra(t.f25316i, 2);
                ProfileActivity.this.startActivityForResult(intent, 1004);
            } else if (i7 != 3) {
                if (i7 != 4) {
                    return;
                }
                ProfileActivity.this.startActivityForResult((ProfileAvatarImageBeen.getInstance().getEmail() == null || !d0.j(ProfileAvatarImageBeen.getInstance().getEmail())) ? new Intent(ProfileActivity.this, (Class<?>) AddDataProfileEmailActivity.class) : new Intent(ProfileActivity.this, (Class<?>) UPDataProfileEmailActivity.class), 1014);
            } else {
                if (!ProfileAvatarImageBeen.getInstance().isHavepwd()) {
                    ProfileActivity.this.startActivity(new Intent(ProfileActivity.this, (Class<?>) UPDataProfilePasswprdActivity.class));
                    return;
                }
                Intent intent2 = new Intent(ProfileActivity.this, (Class<?>) UpDataProfileActivity.class);
                intent2.putExtra(t.f25316i, 1);
                ProfileActivity.this.startActivity(intent2);
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_profile;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.D;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        this.C = (ListView) findViewById(R.id.xlv_profile);
        d0(getResources().getString(R.string.modified_data_title), 1, new View[0]);
        n0(false);
        return this.C;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @t0(api = 29)
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        int i9 = 0;
        if (1004 == i7 && 1005 == i8) {
            while (i9 < this.E.size()) {
                if (getResources().getString(R.string.modified_data_name).equals(this.E.get(i9).getTitle())) {
                    this.E.get(i9).setContent(ProfileAvatarImageBeen.getInstance().getUserName());
                    this.B.notifyDataSetChanged();
                }
                i9++;
            }
            return;
        }
        if (1014 != i7 || 1015 != i8) {
            this.D.o(i7, i8, intent);
            return;
        }
        while (i9 < this.E.size()) {
            if (getResources().getString(R.string.modified_data_email).equals(this.E.get(i9).getTitle())) {
                this.E.get(i9).setContent(ProfileAvatarImageBeen.getInstance().getDesensitizationMailNumber());
                this.B.notifyDataSetChanged();
            }
            i9++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.D.m(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 16)
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, ProfilePageBeen profilePageBeen) {
        bVar.b(R.id.lly_background, R.id.tv_image, R.id.iv_face, R.id.tv_value, R.id.iv_more);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_background);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_image);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_face);
        TextView textView = (TextView) bVar.a(R.id.tv_value);
        ImageView imageView2 = (ImageView) bVar.a(R.id.iv_more);
        fontTextView.setText(profilePageBeen.getTitle());
        textView.setText(profilePageBeen.getContent());
        if (ProfileAvatarImageBeen.getInstance().getAvatar() == null || "".equals(ProfileAvatarImageBeen.getInstance().getAvatar())) {
            imageView.setImageResource(R.drawable.icon_touxiang_wode);
        } else {
            l.O(this).E(ProfileAvatarImageBeen.getInstance().getAvatar()).c0(new com.haier.globalwasher.modle.utils.l(this)).E(imageView);
        }
        if (i7 == 0) {
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.first_laundry_item_select_not_projection));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fontTextView.getLayoutParams();
            layoutParams.height = n0.c(context, 90);
            fontTextView.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fontTextView.getLayoutParams();
            layoutParams2.height = n0.c(context, 50);
            fontTextView.setLayoutParams(layoutParams2);
            imageView.setVisibility(8);
            if (i7 == 2) {
                textView.setText(d0.h(profilePageBeen.getContent()));
            }
            if (i7 == 2) {
                imageView2.setVisibility(8);
                linearLayout.setBackground(context.getResources().getDrawable(R.drawable.cardview_background_huise_not_projection));
            } else {
                imageView2.setVisibility(0);
                linearLayout.setBackground(context.getResources().getDrawable(R.drawable.first_laundry_item_select_not_projection));
            }
        }
        linearLayout.setOnClickListener(new b(i7, imageView));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        View viewInflate = View.inflate(this, R.layout.profile_item, null);
        return i7 == 2 ? new com.haier.globalwasher.mvp_api.adapter.b(this, viewInflate, 3) : new com.haier.globalwasher.mvp_api.adapter.b(this, viewInflate, 1);
    }
}
