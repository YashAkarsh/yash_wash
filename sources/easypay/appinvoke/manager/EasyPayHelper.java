package easypay.appinvoke.manager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.gson.f;
import easypay.appinvoke.utils.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import w4.a;
import x4.e;

/* JADX INFO: loaded from: classes2.dex */
public class EasyPayHelper {
    private a bankResponse;
    private ArrayList<e> mJsCallListListener = new ArrayList<>();

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    EasyPayHelper() {
        PaytmAssist.getAssistInstance().getWebView().addJavascriptInterface(this, Constants.EASYPAY_JS_INTERFACE);
    }

    @JavascriptInterface
    public void NBWatcher(String str, String str2, int i7) {
        if (str == null || str2 == null) {
            return;
        }
        if (i7 == 106) {
            Iterator<e> it = this.mJsCallListListener.iterator();
            while (it.hasNext()) {
                it.next().a("", str, i7);
            }
            return;
        }
        if (i7 == 156) {
            Iterator<e> it2 = this.mJsCallListListener.iterator();
            while (it2.hasNext()) {
                it2.next().a(str, str2, i7);
            }
            return;
        }
        if (i7 != 157) {
            switch (i7) {
                case 151:
                case Constants.ACTION_UID_VIEWER /* 152 */:
                case 153:
                    break;
                default:
                    switch (i7) {
                        case 159:
                        case 160:
                        case 161:
                            break;
                        default:
                            switch (i7) {
                                case 165:
                                    b.a("Bank Bage optimized called", this);
                                    if (PaytmAssist.getAssistInstance().getmEventMap() != null) {
                                        PaytmAssist.getAssistInstance().getmEventMap().put("isWebPageOptimized", Boolean.TRUE);
                                        b.a("Bank Bage optimized called" + PaytmAssist.getAssistInstance().getmEventMap(), this);
                                    }
                                    break;
                            }
                            return;
                    }
                    break;
            }
        }
        Iterator<e> it3 = this.mJsCallListListener.iterator();
        while (it3.hasNext()) {
            it3.next().b(str2, str, i7);
        }
    }

    @JavascriptInterface
    public void OTPWatcher(String str, String str2, int i7) {
        if (i7 != 108) {
            if (i7 == 158) {
                Iterator<e> it = this.mJsCallListListener.iterator();
                while (it.hasNext()) {
                    it.next().b(str2, str, i7);
                }
                return;
            }
            if (i7 != 201) {
                if (i7 == 300) {
                    Iterator<e> it2 = this.mJsCallListListener.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(str2, str, i7);
                    }
                    return;
                } else if (i7 == 221) {
                    Iterator<e> it3 = this.mJsCallListListener.iterator();
                    while (it3.hasNext()) {
                        it3.next().b(str2, str, i7);
                    }
                    return;
                } else {
                    if (i7 != 222) {
                        return;
                    }
                    Iterator<e> it4 = this.mJsCallListListener.iterator();
                    while (it4.hasNext()) {
                        it4.next().b(str2, str, i7);
                    }
                    return;
                }
            }
        }
        Iterator<e> it5 = this.mJsCallListListener.iterator();
        while (it5.hasNext()) {
            it5.next().b(str2, str, i7);
        }
    }

    public void addJsCallListener(e eVar) {
        ArrayList<e> arrayList = this.mJsCallListListener;
        if (arrayList != null) {
            arrayList.add(eVar);
        }
    }

    public a getBankResponse() {
        return this.bankResponse;
    }

    @JavascriptInterface
    public void logError(String str) {
        Iterator<e> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().b("", str, Constants.LOG_ERROR_OTP);
        }
        PaytmAssist.getAssistInstance().getmEventMap().put("JSError", str);
        if (TextUtils.isEmpty(PaytmAssist.getAssistInstance().getCardDetails())) {
            return;
        }
        PaytmAssist.getAssistInstance().getmEventMap().put("JSError", str + "bank Details" + PaytmAssist.getAssistInstance().getCardDetails());
    }

    @JavascriptInterface
    public void sendBnkDtlToApp(String str) {
        b.a("Json From UI:" + str, this);
        HashMap map = (HashMap) new f().o(str, new com.google.gson.reflect.a<HashMap<String, String>>() { // from class: easypay.appinvoke.manager.EasyPayHelper.1
        }.getType());
        String string = "";
        String string2 = (map == null || map.get(Constants.EXTRA_BANK_CODE) == null) ? "" : map.get(Constants.EXTRA_BANK_CODE).toString();
        String string3 = (map == null || map.get("payType") == null) ? "" : map.get("payType").toString();
        if (map != null && map.get(Constants.EXTRA_BANK_SCHEME) != null) {
            string = map.get(Constants.EXTRA_BANK_SCHEME).toString();
        }
        PaytmAssist.getAssistInstance().setBankInfo(string2, string3, string);
    }

    public void setBankResponse(a aVar) {
        this.bankResponse = aVar;
    }

    @JavascriptInterface
    public void showLog(String str) {
        Iterator<e> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().b("", str, 109);
        }
        PaytmAssist.getAssistInstance().setAssistEngineTerminatedStatus(true);
    }

    @JavascriptInterface
    public void successEvent(int i7, String str) {
        if (i7 != 100 && i7 != 101) {
            if (i7 != 107) {
                switch (i7) {
                }
                return;
            }
            for (e eVar : this.mJsCallListListener) {
                b.a("EasyPayHelper :Web success Ui callback" + eVar.toString(), this);
                eVar.b("", str, i7);
            }
            return;
        }
        Iterator<e> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().a("", str, i7);
        }
    }
}
