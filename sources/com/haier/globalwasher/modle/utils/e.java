package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.webkit.MimeTypeMap;
import c.t0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f24583c = "icon_my.jpg";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24584d = 160;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24585e = 161;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24586f = 127;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24587g = 128;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static e f24588h = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f24589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f24590b;

    public interface a {
        void b(Uri uri, int i7);

        void c();

        Activity d();

        void e(String str);
    }

    private e() {
    }

    private Intent b(Uri uri, Context context) {
        q.a("buildCropIntent", "'" + uri);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("outputX", 1080);
        intent.putExtra("outputY", 1080);
        intent.putExtra("return-data", false);
        if (Build.VERSION.SDK_INT >= 29) {
            File fileF = f();
            this.f24589a = fileF;
            Uri uriFromFile = Uri.fromFile(fileF);
            this.f24590b = uriFromFile;
            intent.putExtra("output", uriFromFile);
        } else {
            Uri uri2 = Uri.parse("file:///" + Environment.getExternalStorageDirectory().getPath() + "/bgpicture_upload.jpg");
            this.f24590b = uri2;
            intent.putExtra("output", uri2);
        }
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", false);
        return intent;
    }

    public static e d() {
        return f24588h;
    }

    public static String e(Intent intent) throws Throwable {
        Uri data = intent.getData();
        FileOutputStream fileOutputStream = null;
        Bitmap bitmapDecodeFile = data != null ? BitmapFactory.decodeFile(data.getPath()) : null;
        if (bitmapDecodeFile == null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return "";
            }
            bitmapDecodeFile = (Bitmap) extras.get("data");
        }
        try {
            try {
                String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/washer_photos";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(str, "MT" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmapDecodeFile.compress(Bitmap.CompressFormat.WEBP, 100, fileOutputStream2);
                    String str2 = "file:///" + file2.getPath();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                    return str2;
                } catch (Exception e9) {
                    fileOutputStream = fileOutputStream2;
                    e = e9;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private File f() {
        File file = null;
        try {
            File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/" + (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())) + ".jpg"));
            try {
                file2.createNewFile();
                return file2;
            } catch (Exception e8) {
                e = e8;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    @t0(api = 29)
    public static File h(Uri uri, Context context) {
        q.a("setPhotoImage", "uriToFileApiQ====" + uri);
        File file = null;
        if (uri == null) {
            return null;
        }
        if (uri.getScheme().equals("file")) {
            return new File(uri.getPath());
        }
        if (!uri.getScheme().equals("content")) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String str = (System.currentTimeMillis() + Math.round((Math.random() + 1.0d) * 1000.0d)) + com.alibaba.android.arouter.utils.b.f12515h + MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver.getType(uri));
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            File file2 = new File(context.getExternalCacheDir().getAbsolutePath(), str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileUtils.copy(inputStreamOpenInputStream, fileOutputStream);
            try {
                fileOutputStream.close();
                inputStreamOpenInputStream.close();
                return file2;
            } catch (IOException e8) {
                e = e8;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (IOException e9) {
            e = e9;
        }
    }

    public Intent a() {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(2);
        return intent;
    }

    public Intent c() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        return intent;
    }

    public void g(a aVar, int i7, int i8, Intent intent) {
        q.c("BaseActivity", "test--sethandleResultListerner-" + aVar);
        if (aVar == null) {
            return;
        }
        if (i8 == 0) {
            aVar.c();
            return;
        }
        if (i8 == -1) {
            q.c("BaseActivity", "test--sethandleResultListerner-resultCode=-1");
            q.c("BaseActivity", "test--sethandleResultListerner-requestCode=" + i7);
            if (i7 == 127) {
                q.c("BaseActivity", "test--sethandleResultListerner-222");
                try {
                    aVar.b(this.f24590b, i7);
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            }
            if (i7 == 128) {
                try {
                    q.c("BaseActivity", "test--sethandleResultListerner-111");
                    aVar.b(this.f24590b, i7);
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            }
            if (i7 != 160) {
                if (i7 != 161) {
                    return;
                }
                q.c("BaseActivity", "test--sethandleResultListerner-333===");
                if (aVar.d() == null) {
                    aVar.e("CropHandler's context MUST NOT be null!");
                    return;
                } else {
                    aVar.d().startActivityForResult(b(Uri.parse(e(intent)), aVar.d()), 128);
                    return;
                }
            }
            q.c("BaseActivity", "test--sethandleResultListerner-444");
            if (intent == null) {
                aVar.e("Data MUST NOT be null!");
                return;
            }
            Intent intentB = b(intent.getData(), aVar.d());
            if (aVar.d() != null) {
                aVar.d().startActivityForResult(intentB, 127);
            } else {
                aVar.e("CropHandler's context MUST NOT be null!");
            }
        }
    }
}
