package com.shopwave.ai.services;

import com.shopwave.exception.ProductException;
import com.shopwave.response.ApiResponse;

public interface AiChatBotService {

    ApiResponse aiChatBot(String prompt,Long productId,Long userId) throws ProductException;
}
