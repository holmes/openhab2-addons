/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.solaredge.internal.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.smarthome.core.types.State;

/**
 * this class is used to map the yearly aggregate data json response
 *
 * @author Alexander Friese - initial contribution
 */
public class AggregateYearDataResponsePrivateApi extends AbstractAggregateDataResponsePrivateApi {

    @Override
    public Map<Channel, State> getValues() {
        Map<Channel, State> valueMap = new HashMap<>();

        if (getUtilizationMeasures() != null) {
            if (getUtilizationMeasures().production != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_PRODUCTION, getUtilizationMeasures().production);
            }

            if (getUtilizationMeasures().consumption != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_CONSUMPTION, getUtilizationMeasures().consumption);
            }

            if (getUtilizationMeasures().selfConsumptionForConsumption != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_SELFCONSUMPTIONFORCONSUMPTION,
                        getUtilizationMeasures().selfConsumptionForConsumption);
                assignPercentage(valueMap, AggregateDataChannels.YEAR_SELFCONSUMPTIONCOVERAGE,
                        getUtilizationMeasures().selfConsumptionForConsumption);
            }

            if (getUtilizationMeasures().batterySelfConsumption != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_BATTERYSELFCONSUMPTION,
                        getUtilizationMeasures().batterySelfConsumption);
            }

            if (getUtilizationMeasures().imported != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_IMPORT, getUtilizationMeasures().imported);
            }

            if (getUtilizationMeasures().export != null) {
                assignValue(valueMap, AggregateDataChannels.YEAR_EXPORT, getUtilizationMeasures().export);
            }
        }

        return valueMap;
    }

}
