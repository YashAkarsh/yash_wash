package com.jiao.project.bluetoothofabroadwasherapp.view.adapter;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.haier.hailicommontlib.mvp.model.utils.b;
import com.jiao.project.bluetoothofabroadwasherapp.R;
import com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f32461d = "CustomBluetoothUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ScanResult> f32462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f32463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h f32464c;

    /* JADX INFO: renamed from: com.jiao.project.bluetoothofabroadwasherapp.view.adapter.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0391a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f32465a;

        ViewOnClickListenerC0391a(int i7) {
            this.f32465a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f32464c == null || h.f32416q == null) {
                return;
            }
            b.c("CustomBluetoothUtil", "list.get(" + this.f32465a + ").getAddress()=" + ((ScanResult) a.this.f32462a.get(this.f32465a)).getDevice().getAddress() + "  name=" + ((ScanResult) a.this.f32462a.get(this.f32465a)).getDevice().getName());
            a aVar = a.this;
            aVar.f32464c.a(((ScanResult) aVar.f32462a.get(this.f32465a)).getDevice().getAddress());
        }
    }

    public a(List<ScanResult> list, Context context) {
        this.f32462a = list;
        this.f32463b = context;
    }

    public void b(h hVar) {
        this.f32464c = hVar;
    }

    public void c(List<ScanResult> list) {
        this.f32462a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f32462a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f32462a.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        View viewInflate = View.inflate(this.f32463b, R.layout.adapter_bluetoothlist, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_address);
        ((TextView) viewInflate.findViewById(R.id.tv_name)).setText(this.f32462a.get(i7).getDevice().getName() + "");
        textView.setText(this.f32462a.get(i7).getDevice().getAddress() + "");
        viewInflate.setOnClickListener(new ViewOnClickListenerC0391a(i7));
        return viewInflate;
    }
}
