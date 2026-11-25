package com.haier.globalwasher.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import c.m0;
import c.t0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.zxing.c;
import com.google.zxing.common.j;
import com.google.zxing.common.l;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.k;
import com.google.zxing.m;
import com.google.zxing.r;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.AnalysisURLBeen;
import com.haier.globalwasher.modle.bean.DeviceDetailBeen;
import com.haier.globalwasher.modle.camera.d;
import com.haier.globalwasher.modle.utils.g;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.o;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.view.activity.device.DeviceBaseActivity;
import com.haier.globalwasher.view.activity.device.DryerDetaileActivity;
import com.haier.globalwasher.view.activity.device.WasherDeviceDetaileActivity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Hashtable;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback {
    private static final String Q = "CaptureActivity";
    private static final int R = 1001;
    private static final int S = 1002;
    private ImageView A;
    private Intent B;
    private g D;
    private d F;
    private o G;
    private com.haier.globalwasher.modle.utils.b H;
    private ObjectAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Toolbar f25414J;
    com.haier.globalwasher.presenter.a K;
    private Resources M;
    private String N;
    private b O;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Context f25415u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Activity f25416v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private RelativeLayout f25418x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RelativeLayout f25419y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f25420z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private SurfaceView f25417w = null;
    private boolean C = false;
    private Rect E = null;
    private boolean L = true;
    private boolean P = false;

    class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<AnalysisURLBeen>> {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.activity.CaptureActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0333a implements View.OnClickListener {
            ViewOnClickListenerC0333a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaptureActivity.this.finish();
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaptureActivity.this.finish();
            }
        }

        a() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<AnalysisURLBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(CaptureActivity.this, baseData.getRetInfo());
                return;
            }
            if (!baseData.getData().getType().equals("1")) {
                CaptureActivity captureActivity = CaptureActivity.this;
                z.b(captureActivity, 1, 2, 2, captureActivity.M.getString(R.string.payment_start_title), CaptureActivity.this.M.getString(R.string.scan_qr_code_again), CaptureActivity.this.M.getString(R.string.reservations_are_not_available_back), new ViewOnClickListenerC0333a(), new b());
            } else {
                CaptureActivity.this.N = baseData.getData().getDeviceRQ();
                CaptureActivity.this.K.c(baseData.getData().getDeviceRQ(), CaptureActivity.this.O);
            }
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<DeviceDetailBeen>> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<DeviceDetailBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                return;
            }
            if (baseData.getData().getType().charAt(0) == '1' || baseData.getData().getType().charAt(0) == '2') {
                CaptureActivity captureActivity = CaptureActivity.this;
                DeviceBaseActivity.O0(captureActivity, WasherDeviceDetaileActivity.class, null, captureActivity.N);
                CaptureActivity.this.finish();
            } else {
                CaptureActivity captureActivity2 = CaptureActivity.this;
                DeviceBaseActivity.O0(captureActivity2, DryerDetaileActivity.class, null, captureActivity2.N);
                CaptureActivity.this.finish();
            }
        }
    }

    private void A0(String str) {
        this.K.b(str, new a());
    }

    @t0(api = 19)
    private void C0() {
        g gVar = this.D;
        if (gVar != null) {
            gVar.a();
            this.D = null;
        }
        this.G.f();
        this.H.close();
        this.F.a();
        if (!this.P) {
            this.f25417w.getHolder().removeCallback(this);
        }
        this.I.pause();
        this.C = true;
    }

    private String D0(String str) {
        try {
            return Charset.forName(CharEncoding.ISO_8859_1).newEncoder().canEncode(str) ? new String(str.getBytes(CharEncoding.ISO_8859_1), l.f23594c) : str;
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            return "";
        }
    }

    @t0(api = 19)
    private void F0() {
        this.G = new o(this);
        this.H = new com.haier.globalwasher.modle.utils.b(this);
        if (this.C) {
            this.I.resume();
            this.C = false;
        } else {
            this.I.start();
        }
        this.F = new d(getApplication());
        this.D = null;
        if (this.P) {
            u0(this.f25417w.getHolder());
        } else {
            this.f25417w.getHolder().addCallback(this);
        }
        this.G.g();
    }

    public static float k0(Context context, float f8) {
        return (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static int l0(Context context, float f8) {
        return (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static String o0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void r0() {
        if (androidx.core.content.d.a(this.f25415u, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.b.G(this.f25416v, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        } else {
            B0();
        }
    }

    private int s0() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e8) {
            e8.printStackTrace();
            return 0;
        }
    }

    private void u0(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.F.g()) {
            Log.w(Q, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.F.h(surfaceHolder);
            if (this.D == null) {
                this.D = new g(this, this.F, 768);
            }
            v0();
        } catch (IOException e8) {
            Log.w(Q, e8);
        } catch (RuntimeException e9) {
            Log.w(Q, "Unexpected error initializing camera", e9);
        }
    }

    private void v0() {
        int i7 = this.F.e().y;
        int i8 = this.F.e().x;
        int[] iArr = new int[2];
        this.f25419y.getLocationInWindow(iArr);
        int i9 = iArr[0];
        int iS0 = iArr[1] - s0();
        int width = this.f25419y.getWidth();
        int height = this.f25419y.getHeight();
        int width2 = this.f25418x.getWidth();
        int height2 = this.f25418x.getHeight();
        int i10 = (i9 * i7) / width2;
        int i11 = (iS0 * i8) / height2;
        this.E = new Rect(i10, i11, ((width * i7) / width2) + i10, ((height * i8) / height2) + i11);
    }

    public static boolean w0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean x0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean y0(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean z0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public void B0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1001);
    }

    protected r E0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(e.CHARACTER_SET, "utf-8");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        int i7 = (int) (options.outHeight / 200.0f);
        if (i7 <= 0) {
            i7 = 1;
        }
        options.inSampleSize = i7;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int[] iArr = new int[bitmapDecodeFile.getWidth() * bitmapDecodeFile.getHeight()];
        bitmapDecodeFile.getPixels(iArr, 0, bitmapDecodeFile.getWidth(), 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight());
        try {
            return new k().a(new c(new j(new com.google.zxing.o(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), iArr))), hashtable);
        } catch (com.google.zxing.d e8) {
            e8.printStackTrace();
            return null;
        } catch (h e9) {
            e9.printStackTrace();
            return null;
        } catch (m e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f25420z, "translationY", this.f25420z.getTranslationY(), k0(this, 350.0f));
        this.I = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(3000L);
        this.I.setInterpolator(new LinearInterpolator());
        this.I.setRepeatCount(-1);
        this.I.setRepeatMode(1);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_capture;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.B = getIntent();
        this.f25415u = this;
        this.f25416v = this;
        d0(getResources().getString(R.string.scan_qr_code_title), 1, new View[0]);
        this.M = getResources();
        this.f25420z = (ImageView) findViewById(R.id.capture_scan_line);
        this.f25417w = (SurfaceView) findViewById(R.id.capture_preview);
        this.f25418x = (RelativeLayout) findViewById(R.id.capture_container);
        this.f25419y = (RelativeLayout) findViewById(R.id.capture_crop_view);
        this.A = (ImageView) S(R.id.capture_mask_lamp, true);
        this.O = new b();
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        com.haier.globalwasher.presenter.a aVar = new com.haier.globalwasher.presenter.a();
        this.K = aVar;
        return aVar;
    }

    public d m0() {
        return this.F;
    }

    public Rect n0() {
        return this.E;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (i7 == 1002 && i8 == -1) {
            r rVarE0 = E0(q0(this.f25415u, intent.getData()));
            if (rVarE0 == null) {
                Toast.makeText(this.f25415u, this.M.getString(R.string.scan_qr_code_found), 1).show();
            } else {
                q.a("barCode", "" + rVarE0.toString());
                Toast.makeText(this.f25415u, D0(rVarE0.toString()), 1).show();
            }
        }
        if (i7 == 1001 && i8 == -1) {
            r rVarE1 = E0(q0(this.f25415u, intent.getData()));
            if (rVarE1 == null) {
                Toast.makeText(this.f25415u, this.M.getString(R.string.scan_qr_code_found), 1).show();
            } else {
                Toast.makeText(this.f25415u, D0(rVarE1.toString()), 1).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.capture_mask_lamp) {
            try {
                if (this.L) {
                    this.A.setBackgroundResource(R.drawable.icon_shoudiantong_open);
                    this.L = false;
                    this.F.c();
                } else {
                    this.L = true;
                    this.A.setBackgroundResource(R.drawable.icon_shoudiantong_close);
                    this.F.b();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.G.h();
        ObjectAnimator objectAnimator = this.I;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        super.onDestroy();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        C0();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        if (i7 != 1) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            Toast.makeText(this.f25415u, "拒绝", 1).show();
        } else {
            B0();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        F0();
    }

    public Handler p0() {
        return this.D;
    }

    public String q0(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (x0(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else {
                if (w0(uri)) {
                    return o0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (z0(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if (MessengerShareContentUtility.MEDIA_IMAGE.equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return o0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return y0(uri) ? uri.getLastPathSegment() : o0(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i7, int i8, int i9) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(Q, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.P) {
            return;
        }
        this.P = true;
        u0(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.P = false;
    }

    public void t0(r rVar, Bundle bundle) {
        this.G.e();
        this.H.e();
        bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.E.width());
        bundle.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.E.height());
        bundle.putString(com.alipay.sdk.util.m.f13818c, rVar.g());
        A0(rVar.g());
    }
}
