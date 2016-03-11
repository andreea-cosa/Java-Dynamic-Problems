package comsiruri;

import java.io.FileReader;
import java.util.Scanner;

public class ComSiruri {

    public static int min(int a,int b,int c)
    {
        int x;
        if (a<=b) x=a;
                else x=b;
        if(c<=x ) x=c;
        return x;
    }

    public static int operatii(String s1,String s2,int l1,int l2)
    {
        //creez o matrice cu costul min al operatiilor
        int sol[][]=new int [l1+1][l2+1];

        for (int i=0; i<=l1; i++)
    {
        for (int j=0; j<=l2; j++)
        {
            //daca primul sir e gol doar insert
            if (i==0)
                sol[i][j] = j;

            //daca al 2 sir e gol doar remove
            else if (j==0)
                sol[i][j] = i;

            // Daca ultimul caracter e asemenea ignoram ultimul caracter si mergem la cel anteriorg
            else if (s1.charAt(i-1) == s2.charAt(j-1))
                sol[i][j] = sol[i-1][j-1];

            // Daca ultimul caracter verific toate posibilitatile si iau minum
            else
                sol[i][j] = 1 + min(sol[i][j-1],  // INSERT
                                   sol[i-1][j],  // REMOVE
                                   sol[i-1][j-1]); // REPLACE
        }
    }

    return sol[l1][l2];

    }
    //sunday/saturday => y=y


    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader("src\\comsiruri\\file.txt"));
        } catch (Exception ex) {
            sc = new Scanner(System.in);
        }
        String s1,s2;
        s1=sc.next();
        s2=sc.next();
        System.out.println("Numarul minum de operatii ce se realizeaza pentru a convertii sirul '"+s1+"' la '"+s2+"' este "+operatii(s1,s2,s1.length(),s2.length()));

    }

}
