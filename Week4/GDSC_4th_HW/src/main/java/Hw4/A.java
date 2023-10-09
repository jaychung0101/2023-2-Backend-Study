package Hw4;

import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;
    private C c;

    public A(B b, C c) {
        this.b = b;
        this.c = c;
    }
    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }
}
