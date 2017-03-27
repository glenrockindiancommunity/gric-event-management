package org.glenrockindiancommunity;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.model.GricEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Family.class);
    config.exposeIdsFor(GricEvent.class);
  }

}
