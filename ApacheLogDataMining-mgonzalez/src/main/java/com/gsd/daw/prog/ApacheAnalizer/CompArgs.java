package com.gsd.daw.prog.ApacheAnalizer;

public class CompArgs {
	public static boolean compIp(String ip) {
		String[] separados=ip.split("\\.");
		int ip0=Integer.parseInt( separados[0] );
		int ip1=Integer.parseInt( separados[1] );
		int ip2=Integer.parseInt( separados[2] );
		int ip3=Integer.parseInt( separados[3] );
		if ( ip0>255 || ip0<0 || ip1>255 || ip1<0 || ip2>255 || ip2<0 || ip3>255 || ip3<0) 
			return false;
		else {
			if(ip0==0 && ip1==0 && ip2==0 && ip3==0)
				return false;
			else {
				if(ip0==255 && ip1==255 && ip2==255 && ip3==255)
					return false;
				else
				return true;
			}
		}		
	}
}
