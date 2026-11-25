package com.haier.library.sumhttp.response;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f28008d;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f28011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28012d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f28013e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f28014f;

        public String a() {
            return this.f28009a;
        }

        public String b() {
            return this.f28010b;
        }

        public long c() {
            return this.f28011c;
        }

        public String d() {
            return this.f28012d;
        }

        public String e() {
            return this.f28013e;
        }

        public String f() {
            return this.f28014f;
        }

        public void g(String str) {
            this.f28009a = str;
        }

        public void h(String str) {
            this.f28010b = str;
        }

        public void i(long j7) {
            this.f28011c = j7;
        }

        public void j(String str) {
            this.f28012d = str;
        }

        public void k(String str) {
            this.f28013e = str;
        }

        public void l(String str) {
            this.f28014f = str;
        }

        public String toString() {
            return "PayloadBean{accessId='" + this.f28009a + "', accessToken='" + this.f28010b + "', expireTime=" + this.f28011c + ", requestId='" + this.f28012d + "', serviceId='" + this.f28013e + "', tId='" + this.f28014f + "'}";
        }
    }

    public a f() {
        return this.f28008d;
    }

    public void g(a aVar) {
        this.f28008d = aVar;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "DeviceTempAccessResponse{payload=" + this.f28008d + '}';
    }
}
