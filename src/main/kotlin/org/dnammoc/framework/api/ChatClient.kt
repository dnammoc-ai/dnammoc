package org.dnammoc.framework.api

import kotlinx.coroutines.runBlocking
import org.dnammoc.framework.entity.ChatMessage
import org.dnammoc.framework.entity.ChatRequest
import org.dnammoc.framework.entity.ModelResponse
import org.dnammoc.framework.memory.IMemoryStorage
import org.dnammoc.framework.model.ChatModel
import org.dnammoc.framework.service.ChatService

class ChatClient(
    private val model: org.dnammoc.framework.model.ChatModel,
    private val memory: org.dnammoc.framework.memory.IMemoryStorage,
) {
    private val chatService = _root_ide_package_.org.dnammoc.framework.service.ChatService(model, memory)

    fun generate(message: String): String {
        return runBlocking {
            chatService.execChat(
                ChatRequest(message = message)
            ).value.choices?.getOrNull(0)?.message?.content ?: String()
        }
    }

    suspend fun chat(chatRequest: ChatRequest): ModelResponse<ChatMessage> {
        return chatService.execChat(chatRequest)
    }

    suspend fun chatWithMemory(message: String, memoryId: String): ModelResponse<ChatMessage> {
        return chatService.execChat(ChatRequest(message = message), memoryId)
    }

    suspend fun chatWithMemory(chatRequest: ChatRequest, memoryId: String): ModelResponse<ChatMessage> {
        return chatService.execChat(chatRequest, memoryId)
    }

}
