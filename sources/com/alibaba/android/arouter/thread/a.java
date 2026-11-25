package com.alibaba.android.arouter.thread;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class a extends CountDownLatch {
    public a(int i7) {
        super(i7);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
