package u5;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.g0;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.text.b0;
import kotlin.text.c0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f40418a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f40419b = 7;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f40420c = new d();

    private d() {
    }

    private final List<String> b(X509Certificate x509Certificate, int i7) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return y.F();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!l0.g(list.get(0), Integer.valueOf(i7))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return y.F();
        }
    }

    private final boolean d(String str, String str2) {
        if (!(str == null || str.length() == 0) && !b0.u2(str, com.alibaba.android.arouter.utils.b.f12515h, false, 2, null) && !b0.J1(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !b0.u2(str2, com.alibaba.android.arouter.utils.b.f12515h, false, 2, null) && !b0.J1(str2, "..", false, 2, null)) {
                if (!b0.J1(str, com.alibaba.android.arouter.utils.b.f12515h, false, 2, null)) {
                    str = str + com.alibaba.android.arouter.utils.b.f12515h;
                }
                String str3 = str;
                if (!b0.J1(str2, com.alibaba.android.arouter.utils.b.f12515h, false, 2, null)) {
                    str2 = str2 + com.alibaba.android.arouter.utils.b.f12515h;
                }
                Locale locale = Locale.US;
                l0.o(locale, "Locale.US");
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!c0.V2(lowerCase, "*", false, 2, null)) {
                    return l0.g(str3, lowerCase);
                }
                if (!b0.u2(lowerCase, "*.", false, 2, null) || c0.q3(lowerCase, '*', 1, false, 4, null) != -1 || str3.length() < lowerCase.length() || l0.g("*.", lowerCase)) {
                    return false;
                }
                String strSubstring = lowerCase.substring(1);
                l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
                if (!b0.J1(str3, strSubstring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - strSubstring.length();
                return length <= 0 || c0.E3(str3, ClassUtils.PACKAGE_SEPARATOR_CHAR, length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }

    private final boolean e(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        l0.o(locale, "Locale.US");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> listB = b(x509Certificate, 2);
        if ((listB instanceof Collection) && listB.isEmpty()) {
            return false;
        }
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            if (f40420c.d(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(String str, X509Certificate x509Certificate) {
        String strE = okhttp3.internal.a.e(str);
        List<String> listB = b(x509Certificate, 7);
        if ((listB instanceof Collection) && listB.isEmpty()) {
            return false;
        }
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            if (l0.g(strE, okhttp3.internal.a.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public final List<String> a(@a7.d X509Certificate certificate) {
        l0.p(certificate, "certificate");
        return g0.y4(b(certificate, 7), b(certificate, 2));
    }

    public final boolean c(@a7.d String host, @a7.d X509Certificate certificate) {
        l0.p(host, "host");
        l0.p(certificate, "certificate");
        return okhttp3.internal.d.h(host) ? f(host, certificate) : e(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@a7.d String host, @a7.d SSLSession session) {
        l0.p(host, "host");
        l0.p(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return c(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
