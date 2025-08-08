package org.dnammoc.framework

import io.github.oshai.kotlinlogging.KotlinLogging
import org.dnammoc.framework.context.EndowContext
import org.dnammoc.framework.toolcall.ToolCallInitializer

object DnammocFramework {

    private val logger = KotlinLogging.logger {}

    fun init(packageName: Array<String>) {
        packageName.forEach {
            EndowContext.addPackageName(it)
        }
        ToolCallInitializer.init()
        logger.info { "EndowFramework initialized" }
    }

}