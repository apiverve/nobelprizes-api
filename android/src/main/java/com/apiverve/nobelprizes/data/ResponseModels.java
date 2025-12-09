// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     NobelPrizesData data = Converter.fromJsonString(jsonString);

package com.apiverve.nobelprizes.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static NobelPrizesData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(NobelPrizesData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(NobelPrizesData.class);
        writer = mapper.writerFor(NobelPrizesData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// NobelPrizesData.java

package com.apiverve.nobelprizes.data;

import com.fasterxml.jackson.annotation.*;

public class NobelPrizesData {
    private long count;
    private String[] filteredOn;
    private NobelPrize[] nobelPrizes;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("filteredOn")
    public String[] getFilteredOn() { return filteredOn; }
    @JsonProperty("filteredOn")
    public void setFilteredOn(String[] value) { this.filteredOn = value; }

    @JsonProperty("nobelPrizes")
    public NobelPrize[] getNobelPrizes() { return nobelPrizes; }
    @JsonProperty("nobelPrizes")
    public void setNobelPrizes(NobelPrize[] value) { this.nobelPrizes = value; }
}

// NobelPrize.java

package com.apiverve.nobelprizes.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class NobelPrize {
    private String firstName;
    private String lastName;
    private LocalDate born;
    private LocalDate died;
    private String countryborn;
    private String countrybornCode;
    private String bornCity;
    private String diedCountry;
    private String diedCountryCode;
    private String diedCity;
    private String gender;
    private String year;
    private String category;
    private String motivation;
    private String organization;
    private String organizationCity;
    private String organizationCountry;

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    @JsonProperty("firstName")
    public void setFirstName(String value) { this.firstName = value; }

    @JsonProperty("lastName")
    public String getLastName() { return lastName; }
    @JsonProperty("lastName")
    public void setLastName(String value) { this.lastName = value; }

    @JsonProperty("born")
    public LocalDate getBorn() { return born; }
    @JsonProperty("born")
    public void setBorn(LocalDate value) { this.born = value; }

    @JsonProperty("died")
    public LocalDate getDied() { return died; }
    @JsonProperty("died")
    public void setDied(LocalDate value) { this.died = value; }

    @JsonProperty("countryborn")
    public String getCountryborn() { return countryborn; }
    @JsonProperty("countryborn")
    public void setCountryborn(String value) { this.countryborn = value; }

    @JsonProperty("countrybornCode")
    public String getCountrybornCode() { return countrybornCode; }
    @JsonProperty("countrybornCode")
    public void setCountrybornCode(String value) { this.countrybornCode = value; }

    @JsonProperty("born city")
    public String getBornCity() { return bornCity; }
    @JsonProperty("born city")
    public void setBornCity(String value) { this.bornCity = value; }

    @JsonProperty("diedCountry")
    public String getDiedCountry() { return diedCountry; }
    @JsonProperty("diedCountry")
    public void setDiedCountry(String value) { this.diedCountry = value; }

    @JsonProperty("diedCountryCode")
    public String getDiedCountryCode() { return diedCountryCode; }
    @JsonProperty("diedCountryCode")
    public void setDiedCountryCode(String value) { this.diedCountryCode = value; }

    @JsonProperty("diedCity")
    public String getDiedCity() { return diedCity; }
    @JsonProperty("diedCity")
    public void setDiedCity(String value) { this.diedCity = value; }

    @JsonProperty("gender")
    public String getGender() { return gender; }
    @JsonProperty("gender")
    public void setGender(String value) { this.gender = value; }

    @JsonProperty("year")
    public String getYear() { return year; }
    @JsonProperty("year")
    public void setYear(String value) { this.year = value; }

    @JsonProperty("category")
    public String getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(String value) { this.category = value; }

    @JsonProperty("motivation")
    public String getMotivation() { return motivation; }
    @JsonProperty("motivation")
    public void setMotivation(String value) { this.motivation = value; }

    @JsonProperty("organization")
    public String getOrganization() { return organization; }
    @JsonProperty("organization")
    public void setOrganization(String value) { this.organization = value; }

    @JsonProperty("organizationCity")
    public String getOrganizationCity() { return organizationCity; }
    @JsonProperty("organizationCity")
    public void setOrganizationCity(String value) { this.organizationCity = value; }

    @JsonProperty("organizationCountry")
    public String getOrganizationCountry() { return organizationCountry; }
    @JsonProperty("organizationCountry")
    public void setOrganizationCountry(String value) { this.organizationCountry = value; }
}