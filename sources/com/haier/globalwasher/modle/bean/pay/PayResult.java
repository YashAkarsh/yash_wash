package com.haier.globalwasher.modle.bean.pay;

import android.text.TextUtils;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.m;

/* JADX INFO: loaded from: classes2.dex */
public class PayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public PayResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(j.f13806b)) {
            if (str2.startsWith(m.f13816a)) {
                this.resultStatus = gatValue(str2, m.f13816a);
            }
            if (str2.startsWith(m.f13818c)) {
                this.result = gatValue(str2, m.f13818c);
            }
            if (str2.startsWith(m.f13817b)) {
                this.memo = gatValue(str2, m.f13817b);
            }
        }
    }

    private String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(j.f13808d));
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + j.f13808d;
    }
}
