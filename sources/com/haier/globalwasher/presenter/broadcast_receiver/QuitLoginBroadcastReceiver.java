package com.haier.globalwasher.presenter.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import i2.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class QuitLoginBroadcastReceiver extends BroadcastReceiver {
    protected abstract void a(Intent intent);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.f34126p.equals(intent.getAction())) {
            ProfileAvatarImageBeen.getInstance().initRegisterBeen();
            t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40355b, "");
            t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40356c, "");
            t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40357d, "");
            t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40359f, "");
            t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40358e, "");
            a(intent);
        }
    }
}
