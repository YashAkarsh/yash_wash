package com.haier.globalwasher.modle.utils.phone_util;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.View;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.z;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24679a = "BluetoothUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BluetoothAdapter f24680b = BluetoothAdapter.getDefaultAdapter();

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.utils.phone_util.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0323a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f24681a;

        ViewOnClickListenerC0323a(c cVar) {
            this.f24681a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24681a.cancel();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f24683a;

        b(c cVar) {
            this.f24683a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = this.f24683a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public interface c {
        void a();

        void cancel();
    }

    public boolean a() {
        if (b()) {
            return this.f24680b.disable();
        }
        return true;
    }

    public boolean b() {
        return this.f24680b.isEnabled();
    }

    public void c(BaseActivity baseActivity) {
        baseActivity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1012);
    }

    public boolean d() {
        if (b()) {
            return true;
        }
        return this.f24680b.enable();
    }

    public void e(BaseActivity baseActivity, c cVar) {
        z.f(baseActivity, baseActivity.getResources().getString(R.string.open_bluetooth_popup_title), baseActivity.getResources().getString(R.string.open_bluetooth_popup_content), baseActivity.getResources().getString(R.string.open_bluetooth_popup_button_dont_allow), baseActivity.getResources().getString(R.string.open_bluetooth_popup_button_allow), new ViewOnClickListenerC0323a(cVar), new b(cVar));
    }
}
