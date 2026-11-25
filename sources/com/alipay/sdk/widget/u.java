package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Stack<WebViewWindow> f13902a = new Stack<>();

    public WebViewWindow a() {
        return this.f13902a.pop();
    }

    public void b(WebViewWindow webViewWindow) {
        this.f13902a.push(webViewWindow);
    }

    public boolean c() {
        return this.f13902a.isEmpty();
    }

    public void d() {
        if (c()) {
            return;
        }
        Iterator<WebViewWindow> it = this.f13902a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f13902a.clear();
    }
}
