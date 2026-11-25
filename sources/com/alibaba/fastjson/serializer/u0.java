package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class u0 extends i1 implements y0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static u0 f13175j = new u0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f13176k = k1.e(new k1[]{k1.BrowserCompatible, k1.WriteNonStringKeyAsString, k1.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        r(n0Var, obj, obj2, type, i7, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0154 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0158 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0160 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x017f A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[PHI: r1
      0x0022: PHI (r1v64 java.util.Map<java.lang.String, java.lang.Object>) = 
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v1 java.util.Map<java.lang.String, java.lang.Object>)
     binds: [B:16:0x0030, B:18:0x0034, B:217:0x0022, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:121:0x018e A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0196 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x01b2 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01bc A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x01c4 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x01e0 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x01e9 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x021d A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0235 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0248 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x024d A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0258 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x025f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:178:0x0261 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x026c A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x0278 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0282 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x028c A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0294 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x029b  */
    /* JADX WARN: Code duplicated, block: B:195:0x02a7 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x02be  */
    /* JADX WARN: Code duplicated, block: B:204:0x02ce A[Catch: all -> 0x02fc, TRY_LEAVE, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x0242 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f0 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0120 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0124 A[Catch: all -> 0x02fc, TryCatch #0 {all -> 0x02fc, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ec, B:67:0x00f0, B:70:0x00f8, B:73:0x00fd, B:75:0x0107, B:77:0x010b, B:80:0x0116, B:83:0x0120, B:85:0x0124, B:88:0x012c, B:91:0x0131, B:93:0x013b, B:95:0x013f, B:98:0x014a, B:101:0x0154, B:103:0x0158, B:106:0x0160, B:109:0x0165, B:111:0x016f, B:113:0x0173, B:116:0x017f, B:119:0x018a, B:121:0x018e, B:124:0x0196, B:127:0x019b, B:129:0x01a5, B:131:0x01a9, B:132:0x01b2, B:133:0x01b8, B:135:0x01bc, B:138:0x01c4, B:141:0x01c9, B:143:0x01d3, B:145:0x01d7, B:146:0x01e0, B:149:0x01e9, B:152:0x01ee, B:154:0x01f2, B:160:0x01fc, B:165:0x0235, B:168:0x0242, B:170:0x0248, B:172:0x024d, B:173:0x0250, B:175:0x0258, B:176:0x025b, B:187:0x0282, B:189:0x028c, B:191:0x0294, B:193:0x029d, B:195:0x02a7, B:197:0x02ab, B:199:0x02af, B:201:0x02ba, B:203:0x02c0, B:204:0x02ce, B:178:0x0261, B:179:0x0264, B:181:0x026c, B:183:0x0270, B:185:0x027b, B:184:0x0278, B:162:0x021d, B:37:0x0075), top: B:218:0x0052 }] */
    public void r(n0 n0Var, Object obj, Object obj2, Type type, int i7, boolean z7) throws IOException {
        Map<String, Object> treeMap;
        boolean z8;
        List<c1> list;
        List<b1> list2;
        List<b1> list3;
        List<w0> list4;
        List<w0> list5;
        String str;
        String str2;
        Object objP;
        Object obj3;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        y0 y0Var;
        Type type2;
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        Map<String, Object> mapL1 = (Map) obj;
        int i8 = k1.MapSortField.f13132a;
        if ((j1Var.f13090c & i8) == 0 && (i8 & i7) == 0) {
            treeMap = mapL1;
        } else {
            if (mapL1 instanceof com.alibaba.fastjson.e) {
                mapL1 = ((com.alibaba.fastjson.e) mapL1).l1();
            }
            if ((mapL1 instanceof SortedMap) || (mapL1 instanceof LinkedHashMap)) {
                treeMap = mapL1;
            } else {
                try {
                    treeMap = new TreeMap(mapL1);
                } catch (Exception unused) {
                    treeMap = mapL1;
                }
            }
        }
        if (n0Var.u(obj)) {
            n0Var.W(obj);
            return;
        }
        e1 e1Var = n0Var.f13149q;
        boolean z9 = false;
        n0Var.L(e1Var, obj, obj2, 0);
        if (!z7) {
            try {
                j1Var.write(123);
            } catch (Throwable th) {
                n0Var.f13149q = e1Var;
                throw th;
            }
        }
        n0Var.F();
        if (j1Var.G(k1.WriteClassName)) {
            String str3 = n0Var.f13142j.f13064c;
            Class<?> cls4 = treeMap.getClass();
            if ((cls4 == com.alibaba.fastjson.e.class || cls4 == HashMap.class || cls4 == LinkedHashMap.class) && treeMap.containsKey(str3)) {
                z8 = true;
            } else {
                j1Var.J0(str3);
                j1Var.a2(obj.getClass().getName());
                z8 = false;
            }
        } else {
            z8 = true;
        }
        boolean z10 = z8;
        Class<?> cls5 = null;
        y0 y0VarB = null;
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            List<c1> list6 = n0Var.f13079f;
            if (list6 == null || list6.size() <= 0) {
                list = this.f13079f;
                if (list != null || list.size() <= 0) {
                    list2 = n0Var.f13076c;
                    if (list2 != null || list2.size() <= 0) {
                        list3 = this.f13076c;
                        if (list3 != null && list3.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                if (!e(n0Var, obj, key, value)) {
                                    cls5 = cls5;
                                    cls5 = cls5;
                                    z9 = false;
                                }
                            } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !e(n0Var, obj, com.alibaba.fastjson.a.y0(key), value)) {
                                cls5 = cls5;
                                cls5 = cls5;
                                z9 = false;
                            }
                        }
                        list4 = n0Var.f13078e;
                        if (list4 != null && list4.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = o(n0Var, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = o(n0Var, obj, com.alibaba.fastjson.a.y0(key), value);
                            }
                        }
                        list5 = this.f13078e;
                        if (list5 != null && list5.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = o(n0Var, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = o(n0Var, obj, com.alibaba.fastjson.a.y0(key), value);
                            }
                        }
                        str = key;
                        if (str != null || (str instanceof String)) {
                            str2 = str;
                            objP = p(n0Var, null, obj, str2, value);
                        } else {
                            if (((str instanceof Map) || (str instanceof Collection)) ? true : z9) {
                                str2 = str;
                                cls5 = cls5;
                                obj3 = value;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, com.alibaba.fastjson.a.y0(str), value);
                            }
                            if (obj3 == null || j1Var.F(k1.G)) {
                                if (str2 instanceof String) {
                                    String str4 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str4, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k) || (str2 instanceof Enum)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.T(com.alibaba.fastjson.a.y0(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName) || !(y0Var instanceof p0)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        if (type instanceof ParameterizedType) {
                                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                            if (actualTypeArguments.length == 2) {
                                                type2 = actualTypeArguments[1];
                                            } else {
                                                type2 = null;
                                            }
                                        } else {
                                            type2 = null;
                                        }
                                        y0VarB = y0Var;
                                        ((p0) y0Var).N(n0Var, obj3, str2, type2, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            } else {
                                cls5 = cls5;
                                z9 = false;
                            }
                        }
                        obj3 = objP;
                        if (obj3 == null) {
                        }
                        if (str2 instanceof String) {
                            String str5 = str2;
                            if (!z10) {
                                j1Var.write(44);
                            }
                            if (j1Var.G(k1.PrettyFormat)) {
                                n0Var.J();
                            }
                            j1Var.L0(str5, true);
                        } else {
                            if (!z10) {
                                j1Var.write(44);
                            }
                            if (j1Var.F(f13176k)) {
                                n0Var.S(str2);
                            } else {
                                n0Var.S(str2);
                            }
                            j1Var.write(58);
                        }
                        if (obj3 == null) {
                            j1Var.X1();
                            cls5 = cls5;
                        } else {
                            cls = obj3.getClass();
                            cls2 = cls5;
                            if (cls != cls2) {
                                y0VarB = n0Var.B(cls);
                                cls3 = cls;
                            } else {
                                cls3 = cls2;
                            }
                            y0Var = y0VarB;
                            if (k1.d(i7, k1.WriteClassName)) {
                                y0VarB = y0Var;
                                y0VarB.c(n0Var, obj3, str2, null, i7);
                            } else {
                                y0VarB = y0Var;
                                y0VarB.c(n0Var, obj3, str2, null, i7);
                            }
                            cls5 = cls3;
                        }
                        z9 = false;
                        z10 = false;
                    } else {
                        if (key == null || (key instanceof String)) {
                            if (e(n0Var, obj, key, value)) {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str6 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str6, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            }
                        } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || e(n0Var, obj, com.alibaba.fastjson.a.y0(key), value)) {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str7 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str7, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        }
                        cls5 = cls5;
                        cls5 = cls5;
                        z9 = false;
                    }
                } else {
                    if (key == null || (key instanceof String)) {
                        if (f(n0Var, obj, key)) {
                            list2 = n0Var.f13076c;
                            if (list2 != null) {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str8 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str8, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            } else {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str9 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str9, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            }
                        }
                    } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || f(n0Var, obj, com.alibaba.fastjson.a.y0(key))) {
                        list2 = n0Var.f13076c;
                        if (list2 != null) {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str10 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str10, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        } else {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str11 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str11, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        }
                    }
                    cls5 = cls5;
                    cls5 = cls5;
                    z9 = false;
                }
            } else {
                if (key == null || (key instanceof String)) {
                    if (f(n0Var, obj, key)) {
                        list = this.f13079f;
                        if (list != null) {
                            list2 = n0Var.f13076c;
                            if (list2 != null) {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str12 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str12, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            } else {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str13 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str13, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            }
                        } else {
                            list2 = n0Var.f13076c;
                            if (list2 != null) {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str14 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str14, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            } else {
                                list3 = this.f13076c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(n0Var, obj, key, value)) {
                                        }
                                    } else if (!e(n0Var, obj, key, value)) {
                                    }
                                }
                                list4 = n0Var.f13078e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f13078e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(n0Var, obj, key, value);
                                    } else {
                                        key = o(n0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                } else {
                                    str2 = str;
                                    objP = p(n0Var, null, obj, str2, value);
                                    obj3 = objP;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str15 = str2;
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.G(k1.PrettyFormat)) {
                                        n0Var.J();
                                    }
                                    j1Var.L0(str15, true);
                                } else {
                                    if (!z10) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.F(f13176k)) {
                                        n0Var.S(str2);
                                    } else {
                                        n0Var.S(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.X1();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        y0VarB = n0Var.B(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    y0Var = y0VarB;
                                    if (k1.d(i7, k1.WriteClassName)) {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    } else {
                                        y0VarB = y0Var;
                                        y0VarB.c(n0Var, obj3, str2, null, i7);
                                    }
                                    cls5 = cls3;
                                }
                                z9 = false;
                                z10 = false;
                            }
                        }
                    }
                } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || f(n0Var, obj, com.alibaba.fastjson.a.y0(key))) {
                    list = this.f13079f;
                    if (list != null) {
                        list2 = n0Var.f13076c;
                        if (list2 != null) {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str16 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str16, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        } else {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str17 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str17, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        }
                    } else {
                        list2 = n0Var.f13076c;
                        if (list2 != null) {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str18 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str18, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        } else {
                            list3 = this.f13076c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(n0Var, obj, key, value)) {
                                    }
                                } else if (!e(n0Var, obj, key, value)) {
                                }
                            }
                            list4 = n0Var.f13078e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            list5 = this.f13078e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(n0Var, obj, key, value);
                                } else {
                                    key = o(n0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            } else {
                                str2 = str;
                                objP = p(n0Var, null, obj, str2, value);
                                obj3 = objP;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str19 = str2;
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.G(k1.PrettyFormat)) {
                                    n0Var.J();
                                }
                                j1Var.L0(str19, true);
                            } else {
                                if (!z10) {
                                    j1Var.write(44);
                                }
                                if (j1Var.F(f13176k)) {
                                    n0Var.S(str2);
                                } else {
                                    n0Var.S(str2);
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.X1();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    y0VarB = n0Var.B(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                y0Var = y0VarB;
                                if (k1.d(i7, k1.WriteClassName)) {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                } else {
                                    y0VarB = y0Var;
                                    y0VarB.c(n0Var, obj3, str2, null, i7);
                                }
                                cls5 = cls3;
                            }
                            z9 = false;
                            z10 = false;
                        }
                    }
                }
                cls5 = cls5;
                cls5 = cls5;
                z9 = false;
            }
        }
        n0Var.f13149q = e1Var;
        n0Var.v();
        if (j1Var.G(k1.PrettyFormat) && treeMap.size() > 0) {
            n0Var.J();
        }
        if (z7) {
            return;
        }
        j1Var.write(125);
    }
}
