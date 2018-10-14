/*
    Foilen Infra Resource Application
    https://github.com/foilen/foilen-infra-resource-application
    Copyright (c) 2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.application;

import java.util.Arrays;

import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionProvider;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionV1;

public class FoilenApplicationPluginDefinitionProvider implements IPPluginDefinitionProvider {

    @Override
    public IPPluginDefinitionV1 getIPPluginDefinition() {
        IPPluginDefinitionV1 pluginDefinitionV1 = new IPPluginDefinitionV1("Foilen", "Application", "To manage applications", "1.0.0");

        pluginDefinitionV1.addCustomResource(Application.class, Application.RESOURCE_TYPE, //
                Arrays.asList(Application.PROPERTY_NAME), //
                Arrays.asList( //
                        Application.PROPERTY_NAME, //
                        Application.PROPERTY_DOMAIN_NAMES //
                ));

        pluginDefinitionV1.addUpdateHandler(new ApplicationUpdateHandler());

        return pluginDefinitionV1;
    }

    @Override
    public void initialize(CommonServicesContext commonServicesContext) {
    }

}
