package com.haier.globalwasher.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import c.t0;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.ProfilePageBeen;
import com.haier.globalwasher.modle.utils.f0;
import com.haier.globalwasher.modle.utils.m0;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p extends w2.a<BaseActivity> implements com.haier.globalwasher.modle.utils.e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f25261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f25262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f25263f = MessengerShareContentUtility.MEDIA_IMAGE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f25264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.gson.f f25265h;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.haier.globalwasher.presenter.p$a$a, reason: collision with other inner class name */
        class C0332a implements u4.c.a {
            C0332a() {
            }

            @Override // u4.c.a
            public void a(int i7) {
            }

            @Override // u4.c.a
            public void b(int i7) {
                p.this.f25260c.startActivityForResult(com.haier.globalwasher.modle.utils.e.d().a(), 161);
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u4.c.t(p.this.f25260c).o("android.permission.CAMERA").q(new C0332a());
        }
    }

    class b implements View.OnClickListener {

        class a implements u4.c.a {
            a() {
            }

            @Override // u4.c.a
            public void a(int i7) {
            }

            @Override // u4.c.a
            public void b(int i7) {
                p.this.f25260c.startActivityForResult(com.haier.globalwasher.modle.utils.e.d().c(), 160);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u4.c.t(p.this.f25260c).o("android.permission.CAMERA").q(new a());
        }
    }

    class c extends com.haier.globalwasher.modle.network.a {
        c() {
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void p(Object obj) {
        }
    }

    class d extends com.loopj.android.http.c {
        d() {
        }

        @Override // com.loopj.android.http.c
        public void C(int i7, Header[] headerArr, byte[] bArr) {
            BaseData baseDataFromJson;
            super.C(i7, headerArr, bArr);
            com.haier.globalwasher.modle.utils.q.a("RegistPost", "==================4==========" + i7);
            BaseData baseData = new BaseData();
            try {
                String str = new String(bArr, "UTF-8");
                p.this.f25265h = new com.google.gson.f();
                com.haier.globalwasher.modle.utils.q.a("RegistPost", "==================3==========");
                BaseBeen baseBeen = (BaseBeen) p.this.f25265h.n(str, BaseBeen.class);
                if (baseBeen.getRetSign() == null || "null".equals(baseBeen.getRetSign()) || "".equals(baseBeen.getRetSign())) {
                    baseDataFromJson = baseData.fromJson(str, ProfileAvatarImageBeen.class);
                } else {
                    String retData = baseBeen.getRetData();
                    if (m0.e(i2.a.f34108j, Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8")), Base64.decodeBase64(baseBeen.getRetSign().getBytes("UTF-8")))) {
                        String str2 = new String(m0.a(i2.a.f34111k.getBytes(), Base64.decodeBase64(baseBeen.getRetData().getBytes("UTF-8"))), "UTF-8");
                        str.replace(retData, str2);
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject jSONObject2 = new JSONObject(str);
                        jSONObject2.put("retData", jSONObject);
                        baseDataFromJson = baseData.fromJson(jSONObject2.toString(), ProfileAvatarImageBeen.class);
                    } else {
                        baseDataFromJson = null;
                    }
                }
                com.haier.globalwasher.modle.utils.q.a("setPhotoImage", "" + baseDataFromJson.toString());
                ProfileAvatarImageBeen.getInstance().setAvatar(((ProfileAvatarImageBeen) baseDataFromJson.getData()).getAvatarURL());
                com.bumptech.glide.l.O(p.this.f25260c).E(ProfileAvatarImageBeen.getInstance().getAvatar()).c0(new com.haier.globalwasher.modle.utils.l(p.this.f25260c)).E(p.this.f25262e);
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }

        @Override // com.loopj.android.http.c
        public void v(Throwable th, String str) {
            com.haier.globalwasher.modle.utils.q.a("onFailure", "" + th);
        }

        @Override // com.loopj.android.http.c
        public void x(int i7, int i8) {
            super.x(i7, i8);
            com.haier.globalwasher.modle.utils.q.a("onFailure", "" + i7 + "," + i8);
        }
    }

    class e implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f25272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f25273b;

        e(Class cls, Type[] typeArr) {
            this.f25272a = cls;
            this.f25273b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f25273b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f25272a;
        }
    }

    private ParameterizedType p(Class cls, Type... typeArr) {
        return new e(cls, typeArr);
    }

    @Override // com.haier.globalwasher.modle.utils.e.a
    @t0(api = 29)
    public void b(Uri uri, int i7) {
        if (i7 == 127 || i7 == 128) {
            com.haier.globalwasher.modle.utils.q.a("setPhotoImage", "onPhotoCroppedFile=====" + uri);
            n(uri);
        }
    }

    @Override // com.haier.globalwasher.modle.utils.e.a
    public void c() {
    }

    @Override // com.haier.globalwasher.modle.utils.e.a
    public Activity d() {
        return this.f25260c;
    }

    @Override // com.haier.globalwasher.modle.utils.e.a
    public void e(String str) {
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25260c = baseActivity;
        this.f25261d = baseActivity.getResources();
        return baseActivity;
    }

    public void k(File file) {
        String str;
        Exception e8;
        String str2;
        com.haier.globalwasher.modle.utils.q.a("RegistPost", "" + file);
        com.loopj.android.http.l lVar = new com.loopj.android.http.l();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e9) {
            e9.printStackTrace();
        }
        String str3 = simpleDateFormat.format(date);
        JSONObject jSONObject = new JSONObject();
        com.haier.globalwasher.modle.utils.q.a("RegistPost", "==================1==========");
        String str4 = "appId=hl7c87b100fc2143a&appSecret=759fcd66ad674c80a250753bd7fd5fcb&timestamp=" + str3;
        try {
            str2 = new String(Base64.encodeBase64(m0.c(str4.getBytes())), "UTF-8");
            try {
                byte[] bArrB = m0.b(new String(i2.a.f34108j.getBytes(), "UTF-8"), jSONObject.toString().getBytes("UTF-8"));
                String str5 = new String(Base64.encodeBase64(bArrB), "UTF-8");
                str = new String(Base64.encodeBase64(m0.d(new String(i2.a.f34111k.getBytes(), "UTF-8"), bArrB)), "UTF-8");
                try {
                    lVar.o("bizcontent", str5);
                } catch (Exception e10) {
                    e8 = e10;
                    str4 = str2;
                    e8.printStackTrace();
                    str2 = str4;
                }
            } catch (Exception e11) {
                str = "";
                e8 = e11;
            }
        } catch (Exception e12) {
            str = "";
            e8 = e12;
        }
        lVar.o("sign", str);
        lVar.o("nonce", str2);
        lVar.o("tokenId", t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b));
        lVar.o("timestamp", str3);
        lVar.o("appId", "hl7c87b100fc2143a");
        lVar.o("method", i2.a.C0);
        lVar.o("format", "JSON");
        lVar.o("charset", "UTF-8");
        lVar.o("version", i2.a.f34096f);
        lVar.o("country", Locale.getDefault().getCountry());
        lVar.o("language", Locale.getDefault().getLanguage());
        lVar.o("timeZone", f0.c());
        try {
            if (file.exists() && file.length() > 0) {
                com.haier.globalwasher.modle.utils.q.a("RegistPost", "==================1==========" + file.length());
            }
            lVar.i(MessengerShareContentUtility.MEDIA_IMAGE, file);
        } catch (FileNotFoundException e13) {
            e13.printStackTrace();
        }
        c cVar = new c();
        com.haier.globalwasher.modle.utils.q.a("RegistPost", "==================2==========");
        cVar.f(1, this.f25260c, i2.a.B0, lVar, new d());
    }

    public void l(ImageView imageView) {
        this.f25262e = imageView;
        z.e(this.f25260c, new a(), new b());
    }

    public void m(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<ProfilePageBeen>> bVar) {
        BaseListDate<ProfilePageBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<ProfilePageBeen> arrayList = new ArrayList<>();
        arrayList.add(new ProfilePageBeen(this.f25261d.getString(R.string.modified_data_image), "", 0));
        arrayList.add(new ProfilePageBeen(this.f25261d.getString(R.string.modified_data_name), ProfileAvatarImageBeen.getInstance().getUserName(), 1));
        arrayList.add(new ProfilePageBeen(this.f25261d.getString(R.string.modified_data_phone), ProfileAvatarImageBeen.getInstance().getPhoneNumber(), 2));
        arrayList.add(new ProfilePageBeen(this.f25261d.getString(R.string.modified_data_password), "", 3));
        arrayList.add(new ProfilePageBeen(this.f25261d.getString(R.string.modified_data_email), ProfileAvatarImageBeen.getInstance().getDesensitizationMailNumber(), 4));
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    @t0(api = 29)
    public void n(Uri uri) {
        com.haier.globalwasher.modle.utils.q.a("setPhotoImage", "setPhotoImage====" + uri);
        File fileH = com.haier.globalwasher.modle.utils.e.h(uri, this.f25260c);
        this.f25264g = fileH;
        k(fileH);
    }

    public void o(int i7, int i8, Intent intent) {
        com.haier.globalwasher.modle.utils.e.d().g(this, i7, i8, intent);
    }
}
