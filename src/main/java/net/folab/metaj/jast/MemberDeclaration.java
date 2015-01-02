package net.folab.metaj.jast;

import net.folab.metaj.bytecode.Access;
import net.folab.metaj.bytecode.JavaType;

public class MemberDeclaration {

    public final ClassDeclaration cd;

    public final Access access;

    public final JavaType type;

    public final String name;

    public MemberDeclaration(ClassDeclaration cd, Access access, JavaType type,
            String name) {
        this.cd = cd;
        this.access = access;
        this.type = type;
        this.name = name;
    }

    public void accept(AstVisitor av) {
        av.visitField(this);
    }

}
