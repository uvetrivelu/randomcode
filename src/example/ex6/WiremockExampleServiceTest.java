package example.ex6;

package com.ticketmaster.dc.availability.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.util.ReflectionTestUtils;
import java.io.IOException;
import java.net.ServerSocket;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;


import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Test class meant to test ISMService & EventDB output.
 */
public class WiremockExampleServiceTest {
    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(pickaport());

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private ISMService ismService = new ISMService();

    @Before
    public void setup() {
        ReflectionTestUtils.setField(ismService, "ismBaseUrl",
                "http://localhost:" + instanceRule.port());
        ReflectionTestUtils.setField(ismService, "ismClient", ClientBuilder.newClient().register(JacksonJsonProvider.class));
    }


    /**
     * This method brings up a stub endpoint that returns a HTTP 500 with specific Event DB error code
     * which is supposed to throw ApiException with the message "dc.availability.ismds.event.not.loading".
     * Both exception & message are asserted through this test.
     * @throws IOException
     */
    @Test
    public void testISMEventError() throws IOException {

        stubFor(get(urlMatching(
                "/host/3F005042B556897E/facets?.*"))
                    .withHeader("Accept", equalTo("application/json"))
                        .withHeader("X-TM-Identity", equalTo("QFYxmaLs4UaM26DLjQOkA4GvozFdmcKH"))
                .withQueryParam("by", containing("offer"))
                .withQueryParam("q", containing("inv"))
                .withQueryParam("show", containing("places"))
                .withQueryParam("embed", containing("offer"))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")
                        .withStatus(500)
                        .withBody("{\n" +
                                "  \"schema\" : \"urn:com.ticketmaster.services:schema:common:Status:1.0\",\n" +
                                "  \"meta\" : {\n" +
                                "    \"type\" : \"urn:com.ticketmaster.services:type:common:Status\"\n" +
                                "  },\n" +
                                "  \"timestamp\" : \"2016-02-04T23:49:53.817Z\",\n" +
                                "  \"code\" : \"Error.Internal\",\n" +
                                "  \"internalCode\" : \"TicketingService.EventError.0x0b010025\",\n" +
                                "  \"title\" : \"Internal Server Error\",\n" +
                                "  \"message\" : \"The request could not be completed because an error occurred.\",\n" +
                                "  \"reference\" : \"34843122b3d18ac89c02e3e62a82227c\",\n" +
                                "  \"debug\" : {\n" +
                                "    \"description\" : \"0x0B010025 Failed to load event price info from EVENTDB\",\n" +
                                "    \"service\" : \"ticketing\",\n" +
                                "    \"url\" : \"https://ss.shared.intqa102.websys.tmcs:443/ticketing\",\n" +
                                "    \"request\" : \"{\\\"header\\\":{\\\"ver\\\":\\\"1.0\\\",\\\"sid\\\":\\\"SYSTEMCALL\\\",\\\"bid\\\":\\\"ismds\\\",\\\"cip\\\":\\\"10.71.37.18\\\",\\\"mode\\\":0},\\\"command1\\\":{\\\"event_ids\\\":[\\\"3F005042B556897E\\\"],\\\"user\\\":null,\\\"channel\\\":\\\"INTERNET\\\",\\\"market\\\":null,\\\"transaction_style\\\":\\\"PRIMARY_MARKET_CART\\\",\\\"feature_set\\\":\\\"GOLDSTAR\\\",\\\"visibility_purpose\\\":null,\\\"display_id\\\":null,\\\"lang\\\":null,\\\"debug\\\":null,\\\"cmd\\\":\\\"get_reserve_criteria\\\"}}\",\n" +
                                "    \"response\" : \"{\\\"header\\\":{\\\"ver\\\":\\\"1.0\\\",\\\"sid\\\":\\\"SYSTEMCALL\\\",\\\"bid\\\":\\\"ismds\\\",\\\"uid\\\":\\\"VrPjoApJ9noAAA5Y5MsAAAAM\\\",\\\"cip\\\":\\\"10.71.37.18\\\",\\\"token\\\":\\\"0\\\",\\\"mode\\\":10,\\\"result\\\":\\\"0x0\\\",\\\"transaction_id\\\":\\\"TMSSRANDID6405310131126886663652535020584105743352\\\"},\\\"command1\\\":{\\\"success\\\":false,\\\"cmd\\\":\\\"get_reserve_criteria\\\",\\\"result\\\":\\\"0x0\\\",\\\"channel\\\":\\\"INTERNET\\\",\\\"market\\\":\\\"UNITEDSTATES\\\",\\\"transaction_style\\\":\\\"PRIMARY_MARKET_CART\\\",\\\"feature_set\\\":\\\"GOLDSTAR\\\",\\\"events\\\":[],\\\"failures\\\":[{\\\"event_id\\\":\\\"3F005042B556897E\\\",\\\"result\\\":\\\"0x0b010025\\\",\\\"error_message\\\":null,\\\"detail\\\":null,\\\"auth_scheme_id\\\":null,\\\"offering_id\\\":null,\\\"atlas_code\\\":null,\\\"event_code\\\":null,\\\"venue_name\\\":null,\\\"event_name\\\":null}],\\\"lang\\\":\\\"en-us\\\"}}\"\n" +
                                "  },\n" +
                                "  \"_links\" : { },\n" +
                                "  \"_embedded\" : { }\n" +
                                "}")

                ));
        thrown.expect(Exception.class);
        thrown.expectMessage("dc.availability.ismds.event.not.loading");
        ismService.getAvailableTickets("QFYxmaLs4UaM26DLjQOkA4GvozFdmcKH",
                    "3F005042B556897E");



    }
    
    public static final int pickaport() {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException e) {
            Throwables.propagate(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                Throwables.propagate(e);
            }
        }

        int portPicked = -1;
        if (serverSocket != null) {
            portPicked = serverSocket.getLocalPort();
        }

        Preconditions.checkState(portPicked > 0, "Free port could not be picked.");
        return portPicked;
    }
}
