package no.encodia.loke;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import no.encodia.loke.invoice.InvoiceResource;

public class LokeService extends Service<LokeConfiguration> {

    public static void main(String[] args) throws Exception {
        new LokeService().run(args);
    }

    public void initialize(Bootstrap<LokeConfiguration> bootstrap) {
        bootstrap.setName("loke-service");
    }

    public void run(LokeConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new InvoiceResource());
    }
}
