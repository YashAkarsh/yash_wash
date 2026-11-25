package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: com.google.android.gms.common.a$a, reason: collision with other inner class name */
    public static class C0177a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        private Account f15036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        private ArrayList<Account> f15038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        private ArrayList<String> f15039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f15040e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @c.o0
        private String f15041f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @c.o0
        private Bundle f15042g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f15043h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f15044i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @c.o0
        private String f15045j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f15046k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @c.o0
        private x f15047l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @c.o0
        private String f15048m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f15049n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f15050o;

        /* JADX INFO: renamed from: com.google.android.gms.common.a$a$a, reason: collision with other inner class name */
        public static class C0178a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @c.o0
            private Account f15051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @c.o0
            private ArrayList<Account> f15052b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @c.o0
            private ArrayList<String> f15053c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f15054d = false;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @c.o0
            private String f15055e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @c.o0
            private Bundle f15056f;

            @c.m0
            public C0177a a() {
                com.google.android.gms.common.internal.u.b(true, "We only support hostedDomain filter for account chip styled account picker");
                com.google.android.gms.common.internal.u.b(true, "Consent is only valid for account chip styled account picker");
                C0177a c0177a = new C0177a();
                c0177a.f15039d = this.f15053c;
                c0177a.f15038c = this.f15052b;
                c0177a.f15040e = this.f15054d;
                c0177a.f15047l = null;
                c0177a.f15045j = null;
                c0177a.f15042g = this.f15056f;
                c0177a.f15036a = this.f15051a;
                c0177a.f15037b = false;
                c0177a.f15043h = false;
                c0177a.f15048m = null;
                c0177a.f15044i = 0;
                c0177a.f15041f = this.f15055e;
                c0177a.f15046k = false;
                c0177a.f15049n = false;
                c0177a.f15050o = false;
                return c0177a;
            }

            @c.m0
            public C0178a b(@c.o0 List<Account> list) {
                this.f15052b = list == null ? null : new ArrayList<>(list);
                return this;
            }

            @c.m0
            public C0178a c(@c.o0 List<String> list) {
                this.f15053c = list == null ? null : new ArrayList<>(list);
                return this;
            }

            @c.m0
            public C0178a d(boolean z7) {
                this.f15054d = z7;
                return this;
            }

            @c.m0
            public C0178a e(@c.o0 Bundle bundle) {
                this.f15056f = bundle;
                return this;
            }

            @c.m0
            public C0178a f(@c.o0 Account account) {
                this.f15051a = account;
                return this;
            }

            @c.m0
            public C0178a g(@c.o0 String str) {
                this.f15055e = str;
                return this;
            }
        }

        static /* bridge */ /* synthetic */ boolean D(C0177a c0177a) {
            boolean z7 = c0177a.f15049n;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean a(C0177a c0177a) {
            boolean z7 = c0177a.f15050o;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean b(C0177a c0177a) {
            boolean z7 = c0177a.f15037b;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean c(C0177a c0177a) {
            boolean z7 = c0177a.f15043h;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean d(C0177a c0177a) {
            boolean z7 = c0177a.f15046k;
            return false;
        }

        static /* bridge */ /* synthetic */ int e(C0177a c0177a) {
            int i7 = c0177a.f15044i;
            return 0;
        }

        static /* bridge */ /* synthetic */ x h(C0177a c0177a) {
            x xVar = c0177a.f15047l;
            return null;
        }

        static /* bridge */ /* synthetic */ String i(C0177a c0177a) {
            String str = c0177a.f15045j;
            return null;
        }

        static /* bridge */ /* synthetic */ String j(C0177a c0177a) {
            String str = c0177a.f15048m;
            return null;
        }
    }

    private a() {
    }

    @c.m0
    @Deprecated
    public static Intent a(@c.o0 Account account, @c.o0 ArrayList<Account> arrayList, @c.o0 String[] strArr, boolean z7, @c.o0 String str, @c.o0 String str2, @c.o0 String[] strArr2, @c.o0 Bundle bundle) {
        Intent intent = new Intent();
        com.google.android.gms.common.internal.u.b(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z7);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    @c.m0
    public static Intent b(@c.m0 C0177a c0177a) {
        Intent intent = new Intent();
        C0177a.d(c0177a);
        C0177a.i(c0177a);
        com.google.android.gms.common.internal.u.b(true, "We only support hostedDomain filter for account chip styled account picker");
        C0177a.h(c0177a);
        com.google.android.gms.common.internal.u.b(true, "Consent is only valid for account chip styled account picker");
        C0177a.b(c0177a);
        com.google.android.gms.common.internal.u.b(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        C0177a.d(c0177a);
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", c0177a.f15038c);
        if (c0177a.f15039d != null) {
            intent.putExtra("allowableAccountTypes", (String[]) c0177a.f15039d.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", c0177a.f15042g);
        intent.putExtra("selectedAccount", c0177a.f15036a);
        C0177a.b(c0177a);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", c0177a.f15040e);
        intent.putExtra("descriptionTextOverride", c0177a.f15041f);
        C0177a.c(c0177a);
        intent.putExtra("setGmsCoreAccount", false);
        C0177a.j(c0177a);
        intent.putExtra("realClientPackage", (String) null);
        C0177a.e(c0177a);
        intent.putExtra("overrideTheme", 0);
        C0177a.d(c0177a);
        intent.putExtra("overrideCustomTheme", 0);
        C0177a.i(c0177a);
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        C0177a.d(c0177a);
        C0177a.h(c0177a);
        C0177a.D(c0177a);
        C0177a.a(c0177a);
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
