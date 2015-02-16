package com.gibson.untappd.rest.adapter;

import java.lang.reflect.Type;

import com.gibson.untappd.rest.domain.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TokenGsonAdapter implements JsonDeserializer<Token>, JsonSerializer<Token> {
	private static final String RESPONSE_ELEMENT = "response";
	private final Gson gson = new GsonBuilder().create();
	
	@Override
	public JsonElement serialize(Token token, Type type, JsonSerializationContext context) {
		return gson.toJsonTree(token, type);
	}

	@Override
	public Token deserialize(JsonElement element, Type type,JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = element.getAsJsonObject();
		jsonObject = replaceResponseArrayWithObject(jsonObject);
		return gson.fromJson(jsonObject, type);
	}

	private JsonObject replaceResponseArrayWithObject(JsonObject jsonObject) {
		JsonElement response = jsonObject.get(RESPONSE_ELEMENT);
		if(response.isJsonArray()) {
			jsonObject.remove(RESPONSE_ELEMENT);
			jsonObject.add(RESPONSE_ELEMENT, new JsonObject());
		}
		return jsonObject;
	}
}
