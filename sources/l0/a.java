package l0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37405a;

    a(String str) {
        this.f37405a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f37405a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
