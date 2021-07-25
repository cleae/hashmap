package com.tl.visit;

import com.tl.visit.visitor.Computer;
import com.tl.visit.visitor.ComputerPart;
import com.tl.visit.visitor.ComputerPartDisplayVisitor;

/**
 * 什么时候用访问者模式？
 * 访问者模式得优缺点？
 *
 */
public class Client {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
