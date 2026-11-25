package com.haier.globalwasher.view.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.l2;
import c.m0;
import com.bumptech.glide.l;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.APIContralViewBean;
import com.haier.globalwasher.modle.bean.MyFragmentListBeen;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.h0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.activity.my_page.ProfileActivity;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.globalwasher.base.a implements com.haier.globalwasher.mvp_api.adapter.d<MyFragmentListBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    public j G;
    public View H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ImageView f26089J;
    public TextView K;
    LinearLayout L;
    i M;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MainActivity f26090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.globalwasher.presenter.c f26091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f26092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f26093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f26094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a<MyFragmentListBeen, com.haier.globalwasher.mvp_api.adapter.b> f26095r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Resources f26097t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private XListView f26098u;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList<MyFragmentListBeen> f26096s = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f26099v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f26100w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f26101x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f26102y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f26103z = 4;
    private final int A = 5;
    private final int B = 6;
    private final int C = 8;
    private final int D = 9;
    private final int E = 10;
    private final int F = 11;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            b.this.M(i7 - 1);
        }
    }

    /* JADX INFO: renamed from: com.haier.globalwasher.view.fragment.b$b, reason: collision with other inner class name */
    class C0344b implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<APIContralViewBean>> {
        C0344b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c("RequestNetWork", "quaryShowInvitation   " + exc.toString());
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<APIContralViewBean> baseListDate) {
            if ("00000".equals(baseListDate.getRetCode()) && baseListDate.getData() != null && baseListDate.getData().size() > 0) {
                b bVar = b.this;
                if (bVar.f26096s == null) {
                    bVar.f26096s = new ArrayList<>();
                }
                for (int i7 = 0; i7 < baseListDate.getData().size(); i7++) {
                    MyFragmentListBeen myFragmentListBeen = new MyFragmentListBeen(baseListDate.getData().get(i7).getContent(), baseListDate.getData().get(i7).getPicUrl(), 11);
                    myFragmentListBeen.setUrl(baseListDate.getData().get(i7).getShowInvitUrl());
                    ArrayList<MyFragmentListBeen> arrayList = b.this.f26096s;
                    int i8 = 1;
                    if (arrayList.size() <= 1) {
                        i8 = 0;
                    }
                    arrayList.add(i8, myFragmentListBeen);
                }
                b.this.f26095r.notifyDataSetChanged();
            }
            q.c("RequestNetWork", "quaryShowInvitation " + baseListDate.toString());
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.M == null) {
                bVar.M = new i(b.this);
            }
            b.this.M.sendEmptyMessage(1);
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MainActivity f26107a;

        d(MainActivity mainActivity) {
            this.f26107a = mainActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(t2.a.a(this.f26107a, t2.a.f40354a, t2.a.f40355b))) {
                b.this.f26091n.n(this.f26107a);
            } else {
                b.this.f26091n.m(2, this.f26107a);
            }
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MainActivity f26109a;

        e(MainActivity mainActivity) {
            this.f26109a = mainActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(t2.a.a(this.f26109a, t2.a.f40354a, t2.a.f40355b))) {
                b.this.f26091n.n(this.f26109a);
            } else {
                b.this.f26091n.m(0, this.f26109a);
            }
        }
    }

    class f extends com.bumptech.glide.request.target.j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MyFragmentListBeen f26111d;

        f(MyFragmentListBeen myFragmentListBeen) {
            this.f26111d = myFragmentListBeen;
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
            if (b.this.f26094q.getTag() == null || !b.this.f26094q.getTag().equals(this.f26111d.getPicUrl())) {
                return;
            }
            b.this.f26094q.setImageBitmap(bitmap);
        }
    }

    class g extends Thread {
        g() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                Thread.sleep(500L);
                Process.killProcess(Process.myPid());
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
        }
    }

    class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f26114a;

        h(boolean z7) {
            this.f26114a = z7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f26114a) {
                if (MyApplication.f24258n) {
                    i0.d(b.this.f26090m, "当前为正式环境");
                    return;
                } else {
                    t2.a.b(MyApplication.k(), t2.a.f40362i, t2.a.f40368o, "1");
                    b.this.P();
                    return;
                }
            }
            if (!MyApplication.f24258n) {
                i0.d(b.this.f26090m, "当前为测试环境");
            } else {
                t2.a.b(MyApplication.k(), t2.a.f40362i, t2.a.f40368o, "2");
                b.this.P();
            }
        }
    }

    public static class i extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SoftReference<b> f26116a;

        public i(b bVar) {
            this.f26116a = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(@m0 Message message) {
            super.handleMessage(message);
            if (this.f26116a.get() == null || message.what != 1 || this.f26116a.get().L == null) {
                return;
            }
            this.f26116a.get().L.setTop(n0.g(this.f26116a.get().f26090m));
        }
    }

    class j implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<ProfileAvatarImageBeen>> {

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f26118a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BaseData f26119b;

            a(String str, BaseData baseData) {
                this.f26118a = str;
                this.f26119b = baseData;
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseData baseData) {
                if ("00000".equals(baseData.getRetCode())) {
                    b.this.O("T".equals(this.f26118a));
                    ProfileAvatarImageBeen.getInstance().setIsReceiveMessage(((ProfileAvatarImageBeen) this.f26119b.getData()).getIsReceiveMessage());
                }
            }
        }

        j() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<ProfileAvatarImageBeen> baseData) {
            if (baseData != null) {
                String retCode = baseData.getRetCode();
                retCode.hashCode();
                if (!retCode.equals("00000")) {
                    if (retCode.equals("10017")) {
                        b.this.f26090m.m0(0);
                    }
                    b bVar = b.this;
                    if (bVar.f26089J == null || bVar.K == null) {
                        return;
                    }
                    if (ProfileAvatarImageBeen.getInstance().getAvatar() == null || "".equals(ProfileAvatarImageBeen.getInstance().getAvatar())) {
                        b.this.f26089J.setImageResource(R.drawable.icon_touxiang_wode);
                    } else {
                        l.O(b.this.f26090m).E(ProfileAvatarImageBeen.getInstance().getAvatar()).c0(new com.haier.globalwasher.modle.utils.l(b.this.f26090m)).E(b.this.f26089J);
                    }
                    if (ProfileAvatarImageBeen.getInstance().getUserName() == null || "".equals(ProfileAvatarImageBeen.getInstance().getUserName())) {
                        b.this.K.setText("");
                        return;
                    } else {
                        b.this.K.setText(ProfileAvatarImageBeen.getInstance().getUserName());
                        return;
                    }
                }
                if (baseData.getData() != null) {
                    ProfileAvatarImageBeen.getInstance().setAvatar(baseData.getData().getAvatar());
                    ProfileAvatarImageBeen.getInstance().setHotLine(baseData.getData().getHotLine());
                    ProfileAvatarImageBeen.getInstance().setPhoneNumber(baseData.getData().getPhoneNumber());
                    ProfileAvatarImageBeen.getInstance().setIsReceiveMessage(baseData.getData().getIsReceiveMessage());
                    ProfileAvatarImageBeen.getInstance().setUserId(baseData.getData().getUserId());
                    ProfileAvatarImageBeen.getInstance().setUserName(baseData.getData().getUserName());
                    ProfileAvatarImageBeen.getInstance().setHavepwd(baseData.getData().isHavepwd());
                    ProfileAvatarImageBeen.getInstance().setEmail(baseData.getData().getEmail());
                    ProfileAvatarImageBeen.getInstance().setDesensitizationMailNumber(baseData.getData().getDesensitizationMailNumber());
                    String strA = t2.a.a(b.this.f26090m, t2.a.f40362i, t2.a.f40366m);
                    if (!d0.j(strA)) {
                        strA = "T";
                    }
                    if (!strA.equals(baseData.getData().getIsReceiveMessage())) {
                        b.this.f26091n.g(strA + "", new a(strA, baseData));
                    }
                    b bVar2 = b.this;
                    if (bVar2.f26089J == null || bVar2.K == null) {
                        return;
                    }
                    if (ProfileAvatarImageBeen.getInstance().getAvatar() == null || "".equals(ProfileAvatarImageBeen.getInstance().getAvatar())) {
                        b.this.f26089J.setImageResource(R.drawable.icon_touxiang_wode);
                    } else {
                        l.O(b.this.f26090m).E(ProfileAvatarImageBeen.getInstance().getAvatar()).c0(new com.haier.globalwasher.modle.utils.l(b.this.f26090m)).E(b.this.f26089J);
                    }
                    if (ProfileAvatarImageBeen.getInstance().getUserName() == null || "".equals(ProfileAvatarImageBeen.getInstance().getUserName())) {
                        b.this.K.setText("");
                    } else {
                        b.this.K.setText(ProfileAvatarImageBeen.getInstance().getUserName());
                    }
                }
            }
        }
    }

    public void I(boolean z7) {
        z.f(this.f26090m, "", "切换网络环境需要重新启动App", "不重启", "重启", null, new h(z7));
    }

    public View J(MainActivity mainActivity) {
        View view = this.H;
        if (view == null) {
            if (this.f26090m == null) {
                this.f26090m = mainActivity;
            }
            View viewInflate = View.inflate(mainActivity, R.layout.fragment_my_top, null);
            this.H = viewInflate;
            this.I = (TextView) viewInflate.findViewById(R.id.tv_profile);
            this.L = (LinearLayout) this.H.findViewById(R.id.lly_top);
            this.H.post(new c());
            this.K = (TextView) this.H.findViewById(R.id.tv_user_name);
            this.f26089J = (ImageView) this.H.findViewById(R.id.iv_face_fragment_my);
            ImageView imageView = (ImageView) this.H.findViewById(R.id.iv_setting);
            ImageView imageView2 = (ImageView) this.H.findViewById(R.id.iv_message);
            imageView.setOnClickListener(new d(mainActivity));
            imageView2.setOnClickListener(new e(mainActivity));
            mainActivity.addViewInToolbarBottom(this.H);
            if (ProfileAvatarImageBeen.getInstance().getAvatar() == null || "".equals(ProfileAvatarImageBeen.getInstance().getAvatar())) {
                this.f26089J.setImageResource(R.drawable.icon_touxiang_wode);
            } else {
                l.O(mainActivity).E(ProfileAvatarImageBeen.getInstance().getAvatar()).c0(new com.haier.globalwasher.modle.utils.l(mainActivity)).E(this.f26089J);
            }
            if (ProfileAvatarImageBeen.getInstance().getUserName() == null || "".equals(ProfileAvatarImageBeen.getInstance().getUserName())) {
                this.K.setText("");
            } else {
                this.K.setText(ProfileAvatarImageBeen.getInstance().getUserName());
            }
            this.f26089J.setOnClickListener(this);
            this.I.setOnClickListener(this);
        } else {
            mainActivity.addViewInToolbarBottom(view);
        }
        return this.H;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, MyFragmentListBeen myFragmentListBeen) {
        bVar.b(R.id.tv_content, R.id.iv_more, R.id.iv_left_img);
        this.f26092o = (TextView) bVar.a(R.id.tv_content);
        this.f26093p = (ImageView) bVar.a(R.id.iv_more);
        this.f26094q = (ImageView) bVar.a(R.id.iv_left_img);
        this.f26092o.setText(myFragmentListBeen.getContent() + "");
        if (myFragmentListBeen.getDrawablrId() > 0) {
            Drawable drawable = getResources().getDrawable(myFragmentListBeen.getDrawablrId());
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f26094q.setImageDrawable(drawable);
        } else if (d0.j(myFragmentListBeen.getPicUrl())) {
            this.f26094q.setTag(myFragmentListBeen.getPicUrl());
            q.c("tvContent", "data.getPicUrl()=" + myFragmentListBeen.getPicUrl());
            l.O(this.f26090m).E(myFragmentListBeen.getPicUrl()).L0().F(new f(myFragmentListBeen));
        }
        if (i7 == 4) {
            this.f26093p.setVisibility(8);
        } else {
            this.f26093p.setVisibility(0);
        }
        try {
            if (MyApplication.f24258n) {
                if (myFragmentListBeen.getCode() == 8) {
                    this.f26092o.setTextColor(getResources().getColor(R.color.app_blue, null));
                    return;
                } else {
                    this.f26092o.setTextColor(getResources().getColor(R.color.my_item_content, null));
                    return;
                }
            }
            if (myFragmentListBeen.getCode() == 9) {
                this.f26092o.setTextColor(getResources().getColor(R.color.app_blue, null));
            } else {
                this.f26092o.setTextColor(getResources().getColor(R.color.my_item_content, null));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this.f26090m, View.inflate(this.f26090m, R.layout.fragment_my_item, null), 1);
    }

    public void M(int i7) {
        String strA = t2.a.a(this.f26090m, t2.a.f40354a, t2.a.f40355b);
        switch (this.f26096s.get(i7).getCode()) {
            case 1:
                if (TextUtils.isEmpty(strA)) {
                    this.f26091n.n(this.f26090m);
                    return;
                } else {
                    this.f26091n.m(1, this.f26090m);
                    return;
                }
            case 2:
            case 7:
            default:
                return;
            case 3:
                if (TextUtils.isEmpty(strA)) {
                    this.f26091n.n(this.f26090m);
                    return;
                } else {
                    this.f26091n.m(3, this.f26090m);
                    return;
                }
            case 4:
                if (TextUtils.isEmpty(strA)) {
                    this.f26091n.n(this.f26090m);
                    return;
                }
                if (ProfileAvatarImageBeen.getInstance().getHotLine() == null) {
                    MainActivity mainActivity = this.f26090m;
                    i0.d(mainActivity, mainActivity.getResources().getString(R.string.no_service_call));
                    return;
                }
                h0.a(this.f26090m, ProfileAvatarImageBeen.getInstance().getHotLine() + "");
                return;
            case 5:
                this.f26091n.d(this.f26090m, "zh");
                return;
            case 6:
                this.f26091n.d(this.f26090m, "en");
                return;
            case 8:
                I(true);
                return;
            case 9:
                I(false);
                return;
            case 10:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "测试");
                intent.setType("text/plain");
                intent.addFlags(268435456);
                intent.setPackage("com.facebook.orca");
                startActivity(intent);
                break;
            case 11:
                break;
        }
        if (this.f26096s.get(i7) == null || this.f26096s.get(i7).getUrl() == null) {
            return;
        }
        String url = this.f26096s.get(i7).getUrl();
        if (!this.f26096s.get(i7).getUrl().toLowerCase().startsWith(com.haier.uhome.usdk.base.a.av)) {
            url = "https://" + url;
        }
        WebActivity.j0(this.f26090m, "", url);
    }

    public void N() {
        com.haier.globalwasher.presenter.c cVar;
        j jVar = this.G;
        if (jVar == null || (cVar = this.f26091n) == null) {
            return;
        }
        cVar.f(jVar);
    }

    public void O(boolean z7) {
    }

    public void P() {
        ProfileAvatarImageBeen.getInstance().initRegisterBeen();
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40355b, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40356c, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40357d, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40359f, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40358e, "");
        PendingIntent activity = PendingIntent.getActivity(MyApplication.k(), 0, this.f26090m.getPackageManager().getLaunchIntentForPackage(this.f26090m.getPackageName()), 1073741824);
        AlarmManager alarmManager = (AlarmManager) this.f26090m.getSystemService(l2.f5220v0);
        long jCurrentTimeMillis = System.currentTimeMillis() + com.haier.uhome.ble.hal.a.b.a.f28246a;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(jCurrentTimeMillis, null), activity);
            } else {
                alarmManager.setExact(0, jCurrentTimeMillis, activity);
            }
        }
        new g().start();
    }

    public void Q() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", "这是一段分享的文字");
        startActivity(Intent.createChooser(intent, "分享"));
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f26096s.clear();
        this.f26096s.add(new MyFragmentListBeen(this.f26097t.getString(R.string.my_page_coupon), R.drawable.icon_youhuiquan_wode, 1));
        this.f26096s.add(new MyFragmentListBeen(this.f26097t.getString(R.string.my_page_help), R.drawable.icon_bangzhu_wode, 3));
        this.f26096s.add(new MyFragmentListBeen(this.f26097t.getString(R.string.my_page_platform), R.drawable.icon_kefudianhua_wode, 4));
        if (MyApplication.f24259o) {
            this.f26096s.add(new MyFragmentListBeen("切换中文", R.drawable.icon_kefudianhua_wode, 5));
            this.f26096s.add(new MyFragmentListBeen("切换英文", R.drawable.icon_kefudianhua_wode, 6));
            this.f26096s.add(new MyFragmentListBeen("线上环境", R.drawable.icon_kefudianhua_wode, 8));
            this.f26096s.add(new MyFragmentListBeen("测试环境", R.drawable.icon_kefudianhua_wode, 9));
            this.f26096s.add(new MyFragmentListBeen("测试网页", R.drawable.icon_kefudianhua_wode, 11));
        }
        com.haier.globalwasher.mvp_api.adapter.a<MyFragmentListBeen, com.haier.globalwasher.mvp_api.adapter.b> aVar = new com.haier.globalwasher.mvp_api.adapter.a<>(this.f26090m, this.f26096s, this);
        this.f26095r = aVar;
        this.f26098u.setAdapter((ListAdapter) aVar);
        this.f26098u.setOnItemClickListener(new a());
        this.f26091n.h(new C0344b());
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.fragment_my;
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        XListView xListView = (XListView) findViewById(R.id.lv_my);
        this.f26098u = xListView;
        xListView.setBackground(null);
        this.f26098u.setPullLoadEnable(false);
        this.f26098u.setPullRefreshEnable(false);
        this.G = new j();
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        MainActivity mainActivity = (MainActivity) getActivity();
        this.f26090m = mainActivity;
        this.f26097t = mainActivity.getResources();
        if (this.f26091n == null) {
            this.f26091n = (com.haier.globalwasher.presenter.c) this.f26090m.f();
        }
        return this.f26091n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_profile && id == R.id.iv_face_fragment_my) {
            if (TextUtils.isEmpty(t2.a.a(this.f26090m, t2.a.f40354a, t2.a.f40355b))) {
                this.f26091n.n(this.f26090m);
            } else {
                this.f26090m.startActivity(new Intent(this.f26090m, (Class<?>) ProfileActivity.class));
            }
        }
    }

    @Override // com.haier.globalwasher.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f26090m.t0() == 2) {
            N();
        }
    }
}
