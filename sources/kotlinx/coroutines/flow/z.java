package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class z {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ o0 f36904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i<T> f36905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d0<T> f36906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ T f36907i;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.z$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C0487a extends kotlin.coroutines.jvm.internal.o implements i5.p<Integer, kotlin.coroutines.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36908e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ int f36909f;

            C0487a(kotlin.coroutines.d<? super C0487a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                C0487a c0487a = new C0487a(dVar);
                c0487a.f36909f = ((Number) obj).intValue();
                return c0487a;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                kotlin.coroutines.intrinsics.d.h();
                if (this.f36908e != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f36909f > 0);
            }

            @Override // i5.p
            public /* bridge */ /* synthetic */ Object a0(Integer num, kotlin.coroutines.d<? super Boolean> dVar) {
                return e0(num.intValue(), dVar);
            }

            @a7.e
            public final Object e0(int i7, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
                return ((C0487a) D(Integer.valueOf(i7), dVar)).R(l2.f34958a);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<m0, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36910e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36911f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i<T> f36912g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ d0<T> f36913h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ T f36914i;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.z$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0488a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f36915a;

                static {
                    int[] iArr = new int[m0.values().length];
                    iArr[m0.START.ordinal()] = 1;
                    iArr[m0.STOP.ordinal()] = 2;
                    iArr[m0.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    f36915a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(i<? extends T> iVar, d0<T> d0Var, T t7, kotlin.coroutines.d<? super b> dVar) {
                super(2, dVar);
                this.f36912g = iVar;
                this.f36913h = d0Var;
                this.f36914i = t7;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                b bVar = new b(this.f36912g, this.f36913h, this.f36914i, dVar);
                bVar.f36911f = obj;
                return bVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36910e;
                if (i7 == 0) {
                    e1.n(obj);
                    int i8 = C0488a.f36915a[((m0) this.f36911f).ordinal()];
                    if (i8 == 1) {
                        i<T> iVar = this.f36912g;
                        j jVar = this.f36913h;
                        this.f36910e = 1;
                        if (iVar.a(jVar, this) == objH) {
                            return objH;
                        }
                    } else if (i8 == 3) {
                        T t7 = this.f36914i;
                        if (t7 == k0.f36434a) {
                            this.f36913h.j();
                        } else {
                            this.f36913h.m(t7);
                        }
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d m0 m0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((b) D(m0Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(o0 o0Var, i<? extends T> iVar, d0<T> d0Var, T t7, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36904f = o0Var;
            this.f36905g = iVar;
            this.f36906h = d0Var;
            this.f36907i = t7;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new a(this.f36904f, this.f36905g, this.f36906h, this.f36907i, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0068 A[RETURN] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            i<T> iVar;
            j jVar;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36903e;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2) {
                        e1.n(obj);
                        iVar = this.f36905g;
                        jVar = this.f36906h;
                        this.f36903e = 3;
                        if (iVar.a(jVar, this) == objH) {
                            return objH;
                        }
                    } else if (i7 != 3 && i7 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                e1.n(obj);
            } else {
                e1.n(obj);
                o0 o0Var = this.f36904f;
                o0.a aVar = o0.f36535a;
                if (o0Var == aVar.c()) {
                    i<T> iVar2 = this.f36905g;
                    j jVar2 = this.f36906h;
                    this.f36903e = 1;
                    if (iVar2.a(jVar2, this) == objH) {
                        return objH;
                    }
                } else if (this.f36904f == aVar.d()) {
                    t0<Integer> t0VarQ = this.f36906h.q();
                    C0487a c0487a = new C0487a(null);
                    this.f36903e = 2;
                    if (k.t0(t0VarQ, c0487a, this) == objH) {
                        return objH;
                    }
                    iVar = this.f36905g;
                    jVar = this.f36906h;
                    this.f36903e = 3;
                    if (iVar.a(jVar, this) == objH) {
                        return objH;
                    }
                } else {
                    i iVarG0 = k.g0(this.f36904f.a(this.f36906h.q()));
                    b bVar = new b(this.f36905g, this.f36906h, this.f36907i, null);
                    this.f36903e = 4;
                    if (k.A(iVarG0, bVar, this) == objH) {
                        return objH;
                    }
                }
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i<T> f36918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.z<t0<T>> f36919h;

        static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k1.h<e0<T>> f36920a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.v0 f36921b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.z<t0<T>> f36922c;

            a(k1.h<e0<T>> hVar, kotlinx.coroutines.v0 v0Var, kotlinx.coroutines.z<t0<T>> zVar) {
                this.f36920a = hVar;
                this.f36921b = v0Var;
                this.f36922c = zVar;
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.e0, kotlinx.coroutines.flow.t0] */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                l2 l2Var;
                e0<T> e0Var = this.f36920a.f34872a;
                if (e0Var == null) {
                    l2Var = null;
                } else {
                    e0Var.setValue(t7);
                    l2Var = l2.f34958a;
                }
                if (l2Var == null) {
                    kotlinx.coroutines.v0 v0Var = this.f36921b;
                    k1.h<e0<T>> hVar = this.f36920a;
                    kotlinx.coroutines.z<t0<T>> zVar = this.f36922c;
                    ?? r7 = (T) v0.a(t7);
                    zVar.G0(new g0(r7, s2.B(v0Var.D())));
                    hVar.f34872a = r7;
                }
                return l2.f34958a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i<? extends T> iVar, kotlinx.coroutines.z<t0<T>> zVar, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f36918g = iVar;
            this.f36919h = zVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(this.f36918g, this.f36919h, dVar);
            bVar.f36917f = obj;
            return bVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.z$b for r6v1 'this'  kotlin.coroutines.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r6.f36916e
                r2 = 1
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> Lf
                goto L37
            Lf:
                r7 = move-exception
                goto L3a
            L11:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L19:
                kotlin.e1.n(r7)
                java.lang.Object r7 = r6.f36917f
                kotlinx.coroutines.v0 r7 = (kotlinx.coroutines.v0) r7
                kotlin.jvm.internal.k1$h r1 = new kotlin.jvm.internal.k1$h     // Catch: java.lang.Throwable -> Lf
                r1.<init>()     // Catch: java.lang.Throwable -> Lf
                kotlinx.coroutines.flow.i<T> r3 = r6.f36918g     // Catch: java.lang.Throwable -> Lf
                kotlinx.coroutines.flow.z$b$a r4 = new kotlinx.coroutines.flow.z$b$a     // Catch: java.lang.Throwable -> Lf
                kotlinx.coroutines.z<kotlinx.coroutines.flow.t0<T>> r5 = r6.f36919h     // Catch: java.lang.Throwable -> Lf
                r4.<init>(r1, r7, r5)     // Catch: java.lang.Throwable -> Lf
                r6.f36916e = r2     // Catch: java.lang.Throwable -> Lf
                java.lang.Object r7 = r3.a(r4, r6)     // Catch: java.lang.Throwable -> Lf
                if (r7 != r0) goto L37
                return r0
            L37:
                kotlin.l2 r7 = kotlin.l2.f34958a
                return r7
            L3a:
                kotlinx.coroutines.z<kotlinx.coroutines.flow.t0<T>> r0 = r6.f36919h
                r0.f(r7)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.z.b.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((b) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @a7.d
    public static final <T> i0<T> a(@a7.d d0<T> d0Var) {
        return new f0(d0Var, null);
    }

    @a7.d
    public static final <T> t0<T> b(@a7.d e0<T> e0Var) {
        return new g0(e0Var, null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static final <T> n0<T> c(i<? extends T> iVar, int i7) {
        kotlinx.coroutines.flow.internal.e eVar;
        i<T> iVarK;
        int iN = kotlin.ranges.q.n(i7, kotlinx.coroutines.channels.n.f35616t0.a()) - i7;
        if (!(iVar instanceof kotlinx.coroutines.flow.internal.e) || (iVarK = (eVar = (kotlinx.coroutines.flow.internal.e) iVar).k()) == null) {
            return new n0<>(iVar, iN, kotlinx.coroutines.channels.m.SUSPEND, kotlin.coroutines.i.f34682a);
        }
        int i8 = eVar.f36274b;
        if (i8 != -3 && i8 != -2 && i8 != 0) {
            iN = i8;
        } else if (eVar.f36275c == kotlinx.coroutines.channels.m.SUSPEND) {
            if (i8 == 0) {
                iN = 0;
            }
        } else if (i7 == 0) {
            iN = 1;
        } else {
            iN = 0;
        }
        return new n0<>(iVarK, iN, eVar.f36275c, eVar.f36273a);
    }

    private static final <T> o2 d(kotlinx.coroutines.v0 v0Var, kotlin.coroutines.g gVar, i<? extends T> iVar, d0<T> d0Var, o0 o0Var, T t7) {
        return kotlinx.coroutines.j.d(v0Var, gVar, kotlin.jvm.internal.l0.g(o0Var, o0.f36535a.c()) ? kotlinx.coroutines.x0.DEFAULT : kotlinx.coroutines.x0.UNDISPATCHED, new a(o0Var, iVar, d0Var, t7, null));
    }

    private static final <T> void e(kotlinx.coroutines.v0 v0Var, kotlin.coroutines.g gVar, i<? extends T> iVar, kotlinx.coroutines.z<t0<T>> zVar) {
        kotlinx.coroutines.l.f(v0Var, gVar, null, new b(iVar, zVar, null), 2, null);
    }

    @a7.d
    public static final <T> i0<T> f(@a7.d i0<? extends T> i0Var, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new y0(i0Var, pVar);
    }

    @a7.d
    public static final <T> i0<T> g(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d o0 o0Var, int i7) {
        n0 n0VarC = c(iVar, i7);
        d0 d0VarA = k0.a(i7, n0VarC.f36528b, n0VarC.f36529c);
        return new f0(d0VarA, d(v0Var, n0VarC.f36530d, n0VarC.f36527a, d0VarA, o0Var, k0.f36434a));
    }

    public static /* synthetic */ i0 h(i iVar, kotlinx.coroutines.v0 v0Var, o0 o0Var, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return k.F1(iVar, v0Var, o0Var, i7);
    }

    @a7.e
    public static final <T> Object i(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d kotlin.coroutines.d<? super t0<? extends T>> dVar) {
        n0 n0VarC = c(iVar, 1);
        kotlinx.coroutines.z zVarC = kotlinx.coroutines.b0.c(null, 1, null);
        e(v0Var, n0VarC.f36530d, n0VarC.f36527a, zVarC);
        return zVarC.h0(dVar);
    }

    @a7.d
    public static final <T> t0<T> j(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d o0 o0Var, T t7) {
        n0 n0VarC = c(iVar, 1);
        e0 e0VarA = v0.a(t7);
        return new g0(e0VarA, d(v0Var, n0VarC.f36530d, n0VarC.f36527a, e0VarA, o0Var, t7));
    }
}
