/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.util.log;

/**
 *
 * @author zhuleqi
 */
public class LogUtil {
    public static void logInfo(String message){
        System.out.println(message);
    }
    
      public static void logErr(String message){
        System.err.println(message);
    }
}
