/*
    Foilen Infra Resource Application
    https://github.com/foilen/foilen-infra-resource-application
    Copyright (c) 2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.application;

import java.util.HashSet;
import java.util.Set;

import com.foilen.infra.plugin.v1.model.base.IPApplicationDefinition;
import com.foilen.infra.plugin.v1.model.resource.AbstractIPResource;
import com.foilen.infra.plugin.v1.model.resource.InfraPluginResourceCategory;
import com.foilen.infra.resource.application.model.ExecutionPolicy;
import com.google.common.collect.ComparisonChain;

/**
 * This is for any application/service that is installed on a machine. <br>
 * Links to:
 * <ul>
 * <li>UnixUser: (optional / 1) RUN_AS - The user that executes that application. Will update the "runAs" of the Application itself and the "runAs" of all the services that are "null"</li>
 * <li>Machine: (optional / many) INSTALLED_ON - The machines where to install that application</li>
 * </ul>
 *
 * Manages:
 * <ul>
 * <li>DnsPointer: (optional / many) POINTS_TO - Some domain names that will automatically point to the Machines on which it is INSTALLED_ON</li>
 * </ul>
 */
public class Application extends AbstractIPResource implements Comparable<Application> {

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_APPLICATION_DEFINITION = "applicationDefinition";
    public static final String PROPERTY_DOMAIN_NAMES = "domainNames";

    // Application
    private String name;
    private String description;

    // Execution
    private ExecutionPolicy executionPolicy = ExecutionPolicy.ALWAYS_ON;
    private String executionCronDetails;

    // Details
    private IPApplicationDefinition applicationDefinition = new IPApplicationDefinition();

    // Network
    private Set<String> domainNames = new HashSet<>();

    public Application() {
    }

    @Override
    public int compareTo(Application o) {
        return ComparisonChain.start() //
                .compare(this.name, o.name) //
                .result();
    }

    public IPApplicationDefinition getApplicationDefinition() {
        return applicationDefinition;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getDomainNames() {
        return domainNames;
    }

    public String getExecutionCronDetails() {
        return executionCronDetails;
    }

    public ExecutionPolicy getExecutionPolicy() {
        return executionPolicy;
    }

    public String getName() {
        return name;
    }

    @Override
    public InfraPluginResourceCategory getResourceCategory() {
        return InfraPluginResourceCategory.INFRASTRUCTURE;
    }

    @Override
    public String getResourceDescription() {
        return description;
    }

    @Override
    public String getResourceName() {
        return name;
    }

    public void setApplicationDefinition(IPApplicationDefinition applicationDefinition) {
        this.applicationDefinition = applicationDefinition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomainNames(Set<String> domainNames) {
        this.domainNames = domainNames;
    }

    public void setExecutionCronDetails(String executionCronDetails) {
        this.executionCronDetails = executionCronDetails;
    }

    public void setExecutionPolicy(ExecutionPolicy executionPolicy) {
        this.executionPolicy = executionPolicy;
    }

    public void setName(String name) {
        this.name = name;
    }

}
