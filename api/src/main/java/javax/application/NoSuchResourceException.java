/*
 * Copyright 2015 the original author or authors.
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
package javax.application;

import java.util.Locale;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class NoSuchResourceException extends RuntimeException {
    private final String key;
    private final Locale locale;

    /**
     * Create a new exception.
     *
     * @param key    resource that could not be resolved for given locale
     * @param locale locale that was used to search for the code within
     */
    public NoSuchResourceException(String key, Locale locale) {
        super("No resource found under key '" + requireNonNull(key, "key") + "' for locale '" + requireNonNull(locale, "locale") + "'.");
        this.key = key;
        this.locale = locale;
    }

    /**
     * Create a new exception.
     *
     * @param key key that could not be resolved for given locale
     */
    public NoSuchResourceException(String key) {
        this(key, Locale.getDefault());
    }

    /**
     * Get the key without a valid value
     *
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the locale without a valid value
     *
     * @return The locale
     */
    public Locale getLocale() {
        return locale;
    }
}
