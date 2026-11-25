package com.haier.globalwasher.modle.advertis;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;
import androidx.viewpager.widget.ViewPager;
import c.m0;
import com.bumptech.glide.l;
import com.bumptech.glide.request.animation.e;
import com.bumptech.glide.request.target.j;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.VideoActivityBean;
import com.haier.globalwasher.modle.bean.advertis.AdertisView;
import com.haier.globalwasher.modle.bean.advertis.FirstPagePopupWindowAdvertisBean;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.activity.videopage.VedioActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f24335c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    c f24337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ViewPager f24338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    RadioGroup f24339g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24333a = "Advertis";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<AdertisView> f24334b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.globalwasher.view.adapter.b f24336d = null;

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.advertis.a$a, reason: collision with other inner class name */
    class C0316a implements ViewPager.i {
        C0316a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void h(int i7, float f8, int i8) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void t(int i7) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void u(int i7) {
            int i8 = 0;
            while (i8 < a.this.f24334b.size()) {
                if ((((AdertisView) a.this.f24334b.get(i8)).getMediaView() instanceof ViewGroup) && i8 != i7) {
                    ViewGroup viewGroup = (ViewGroup) ((AdertisView) a.this.f24334b.get(i8)).getMediaView();
                    if (viewGroup.getChildCount() > 0) {
                        for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                            if ((viewGroup.getChildAt(i9) instanceof VideoView) && ((VideoView) viewGroup.getChildAt(i9)).isPlaying()) {
                                ((VideoView) viewGroup.getChildAt(i9)).pause();
                                break;
                            }
                        }
                    }
                }
                ((AdertisView) a.this.f24334b.get(i8)).getNavigation().setChecked(i8 == i7);
                i8++;
            }
        }
    }

    class b extends j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f24341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f24342e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FirstPagePopupWindowAdvertisBean f24343f;

        b(d dVar, ImageView imageView, FirstPagePopupWindowAdvertisBean firstPagePopupWindowAdvertisBean) {
            this.f24341d = dVar;
            this.f24342e = imageView;
            this.f24343f = firstPagePopupWindowAdvertisBean;
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, e<? super Bitmap> eVar) {
            d dVar = this.f24341d;
            if (dVar != null) {
                dVar.a(this.f24342e, this.f24343f);
            }
            this.f24342e.setImageBitmap(bitmap);
        }
    }

    public class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BaseActivity f24345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<FirstPagePopupWindowAdvertisBean> f24346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        PopupWindow f24347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PopupWindow f24348d;

        /* JADX INFO: renamed from: com.haier.globalwasher.modle.advertis.a$c$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0317a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FirstPagePopupWindowAdvertisBean f24350a;

            ViewOnClickListenerC0317a(FirstPagePopupWindowAdvertisBean firstPagePopupWindowAdvertisBean) {
                this.f24350a = firstPagePopupWindowAdvertisBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (1 == this.f24350a.getMediaType()) {
                    WebActivity.j0(c.this.f24345a, "", this.f24350a.getHttpUrl());
                } else if (2 == this.f24350a.getMediaType()) {
                    VideoActivityBean videoActivityBean = new VideoActivityBean();
                    videoActivityBean.setVedioUrl(this.f24350a.getVideoUrl());
                    VedioActivity.h0(c.this.f24345a, videoActivityBean);
                }
                PopupWindow popupWindow = c.this.f24348d;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    return;
                }
                c.this.f24348d.dismiss();
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.f24347c.dismiss();
                c.this.f24348d.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.haier.globalwasher.modle.advertis.a$c$c, reason: collision with other inner class name */
        class C0318c implements PopupWindow.OnDismissListener {
            C0318c() {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (c.this.f24347c.isShowing()) {
                    c.this.f24347c.dismiss();
                }
                a.this.f24335c = null;
                a.this.f24334b.clear();
                a.this.f24336d = null;
            }
        }

        public c(BaseActivity baseActivity, ArrayList<FirstPagePopupWindowAdvertisBean> arrayList) {
            this.f24345a = baseActivity;
            this.f24346b = arrayList;
        }

        @Override // com.haier.globalwasher.modle.advertis.a.d
        public void a(View view, FirstPagePopupWindowAdvertisBean firstPagePopupWindowAdvertisBean) {
            view.setOnClickListener(new ViewOnClickListenerC0317a(firstPagePopupWindowAdvertisBean));
            q.c(a.this.f24333a, "onCompletion=" + a.this.f24334b.size());
            BaseActivity baseActivity = this.f24345a;
            if (baseActivity == null || baseActivity.isFinishing()) {
                return;
            }
            if (this.f24347c == null) {
                View view2 = new View(this.f24345a);
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                PopupWindow popupWindow = new PopupWindow(view2);
                this.f24347c = popupWindow;
                popupWindow.setWidth(-1);
                this.f24347c.setHeight(-1);
                this.f24347c.setFocusable(false);
                this.f24347c.setOutsideTouchable(false);
                this.f24347c.setBackgroundDrawable(new ColorDrawable(-1342177280));
            }
            if (this.f24348d != null) {
                a.this.h(this.f24345a, view);
                return;
            }
            a.this.h(this.f24345a, view);
            PopupWindow popupWindow2 = new PopupWindow(a.this.f24335c);
            this.f24348d = popupWindow2;
            popupWindow2.setWidth(n0.e(275.0f));
            this.f24348d.setHeight(n0.e(350.0f));
            this.f24348d.setFocusable(false);
            this.f24348d.setOutsideTouchable(false);
            this.f24348d.setAnimationStyle(R.style.popupZoomAnimation);
            this.f24348d.setBackgroundDrawable(new ColorDrawable(0));
            View viewFindViewById = a.this.f24335c.findViewById(R.id.iv_close);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new b());
            }
            this.f24348d.setOnDismissListener(new C0318c());
            this.f24347c.showAtLocation(this.f24345a.getWindow().getDecorView(), 17, 0, 0);
            this.f24348d.showAtLocation(this.f24345a.getWindow().getDecorView(), 17, 0, 0);
        }
    }

    public interface d {
        void a(View view, FirstPagePopupWindowAdvertisBean firstPagePopupWindowAdvertisBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h(BaseActivity baseActivity, View view) {
        if (this.f24335c == null) {
            View viewInflate = View.inflate(baseActivity, R.layout.advertis_popupwindow, null);
            this.f24335c = viewInflate;
            this.f24338f = (ViewPager) viewInflate.findViewById(R.id.vp_img);
            this.f24339g = (RadioGroup) this.f24335c.findViewById(R.id.rg_navigation);
        }
        RadioButton radioButton = (RadioButton) View.inflate(baseActivity, R.layout.radio_buttom_navigation, null);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(n0.e(5.0f), n0.e(5.0f));
        layoutParams.leftMargin = n0.e(3.0f);
        radioButton.setLayoutParams(layoutParams);
        this.f24334b.add(new AdertisView(view, radioButton));
        this.f24339g.addView(radioButton);
        radioButton.setChecked(this.f24334b.size() == 1);
        q.c(this.f24333a, "advertisViewInFragment adertisViews.size=" + this.f24334b.size());
        com.haier.globalwasher.view.adapter.b bVar = this.f24336d;
        if (bVar == null) {
            com.haier.globalwasher.view.adapter.b bVar2 = new com.haier.globalwasher.view.adapter.b(this.f24334b);
            this.f24336d = bVar2;
            this.f24338f.setAdapter(bVar2);
            this.f24338f.setOffscreenPageLimit(this.f24334b.size() < 2 ? this.f24334b.size() : this.f24334b.size() - 1);
            this.f24338f.c(new C0316a());
        } else {
            bVar.l();
        }
        return this.f24335c;
    }

    private void i(BaseActivity baseActivity, FirstPagePopupWindowAdvertisBean firstPagePopupWindowAdvertisBean, d dVar) {
        ImageView imageView = new ImageView(baseActivity);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        l.O(baseActivity).E(firstPagePopupWindowAdvertisBean.getPictureURL()).L0().F(new b(dVar, imageView, firstPagePopupWindowAdvertisBean));
    }

    public void g(BaseActivity baseActivity, @m0 ArrayList<FirstPagePopupWindowAdvertisBean> arrayList) {
        if (this.f24337e == null) {
            this.f24337e = new c(baseActivity, arrayList);
        }
        this.f24334b.clear();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            q.c(this.f24333a, "advertisPopupWindowAtFirstPage adertisViews.size=" + arrayList.size());
            i(baseActivity, arrayList.get(i7), this.f24337e);
        }
    }
}
