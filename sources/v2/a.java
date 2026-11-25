package v2;

import android.content.pm.PackageManager;
import com.haier.globalwasher.MyApplication;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a() {
        try {
            return MyApplication.k().getPackageManager().getPackageInfo(MyApplication.k().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return "";
        }
    }
}
