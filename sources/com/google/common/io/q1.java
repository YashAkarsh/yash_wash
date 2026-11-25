package com.google.common.io;

import com.google.common.collect.d7;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.graph.s0<Path> f22006a = new a();

    static class a implements com.google.common.graph.s0<Path> {
        a() {
        }

        public Iterable<Path> G(Path path) {
            return q1.r(path);
        }

        @Override // com.google.common.graph.s0
        public /* bridge */ /* synthetic */ Iterable<? extends Path> b(Path path) {
            return G(k0.a(path));
        }
    }

    static class b implements com.google.common.base.g0<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkOption[] f22007a;

        b(LinkOption[] linkOptionArr) {
            this.f22007a = linkOptionArr;
        }

        public boolean a(Path path) {
            return Files.isDirectory(path, this.f22007a);
        }

        @Override // com.google.common.base.g0
        public /* bridge */ /* synthetic */ boolean apply(Path path) {
            return a(k0.a(path));
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return com.google.common.base.f0.a(this, obj);
        }

        public String toString() {
            return "MoreFiles.isDirectory(" + Arrays.toString(this.f22007a) + ")";
        }
    }

    static class c implements com.google.common.base.g0<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkOption[] f22008a;

        c(LinkOption[] linkOptionArr) {
            this.f22008a = linkOptionArr;
        }

        public boolean a(Path path) {
            return Files.isRegularFile(path, this.f22008a);
        }

        @Override // com.google.common.base.g0
        public /* bridge */ /* synthetic */ boolean apply(Path path) {
            return a(k0.a(path));
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return com.google.common.base.f0.a(this, obj);
        }

        public String toString() {
            return "MoreFiles.isRegularFile(" + Arrays.toString(this.f22008a) + ")";
        }
    }

    private static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f22009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OpenOption[] f22010b;

        /* synthetic */ d(Path path, OpenOption[] openOptionArr, a aVar) {
            this(path, openOptionArr);
        }

        @Override // com.google.common.io.f
        public OutputStream c() throws IOException {
            return Files.newOutputStream(this.f22009a, this.f22010b);
        }

        public String toString() {
            return "MoreFiles.asByteSink(" + this.f22009a + ", " + Arrays.toString(this.f22010b) + ")";
        }

        private d(Path path, OpenOption... openOptionArr) {
            this.f22009a = k0.a(com.google.common.base.e0.E(path));
            this.f22010b = (OpenOption[]) openOptionArr.clone();
        }
    }

    private static final class e extends g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final LinkOption[] f22011d = new LinkOption[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f22012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OpenOption[] f22013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f22014c;

        class a extends g.a {
            a(Charset charset) {
                super(charset);
            }

            @Override // com.google.common.io.p
            public Stream<String> o() throws IOException {
                return Files.lines(e.this.f22012a, this.f21970a);
            }
        }

        /* synthetic */ e(Path path, OpenOption[] openOptionArr, a aVar) {
            this(path, openOptionArr);
        }

        private static boolean u(OpenOption[] openOptionArr) {
            for (OpenOption openOption : openOptionArr) {
                if (openOption == LinkOption.NOFOLLOW_LINKS) {
                    return false;
                }
            }
            return true;
        }

        private BasicFileAttributes v() throws IOException {
            return Files.readAttributes(this.f22012a, BasicFileAttributes.class, this.f22014c ? f22011d : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }

        @Override // com.google.common.io.g
        public p a(Charset charset) {
            return this.f22013b.length == 0 ? new a(charset) : super.a(charset);
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return Files.newInputStream(this.f22012a, this.f22013b);
        }

        @Override // com.google.common.io.g
        public byte[] o() throws IOException {
            SeekableByteChannel seekableByteChannelNewByteChannel = Files.newByteChannel(this.f22012a, this.f22013b);
            try {
                byte[] bArrV = h.v(Channels.newInputStream(seekableByteChannelNewByteChannel), seekableByteChannelNewByteChannel.size());
                if (seekableByteChannelNewByteChannel != null) {
                    seekableByteChannelNewByteChannel.close();
                }
                return bArrV;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (seekableByteChannelNewByteChannel != null) {
                        try {
                            seekableByteChannelNewByteChannel.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // com.google.common.io.g
        public long p() throws IOException {
            BasicFileAttributes basicFileAttributesV = v();
            if (basicFileAttributesV.isDirectory()) {
                throw new IOException("can't read: is a directory");
            }
            if (basicFileAttributesV.isSymbolicLink()) {
                throw new IOException("can't read: is a symbolic link");
            }
            return basicFileAttributesV.size();
        }

        @Override // com.google.common.io.g
        public com.google.common.base.a0<Long> q() {
            try {
                BasicFileAttributes basicFileAttributesV = v();
                return (basicFileAttributesV.isDirectory() || basicFileAttributesV.isSymbolicLink()) ? com.google.common.base.a0.a() : com.google.common.base.a0.g(Long.valueOf(basicFileAttributesV.size()));
            } catch (IOException unused) {
                return com.google.common.base.a0.a();
            }
        }

        public String toString() {
            return "MoreFiles.asByteSource(" + this.f22012a + ", " + Arrays.toString(this.f22013b) + ")";
        }

        private e(Path path, OpenOption... openOptionArr) {
            this.f22012a = k0.a(com.google.common.base.e0.E(path));
            OpenOption[] openOptionArr2 = (OpenOption[]) openOptionArr.clone();
            this.f22013b = openOptionArr2;
            this.f22014c = u(openOptionArr2);
        }
    }

    private q1() {
    }

    public static void A(Path path) throws IOException {
        com.google.common.base.e0.E(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
        } catch (NoSuchFileException unused) {
            try {
                Files.createFile(path, new FileAttribute[0]);
            } catch (FileAlreadyExistsException unused2) {
            }
        }
    }

    private static Collection<IOException> b(Collection<IOException> collection, IOException iOException) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(iOException);
        return collection;
    }

    public static f c(Path path, OpenOption... openOptionArr) {
        return new d(path, openOptionArr, null);
    }

    public static g d(Path path, OpenOption... openOptionArr) {
        return new e(path, openOptionArr, null);
    }

    public static j e(Path path, Charset charset, OpenOption... openOptionArr) {
        return c(path, openOptionArr).a(charset);
    }

    public static p f(Path path, Charset charset, OpenOption... openOptionArr) {
        return d(path, openOptionArr).a(charset);
    }

    private static void g(Path path, f2[] f2VarArr) throws z {
        if (!Arrays.asList(f2VarArr).contains(f2.ALLOW_INSECURE)) {
            throw new z(path.toString());
        }
    }

    private static Collection<IOException> h(Collection<IOException> collection, Collection<IOException> collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 != null) {
            collection.addAll(collection2);
        }
        return collection;
    }

    public static void i(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path parent = path.toAbsolutePath().normalize().getParent();
        if (parent == null || Files.isDirectory(parent, new LinkOption[0])) {
            return;
        }
        Files.createDirectories(parent, fileAttributeArr);
        if (Files.isDirectory(parent, new LinkOption[0])) {
            return;
        }
        throw new IOException("Unable to create parent directories of " + path);
    }

    public static void j(Path path, f2... f2VarArr) throws IOException {
        Collection<IOException> collectionK;
        Collection<IOException> collection = null;
        try {
            DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            try {
                if (y0.a(directoryStreamNewDirectoryStream)) {
                    collectionK = l(z0.a(directoryStreamNewDirectoryStream));
                } else {
                    g(path, f2VarArr);
                    collectionK = k(directoryStreamNewDirectoryStream);
                }
                collection = collectionK;
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (directoryStreamNewDirectoryStream != null) {
                        try {
                            directoryStreamNewDirectoryStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e8) {
            if (0 == 0) {
                throw e8;
            }
            collection.add(e8);
        }
        if (collection != null) {
            z(path, collection);
        }
    }

    private static Collection<IOException> k(DirectoryStream<Path> directoryStream) {
        Collection<IOException> collectionH = null;
        try {
            Iterator it = directoryStream.iterator();
            while (it.hasNext()) {
                collectionH = h(collectionH, n(k0.a(it.next())));
            }
            return collectionH;
        } catch (DirectoryIteratorException e8) {
            return b(null, e8.getCause());
        }
    }

    private static Collection<IOException> l(SecureDirectoryStream<Path> secureDirectoryStream) {
        Collection<IOException> collectionH = null;
        try {
            Iterator it = secureDirectoryStream.iterator();
            while (it.hasNext()) {
                collectionH = h(collectionH, o(secureDirectoryStream, k0.a(it.next()).getFileName()));
            }
            return collectionH;
        } catch (DirectoryIteratorException e8) {
            return b(null, e8.getCause());
        }
    }

    public static void m(Path path, f2... f2VarArr) throws IOException {
        boolean z7;
        Path pathU = u(path);
        Collection<IOException> collectionN = null;
        if (pathU == null) {
            g1.a();
            throw f1.a(path.toString(), null, "can't delete recursively");
        }
        try {
            DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(pathU);
            try {
                if (y0.a(directoryStreamNewDirectoryStream)) {
                    collectionN = o(z0.a(directoryStreamNewDirectoryStream), path.getFileName());
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
                if (!z7) {
                    g(path, f2VarArr);
                    collectionN = n(path);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (directoryStreamNewDirectoryStream != null) {
                        try {
                            directoryStreamNewDirectoryStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e8) {
            if (collectionN == null) {
                throw e8;
            }
            collectionN.add(e8);
        }
        if (collectionN != null) {
            z(path, collectionN);
        }
    }

    private static Collection<IOException> n(Path path) {
        Collection<IOException> collectionK = null;
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
                try {
                    collectionK = k(directoryStreamNewDirectoryStream);
                    if (directoryStreamNewDirectoryStream != null) {
                        directoryStreamNewDirectoryStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (directoryStreamNewDirectoryStream != null) {
                            try {
                                directoryStreamNewDirectoryStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (collectionK == null) {
                Files.delete(path);
            }
            return collectionK;
        } catch (IOException e8) {
            return b(collectionK, e8);
        }
    }

    private static Collection<IOException> o(SecureDirectoryStream<Path> secureDirectoryStream, Path path) {
        Collection<IOException> collectionL = null;
        try {
            if (w(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                SecureDirectoryStream secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
                try {
                    collectionL = l(secureDirectoryStreamNewDirectoryStream);
                    if (secureDirectoryStreamNewDirectoryStream != null) {
                        secureDirectoryStreamNewDirectoryStream.close();
                    }
                    if (collectionL == null) {
                        secureDirectoryStream.deleteDirectory(path);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (secureDirectoryStreamNewDirectoryStream != null) {
                            try {
                                secureDirectoryStreamNewDirectoryStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                secureDirectoryStream.deleteFile(path);
            }
            return collectionL;
        } catch (IOException e8) {
            return b(collectionL, e8);
        }
    }

    public static boolean p(Path path, Path path2) throws IOException {
        com.google.common.base.e0.E(path);
        com.google.common.base.e0.E(path2);
        if (Files.isSameFile(path, path2)) {
            return true;
        }
        g gVarD = d(path, new OpenOption[0]);
        g gVarD2 = d(path2, new OpenOption[0]);
        long jLongValue = gVarD.q().j(0L).longValue();
        long jLongValue2 = gVarD2.q().j(0L).longValue();
        if (jLongValue == 0 || jLongValue2 == 0 || jLongValue == jLongValue2) {
            return gVarD.e(gVarD2);
        }
        return false;
    }

    public static com.google.common.graph.t0<Path> q() {
        return com.google.common.graph.t0.h(f22006a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Path> r(Path path) {
        if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            return d7.x();
        }
        try {
            return y(path);
        } catch (IOException e8) {
            i1.a();
            throw h1.a(e8);
        }
    }

    public static String s(Path path) {
        String string;
        int iLastIndexOf;
        Path fileName = path.getFileName();
        return (fileName == null || (iLastIndexOf = (string = fileName.toString()).lastIndexOf(46)) == -1) ? "" : string.substring(iLastIndexOf + 1);
    }

    public static String t(Path path) {
        Path fileName = path.getFileName();
        if (fileName == null) {
            return "";
        }
        String string = fileName.toString();
        int iLastIndexOf = string.lastIndexOf(46);
        return iLastIndexOf == -1 ? string : string.substring(0, iLastIndexOf);
    }

    private static Path u(Path path) {
        Path parent = path.getParent();
        if (parent != null) {
            return parent;
        }
        if (path.getNameCount() == 0) {
            return null;
        }
        return path.getFileSystem().getPath(com.alibaba.android.arouter.utils.b.f12515h, new String[0]);
    }

    public static com.google.common.base.g0<Path> v(LinkOption... linkOptionArr) {
        return new b((LinkOption[]) linkOptionArr.clone());
    }

    private static boolean w(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) throws IOException {
        return m1.a(secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, linkOptionArr)).readAttributes().isDirectory();
    }

    public static com.google.common.base.g0<Path> x(LinkOption... linkOptionArr) {
        return new c((LinkOption[]) linkOptionArr.clone());
    }

    public static d7<Path> y(Path path) throws IOException {
        try {
            DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            try {
                d7<Path> d7VarP = d7.p(directoryStreamNewDirectoryStream);
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
                return d7VarP;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (directoryStreamNewDirectoryStream != null) {
                        try {
                            directoryStreamNewDirectoryStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (DirectoryIteratorException e8) {
            throw e8.getCause();
        }
    }

    private static void z(Path path, Collection<IOException> collection) throws FileSystemException {
        g1.a();
        FileSystemException fileSystemExceptionA = f1.a(path.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        Iterator<IOException> it = collection.iterator();
        while (it.hasNext()) {
            fileSystemExceptionA.addSuppressed(it.next());
        }
        throw fileSystemExceptionA;
    }
}
