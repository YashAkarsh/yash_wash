package com.google.common.xml;

import com.google.common.escape.f;
import com.google.common.escape.g;
import kotlin.text.h0;
import okio.r0;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char f22946a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f22947b = 31;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f22948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f22949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f22950e;

    static {
        g.c cVarB = g.b();
        cVarB.d((char) 0, r0.f38529b);
        cVarB.e("�");
        for (char c8 = 0; c8 <= 31; c8 = (char) (c8 + 1)) {
            if (c8 != '\t' && c8 != '\n' && c8 != '\r') {
                cVarB.b(c8, "�");
            }
        }
        cVarB.b(h0.f35378d, "&amp;");
        cVarB.b(h0.f35379e, "&lt;");
        cVarB.b(h0.f35380f, "&gt;");
        f22949d = cVarB.c();
        cVarB.b('\'', "&apos;");
        cVarB.b(h0.f35376b, "&quot;");
        f22948c = cVarB.c();
        cVarB.b('\t', "&#x9;");
        cVarB.b('\n', "&#xA;");
        cVarB.b(CharUtils.CR, "&#xD;");
        f22950e = cVarB.c();
    }

    private a() {
    }

    public static f a() {
        return f22950e;
    }

    public static f b() {
        return f22949d;
    }
}
