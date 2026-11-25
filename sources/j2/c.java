package j2;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.e;
import com.haier.globalwasher.view.activity.CaptureActivity;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Thread {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f34258e = "barcode_bitmap";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34259f = 256;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34260g = 512;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34261h = 768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CaptureActivity f34262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<e, Object> f34263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f34264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CountDownLatch f34265d = new CountDownLatch(1);

    public c(CaptureActivity captureActivity, int i7) {
        this.f34262a = captureActivity;
        EnumMap enumMap = new EnumMap(e.class);
        this.f34263b = enumMap;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(EnumSet.of(com.google.zxing.a.AZTEC));
        arrayList.addAll(EnumSet.of(com.google.zxing.a.PDF_417));
        if (i7 == 256) {
            arrayList.addAll(a.a());
        } else if (i7 == 512) {
            arrayList.addAll(a.b());
        } else if (i7 == 768) {
            arrayList.addAll(a.a());
            arrayList.addAll(a.b());
        }
        enumMap.put(e.POSSIBLE_FORMATS, arrayList);
    }

    public Handler a() {
        try {
            this.f34265d.await();
        } catch (InterruptedException unused) {
        }
        return this.f34264c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f34264c = new b(this.f34262a, this.f34263b);
        this.f34265d.countDown();
        Looper.loop();
    }
}
