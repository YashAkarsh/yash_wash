package com.google.zxing.client.result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f23493f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public m k(com.google.zxing.r rVar) {
        Matcher matcher = f23493f.matcher(u.c(rVar));
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        try {
            double d8 = Double.parseDouble(matcher.group(1));
            if (d8 <= 90.0d && d8 >= -90.0d) {
                double d9 = Double.parseDouble(matcher.group(2));
                if (d9 <= 180.0d && d9 >= -180.0d) {
                    double d10 = 0.0d;
                    if (matcher.group(3) != null) {
                        double d11 = Double.parseDouble(matcher.group(3));
                        if (d11 < 0.0d) {
                            return null;
                        }
                        d10 = d11;
                    }
                    return new m(d8, d9, d10, strGroup);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
