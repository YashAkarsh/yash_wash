package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.m0;
import c.o0;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import g1.d0;
import g1.g;
import g1.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @m0
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d0
    @m0
    public static g f14942n = k.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f14943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getId", id = 2)
    private String f14944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getIdToken", id = 3)
    private String f14945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getEmail", id = 4)
    private String f14946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getDisplayName", id = 5)
    private String f14947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getPhotoUrl", id = 6)
    private Uri f14948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getServerAuthCode", id = 7)
    private String f14949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "getExpirationTimeSecs", id = 8)
    private long f14950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getObfuscatedIdentifier", id = 9)
    private String f14951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(id = 10)
    List<Scope> f14952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getGivenName", id = 11)
    private String f14953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getFamilyName", id = 12)
    private String f14954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Set<Scope> f14955m = new HashSet();

    @SafeParcelable.b
    GoogleSignInAccount(@SafeParcelable.e(id = 1) int i7, @o0 @SafeParcelable.e(id = 2) String str, @o0 @SafeParcelable.e(id = 3) String str2, @o0 @SafeParcelable.e(id = 4) String str3, @o0 @SafeParcelable.e(id = 5) String str4, @o0 @SafeParcelable.e(id = 6) Uri uri, @o0 @SafeParcelable.e(id = 7) String str5, @SafeParcelable.e(id = 8) long j7, @SafeParcelable.e(id = 9) String str6, @SafeParcelable.e(id = 10) List<Scope> list, @o0 @SafeParcelable.e(id = 11) String str7, @o0 @SafeParcelable.e(id = 12) String str8) {
        this.f14943a = i7;
        this.f14944b = str;
        this.f14945c = str2;
        this.f14946d = str3;
        this.f14947e = str4;
        this.f14948f = uri;
        this.f14949g = str5;
        this.f14950h = j7;
        this.f14951i = str6;
        this.f14952j = list;
        this.f14953k = str7;
        this.f14954l = str8;
    }

    @c1.a
    @m0
    public static GoogleSignInAccount K() {
        return i1(new Account("<<default account>>", com.google.android.gms.common.internal.b.f15664a), new HashSet());
    }

    @c1.a
    @m0
    public static GoogleSignInAccount Q(@m0 Account account) {
        return i1(account, new androidx.collection.b());
    }

    @m0
    public static GoogleSignInAccount Y0(@o0 String str, @o0 String str2, @o0 String str3, @o0 String str4, @o0 String str5, @o0 String str6, @o0 Uri uri, @o0 Long l7, @m0 String str7, @m0 Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l7.longValue(), u.g(str7), new ArrayList((Collection) u.k(set)), str5, str6);
    }

    @o0
    public static GoogleSignInAccount a1(@o0 String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j7 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            hashSet.add(new Scope(jSONArray.getString(i7)));
        }
        GoogleSignInAccount googleSignInAccountY0 = Y0(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j7), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountY0.f14949g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountY0;
    }

    private static GoogleSignInAccount i1(Account account, Set<Scope> set) {
        return Y0(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    @o0
    public Account F() {
        String str = this.f14946d;
        if (str == null) {
            return null;
        }
        return new Account(str, com.google.android.gms.common.internal.b.f15664a);
    }

    @o0
    public String G0() {
        return this.f14944b;
    }

    @o0
    public String I0() {
        return this.f14945c;
    }

    @o0
    public Uri J0() {
        return this.f14948f;
    }

    @c1.a
    @m0
    public Set<Scope> L0() {
        HashSet hashSet = new HashSet(this.f14952j);
        hashSet.addAll(this.f14955m);
        return hashSet;
    }

    @o0
    public String Q0() {
        return this.f14949g;
    }

    @c1.a
    public boolean T0() {
        return f14942n.b() / 1000 >= this.f14950h + (-300);
    }

    @c1.a
    @m0
    public GoogleSignInAccount V0(@m0 Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.f14955m, scopeArr);
        }
        return this;
    }

    @m0
    public final String d1() {
        return this.f14951i;
    }

    @m0
    public final String e1() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (G0() != null) {
                jSONObject.put("id", G0());
            }
            if (I0() != null) {
                jSONObject.put("tokenId", I0());
            }
            if (r0() != null) {
                jSONObject.put("email", r0());
            }
            if (p0() != null) {
                jSONObject.put("displayName", p0());
            }
            if (v0() != null) {
                jSONObject.put("givenName", v0());
            }
            if (s0() != null) {
                jSONObject.put("familyName", s0());
            }
            Uri uriJ0 = J0();
            if (uriJ0 != null) {
                jSONObject.put("photoUrl", uriJ0.toString());
            }
            if (Q0() != null) {
                jSONObject.put("serverAuthCode", Q0());
            }
            jSONObject.put("expirationTime", this.f14950h);
            jSONObject.put("obfuscatedIdentifier", this.f14951i);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.f14952j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: com.google.android.gms.auth.api.signin.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).K().compareTo(((Scope) obj2).K());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.K());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e8) {
            throw new RuntimeException(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f14951i.equals(this.f14951i) && googleSignInAccount.L0().equals(L0());
    }

    public int hashCode() {
        return ((this.f14951i.hashCode() + 527) * 31) + L0().hashCode();
    }

    @o0
    public String p0() {
        return this.f14947e;
    }

    @o0
    public String r0() {
        return this.f14946d;
    }

    @o0
    public String s0() {
        return this.f14954l;
    }

    @o0
    public String v0() {
        return this.f14953k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f14943a);
        e1.b.Y(parcel, 2, G0(), false);
        e1.b.Y(parcel, 3, I0(), false);
        e1.b.Y(parcel, 4, r0(), false);
        e1.b.Y(parcel, 5, p0(), false);
        e1.b.S(parcel, 6, J0(), i7, false);
        e1.b.Y(parcel, 7, Q0(), false);
        e1.b.K(parcel, 8, this.f14950h);
        e1.b.Y(parcel, 9, this.f14951i, false);
        e1.b.d0(parcel, 10, this.f14952j, false);
        e1.b.Y(parcel, 11, v0(), false);
        e1.b.Y(parcel, 12, s0(), false);
        e1.b.b(parcel, iA);
    }

    @m0
    public Set<Scope> x0() {
        return new HashSet(this.f14952j);
    }
}
