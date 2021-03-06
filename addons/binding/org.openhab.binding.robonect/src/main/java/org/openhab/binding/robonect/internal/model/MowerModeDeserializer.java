/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.robonect.internal.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * This is a Gson desirializer capable of translating numeric modes into enum values.
 * 
 * @author Marco Meyer - Initial contribution
 */
public class MowerModeDeserializer implements JsonDeserializer<MowerMode> {

    @Override
    public MowerMode deserialize(JsonElement jsonElement, Type type,
            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        int mode = jsonElement.getAsInt();
        return MowerMode.fromMode(mode);
    }
}
