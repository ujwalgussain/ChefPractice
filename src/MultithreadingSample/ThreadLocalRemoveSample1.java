package MultithreadingSample;

public class ThreadLocalRemoveSample1 {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        System.out.println(tl.get()); //Due to default impl of initialValue() return null
        tl.set("test");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());// invokes initialValue()
        tl = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return "initValue";
            }
        };
        System.out.println(tl.get()); //Due to default impl of initialValue() return null
        tl.set("test");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());// invokes initialValue()
    }
}
