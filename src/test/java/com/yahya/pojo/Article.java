package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * "articles": [
 *         {
 *             "source": {
 *                 "id": null,
 *                 "name": "Yahoo Entertainment"
 *             },
 *             "author": "The Associated Press",
 *             "title": "Winning ticket for $1.22 billion lottery jackpot sold in California, Mega Millions says - Yahoo! Voices",
 *             }
 *             ]
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private Map<String, Object> source;
    private String author;
    private String title;
}
