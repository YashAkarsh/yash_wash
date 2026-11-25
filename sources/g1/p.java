package g1;

import c.m0;
import com.google.android.gms.internal.common.i0;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f34016a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f34017b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f34018c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private p() {
    }

    @c1.a
    @m0
    public static Map<String, String> a(@m0 URI uri, @m0 String str) {
        Map<String, String> mapEmptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            mapEmptyMap = new HashMap<>();
            i0 i0VarC = i0.c(com.google.android.gms.internal.common.z.b('='));
            Iterator<String> it = i0.c(com.google.android.gms.internal.common.z.b(kotlin.text.h0.f35378d)).b().d(rawQuery).iterator();
            while (it.hasNext()) {
                List<String> listF = i0VarC.f(it.next());
                if (listF.isEmpty() || listF.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                mapEmptyMap.put(b(listF.get(0), str), listF.size() == 2 ? b(listF.get(1), str) : null);
            }
        }
        return mapEmptyMap;
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = CharEncoding.ISO_8859_1;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalArgumentException(e8);
        }
    }
}
