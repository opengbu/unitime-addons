/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
*/

package org.unitime.banner.queueprocessor.util;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * based on code contributed by Aaron Tyler
 */
public class ClobTools {

	public static Clob documentToCLOB(Document document, Connection conn) throws IOException, SQLException {
		Clob clob = conn.createClob();
		XMLWriter writer = new XMLWriter(clob.setCharacterStream(1l), OutputFormat.createCompactFormat());
		writer.write(document);
		writer.flush(); writer.close();
		return clob;
	}
	
	public static Document clobToDocument(Clob clob) throws DocumentException, SQLException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(clob.getCharacterStream());
		return document;
	}
}
