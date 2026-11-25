package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.i;
import com.google.android.gms.common.j;

/* JADX INFO: loaded from: classes.dex */
final class b extends AsyncTask<Void, Void, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0188a f16747b;

    b(Context context, a.InterfaceC0188a interfaceC0188a) {
        this.f16746a = context;
        this.f16747b = interfaceC0188a;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Integer doInBackground(Void[] voidArr) {
        try {
            a.a(this.f16746a);
            return 0;
        } catch (i e8) {
            return Integer.valueOf(e8.f15582a);
        } catch (j e9) {
            return Integer.valueOf(e9.b());
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Integer num) {
        Integer num2 = num;
        if (num2.intValue() == 0) {
            this.f16747b.a();
        } else {
            this.f16747b.b(num2.intValue(), a.f16742b.e(this.f16746a, num2.intValue(), "pi"));
        }
    }
}
