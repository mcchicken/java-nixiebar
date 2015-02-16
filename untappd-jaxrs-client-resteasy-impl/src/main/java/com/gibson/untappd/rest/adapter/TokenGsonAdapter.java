package com.gibson.untappd.rest.adapter;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	Gson gson = new GsonBuilder().create();
	
	@Override
	public JsonElement serialize(Token token, Type type, JsonSerializationContext context) {
		return gson.toJsonTree(token, type);
	}

	@Override
	public Token deserialize(JsonElement element, Type type,JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = element.getAsJsonObject();
		Set<Map.Entry<String, JsonElement>> entries = object.entrySet();
		Iterator<Entry<String, JsonElement>> iterator = entries.iterator();
		JsonElement tokenElement = iterator.next().getValue();
		return gson.fromJson(tokenElement, type);
	}
}
