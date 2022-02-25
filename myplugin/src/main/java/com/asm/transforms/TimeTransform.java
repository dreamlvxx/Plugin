package com.asm.transforms;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class TimeTransform extends AdviceAdapter {
    /**
     * Creates a new {@link AdviceAdapter}.
     *
     * @param api    the ASM API version implemented by this visitor. Must be one
     *               of {@link Opcodes#ASM4} or {@link Opcodes#ASM5}.
     * @param mv     the method visitor to which this adapter delegates calls.
     * @param access the method's access flags (see {@link Opcodes}).
     * @param name   the method's name.
     * @param desc   the method's descriptor (see {@link Type Type}).
     */
    protected TimeTransform(int api, MethodVisitor mv, int access, String name, String desc) {
        super(api, mv, access, name, desc);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
    }
}
