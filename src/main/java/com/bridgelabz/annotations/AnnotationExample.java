package com.bridgelabz.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
public class AnnotationExample
{
    @MethodInfo( author = "Nithin",comments = "Main method", date = "Nov 17 2012", revision = 1 )
    @Override
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method",date = "Nov 17 2012")
    public static void oldMethod()
    {
        System.out.println("old method, dont use it");
    }

    public static void main(String[] args)
    {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method :" + method + " : " + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        catch (SecurityException e)
        {
         e.printStackTrace();
        }
    }
}
