package com.haier.globalwasher.modle.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f24378i = "d";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f24379j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f24381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Camera f24382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f24383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f24385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24386g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f24387h;

    public d(Context context) {
        this.f24380a = context;
        c cVar = new c(context);
        this.f24381b = cVar;
        this.f24387h = new e(cVar);
    }

    public synchronized void a() {
        Camera camera = this.f24382c;
        if (camera != null) {
            camera.release();
            this.f24382c = null;
        }
    }

    public void b() {
        try {
            if (this.f24382c == null || !this.f24380a.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                return;
            }
            Camera.Parameters parameters = this.f24382c.getParameters();
            parameters.setFlashMode(z0.f37391e);
            this.f24382c.setParameters(parameters);
            f24379j = false;
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void c() {
        try {
            if (this.f24382c == null || !this.f24380a.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                return;
            }
            Camera.Parameters parameters = this.f24382c.getParameters();
            parameters.setFlashMode("torch");
            this.f24382c.setParameters(parameters);
            f24379j = true;
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public Camera d() {
        return this.f24382c;
    }

    public Point e() {
        return this.f24381b.b();
    }

    public Camera.Size f() {
        Camera camera = this.f24382c;
        if (camera != null) {
            return camera.getParameters().getPreviewSize();
        }
        return null;
    }

    public synchronized boolean g() {
        return this.f24382c != null;
    }

    public synchronized void h(SurfaceHolder surfaceHolder) throws IOException {
        Camera cameraB = this.f24382c;
        if (cameraB == null) {
            int i7 = this.f24386g;
            cameraB = i7 >= 0 ? h2.a.b(i7) : h2.a.a();
            if (cameraB == null) {
                throw new IOException();
            }
            this.f24382c = cameraB;
        }
        cameraB.setPreviewDisplay(surfaceHolder);
        if (!this.f24384e) {
            this.f24384e = true;
            this.f24381b.e(cameraB);
        }
        Camera.Parameters parameters = cameraB.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.f24381b.f(cameraB, false);
        } catch (RuntimeException unused) {
            String str = f24378i;
            Log.w(str, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(str, "Resetting to saved camera params: " + strFlatten);
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraB.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraB.setParameters(parameters2);
                    this.f24381b.f(cameraB, true);
                } catch (RuntimeException unused2) {
                    Log.w(f24378i, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized void i(Handler handler, int i7) {
        Camera camera = this.f24382c;
        if (camera != null && this.f24385f) {
            this.f24387h.a(handler, i7);
            camera.setOneShotPreviewCallback(this.f24387h);
        }
    }

    public synchronized void j(int i7) {
        this.f24386g = i7;
    }

    public synchronized void k() {
        Camera camera = this.f24382c;
        if (camera != null && !this.f24385f) {
            camera.startPreview();
            this.f24385f = true;
            this.f24383d = new b(this.f24380a, this.f24382c);
        }
    }

    public synchronized void l() {
        b bVar = this.f24383d;
        if (bVar != null) {
            bVar.d();
            this.f24383d = null;
        }
        Camera camera = this.f24382c;
        if (camera != null && this.f24385f) {
            camera.stopPreview();
            this.f24387h.a(null, 0);
            this.f24385f = false;
        }
    }
}
