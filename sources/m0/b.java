package m0;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.alipay.sdk.util.d;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f37460b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37461a;

    private b() {
    }

    public static b a() {
        if (f37460b == null) {
            f37460b = new b();
        }
        return f37460b;
    }

    public static boolean e() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i7 = 0; i7 < 10; i7++) {
            if (new File(strArr[i7]).exists()) {
                return true;
            }
        }
        return false;
    }

    public void b(Context context, c cVar) {
        this.f37461a = context.getApplicationContext();
    }

    public Context c() {
        return this.f37461a;
    }

    public c d() {
        return c.g();
    }

    public String f() {
        try {
            return UTDevice.getUtdid(this.f37461a);
        } catch (Throwable th) {
            d.d(th);
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13644o, com.alipay.sdk.app.statistic.c.f13650u, th);
            return "";
        }
    }
}
