package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobsV2 {

    @JsonProperty("job_id")
    private String jobId;
    @JsonProperty("job_title")
    private String jobTitle;
    @JsonProperty("min_salary")
    private int minSalary;
    @JsonProperty("max_salary")
    private int maxSalary;
}
