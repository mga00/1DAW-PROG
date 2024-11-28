package com.gsd.daw.prog;

public class Funciones {
	public static boolean ipRangosBien(String ip) {
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
	public static boolean ipNoMenosCero(String ip) {
		String[] separados=ip.split("\\.");
		String ip0=separados[0];
		String ip1=separados[1];
		String ip2=separados[2];
		String ip3=separados[3];
		if (ip0=="-0" || ip1=="-0" || ip2=="-0" || ip3=="-0") 
			return false;
		else 
			return true;	
	}
	public static boolean rangosCidrBien(int cidr) {
		if ( cidr>=32 || cidr<=0 ) 
			return false;
		else
			return true;
	}

	public static boolean ipCamposCorrectos(String ip) {
		String[] separados=ip.split("\\.");
		if (separados.length!=4) {
			return false;
		}else	
			return true;
	}

	public static boolean ipIntValido( String ipValido ) {
		try {
			String[] ipseparada=ipValido.split("\\.");
			Integer.parseInt( ipseparada[0] );
			Integer.parseInt( ipseparada[1] );
			Integer.parseInt( ipseparada[2] );
			Integer.parseInt( ipseparada[3] );
		} catch ( Exception e ) {
			return false;
			}
		    return true;
	}

	public static void clase(String clase,int cidr1) {
		String[] ipseparada=clase.split("\\.");
		int claseA=Integer.parseInt( ipseparada[0] );
		int claseB=Integer.parseInt( ipseparada[1] );
		int claseC=Integer.parseInt( ipseparada[2] );
		int claseOTRA=Integer.parseInt( ipseparada[3] );
		if(claseA<=127) {
				System.out.println("A");
				if(cidr1!=8)
					System.out.println("Subnetting:true");
				else
					System.out.println("Subnetting:false");
		}else
		if(claseA>=128 && claseA<=190) {
			if (claseB>=0 && claseC>=0 && claseOTRA>=0) {
				if (claseA<=191 || claseB>=255 || claseC>=255 || claseOTRA>=255) {
					System.out.println("B");
					if(cidr1!=16)
						System.out.println("Subnetting:true");
					else
						System.out.println("Subnetting:false");
				}
			}	
		}else
		if (claseA>=191 && claseA<=223) {
			if (claseB>=0 && claseC>=0 && claseOTRA>=0) {
				if (claseA<=223 || claseB>=255 || claseC>=255 || claseOTRA>=255) {
					System.out.println("C");
					if(cidr1!=24)
						System.out.println("Subnetting:true");
					else
						System.out.println("Subnetting:false");
				}
			}
		}else {
			System.out.println("OTRA");
			if(cidr1!=36)
				System.out.println("Subnetting:true");
				else
					System.out.println("Subnetting:false");
		}
	}
	public static boolean cidrIntValido( String cidr1 ) {
		   try {
		          Integer.parseInt( cidr1 );
		       } catch ( Exception e ) {
		          return false;
		       }
		       return true;
		}
}