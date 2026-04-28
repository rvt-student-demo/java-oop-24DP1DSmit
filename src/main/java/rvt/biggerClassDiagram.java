package rvt;

import java.util.ArrayList;

class A implements IA{}
class B extends A implements IB {}
class C extends B implements IC {ArrayList<E> e;}
class D {IA ia;}
class E {ArrayList<C> c;}

interface IA {};
interface IB {};
interface IC {};