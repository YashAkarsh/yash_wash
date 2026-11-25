package com.haier.globalwasher.view.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.a;
import com.haier.globalwasher.mvp_api.presenter.b;
import com.haier.globalwasher.presenter.r;
import com.haier.globalwasher.view.adapter.c;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GuidePageActivity extends BaseActivity implements ViewPager.i {
    private TextView A;
    private FontTextView B;
    private FontTextView C;
    private Resources D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private r f25425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ViewPager f25426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int[] f25427w = {R.drawable.android_pay_1, R.drawable.android_pay_2, R.drawable.android_pay_3};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ArrayList<ImageView> f25428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private c f25429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView[] f25430z;

    private void g0() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.sp_dot);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
        layoutParams.setMargins(10, 0, 10, 0);
        this.f25430z = new ImageView[this.f25427w.length];
        for (int i7 = 0; i7 < this.f25428x.size(); i7++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            if (i7 == 0) {
                imageView.setSelected(true);
            } else {
                imageView.setSelected(false);
            }
            this.f25430z[i7] = imageView;
            linearLayout.addView(imageView);
        }
    }

    private void h0() {
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        this.f25428x = new ArrayList<>();
        for (int i7 = 0; i7 < this.f25427w.length; i7++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(this.f25427w[i7]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f25428x.add(imageView);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        a.d(this, 1006, new String[0]);
        h0();
        g0();
        c cVar = new c(this.f25428x);
        this.f25429y = cVar;
        this.f25426v.setAdapter(cVar);
        this.f25426v.c(this);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_guide;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, null);
        U(false);
        this.D = getResources();
        this.f25426v = (ViewPager) findViewById(R.id.sp_viewpager);
        this.A = (TextView) S(R.id.sp_btn_logn, true);
        this.B = (FontTextView) findViewById(R.id.font_id_text);
        this.C = (FontTextView) findViewById(R.id.font_id_text_tow);
        this.A.setVisibility(8);
        this.B.setText(this.D.getString(R.string.introduction_title_one));
        this.C.setText(this.D.getString(R.string.introduction_msg_one));
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public b f() {
        r rVar = new r();
        this.f25425u = rVar;
        return rVar;
    }

    @Override // androidx.viewpager.widget.ViewPager.i
    public void h(int i7, float f8, int i8) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.sp_btn_logn) {
            t2.a.b(getApplicationContext(), t2.a.f40354a, t2.a.f40360g, "1");
            this.f25425u.d(this);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.i
    public void t(int i7) {
    }

    @Override // androidx.viewpager.widget.ViewPager.i
    public void u(int i7) {
        if (i7 == this.f25427w.length - 1) {
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(8);
        }
        int i8 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f25430z;
            if (i8 >= imageViewArr.length) {
                break;
            }
            if (i7 == i8) {
                imageViewArr[i8].setSelected(true);
            } else {
                imageViewArr[i8].setSelected(false);
            }
            i8++;
        }
        if (i7 == 0) {
            this.B.setText(this.D.getString(R.string.introduction_title_one));
            this.C.setText(this.D.getString(R.string.introduction_msg_one));
        } else if (i7 == 1) {
            this.B.setText(this.D.getString(R.string.introduction_title_two));
            this.C.setText(this.D.getString(R.string.introduction_msg_two));
        } else if (i7 == 2) {
            this.B.setText(this.D.getString(R.string.introduction_title_three));
            this.C.setText(this.D.getString(R.string.introduction_msg_three));
        }
    }
}
