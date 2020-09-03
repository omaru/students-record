package com.joedago.studentsrecord.util;


import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.AllArgsConstructor;
import lombok.Builder;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@Builder
public class WireMockHelper {

    private final WireMockServer wireMockServer;

    public WireMockHelper stubsForPostionFromStudent() {
        wireMockServer.stubFor(get(
                urlPathEqualTo("/forward?access_key=ea4f12d05df8c061aa8dc52612325ab2&query=1600%20Pennsylvania%20Ave%20NW,%20Washington%20DC,%20Washington%20DC%2077057%20USA"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .withBody("{\n" +
                                "    \"data\": [\n" +
                                "        {\n" +
                                "            \"latitude\": 38.897675,\n" +
                                "            \"longitude\": -77.036547,\n" +
                                "            \"type\": \"address\",\n" +
                                "            \"name\": \"1600 Pennsylvania Avenue NW\",\n" +
                                "            \"number\": \"1600\",\n" +
                                "            \"postal_code\": \"20500\",\n" +
                                "            \"street\": \"Pennsylvania Avenue NW\",\n" +
                                "            \"confidence\": 1,\n" +
                                "            \"region\": \"District of Columbia\",\n" +
                                "            \"region_code\": \"DC\",\n" +
                                "            \"county\": null,\n" +
                                "            \"locality\": \"Washington\",\n" +
                                "            \"administrative_area\": null,\n" +
                                "            \"neighbourhood\": \"White House Grounds\",\n" +
                                "            \"country\": \"United States\",\n" +
                                "            \"country_code\": \"USA\",\n" +
                                "            \"continent\": \"North America\",\n" +
                                "            \"label\": \"1600 Pennsylvania Avenue NW, Washington, DC, USA\",\n" +
                                "            \"map_url\": \"https://map.positionstack.com/export/embed.html?bbox=-77.036047,38.898175,-77.037047,38.897175&layer=mapnik&marker=38.897675,-77.036547\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"latitude\": 38.897498,\n" +
                                "            \"longitude\": -77.037538,\n" +
                                "            \"type\": \"address\",\n" +
                                "            \"name\": \"1600 Pennsylvania Avenue Northwest\",\n" +
                                "            \"number\": \"1600\",\n" +
                                "            \"postal_code\": \"20500\",\n" +
                                "            \"street\": \"Pennsylvania Avenue Northwest\",\n" +
                                "            \"confidence\": 1,\n" +
                                "            \"region\": \"District of Columbia\",\n" +
                                "            \"region_code\": \"DC\",\n" +
                                "            \"county\": null,\n" +
                                "            \"locality\": \"Washington\",\n" +
                                "            \"administrative_area\": null,\n" +
                                "            \"neighbourhood\": \"White House Grounds\",\n" +
                                "            \"country\": \"United States\",\n" +
                                "            \"country_code\": \"USA\",\n" +
                                "            \"continent\": \"North America\",\n" +
                                "            \"label\": \"1600 Pennsylvania Avenue Northwest, Washington, DC, USA\",\n" +
                                "            \"map_url\": \"https://map.positionstack.com/export/embed.html?bbox=-77.037038,38.897998,-77.038038,38.896998&layer=mapnik&marker=38.897498,-77.037538\"\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}")));
        return this;
    }
}
