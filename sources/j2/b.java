package j2;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.common.j;
import com.google.zxing.e;
import com.google.zxing.k;
import com.google.zxing.n;
import com.google.zxing.q;
import com.google.zxing.r;
import com.haier.globalwasher.R;
import com.haier.globalwasher.view.activity.CaptureActivity;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CaptureActivity f34255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f34256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34257c = true;

    public b(CaptureActivity captureActivity, Map<e, Object> map) {
        k kVar = new k();
        this.f34256b = kVar;
        kVar.e(map);
        this.f34255a = captureActivity;
    }

    private static void b(n nVar, Bundle bundle) {
        int[] iArrM = nVar.m();
        int iL = nVar.l();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrM, 0, iL, iL, nVar.k(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(c.f34258e, byteArrayOutputStream.toByteArray());
    }

    private void c(byte[] bArr, int i7, int i8) {
        int i9;
        r rVarD;
        Camera.Size sizeF = this.f34255a.m0().f();
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        while (true) {
            i9 = sizeF.height;
            if (i10 >= i9) {
                break;
            }
            int i11 = 0;
            while (true) {
                int i12 = sizeF.width;
                if (i11 < i12) {
                    int i13 = sizeF.height;
                    bArr2[(((i11 * i13) + i13) - i10) - 1] = bArr[(i12 * i10) + i11];
                    i11++;
                }
            }
            i10++;
        }
        int i14 = sizeF.width;
        sizeF.width = i9;
        sizeF.height = i14;
        n nVarA = a(bArr2, i9, i14);
        if (nVarA != null) {
            try {
                rVarD = this.f34256b.d(new com.google.zxing.c(new j(nVarA)));
                this.f34256b.reset();
            } catch (q unused) {
                this.f34256b.reset();
                rVarD = null;
            } catch (Throwable th) {
                this.f34256b.reset();
                throw th;
            }
        } else {
            rVarD = null;
        }
        Handler handlerP0 = this.f34255a.p0();
        if (rVarD == null) {
            if (handlerP0 != null) {
                Message.obtain(handlerP0, R.id.decode_failed).sendToTarget();
            }
        } else if (handlerP0 != null) {
            Message messageObtain = Message.obtain(handlerP0, R.id.decode_succeeded, rVarD);
            Bundle bundle = new Bundle();
            b(nVarA, bundle);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        }
    }

    public n a(byte[] bArr, int i7, int i8) {
        Rect rectN0 = this.f34255a.n0();
        if (rectN0 == null) {
            return null;
        }
        return new n(bArr, i7, i8, rectN0.left, rectN0.top, rectN0.width(), rectN0.height(), false);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f34257c) {
            int i7 = message.what;
            if (i7 == R.id.decode) {
                c((byte[]) message.obj, message.arg1, message.arg2);
            } else if (i7 == R.id.quit) {
                this.f34257c = false;
                Looper.myLooper().quit();
            }
        }
    }
}
