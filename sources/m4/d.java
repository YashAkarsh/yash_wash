package m4;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        return (Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale).getLanguage().endsWith("zh");
    }
}
