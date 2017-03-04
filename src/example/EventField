public enum EventField {

    START_TIME("startTime"),
    END_TIME("endTime"),
    TIMEZONE("timezone"),
    ADMINS("admins"),
    CATEGORY("category"),
    COVER("cover"),
    DESCRIPTION("description"),
    PLACE_ID("placeId"),
    NAME("name"),
    ROLES("roles"),
    TICKET_URI("ticketUri");

    private final String jsonField;

    private static final Map<String,EventField> VALUE_BY_CODE =
            Arrays.stream(EventField.values())
                    .collect(
                            HashMap::new,
                            (m,c) -> {m.put(c.getJsonField().toLowerCase(), c); m.put(c.name().toLowerCase(), c);},
                            HashMap::putAll
                    );


    private EventField(String jsonField) {
        this.jsonField = jsonField;
    }

    public String getJsonField() {
        return jsonField;
    }

    /**
     * Converts from a String value to the enum, but in a very lenient way:  it is a case-insensitive
     * and it'll match on either the enum name OR the jsonfield value.
     *
     * Returns null if no match is found.
     */
    public static EventField valueOfJsonFieldOrName(String jsonFieldOrName) {
        EventField eventField = VALUE_BY_CODE.get(jsonFieldOrName.toLowerCase());
        return eventField;
    }

}
