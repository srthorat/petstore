package io.swagger.petstore.data;

import org.json.JSONObject;

public class CommonData {

    private static String savedPetId;
    private static String createPetJsonBody;
    public static String getSavedPetId() {
        return savedPetId;
    }

    public static void setSavedPetId(String petId) {
        savedPetId = petId;
    }

    public static String getCreatePetJsonBody() {
        return createPetJsonBody;
    }

    public static void setCreatePetJsonBody(String petJsonBody) {
        createPetJsonBody = petJsonBody;
    }

}
