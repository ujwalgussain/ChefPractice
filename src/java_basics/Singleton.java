package java_basics;

import java.io.*;
import java.lang.reflect.Constructor;

public class Singleton implements Serializable {

    // Refer - https://dzone.com/articles/prevent-breaking-a-singleton-class-pattern


    public static Singleton INSTANCE;

    public static Singleton getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton.class){
                if(INSTANCE==null)
                    INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }

    //-----------------------Breaking Singleton Property through Reflection----------------------------------------------//
    static void breakingSingletonPropertyThroughReflection(){
        Singleton objOne = Singleton.getInstance();
        Singleton objTwo = null;
        try {
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objTwo = (Singleton) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println("Error Occured");
            ex.printStackTrace();
        }

        System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());
    }

    //Solve the reflection issue
    private Singleton(){
        if (INSTANCE!=null)
            throw new RuntimeException("Cannot create instance");
    }




    //-----------------------Breaking Singleton Property through Serialization----------------------------------------------//
    static void breakingSingletonPropertyThroughSerialization() throws IOException, ClassNotFoundException {

        Singleton instanceOne = Singleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
        Singleton instanceTwo = (Singleton) in.readObject();
        in.close();

        System.out.println("hashCode of instance 1 is - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 is - " + instanceTwo.hashCode());
    }

    //Static variables are class level variables and Serialization is Done over an object hence transient has no effect over static variables.
    //Solve Serialization Issue
    private Object readResolve(){
        return INSTANCE;
    }





    //-----------------------Breaking Singleton Property through Cloning----------------------------------------------//
    static void breakingSingletonPropertyThroughCloning() throws CloneNotSupportedException {
        Singleton instanceOne = Singleton.getInstance();
        Singleton instanceTwo = (Singleton) instanceOne.clone();
        System.out.println("hashCode of instance 1 - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 - " + instanceTwo.hashCode());
    }

    //Solve the cloning issue
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        //breakingSingletonPropertyThroughReflection();
        breakingSingletonPropertyThroughSerialization();
        //breakingSingletonPropertyThroughCloning();

    }
}
