package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n extends p<JSONArray> {
    public n(int i7, String str, String str2, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        super(i7, str, str2, bVar, bVar2);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.p, com.haier.globalwasher.mvp_api.volley.n
    protected com.haier.globalwasher.mvp_api.volley.p<JSONArray> L(com.haier.globalwasher.mvp_api.volley.j jVar) {
        try {
            return com.haier.globalwasher.mvp_api.volley.p.c(new JSONArray(new String(jVar.f24843b, i.c(jVar.f24844c, "utf-8"))), i.a(jVar));
        } catch (UnsupportedEncodingException e8) {
            return com.haier.globalwasher.mvp_api.volley.p.a(new com.haier.globalwasher.mvp_api.volley.l(e8));
        } catch (JSONException e9) {
            return com.haier.globalwasher.mvp_api.volley.p.a(new com.haier.globalwasher.mvp_api.volley.l(e9));
        }
    }

    public n(String str, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        super(0, str, null, bVar, bVar2);
    }

    public n(int i7, String str, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        super(i7, str, null, bVar, bVar2);
    }

    public n(int i7, String str, JSONArray jSONArray, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        super(i7, str, jSONArray == null ? null : jSONArray.toString(), bVar, bVar2);
    }

    public n(int i7, String str, JSONObject jSONObject, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        super(i7, str, jSONObject == null ? null : jSONObject.toString(), bVar, bVar2);
    }

    public n(String str, JSONArray jSONArray, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        this(jSONArray == null ? 0 : 1, str, jSONArray, bVar, bVar2);
    }

    public n(String str, JSONObject jSONObject, com.haier.globalwasher.mvp_api.volley.p.b<JSONArray> bVar, com.haier.globalwasher.mvp_api.moudle.b<JSONArray> bVar2) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, bVar, bVar2);
    }
}
