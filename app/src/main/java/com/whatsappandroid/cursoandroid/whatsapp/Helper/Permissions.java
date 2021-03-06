package com.whatsappandroid.cursoandroid.whatsapp.Helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissions {
    public static boolean validPermissions(int requestCode, Activity activity, String[] permissions){

        if(Build.VERSION.SDK_INT >= 23){

            List<String> permissionList = new ArrayList<>();

            /*Run throught the permissions recieved one by one*/

            for(String perm : permissions){

                //Thie verify if I already have the fllowing permission
               Boolean validPerm =  ContextCompat.checkSelfPermission(activity, perm) == PackageManager.PERMISSION_GRANTED;

               if( !validPerm ){ permissionList.add(perm); }
            }

            //If the list is empty It won't be necessary to update the permissions
            if (permissionList.isEmpty()) {
                return true;
            }

            //Converting a List in a ArrayList
            String newPermitions[] = new String[permissionList.size()];
            permissionList.toArray(newPermitions);

            //Soliciting permission
            ActivityCompat.requestPermissions(activity, newPermitions, requestCode);
        }

        return true;
    }
}
