package net.folab.metaj.jast;

import net.folab.metaj.bytecode.Access;

public abstract class MemberDeclaration {

    public final ClassDeclaration cd;

    public final Access access;

    public final String name;

    public MemberDeclaration(ClassDeclaration cd, Access access, String name) {
        this.cd = cd;
        this.access = access;
        this.name = name;
    }

}
