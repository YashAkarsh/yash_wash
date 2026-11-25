package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccountManager f24956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Account f24957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f24959d;

    public a(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.b
    public String a() throws com.haier.globalwasher.mvp_api.volley.a {
        String string;
        AccountManagerFuture<Bundle> authToken = this.f24956a.getAuthToken(this.f24957b, this.f24958c, this.f24959d, null, null);
        try {
            Bundle result = authToken.getResult();
            if (!authToken.isDone() || authToken.isCancelled()) {
                string = null;
            } else {
                if (result.containsKey("intent")) {
                    throw new com.haier.globalwasher.mvp_api.volley.a((Intent) result.getParcelable("intent"));
                }
                string = result.getString("authtoken");
            }
            if (string != null) {
                return string;
            }
            throw new com.haier.globalwasher.mvp_api.volley.a("Got null auth token for type: " + this.f24958c);
        } catch (Exception e8) {
            throw new com.haier.globalwasher.mvp_api.volley.a("Error while retrieving auth token", e8);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.b
    public void b(String str) {
        this.f24956a.invalidateAuthToken(this.f24957b.type, str);
    }

    public Account c() {
        return this.f24957b;
    }

    public a(Context context, Account account, String str, boolean z7) {
        this(AccountManager.get(context), account, str, z7);
    }

    a(AccountManager accountManager, Account account, String str, boolean z7) {
        this.f24956a = accountManager;
        this.f24957b = account;
        this.f24958c = str;
        this.f24959d = z7;
    }
}
