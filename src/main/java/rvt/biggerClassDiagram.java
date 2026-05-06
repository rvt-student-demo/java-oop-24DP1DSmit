package rvt;

import java.util.ArrayList;
import javax.swing.JFrame;
public class biggerClassDiagram {
    public static void main(){
        JFrame frame = new JFrame("Happy Coding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
    }
    
}

class A implements IA{}
class B extends A implements IB {}
class C extends B implements IC {ArrayList<E> e;}
class D {IA ia;}
class E {ArrayList<C> c;}

interface IA {};
interface IB {};
interface IC {};