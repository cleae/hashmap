package com.tl.jvm;

public class GarbageEscape {

    private static GarbageEscape hook = null; //类变量 属于GC ROOT

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize ... ");

        hook=this; //让当前对象到GC ROOT 可达
    }


    public static void main(String[] args) {


        try {
            hook = new GarbageEscape();
            hook = null;//对象第一次成功拯救自己
            System.gc();//调用垃圾收集器
            System.out.println("进行第一次gc");
            Thread.sleep(2000L);
            if(hook == null ){
                System.out.println(" obj is dead ");
            }else{
                System.out.println(" obj is Still alive ");
            }

            hook = null;
            System.gc();//调用垃圾收集器
            System.out.println("进行第二次gc");
            Thread.sleep(2000L);
            if(hook == null ){
                System.out.println(" obj is dead ");
            }else{
                System.out.println(" obj is Still alive ");
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
