package kr.or.ddit.case01.objs;

//Bar와 Baz에 대해 의존관계를 가지고 있음.
public class Foo {
	private final Bar bar; //필수 의존객체 <--반드시 있어야 하는...
	private Baz baz; //옵셔널 의존객체 <--있어도없어도뭐...
	
	
	/** 의존성을 주입하는 구조를 설계해야 함. */
	public Foo(Bar bar) {
		//생성자 주입 방식(constructor injection)
		super();
		this.bar = bar;
	}

	//Setter 주입 방식(setter injection)
	public void setBaz(Baz baz) { this.baz = baz; }
	
	
	
}
