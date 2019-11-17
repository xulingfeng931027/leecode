/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/15
 */
public class FinalReferenceTest {
    static FinalReferenceTest obj;
    int[] arr;

    public FinalReferenceTest() {
        arr = new int[1];
        arr[0] = 1;
    }

    public static void writeOne() {
        obj = new FinalReferenceTest();
    }

    public static void writeTwo() {
        obj.arr[0] = 2;
    }

    public static void reader() {
        if (obj != null) {
            System.out.println(obj.arr[0]);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Thread A = new Thread(FinalReferenceTest::writeOne);
//            Thread B = new Thread(FinalReferenceTest::writeTwo);
            Thread C = new Thread(FinalReferenceTest::reader);
//            A.start();
//            B.start();
            C.start();
            A.start();
        }
    }

}
