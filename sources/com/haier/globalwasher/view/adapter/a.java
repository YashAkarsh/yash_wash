package com.haier.globalwasher.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.ShowRunModeBeen;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.activity.device.WasherDeviceDetaileActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.globalwasher.mvp_api.adapter.c<ShowRunModeBeen> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Resources f25784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WasherDeviceDetaileActivity.c f25785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Handler f25786k;

    /* JADX INFO: renamed from: com.haier.globalwasher.view.adapter.a$a, reason: collision with other inner class name */
    class C0338a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25787a;

        C0338a(int i7) {
            this.f25787a = i7;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (a.this.f25785j != null) {
                a.this.new c(z7, this.f25787a).start();
            }
        }
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 3) {
                a.this.j();
            }
        }
    }

    class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f25791b;

        public c(boolean z7, int i7) {
            this.f25790a = i7;
            this.f25791b = z7;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            super.run();
            ArrayList<String> arrayListA = a.this.f25785j.a(this.f25791b, (ShowRunModeBeen) a.this.f24783c.get(this.f25790a));
            if (arrayListA.size() == 0) {
                ((ShowRunModeBeen) a.this.f24783c.get(this.f25790a)).setSelect(false);
            } else {
                for (int i7 = 0; i7 < arrayListA.size(); i7++) {
                    if (arrayListA.get(i7).equals(((ShowRunModeBeen) a.this.f24783c.get(this.f25790a)).getCode())) {
                        ((ShowRunModeBeen) a.this.f24783c.get(this.f25790a)).setSelect(true);
                    } else {
                        ((ShowRunModeBeen) a.this.f24783c.get(this.f25790a)).setSelect(false);
                    }
                }
            }
            a.this.f25786k.sendEmptyMessage(3);
        }
    }

    public a(ArrayList<ShowRunModeBeen> arrayList, int i7, WasherDeviceDetaileActivity.c cVar) {
        super(arrayList, i7);
        this.f25786k = new b();
        this.f25785j = cVar;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.c
    public View G(Context context) {
        View viewInflate = View.inflate(context, R.layout.device_detail_run_model_item, null);
        this.f25784i = context.getResources();
        return viewInflate;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.c
    public boolean H() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void u(com.haier.globalwasher.mvp_api.adapter.c.a aVar, @SuppressLint({"RecyclerView"}) int i7) {
        aVar.P(R.id.cb_child_model, R.id.lly_chebox_background);
        LinearLayout linearLayout = (LinearLayout) aVar.O(R.id.lly_chebox_background);
        CheckBox checkBox = (CheckBox) aVar.O(R.id.cb_child_model);
        checkBox.setChecked(((ShowRunModeBeen) this.f24783c.get(i7)).isSelect());
        checkBox.setText(((ShowRunModeBeen) this.f24783c.get(i7)).getModeName());
        if (((ShowRunModeBeen) this.f24783c.get(i7)).isSelect()) {
            linearLayout.setBackground(this.f25784i.getDrawable(R.drawable.cardview_background));
        } else {
            linearLayout.setBackground(null);
        }
        q.c("RequestNetWork", "" + i7 + "---" + ((ShowRunModeBeen) this.f24783c.get(i7)).isSelect());
        checkBox.setOnCheckedChangeListener(new C0338a(i7));
    }
}
