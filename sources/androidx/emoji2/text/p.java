package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.r0;
import androidx.core.util.w;
import c.g1;
import c.m0;
import c.t0;
import c.x0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@c.d
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f7685e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7686f = "EmojiCompat.MetadataRepo.create";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final androidx.emoji2.text.flatbuffer.p f7687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final char[] f7688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final a f7689c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final Typeface f7690d;

    @x0({x0.a.LIBRARY})
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray<a> f7691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f7692b;

        private a() {
            this(1);
        }

        a a(int i7) {
            SparseArray<a> sparseArray = this.f7691a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i7);
        }

        final i b() {
            return this.f7692b;
        }

        void c(@m0 i iVar, int i7, int i8) {
            a aVarA = a(iVar.b(i7));
            if (aVarA == null) {
                aVarA = new a();
                this.f7691a.put(iVar.b(i7), aVarA);
            }
            if (i8 > i7) {
                aVarA.c(iVar, i7 + 1, i8);
            } else {
                aVarA.f7692b = iVar;
            }
        }

        a(int i7) {
            this.f7691a = new SparseArray<>(i7);
        }
    }

    private p(@m0 Typeface typeface, @m0 androidx.emoji2.text.flatbuffer.p pVar) {
        this.f7690d = typeface;
        this.f7687a = pVar;
        this.f7688b = new char[pVar.K() * 2];
        a(pVar);
    }

    private void a(androidx.emoji2.text.flatbuffer.p pVar) {
        int iK = pVar.K();
        for (int i7 = 0; i7 < iK; i7++) {
            i iVar = new i(this, i7);
            Character.toChars(iVar.g(), this.f7688b, i7 * 2);
            k(iVar);
        }
    }

    @m0
    public static p b(@m0 AssetManager assetManager, @m0 String str) throws IOException {
        try {
            r0.b(f7686f);
            return new p(Typeface.createFromAsset(assetManager, str), o.b(assetManager, str));
        } finally {
            r0.d();
        }
    }

    @x0({x0.a.TESTS})
    @m0
    public static p c(@m0 Typeface typeface) {
        try {
            r0.b(f7686f);
            return new p(typeface, new androidx.emoji2.text.flatbuffer.p());
        } finally {
            r0.d();
        }
    }

    @m0
    public static p d(@m0 Typeface typeface, @m0 InputStream inputStream) throws IOException {
        try {
            r0.b(f7686f);
            return new p(typeface, o.c(inputStream));
        } finally {
            r0.d();
        }
    }

    @m0
    public static p e(@m0 Typeface typeface, @m0 ByteBuffer byteBuffer) throws IOException {
        try {
            r0.b(f7686f);
            return new p(typeface, o.d(byteBuffer));
        } finally {
            r0.d();
        }
    }

    @x0({x0.a.LIBRARY})
    @m0
    public char[] f() {
        return this.f7688b;
    }

    @x0({x0.a.LIBRARY})
    @m0
    public androidx.emoji2.text.flatbuffer.p g() {
        return this.f7687a;
    }

    @x0({x0.a.LIBRARY})
    int h() {
        return this.f7687a.S();
    }

    @x0({x0.a.LIBRARY})
    @m0
    a i() {
        return this.f7689c;
    }

    @x0({x0.a.LIBRARY})
    @m0
    Typeface j() {
        return this.f7690d;
    }

    @x0({x0.a.LIBRARY})
    @g1
    void k(@m0 i iVar) {
        w.m(iVar, "emoji metadata cannot be null");
        w.b(iVar.c() > 0, "invalid metadata codepoint length");
        this.f7689c.c(iVar, 0, iVar.c() - 1);
    }
}
