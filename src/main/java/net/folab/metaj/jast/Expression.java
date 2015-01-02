package net.folab.metaj.jast;

import net.folab.metaj.bytecode.JavaType;
import net.folab.metaj.bytecode.StatementContext;

import org.objectweb.asm.MethodVisitor;

public interface Expression {

    public static final Expression VOID = new Expression() {

        @Override
        public JavaType getType() {
            return JavaType.VOID;
        }

        @Override
        public void generate(MethodVisitor mv, StatementContext context) {

        }

    };

    public void generate(MethodVisitor mv, StatementContext context);

    public JavaType getType();

}
