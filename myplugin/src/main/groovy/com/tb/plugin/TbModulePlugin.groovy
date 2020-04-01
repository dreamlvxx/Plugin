package com.tb.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppExtension


class TbModulePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println("this is a groovy plugin...")
        AppExtension android = project.extensions.getByType(AppExtension)
        android.registerTransform(new SelfTransform(project))
    }
}