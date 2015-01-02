package net.folab.metaj.jast;

import net.folab.metaj.bytecode.StatementContext;

import org.objectweb.asm.MethodVisitor;

public interface Statement {

    public void generate(MethodVisitor mv, StatementContext ctx);

}
