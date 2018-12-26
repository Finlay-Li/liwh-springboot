package com.dodou.liwh.propertiesconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: AuthorSettings
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-16 6:13 PM
 */
@ConfigurationProperties(prefix = "author")
@Data
public class AuthorSettings {
    private String name;
    private Integer money;
    private Assets[] assets;
}
