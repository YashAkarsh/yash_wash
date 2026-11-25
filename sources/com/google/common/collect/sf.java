package com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
final class sf {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f21072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f21073d;

        static enum a extends b {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.b
            int a(int i7) {
                return i7 - 1;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.sf$b$b, reason: collision with other inner class name */
        static enum C0252b extends b {
            C0252b(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.b
            public int a(int i7) {
                return i7;
            }
        }

        static enum c extends b {
            c(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.b
            public int a(int i7) {
                return ~i7;
            }
        }

        static {
            a aVar = new a("NEXT_LOWER", 0);
            f21070a = aVar;
            C0252b c0252b = new C0252b("NEXT_HIGHER", 1);
            f21071b = c0252b;
            c cVar = new c("INVERTED_INSERTION_INDEX", 2);
            f21072c = cVar;
            f21073d = new b[]{aVar, c0252b, cVar};
        }

        private b(String str, int i7) {
            super(str, i7);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f21073d.clone();
        }

        abstract int a(int i7);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f21074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f21075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f21076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f21077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f21078e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ c[] f21079f;

        static enum a extends c {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.c
            <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7) {
                return i7;
            }
        }

        static enum b extends c {
            b(String str, int i7) {
                super(str, i7);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.sf.c
            <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7) {
                int size = list.size() - 1;
                while (i7 < size) {
                    int i8 = ((i7 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i8), e8) > 0) {
                        size = i8 - 1;
                    } else {
                        i7 = i8;
                    }
                }
                return i7;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.sf$c$c, reason: collision with other inner class name */
        static enum C0253c extends c {
            C0253c(String str, int i7) {
                super(str, i7);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.sf.c
            <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7) {
                int i8 = 0;
                while (i8 < i7) {
                    int i9 = (i8 + i7) >>> 1;
                    if (comparator.compare(list.get(i9), e8) < 0) {
                        i8 = i9 + 1;
                    } else {
                        i7 = i9;
                    }
                }
                return i8;
            }
        }

        static enum d extends c {
            d(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.c
            public <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7) {
                return c.f21075b.a(comparator, e8, list, i7) + 1;
            }
        }

        static enum e extends c {
            e(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.collect.sf.c
            public <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7) {
                return c.f21076c.a(comparator, e8, list, i7) - 1;
            }
        }

        static {
            a aVar = new a("ANY_PRESENT", 0);
            f21074a = aVar;
            b bVar = new b("LAST_PRESENT", 1);
            f21075b = bVar;
            C0253c c0253c = new C0253c("FIRST_PRESENT", 2);
            f21076c = c0253c;
            d dVar = new d("FIRST_AFTER", 3);
            f21077d = dVar;
            e eVar = new e("LAST_BEFORE", 4);
            f21078e = eVar;
            f21079f = new c[]{aVar, bVar, c0253c, dVar, eVar};
        }

        private c(String str, int i7) {
            super(str, i7);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f21079f.clone();
        }

        abstract <E> int a(Comparator<? super E> comparator, E e8, List<? extends E> list, int i7);
    }

    private sf() {
    }

    public static <E, K extends Comparable> int a(List<E> list, com.google.common.base.s<? super E, K> sVar, K k7, c cVar, b bVar) {
        return b(list, sVar, k7, td.A(), cVar, bVar);
    }

    public static <E, K> int b(List<E> list, com.google.common.base.s<? super E, K> sVar, K k7, Comparator<? super K> comparator, c cVar, b bVar) {
        return d(ib.D(list, sVar), k7, comparator, cVar, bVar);
    }

    public static <E extends Comparable> int c(List<? extends E> list, E e8, c cVar, b bVar) {
        com.google.common.base.e0.E(e8);
        return d(list, e8, td.A(), cVar, bVar);
    }

    public static <E> int d(List<? extends E> list, E e8, Comparator<? super E> comparator, c cVar, b bVar) {
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(list);
        com.google.common.base.e0.E(cVar);
        com.google.common.base.e0.E(bVar);
        if (!(list instanceof RandomAccess)) {
            list = ib.r(list);
        }
        int size = list.size() - 1;
        int i7 = 0;
        while (i7 <= size) {
            int i8 = (i7 + size) >>> 1;
            int iCompare = comparator.compare(e8, list.get(i8));
            if (iCompare < 0) {
                size = i8 - 1;
            } else {
                if (iCompare <= 0) {
                    return i7 + cVar.a(comparator, e8, list.subList(i7, size + 1), i8 - i7);
                }
                i7 = i8 + 1;
            }
        }
        return bVar.a(i7);
    }
}
