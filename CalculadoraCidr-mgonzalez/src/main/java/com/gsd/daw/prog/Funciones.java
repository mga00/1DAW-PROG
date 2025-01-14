package com.gsd.daw.prog;

public class Funciones {
	
	public static boolean ipRangosBien(String ip) {
		String[] separados=ip.split("\\.");
		int ip0=Integer.parseInt( separados[0] );
		int ip1=Integer.parseInt( separados[1] );
		int ip2=Integer.parseInt( separados[2] );
		int ip3=Integer.parseInt( separados[3] );
		if ( ip0>255 || ip0<0 || ip1>255 || ip1<0 || ip2>255 || ip2<0 || ip3>255 || ip3<0) {
			System.err.println("Error: Los campos de la ip no son correctos");
			return false;
		}else {
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
		if (ip0.contains("-") || ip1.contains("-") || ip2.contains("-") || ip3.contains("-")) {
			System.err.println("Error: los campos de la ip no tiene los enteros correctos");
			return false;
		}else 
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
			System.err.println("Error: la ip introducida no tiene los campos correctos");
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
			System.err.println("Error: los datos introducidos no representan una ip de enteros");
			return false;
			}
		    return true;
	}

	public static String clase(String ip,int cidr1) {
		String resultado="";
		String[] ipseparada=ip.split("\\.");
		int claseA=Integer.parseInt( ipseparada[0] );
		if(claseA<=127) {
				resultado+="A";
				if(cidr1!=8)
					resultado+=" Subnetting:true";
				else
					resultado+=" Subnetting:false";
		}else
		if(claseA<=190) {
					resultado+="B";
					if(cidr1!=16)
						resultado+=" Subnetting:true";
					else
						resultado+=" Subnetting:false";
		}else
		if (claseA<=223) {
					resultado+="C";
					if(cidr1!=24)
						resultado+=" Subnetting:true";
					else
						resultado+=" Subnetting:false";
		}else {
			resultado+="OTRA";
			if(cidr1!=36)
				resultado+=" Subnetting:true";
				else
					resultado+=" Subnetting:false";
		}
		
		System.out.println(resultado);
		return resultado;
	}
	public static boolean cidrIntValido( String cidr1 ) {
		   try {
		          Integer.parseInt( cidr1 );
		       } catch ( Exception e ) {
		    	   System.err.println("Error: la máscara de red no es un entero válido");
		          return false;
		       }
		       return true;
		}
	public static boolean errorNumArgum(int length) {
		if (length!=2) {
			System.err.println("Error: el numero de argumentos tiene que ser 2");
			return false;
		}else {
			return true;
		}
	}

	
	
	
	
}