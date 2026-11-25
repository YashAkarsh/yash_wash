package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes2.dex */
public class h extends r {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f32530p = "JsonHttpResponseHandler";

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Header[] f32533c;

        /* JADX INFO: renamed from: com.loopj.android.http.h$a$a, reason: collision with other inner class name */
        class RunnableC0395a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f32535a;

            RunnableC0395a(Object obj) {
                this.f32535a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj = this.f32535a;
                if (obj instanceof JSONObject) {
                    a aVar = a.this;
                    h.this.S(aVar.f32532b, aVar.f32533c, (JSONObject) obj);
                    return;
                }
                if (obj instanceof JSONArray) {
                    a aVar2 = a.this;
                    h.this.R(aVar2.f32532b, aVar2.f32533c, (JSONArray) obj);
                } else {
                    if (obj instanceof String) {
                        a aVar3 = a.this;
                        h.this.B(aVar3.f32532b, aVar3.f32533c, (String) obj);
                        return;
                    }
                    h.this.O(new JSONException("Unexpected type " + this.f32535a.getClass().getName()), null);
                }
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONException f32537a;

            b(JSONException jSONException) {
                this.f32537a = jSONException;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.O(this.f32537a, null);
            }
        }

        a(String str, int i7, Header[] headerArr) {
            this.f32531a = str;
            this.f32532b = i7;
            this.f32533c = headerArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.this.E(new RunnableC0395a(h.this.V(this.f32531a)));
            } catch (JSONException e8) {
                h.this.E(new b(e8));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Header[] f32541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Throwable f32542d;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f32544a;

            a(Object obj) {
                this.f32544a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj = this.f32544a;
                if (obj instanceof JSONObject) {
                    b bVar = b.this;
                    h.this.M(bVar.f32540b, bVar.f32541c, bVar.f32542d, (JSONObject) obj);
                    return;
                }
                if (obj instanceof JSONArray) {
                    b bVar2 = b.this;
                    h.this.L(bVar2.f32540b, bVar2.f32541c, bVar2.f32542d, (JSONArray) obj);
                } else {
                    if (obj instanceof String) {
                        b bVar3 = b.this;
                        h.this.s(bVar3.f32540b, bVar3.f32541c, bVar3.f32542d, (String) obj);
                        return;
                    }
                    h.this.O(new JSONException("Unexpected type " + this.f32544a.getClass().getName()), null);
                }
            }
        }

        /* JADX INFO: renamed from: com.loopj.android.http.h$b$b, reason: collision with other inner class name */
        class RunnableC0396b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONException f32546a;

            RunnableC0396b(JSONException jSONException) {
                this.f32546a = jSONException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                h.this.M(bVar.f32540b, bVar.f32541c, this.f32546a, null);
            }
        }

        b(String str, int i7, Header[] headerArr, Throwable th) {
            this.f32539a = str;
            this.f32540b = i7;
            this.f32541c = headerArr;
            this.f32542d = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.this.E(new a(h.this.V(this.f32539a)));
            } catch (JSONException e8) {
                h.this.E(new RunnableC0396b(e8));
            }
        }
    }

    public h() {
        super("UTF-8");
    }

    @Override // com.loopj.android.http.r, com.loopj.android.http.c
    public void B(int i7, Header[] headerArr, String str) {
        if (i7 != 204) {
            new Thread(new a(str, i7, headerArr)).start();
        } else {
            S(i7, headerArr, new JSONObject());
        }
    }

    @Override // com.loopj.android.http.r
    public void H(int i7, Header[] headerArr, String str, Throwable th) {
        if (str != null) {
            new Thread(new b(str, i7, headerArr, th)).start();
        } else {
            Log.v(f32530p, "response body is null, calling onFailure(Throwable, JSONObject)");
            M(i7, headerArr, th, null);
        }
    }

    public void J(int i7, Throwable th, JSONArray jSONArray) {
        N(th, jSONArray);
    }

    public void K(int i7, Throwable th, JSONObject jSONObject) {
        O(th, jSONObject);
    }

    public void L(int i7, Header[] headerArr, Throwable th, JSONArray jSONArray) {
        J(i7, th, jSONArray);
    }

    public void M(int i7, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        K(i7, th, jSONObject);
    }

    public void N(Throwable th, JSONArray jSONArray) {
        u(th);
    }

    public void O(Throwable th, JSONObject jSONObject) {
        u(th);
    }

    public void P(int i7, JSONArray jSONArray) {
        T(jSONArray);
    }

    public void Q(int i7, JSONObject jSONObject) {
        U(jSONObject);
    }

    public void R(int i7, Header[] headerArr, JSONArray jSONArray) {
        P(i7, jSONArray);
    }

    public void S(int i7, Header[] headerArr, JSONObject jSONObject) {
        Q(i7, jSONObject);
    }

    public void T(JSONArray jSONArray) {
    }

    public void U(JSONObject jSONObject) {
    }

    protected Object V(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        Object objNextValue = (strTrim.startsWith("{") || strTrim.startsWith("[")) ? new JSONTokener(strTrim).nextValue() : null;
        return objNextValue == null ? strTrim : objNextValue;
    }

    public h(String str) {
        super(str);
    }
}
