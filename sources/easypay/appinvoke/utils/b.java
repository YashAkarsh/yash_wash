package easypay.appinvoke.utils;

import android.text.TextUtils;
import easypay.appinvoke.manager.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(String str, Object obj) {
        if (Constants.DEV_MODE) {
            obj.getClass();
            e.a(Constants.ASSIST_LOG_CONSTANT, obj + ":" + str);
            try {
                if (TextUtils.isEmpty(str)) {
                    throw new f();
                }
            } catch (Exception e8) {
                e8.printStackTrace(new PrintWriter(new StringWriter()));
            }
        }
    }
}
