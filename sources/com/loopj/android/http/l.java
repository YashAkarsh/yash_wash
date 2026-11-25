package com.loopj.android.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f32556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ConcurrentHashMap<String, String> f32557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ConcurrentHashMap<String, c> f32558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ConcurrentHashMap<String, b> f32559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ConcurrentHashMap<String, Object> f32560e;

    class a extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32562b;

        a(String str, String str2) {
            this.f32561a = str;
            this.f32562b = str2;
            put(str, str2);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f32563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32564b;

        public b(File file, String str) {
            this.f32563a = file;
            this.f32564b = str;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f32565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f32567c;

        public c(InputStream inputStream, String str, String str2) {
            this.f32565a = inputStream;
            this.f32566b = str;
            this.f32567c = str2;
        }
    }

    public l() {
        this((Map<String, String>) null);
    }

    private HttpEntity b() {
        try {
            return new UrlEncodedFormEntity(f(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private HttpEntity c(m mVar) throws IOException {
        p pVar = new p(mVar);
        pVar.o(this.f32556a);
        for (Map.Entry<String, String> entry : this.f32557b.entrySet()) {
            pVar.i(entry.getKey(), entry.getValue());
        }
        for (BasicNameValuePair basicNameValuePair : g(null, this.f32560e)) {
            pVar.i(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
        for (Map.Entry<String, c> entry2 : this.f32558c.entrySet()) {
            c value = entry2.getValue();
            if (value.f32565a != null) {
                pVar.j(entry2.getKey(), value.f32566b, value.f32565a, value.f32567c);
            }
        }
        for (Map.Entry<String, b> entry3 : this.f32559d.entrySet()) {
            b value2 = entry3.getValue();
            pVar.h(entry3.getKey(), value2.f32563a, value2.f32564b);
        }
        return pVar;
    }

    private List<BasicNameValuePair> g(String str, Object obj) {
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (String str2 : arrayList) {
                Object obj2 = map.get(str2);
                if (obj2 != null) {
                    if (str != null) {
                        str2 = String.format("%s[%s]", str, str2);
                    }
                    linkedList.addAll(g(str2, obj2));
                }
            }
        } else if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                linkedList.addAll(g(String.format("%s[]", str), it.next()));
            }
        } else if (obj instanceof Object[]) {
            for (Object obj3 : (Object[]) obj) {
                linkedList.addAll(g(String.format("%s[]", str), obj3));
            }
        } else if (obj instanceof Set) {
            Iterator it2 = ((Set) obj).iterator();
            while (it2.hasNext()) {
                linkedList.addAll(g(str, it2.next()));
            }
        } else if (obj instanceof String) {
            linkedList.add(new BasicNameValuePair(str, (String) obj));
        }
        return linkedList;
    }

    private void h() {
        this.f32557b = new ConcurrentHashMap<>();
        this.f32558c = new ConcurrentHashMap<>();
        this.f32559d = new ConcurrentHashMap<>();
        this.f32560e = new ConcurrentHashMap<>();
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Object hashSet = this.f32560e.get(str);
        if (hashSet == null) {
            hashSet = new HashSet();
            n(str, hashSet);
        }
        if (hashSet instanceof List) {
            ((List) hashSet).add(str2);
        } else if (hashSet instanceof Set) {
            ((Set) hashSet).add(str2);
        }
    }

    public HttpEntity d(m mVar) throws IOException {
        return (this.f32558c.isEmpty() && this.f32559d.isEmpty()) ? b() : c(mVar);
    }

    protected String e() {
        return URLEncodedUtils.format(f(), "UTF-8");
    }

    protected List<BasicNameValuePair> f() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.f32557b.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(g(null, this.f32560e));
        return linkedList;
    }

    public void i(String str, File file) throws FileNotFoundException {
        j(str, file, null);
    }

    public void j(String str, File file, String str2) throws FileNotFoundException {
        if (str == null || file == null) {
            return;
        }
        this.f32559d.put(str, new b(file, str2));
    }

    public void k(String str, InputStream inputStream) {
        l(str, inputStream, null);
    }

    public void l(String str, InputStream inputStream, String str2) {
        m(str, inputStream, str2, null);
    }

    public void m(String str, InputStream inputStream, String str2, String str3) {
        if (str == null || inputStream == null) {
            return;
        }
        this.f32558c.put(str, new c(inputStream, str2, str3));
    }

    public void n(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f32560e.put(str, obj);
    }

    public void o(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f32557b.put(str, str2);
    }

    public void p(String str) {
        this.f32557b.remove(str);
        this.f32558c.remove(str);
        this.f32559d.remove(str);
        this.f32560e.remove(str);
    }

    public void q(boolean z7) {
        this.f32556a = z7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f32557b.entrySet()) {
            if (sb.length() > 0) {
                sb.append(m0.a.f37445e);
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, c> entry2 : this.f32558c.entrySet()) {
            if (sb.length() > 0) {
                sb.append(m0.a.f37445e);
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry<String, b> entry3 : this.f32559d.entrySet()) {
            if (sb.length() > 0) {
                sb.append(m0.a.f37445e);
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (BasicNameValuePair basicNameValuePair : g(null, this.f32560e)) {
            if (sb.length() > 0) {
                sb.append(m0.a.f37445e);
            }
            sb.append(basicNameValuePair.getName());
            sb.append("=");
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }

    public l(Map<String, String> map) {
        this.f32556a = false;
        h();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                o(entry.getKey(), entry.getValue());
            }
        }
    }

    public l(String str, String str2) {
        this(new a(str, str2));
    }

    public l(Object... objArr) {
        this.f32556a = false;
        h();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i7 = 0; i7 < length; i7 += 2) {
            o(String.valueOf(objArr[i7]), String.valueOf(objArr[i7 + 1]));
        }
    }
}
