MetaJ
====================

MetaJ provides meta-programming in Java.

*Following code is just draft*

```java
beginCode();

package_("foo.bar");

public_class("Greeting")
    .implements_(Type.of("java.util.concurrent.Callable", Type.STRING));

{
    private_field(Type.STRING, "name");
}

{
    public_constructor().p(Type.STRING, "name").beginBody();
        assign(local("this").field("name"), local("name"));
    endBody();
}

{
    public_method(Type.VOID, "call").p().beginBody();
        return_(append(append(Literal.of("Hello, "), field("name")), "!"));
    endBody();
}

endCode();

Class<Callable<String>> genClass = generateClass((Callable<String>) null);
Constructor<Callable<String>> ctor = genClass.getConstructor(String.class);
Callable<String> callable = ctor.newInstance("MetaJ");
System.out.println(callable.call());
```
