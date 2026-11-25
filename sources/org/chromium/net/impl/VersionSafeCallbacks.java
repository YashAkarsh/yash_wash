package org.chromium.net.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.net.b0;
import org.chromium.net.c0;
import org.chromium.net.k0;
import org.chromium.net.q0;
import org.chromium.net.s0;
import org.chromium.net.t0;
import org.chromium.net.u0;

/* JADX INFO: loaded from: classes3.dex */
public class VersionSafeCallbacks {

    public static final class UrlRequestStatusListener extends t0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t0.d f39306a;

        public UrlRequestStatusListener(t0.d dVar) {
            this.f39306a = dVar;
        }

        @Override // org.chromium.net.t0.d
        public void a(int i7) {
            this.f39306a.a(i7);
        }
    }

    public static final class a extends org.chromium.net.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.chromium.net.d.b f39307a;

        public a(org.chromium.net.d.b bVar) {
            this.f39307a = bVar;
        }

        @Override // org.chromium.net.d.b
        public void a(org.chromium.net.d dVar, u0 u0Var) {
            this.f39307a.a(dVar, u0Var);
        }

        @Override // org.chromium.net.d.b
        public void b(org.chromium.net.d dVar, u0 u0Var, org.chromium.net.k kVar) {
            this.f39307a.b(dVar, u0Var, kVar);
        }

        @Override // org.chromium.net.d.b
        public void c(org.chromium.net.d dVar, u0 u0Var, ByteBuffer byteBuffer, boolean z7) {
            this.f39307a.c(dVar, u0Var, byteBuffer, z7);
        }

        @Override // org.chromium.net.d.b
        public void d(org.chromium.net.d dVar, u0 u0Var) {
            this.f39307a.d(dVar, u0Var);
        }

        @Override // org.chromium.net.d.b
        public void e(org.chromium.net.d dVar, u0 u0Var, u0.a aVar) {
            this.f39307a.e(dVar, u0Var, aVar);
        }

        @Override // org.chromium.net.d.b
        public void f(org.chromium.net.d dVar) {
            this.f39307a.f(dVar);
        }

        @Override // org.chromium.net.d.b
        public void g(org.chromium.net.d dVar, u0 u0Var) {
            this.f39307a.g(dVar, u0Var);
        }

        @Override // org.chromium.net.d.b
        public void h(org.chromium.net.d dVar, u0 u0Var, ByteBuffer byteBuffer, boolean z7) {
            this.f39307a.h(dVar, u0Var, byteBuffer, z7);
        }
    }

    public static final class b extends org.chromium.net.j.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.chromium.net.j.a.b f39308a;

        public b(org.chromium.net.j.a.b bVar) {
            this.f39308a = bVar;
        }

        @Override // org.chromium.net.j.a.b
        public void a(String str) {
            this.f39308a.a(str);
        }
    }

    public static final class c extends b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b0 f39309b;

        public c(b0 b0Var) {
            super(b0Var.a());
            this.f39309b = b0Var;
        }

        @Override // org.chromium.net.b0
        public Executor a() {
            return this.f39309b.a();
        }

        @Override // org.chromium.net.b0
        public void b(int i7, long j7, int i8) {
            this.f39309b.b(i7, j7, i8);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.f39309b.equals(((c) obj).f39309b);
        }

        public int hashCode() {
            return this.f39309b.hashCode();
        }
    }

    public static final class d extends c0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c0 f39310b;

        public d(c0 c0Var) {
            super(c0Var.a());
            this.f39310b = c0Var;
        }

        @Override // org.chromium.net.c0
        public Executor a() {
            return this.f39310b.a();
        }

        @Override // org.chromium.net.c0
        public void b(int i7, long j7, int i8) {
            this.f39310b.b(i7, j7, i8);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            return this.f39310b.equals(((d) obj).f39310b);
        }

        public int hashCode() {
            return this.f39310b.hashCode();
        }
    }

    public static final class e extends k0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k0.a f39311b;

        public e(k0.a aVar) {
            super(aVar.a());
            this.f39311b = aVar;
        }

        @Override // org.chromium.net.k0.a
        public Executor a() {
            return this.f39311b.a();
        }

        @Override // org.chromium.net.k0.a
        public void b(k0 k0Var) {
            this.f39311b.b(k0Var);
        }
    }

    public static final class f extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q0 f39312a;

        public f(q0 q0Var) {
            this.f39312a = q0Var;
        }

        @Override // org.chromium.net.q0
        public long b() throws IOException {
            return this.f39312a.b();
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) throws IOException {
            this.f39312a.c(s0Var, byteBuffer);
        }

        @Override // org.chromium.net.q0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f39312a.close();
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) throws IOException {
            this.f39312a.e(s0Var);
        }
    }

    public static final class g extends t0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t0.b f39313a;

        public g(t0.b bVar) {
            this.f39313a = bVar;
        }

        @Override // org.chromium.net.t0.b
        public void a(t0 t0Var, u0 u0Var) {
            this.f39313a.a(t0Var, u0Var);
        }

        @Override // org.chromium.net.t0.b
        public void b(t0 t0Var, u0 u0Var, org.chromium.net.k kVar) {
            this.f39313a.b(t0Var, u0Var, kVar);
        }

        @Override // org.chromium.net.t0.b
        public void c(t0 t0Var, u0 u0Var, ByteBuffer byteBuffer) throws Exception {
            this.f39313a.c(t0Var, u0Var, byteBuffer);
        }

        @Override // org.chromium.net.t0.b
        public void d(t0 t0Var, u0 u0Var, String str) throws Exception {
            this.f39313a.d(t0Var, u0Var, str);
        }

        @Override // org.chromium.net.t0.b
        public void e(t0 t0Var, u0 u0Var) throws Exception {
            this.f39313a.e(t0Var, u0Var);
        }

        @Override // org.chromium.net.t0.b
        public void f(t0 t0Var, u0 u0Var) {
            this.f39313a.f(t0Var, u0Var);
        }
    }
}
