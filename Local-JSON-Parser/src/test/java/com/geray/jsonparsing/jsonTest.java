package com.geray.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.geray.jsonparsing.pojo.SimpleTestCaseJsonPOJO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class jsonTest {

    private String simpleTestCaseJsonSource = "{ \"title\": \"MySource\"}";


    @Test
    void parse() throws JsonProcessingException {

        JsonNode node = json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "MySource");
    }
    @Test
    void fromJson() throws JsonProcessingException {

        JsonNode node = json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(),"MySource");
    }

}