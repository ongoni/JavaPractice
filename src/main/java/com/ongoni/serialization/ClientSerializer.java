package com.ongoni.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ongoni.entities.Client;

import java.lang.reflect.Type;

public class ClientSerializer implements JsonSerializer<Client> {

    public JsonElement serialize(Client client, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.addProperty("id", client.getId());
        result.addProperty("name", client.getName());
        result.addProperty("pass", client.getPassword());
        result.addProperty("bank_account", client.getBankAccountNumber());
        result.addProperty("balance", client.getBankAccountBalance());

        return result;
    }

}
