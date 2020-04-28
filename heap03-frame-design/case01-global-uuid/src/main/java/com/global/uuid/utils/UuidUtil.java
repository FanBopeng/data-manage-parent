package com.global.uuid.utils;

import java.util.UUID;

public class UuidUtil {

    private static final String ZERO = "00000000000";
    private static final String PREFIX = "UID";

    public static String getUUid() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replace("-","");
    }

    public static String getNoId(int length,Long id){
        String idVar = String.valueOf(id) ;
        if (idVar.length()>length){
            return PREFIX+idVar ;
        } else {
            int gapLen = length-idVar.length()-PREFIX.length() ;
            return PREFIX+ZERO.substring(0,gapLen)+idVar ;
        }
    }

    public static String getRouteId(String route,Integer length,Long id){
        String idVar = String.valueOf(id) ;
        if (idVar.length()>length){
            return route+idVar ;
        } else {
            int gapLen = length-idVar.length()-route.length() ;
            return route+ZERO.substring(0,gapLen)+idVar ;
        }
    }
}
