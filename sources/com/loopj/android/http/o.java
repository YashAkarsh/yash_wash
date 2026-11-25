package com.loopj.android.http;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public class o implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f32572c = 6374381828722046732L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient Cookie f32573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient BasicClientCookie f32574b;

    public o(Cookie cookie) {
        this.f32573a = cookie;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        BasicClientCookie basicClientCookie = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.f32574b = basicClientCookie;
        basicClientCookie.setComment((String) objectInputStream.readObject());
        this.f32574b.setDomain((String) objectInputStream.readObject());
        this.f32574b.setExpiryDate((Date) objectInputStream.readObject());
        this.f32574b.setPath((String) objectInputStream.readObject());
        this.f32574b.setVersion(objectInputStream.readInt());
        this.f32574b.setSecure(objectInputStream.readBoolean());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f32573a.getName());
        objectOutputStream.writeObject(this.f32573a.getValue());
        objectOutputStream.writeObject(this.f32573a.getComment());
        objectOutputStream.writeObject(this.f32573a.getDomain());
        objectOutputStream.writeObject(this.f32573a.getExpiryDate());
        objectOutputStream.writeObject(this.f32573a.getPath());
        objectOutputStream.writeInt(this.f32573a.getVersion());
        objectOutputStream.writeBoolean(this.f32573a.isSecure());
    }

    public Cookie a() {
        Cookie cookie = this.f32573a;
        BasicClientCookie basicClientCookie = this.f32574b;
        return basicClientCookie != null ? basicClientCookie : cookie;
    }
}
