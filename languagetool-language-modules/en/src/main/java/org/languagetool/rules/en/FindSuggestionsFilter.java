/* LanguageTool, a natural language style checker 
 * Copyright (C) 2021 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.en;

import java.io.IOException;

import org.languagetool.JLanguageTool;
import org.languagetool.rules.AbstractFindSuggestionsFilter;
import org.languagetool.rules.spelling.morfologik.MorfologikSpeller;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.en.EnglishTagger;

public class FindSuggestionsFilter extends AbstractFindSuggestionsFilter {

  private static final String DICT_FILENAME = "/en/english.dict";
  private static MorfologikSpeller speller;
  private static final EnglishTagger tagger = new EnglishTagger();

  public FindSuggestionsFilter() throws IOException {
    // lazy init
    if (speller == null) {
      if (JLanguageTool.getDataBroker().resourceExists(DICT_FILENAME)) {
        speller = new MorfologikSpeller(DICT_FILENAME);
      }
    }
  }

  @Override
  protected Tagger getTagger() {
    return tagger;
  }

  @Override
  protected MorfologikSpeller getSpeller() {
    return speller;
  }

}
