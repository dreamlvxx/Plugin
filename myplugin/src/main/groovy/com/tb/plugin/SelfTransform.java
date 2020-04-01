package com.tb.plugin;

import com.android.build.gradle.internal.pipeline.TransformManager;

import com.android.build.api.transform.*;
import com.google.common.collect.ImmutableSet;
import org.gradle.api.Project;
import java.io.IOException;
import java.util.Set;

public class SelfTransform extends Transform {
    Project project;

    public SelfTransform(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return "DreamXXXName";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        // 输入类型，可以使class文件，也可以是源码文件 ，这是表示输入的class文件
        return ImmutableSet.of(QualifiedContent.DefaultContentType.CLASSES);
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return false;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);
        if (transformInvocation.isIncremental()) {
            System.out.println("==============NoIncrement========");
        }else {
            System.out.println("====================Increment=================");
        }
    }
}
