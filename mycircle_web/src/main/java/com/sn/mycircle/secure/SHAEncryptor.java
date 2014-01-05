package com.sn.mycircle.secure;

import java.security.MessageDigest;

/**
 * 
 * How to use SHA Encrypt (It's only one-way hash)<br>
 * SHAEncrypt sha= new SHAEncrypt(); <br>
 * password = sha.Encrypt(password); <br>
 * 
 * @author MJ_LEE
 */
public class SHAEncryptor {
	public String Encrypt(String strSrc) {
        MessageDigest md = null;
        SHAEncryptor mept = new SHAEncryptor();
        String strDes = null;
        byte[] bt = null;
		try {
			bt = strSrc.getBytes("UTF-8");		
            md = MessageDigest.getInstance("SHA");
            md.update(bt);
            strDes = mept.bytes2Hex(md.digest()); //to HexString
        } catch (Exception e) {
            System.out.println("Invalid algorithm.\n" + e.getMessage());
            return null;
        }
        return strDes;
    }

    private String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;

        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
