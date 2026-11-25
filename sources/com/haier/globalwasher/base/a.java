package com.haier.globalwasher.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import c.o0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.q;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Fragment implements com.haier.globalwasher.mvp_api.view.a, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.haier.globalwasher.mvp_api.presenter.b f24305a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f24308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    View f24309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    View f24310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BaseActivity f24311g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f24313i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24306b = "BaseFragment";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList<View> f24312h = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24314j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24315k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24316l = 2;

    /* JADX INFO: renamed from: com.haier.globalwasher.base.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0315a implements View.OnClickListener {
        ViewOnClickListenerC0315a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.e();
        }
    }

    public void A(View... viewArr) {
        this.f24312h.clear();
        for (int i7 = 0; i7 < viewArr.length; i7++) {
            if (viewArr[i7].getId() == R.id.utiles_temporarily_no_data) {
                this.f24314j = i7;
            } else if (viewArr[i7].getId() == R.id.utiles_reload_the) {
                this.f24315k = i7;
            }
            this.f24312h.add(viewArr[i7]);
        }
    }

    public void B(View view, int i7) {
        if (this.f24312h.size() > i7) {
            for (int i8 = 0; i8 < this.f24312h.size(); i8++) {
                if (view != null) {
                    if (i7 == this.f24315k) {
                        view.setVisibility(8);
                    } else if (!view.isShown()) {
                        view.setVisibility(0);
                    }
                }
                if (i8 == i7) {
                    this.f24312h.get(i8).setVisibility(0);
                } else {
                    this.f24312h.get(i8).setVisibility(8);
                }
            }
        }
    }

    public <V extends View> V C(int i7, boolean z7) {
        V v7 = (V) this.f24308d.findViewById(i7);
        if (z7) {
            v7.setOnClickListener(this);
        }
        return v7;
    }

    public void D(String str) {
        if (str == null) {
            this.f24313i.setVisibility(8);
            return;
        }
        this.f24313i.setVisibility(0);
        if (str.length() > 0) {
            this.f24313i.setText(str);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract void a();

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract int b();

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract void d();

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract com.haier.globalwasher.mvp_api.presenter.b f();

    @Override // com.haier.globalwasher.mvp_api.view.a
    public <V extends View> V findViewById(int i7) {
        return (V) this.f24308d.findViewById(i7);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@o0 Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @o0
    public View onCreateView(LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        q.c("BaseActivity", "" + getClass().getSimpleName());
        this.f24307c = b();
        this.f24311g = (BaseActivity) getActivity();
        com.haier.globalwasher.mvp_api.presenter.b bVarF = f();
        this.f24305a = bVarF;
        if (bVarF != null) {
            bVarF.a(this.f24311g);
        }
        this.f24308d = View.inflate(this.f24311g, this.f24307c, null);
        View viewInflate = View.inflate(this.f24311g, R.layout.fragment_base, null);
        this.f24309e = viewInflate.findViewById(R.id.utiles_reload_the);
        this.f24310f = viewInflate.findViewById(R.id.utiles_temporarily_no_data);
        this.f24313i = (TextView) viewInflate.findViewById(R.id.tv_notdata_message);
        ((TextView) this.f24309e.findViewById(R.id.reload_btn)).setOnClickListener(new ViewOnClickListenerC0315a());
        ((FrameLayout) viewInflate.findViewById(R.id.fly_)).addView(this.f24308d);
        A(this.f24310f, this.f24309e);
        d();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        q.c(this.f24306b, "onDestroy=" + toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
