package com.ongoni.serialization;

import com.google.gson.*;
import com.ongoni.entities.Client;

import java.lang.reflect.Type;

public class ClientDeserializer implements JsonDeserializer<Client> {

    public Client deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return new Client()
                .setId(jsonObject.get("id").getAsInt())
                .setName(jsonObject.get("name").getAsString())
                .setPassword(jsonObject.get("pass").getAsString())
                .setBankAccountNumber(jsonObject.get("bank_account").getAsInt())
                .setBankAccountBalance(jsonObject.get("balance").getAsDouble());
    }

}
