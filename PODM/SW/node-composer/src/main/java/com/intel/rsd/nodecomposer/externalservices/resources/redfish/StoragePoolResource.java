/*
 * Copyright (c) 2017-2019 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intel.rsd.nodecomposer.externalservices.resources.redfish;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intel.rsd.nodecomposer.business.services.redfish.odataid.ODataId;
import com.intel.rsd.nodecomposer.externalservices.LinkName;
import com.intel.rsd.nodecomposer.externalservices.OdataTypes;
import com.intel.rsd.nodecomposer.externalservices.WebClientRequestException;
import com.intel.rsd.nodecomposer.externalservices.reader.ResourceSupplier;
import com.intel.rsd.nodecomposer.externalservices.resources.ExternalServiceResourceImpl;
import com.intel.rsd.nodecomposer.types.Status;
import lombok.Getter;

import static com.intel.rsd.redfish.ODataTypeVersions.VERSION_PATTERN;

@OdataTypes({
    "#StoragePool" + VERSION_PATTERN + "StoragePool"
})
public class StoragePoolResource extends ExternalServiceResourceImpl {
    @Getter
    @JsonProperty("Status")
    private Status status;

    @Getter
    @JsonProperty("Capacity")
    private CapacityResource capacity;

    @JsonProperty("AllocatedVolumes")
    private ODataId allocatedVolumes;

    @JsonProperty("AllocatedPools")
    private ODataId allocatedPools;

    @LinkName("allocatedVolumes")
    public Iterable<ResourceSupplier> getAllocatedVolumes() throws WebClientRequestException {
        return processMembersListResource(allocatedVolumes);
    }

    @LinkName("allocatedPools")
    public Iterable<ResourceSupplier> getAllocatedPools() throws WebClientRequestException {
        return processMembersListResource(allocatedPools);
    }
}
