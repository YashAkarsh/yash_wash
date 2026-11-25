package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.j0;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements kotlin.sequences.m<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final File f34764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final l f34765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final i5.l<File, Boolean> f34766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private final i5.l<File, l2> f34767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private final i5.p<File, IOException, l2> f34768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f34769f;

    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@a7.d File rootDir) {
            super(rootDir);
            l0.p(rootDir, "rootDir");
        }
    }

    private final class b extends kotlin.collections.b<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        private final ArrayDeque<c> f34770c;

        private final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f34772b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @a7.e
            private File[] f34773c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f34774d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f34775e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f34776f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@a7.d b bVar, File rootDir) {
                super(rootDir);
                l0.p(rootDir, "rootDir");
                this.f34776f = bVar;
            }

            @Override // kotlin.io.k.c
            @a7.e
            public File b() {
                if (!this.f34775e && this.f34773c == null) {
                    i5.l lVar = k.this.f34766c;
                    boolean z7 = false;
                    if (lVar != null && !((Boolean) lVar.z(a())).booleanValue()) {
                        z7 = true;
                    }
                    if (z7) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.f34773c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        i5.p pVar = k.this.f34768e;
                        if (pVar != null) {
                            pVar.a0(a(), new kotlin.io.a(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f34775e = true;
                    }
                }
                File[] fileArr = this.f34773c;
                if (fileArr != null) {
                    int i7 = this.f34774d;
                    l0.m(fileArr);
                    if (i7 < fileArr.length) {
                        File[] fileArr2 = this.f34773c;
                        l0.m(fileArr2);
                        int i8 = this.f34774d;
                        this.f34774d = i8 + 1;
                        return fileArr2[i8];
                    }
                }
                if (!this.f34772b) {
                    this.f34772b = true;
                    return a();
                }
                i5.l lVar2 = k.this.f34767d;
                if (lVar2 != null) {
                    lVar2.z(a());
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: kotlin.io.k$b$b, reason: collision with other inner class name */
        private final class C0433b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f34777b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f34778c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0433b(@a7.d b bVar, File rootFile) {
                super(rootFile);
                l0.p(rootFile, "rootFile");
                this.f34778c = bVar;
            }

            @Override // kotlin.io.k.c
            @a7.e
            public File b() {
                if (this.f34777b) {
                    return null;
                }
                this.f34777b = true;
                return a();
            }
        }

        private final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f34779b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @a7.e
            private File[] f34780c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f34781d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f34782e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@a7.d b bVar, File rootDir) {
                super(rootDir);
                l0.p(rootDir, "rootDir");
                this.f34782e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // kotlin.io.k.c
            @a7.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f34779b
                    r1 = 0
                    if (r0 != 0) goto L2c
                    kotlin.io.k$b r0 = r10.f34782e
                    kotlin.io.k r0 = kotlin.io.k.this
                    i5.l r0 = kotlin.io.k.e(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.z(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = r3
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.f34779b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.f34780c
                    if (r0 == 0) goto L4b
                    int r2 = r10.f34781d
                    kotlin.jvm.internal.l0.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    kotlin.io.k$b r0 = r10.f34782e
                    kotlin.io.k r0 = kotlin.io.k.this
                    i5.l r0 = kotlin.io.k.g(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.a()
                    r0.z(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.f34780c
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f34780c = r0
                    if (r0 != 0) goto L7b
                    kotlin.io.k$b r0 = r10.f34782e
                    kotlin.io.k r0 = kotlin.io.k.this
                    i5.p r0 = kotlin.io.k.f(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.a()
                    kotlin.io.a r9 = new kotlin.io.a
                    java.io.File r4 = r10.a()
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r7 = 2
                    r8 = 0
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.a0(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.f34780c
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.l0.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    kotlin.io.k$b r0 = r10.f34782e
                    kotlin.io.k r0 = kotlin.io.k.this
                    i5.l r0 = kotlin.io.k.g(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.a()
                    r0.z(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.f34780c
                    kotlin.jvm.internal.l0.m(r0)
                    int r1 = r10.f34781d
                    int r2 = r1 + 1
                    r10.f34781d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.k.b.c.b():java.io.File");
            }
        }

        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f34783a;

            static {
                int[] iArr = new int[l.values().length];
                iArr[l.TOP_DOWN.ordinal()] = 1;
                iArr[l.BOTTOM_UP.ordinal()] = 2;
                f34783a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f34770c = arrayDeque;
            if (k.this.f34764a.isDirectory()) {
                arrayDeque.push(f(k.this.f34764a));
            } else if (k.this.f34764a.isFile()) {
                arrayDeque.push(new C0433b(this, k.this.f34764a));
            } else {
                b();
            }
        }

        private final a f(File file) {
            int i7 = d.f34783a[k.this.f34765b.ordinal()];
            if (i7 == 1) {
                return new c(this, file);
            }
            if (i7 == 2) {
                return new a(this, file);
            }
            throw new j0();
        }

        private final File g() {
            while (true) {
                c cVarPeek = this.f34770c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                File fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f34770c.pop();
                } else {
                    if (l0.g(fileB, cVarPeek.a()) || !fileB.isDirectory() || this.f34770c.size() >= k.this.f34769f) {
                        return fileB;
                    }
                    this.f34770c.push(f(fileB));
                }
            }
        }

        @Override // kotlin.collections.b
        protected void a() {
            File fileG = g();
            if (fileG != null) {
                d(fileG);
            } else {
                b();
            }
        }
    }

    private static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final File f34784a;

        public c(@a7.d File root) {
            l0.p(root, "root");
            this.f34784a = root;
        }

        @a7.d
        public final File a() {
            return this.f34784a;
        }

        @a7.e
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k(File file, l lVar, i5.l<? super File, Boolean> lVar2, i5.l<? super File, l2> lVar3, i5.p<? super File, ? super IOException, l2> pVar, int i7) {
        this.f34764a = file;
        this.f34765b = lVar;
        this.f34766c = lVar2;
        this.f34767d = lVar3;
        this.f34768e = pVar;
        this.f34769f = i7;
    }

    @a7.d
    public final k i(int i7) {
        if (i7 > 0) {
            return new k(this.f34764a, this.f34765b, this.f34766c, this.f34767d, this.f34768e, i7);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<File> iterator() {
        return new b();
    }

    @a7.d
    public final k j(@a7.d i5.l<? super File, Boolean> function) {
        l0.p(function, "function");
        return new k(this.f34764a, this.f34765b, function, this.f34767d, this.f34768e, this.f34769f);
    }

    @a7.d
    public final k k(@a7.d i5.p<? super File, ? super IOException, l2> function) {
        l0.p(function, "function");
        return new k(this.f34764a, this.f34765b, this.f34766c, this.f34767d, function, this.f34769f);
    }

    @a7.d
    public final k l(@a7.d i5.l<? super File, l2> function) {
        l0.p(function, "function");
        return new k(this.f34764a, this.f34765b, this.f34766c, function, this.f34768e, this.f34769f);
    }

    /* synthetic */ k(File file, l lVar, i5.l lVar2, i5.l lVar3, i5.p pVar, int i7, int i8, kotlin.jvm.internal.w wVar) {
        this(file, (i8 & 2) != 0 ? l.TOP_DOWN : lVar, lVar2, lVar3, pVar, (i8 & 32) != 0 ? Integer.MAX_VALUE : i7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@a7.d File start, @a7.d l direction) {
        this(start, direction, null, null, null, 0, 32, null);
        l0.p(start, "start");
        l0.p(direction, "direction");
    }

    public /* synthetic */ k(File file, l lVar, int i7, kotlin.jvm.internal.w wVar) {
        this(file, (i7 & 2) != 0 ? l.TOP_DOWN : lVar);
    }
}
