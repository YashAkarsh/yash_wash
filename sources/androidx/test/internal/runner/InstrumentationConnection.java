package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.LogUtil;
import androidx.test.internal.util.ParcelableIBinder;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import c.g1;
import c.m0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class InstrumentationConnection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9938d = "InstrConnection";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final InstrumentationConnection f9939e = new InstrumentationConnection(InstrumentationRegistry.b().getTargetContext());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9940f = "instr_clients";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9941g = "instr_client_type";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f9942h = "instr_client_msgr";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9943i = "instr_uuid";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g1
    static final String f9944j = "new_instrumentation_binder";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9945k = "androidx.test.runner.InstrumentationConnection.event";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9946l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9947m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9948n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9949o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g1
    static final int f9950p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f9951q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g1
    static final int f9952r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f9953s = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f9954t = 8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f9955u = 9;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @g1
    static final int f9956v = 10;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f9957w = 11;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f9958x = 12;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static Instrumentation f9959y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static MonitoringInstrumentation.ActivityFinisher f9960z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IncomingHandler f9962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1
    final BroadcastReceiver f9963c = new MessengerReceiver();

    @g1
    static class IncomingHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g1
        Messenger f9965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g1
        Set<Messenger> f9966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g1
        Map<String, Set<Messenger>> f9967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<UUID, CountDownLatch> f9968d;

        public IncomingHandler(Looper looper) {
            super(looper);
            this.f9965a = new Messenger(this);
            this.f9966b = new HashSet();
            this.f9967c = new HashMap();
            this.f9968d = new HashMap();
            if (Looper.getMainLooper() == looper || Looper.myLooper() == looper) {
                throw new IllegalStateException("This handler should not be using the main thread looper nor the instrumentation thread looper.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(final UUID latchId, final CountDownLatch latch) {
            o(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void call() {
                    IncomingHandler.this.f9968d.put(latchId, latch);
                    return null;
                }
            });
        }

        private void h(Bundle clientsBundle, boolean shouldRegister) {
            LogUtil.f(InstrumentationConnection.f9938d, "clientsRegistrationFromBundle called", new Object[0]);
            if (clientsBundle == null) {
                Log.w(InstrumentationConnection.f9938d, "The client bundle is null, ignoring...");
                return;
            }
            ArrayList<String> stringArrayList = clientsBundle.getStringArrayList(InstrumentationConnection.f9940f);
            if (stringArrayList == null) {
                Log.w(InstrumentationConnection.f9938d, "No clients found in the given bundle");
                return;
            }
            for (String str : stringArrayList) {
                Parcelable[] parcelableArray = clientsBundle.getParcelableArray(String.valueOf(str));
                if (parcelableArray != null) {
                    for (Parcelable parcelable : parcelableArray) {
                        if (shouldRegister) {
                            n(str, (Messenger) parcelable);
                        } else {
                            r(str, (Messenger) parcelable);
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(final UUID latchId) {
            o(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void call() {
                    IncomingHandler.this.f9968d.remove(latchId);
                    return null;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            Log.i(InstrumentationConnection.f9938d, "terminating process");
            p(5, null);
            this.f9966b.clear();
            this.f9967c.clear();
            LogUtil.f(InstrumentationConnection.f9938d, "quitting looper...", new Object[0]);
            getLooper().quit();
            LogUtil.f(InstrumentationConnection.f9938d, "finishing instrumentation...", new Object[0]);
            InstrumentationConnection.f9959y.finish(0, null);
            Instrumentation unused = InstrumentationConnection.f9959y = null;
            MonitoringInstrumentation.ActivityFinisher unused2 = InstrumentationConnection.f9960z = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<Messenger> k(final String type) {
            FutureTask futureTask = new FutureTask(new Callable<Set<Messenger>>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Set<Messenger> call() {
                    return IncomingHandler.this.f9967c.get(type);
                }
            });
            post(futureTask);
            try {
                return (Set) futureTask.get();
            } catch (InterruptedException e8) {
                throw new IllegalStateException(e8);
            } catch (ExecutionException e9) {
                throw new IllegalStateException(e9.getCause());
            }
        }

        private void l(Messenger instrMessenger) {
            Message messageObtainMessage = obtainMessage(5);
            messageObtainMessage.replyTo = instrMessenger;
            sendMessage(messageObtainMessage);
        }

        private void m(UUID uuid) {
            if (uuid != null && this.f9968d.containsKey(uuid)) {
                this.f9968d.get(uuid).countDown();
                return;
            }
            String strValueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16);
            sb.append("Latch not found ");
            sb.append(strValueOf);
            Log.w(InstrumentationConnection.f9938d, sb.toString());
        }

        private void n(String type, Messenger client) {
            LogUtil.f(InstrumentationConnection.f9938d, "registerClient called with type = [%s] client = [%s]", type, client);
            Checks.g(type, "type cannot be null!");
            Checks.g(client, "client cannot be null!");
            Set<Messenger> set = this.f9967c.get(type);
            if (set != null) {
                set.add(client);
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(client);
            this.f9967c.put(type, hashSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> T o(Callable<T> callable) {
            FutureTask futureTask = new FutureTask(callable);
            post(futureTask);
            try {
                return (T) futureTask.get();
            } catch (InterruptedException e8) {
                throw new IllegalStateException(e8.getCause());
            } catch (ExecutionException e9) {
                throw new IllegalStateException(e9.getCause());
            }
        }

        private void p(int what, Bundle data) {
            LogUtil.f(InstrumentationConnection.f9938d, "sendMessageToOtherInstr() called with: what = [%s], data = [%s]", Integer.valueOf(what), data);
            Iterator<Messenger> it = this.f9966b.iterator();
            while (it.hasNext()) {
                q(it.next(), what, data);
            }
        }

        private void q(Messenger toMessenger, int what, Bundle data) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("sendMessageWithReply type: ");
            sb.append(what);
            sb.append(" called");
            LogUtil.f(InstrumentationConnection.f9938d, sb.toString(), new Object[0]);
            Message messageObtainMessage = obtainMessage(what);
            messageObtainMessage.replyTo = this.f9965a;
            if (data != null) {
                messageObtainMessage.setData(data);
            }
            if (!this.f9967c.isEmpty()) {
                Bundle data2 = messageObtainMessage.getData();
                data2.putStringArrayList(InstrumentationConnection.f9940f, new ArrayList<>(this.f9967c.keySet()));
                for (Map.Entry<String, Set<Messenger>> entry : this.f9967c.entrySet()) {
                    data2.putParcelableArray(String.valueOf(entry.getKey()), (Messenger[]) entry.getValue().toArray(new Messenger[entry.getValue().size()]));
                }
                messageObtainMessage.setData(data2);
            }
            try {
                toMessenger.send(messageObtainMessage);
            } catch (RemoteException e8) {
                Log.w(InstrumentationConnection.f9938d, "The remote process is terminated unexpectedly", e8);
                l(toMessenger);
            }
        }

        private void r(String type, Messenger client) {
            LogUtil.f(InstrumentationConnection.f9938d, "unregisterClient called with type = [%s] client = [%s]", type, client);
            Checks.g(type, "type cannot be null!");
            Checks.g(client, "client cannot be null!");
            if (!this.f9967c.containsKey(type)) {
                String strValueOf = String.valueOf(type);
                Log.w(InstrumentationConnection.f9938d, strValueOf.length() != 0 ? "There are no registered clients for type: ".concat(strValueOf) : new String("There are no registered clients for type: "));
                return;
            }
            Set<Messenger> set = this.f9967c.get(type);
            if (set.contains(client)) {
                set.remove(client);
                if (set.isEmpty()) {
                    this.f9967c.remove(type);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 78);
            sb.append("Could not unregister client for type ");
            sb.append(type);
            sb.append(" because it doesn't seem to be registered");
            Log.w(InstrumentationConnection.f9938d, sb.toString());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int i7 = msg.what;
            switch (i7) {
                case 0:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REMOTE_ADD_CLIENT)", new Object[0]);
                    n(msg.getData().getString(InstrumentationConnection.f9941g), (Messenger) msg.getData().getParcelable(InstrumentationConnection.f9942h));
                    break;
                case 1:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REMOTE_REMOVE_CLIENT)", new Object[0]);
                    r(msg.getData().getString(InstrumentationConnection.f9941g), msg.replyTo);
                    break;
                case 2:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_TERMINATE)", new Object[0]);
                    j();
                    break;
                case 3:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST)", new Object[0]);
                    if (!this.f9966b.add(msg.replyTo)) {
                        Log.w(InstrumentationConnection.f9938d, "Broadcast with existing binder was received, ignoring it..");
                    } else {
                        q(msg.replyTo, 4, null);
                    }
                    break;
                case 4:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_ADD_INSTRUMENTATION)", new Object[0]);
                    if (!this.f9966b.add(msg.replyTo)) {
                        Log.w(InstrumentationConnection.f9938d, "Message with existing binder was received, ignoring it..");
                    } else {
                        if (!this.f9967c.isEmpty()) {
                            q(msg.replyTo, 6, null);
                        }
                        h(msg.getData(), true);
                    }
                    break;
                case 5:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REMOVE_INSTRUMENTATION)", new Object[0]);
                    if (!this.f9966b.remove(msg.replyTo)) {
                        Log.w(InstrumentationConnection.f9938d, "Attempting to remove a non-existent binder!");
                    }
                    break;
                case 6:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_ADD_CLIENTS_IN_BUNDLE)", new Object[0]);
                    h(msg.getData(), true);
                    break;
                case 7:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REMOVE_CLIENTS_IN_BUNDLE)", new Object[0]);
                    h(msg.getData(), false);
                    break;
                case 8:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REG_CLIENT)", new Object[0]);
                    n(msg.getData().getString(InstrumentationConnection.f9941g), (Messenger) msg.getData().getParcelable(InstrumentationConnection.f9942h));
                    p(0, msg.getData());
                    break;
                case 9:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_UN_REG_CLIENT)", new Object[0]);
                    r(msg.getData().getString(InstrumentationConnection.f9941g), (Messenger) msg.getData().getParcelable(InstrumentationConnection.f9942h));
                    p(1, msg.getData());
                    break;
                case 10:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_REMOTE_CLEANUP_REQUEST)", new Object[0]);
                    if (!this.f9966b.isEmpty()) {
                        p(11, msg.getData());
                    } else {
                        Message messageObtainMessage = obtainMessage(12);
                        messageObtainMessage.setData(msg.getData());
                        sendMessage(messageObtainMessage);
                    }
                    break;
                case 11:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_PERFORM_CLEANUP)", new Object[0]);
                    InstrumentationConnection.f9959y.runOnMainSync(InstrumentationConnection.f9960z);
                    q(msg.replyTo, 12, msg.getData());
                    break;
                case 12:
                    LogUtil.f(InstrumentationConnection.f9938d, "handleMessage(MSG_PERFORM_CLEANUP_FINISHED)", new Object[0]);
                    m((UUID) msg.getData().getSerializable(InstrumentationConnection.f9943i));
                    break;
                default:
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Unknown message code received: ");
                    sb.append(i7);
                    Log.w(InstrumentationConnection.f9938d, sb.toString());
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    @g1
    class MessengerReceiver extends BroadcastReceiver {
        MessengerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtil.f(InstrumentationConnection.f9938d, "Broadcast received", new Object[0]);
            Bundle bundleExtra = intent.getBundleExtra(InstrumentationConnection.f9944j);
            if (bundleExtra == null) {
                Log.w(InstrumentationConnection.f9938d, "Broadcast intent doesn't contain any extras, ignoring it..");
                return;
            }
            ParcelableIBinder parcelableIBinder = (ParcelableIBinder) bundleExtra.getParcelable(InstrumentationConnection.f9944j);
            if (parcelableIBinder != null) {
                Messenger messenger = new Messenger(parcelableIBinder.a());
                Message messageObtainMessage = InstrumentationConnection.this.f9962b.obtainMessage(3);
                messageObtainMessage.replyTo = messenger;
                InstrumentationConnection.this.f9962b.sendMessage(messageObtainMessage);
            }
        }
    }

    @g1
    InstrumentationConnection(@m0 Context context) {
        this.f9961a = (Context) Checks.g(context, "Context can't be null");
    }

    public static InstrumentationConnection f() {
        return f9939e;
    }

    public synchronized Set<Messenger> e(final String type) {
        return this.f9962b.k(type);
    }

    public synchronized void g(Instrumentation instrumentation, MonitoringInstrumentation.ActivityFinisher finisher) {
        try {
            LogUtil.f(f9938d, "init", new Object[0]);
            if (this.f9962b == null) {
                f9959y = instrumentation;
                f9960z = finisher;
                HandlerThread handlerThread = new HandlerThread("InstrumentationConnectionThread");
                handlerThread.start();
                this.f9962b = new IncomingHandler(handlerThread.getLooper());
                Intent intent = new Intent(f9945k);
                Bundle bundle = new Bundle();
                bundle.putParcelable(f9944j, new ParcelableIBinder(this.f9962b.f9965a.getBinder()));
                intent.putExtra(f9944j, bundle);
                try {
                    this.f9961a.sendBroadcast(intent);
                    this.f9961a.registerReceiver(this.f9963c, new IntentFilter(f9945k));
                } catch (SecurityException unused) {
                    Log.i(f9938d, "Could not send broadcast or register receiver (isolatedProcess?)");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void h(String type, Messenger messenger) {
        Checks.j(this.f9962b != null, "Instrumentation Connection in not yet initialized");
        String strValueOf = String.valueOf(type);
        Log.i(f9938d, strValueOf.length() != 0 ? "Register client of type: ".concat(strValueOf) : new String("Register client of type: "));
        Bundle bundle = new Bundle();
        bundle.putString(f9941g, type);
        bundle.putParcelable(f9942h, messenger);
        Message messageObtainMessage = this.f9962b.obtainMessage(8);
        messageObtainMessage.setData(bundle);
        this.f9962b.sendMessage(messageObtainMessage);
    }

    public synchronized void i() {
        IncomingHandler incomingHandler;
        Checks.j(this.f9962b != null, "Instrumentation Connection in not yet initialized");
        UUID uuidRandomUUID = UUID.randomUUID();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f9962b.g(uuidRandomUUID, countDownLatch);
        Message messageObtainMessage = this.f9962b.obtainMessage(10);
        messageObtainMessage.replyTo = this.f9962b.f9965a;
        Bundle data = messageObtainMessage.getData();
        data.putSerializable(f9943i, uuidRandomUUID);
        messageObtainMessage.setData(data);
        this.f9962b.sendMessage(messageObtainMessage);
        try {
            try {
                if (!countDownLatch.await(2L, TimeUnit.SECONDS)) {
                    String strValueOf = String.valueOf(uuidRandomUUID);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 60);
                    sb.append("Timed out while attempting to perform activity clean up for ");
                    sb.append(strValueOf);
                    Log.w(f9938d, sb.toString());
                }
                incomingHandler = this.f9962b;
            } catch (InterruptedException e8) {
                String strValueOf2 = String.valueOf(uuidRandomUUID);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 61);
                sb2.append("Interrupted while waiting for response from message with id: ");
                sb2.append(strValueOf2);
                Log.e(f9938d, sb2.toString(), e8);
                incomingHandler = this.f9962b;
            }
            incomingHandler.i(uuidRandomUUID);
        } catch (Throwable th) {
            this.f9962b.i(uuidRandomUUID);
            throw th;
        }
    }

    public synchronized void j() {
        LogUtil.f(f9938d, "Terminate is called", new Object[0]);
        IncomingHandler incomingHandler = this.f9962b;
        if (incomingHandler != null) {
            incomingHandler.o(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void call() {
                    InstrumentationConnection.this.f9962b.j();
                    return null;
                }
            });
            this.f9961a.unregisterReceiver(this.f9963c);
            this.f9962b = null;
        }
    }

    public synchronized void k(String type, Messenger messenger) {
        Checks.j(this.f9962b != null, "Instrumentation Connection in not yet initialized");
        String strValueOf = String.valueOf(type);
        Log.i(f9938d, strValueOf.length() != 0 ? "Unregister client of type: ".concat(strValueOf) : new String("Unregister client of type: "));
        Bundle bundle = new Bundle();
        bundle.putString(f9941g, type);
        bundle.putParcelable(f9942h, messenger);
        Message messageObtainMessage = this.f9962b.obtainMessage(9);
        messageObtainMessage.setData(bundle);
        this.f9962b.sendMessage(messageObtainMessage);
    }
}
