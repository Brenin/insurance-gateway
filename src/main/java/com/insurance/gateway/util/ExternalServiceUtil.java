package com.insurance.gateway.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public final class ExternalServiceUtil {

    private ExternalServiceUtil() {}

    private static ResteasyClient restEasyClient;

    private static void createSingleInstanceOfRestEasyClient() {
        // Create and configure client if needed
        restEasyClient = new ResteasyClientBuilderImpl().build();
    }

    // This is added as an external util class so we can setup AOP and log both outgoing and incoming requests
    // We probably will not have prioritize that though
    public static <T> T callExternalResourceAndReturnResponse(@NonNull String requestUrl, Object request, @NonNull Class<T> responseClass) throws IOException {
        if (restEasyClient == null) {
            createSingleInstanceOfRestEasyClient();
        }

        String answer = restEasyClient
                .target(requestUrl).request()
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE)) // We only have post requests
                .readEntity(String.class);                                     // Having issues with serialization. All the fields are null in response

        return new ObjectMapper().reader().readValue(answer, responseClass);
    }
}
