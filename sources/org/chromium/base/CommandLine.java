package org.chromium.base;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
public abstract class CommandLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<CommandLine> f38636a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38637b = "CommandLine";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38638c = "--";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f38639d = "--";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f38640e = "=";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f38641f = false;

    private static class b extends CommandLine {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ boolean f38642j = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private HashMap<String, String> f38643g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ArrayList<String> f38644h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f38645i;

        b(@c.o0 String[] strArr) {
            String str;
            super();
            this.f38643g = new HashMap<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.f38644h = arrayList;
            this.f38645i = 1;
            if (strArr == null || strArr.length == 0 || (str = strArr[0]) == null) {
                arrayList.add("");
            } else {
                arrayList.add(str);
                z(strArr, 1);
            }
        }

        private void z(String[] strArr, int i7) {
            boolean z7 = true;
            for (String str : strArr) {
                if (i7 > 0) {
                    i7--;
                } else {
                    if (str.equals("--")) {
                        z7 = false;
                    }
                    if (z7 && str.startsWith("--")) {
                        String[] strArrSplit = str.split(CommandLine.f38640e, 2);
                        h(strArrSplit[0].substring(2), strArrSplit.length > 1 ? strArrSplit[1] : null);
                    } else {
                        this.f38644h.add(str);
                    }
                }
            }
        }

        @Override // org.chromium.base.CommandLine
        public void g(String str) {
            h(str, null);
        }

        @Override // org.chromium.base.CommandLine
        public void h(String str, String str2) {
            this.f38643g.put(str, str2 == null ? "" : str2);
            String str3 = "--" + str;
            if (str2 != null && !str2.isEmpty()) {
                str3 = str3 + CommandLine.f38640e + str2;
            }
            ArrayList<String> arrayList = this.f38644h;
            int i7 = this.f38645i;
            this.f38645i = i7 + 1;
            arrayList.add(i7, str3);
        }

        @Override // org.chromium.base.CommandLine
        public void i(String[] strArr) {
            z(strArr, 0);
        }

        @Override // org.chromium.base.CommandLine
        protected String[] l() {
            ArrayList<String> arrayList = this.f38644h;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @Override // org.chromium.base.CommandLine
        public String o(String str) {
            String str2 = this.f38643g.get(str);
            if (str2 == null || str2.isEmpty()) {
                return null;
            }
            return str2;
        }

        @Override // org.chromium.base.CommandLine
        public boolean q(String str) {
            return this.f38643g.containsKey(str);
        }
    }

    private static class c extends CommandLine {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f38646g = false;

        public c(@c.o0 String[] strArr) {
            super();
            CommandLine.nativeInit(strArr);
        }

        @Override // org.chromium.base.CommandLine
        public void g(String str) {
            CommandLine.nativeAppendSwitch(str);
        }

        @Override // org.chromium.base.CommandLine
        public void h(String str, String str2) {
            CommandLine.nativeAppendSwitchWithValue(str, str2);
        }

        @Override // org.chromium.base.CommandLine
        public void i(String[] strArr) {
            CommandLine.nativeAppendSwitchesAndArguments(strArr);
        }

        @Override // org.chromium.base.CommandLine
        protected void j() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // org.chromium.base.CommandLine
        protected String[] l() {
            return null;
        }

        @Override // org.chromium.base.CommandLine
        public String o(String str) {
            return CommandLine.nativeGetSwitchValue(str);
        }

        @Override // org.chromium.base.CommandLine
        public boolean q(String str) {
            return CommandLine.nativeHasSwitch(str);
        }

        @Override // org.chromium.base.CommandLine
        public boolean u() {
            return true;
        }
    }

    public static void k() {
        f38636a.set(new c(n()));
    }

    @s0
    public static CommandLine m() {
        return f38636a.get();
    }

    @c.o0
    public static String[] n() {
        CommandLine commandLine = f38636a.get();
        if (commandLine != null) {
            return commandLine.l();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchWithValue(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String nativeGetSwitchValue(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeHasSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInit(String[] strArr);

    public static void r(@c.o0 String[] strArr) {
        x(new b(strArr));
    }

    public static void s(String str) {
        char[] cArrV = v(str);
        r(cArrV == null ? null : y(cArrV));
    }

    public static boolean t() {
        return f38636a.get() != null;
    }

    private static char[] v(String str) {
        File file = new File(str);
        try {
            FileReader fileReader = new FileReader(file);
            try {
                char[] cArr = new char[(int) file.length()];
                char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, 0, fileReader.read(cArr));
                fileReader.close();
                return cArrCopyOfRange;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @s0
    public static void w() {
        x(null);
    }

    private static void x(CommandLine commandLine) {
        CommandLine andSet = f38636a.getAndSet(commandLine);
        if (andSet != null) {
            andSet.j();
        }
    }

    @s0
    static String[] y(char[] cArr) {
        if (cArr.length > 65536) {
            throw new RuntimeException("Flags file too big: " + cArr.length);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = null;
        char c8 = 0;
        for (char c9 : cArr) {
            if ((c8 == 0 && (c9 == '\'' || c9 == '\"')) || c9 == c8) {
                if (sb == null || sb.length() <= 0 || sb.charAt(sb.length() - 1) != '\\') {
                    c8 = c8 == 0 ? c9 : (char) 0;
                } else {
                    sb.setCharAt(sb.length() - 1, c9);
                }
            } else if (c8 != 0 || !Character.isWhitespace(c9)) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(c9);
            } else if (sb != null) {
                arrayList.add(sb.toString());
                sb = null;
            }
        }
        if (sb != null) {
            if (c8 != 0) {
                Log.w(f38637b, "Unterminated quoted string: " + ((Object) sb));
            }
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @s0
    public abstract void g(String str);

    public abstract void h(String str, String str2);

    public abstract void i(String[] strArr);

    protected void j() {
    }

    protected abstract String[] l();

    public abstract String o(String str);

    public String p(String str, String str2) {
        String strO = o(str);
        return TextUtils.isEmpty(strO) ? str2 : strO;
    }

    @s0
    public abstract boolean q(String str);

    public boolean u() {
        return false;
    }

    private CommandLine() {
    }
}
