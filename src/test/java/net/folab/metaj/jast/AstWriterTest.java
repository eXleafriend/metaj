package net.folab.metaj.jast;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import net.folab.metaj.bytecode.ByteArrayClassLoader;
import net.folab.metaj.bytecode.Java;
import net.folab.metaj.jast.AstWriter;
import net.folab.metaj.jast.ClassDeclaration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AstWriterTest {

    private AstWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new AstWriter(Java.V1_5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testVisitClass_0() throws InstantiationException,
            IllegalAccessException {
        testVisitClass("MainClass");
    }

    @Test
    public void testVisitClass_1() throws InstantiationException,
            IllegalAccessException {
        testVisitClass("foo.MainClass");
    }

    private void testVisitClass(String name) throws InstantiationException,
            IllegalAccessException {

        writer.visitClass(new ClassDeclaration(name));
        byte[] bytecode = writer.toByteArray();

        Class<?> generatedClass = defineClass(name, bytecode);
        assertThat(generatedClass.getName(), is(name));

        Object obj = generatedClass.newInstance();
        assertThat(obj, is(not(nullValue())));

    }

    public static Class<?> defineClass(String name, byte[] bytecode) {
        return new ByteArrayClassLoader().defineClass(name, bytecode);
    }

}
