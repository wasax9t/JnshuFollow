package cn.yxy.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtil {

	/**
	 *
	 * @return 随机生成的DES算法密钥
	 */
	public static byte[] generateKey() {
		try {
			// Java自带的安全的随机数源
			SecureRandom sRondom = new SecureRandom();
			// 得到一个DES算法的KeyGenerator对象
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			// 初始化生成器
			keyGenerator.init(sRondom);
			// 生成密钥
			SecretKey secretKey = keyGenerator.generateKey();
			// 获取密钥数据
			byte[] key = secretKey.getEncoded();
			return key;
		} catch (NoSuchAlgorithmException e) {
			// 这里catch的异常是KeyGenerator.getInstance中无提供指定的算法
			System.err.println("DES算法，生成密钥出错!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密函数 ECB mode
	 *
	 * @param data
	 *            加密数据
	 * @param key
	 *            密钥
	 * @return 返回加密后的数据
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {

		try {
			SecureRandom sRondom = new SecureRandom();
			// 从原始密钥数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			// 下面这两句和上一方法的sercretKey获得有什么区别呢
			// 区别在于有一个参数传了进来
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);
			// 至此，key变为一个DES可用的key
			
			// 得到一个DES ECB mode的密码工具对象
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, sRondom);
			// 执行加密操作
			byte encryptedData[] = cipher.doFinal(data);
			return encryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，加密数据出错!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密函数 ECB mode
	 *
	 * @param data
	 *            解密数据
	 * @param key
	 *            密钥
	 * @return 返回解密后的数据
	 */
	public static byte[] decrypt(byte[] data, byte[] key) {
		try {
			//TODO DES算法的随机数源,可以是和加密中的不同，真的可以吗
			SecureRandom sRondom = new SecureRandom();
			// 从原始密匙数据创建一个DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);
			// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);

			// using DES in ECB mode
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// 用密匙初始化Cipher对象，注意这里不同点在与Cipher的常量
			cipher.init(Cipher.DECRYPT_MODE, secretKey, sRondom);
			// 正式执行解密操作
			byte decryptedData[] = cipher.doFinal(data);
			return decryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，解密出错。");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密函数 CBC mode
	 *
	 * @param data
	 *            加密数据
	 * @param key
	 *            密钥
	 * @param iv           
	 * 			  用来初始化cipher加密器的密钥 DEC CBC mode需要
	 * @return 返回加密后的数据
	 */
	public static byte[] CBCEncrypt(byte[] data, byte[] key, byte[] iv) {

		try {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);

			// 注意这里是CBC
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			IvParameterSpec param = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, param);
			byte encryptedData[] = cipher.doFinal(data);
			return encryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，加密数据出错!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密函数 CBC mode
	 *
	 * @param data
	 *            解密数据
	 * @param key
	 *            密钥
	 * @param iv           
	 * 			  用来初始化cipher加密器的密钥 DEC CBC mode需要
	 * @return 返回解密后的数据
	 */
	public static byte[] CBCDecrypt(byte[] data, byte[] key, byte[] iv) {
		try {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);

			// using DES in CBC mode
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 用密匙初始化Cipher对象
			IvParameterSpec param = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, param);
			byte decryptedData[] = cipher.doFinal(data);
			return decryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，解密出错。");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
        try {
            byte[] key = "11111111".getBytes();
            byte[] iv = "22222222".getBytes();
            byte[] data = DESUtil.encrypt("ebc-mode test".getBytes(), key);
            System.out.print("EBC mode:");
            System.out.println(new String(DESUtil.decrypt(data, key)));
            System.out.print("CBC mode:");
            data = DESUtil.CBCEncrypt("cbc %^&$*N()_>N{{mode test".getBytes(), key, iv);
            System.out.println(new String(DESUtil.CBCDecrypt(data, key, iv)));
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
