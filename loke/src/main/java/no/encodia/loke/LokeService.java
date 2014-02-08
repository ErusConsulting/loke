package no.encodia.loke;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class LokeService extends Service<LokeConfiguration> {

    public void initialize(Bootstrap<LokeConfiguration> bootstrap) {
        bootstrap.setName("loke-service");
    }

    public void run(LokeConfiguration configuration, Environment environment) throws Exception {
        // nothing yet
    }
}
