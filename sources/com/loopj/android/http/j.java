package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

/* JADX INFO: loaded from: classes2.dex */
public class j implements CookieStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f32550c = "CookiePrefsFile";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f32551d = "names";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f32552e = "cookie_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Cookie> f32553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f32554b;

    public j(Context context) {
        Cookie cookieB;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f32550c, 0);
        this.f32554b = sharedPreferences;
        this.f32553a = new ConcurrentHashMap<>();
        String string = sharedPreferences.getString(f32551d, null);
        if (string != null) {
            for (String str : TextUtils.split(string, ",")) {
                String string2 = this.f32554b.getString(f32552e + str, null);
                if (string2 != null && (cookieB = b(string2)) != null) {
                    this.f32553a.put(str, cookieB);
                }
            }
            clearExpired(new Date());
        }
    }

    protected String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b8 : bArr) {
            int i7 = b8 & 255;
            if (i7 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i7));
        }
        return sb.toString().toUpperCase();
    }

    @Override // org.apache.http.client.CookieStore
    public void addCookie(Cookie cookie) {
        String str = cookie.getName() + cookie.getDomain();
        if (cookie.isExpired(new Date())) {
            this.f32553a.remove(str);
        } else {
            this.f32553a.put(str, cookie);
        }
        SharedPreferences.Editor editorEdit = this.f32554b.edit();
        editorEdit.putString(f32551d, TextUtils.join(",", this.f32553a.keySet()));
        editorEdit.putString(f32552e + str, c(new o(cookie)));
        editorEdit.commit();
    }

    protected Cookie b(String str) {
        try {
            return ((o) new ObjectInputStream(new ByteArrayInputStream(d(str))).readObject()).a();
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    protected String c(o oVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(oVar);
            return a(byteArrayOutputStream.toByteArray());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.apache.http.client.CookieStore
    public void clear() {
        SharedPreferences.Editor editorEdit = this.f32554b.edit();
        Iterator<String> it = this.f32553a.keySet().iterator();
        while (it.hasNext()) {
            editorEdit.remove(f32552e + it.next());
        }
        editorEdit.remove(f32551d);
        editorEdit.commit();
        this.f32553a.clear();
    }

    @Override // org.apache.http.client.CookieStore
    public boolean clearExpired(Date date) {
        SharedPreferences.Editor editorEdit = this.f32554b.edit();
        boolean z7 = false;
        for (Map.Entry<String, Cookie> entry : this.f32553a.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isExpired(date)) {
                this.f32553a.remove(key);
                editorEdit.remove(f32552e + key);
                z7 = true;
            }
        }
        if (z7) {
            editorEdit.putString(f32551d, TextUtils.join(",", this.f32553a.keySet()));
        }
        editorEdit.commit();
        return z7;
    }

    protected byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i7 = 0; i7 < length; i7 += 2) {
            bArr[i7 / 2] = (byte) ((Character.digit(str.charAt(i7), 16) << 4) + Character.digit(str.charAt(i7 + 1), 16));
        }
        return bArr;
    }

    @Override // org.apache.http.client.CookieStore
    public List<Cookie> getCookies() {
        return new ArrayList(this.f32553a.values());
    }
}
