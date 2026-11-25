package org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import java.io.IOException;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net::android")
public class HttpNegotiateAuthenticator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38996c = "net_auth";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f38997d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f38998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38999b;

    @org.chromium.base.s0
    class a implements AccountManagerCallback<Account[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f39000a;

        public a(c cVar) {
            this.f39000a = cVar;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> accountManagerFuture) {
            try {
                Account[] result = accountManagerFuture.getResult();
                if (result.length == 0) {
                    org.chromium.base.t.B(HttpNegotiateAuthenticator.f38996c, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.f39000a.f39006a, v.f39670u4, null);
                    return;
                }
                if (result.length > 1) {
                    org.chromium.base.t.B(HttpNegotiateAuthenticator.f38996c, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", Integer.valueOf(result.length));
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.f39000a.f39006a, v.f39670u4, null);
                } else if (HttpNegotiateAuthenticator.this.b(org.chromium.base.o.e(), "android.permission.USE_CREDENTIALS", true)) {
                    org.chromium.base.t.j(HttpNegotiateAuthenticator.f38996c, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.f39000a.f39006a, v.f39678w4, null);
                } else {
                    c cVar = this.f39000a;
                    Account account = result[0];
                    cVar.f39010e = account;
                    cVar.f39007b.getAuthToken(account, cVar.f39009d, cVar.f39008c, true, (AccountManagerCallback<Bundle>) HttpNegotiateAuthenticator.this.new b(cVar), new Handler(ThreadUtils.e()));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e8) {
                org.chromium.base.t.B(HttpNegotiateAuthenticator.f38996c, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e8);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.f39000a.f39006a, -9, null);
            }
        }
    }

    @org.chromium.base.s0
    class b implements AccountManagerCallback<Bundle> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f39002a;

        class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f39004a;

            a(Context context) {
                this.f39004a = context;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                this.f39004a.unregisterReceiver(this);
                AccountManager accountManager = b.this.f39002a.f39007b;
                Account account = b.this.f39002a.f39010e;
                String str = b.this.f39002a.f39009d;
                Bundle bundle = b.this.f39002a.f39008c;
                b bVar = b.this;
                accountManager.getAuthToken(account, str, bundle, true, (AccountManagerCallback<Bundle>) HttpNegotiateAuthenticator.this.new b(bVar.f39002a), (Handler) null);
            }
        }

        public b(c cVar) {
            this.f39002a = cVar;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle result = accountManagerFuture.getResult();
                if (!result.containsKey("intent")) {
                    HttpNegotiateAuthenticator.this.c(result, this.f39002a);
                } else {
                    Context contextE = org.chromium.base.o.e();
                    contextE.registerReceiver(new a(contextE), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e8) {
                org.chromium.base.t.B(HttpNegotiateAuthenticator.f38996c, "ERR_UNEXPECTED: Error while attempting to obtain a token.", e8);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.f39002a.f39006a, -9, null);
            }
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f39006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AccountManager f39007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f39008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f39009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f39010e;

        c() {
        }
    }

    protected HttpNegotiateAuthenticator(String str) {
        this.f38999b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle, c cVar) {
        this.f38998a = bundle.getBundle(q.f39482b);
        int i7 = -9;
        switch (bundle.getInt(q.f39484d, 1)) {
            case 0:
                i7 = 0;
                break;
            case 2:
                i7 = -3;
                break;
            case 3:
                i7 = v.f39674v4;
                break;
            case 4:
                i7 = v.f39590a4;
                break;
            case 5:
                i7 = v.f39658r4;
                break;
            case 6:
                i7 = v.f39662s4;
                break;
            case 7:
                i7 = v.f39670u4;
                break;
            case 8:
                i7 = v.f39682x4;
                break;
            case 9:
                i7 = v.f39626j4;
                break;
        }
        nativeSetResult(cVar.f39006a, i7, bundle.getString("authtoken"));
    }

    @CalledByNative
    @org.chromium.base.s0
    static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    private void d(Context context, Activity activity, c cVar, String[] strArr) {
        if (!b(context, "android.permission.GET_ACCOUNTS", false)) {
            cVar.f39007b.getAuthTokenByFeatures(this.f38999b, cVar.f39009d, strArr, activity, null, cVar.f39008c, new b(cVar), new Handler(ThreadUtils.e()));
        } else {
            org.chromium.base.t.j(f38996c, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", "android.permission.GET_ACCOUNTS");
            nativeSetResult(cVar.f39006a, v.f39678w4, null);
        }
    }

    private void e(Context context, c cVar, String[] strArr) {
        if (!b(context, "android.permission.GET_ACCOUNTS", true)) {
            cVar.f39007b.getAccountsByTypeAndFeatures(this.f38999b, strArr, new a(cVar), new Handler(ThreadUtils.e()));
        } else {
            org.chromium.base.t.j(f38996c, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
            nativeSetResult(cVar.f39006a, v.f39678w4, null);
        }
    }

    @org.chromium.base.s0
    boolean b(Context context, String str, boolean z7) {
        return (z7 || context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) ? false : true;
    }

    @CalledByNative
    @org.chromium.base.s0
    void getNextAuthToken(long j7, String str, String str2, boolean z7) {
        Context contextE = org.chromium.base.o.e();
        c cVar = new c();
        cVar.f39009d = q.f39486f + str;
        cVar.f39007b = AccountManager.get(contextE);
        cVar.f39006a = j7;
        String[] strArr = {q.f39485e};
        Bundle bundle = new Bundle();
        cVar.f39008c = bundle;
        if (str2 != null) {
            bundle.putString(q.f39481a, str2);
        }
        Bundle bundle2 = this.f38998a;
        if (bundle2 != null) {
            cVar.f39008c.putBundle(q.f39482b, bundle2);
        }
        cVar.f39008c.putBoolean(q.f39483c, z7);
        Activity activityJ = ApplicationStatus.j();
        if (activityJ == null) {
            e(contextE, cVar, strArr);
        } else {
            d(contextE, activityJ, cVar, strArr);
        }
    }

    @org.chromium.base.s0
    native void nativeSetResult(long j7, int i7, String str);
}
