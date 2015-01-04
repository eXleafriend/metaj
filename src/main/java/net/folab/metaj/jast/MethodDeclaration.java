package net.folab.metaj.jast;

import java.util.ArrayList;
import java.util.List;

import net.folab.metaj.bytecode.Access;
import net.folab.metaj.bytecode.JavaType;
import net.folab.metaj.jast.Block;
import net.folab.metaj.jast.Statement;

public class MethodDeclaration extends MemberDeclaration {

    public final JavaType returnType;

    public final JavaType[] parameterTypes;

    public final Block block;

    public MethodDeclaration(ClassDeclaration cd, String name) {
        this(cd, Access.PUBLIC, name, JavaType.VOID, new JavaType[0],
                false, new ArrayList<Statement>());
    }

    public MethodDeclaration(ClassDeclaration cd, Access access, String name, JavaType returnType,
            JavaType[] parameterTypes, boolean isStatic, List<Statement> statements) {
        super(cd, access, name);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
        this.block = new Block(isStatic, statements);
    }

    public void accept(AstVisitor av) {
        av.visitMethod(this);
    }

    public MethodDeclaration setAccess(Access access) {
        return new MethodDeclaration(cd, access, name, returnType, parameterTypes,
                block.isStatic, block.statements);
    }

    public MethodDeclaration setReturnType(JavaType returnType) {
        return new MethodDeclaration(cd, access, name, returnType, parameterTypes,
                block.isStatic, block.statements);
    }

    public MethodDeclaration setParameterTypes(JavaType... parameterTypes) {
        return new MethodDeclaration(cd, access, name, returnType, parameterTypes,
                block.isStatic, block.statements);
    }

    public MethodDeclaration addStatement(Statement statement) {
        List<Statement> statements = new ArrayList<Statement>(block.statements);
        statements.add(statement);
        return new MethodDeclaration(cd, access, name, returnType, parameterTypes,
                block.isStatic, statements);
    }

}
