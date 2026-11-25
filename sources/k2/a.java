package k2;

import com.google.gson.f;
import com.haier.globalwasher.modle.deviceinfo.PhoneInfoBean;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a() {
        return "(Android:" + b() + ")";
    }

    private static String b() {
        return new f().z(new PhoneInfoBean());
    }
}
