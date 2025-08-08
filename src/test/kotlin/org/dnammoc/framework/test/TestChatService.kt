package org.dnammoc.framework.test

import kotlinx.coroutines.runBlocking
import org.dnammoc.framework.DnammocFramework
import org.dnammoc.framework.entity.ChatRequest
import org.dnammoc.framework.model.ChatModel
import org.dnammoc.framework.service.ChatService
import org.dnammoc.framework.toolcall.ToolContainer

fun main() {
    DnammocFramework.init(arrayOf("org.dnammoc.framework.test"))
    runBlocking {
        val chatService = ChatService(
            ChatModel(
                baseUrl = "base-url",
                apiKey = "api-key",
                modelName = "qwen-plus"
            )
        )

        val chatRequest = ChatRequest(
            message = "What is the weather like in the four municipalities?"
        ).apply {
            params.stream = false
            params.tools = ToolContainer.getTools("default")
            params.parallelToolCalls = true
        }
        println(chatService.execChat(chatRequest).value)
//        chatService.execChat(chatRequest).stream
//            .map { data ->
//                print("${data.choices?.getOrNull(0)?.delta?.content}")
//            }
//            .collect()
    }

}