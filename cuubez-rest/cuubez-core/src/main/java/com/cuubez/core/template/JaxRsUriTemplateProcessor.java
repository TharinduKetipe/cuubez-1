/**
 *	Copyright [2013] [www.cuubez.com]
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.cuubez.core.template;

import com.cuubez.core.resource.metaData.ClassMetaData;
import com.cuubez.core.resource.metaData.MethodMetaData;
import com.cuubez.core.resource.metaData.PathMetaData;

public class JaxRsUriTemplateProcessor extends UriTemplateProcessor {


    @Override
    public UriTemplate compile(ClassMetaData classMetaData) {

        UriTemplateBuilder uriTemplateBuilder = new UriTemplateBuilder();
        PathMetaData pathMetaData = uriTemplateBuilder.build(classMetaData.getPath(), true);

        UriTemplate uriTemplate = new JaxRsUriTemplate();
        uriTemplate.setTemplate(pathMetaData.getTemplate());
        uriTemplate.setPathMetaData(pathMetaData);

        return uriTemplate;
    }

    @Override
    public UriTemplate compile(MethodMetaData methodMetaData) {

        UriTemplateBuilder uriTemplateBuilder = new UriTemplateBuilder();
        PathMetaData pathMetaData = uriTemplateBuilder.build(methodMetaData.getPath(), false);

        UriTemplate uriTemplate = new JaxRsUriTemplate();
        uriTemplate.setTemplate(pathMetaData.getTemplate());
        uriTemplate.setPathMetaData(pathMetaData);

        return uriTemplate;
    }


}
