package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j4 {

    public static final class a implements kotlin.sequences.m<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6630a;

        a(ViewGroup viewGroup) {
            this.f6630a = viewGroup;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<View> iterator() {
            return j4.k(this.f6630a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {118, 120}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
    static final class b extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super View>, kotlin.coroutines.d<? super kotlin.l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f6631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f6632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f6633e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f6634f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f6635g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f6636h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6637i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ViewGroup viewGroup, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f6637i = viewGroup;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<kotlin.l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(this.f6637i, dVar);
            bVar.f6636h = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x004e  */
        /* JADX WARN: Code duplicated, block: B:14:0x0069 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x006a  */
        /* JADX WARN: Code duplicated, block: B:18:0x0075  */
        /* JADX WARN: Code duplicated, block: B:20:0x008e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x008f  */
        /* JADX WARN: Code duplicated, block: B:23:0x0098  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008f -> B:22:0x0091). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0098 -> B:24:0x009c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r11.f6635g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3d
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                int r1 = r11.f6634f
                int r4 = r11.f6633e
                java.lang.Object r5 = r11.f6631c
                android.view.ViewGroup r5 = (android.view.ViewGroup) r5
                java.lang.Object r6 = r11.f6636h
                kotlin.sequences.o r6 = (kotlin.sequences.o) r6
                kotlin.e1.n(r12)
                r12 = r11
                goto L91
            L20:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L28:
                int r1 = r11.f6634f
                int r4 = r11.f6633e
                java.lang.Object r5 = r11.f6632d
                android.view.View r5 = (android.view.View) r5
                java.lang.Object r6 = r11.f6631c
                android.view.ViewGroup r6 = (android.view.ViewGroup) r6
                java.lang.Object r7 = r11.f6636h
                kotlin.sequences.o r7 = (kotlin.sequences.o) r7
                kotlin.e1.n(r12)
                r12 = r11
                goto L71
            L3d:
                kotlin.e1.n(r12)
                java.lang.Object r12 = r11.f6636h
                kotlin.sequences.o r12 = (kotlin.sequences.o) r12
                android.view.ViewGroup r1 = r11.f6637i
                int r4 = r1.getChildCount()
                r5 = 0
                r6 = r11
            L4c:
                if (r5 >= r4) goto La1
                android.view.View r7 = r1.getChildAt(r5)
                java.lang.String r8 = "getChildAt(index)"
                kotlin.jvm.internal.l0.o(r7, r8)
                r6.f6636h = r12
                r6.f6631c = r1
                r6.f6632d = r7
                r6.f6633e = r5
                r6.f6634f = r4
                r6.f6635g = r3
                java.lang.Object r8 = r12.a(r7, r6)
                if (r8 != r0) goto L6a
                return r0
            L6a:
                r9 = r7
                r7 = r12
                r12 = r6
                r6 = r1
                r1 = r4
                r4 = r5
                r5 = r9
            L71:
                boolean r8 = r5 instanceof android.view.ViewGroup
                if (r8 == 0) goto L98
                android.view.ViewGroup r5 = (android.view.ViewGroup) r5
                kotlin.sequences.m r5 = androidx.core.view.j4.f(r5)
                r12.f6636h = r7
                r12.f6631c = r6
                r8 = 0
                r12.f6632d = r8
                r12.f6633e = r4
                r12.f6634f = r1
                r12.f6635g = r2
                java.lang.Object r5 = r7.h(r5, r12)
                if (r5 != r0) goto L8f
                return r0
            L8f:
                r5 = r6
                r6 = r7
            L91:
                r9 = r6
                r6 = r12
                r12 = r9
                r10 = r5
                r5 = r1
                r1 = r10
                goto L9c
            L98:
                r5 = r1
                r1 = r6
                r6 = r12
                r12 = r7
            L9c:
                int r4 = r4 + r3
                r9 = r5
                r5 = r4
                r4 = r9
                goto L4c
            La1:
                kotlin.l2 r12 = kotlin.l2.f34958a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.j4.b.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super View> oVar, @a7.e kotlin.coroutines.d<? super kotlin.l2> dVar) {
            return ((b) D(oVar, dVar)).R(kotlin.l2.f34958a);
        }
    }

    public static final class c implements Iterator<View>, j5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6639b;

        c(ViewGroup viewGroup) {
            this.f6639b = viewGroup;
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f6639b;
            int i7 = this.f6638a;
            this.f6638a = i7 + 1;
            View childAt = viewGroup.getChildAt(i7);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6638a < this.f6639b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f6639b;
            int i7 = this.f6638a - 1;
            this.f6638a = i7;
            viewGroup.removeViewAt(i7);
        }
    }

    public static final boolean a(@a7.d ViewGroup viewGroup, @a7.d View view) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        kotlin.jvm.internal.l0.p(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void b(@a7.d ViewGroup viewGroup, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            kotlin.jvm.internal.l0.o(childAt, "getChildAt(index)");
            action.z(childAt);
        }
    }

    public static final void c(@a7.d ViewGroup viewGroup, @a7.d i5.p<? super Integer, ? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            Integer numValueOf = Integer.valueOf(i7);
            View childAt = viewGroup.getChildAt(i7);
            kotlin.jvm.internal.l0.o(childAt, "getChildAt(index)");
            action.a0(numValueOf, childAt);
        }
    }

    @a7.d
    public static final View d(@a7.d ViewGroup viewGroup, int i7) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i7);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i7 + ", Size: " + viewGroup.getChildCount());
    }

    @a7.d
    public static final kotlin.sequences.m<View> e(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return new a(viewGroup);
    }

    @a7.d
    public static final kotlin.sequences.m<View> f(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return kotlin.sequences.q.b(new b(viewGroup, null));
    }

    @a7.d
    public static final kotlin.ranges.k g(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return kotlin.ranges.q.z1(0, viewGroup.getChildCount());
    }

    public static final int h(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean i(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean j(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    @a7.d
    public static final Iterator<View> k(@a7.d ViewGroup viewGroup) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        return new c(viewGroup);
    }

    public static final void l(@a7.d ViewGroup viewGroup, @a7.d View view) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        kotlin.jvm.internal.l0.p(view, "view");
        viewGroup.removeView(view);
    }

    public static final void m(@a7.d ViewGroup viewGroup, @a7.d View view) {
        kotlin.jvm.internal.l0.p(viewGroup, "<this>");
        kotlin.jvm.internal.l0.p(view, "view");
        viewGroup.addView(view);
    }

    public static final void n(@a7.d ViewGroup.MarginLayoutParams marginLayoutParams, @c.r0 int i7) {
        kotlin.jvm.internal.l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i7, i7, i7, i7);
    }

    public static final void o(@a7.d ViewGroup.MarginLayoutParams marginLayoutParams, @c.r0 int i7, @c.r0 int i8, @c.r0 int i9, @c.r0 int i10) {
        kotlin.jvm.internal.l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i7, i8, i9, i10);
    }

    public static /* synthetic */ void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i7, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = marginLayoutParams.leftMargin;
        }
        if ((i11 & 2) != 0) {
            i8 = marginLayoutParams.topMargin;
        }
        if ((i11 & 4) != 0) {
            i9 = marginLayoutParams.rightMargin;
        }
        if ((i11 & 8) != 0) {
            i10 = marginLayoutParams.bottomMargin;
        }
        kotlin.jvm.internal.l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i7, i8, i9, i10);
    }

    @c.t0(17)
    public static final void q(@a7.d ViewGroup.MarginLayoutParams marginLayoutParams, @c.r0 int i7, @c.r0 int i8, @c.r0 int i9, @c.r0 int i10) {
        kotlin.jvm.internal.l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i7);
        marginLayoutParams.topMargin = i8;
        marginLayoutParams.setMarginEnd(i9);
        marginLayoutParams.bottomMargin = i10;
    }

    public static /* synthetic */ void r(ViewGroup.MarginLayoutParams marginLayoutParams, int i7, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = marginLayoutParams.getMarginStart();
        }
        if ((i11 & 2) != 0) {
            i8 = marginLayoutParams.topMargin;
        }
        if ((i11 & 4) != 0) {
            i9 = marginLayoutParams.getMarginEnd();
        }
        if ((i11 & 8) != 0) {
            i10 = marginLayoutParams.bottomMargin;
        }
        kotlin.jvm.internal.l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i7);
        marginLayoutParams.topMargin = i8;
        marginLayoutParams.setMarginEnd(i9);
        marginLayoutParams.bottomMargin = i10;
    }
}
