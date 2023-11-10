package com.gsd.daw.prog;


public class App 
{
    public static void main( String[] args )
    {
        MiArrayProcedural ap = new MiArrayProcedural();
        //ap.array[5] = 7;
        
        MiArrayPoo apoo1 = new MiArrayPoo();
        //apoo1.addToArray( 5, 7 );
        
        MiArrayPooBueno apoo2 = new MiArrayPooBueno();
        apoo2.addToArray( 5, 7 );
        apoo2.addToArray( -1, 7 );
    }
}
