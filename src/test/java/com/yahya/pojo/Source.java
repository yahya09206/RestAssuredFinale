package com.yahya.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * {
 *  *             "source": {
 *  *                 "id": null,
 *  *                 "name": "Yahoo Entertainment"
 *  *             },
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class Source {

    private String id;
    private String name;
}
