package kotlin.io.path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a1;
import kotlin.b1;
import kotlin.g1;
import kotlin.l2;
import kotlin.q2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
class z0 extends o {
    private static final String A0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return path.toString();
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    public static /* synthetic */ void B0(Path path) {
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Set<PosixFilePermission> C0(Path path, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(posixFilePermissions, "getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean D0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean E0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.isExecutable(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean F0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.isHidden(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean G0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.isReadable(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path H(String path) {
        kotlin.jvm.internal.l0.p(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        kotlin.jvm.internal.l0.o(path2, "get(path)");
        return path2;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean H0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path I(String base, String... subpaths) {
        kotlin.jvm.internal.l0.p(base, "base");
        kotlin.jvm.internal.l0.p(subpaths, "subpaths");
        Path path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        kotlin.jvm.internal.l0.o(path, "get(base, *subpaths)");
        return path;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean I0(Path path, Path other) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Files.isSameFile(path, other);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path J(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Path absolutePath = path.toAbsolutePath();
        kotlin.jvm.internal.l0.o(absolutePath, "toAbsolutePath()");
        return absolutePath;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean J0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final String K(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean K0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.isWritable(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path L(Path path, Path target, boolean z7) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        CopyOption[] copyOptionArr = z7 ? new CopyOption[]{l0.a(StandardCopyOption.REPLACE_EXISTING)} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.l0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    @g1(version = "1.5")
    @a7.d
    @q2(markerClass = {a.class})
    public static final List<Path> L0(@a7.d Path path, @a7.d String glob) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(glob, "glob");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = v0.a(directoryStreamNewDirectoryStream);
            kotlin.jvm.internal.l0.o(it, "it");
            List<Path> listQ5 = kotlin.collections.g0.Q5(it);
            kotlin.io.c.a(directoryStreamNewDirectoryStream, null);
            return listQ5;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(directoryStreamNewDirectoryStream, th);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path M(Path path, Path target, CopyOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    public static /* synthetic */ List M0(Path path, String str, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            str = "*";
        }
        return L0(path, str);
    }

    static /* synthetic */ Path N(Path path, Path target, boolean z7, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        CopyOption[] copyOptionArr = z7 ? new CopyOption[]{l0.a(StandardCopyOption.REPLACE_EXISTING)} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.l0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path N0(Path path, Path target, boolean z7) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        CopyOption[] copyOptionArr = z7 ? new CopyOption[]{l0.a(StandardCopyOption.REPLACE_EXISTING)} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.l0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path O(Path path, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateDirectories, "createDirectories(this, *attributes)");
        return pathCreateDirectories;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path O0(Path path, Path target, CopyOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path P(Path path, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateDirectory, "createDirectory(this, *attributes)");
        return pathCreateDirectory;
    }

    static /* synthetic */ Path P0(Path path, Path target, boolean z7, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        CopyOption[] copyOptionArr = z7 ? new CopyOption[]{l0.a(StandardCopyOption.REPLACE_EXISTING)} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        kotlin.jvm.internal.l0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path Q(Path path, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateFile, "createFile(this, *attributes)");
        return pathCreateFile;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean Q0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path R(Path path, Path target) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        Path pathCreateLink = Files.createLink(path, target);
        kotlin.jvm.internal.l0.o(pathCreateLink, "createLink(this, target)");
        return pathCreateLink;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final /* synthetic */ <A extends BasicFileAttributes> A R0(Path path, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        kotlin.jvm.internal.l0.y(4, "A");
        BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(attributes, "readAttributes(this, A::class.java, *options)");
        return (A) p.a(attributes);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path S(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(target, "target");
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateSymbolicLink, "createSymbolicLink(this, target, *attributes)");
        return pathCreateSymbolicLink;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Map<String, Object> S0(Path path, String attributes, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        kotlin.jvm.internal.l0.p(options, "options");
        Map<String, Object> attributes2 = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(attributes2, "readAttributes(this, attributes, *options)");
        return attributes2;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path T(String str, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempDirectory, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path T0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Path symbolicLink = Files.readSymbolicLink(path);
        kotlin.jvm.internal.l0.o(symbolicLink, "readSymbolicLink(this)");
        return symbolicLink;
    }

    @g1(version = "1.5")
    @a7.d
    @q2(markerClass = {a.class})
    public static final Path U(@a7.e Path path, @a7.e String str, @a7.d FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.l0.o(pathCreateTempDirectory, "createTempDirectory(dire…ory, prefix, *attributes)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempDirectory2, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory2;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static final Path U0(@a7.d Path path, @a7.d Path base) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(base, "base");
        try {
            return f.f34789a.a(path, base);
        } catch (IllegalArgumentException e8) {
            throw new IllegalArgumentException(((Object) e8.getMessage()) + "\nthis path: " + path + "\nbase path: " + base, e8);
        }
    }

    static /* synthetic */ Path V(String str, FileAttribute[] attributes, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            str = null;
        }
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempDirectory, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @a7.e
    public static final Path V0(@a7.d Path path, @a7.d Path base) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(base, "base");
        try {
            return f.f34789a.a(path, base);
        } catch (IllegalArgumentException unused) {
            return com.google.common.io.k0.a(null);
        }
    }

    public static /* synthetic */ Path W(Path path, String str, FileAttribute[] fileAttributeArr, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            str = null;
        }
        return U(path, str, fileAttributeArr);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static final Path W0(@a7.d Path path, @a7.d Path base) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(base, "base");
        Path pathV0 = V0(path, base);
        return pathV0 == null ? path : pathV0;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path X(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempFile, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path X0(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attribute, "attribute");
        kotlin.jvm.internal.l0.p(options, "options");
        Path attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(attribute2, "setAttribute(this, attribute, value, *options)");
        return attribute2;
    }

    @g1(version = "1.5")
    @a7.d
    @q2(markerClass = {a.class})
    public static final Path Y(@a7.e Path path, @a7.e String str, @a7.e String str2, @a7.d FileAttribute<?>... attributes) throws IOException {
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            kotlin.jvm.internal.l0.o(pathCreateTempFile, "createTempFile(directory…fix, suffix, *attributes)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempFile2, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile2;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path Y0(Path path, FileTime value) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime(path, value);
        kotlin.jvm.internal.l0.o(lastModifiedTime, "setLastModifiedTime(this, value)");
        return lastModifiedTime;
    }

    static /* synthetic */ Path Z(String str, String str2, FileAttribute[] attributes, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            str2 = null;
        }
        kotlin.jvm.internal.l0.p(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        kotlin.jvm.internal.l0.o(pathCreateTempFile, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path Z0(Path path, UserPrincipal value) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(value, "value");
        Path owner = Files.setOwner(path, value);
        kotlin.jvm.internal.l0.o(owner, "setOwner(this, value)");
        return owner;
    }

    public static /* synthetic */ Path a0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            str = null;
        }
        if ((i7 & 4) != 0) {
            str2 = null;
        }
        return Y(path, str, str2, fileAttributeArr);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path a1(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(value, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, value);
        kotlin.jvm.internal.l0.o(posixFilePermissions, "setPosixFilePermissions(this, value)");
        return posixFilePermissions;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final void b0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Files.delete(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path b1(URI uri) {
        kotlin.jvm.internal.l0.p(uri, "<this>");
        Path path = Paths.get(uri);
        kotlin.jvm.internal.l0.o(path, "get(this)");
        return path;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean c0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final <T> T c1(Path path, String glob, i5.l<? super kotlin.sequences.m<? extends Path>, ? extends T> block) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(glob, "glob");
        kotlin.jvm.internal.l0.p(block, "block");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = v0.a(directoryStreamNewDirectoryStream);
            kotlin.jvm.internal.l0.o(it, "it");
            T tZ = block.z(kotlin.collections.g0.v1(it));
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(directoryStreamNewDirectoryStream, null);
            kotlin.jvm.internal.i0.c(1);
            return tZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(directoryStreamNewDirectoryStream, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path d0(Path path, String other) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Path pathResolve = path.resolve(other);
        kotlin.jvm.internal.l0.o(pathResolve, "this.resolve(other)");
        return pathResolve;
    }

    static /* synthetic */ Object d1(Path path, String glob, i5.l block, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(glob, "glob");
        kotlin.jvm.internal.l0.p(block, "block");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = v0.a(directoryStreamNewDirectoryStream);
            kotlin.jvm.internal.l0.o(it, "it");
            Object objZ = block.z(kotlin.collections.g0.v1(it));
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(directoryStreamNewDirectoryStream, null);
            kotlin.jvm.internal.i0.c(1);
            return objZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(directoryStreamNewDirectoryStream, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path e0(Path path, Path other) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Path pathResolve = path.resolve(other);
        kotlin.jvm.internal.l0.o(pathResolve, "this.resolve(other)");
        return pathResolve;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final boolean f0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @a7.d
    @a1
    public static final Void g0(@a7.d Path path, @a7.d Class<?> attributeViewClass) {
        kotlin.jvm.internal.l0.p(path, "path");
        kotlin.jvm.internal.l0.p(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final /* synthetic */ <V extends FileAttributeView> V h0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        kotlin.jvm.internal.l0.y(4, "V");
        FileAttributeView fileAttributeView = Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        if (fileAttributeView != null) {
            return (V) g0.a(fileAttributeView);
        }
        kotlin.jvm.internal.l0.y(4, "V");
        g0(path, FileAttributeView.class);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final /* synthetic */ <V extends FileAttributeView> V i0(Path path, LinkOption... options) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        kotlin.jvm.internal.l0.y(4, "V");
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final long j0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return Files.size(path);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final FileStore k0(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        FileStore fileStore = Files.getFileStore(path);
        kotlin.jvm.internal.l0.o(fileStore, "getFileStore(this)");
        return fileStore;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final void l0(Path path, String glob, i5.l<? super Path, l2> action) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(glob, "glob");
        kotlin.jvm.internal.l0.p(action, "action");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = v0.a(directoryStreamNewDirectoryStream);
            kotlin.jvm.internal.l0.o(it, "it");
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                action.z(it2.next());
            }
            l2 l2Var = l2.f34958a;
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(directoryStreamNewDirectoryStream, null);
            kotlin.jvm.internal.i0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(directoryStreamNewDirectoryStream, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ void m0(Path path, String glob, i5.l action, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            glob = "*";
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(glob, "glob");
        kotlin.jvm.internal.l0.p(action, "action");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = v0.a(directoryStreamNewDirectoryStream);
            kotlin.jvm.internal.l0.o(it, "it");
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                action.z(it2.next());
            }
            l2 l2Var = l2.f34958a;
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(directoryStreamNewDirectoryStream, null);
            kotlin.jvm.internal.i0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(directoryStreamNewDirectoryStream, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Object n0(Path path, String attribute, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(attribute, "attribute");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @a7.d
    public static final String o0(@a7.d Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Path fileName = path.getFileName();
        return fileName == null ? "" : kotlin.text.c0.q5(fileName.toString(), ClassUtils.PACKAGE_SEPARATOR_CHAR, "");
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static /* synthetic */ void p0(Path path) {
    }

    private static final String q0(Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        return s0(path);
    }

    @g1(version = "1.4")
    @kotlin.k(level = kotlin.m.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @b1(expression = "invariantSeparatorsPathString", imports = {}))
    @a
    @kotlin.internal.f
    public static /* synthetic */ void r0(Path path) {
    }

    @a7.d
    public static final String s0(@a7.d Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        String separator = path.getFileSystem().getSeparator();
        if (kotlin.jvm.internal.l0.g(separator, "/")) {
            return path.toString();
        }
        String string = path.toString();
        kotlin.jvm.internal.l0.o(separator, "separator");
        return kotlin.text.b0.k2(string, separator, "/", false, 4, null);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static /* synthetic */ void t0(Path path) {
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final FileTime u0(Path path, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(lastModifiedTime, "getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }

    @a7.d
    public static final String v0(@a7.d Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName == null ? null : fileName.toString();
        return string == null ? "" : string;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static /* synthetic */ void w0(Path path) {
    }

    @a7.d
    public static final String x0(@a7.d Path path) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Path fileName = path.getFileName();
        return fileName == null ? "" : kotlin.text.c0.B5(fileName.toString(), com.alibaba.android.arouter.utils.b.f12515h, null, 2, null);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static /* synthetic */ void y0(Path path) {
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final UserPrincipal z0(Path path, LinkOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }
}
