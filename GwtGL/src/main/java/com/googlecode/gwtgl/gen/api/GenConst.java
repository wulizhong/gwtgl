/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.gen.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * This annotation is used for generated constant access. The value defines the
 * gwt property to read to get the name of the JS type to use for constant
 * access.
 * 
 * @author Steffen Schäfer
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { java.lang.annotation.ElementType.TYPE })
public @interface GenConst {
	/**
	 * Defines the gwt property to read to get the name of the JS type to use
	 * for constant access.
	 * 
	 * @return the name gwt property to read
	 */
	String value();
}
