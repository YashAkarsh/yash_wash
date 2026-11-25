package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.m0;
import c.o0;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.q;
import g1.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements com.google.android.gms.common.api.a.d.f, ReflectedParcelable {

    @m0
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    public static final GoogleSignInOptions f14956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @m0
    public static final GoogleSignInOptions f14957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d0
    @m0
    public static final Scope f14958n = new Scope(q.f15877a);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @d0
    @m0
    public static final Scope f14959o = new Scope("email");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @d0
    @m0
    public static final Scope f14960p = new Scope(q.f15879c);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @d0
    @m0
    public static final Scope f14961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @d0
    @m0
    public static final Scope f14962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static Comparator<Scope> f14963s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f14964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getScopes", id = 2)
    private final ArrayList<Scope> f14965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getAccount", id = 3)
    private Account f14966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "isIdTokenRequested", id = 4)
    private boolean f14967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean f14968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean f14969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getServerClientId", id = 7)
    private String f14970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getHostedDomain", id = 8)
    private String f14971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> f14972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getLogSessionId", id = 10)
    private String f14973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> f14974k;

    static {
        Scope scope = new Scope(q.f15883g);
        f14961q = scope;
        f14962r = new Scope(q.f15882f);
        a aVar = new a();
        aVar.d();
        aVar.f();
        f14956l = aVar.b();
        a aVar2 = new a();
        aVar2.g(scope, new Scope[0]);
        f14957m = aVar2.b();
        CREATOR = new f();
        f14963s = new d();
    }

    @o0
    public static GoogleSignInOptions J0(@o0 String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            hashSet.add(new Scope(jSONArray.getString(i7)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, com.google.android.gms.common.internal.b.f15664a) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> s1(@o0 List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.K()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    @o0
    @c1.a
    public Account F() {
        return this.f14966c;
    }

    @c1.a
    public boolean G0() {
        return this.f14968e;
    }

    @c1.a
    @m0
    public ArrayList<GoogleSignInOptionsExtensionParcelable> K() {
        return this.f14972i;
    }

    @o0
    @c1.a
    public String Q() {
        return this.f14973j;
    }

    @m0
    public final String V0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f14965b, f14963s);
            Iterator<Scope> it = this.f14965b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().K());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f14966c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f14967d);
            jSONObject.put("forceCodeForRefreshToken", this.f14969f);
            jSONObject.put("serverAuthRequested", this.f14968e);
            if (!TextUtils.isEmpty(this.f14970g)) {
                jSONObject.put("serverClientId", this.f14970g);
            }
            if (!TextUtils.isEmpty(this.f14971h)) {
                jSONObject.put("hostedDomain", this.f14971h);
            }
            return jSONObject.toString();
        } catch (JSONException e8) {
            throw new RuntimeException(e8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x006a A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    public boolean equals(@o0 Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f14972i.size() <= 0 && googleSignInOptions.f14972i.size() <= 0 && this.f14965b.size() == googleSignInOptions.r0().size() && this.f14965b.containsAll(googleSignInOptions.r0())) {
                Account account = this.f14966c;
                if (account == null) {
                    if (googleSignInOptions.F() == null) {
                        if (TextUtils.isEmpty(this.f14970g)) {
                            if (TextUtils.isEmpty(googleSignInOptions.s0())) {
                                if (this.f14969f != googleSignInOptions.v0() && this.f14967d == googleSignInOptions.x0() && this.f14968e == googleSignInOptions.G0() && TextUtils.equals(this.f14973j, googleSignInOptions.Q())) {
                                    return true;
                                }
                            }
                        } else if (!this.f14970g.equals(googleSignInOptions.s0())) {
                            if (this.f14969f != googleSignInOptions.v0()) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.F())) {
                    if (TextUtils.isEmpty(this.f14970g)) {
                        if (TextUtils.isEmpty(googleSignInOptions.s0())) {
                            if (this.f14969f != googleSignInOptions.v0()) {
                            }
                        }
                    } else if (!this.f14970g.equals(googleSignInOptions.s0())) {
                        if (this.f14969f != googleSignInOptions.v0()) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f14965b;
        int size = arrayList2.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(arrayList2.get(i7).K());
        }
        Collections.sort(arrayList);
        com.google.android.gms.auth.api.signin.internal.a aVar = new com.google.android.gms.auth.api.signin.internal.a();
        aVar.a(arrayList);
        aVar.a(this.f14966c);
        aVar.a(this.f14970g);
        aVar.c(this.f14969f);
        aVar.c(this.f14967d);
        aVar.c(this.f14968e);
        aVar.a(this.f14973j);
        return aVar.b();
    }

    @m0
    public Scope[] p0() {
        ArrayList<Scope> arrayList = this.f14965b;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @c1.a
    @m0
    public ArrayList<Scope> r0() {
        return new ArrayList<>(this.f14965b);
    }

    @o0
    @c1.a
    public String s0() {
        return this.f14970g;
    }

    @c1.a
    public boolean v0() {
        return this.f14969f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f14964a);
        e1.b.d0(parcel, 2, r0(), false);
        e1.b.S(parcel, 3, F(), i7, false);
        e1.b.g(parcel, 4, x0());
        e1.b.g(parcel, 5, G0());
        e1.b.g(parcel, 6, v0());
        e1.b.Y(parcel, 7, s0(), false);
        e1.b.Y(parcel, 8, this.f14971h, false);
        e1.b.d0(parcel, 9, K(), false);
        e1.b.Y(parcel, 10, Q(), false);
        e1.b.b(parcel, iA);
    }

    @c1.a
    public boolean x0() {
        return this.f14967d;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Set<Scope> f14975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        private String f14979e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        private Account f14980f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        private String f14981g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f14982h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @o0
        private String f14983i;

        public a() {
            this.f14975a = new HashSet();
            this.f14982h = new HashMap();
        }

        private final String m(String str) {
            u.g(str);
            String str2 = this.f14979e;
            boolean z7 = true;
            if (str2 != null && !str2.equals(str)) {
                z7 = false;
            }
            u.b(z7, "two different server client ids provided");
            return str;
        }

        @m0
        public a a(@m0 com.google.android.gms.auth.api.signin.a aVar) {
            if (this.f14982h.containsKey(Integer.valueOf(aVar.b()))) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            List<Scope> listC = aVar.c();
            if (listC != null) {
                this.f14975a.addAll(listC);
            }
            this.f14982h.put(Integer.valueOf(aVar.b()), new GoogleSignInOptionsExtensionParcelable(aVar));
            return this;
        }

        @m0
        public GoogleSignInOptions b() {
            if (this.f14975a.contains(GoogleSignInOptions.f14962r)) {
                Set<Scope> set = this.f14975a;
                Scope scope = GoogleSignInOptions.f14961q;
                if (set.contains(scope)) {
                    this.f14975a.remove(scope);
                }
            }
            if (this.f14978d && (this.f14980f == null || !this.f14975a.isEmpty())) {
                d();
            }
            return new GoogleSignInOptions(new ArrayList(this.f14975a), this.f14980f, this.f14978d, this.f14976b, this.f14977c, this.f14979e, this.f14981g, this.f14982h, this.f14983i);
        }

        @m0
        public a c() {
            this.f14975a.add(GoogleSignInOptions.f14959o);
            return this;
        }

        @m0
        public a d() {
            this.f14975a.add(GoogleSignInOptions.f14960p);
            return this;
        }

        @m0
        public a e(@m0 String str) {
            this.f14978d = true;
            m(str);
            this.f14979e = str;
            return this;
        }

        @m0
        public a f() {
            this.f14975a.add(GoogleSignInOptions.f14958n);
            return this;
        }

        @m0
        public a g(@m0 Scope scope, @m0 Scope... scopeArr) {
            this.f14975a.add(scope);
            this.f14975a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @m0
        public a h(@m0 String str) {
            i(str, false);
            return this;
        }

        @m0
        public a i(@m0 String str, boolean z7) {
            this.f14976b = true;
            m(str);
            this.f14979e = str;
            this.f14977c = z7;
            return this;
        }

        @m0
        public a j(@m0 String str) {
            this.f14980f = new Account(u.g(str), com.google.android.gms.common.internal.b.f15664a);
            return this;
        }

        @m0
        public a k(@m0 String str) {
            this.f14981g = u.g(str);
            return this;
        }

        @c1.a
        @m0
        public a l(@m0 String str) {
            this.f14983i = str;
            return this;
        }

        public a(@m0 GoogleSignInOptions googleSignInOptions) {
            this.f14975a = new HashSet();
            this.f14982h = new HashMap();
            u.k(googleSignInOptions);
            this.f14975a = new HashSet(googleSignInOptions.f14965b);
            this.f14976b = googleSignInOptions.f14968e;
            this.f14977c = googleSignInOptions.f14969f;
            this.f14978d = googleSignInOptions.f14967d;
            this.f14979e = googleSignInOptions.f14970g;
            this.f14980f = googleSignInOptions.f14966c;
            this.f14981g = googleSignInOptions.f14971h;
            this.f14982h = GoogleSignInOptions.s1(googleSignInOptions.f14972i);
            this.f14983i = googleSignInOptions.f14973j;
        }
    }

    @SafeParcelable.b
    GoogleSignInOptions(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) ArrayList<Scope> arrayList, @o0 @SafeParcelable.e(id = 3) Account account, @SafeParcelable.e(id = 4) boolean z7, @SafeParcelable.e(id = 5) boolean z8, @SafeParcelable.e(id = 6) boolean z9, @o0 @SafeParcelable.e(id = 7) String str, @o0 @SafeParcelable.e(id = 8) String str2, @SafeParcelable.e(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @o0 @SafeParcelable.e(id = 10) String str3) {
        this(i7, arrayList, account, z7, z8, z9, str, str2, s1(arrayList2), str3);
    }

    private GoogleSignInOptions(int i7, ArrayList<Scope> arrayList, @o0 Account account, boolean z7, boolean z8, boolean z9, @o0 String str, @o0 String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @o0 String str3) {
        this.f14964a = i7;
        this.f14965b = arrayList;
        this.f14966c = account;
        this.f14967d = z7;
        this.f14968e = z8;
        this.f14969f = z9;
        this.f14970g = str;
        this.f14971h = str2;
        this.f14972i = new ArrayList<>(map.values());
        this.f14974k = map;
        this.f14973j = str3;
    }
}
