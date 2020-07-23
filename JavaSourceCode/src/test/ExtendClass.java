package test;

/**
 * @author Dun Wenlong
 * @time 2020/7/23 9:21
 * 访问修饰符，只能扩大，不能缩小
 */
public class ExtendClass extends BaseClass{
    @Override
    public void test() {
        super.test();
    }
}

