package com.haier.globalwasher.mvp_api.volley.myvolley;

import android.os.AsyncTask;
import com.haier.globalwasher.modle.utils.q;
import com.haier.uhome.account.okhttp.uAccountRequest;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends AsyncTask<String, Void, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f24879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24880b;

    public h(String... strArr) {
        this.f24879a = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(String... strArr) {
        MultipartEntity multipartEntity = new MultipartEntity();
        try {
            HttpPost httpPost = new HttpPost(this.f24879a[0]);
            multipartEntity.addPart("tokenId", new StringBody(this.f24879a[1]));
            multipartEntity.addPart("imageId", new StringBody(this.f24879a[2]));
            multipartEntity.addPart(y2.a.C, new StringBody(this.f24879a[3]));
            httpPost.setEntity(multipartEntity);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000000);
            HttpResponse httpResponseExecute = f.a().execute(httpPost);
            httpPost.setParams(basicHttpParams);
            if (!b(httpResponseExecute)) {
                return 3;
            }
            String string = EntityUtils.toString(httpResponseExecute.getEntity(), "UTF-8");
            q.a("requestPersonals", string + "\n");
            JSONObject jSONObject = new JSONObject(string);
            if (!jSONObject.getString(uAccountRequest.KEY_RET_CODE).equals("00000")) {
                return "10017".equals(Boolean.valueOf(jSONObject.getString(uAccountRequest.KEY_RET_CODE).equals("10017"))) ? 2 : 3;
            }
            jSONObject.getJSONObject("data");
            return 1;
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
            return 3;
        } catch (IOException e9) {
            e9.printStackTrace();
            return 3;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return 3;
        }
    }

    public boolean b(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        q.a("httpstatusCode", "http statusCode:" + statusCode);
        return statusCode > 199 && statusCode < 400;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (num.intValue() == 1) {
            return;
        }
        num.intValue();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
