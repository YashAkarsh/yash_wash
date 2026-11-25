package com.haier.globalwasher.modle.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24371d = "CameraConfiguration";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24372e = 153600;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final double f24373f = 0.15d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Point f24375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Point f24376c;

    class a implements Comparator<Camera.Size> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i7 = size.height * size.width;
            int i8 = size2.height * size2.width;
            if (i8 < i7) {
                return -1;
            }
            return i8 > i7 ? 1 : 0;
        }
    }

    public c(Context context) {
        this.f24374a = context;
    }

    private Point a(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(f24371d, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new a());
        if (Log.isLoggable(f24371d, 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i(f24371d, "Supported preview sizes: " + ((Object) sb));
        }
        double d8 = ((double) point.x) / ((double) point.y);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (arrayList.isEmpty()) {
                    Camera.Size previewSize2 = parameters.getPreviewSize();
                    Point point2 = new Point(previewSize2.width, previewSize2.height);
                    Log.i(f24371d, "No suitable preview sizes, using default: " + point2);
                    return point2;
                }
                Camera.Size size2 = (Camera.Size) arrayList.get(0);
                Point point3 = new Point(size2.width, size2.height);
                Log.i(f24371d, "Using largest suitable preview size: " + point3);
                return point3;
            }
            Camera.Size size3 = (Camera.Size) it.next();
            int i7 = size3.width;
            int i8 = size3.height;
            if (i7 * i8 < f24372e) {
                it.remove();
            } else {
                boolean z7 = i7 < i8;
                int i9 = z7 ? i8 : i7;
                int i10 = z7 ? i7 : i8;
                if (Math.abs((((double) i9) / ((double) i10)) - d8) > f24373f) {
                    it.remove();
                } else if (i9 == point.x && i10 == point.y) {
                    Point point4 = new Point(i7, i8);
                    Log.i(f24371d, "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private Point c(Display display) {
        Point point = new Point();
        try {
            display.getSize(point);
        } catch (NoSuchMethodError unused) {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        return point;
    }

    public Point b() {
        return this.f24376c;
    }

    public Point d() {
        return this.f24375b;
    }

    public void e(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f24374a.getSystemService("window")).getDefaultDisplay();
        new Point();
        this.f24375b = c(defaultDisplay);
        Log.i(f24371d, "Screen resolution: " + this.f24375b);
        Point point = new Point();
        Point point2 = this.f24375b;
        point.x = point2.x;
        point.y = point2.y;
        int i7 = point2.x;
        int i8 = point2.y;
        if (i7 < i8) {
            point.x = i8;
            point.y = point2.x;
        }
        this.f24376c = a(parameters, point);
        Log.i(f24371d, "Camera resolution x: " + this.f24376c.x);
        Log.i(f24371d, "Camera resolution y: " + this.f24376c.y);
    }

    public void f(Camera camera, boolean z7) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(f24371d, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(f24371d, "Initial camera parameters: " + parameters.flatten());
        if (z7) {
            Log.w(f24371d, "In camera config safe mode -- most settings will not be honored");
        }
        Point point = this.f24376c;
        parameters.setPreviewSize(point.x, point.y);
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f24376c;
            if (point2.x != previewSize.width || point2.y != previewSize.height) {
                Log.w(f24371d, "Camera said it supported preview size " + this.f24376c.x + 'x' + this.f24376c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
                Point point3 = this.f24376c;
                point3.x = previewSize.width;
                point3.y = previewSize.height;
            }
        }
        camera.setDisplayOrientation(90);
    }
}
