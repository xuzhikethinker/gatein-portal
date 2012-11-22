/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.portal.resource.compressor.impl;

import java.io.Reader;
import java.io.Writer;

import org.exoplatform.container.xml.InitParams;
import org.exoplatform.portal.resource.compressor.BaseResourceCompressorPlugin;
import org.exoplatform.portal.resource.compressor.ResourceCompressorException;
import org.exoplatform.portal.resource.compressor.ResourceType;
import org.exoplatform.web.application.javascript.JSMin;

/**
 * @author <a href="mailto:hoang281283@gmail.com">Minh Hoang TO</a> Aug 19, 2010
 */

public class JSMinCompressorPlugin extends BaseResourceCompressorPlugin {

    public JSMinCompressorPlugin(InitParams params) throws Exception {
        super(params);
    }

    public ResourceType getResourceType() {
        return ResourceType.JAVASCRIPT;
    }

    public void compress(Reader input, Writer output) throws ResourceCompressorException {
        try {
            new JSMin(input, output).jsmin();
        } catch (Exception ex) {
            throw new ResourceCompressorException(ex);
        }
    }
}
