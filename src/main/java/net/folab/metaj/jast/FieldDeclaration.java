package net.folab.metaj.jast;

import net.folab.metaj.bytecode.Access;
import net.folab.metaj.bytecode.JavaType;

public class FieldDeclaration extends MemberDeclaration {

    public final JavaType type;

    public FieldDeclaration(ClassDeclaration cd, Access access, JavaType type,
            String name) {
        super(cd, access, name);
        this.type = type;
    }

    public void accept(AstVisitor av) {
        av.visitField(this);
    }

}
