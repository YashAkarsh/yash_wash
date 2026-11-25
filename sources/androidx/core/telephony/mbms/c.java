package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import c.m0;
import c.o0;
import c.t0;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    @t0(28)
    static class a {
        private a() {
        }

        static CharSequence a(Context context, ServiceInfo serviceInfo) {
            Set namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            Iterator it = serviceInfo.getNamedContentLocales().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                strArr[i7] = ((Locale) it.next()).toLanguageTag();
                i7++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
    }

    private c() {
    }

    @o0
    public static CharSequence a(@m0 Context context, @m0 ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(context, serviceInfo);
        }
        return null;
    }
}
