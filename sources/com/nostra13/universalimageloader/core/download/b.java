package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HttpClient f32782j;

    public b(Context context, HttpClient httpClient) {
        super(context);
        this.f32782j = httpClient;
    }

    @Override // com.nostra13.universalimageloader.core.download.a
    protected InputStream g(String str, Object obj) throws IOException {
        return new BufferedHttpEntity(this.f32782j.execute(new HttpGet(str)).getEntity()).getContent();
    }
}
