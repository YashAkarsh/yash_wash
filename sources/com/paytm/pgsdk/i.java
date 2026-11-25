package com.paytm.pgsdk;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f33057a;

    public i(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid orderId");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Invalid mid");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Invalid txnToken");
        }
        if (TextUtils.isEmpty(str5)) {
            throw new IllegalArgumentException("Invalid callbackurl");
        }
        HashMap<String, String> map = new HashMap<>();
        this.f33057a = map;
        map.put(d.f32998a, str);
        this.f33057a.put(d.f33000c, str4);
        this.f33057a.put("MID", str2);
        this.f33057a.put(d.f33007j, str3);
        this.f33057a.put(d.f33005h, str5);
    }

    HashMap<String, String> a() {
        return this.f33057a;
    }

    public i(HashMap<String, String> map) throws IllegalArgumentException {
        if (map != null && map.size() > 0) {
            if (map.containsKey(d.f33005h)) {
                if (map.containsKey(d.f33006i)) {
                    if (map.containsKey(d.f33001d)) {
                        if (map.containsKey(d.f33002e)) {
                            if (map.containsKey("MID")) {
                                if (map.containsKey(d.f32998a)) {
                                    if (map.containsKey(d.f33004g)) {
                                        if (map.containsKey(d.f33003f)) {
                                            if (map.containsKey(d.f33000c)) {
                                                this.f33057a = map;
                                                return;
                                            }
                                            throw new IllegalArgumentException("TXN_AMOUNT not present");
                                        }
                                        throw new IllegalArgumentException("CHANNEL_ID not present");
                                    }
                                    throw new IllegalArgumentException("WEBSITE not present");
                                }
                                throw new IllegalArgumentException("ORDER_ID not present");
                            }
                            throw new IllegalArgumentException("MID not present");
                        }
                        throw new IllegalArgumentException("INDUSTRY_TYPE_ID not present");
                    }
                    throw new IllegalArgumentException("CUST_ID not present");
                }
                throw new IllegalArgumentException("CHECKSUMHASH not present");
            }
            throw new IllegalArgumentException("CALLBACK_URL not present");
        }
        throw new IllegalArgumentException("Invalid request params");
    }
}
