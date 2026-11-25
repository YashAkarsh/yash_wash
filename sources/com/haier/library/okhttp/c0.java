package com.haier.library.okhttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f27512a = new a();

    static class a implements c0 {
        a() {
        }

        @Override // com.haier.library.okhttp.c0
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e8) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e8);
                throw unknownHostException;
            }
        }
    }

    List<InetAddress> a(String str) throws UnknownHostException;
}
