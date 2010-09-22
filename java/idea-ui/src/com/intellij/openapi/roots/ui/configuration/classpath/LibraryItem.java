/*
 * Copyright 2000-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.openapi.roots.ui.configuration.classpath;

import com.intellij.openapi.roots.LibraryOrderEntry;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.ui.configuration.libraries.LibraryPresentationManager;
import com.intellij.openapi.roots.ui.configuration.projectRoot.StructureConfigurableContext;
import com.intellij.openapi.util.text.StringUtil;

import java.util.List;

/**
* @author nik
*/
class LibraryItem extends ClasspathTableItem<LibraryOrderEntry> {
  private final StructureConfigurableContext myContext;

  public LibraryItem(LibraryOrderEntry orderEntry, StructureConfigurableContext context) {
    super(orderEntry, true);
    myContext = context;
  }

  public boolean isEditable() {
    return myEntry != null && myEntry.isValid();
  }

  @Override
  public String getTooltipText() {
    if (myEntry == null) return null;

    final Library library = myEntry.getLibrary();
    if (library == null) return null;

    final List<String> descriptions = LibraryPresentationManager.getInstance().getDescriptions(library, myContext);
    return "<html>" + StringUtil.join(descriptions, "<br>") + "</html>";
  }
}
