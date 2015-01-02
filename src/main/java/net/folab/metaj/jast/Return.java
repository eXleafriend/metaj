package net.folab.metaj.jast;

import net.folab.metaj.bytecode.StatementContext;

import org.objectweb.asm.MethodVisitor;

public class Return implements Statement {

    public static final Statement VOID = new Return(Expression.VOID);

    private final Expression returnValue;

    public Return(Expression returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public void generate(MethodVisitor mv, StatementContext ctx) {

        returnValue.generate(mv, ctx);

        mv.visitInsn(returnValue.getType().returnOpcode);
        ctx.clearStack();

    }

}
