/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoalgoritmi;

/**
 *
 * @author Lee
 */
public final class OsUtils
{
   private static String OS = null;
   public static String getOsName()
   {
      if(OS == null) { OS = System.getProperty("os.name"); }
      return OS;
   }
   public static boolean isWindows()
   {
      return getOsName().startsWith("Windows");
   }

   public static boolean isMac()
   {
       return getOsName().startsWith("Mac");
   }// and so on
}