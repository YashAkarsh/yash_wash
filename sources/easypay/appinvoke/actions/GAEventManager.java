package easypay.appinvoke.actions;

import android.text.TextUtils;
import com.haier.uhome.nfc.service.HttpHelper;
import easypay.appinvoke.manager.PaytmAssist;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class GAEventManager implements x4.a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f33649a = new HashMap<>();

    @Override // x4.a
    public void A(boolean z7) {
        this.f33649a.put("isNbSubmitButtonClicked", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isNbSubmitButtonClicked:" + z7, this);
    }

    @Override // x4.a
    public void B(StringBuilder sb) {
        this.f33649a.put("redirectUrls", sb.toString());
        easypay.appinvoke.utils.b.a("AssistAnalytics:redirectUrls:" + sb.toString(), this);
    }

    @Override // x4.a
    public void C(boolean z7) {
        this.f33649a.put("isShowPasswordClicked", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isShowPasswordClicked:" + z7, this);
    }

    @Override // x4.a
    public void D(boolean z7) {
        this.f33649a.put("isAssistMinimized", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isAssistMinimized:" + z7, this);
    }

    @Override // x4.a
    public void E(boolean z7) {
        PaytmAssist.getAssistInstance().getmEventMap().put("autoSubmit", Boolean.valueOf(z7));
        this.f33649a.put("autoSubmitAssist", PaytmAssist.getAssistInstance().getmEventMap());
        easypay.appinvoke.utils.b.a("AssistAnalytics:autoSubmitAssist:" + PaytmAssist.getAssistInstance().getmEventMap(), this);
    }

    @Override // x4.a
    public void F(boolean z7) {
    }

    @Override // x4.a
    public void H(boolean z7) {
        this.f33649a.put("isNetbanking", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isNetbanking:" + z7, this);
    }

    @Override // x4.a
    public void I(boolean z7) {
        this.f33649a.put("isAssistEnable", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isAssistEnabled:" + z7, this);
    }

    @Override // x4.a
    public void J(String str) {
        this.f33649a.put("sender", str);
        easypay.appinvoke.utils.b.a("AssistAnalytics:sender:" + str, this);
    }

    @Override // x4.a
    public void K(boolean z7) {
        this.f33649a.put("isRememberUserIdChecked", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isRememberUserIdChecked:" + z7, this);
    }

    @Override // x4.a
    public void L(boolean z7) {
        this.f33649a.put("NBOtpSubmitted", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:NBOtpSubmitted:" + z7, this);
    }

    @Override // x4.a
    public void M(String str) {
    }

    @Override // x4.a
    public void N(String str) {
        this.f33649a.put("acsUrlLoaded", str);
    }

    @Override // x4.a
    public void O(boolean z7) {
        this.f33649a.put("smsDetected", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:smsDetected:" + z7, this);
    }

    @Override // x4.a
    public void P(String str) {
        this.f33649a.put("acsUrl", str);
        easypay.appinvoke.utils.b.a("AssistAnalytics:acsUrl:" + str, this);
    }

    HashMap<String, Object> R() {
        return this.f33649a;
    }

    @Override // x4.a
    public void a(Boolean bool) {
        easypay.appinvoke.utils.b.a("AssistAnalytics:backPressClicked:" + bool, this);
        if (!PaytmAssist.getAssistInstance().isFragmentResumed()) {
            if (PaytmAssist.getAssistInstance().isFragmentPaused()) {
                return;
            }
            this.f33649a.put("backPressClicked", bool);
        } else {
            if (TextUtils.isEmpty(PaytmAssist.getAssistInstance().getLastLoadedUrl()) || PaytmAssist.getAssistInstance().getLastLoadedUrl().contains("paytm")) {
                return;
            }
            this.f33649a.put("isBackClickedOnAcsPage", bool);
        }
    }

    @Override // x4.a
    public void b(boolean z7) {
        this.f33649a.put("isSMSRead", Boolean.TRUE);
        this.f33649a.put("otp", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isSMSRead:" + z7, this);
    }

    @Override // x4.a
    public void c() {
    }

    @Override // x4.a
    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f33649a.put("NBPageUrl", "URl Not supported|couldnot invoke netbaking asssist");
        } else {
            this.f33649a.put("NBPageUrl", str);
            this.f33649a.put("acsUrl", str);
        }
        easypay.appinvoke.utils.b.a("AssistAnalytics:NbPageUrl:" + str, this);
    }

    @Override // x4.a
    public void e(boolean z7) {
        this.f33649a.put("isPauseButtonTapped", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isPauseButtonTapped:" + z7, this);
    }

    @Override // x4.a
    public void f(String str) {
        this.f33649a.put("cardIssuer", str);
        easypay.appinvoke.utils.b.a("AssistAnalytics:cardIssuer:" + str, this);
    }

    @Override // x4.a
    public void g(String str) {
        this.f33649a.put("acsUrlRequested", str);
    }

    @Override // x4.a
    public void h(boolean z7) {
    }

    @Override // x4.a
    public void i(boolean z7) {
        this.f33649a.put("isSubmitted", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isSubmitted:" + z7, this);
    }

    @Override // x4.a
    public void j(String str, String str2, String str3) {
        this.f33649a.put("appName", str);
        this.f33649a.put("orderId", str2);
        this.f33649a.put(HttpHelper.a.f29518b, str3);
        easypay.appinvoke.utils.b.a("AssistAnalytics:" + str + str2 + str3, this);
    }

    @Override // x4.a
    public void k(boolean z7) {
        PaytmAssist.getAssistInstance().getmEventMap().put("isAutoFillSuccess", Boolean.valueOf(z7));
        this.f33649a.put("isAutoFillSuccess", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isAutoFillSuccess:" + z7, this);
    }

    @Override // x4.a
    public void l(Object obj) {
        try {
            this.f33649a.put("extendedInfo", (HashMap) obj);
            easypay.appinvoke.utils.b.a("AssistAnalytics:extendedInfo:" + obj.toString(), this);
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    @Override // x4.a
    public void m(boolean z7) {
        this.f33649a.put("isBankEnabled", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isBankEnabled:" + z7, this);
    }

    @Override // x4.a
    public void n(boolean z7) {
        this.f33649a.put("NonOTPRequest", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:NonOTPRequest:" + z7, this);
    }

    @Override // x4.a
    public void o(boolean z7) {
        this.f33649a.put("smsPermission", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:smsPermission:" + z7, this);
    }

    @Override // x4.a
    public void p() {
    }

    @Override // x4.a
    public void q(boolean z7) {
        this.f33649a.put("isAutoFillUserIdSuccess", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:isAutoFillUserIdSuccess:" + z7, this);
    }

    @Override // x4.a
    public void r(boolean z7) {
        this.f33649a.put("NBIsotpSelected", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:NbIsotpSelected:" + z7, this);
    }

    @Override // x4.a
    public void t(boolean z7) {
        this.f33649a.put("OTPManuallyEntered", Boolean.valueOf(z7));
        easypay.appinvoke.utils.b.a("AssistAnalytics:OTPManuallyEntered:" + z7, this);
    }

    @Override // x4.a
    public void u(String str) {
        this.f33649a.put("mid", str);
    }

    @Override // x4.a
    public void v() {
    }

    @Override // x4.a
    public void w(String str) {
    }

    @Override // x4.a
    public void x(boolean z7) {
        easypay.appinvoke.utils.b.a("AssistAnalytics:isAssistPopped:" + z7, this);
        this.f33649a.put("isAssistPopped", Boolean.valueOf(z7));
    }

    @Override // x4.a
    public void y(String str) {
        this.f33649a.put("cardType", str);
        easypay.appinvoke.utils.b.a("AssistAnalytics:cardType:" + str, this);
    }

    @Override // x4.a
    public void z(boolean z7, int i7) {
        PaytmAssist.getAssistInstance().getmEventMap().put("buttonClicked", Boolean.valueOf(z7));
        PaytmAssist.getAssistInstance().getmEventMap().put("buttonClickedCount", Integer.valueOf(i7));
        this.f33649a.put("buttonClickedWithCount", PaytmAssist.getAssistInstance().getmEventMap());
        easypay.appinvoke.utils.b.a("AssistAnalytics:buttonClickedWithCount:" + PaytmAssist.getAssistInstance().getmEventMap(), this);
    }
}
