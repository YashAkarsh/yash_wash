package com.haier.library.okhttp.api;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class g extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f26923b = {"TLSv1.2", "TLSv1.1"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f26924a;

    public g(SSLSocketFactory sSLSocketFactory) {
        this.f26924a = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        try {
            if (socket instanceof SSLSocket) {
                ((SSLSocket) socket).setEnabledProtocols(f26923b);
            }
        } catch (Exception e8) {
            Log.i("Tls12SocketFactory", "try support TLSv1.2 fail!!");
            e8.printStackTrace();
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i7, boolean z7) throws IOException {
        return a(this.f26924a.createSocket(socket, str, i7, z7));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f26924a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f26924a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i7) throws IOException {
        return a(this.f26924a.createSocket(str, i7));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i7, InetAddress inetAddress, int i8) throws IOException {
        return a(this.f26924a.createSocket(str, i7, inetAddress, i8));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i7) throws IOException {
        return a(this.f26924a.createSocket(inetAddress, i7));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i7, InetAddress inetAddress2, int i8) throws IOException {
        return a(this.f26924a.createSocket(inetAddress, i7, inetAddress2, i8));
    }
}
