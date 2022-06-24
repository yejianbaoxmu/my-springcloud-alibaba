package com.example.common.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.io.File;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.util.MySmUtil
 * @Date: 2022年06月06日 13:54
 * @Description:
 */
public class MySmUtil {

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public void testSm2() {
        String text = "我是一段测试aaaa";
        System.out.println(text.getBytes().length);
        SM2 sm2 = SmUtil.sm2();
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        System.out.println(encryptStr);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println(decryptStr);

        String sign = sm2.signHex(HexUtil.encodeHexStr(text));
        System.out.println(sign);
        boolean flag = sm2.verifyHex(HexUtil.encodeHexStr(text), sign);
        System.out.println(flag);

    }

    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static String encodeHexStr(byte[] data) {
        return new String(encodeHex(data, true));
    }

    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int length = data.length;
        char[] out = new char[length << 1];
        for (int i = 0, j = 0; i < length; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    public static byte[] decodeHex(char[] data) {
        int length = data.length;
        if((length & 0x01) !=0){
            throw new RuntimeException("Odd number of characters.");
        }
        byte[] out = new byte[length>>1];
        for(int i=0,j=0;j<length;i++){
            int h = toDigit(data[j],j)<<4;
            j++;
            h = h|toDigit(data[j],j);
            j++;
            out[i] = (byte)(h & 0xff);
        }
        return out;
    }

    protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch
                    + " at index " + index);
        }
        return digit;
    }


    public static void main(String[] args) {
        MySmUtil smUtil = new MySmUtil();
        smUtil.testSm2();

        String srcStr = "待转换字符串";
        String encodeStr = encodeHexStr(srcStr.getBytes());
        String decodeStr = new String(decodeHex(encodeStr.toCharArray()));
        System.out.println("转换前：" + srcStr);
        System.out.println("转换后：" + encodeStr);
        System.out.println("还原后：" + decodeStr);

        Digester sha1 = new Digester(DigestAlgorithm.SHA1);
        String digestHex = sha1.digestHex(new File("d:\\net_1.1.cap"));
        System.out.println(digestHex);
    }
}