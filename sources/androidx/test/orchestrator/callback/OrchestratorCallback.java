package androidx.test.orchestrator.callback;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

/* JADX INFO: loaded from: classes.dex */
public interface OrchestratorCallback extends IInterface {

    public static abstract class Stub extends BaseStub implements OrchestratorCallback {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f10258d = "androidx.test.orchestrator.callback.OrchestratorCallback";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f10259e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f10260f = 2;

        public static class Proxy extends BaseProxy implements OrchestratorCallback {
            Proxy(IBinder remote) {
                super(remote, Stub.f10258d);
            }

            @Override // androidx.test.orchestrator.callback.OrchestratorCallback
            public void M1(String test) throws RemoteException {
                Parcel parcelI0 = i0();
                parcelI0.writeString(test);
                y0(1, parcelI0);
            }

            @Override // androidx.test.orchestrator.callback.OrchestratorCallback
            public void j2(Bundle bundle) throws RemoteException {
                Parcel parcelI0 = i0();
                Codecs.k(parcelI0, bundle);
                y0(2, parcelI0);
            }
        }

        public Stub() {
            super(f10258d);
        }

        public static OrchestratorCallback z3(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(f10258d);
            return iInterfaceQueryLocalInterface instanceof OrchestratorCallback ? (OrchestratorCallback) iInterfaceQueryLocalInterface : new Proxy(obj);
        }

        @Override // androidx.test.runner.internal.deps.aidl.BaseStub
        protected boolean i0(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1) {
                M1(data.readString());
            } else {
                if (code != 2) {
                    return false;
                }
                j2((Bundle) Codecs.e(data, Bundle.CREATOR));
            }
            reply.writeNoException();
            return true;
        }
    }

    void M1(String test) throws RemoteException;

    void j2(Bundle bundle) throws RemoteException;
}
