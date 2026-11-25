package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f13419d;

    public e(int i7, String str, Object obj) {
        super(str, obj);
        this.f13418c = i7;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f13419d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f13419d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.a.a.f.a(this.f13419d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f13416a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.f13418c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            Objects.toString(this.f13417b);
            Object obj = this.f13417b;
            arrayList.add(new BasicNameValuePair("requestData", obj == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : com.alipay.a.a.f.a(obj)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e8) {
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.f13417b);
            sb2.append(":");
            sb2.append(e8);
            throw new RpcException(9, sb2.toString() == null ? "" : e8.getMessage(), e8);
        }
    }
}
