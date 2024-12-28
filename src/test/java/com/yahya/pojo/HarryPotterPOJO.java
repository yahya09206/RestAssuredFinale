package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * "id": "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
 *         "name": "Harry Potter",
 *         "species": "human",
 *         "gender": "male",
 *         "house": "Gryffindor",
 *         "dateOfBirth": "31-07-1980",
 *         "yearOfBirth": 1980,
 *         "wizard": true,
 *         "ancestry": "half-blood",
 */
public class HarryPotterPOJO {

    private String id;
    private String name;
    private String species;
    private String gender;
    private String house;
    private Boolean wizard;
    @JsonProperty("alternate_names")
    private List<String> alternateNames;
}
