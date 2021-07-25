package com.sistema.plazas.util;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class UniqId {
	//private Random random = new Random();
	//Generador de claves unicas en formato Long
	public Long uniqid(byte prefix, boolean more_entropy)
	{
		long time = System.currentTimeMillis();
		String generator = "";
		if(!more_entropy)
		{
			generator = String.format("%d%d", prefix, time);
		}else
		{
			SecureRandom sec = new SecureRandom();
			byte[] sbuf = sec.generateSeed(8);
			ByteBuffer bb = ByteBuffer.wrap(sbuf);

			generator = String.format("%d%d%.3s", prefix, time, Math.abs(bb.getLong()));
		}
		Long Uniqid=Long.parseLong(generator);
		return Uniqid;
	}
	
	//Generador de claves unicas en formato String
	public String uniqid(String prefix, boolean more_entropy)
	{
		long time = System.currentTimeMillis();
		//String uniqid = String.format("%fd%05f", Math.floor(time),(time-Math.floor(time))*1000000);
		//uniqid = uniqid.substring(0, 13);
		String uniqid = "";
		if(!more_entropy)
		{
			uniqid = String.format("%s%08x%05x", prefix, time/1000, time);
		}else
		{
			SecureRandom sec = new SecureRandom();
			byte[] sbuf = sec.generateSeed(8);
			ByteBuffer bb = ByteBuffer.wrap(sbuf);
			//formato %s string, %08x llenar 0 y hexadecimales en 8 espacion
			uniqid = String.format("%s%08x%05x", prefix, time/1000, time);
			uniqid += "." + String.format("%.8s", ""+bb.getLong()*-1);
		}
		return uniqid;
	}
	
}
