package net.folab.metaj.jast;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.folab.metaj.bytecode.ByteArrayClassLoader;
import net.folab.metaj.bytecode.Java;
import net.folab.metaj.bytecode.JavaType;
import net.folab.metaj.jast.AstVisitor;
import net.folab.metaj.jast.AstWriter;
import net.folab.metaj.jast.ClassDeclaration;
import net.folab.metaj.jast.Literal;
import net.folab.metaj.jast.MethodDeclaration;
import net.folab.metaj.jast.Return;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MethodDeclarationTest {

    private static final String CLASS_NAME = "foo";

    private ClassDeclaration cd;

    private AstVisitor av;

    @Before
    public void setUp() throws Exception {
        cd = new ClassDeclaration(CLASS_NAME);
        av = new AstWriter(Java.V1_5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetReturnType_void() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.VOID) //
                .setParameterTypes() //
                .addStatement(Return.VOID) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(void.class));

    }

    @Test
    public void testSetReturnType_boolean() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.BOOLEAN) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of(false))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(boolean.class));

        boolean b = (Boolean) method.invoke(generatedClass.newInstance());
        assertThat(b, is(false));

    }

    @Test
    public void testSetReturnType_byte() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.BYTE) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of((byte) 0))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(byte.class));

        byte b = (Byte) method.invoke(generatedClass.newInstance());
        assertThat(b, is((byte) 0));

    }

    @Test
    public void testSetReturnType_char() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.CHAR) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of((char) 0))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(char.class));

        char c = (Character) method.invoke(generatedClass.newInstance());
        assertThat(c, is((char) 0));

    }

    @Test
    public void testSetReturnType_short() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.SHORT) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of((short) 0))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(short.class));

        short S = (Short) method.invoke(generatedClass.newInstance());
        assertThat(S, is((short) 0));

    }

    @Test
    public void testSetReturnType_int() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.INT) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of(0))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(int.class));

        int i = (Integer) method.invoke(generatedClass.newInstance());
        assertThat(i, is(0));

    }

    @Test
    public void testSetReturnType_long() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.LONG) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of(0l))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(long.class));

        long l = (Long) method.invoke(generatedClass.newInstance());
        assertThat(l, is(0l));

    }

    @Test
    public void testSetReturnType_float() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.FLOAT) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of(0.0f))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(float.class));

        float f = (Float) method.invoke(generatedClass.newInstance());
        assertThat(f, is(0.0f));

    }

    @Test
    public void testSetReturnType_double() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.DOUBLE) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of(0.0))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(double.class));

        double d = (Double) method.invoke(generatedClass.newInstance());
        assertThat(d, is(0.0d));

    }

    @Test
    public void testSetReturnType_Object() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.OBJECT) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.nullValue())) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(Object.class));

        Object o = method.invoke(generatedClass.newInstance());
        assertThat(o, is(nullValue()));

    }

    @Test
    public void testSetReturnType_String() throws SecurityException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        cd = cd.addMember( //
        new MethodDeclaration(cd, "bar") //
                .setReturnType(JavaType.STRING) //
                .setParameterTypes() //
                .addStatement(new Return(Literal.of("baz"))) //
        );
        av.visitClass(cd);

        Class<?> generatedClass = defineClass(CLASS_NAME, av.toByteArray());
        Method method = generatedClass.getDeclaredMethod("bar");

        assertThat(method.getReturnType(), typeCompatibleWith(String.class));

        String s = (String) method.invoke(generatedClass.newInstance());
        assertThat(s, is("baz"));

    }

    public static Class<?> defineClass(String name, byte[] bytecode) {
        return new ByteArrayClassLoader().defineClass(name, bytecode);
    }

}
