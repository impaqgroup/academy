package com.impaqgroup.academy.cloud;

import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by impaq on 18.03.15.
 */
@Configuration
@Profile("cloud")
@ServiceScan
public class CloudConfiguration {
}
