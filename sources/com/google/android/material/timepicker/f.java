package com.google.android.material.timepicker;

import android.view.accessibility.AccessibilityManager;
import com.google.android.material.R;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.TraceProtocolConst;

/* JADX INFO: loaded from: classes.dex */
class f implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f18838f = {"12", "1", "2", "3", "4", "5", TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE_BLE_ADV, TraceProtocolConst.PRO_CONFIG_PROFILE_BT_SECURITY, HttpHelper.b.f29530c, "9", "10", "11"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f18839g = {"00", "2", "4", TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE_BLE_ADV, HttpHelper.b.f29530c, "10", "12", "14", "16", "18", "20", "22"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f18840h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f18841i = 30;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18842j = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TimePickerView f18843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TimeModel f18844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f18845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f18846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18847e = false;

    public f(TimePickerView timePickerView, TimeModel timeModel) {
        this.f18843a = timePickerView;
        this.f18844b = timeModel;
        a();
    }

    private int i() {
        return this.f18844b.f18792c == 1 ? 15 : 30;
    }

    private String[] j() {
        return this.f18844b.f18792c == 1 ? f18839g : f18838f;
    }

    private void k(int i7, int i8) {
        TimeModel timeModel = this.f18844b;
        if (timeModel.f18794e == i8 && timeModel.f18793d == i7) {
            return;
        }
        this.f18843a.performHapticFeedback(4);
    }

    private void m() {
        TimePickerView timePickerView = this.f18843a;
        TimeModel timeModel = this.f18844b;
        timePickerView.b(timeModel.f18796g, timeModel.d(), this.f18844b.f18794e);
    }

    private void n() {
        o(f18838f, TimeModel.f18789i);
        o(f18839g, TimeModel.f18789i);
        o(f18840h, TimeModel.f18788h);
    }

    private void o(String[] strArr, String str) {
        for (int i7 = 0; i7 < strArr.length; i7++) {
            strArr[i7] = TimeModel.b(this.f18843a.getResources(), strArr[i7], str);
        }
    }

    @Override // com.google.android.material.timepicker.h
    public void a() {
        if (this.f18844b.f18792c == 0) {
            this.f18843a.U();
        }
        this.f18843a.J(this);
        this.f18843a.R(this);
        this.f18843a.Q(this);
        this.f18843a.O(this);
        n();
        c();
    }

    @Override // com.google.android.material.timepicker.h
    public void b() {
        this.f18843a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.h
    public void c() {
        this.f18846d = this.f18844b.d() * i();
        TimeModel timeModel = this.f18844b;
        this.f18845c = timeModel.f18794e * 6;
        l(timeModel.f18795f, false);
        m();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void d(float f8, boolean z7) {
        if (this.f18847e) {
            return;
        }
        TimeModel timeModel = this.f18844b;
        int i7 = timeModel.f18793d;
        int i8 = timeModel.f18794e;
        int iRound = Math.round(f8);
        TimeModel timeModel2 = this.f18844b;
        if (timeModel2.f18795f == 12) {
            timeModel2.j((iRound + 3) / 6);
            this.f18845c = (float) Math.floor(this.f18844b.f18794e * 6);
        } else {
            this.f18844b.h((iRound + (i() / 2)) / i());
            this.f18846d = this.f18844b.d() * i();
        }
        if (z7) {
            return;
        }
        m();
        k(i7, i8);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void e(float f8, boolean z7) {
        this.f18847e = true;
        TimeModel timeModel = this.f18844b;
        int i7 = timeModel.f18794e;
        int i8 = timeModel.f18793d;
        if (timeModel.f18795f == 10) {
            this.f18843a.L(this.f18846d, false);
            if (!((AccessibilityManager) androidx.core.content.d.o(this.f18843a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                l(12, true);
            }
        } else {
            int iRound = Math.round(f8);
            if (!z7) {
                this.f18844b.j(((iRound + 15) / 30) * 5);
                this.f18845c = this.f18844b.f18794e * 6;
            }
            this.f18843a.L(this.f18845c, z7);
        }
        this.f18847e = false;
        m();
        k(i8, i7);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void f(int i7) {
        this.f18844b.k(i7);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void g(int i7) {
        l(i7, true);
    }

    @Override // com.google.android.material.timepicker.h
    public void h() {
        this.f18843a.setVisibility(8);
    }

    void l(int i7, boolean z7) {
        boolean z8 = i7 == 12;
        this.f18843a.K(z8);
        this.f18844b.f18795f = i7;
        this.f18843a.c(z8 ? f18840h : j(), z8 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.f18843a.L(z8 ? this.f18845c : this.f18846d, z7);
        this.f18843a.a(i7);
        this.f18843a.N(new b(this.f18843a.getContext(), R.string.material_hour_selection));
        this.f18843a.M(new b(this.f18843a.getContext(), R.string.material_minute_selection));
    }
}
