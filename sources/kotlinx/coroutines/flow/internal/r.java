package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public interface r<T> extends kotlinx.coroutines.flow.i<T> {

    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.i a(r rVar, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i8 & 1) != 0) {
                gVar = kotlin.coroutines.i.f34682a;
            }
            if ((i8 & 2) != 0) {
                i7 = -3;
            }
            if ((i8 & 4) != 0) {
                mVar = kotlinx.coroutines.channels.m.SUSPEND;
            }
            return rVar.c(gVar, i7, mVar);
        }
    }

    @a7.d
    kotlinx.coroutines.flow.i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar);
}
