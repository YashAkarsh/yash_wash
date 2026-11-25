package com.haier.library.okhttp.b.l;

import com.haier.library.okhttp.n;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f27402a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f27403b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f27404c = 7;

    private e() {
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> listB = b(x509Certificate, 7);
        List<String> listB2 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listB.size() + listB2.size());
        arrayList.addAll(listB);
        arrayList.addAll(listB2);
        return arrayList;
    }

    private static List<String> b(X509Certificate x509Certificate, int i7) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i7 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean e(String str, X509Certificate x509Certificate) {
        List<String> listB = b(x509Certificate, 7);
        int size = listB.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (str.equalsIgnoreCase(listB.get(i7))) {
                return true;
            }
        }
        return false;
    }

    private boolean f(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = b(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (c(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(com.alibaba.android.arouter.utils.b.f12515h) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(com.alibaba.android.arouter.utils.b.f12515h) && !str2.endsWith("..")) {
            if (!str.endsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
                str = str + ClassUtils.PACKAGE_SEPARATOR_CHAR;
            }
            if (!str2.endsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
                str2 = str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR;
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    public boolean d(String str, X509Certificate x509Certificate) {
        return n.d.I(str) ? e(str, x509Certificate) : f(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return d(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
