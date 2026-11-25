package h2;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f34041a = "h2.a";

    public static Camera a() {
        return b(-1);
    }

    public static Camera b(int i7) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f34041a, "No cameras!");
            return null;
        }
        boolean z7 = i7 >= 0;
        if (!z7) {
            i7 = 0;
            while (i7 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i7, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i7++;
            }
        }
        if (i7 < numberOfCameras) {
            Log.i(f34041a, "Opening camera #" + i7);
            return Camera.open(i7);
        }
        if (!z7) {
            Log.i(f34041a, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
        Log.w(f34041a, "Requested camera does not exist: " + i7);
        return null;
    }
}
