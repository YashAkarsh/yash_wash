package androidx.test.internal.runner;

import c.g1;
import com.alibaba.android.arouter.utils.b;
import dalvik.system.DexFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@g1(otherwise = 3)
public class ClassPathScanner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f9933a;

    public static class AcceptAllFilter implements ClassNameFilter {
        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String className) {
            return true;
        }
    }

    public static class ChainedClassNameFilter implements ClassNameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<ClassNameFilter> f9934a = new ArrayList();

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String className) {
            Iterator<ClassNameFilter> it = this.f9934a.iterator();
            while (it.hasNext()) {
                if (!it.next().a(className)) {
                    return false;
                }
            }
            return true;
        }

        public void b(ClassNameFilter filter) {
            this.f9934a.add(filter);
        }

        public void c(ClassNameFilter... filters) {
            this.f9934a.addAll(Arrays.asList(filters));
        }
    }

    public interface ClassNameFilter {
        boolean a(String className);
    }

    static class ExcludeClassNamesFilter implements ClassNameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Set<String> f9935a;

        public ExcludeClassNamesFilter(Set<String> excludedClassNames) {
            this.f9935a = excludedClassNames;
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String className) {
            return !this.f9935a.contains(className);
        }
    }

    public static class ExcludePackageNameFilter implements ClassNameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9936a;

        ExcludePackageNameFilter(String pkgName) {
            if (pkgName.endsWith(b.f12515h)) {
                this.f9936a = pkgName;
            } else {
                this.f9936a = String.format("%s.", pkgName);
            }
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String pathName) {
            return !pathName.startsWith(this.f9936a);
        }
    }

    public static class ExternalClassNameFilter implements ClassNameFilter {
        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String pathName) {
            return !pathName.contains("$");
        }
    }

    public static class InclusivePackageNamesFilter implements ClassNameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<String> f9937a;

        InclusivePackageNamesFilter(Collection<String> pkgNames) {
            this.f9937a = new ArrayList(pkgNames.size());
            for (String str : pkgNames) {
                if (str.endsWith(b.f12515h)) {
                    this.f9937a.add(str);
                } else {
                    this.f9937a.add(String.format("%s.", str));
                }
            }
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean a(String pathName) {
            Iterator<String> it = this.f9937a.iterator();
            while (it.hasNext()) {
                if (pathName.startsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public ClassPathScanner(String... paths) {
        this(Arrays.asList(paths));
    }

    private void a(Set<String> entryNames, String path, ClassNameFilter filter) throws Throwable {
        DexFile dexFile = null;
        try {
            DexFile dexFile2 = new DexFile(path);
            try {
                Enumeration<String> enumerationC = c(dexFile2);
                while (enumerationC.hasMoreElements()) {
                    String strNextElement = enumerationC.nextElement();
                    if (filter.a(strNextElement)) {
                        entryNames.add(strNextElement);
                    }
                }
                dexFile2.close();
            } catch (Throwable th) {
                th = th;
                dexFile = dexFile2;
                if (dexFile != null) {
                    dexFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Set<String> b(ClassNameFilter filter) throws Throwable {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = this.f9933a.iterator();
        while (it.hasNext()) {
            a(linkedHashSet, it.next(), filter);
        }
        return linkedHashSet;
    }

    @g1
    Enumeration<String> c(DexFile dexFile) {
        return dexFile.entries();
    }

    public ClassPathScanner(Collection<String> paths) {
        HashSet hashSet = new HashSet();
        this.f9933a = hashSet;
        hashSet.addAll(paths);
    }
}
