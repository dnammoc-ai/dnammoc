package org.dnammoc.framework.toolcall

import org.dnammoc.framework.utils.JsonUtil

fun ToolDefinition.toJson() = JsonUtil.toJson(this)

fun String.toToolDefinition() = JsonUtil.fromJson<ToolDefinition>(this)
