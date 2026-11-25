package com.haier.globalwasher.view.activity.device;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import c.m0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.DeviceDetailBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.RunModeBeen;
import com.haier.globalwasher.modle.bean.ShowRunModeBeen;
import com.haier.globalwasher.modle.bean.UBluetoothBean;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.o;
import com.haier.globalwasher.presenter.x;
import com.haier.globalwasher.view.activity.order.OrderIsPaidToRunActivity;
import com.haier.globalwasher.view.activity.order.SubscriptSuccessfulActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceBaseActivity extends BaseListActivity<RunModeBeen> implements com.haier.globalwasher.mvp_api.adapter.d<RunModeBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    public Resources B;
    private ArrayList<RunModeBeen> B0;
    private View C;
    private FontTextView D;
    private FontTextView E;
    private FontTextView F;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a.g F0;
    private FontTextView G;
    j G0;
    String H;
    String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ListView f25477J;
    private FontTextView K;
    private FontTextView L;
    private FontTextView M;
    public com.haier.globalwasher.mvp_api.adapter.a<RunModeBeen, com.haier.globalwasher.mvp_api.adapter.b> R;
    LinearLayout S;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a T;
    private DeviceDetailBeen Z;
    public int N = 10;
    public int O = 9;
    public double P = 1.0d;
    private x Q = new x();
    ArrayList<String> U = new ArrayList<>();
    ArrayList<ShowRunModeBeen> V = new ArrayList<>();
    public ShowRunModeBeen W = null;
    private int X = 0;
    private String Y = SubscriptSuccessfulActivity.D;
    private String A0 = "0";
    Handler C0 = new f();
    Map<String, Drawable> D0 = new HashMap();
    Map<String, Drawable> E0 = new HashMap();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceBaseActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceBaseActivity.this.finish();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceBaseActivity.this.finish();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceBaseActivity.this.finish();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceBaseActivity.this.finish();
        }
    }

    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i7 = message.what;
            if (i7 == 1) {
                RunModeBeen runModeBeen = (RunModeBeen) message.obj;
                DeviceBaseActivity deviceBaseActivity = DeviceBaseActivity.this;
                if (deviceBaseActivity.R != null) {
                    deviceBaseActivity.W = new ShowRunModeBeen();
                    DeviceBaseActivity.this.W.setSelect(runModeBeen.isSelect());
                    DeviceBaseActivity.this.W.setCode(runModeBeen.getCode());
                    DeviceBaseActivity.this.W.setIsDisply(runModeBeen.getIsDisply());
                    DeviceBaseActivity.this.W.setModeDescription(runModeBeen.getModeDescription());
                    DeviceBaseActivity.this.W.setModeFeature(runModeBeen.getModeFeature());
                    DeviceBaseActivity.this.W.setModeId(runModeBeen.getModeId());
                    DeviceBaseActivity.this.W.setModeImage(runModeBeen.getModeImage());
                    DeviceBaseActivity.this.W.setModeName(runModeBeen.getModeName());
                    DeviceBaseActivity.this.W.setPrice(runModeBeen.getPrice());
                    DeviceBaseActivity.this.W.setSelectType("T");
                    DeviceBaseActivity.this.W.setTimeDuration(runModeBeen.getTimeDuration());
                    DeviceBaseActivity.this.R.notifyDataSetChanged();
                }
                DeviceBaseActivity.this.K.setText(DeviceBaseActivity.this.W.getTimeDuration() + DeviceBaseActivity.this.getResources().getString(R.string.payment_success_pageds_time_unit));
                if (DeviceBaseActivity.this.Z != null) {
                    DeviceBaseActivity.this.L.setText(DeviceBaseActivity.this.Z.getCurrencySymbol() + " " + DeviceBaseActivity.this.W.getPrice());
                    return;
                }
                DeviceBaseActivity.this.L.setText(DeviceBaseActivity.this.I0().getCurrencySymbol() + " " + DeviceBaseActivity.this.W.getPrice());
                return;
            }
            if (i7 != 2) {
                if (i7 == 3) {
                    ((ImageView) message.obj).setImageDrawable(new BitmapDrawable(com.haier.globalwasher.modle.b.b(message.getData().getByteArray("DRAWABLE"))));
                    return;
                } else {
                    if (i7 != 4) {
                        return;
                    }
                    ((ImageView) DeviceBaseActivity.this.f25477J.getChildAt(0).findViewById(R.id.iv_image)).setImageDrawable(DeviceBaseActivity.this.E0.get((String) message.obj));
                    DeviceBaseActivity.this.R.notifyDataSetChanged();
                    return;
                }
            }
            DeviceBaseActivity deviceBaseActivity2 = DeviceBaseActivity.this;
            deviceBaseActivity2.W = (ShowRunModeBeen) message.obj;
            deviceBaseActivity2.X = message.arg1;
            DeviceBaseActivity.this.K.setText(DeviceBaseActivity.this.W.getTimeDuration() + DeviceBaseActivity.this.getResources().getString(R.string.payment_success_pageds_time_unit));
            if (DeviceBaseActivity.this.Z != null) {
                DeviceBaseActivity.this.L.setText(DeviceBaseActivity.this.Z.getCurrencySymbol() + " " + DeviceBaseActivity.this.W.getPrice());
            } else {
                DeviceBaseActivity.this.L.setText(DeviceBaseActivity.this.I0().getCurrencySymbol() + " " + DeviceBaseActivity.this.W.getPrice());
            }
            FontTextView fontTextView = (FontTextView) DeviceBaseActivity.this.f25477J.getChildAt(DeviceBaseActivity.this.X).findViewById(R.id.tv_introduce);
            if (DeviceBaseActivity.this.W.getModeFeature() == null) {
                fontTextView.setVisibility(8);
            } else {
                fontTextView.setVisibility(0);
                fontTextView.setText(DeviceBaseActivity.this.W.getModeFeature());
            }
        }
    }

    class g extends com.bumptech.glide.request.target.j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f25484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f25485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f25486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ImageView f25487g;

        g(boolean z7, int i7, String str, ImageView imageView) {
            this.f25484d = z7;
            this.f25485e = i7;
            this.f25486f = str;
            this.f25487g = imageView;
        }

        @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
        public void c(Exception exc, Drawable drawable) {
            super.c(exc, drawable);
            this.f25487g.setImageDrawable(DeviceBaseActivity.this.B.getDrawable(R.drawable.icon_commonmix));
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
            q.c(DeviceBaseActivity.this.Y, "isSelect " + this.f25484d + "  position=" + this.f25485e + " url=" + this.f25486f);
            if (bitmap != null) {
                try {
                    if (DeviceBaseActivity.this.D0.get(this.f25486f) == null && this.f25486f.equals(this.f25487g.getTag())) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(DeviceBaseActivity.this.B, bitmap);
                        DeviceBaseActivity.this.D0.put(this.f25486f, bitmapDrawable);
                        Resources resources = DeviceBaseActivity.this.B;
                        Drawable drawableD = com.haier.globalwasher.modle.b.d(resources, bitmap, resources.getColorStateList(R.color.app_white));
                        DeviceBaseActivity.this.E0.put(this.f25486f, drawableD);
                        if (this.f25484d) {
                            this.f25487g.setImageDrawable(drawableD);
                        } else {
                            this.f25487g.setImageDrawable(bitmapDrawable);
                        }
                    }
                } catch (Exception e8) {
                    q.c(DeviceBaseActivity.this.Y, e8.toString());
                    return;
                }
            }
            DeviceBaseActivity.this.R.notifyDataSetChanged();
        }
    }

    class h extends com.haier.globalwasher.modle.utils.bluetoothutil.a.g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j jVar, boolean z7, v3.b bVar) {
            super(z7, bVar);
            Objects.requireNonNull(jVar);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a.g, n2.b
        public void d() {
            super.d();
            q.c(DeviceBaseActivity.this.Y, "deviceIsConnent--toNext=" + r());
            if (r()) {
                DeviceBaseActivity.this.F0();
            } else {
                DeviceBaseActivity.this.M.setOnClickListener(DeviceBaseActivity.this);
            }
        }

        @Override // n2.a
        public void e(boolean z7) {
            DeviceBaseActivity.this.M.setOnClickListener(z7 ? DeviceBaseActivity.this : null);
        }

        @Override // v3.a
        public void g(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, int i7) {
        }
    }

    static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f25491b;

        static {
            int[] iArr = new int[com.haier.globalwasher.modle.enum_.e.values().length];
            f25491b = iArr;
            try {
                iArr[com.haier.globalwasher.modle.enum_.e.RESUERVE_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25491b[com.haier.globalwasher.modle.enum_.e.YUYUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25491b[com.haier.globalwasher.modle.enum_.e.VERIFICATION_NO_PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.haier.globalwasher.modle.enum_.a.values().length];
            f25490a = iArr2;
            try {
                iArr2[com.haier.globalwasher.modle.enum_.a.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25490a[com.haier.globalwasher.modle.enum_.a.IN_USE_SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25490a[com.haier.globalwasher.modle.enum_.a.BLUR_TOOTH_MAKE_AN_APPOINTMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25490a[com.haier.globalwasher.modle.enum_.a.IN_USE_NOT_SUBSCRIBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25490a[com.haier.globalwasher.modle.enum_.a.CAN_NOT_RUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public class j extends com.haier.globalwasher.modle.utils.bluetoothutil.a {
        public j(BaseActivity baseActivity, int i7) {
            super(baseActivity, i7);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a
        public void k() {
            q.c(OrderIsPaidToRunActivity.Q, "devicebaseac_closeUSDKBeforOnDestory");
        }
    }

    public abstract class k extends BaseListActivity<RunModeBeen>.a {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseData f25494a;

            a(BaseData baseData) {
                this.f25494a = baseData;
            }

            @Override // java.lang.Runnable
            public void run() {
                DeviceBaseActivity.this.R0((DeviceDetailBeen) this.f25494a.getData());
            }
        }

        public k() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<RunModeBeen> arrayList) {
            DeviceBaseActivity.this.B0 = arrayList;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0137  */
        /* JADX WARN: Code duplicated, block: B:31:0x01a3  */
        public void h(BaseData<DeviceDetailBeen> baseData) {
            DeviceBaseActivity.this.Z = baseData.getData();
            if (DeviceBaseActivity.this.Z != null) {
                DeviceBaseActivity.this.A0 = d0.i(0, baseData.getData().getType());
                int i7 = i.f25490a[com.haier.globalwasher.modle.enum_.a.d(Integer.parseInt(DeviceBaseActivity.this.Z.getStatus())).ordinal()];
                if (i7 == 1) {
                    DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.button_background_g40_blue));
                    Objects.requireNonNull(DeviceBaseActivity.this.Q);
                    if ("1".equals(DeviceBaseActivity.this.A0)) {
                        DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_washing_mode_btn_wash));
                    } else {
                        Objects.requireNonNull(DeviceBaseActivity.this.Q);
                        if ("2".equals(DeviceBaseActivity.this.A0)) {
                            DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_washing_mode_btn_wash));
                        } else {
                            DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_drying_mode_btn));
                        }
                    }
                } else if (i7 == 2) {
                    DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_washing_mode_btn_Appointment_status));
                    Objects.requireNonNull(DeviceBaseActivity.this.Q);
                    if ("1".equals(DeviceBaseActivity.this.A0)) {
                        DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.button_background_g40_red));
                    } else {
                        Objects.requireNonNull(DeviceBaseActivity.this.Q);
                        if ("2".equals(DeviceBaseActivity.this.A0)) {
                            DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.button_background_g40_red));
                        } else {
                            DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.background_huise_button));
                        }
                    }
                } else if (i7 == 3) {
                    DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.bluetooth_order_button));
                    DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.button_background_g40_blue, null));
                    DeviceBaseActivity.this.S0(false);
                } else if (i7 == 4) {
                    DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_washing_mode_btn_Appointment_status));
                    DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.background_huise_button));
                } else if (i7 == 5) {
                    DeviceBaseActivity.this.M.setText(DeviceBaseActivity.this.getResources().getString(R.string.selective_washing_mode_btn_EquipmentTrouble));
                    DeviceBaseActivity.this.M.setBackground(DeviceBaseActivity.this.getResources().getDrawable(R.drawable.background_huise_button));
                }
            }
            View viewD0 = DeviceBaseActivity.this.D0();
            if (viewD0 != null) {
                DeviceBaseActivity.this.S.addView(viewD0);
            } else {
                DeviceBaseActivity.this.S.setVisibility(8);
            }
            DeviceBaseActivity.this.E0(baseData.getData());
            DeviceBaseActivity.this.S.post(new a(baseData));
        }
    }

    private class l implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f25496c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f25497d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25498a;

        public l(int i7) {
            this.f25498a = i7;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c(DeviceBaseActivity.this.Y, "CreateOrder filed be result in NetWork");
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<OrderDetailsBeen> baseData) {
            OrderDetailsBeen data = baseData.getData();
            if (data != null) {
                q.c(DeviceBaseActivity.this.Y, "CreateOrder success " + data.toString());
                int i7 = i.f25491b[com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(data.getOrderStatus())).ordinal()];
                if (i7 == 1 || i7 == 2) {
                    com.haier.globalwasher.presenter.h.b(DeviceBaseActivity.this, baseData, "", com.haier.globalwasher.modle.enum_.d.SEND_CODE_ACTIVITY, 0);
                    return;
                }
                if (i7 != 3) {
                    return;
                }
                q.c(OrderIsPaidToRunActivity.Q, "--VERIFICATION_NO_PAY--orderType=" + this.f25498a);
                int i8 = this.f25498a;
                if (i8 == 1) {
                    com.haier.globalwasher.presenter.h.b(DeviceBaseActivity.this, null, data.getOrderId(), com.haier.globalwasher.modle.enum_.d.ORDER_PAY_ACTIVITY, 0);
                } else {
                    if (i8 != 2) {
                        return;
                    }
                    com.haier.globalwasher.presenter.h.b(DeviceBaseActivity.this, null, data.getOrderId(), com.haier.globalwasher.modle.enum_.d.ORDER_PAY_ACTIVITY, 1);
                }
            }
        }
    }

    public static <T extends DeviceBaseActivity> void O0(BaseActivity baseActivity, Class cls, String str, String str2) {
        Intent intent = new Intent(baseActivity, (Class<?>) cls);
        intent.putExtra(o.f25218y, str);
        intent.putExtra("deviceQRCode", str2);
        baseActivity.startActivity(intent);
    }

    public abstract View D0();

    public View E0(DeviceDetailBeen deviceDetailBeen) {
        this.B = getResources();
        if (this.C == null) {
            View viewInflate = View.inflate(this, R.layout.activity_top_wash_detaile, null);
            this.C = viewInflate;
            this.D = (FontTextView) viewInflate.findViewById(R.id.name);
            this.E = (FontTextView) this.C.findViewById(R.id.tv_stuta);
            this.G = (FontTextView) this.C.findViewById(R.id.tv_floor);
            this.F = (FontTextView) this.C.findViewById(R.id.tv_address);
            this.G.setText(d0.c(deviceDetailBeen.getSerialNumber()) + this.B.getString(R.string.the_laundry_is_floor_F));
            this.D.setText("#" + d0.f(deviceDetailBeen.getSerialNumber()) + " " + deviceDetailBeen.getName());
            this.F.setText(deviceDetailBeen.getLocation());
            if (deviceDetailBeen.getType().charAt(0) == '1' || deviceDetailBeen.getType().charAt(0) == '2') {
                this.E.setText(this.B.getString(R.string.Nearby_laundry_atlas_available));
                this.E.setCompoundDrawablesWithIntrinsicBounds(this.B.getDrawable(R.drawable.icon_xiyijimingcheng), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (deviceDetailBeen.getType().charAt(0) == '3') {
                this.E.setText(this.B.getString(R.string.Nearby_laundry_atlas_available));
                this.E.setCompoundDrawablesWithIntrinsicBounds(this.B.getDrawable(R.drawable.icon_ganyiji), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        addViewInToolbarBottom(this.C);
        return this.C;
    }

    public void F0() {
        String str;
        x xVar = this.Q;
        int i7 = this.I == null ? 1 : 2;
        String deviceId = this.Z.getDeviceId();
        String strL0 = L0();
        if (this instanceof WasherDeviceDetaileActivity) {
            str = "1";
        } else {
            str = (Integer.parseInt(this.W.getTimeDuration()) / this.N) + "";
        }
        xVar.h(i7, deviceId, strL0, str, "1", new l(2));
    }

    public com.haier.globalwasher.modle.utils.bluetoothutil.a.g G0() {
        v3.b uBluetoothBean;
        if (this.F0 == null) {
            String str = this.Y;
            StringBuilder sb = new StringBuilder();
            sb.append("AbsCheckPhoneParamentInterface---");
            sb.append(this.Z == null);
            q.c(str, sb.toString());
            DeviceDetailBeen deviceDetailBeen = this.Z;
            if (deviceDetailBeen == null || deviceDetailBeen.getBlueToolthInfo() == null) {
                uBluetoothBean = null;
            } else {
                uBluetoothBean = Integer.parseInt(this.Z.getBlueToolthInfo().getModuleType()) == 1 ? new UBluetoothBean(this.Z.getBlueToolthInfo().getAccessToken(), this.Z.getBlueToolthInfo().getBlueName(), this.Z.getBlueToolthInfo().getDirective()) : new w3.a(this.Z.getBlueToolthInfo().getDeviceCode(), this.Z.getBlueToolthInfo().getBlueName(), this.Z.getBlueToolthInfo().getDirective());
            }
            H0();
            j jVar = this.G0;
            if (jVar != null) {
                Objects.requireNonNull(jVar);
                this.F0 = new h(jVar, true, uBluetoothBean);
            }
        }
        return this.F0;
    }

    public void H0() {
        String moduleType;
        int i7;
        if (this.G0 == null) {
            DeviceDetailBeen deviceDetailBeen = this.Z;
            if (deviceDetailBeen != null) {
                moduleType = deviceDetailBeen.getBlueToolthInfo() != null ? this.Z.getBlueToolthInfo().getModuleType() : null;
            } else {
                moduleType = "";
            }
            if ("1".equals(moduleType)) {
                i7 = 1;
            } else {
                i7 = "2".equals(moduleType) ? 2 : -1;
            }
            this.G0 = new j(this, i7);
        }
    }

    public DeviceDetailBeen I0() {
        return this.Z;
    }

    public ListView J0() {
        return this.f25477J;
    }

    public int K0() {
        return this.X;
    }

    public abstract String L0();

    public abstract k M0();

    public void N0(boolean z7, String str, ImageView imageView, int i7) {
        imageView.setTag(str);
        if (this.D0.get(str) == null || this.E0.get(str) == null) {
            if (isFinishing()) {
                return;
            }
            com.bumptech.glide.l.O(this).E(str).L0().F(new g(z7, i7, str, imageView));
        } else if (z7) {
            imageView.setImageDrawable(this.E0.get(str));
        } else {
            imageView.setImageDrawable(this.D0.get(str));
        }
    }

    public void P0(ListView listView) {
        com.haier.globalwasher.mvp_api.adapter.a aVar = (com.haier.globalwasher.mvp_api.adapter.a) listView.getAdapter();
        if (aVar == null) {
            return;
        }
        int measuredHeight = 0;
        for (int i7 = 0; i7 < aVar.getCount(); i7++) {
            measuredHeight += aVar.getView(i7, null, listView).getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + (listView.getDividerHeight() * (aVar.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }

    public void Q0(int i7) {
        this.X = i7;
    }

    public void R0(DeviceDetailBeen deviceDetailBeen) {
        if (deviceDetailBeen != null) {
            if (deviceDetailBeen.getLaundryInfo().getBusinessStatus().equals("2")) {
                this.A0 = d0.i(0, deviceDetailBeen.getType());
                int i7 = i.f25490a[com.haier.globalwasher.modle.enum_.a.d(Integer.parseInt(deviceDetailBeen.getStatus())).ordinal()];
                if (i7 == 2) {
                    Objects.requireNonNull(this.Q);
                    if ("3".equals(this.A0)) {
                        z.d(this, 2, this.B.getString(R.string.reservations_are_not_available_APPOINTMENT), this.B.getString(R.string.reservations_are_not_available_details), "", new a());
                        return;
                    }
                    return;
                }
                if (i7 == 4) {
                    z.d(this, 2, this.B.getString(R.string.reservations_are_not_available_APPOINTMENT), this.B.getString(R.string.reservations_are_not_available_details), "", new b());
                    return;
                } else {
                    if (i7 != 5) {
                        return;
                    }
                    z.b(this, 1, 2, 2, this.B.getString(R.string.reservations_are_not_available_SERVICE), this.B.getString(R.string.reservations_are_not_available_machine), this.B.getString(R.string.reservations_are_not_available_one), new c(), new d());
                    return;
                }
            }
            z.d(this, 2, this.B.getString(R.string.the_laundry_is_closed_title), this.B.getString(R.string.the_laundry_is_closed_smalltitle), this.B.getString(R.string.the_laundry_is_closed_ondetails) + "\n" + this.B.getString(R.string.the_laundry_is_closed_working) + " " + deviceDetailBeen.getLaundryInfo().getWorkStartTime() + " " + this.B.getString(R.string.the_laundry_is_closed_to) + " " + deviceDetailBeen.getLaundryInfo().getWorkEndTime() + "\n" + this.B.getString(R.string.the_laundry_is_closed_saturday) + " " + deviceDetailBeen.getLaundryInfo().getWeekStartTime() + " " + this.B.getString(R.string.the_laundry_is_closed_to) + " " + deviceDetailBeen.getLaundryInfo().getWorkEndTime(), new e());
        }
    }

    public void S0(boolean z7) {
        G0().u(z7);
        H0();
        j jVar = this.G0;
        if (jVar != null) {
            jVar.u(G0());
        }
        q.c(SubscriptSuccessfulActivity.D, "toCheckPhoneSystemPar");
    }

    @Override // com.haier.globalwasher.base.BaseActivity
    public void W() {
        super.W();
        j jVar = this.G0;
        if (jVar != null) {
            jVar.t();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_device_base_detaile;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.Q;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0("", 1, new View[0]);
        this.B = getResources();
        Intent intent = getIntent();
        this.H = intent.getStringExtra(o.f25218y);
        this.f25477J = (ListView) findViewById(R.id.lv_run_model);
        this.I = intent.getStringExtra("deviceQRCode");
        this.K = (FontTextView) findViewById(R.id.tv_time);
        this.L = (FontTextView) findViewById(R.id.tv_price);
        this.M = (FontTextView) S(R.id.tv_wash_button, true);
        this.S = (LinearLayout) findViewById(R.id.lly_view);
        return this.f25477J;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_wash_button) {
            q.c(this.Y, " tv_wash_button");
            DeviceDetailBeen deviceDetailBeen = this.Z;
            if (deviceDetailBeen != null) {
                int i7 = i.f25490a[com.haier.globalwasher.modle.enum_.a.d(Integer.parseInt(deviceDetailBeen.getStatus())).ordinal()];
                String str = "1";
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            return;
                        }
                        S0(true);
                        return;
                    } else {
                        Objects.requireNonNull(this.Q);
                        if (!"1".equals(this.A0)) {
                            Objects.requireNonNull(this.Q);
                            if (!"2".equals(this.A0)) {
                                return;
                            }
                        }
                        this.Q.i(this.Z.getDeviceId(), L0(), new l(1));
                        return;
                    }
                }
                q.c(this.Y, L0() + "===getmodelId");
                x xVar = this.Q;
                int i8 = this.I == null ? 1 : 2;
                String deviceId = this.Z.getDeviceId();
                String strL0 = L0();
                if (!(this instanceof WasherDeviceDetaileActivity)) {
                    str = (Integer.parseInt(this.W.getTimeDuration()) / this.N) + "";
                }
                xVar.h(i8, deviceId, strL0, str, null, new l(1));
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        j jVar = this.G0;
        if (jVar != null) {
            jVar.s();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        H0();
        j jVar = this.G0;
        if (jVar != null) {
            jVar.r(i7, strArr, iArr);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FontTextView fontTextView = this.M;
        if (fontTextView != null) {
            fontTextView.setOnClickListener(this);
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.Q.j(i8, this.H, this.I, M0());
    }
}
