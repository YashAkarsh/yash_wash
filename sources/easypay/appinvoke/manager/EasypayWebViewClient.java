package easypay.appinvoke.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.utils.a;
import easypay.appinvoke.utils.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import x4.f;

/* JADX INFO: loaded from: classes2.dex */
public class EasypayWebViewClient extends WebViewClient implements Serializable {
    public static long smsTrackingTime;
    private EasypayBrowserFragment fragment;
    private Activity mActivity;
    private ArrayList<f> mWcListListener;

    public EasypayWebViewClient() {
    }

    private void fireActions(final WebView webView, final String str) {
        if (this.fragment == null || PaytmAssist.getAssistInstance().getAssistEngineTerminatedStatus()) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.EasypayWebViewClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (EasypayWebViewClient.this.fragment != null) {
                    b.a("page finish: fire action:checkAssistFlow", this);
                    EasypayWebViewClient.this.fragment.X(webView, str);
                }
            }
        });
    }

    public void addAssistWebClientListener(f fVar) {
        ArrayList<f> arrayList = this.mWcListListener;
        if (arrayList != null) {
            try {
                arrayList.listIterator().add(fVar);
                return;
            } catch (Exception e8) {
                e8.printStackTrace();
                return;
            }
        }
        try {
            throw new a(Constants.Assist_Invoke_Exception_Message);
        } catch (a e9) {
            e9.printStackTrace();
            b.a("EXCEPTION", e9);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b.a("" + str, this);
        try {
            ArrayList<f> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().y(webView, str);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
        }
        try {
            if (this.fragment == null) {
                this.fragment = PaytmAssist.getAssistInstance().getFragment();
            }
            fireActions(webView, str);
            PaytmAssist.getAssistInstance().setLastLoadedUrl(str);
        } catch (Exception e9) {
            e9.printStackTrace();
            b.a("EXCEPTION", e9);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        b.a("onpage started-" + str, this);
        try {
            if (this.mWcListListener != null) {
                for (int i7 = 0; i7 < this.mWcListListener.size(); i7++) {
                    this.mWcListListener.get(i7).k(webView, str, bitmap);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
        }
        EasypayBrowserFragment easypayBrowserFragment = this.fragment;
        if (easypayBrowserFragment != null) {
            easypayBrowserFragment.z0();
            try {
                this.fragment.getActivity().runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.EasypayWebViewClient.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i7, String str, String str2) {
        super.onReceivedError(webView, i7, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            ArrayList<f> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().j(webView, sslErrorHandler, sslError);
                }
            }
        } catch (AbstractMethodError unused) {
        }
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }

    public synchronized void removeAssistWebClientListener(f fVar) {
        ArrayList<f> arrayList = this.mWcListListener;
        if (arrayList != null) {
            try {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(fVar)) {
                        it.remove();
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        } else {
            try {
                throw new a(Constants.Assist_Invoke_Exception_Message);
            } catch (a e9) {
                e9.printStackTrace();
                b.a("EXCEPTION", e9);
            }
        }
        throw th;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            ArrayList<f> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().r(webView, str);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            ArrayList<f> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().z(webView, str);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public EasypayWebViewClient(Activity activity) {
        b.a("EasypayWebViewClient" + toString(), this);
        this.mActivity = activity;
        this.mWcListListener = PaytmAssist.getAssistInstance().getmWcListListener();
        smsTrackingTime = System.currentTimeMillis();
        this.fragment = PaytmAssist.getAssistInstance().getFragment();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            ArrayList<f> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().z(webView, webResourceRequest);
                }
            }
        } catch (Exception unused) {
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
