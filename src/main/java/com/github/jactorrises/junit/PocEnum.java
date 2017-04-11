package com.github.jactorrises.junit;

public enum PocEnum {
    BMW(
            "Bayerische Motoren Werke (German: Bavarian Motor Works; German auto manufacturer)",
            "Be My Wife",
            "Bob Marley & the Wailers",
            "Black Magic Woman (Santana song)",
            "Black Magic Woman (festival)",
            "Boy Meets World (Disney TV show)",
            "Bureau of Motor Vehicles"
    ), CIA(
            "Central Intelligence Agency (US government)",
            "Certified Internal Auditor",
            "Cleveland Institute of Art",
            "Culinary Institute of America (Hyde Park, New York)"
    ), DW(
            "Data Warehouse",
            "Deutsche Welle (German Radio and TV Station)",
            "Disney World",
            "Doctor Who (British TV sci-fi series)",
            "Don't Worry",
            "Dreamweaver (web design program)",
            "Deep Water",
            "Dynasty Warriors (game)"
    ), NOT_SUPPORTED;

    private final String[] acronyms;

    PocEnum(String... acronyms) {
        this.acronyms = acronyms;
    }

    public String[] getAcronyms() {
        return acronyms;
    }
}
