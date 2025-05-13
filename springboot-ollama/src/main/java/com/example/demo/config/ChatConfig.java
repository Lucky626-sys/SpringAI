//它是在建立並管理一個 ChatClient 的物件，讓你在其他程式中可以直接使用這個物件（例如用來跟 AI 對話），而不用自己去 new 一個出來。
//「我要幫大家建立一個 ChatClient，然後交給 Spring 管理。別人想用，就可以自動拿來用，不需要自己 new。」
package com.example.demo.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {
	//Bean這個註解很重要「這個方法會回傳一個物件（這裡是 ChatClient），Spring 要幫我管理這個物件，別人想用就直接拿來用，不用自己 new。」
	@Bean	//此物件是被Spring管理，其他程式可以透過@Autowired自動綁定來取得該物件(不需要new)
	//參數：它接受一個 ChatClient.Builder 的物件（Builder 是一種幫助你蓋出完整物件的工具），這個物件會由 Spring 幫你自動傳進來。
	public ChatClient chatClient(ChatClient.Builder builder) {
		//動作：用 .build() 把這個 builder 蓋成一個真正的 ChatClient 物件，然後回傳
		return builder.build();
	}
}
