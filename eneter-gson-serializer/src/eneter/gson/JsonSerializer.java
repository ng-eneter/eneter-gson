/**
 * Copyright 2014 Ondrej Uzovic
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

package eneter.gson;

import com.google.gson.Gson;

import eneter.messaging.dataprocessing.serializing.ISerializer;

/**
 * JSON serializer for Eneter Messaging Framework based on Gson library from Google.
 * 
 * This serializer is intended to be used with Eneter Messaging Framework to serialize / deserialize messages.
 * To use this serializer you need reference eneter-messaging.jar or eneter-messaging-android.jar
 *
 */
public class JsonSerializer implements ISerializer
{
    /**
     * Serialize to JSON.
     */
    @Override
    public <T> T deserialize(Object serializedData, Class<T> clazz)
            throws Exception
    {
        // Check input parameters.
        if (serializedData == null)
        {
            throw new IllegalArgumentException("Input parameter serializedData is null.");
        }
        if (serializedData instanceof String == false)
        {
            throw new IllegalArgumentException("Input parameter serializedData is not String.");
        }
        
        // Serialize using GSON.
        T aDeserializedObject = myGson.fromJson((String)serializedData, clazz);
        return aDeserializedObject;
    }

    /**
     * Deserialize from JSON.
     */
    @Override
    public <T> Object serialize(T dataToSerialize, Class<T> clazz)
            throws Exception
    {
        // Deserialize using GSON.
        String aSerializedObject = myGson.toJson(dataToSerialize);
        return aSerializedObject;
    }

    private Gson myGson = new Gson();
}
