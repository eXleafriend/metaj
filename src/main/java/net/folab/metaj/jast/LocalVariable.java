package net.folab.metaj.jast;

import net.folab.metaj.bytecode.JavaType;
import net.folab.metaj.bytecode.StatementContext;

import org.objectweb.asm.MethodVisitor;

public class LocalVariable implements Expression {

    private final String name;

    public LocalVariable(String name) {
        this.name = name;
    }

    @Override
    public void generate(MethodVisitor mv, StatementContext ctx) {
        int index = ctx.indexOfLocal(name);
        JavaType type = ctx.typeOfLocal(name);
        ctx.incStack();
        mv.visitVarInsn(type.loadOpcode, index);
    }

    @Override
    public JavaType getType() {
        throw new RuntimeException();
    }

}
