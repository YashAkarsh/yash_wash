package l0;

import android.text.TextUtils;
import com.alipay.sdk.tid.d;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f37406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f37408c;

    public b(String str) {
        this.f37407b = str;
    }

    public static List<b> b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] strArrF = f(jSONObject.optString("name", ""));
        for (int i7 = 0; i7 < strArrF.length; i7++) {
            a aVarA = a.a(strArrF[i7]);
            if (aVarA != a.None) {
                b bVar = new b(strArrF[i7], aVarA);
                bVar.f37408c = d(strArrF[i7]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public static void c(b bVar) {
        String[] strArrG = bVar.g();
        if (strArrG.length == 3 && TextUtils.equals("tid", strArrG[0])) {
            d dVarA = d.a(m0.b.a().c());
            if (TextUtils.isEmpty(strArrG[1]) || TextUtils.isEmpty(strArrG[2])) {
                return;
            }
            dVarA.c(strArrG[1], strArrG[2]);
        }
    }

    private static String[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf(40);
        int iLastIndexOf = str.lastIndexOf(41);
        if (iIndexOf == -1 || iLastIndexOf == -1 || iLastIndexOf <= iIndexOf) {
            return null;
        }
        for (String str2 : str.substring(iIndexOf + 1, iLastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String[] f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(j.f13806b);
    }

    public String a() {
        return this.f37407b;
    }

    public a e() {
        return this.f37406a;
    }

    public String[] g() {
        return this.f37408c;
    }

    public b(String str, a aVar) {
        this.f37407b = str;
        this.f37406a = aVar;
    }
}
