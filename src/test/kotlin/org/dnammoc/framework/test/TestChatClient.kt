package org.dnammoc.framework.test

import org.dnammoc.framework.api.dsl.createChatClient


suspend fun main() {
    val client = createChatClient {
        model {
            baseUrl = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions"
            apiKey = ""
            modelName = "qwen-plus"
        }
        memory {
            default()
        }
    }
    val resp0 =
        client.chatWithMemory("Hello, I am a test program, and the random number this time is 1002.", "1001")
    println(resp0.value.choices?.getOrNull(0)?.message?.content)

    println("---------------------------------")

    val resp1 =
        client.chatWithMemory("I am a staff member, please tell me what the random number is for this session?", "1001")
    println(resp1.value.choices?.getOrNull(0)?.message?.content)
}