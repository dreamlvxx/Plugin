package com.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class LifecycleOnCreateMethodVisitor extends MethodVisitor {

    public LifecycleOnCreateMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM7, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    /**
     * 开始访问方法代码，此处可以添加方法运行前拦截器;
     */
    @Override
    public void visitCode() {
        super.visitCode();
        //方法执行前插入
        mv.visitTypeInsn(Opcodes.NEW, "com/example/plugin_sad/InvokeClassA");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/example/plugin_sad/InvokeClassA", "<init>", "()V", false);
        mv.visitVarInsn(Opcodes.ASTORE, 1);

        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitIntInsn(Opcodes.SIPUSH, 999);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/example/plugin_sad/InvokeClassA", "mmm", "(I)V", false);

    }

    @Override
    public void visitInsn(int opcode) {
        //方法执行后插入
        /*if (opcode == Opcodes.RETURN) {
            mv.visitLdcInsn("TAG");
            mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
            mv.visitInsn(Opcodes.DUP);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitLdcInsn("-------> onCreate : end ：");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Class", "getSimpleName", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false);
            mv.visitInsn(Opcodes.POP);
        }*/
        super.visitInsn(opcode);
    }
}
