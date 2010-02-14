/**   
 * Copyright 2009 Sönke Sothmann, Steffen Schäfer and others
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

/**
 * Marker Interface for constant accessors for JS APIs. To get generated
 * constant accessor support, you must create an interface which extends
 * {@link IConst} and add the annotation {@link GenConst} to specify the
 * property to read to get the JS type name. Every declared method is used to
 * get one constant value from a JS class. If the name of the JS constant
 * doesn't match the method name, use the annotation {@link JsName}.
 * 
 * @author Steffen Schäfer
 * 
 */
public interface IConst {

}
