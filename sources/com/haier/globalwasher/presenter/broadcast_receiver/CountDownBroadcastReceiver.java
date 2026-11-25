package com.haier.globalwasher.presenter.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import i2.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CountDownBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25076a = "1001";

    public abstract void a(ArrayList<CountDownBeen> arrayList);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(a.f34153y)) {
            a(MyApplication.l());
        }
    }
}
