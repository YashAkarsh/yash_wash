package com.google.thirdparty.publicsuffix;

import com.google.common.base.w;
import com.google.common.collect.ib;
import com.google.common.collect.v7;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final w f23322a = w.p("");

    c() {
    }

    private static int a(List<CharSequence> list, CharSequence charSequence, int i7, v7.b<String, b> bVar) {
        int length = charSequence.length();
        int i8 = i7;
        char cCharAt = 0;
        while (i8 < length && (cCharAt = charSequence.charAt(i8)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i8++;
        }
        list.add(0, c(charSequence.subSequence(i7, i8)));
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strK = f23322a.k(list);
            if (strK.length() > 0) {
                bVar.f(strK, b.a(cCharAt));
            }
        }
        int iA = i8 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(list, charSequence, iA, bVar);
                if (charSequence.charAt(iA) == '?' || charSequence.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        list.remove(0);
        return iA - i7;
    }

    static v7<String, b> b(CharSequence charSequence) {
        v7.b bVarB = v7.b();
        int length = charSequence.length();
        int iA = 0;
        while (iA < length) {
            iA += a(ib.y(), charSequence, iA, bVarB);
        }
        return bVarB.a();
    }

    private static CharSequence c(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
