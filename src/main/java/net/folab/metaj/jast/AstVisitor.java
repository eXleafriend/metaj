package net.folab.metaj.jast;

public interface AstVisitor {

    public void visitClass(ClassDeclaration cd);

    public void visitField(FieldDeclaration md);

    public void visitMethod(MethodDeclaration md);

    public byte[] toByteArray();

}
