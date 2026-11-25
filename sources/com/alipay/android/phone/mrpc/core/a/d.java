package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.util.m;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.f13415b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i7 = jSONObject.getInt(m.f13816a);
            if (i7 == 1000) {
                return this.f13414a == String.class ? jSONObject.optString(m.f13818c) : com.alipay.a.a.e.b(jSONObject.optString(m.f13818c), this.f13414a);
            }
            throw new RpcException(Integer.valueOf(i7), jSONObject.optString("tips"));
        } catch (Exception e8) {
            StringBuilder sb = new StringBuilder("response  =");
            sb.append(new String(this.f13415b));
            sb.append(":");
            sb.append(e8);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e8.getMessage());
        }
    }
}
