/*
 * Copyright 2016-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kafka.support.serializer;

import java.util.Map;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomJsonDeserializer<T> extends JsonDeserializer<T> {

	/**
	 * constructor for custom json serializer.
	 */
	public CustomJsonDeserializer() {
		super();
	}
	public CustomJsonDeserializer(@Nullable JavaType targetType) {
		super(targetType);
	}
	public CustomJsonDeserializer(@Nullable Class<? super T> targetType) {
		super(targetType);
	}
	public CustomJsonDeserializer(@Nullable TypeReference<? super T> targetType) {
		super(targetType);
	}

	@Override
	public ObjectMapper customizeObjectMapper(Map<String, ?> configs, ObjectMapper mapper) {
		mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		return mapper;
	}

}
